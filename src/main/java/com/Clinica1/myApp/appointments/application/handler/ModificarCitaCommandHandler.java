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
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;

import java.time.LocalDateTime;

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

        // Cambio de doctor
        if (command.getDoctorId() != null) {

            IDEntidad doctorId = command.getDoctorId();
            Doctor doctor = doctorRepository.findById(doctorId);

            if (doctor == null) {
                throw new DoctorNoDisponibleException("El doctor no existe: " + command.getDoctorId());
            }

            verificarDisponibilidadDoctor(doctor, command.getInicio(), command.getFin());
            cita.setInst_doctor(doctor);
        }

        cita.modificar(
                command.getMotivo(),
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
    
    private void verificarDisponibilidadDoctor(Doctor doctor, LocalDateTime inicio, LocalDateTime fin) 
            throws DoctorNoDisponibleException {
        throw new UnsupportedOperationException("Verificación de disponibilidad pendiente");
    }
}
