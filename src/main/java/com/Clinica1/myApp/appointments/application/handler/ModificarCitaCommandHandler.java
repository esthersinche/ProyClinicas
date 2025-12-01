package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.ModificarCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.exception.DoctorNoDisponibleException;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ModificarCitaCommandHandler {

    private final CitaRepository citaRepository;
    private final DoctorRepository doctorRepository;
    private final CitaAssembler citaAssembler;

    public ModificarCitaCommandHandler(CitaRepository citaRepository,
                                       DoctorRepository doctorRepository,
                                       CitaAssembler citaAssembler) {
        this.citaRepository = citaRepository;
        this.doctorRepository = doctorRepository;
        this.citaAssembler = citaAssembler;
    }

    public CitaDto handle(ModificarCitaCommand command)
            throws FechaInvalidaException, CitaNoEncontradaException, DoctorNoDisponibleException {

        IDEntidad citaId = command.getCitaId();

        Cita cita = citaRepository.findById(citaId);

        if (cita == null) {
            throw new CitaNoEncontradaException("No existe la cita con ID: " + command.getCitaId());
        }

        validarFechas(command.getInicio(), command.getFin());

        // Obtener doctor asignado actual
        Doctor doctorAsignado = doctorRepository.findById(cita.getDoc_id());

        // Verificar disponibilidad del doctor actual
        verificarDisponibilidadDoctor(
                doctorAsignado,
                command.getInicio(),
                command.getFin(),
                citaId
        );

        // Aplicar cambios (solo fecha y hora)
        cita.modificar(
                cita.getMotivo_cita(),   // NO cambia motivo
                command.getInicio(),
                command.getFin()
        );

        Cita citaActualizada = citaRepository.update(cita);

        return citaAssembler.toDto(citaActualizada);
    }
    
    private void validarFechas(LocalDateTime inicio, LocalDateTime fin) throws FechaInvalidaException {
        if (inicio == null || fin == null) {
            throw new FechaInvalidaException("Las fechas de inicio y fin no pueden ser nulas");
        }
        
        if (inicio.isBefore(LocalDateTime.now())) {
            throw new FechaInvalidaException("La fecha de inicio no puede ser en el pasado");
        }
        
        if (fin.isBefore(inicio)) {
            throw new FechaInvalidaException("La fecha de fin debe ser posterior a la fecha de inicio");
        }
    }

    private void verificarDisponibilidadDoctor(
            Doctor doctor,
            LocalDateTime inicio,
            LocalDateTime fin,
            IDEntidad citaIdActual
    ) throws DoctorNoDisponibleException {

        List<Cita> citasDelDoctor = citaRepository.findByDoctorId(doctor.getId_doc());

        for (Cita c : citasDelDoctor) {

            // 1. Ignorar cita actual
            if (c.getId_cita().equals(citaIdActual))
                continue;

            // 2. Ignorar canceladas
            if (c.getEstado_cita() == Estado.Desercion)
                continue;

            LocalDateTime inicioExistente = c.getInicio_cita();
            LocalDateTime finExistente = c.getFin_cita();

            boolean seSolapan =
                    inicio.isBefore(finExistente) &&
                            fin.isAfter(inicioExistente);

            if (seSolapan) {
                throw new DoctorNoDisponibleException(
                        "El doctor NO está disponible entre "
                                + inicio + " y " + fin
                                + ". Tiene otra cita entre "
                                + inicioExistente + " y " + finExistente
                );
            }
        }
    }
}