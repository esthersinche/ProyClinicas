package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.command.CrearCitaCommand;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CrearCitaCommandHandlerTest {

    @Mock
    private CitaRepository citaRepository;
    
    @Mock
    private DoctorRepository doctorRepository;
    
    @Mock
    private PacienteRepository pacienteRepository;
    
    @Mock
    private CitaAssembler citaAssembler;
    
    private CrearCitaCommandHandler handler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        handler = new CrearCitaCommandHandler(citaRepository, doctorRepository, pacienteRepository, citaAssembler);
    }

    @Test
    void deberiaLanzarExcepcionCuandoFechaInicioEsNula() {
        CrearCitaCommand command = new CrearCitaCommand(
            "Consulta",
            "Presencial",
            null,
            LocalDateTime.now().plusDays(1),
            1L, 2L, 3L, "Cardiología"
        );
        
        assertThrows(FechaInvalidaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionCuandoFechaFinEsNula() {
        CrearCitaCommand command = new CrearCitaCommand(
            "Consulta",
            "Presencial",
            LocalDateTime.now().plusDays(1),
            null,
            1L, 2L, 3L, "Cardiología"
        );
        
        assertThrows(FechaInvalidaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionCuandoFechaInicioEsEnElPasado() {
        CrearCitaCommand command = new CrearCitaCommand(
            "Consulta",
            "Presencial",
            LocalDateTime.now().minusDays(1),
            LocalDateTime.now().plusHours(1),
            1L, 2L, 3L, "Cardiología"
        );
        
        assertThrows(FechaInvalidaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionCuandoFechaFinEsAnteriorAInicio() {
        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        CrearCitaCommand command = new CrearCitaCommand(
            "Consulta",
            "Presencial",
            inicio,
            inicio.minusHours(1),
            1L, 2L, 3L, "Cardiología"
        );
        
        assertThrows(FechaInvalidaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionCuandoPacienteNoExiste() {
        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        CrearCitaCommand command = new CrearCitaCommand(
            "Consulta",
            "Presencial",
            inicio,
            inicio.plusHours(1),
            1L, 2L, 3L, "Cardiología"
        );
        
        when(pacienteRepository.findbyId(any(UUID.class))).thenReturn(null);
        
        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionCuandoDoctorNoExiste() {
        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        CrearCitaCommand command = new CrearCitaCommand(
            "Consulta",
            "Presencial",
            inicio,
            inicio.plusHours(1),
            1L, 2L, 3L, "Cardiología"
        );
        
        when(pacienteRepository.findbyId(any(UUID.class))).thenReturn(mock(Paciente.class));
        when(doctorRepository.findbyId(any(UUID.class))).thenReturn(null);
        
        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(command));
    }
}
