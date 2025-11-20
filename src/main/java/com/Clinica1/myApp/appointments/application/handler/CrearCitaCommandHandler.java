package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.command.CrearCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;
import com.Clinica1.myApp.appointments.application.exception.DoctorNoDisponibleException;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Clinica;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Canal;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;

import java.time.LocalDateTime;
import java.util.UUID;

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

    public CitaDto handle(CrearCitaCommand command) throws FechaInvalidaException, DoctorNoDisponibleException, CitaNoEncontradaException {
        validarFechas(command.getInicio(), command.getFin());
        
        Paciente paciente = pacienteRepository.findbyId(UUID.fromString(command.getPacienteId().toString()));
        if (paciente == null) {
            throw new CitaNoEncontradaException("Paciente no encontrado con ID: " + command.getPacienteId());
        }
        
        Doctor doctor = doctorRepository.findbyId(UUID.fromString(command.getDoctorId().toString()));
        if (doctor == null) {
            throw new CitaNoEncontradaException("Doctor no encontrado con ID: " + command.getDoctorId());
        }
        
        verificarDisponibilidadDoctor(doctor, command.getInicio(), command.getFin());
        
        Clinica clinica = new Clinica();
        
        Cita cita = Cita.crearcita(
            command.getMotivo(),
            Canal.valueOf(command.getCanal()),
            command.getInicio(),
            command.getFin(),
            paciente,
            doctor,
            Especialidad.of(command.getEspecialidad()),
            clinica,
            null
        );
        
        Cita citaGuardada = citaRepository.insert(cita);
        
        return citaAssembler.toDto(citaGuardada);
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
