package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CrearCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;
import com.Clinica1.myApp.appointments.application.exception.DoctorNoDisponibleException;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Canal;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;

import java.time.LocalDateTime;
import java.util.List;


public class CrearCitaCommandHandler {
    
    private final CitaRepository citaRepository;
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;
    private final CitaAssembler citaAssembler;

    public CrearCitaCommandHandler(CitaRepository citaRepository, DoctorRepository doctorRepository,
                                  PacienteRepository pacienteRepository, CitaAssembler citaAssembler) {
        this.citaRepository = citaRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
        this.citaAssembler = citaAssembler;
    }

    public CitaDto handle(CrearCitaCommand command)
            throws FechaInvalidaException, DoctorNoDisponibleException, CitaNoEncontradaException {

        validarFechas(command.getInicio(), command.getFin());
    // 1. Buscar paciente
        Paciente paciente = pacienteRepository.findById(command.getPacienteId());
        if (paciente == null)
            throw new CitaNoEncontradaException("Paciente no encontrado: " + command.getPacienteId());

        // 2. Buscar doctor
        Doctor doctor = doctorRepository.findById(command.getDoctorId());
        if (doctor == null)
            throw new CitaNoEncontradaException("Doctor no encontrado: " + command.getDoctorId());

        // 3. Verificar disponibilidad del doctor
        verificarDisponibilidadDoctor(doctor, command.getInicio(), command.getFin());


        // 4. Crear cita usando el FACTORY
        Canal canal;
        try {
            canal = Canal.valueOf(command.getCanal());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Canal inválido: " + command.getCanal());
        }


        Cita cita = Cita.crearcita(
                command.getMotivo(),
                canal,
                command.getInicio(),
                command.getFin(),
                paciente,
                doctor,
                Especialidad.of(command.getEspecialidad())
        );

        // 5. Persistir cita
        Cita citaGuardada = citaRepository.insert(cita);

        // 6. Convertir a DTO
        return citaAssembler.toDto(citaGuardada);
    }

    private void validarFechas(LocalDateTime inicio, LocalDateTime fin) throws FechaInvalidaException {

        if (inicio == null || fin == null)
            throw new FechaInvalidaException("Las fechas de inicio y fin no pueden ser nulas");

        if (inicio.isBefore(LocalDateTime.now()))
            throw new FechaInvalidaException("La hora de inicio no puede ser en el pasado");

        if (fin.isBefore(inicio))
            throw new FechaInvalidaException("La fecha de fin debe ser posterior al inicio");
    }

    private void verificarDisponibilidadDoctor(Doctor doctor, LocalDateTime inicio, LocalDateTime fin)
            throws DoctorNoDisponibleException {

        // 1. Obtener todas las citas del doctor
        List<Cita> citasDelDoctor = citaRepository.findByDoctorId(doctor.getId_doc());

        // 2. Recorrer y buscar solapamiento
        for (Cita c : citasDelDoctor) {
            //Si la cita está cancelada, NO debe bloquear horarios
             if (c.getEstado_cita() == Estado.Desercion)
            continue;
            LocalDateTime inicioExistente = c.getInicio_cita();
            LocalDateTime finExistente = c.getFin_cita();

            boolean seSolapan =
                    inicio.isBefore(finExistente) &&   // inicia antes de que termine la otra
                            fin.isAfter(inicioExistente);      // termina después de que empieza la otra

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