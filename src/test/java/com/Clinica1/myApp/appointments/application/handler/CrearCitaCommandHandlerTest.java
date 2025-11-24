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
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CrearCitaCommandHandlerTest {

    private CitaRepository citaRepository;
    private DoctorRepository doctorRepository;
    private PacienteRepository pacienteRepository;
    private CitaAssembler citaAssembler;
    private CrearCitaCommandHandler handler;

    @BeforeEach
    void setUp() {
        citaRepository = mock(CitaRepository.class);
        doctorRepository = mock(DoctorRepository.class);
        pacienteRepository = mock(PacienteRepository.class);
        citaAssembler = mock(CitaAssembler.class);
        handler = new CrearCitaCommandHandler(citaRepository, doctorRepository, pacienteRepository, citaAssembler);
    }

    @Test
    void deberiaCrearCitaCorrectamente() throws FechaInvalidaException, DoctorNoDisponibleException, CitaNoEncontradaException {
        IDEntidad pacienteId = IDEntidad.generar();
        IDEntidad doctorId = IDEntidad.generar();

        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fin = inicio.plusHours(1);

        CrearCitaCommand command = new CrearCitaCommand(
                "Consulta general",
                "Virtual",
                inicio,
                fin,
                pacienteId,
                doctorId,
                IDEntidad.generar(),
                "Cardiología"
        );

        Paciente paciente = mock(Paciente.class);
        Doctor doctor = mock(Doctor.class);
        Cita citaGuardada = mock(Cita.class);
        CitaDto dtoEsperado = mock(CitaDto.class);

        when(pacienteRepository.findById(pacienteId)).thenReturn(paciente);
        when(doctorRepository.findById(doctorId)).thenReturn(doctor);
        when(citaRepository.insert(any(Cita.class))).thenReturn(citaGuardada);
        when(citaAssembler.toDto(citaGuardada)).thenReturn(dtoEsperado);


        CitaDto resultado = handler.handle(command);

        assertNotNull(resultado);
        assertEquals(dtoEsperado, resultado);

        verify(citaRepository, times(1)).insert(any(Cita.class));
        verify(citaAssembler, times(1)).toDto(citaGuardada);
    }

    @Test
    void deberiaLanzarExcepcionSiPacienteNoExiste() {
        IDEntidad pacienteId = IDEntidad.generar();
        IDEntidad doctorId = IDEntidad.generar();

        CrearCitaCommand command = new CrearCitaCommand(
                "Consulta",
                "Virtual",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1),
                pacienteId,
                doctorId,
                IDEntidad.generar(),
                "Cardiología"
        );

        when(pacienteRepository.findById(pacienteId)).thenReturn(null);

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionSiDoctorNoExiste() {
        IDEntidad pacienteId = IDEntidad.generar();
        IDEntidad doctorId = IDEntidad.generar();

        CrearCitaCommand command = new CrearCitaCommand(
                "Consulta",
                "Virtual",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1),
                pacienteId,
                doctorId,
                IDEntidad.generar(),
                "Cardiología"
        );

        when(pacienteRepository.findById(pacienteId)).thenReturn(mock(Paciente.class));
        when(doctorRepository.findById(doctorId)).thenReturn(null);

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionSiFechasInvalidas() {
        IDEntidad pacienteId = IDEntidad.generar();
        IDEntidad doctorId = IDEntidad.generar();

        CrearCitaCommand command = new CrearCitaCommand(
                "Consulta",
                "Virtual",
                LocalDateTime.now().minusDays(1), // inicio en pasado
                LocalDateTime.now().plusDays(1),
                pacienteId,
                doctorId,
                IDEntidad.generar(),
                "Cardiología"
        );

        assertThrows(FechaInvalidaException.class, () -> handler.handle(command));
    }
    //TODO: testteo de esa cosa causas
    @Test
    void deberiaLanzarExcepcionSiDoctorNoDisponible() throws Exception {
        }
}
