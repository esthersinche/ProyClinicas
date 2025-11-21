package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.command.ModificarCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.exception.DoctorNoDisponibleException;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ModificarCitaCommandHandlerTest {

    private CitaRepository citaRepository;
    private DoctorRepository doctorRepository;
    private CitaAssembler citaAssembler;
    private ModificarCitaCommandHandler handler;

    @BeforeEach
    void setup() {
        citaRepository = mock(CitaRepository.class);
        doctorRepository = mock(DoctorRepository.class);
        citaAssembler = mock(CitaAssembler.class);

        handler = new ModificarCitaCommandHandler(citaRepository, doctorRepository, citaAssembler);
    }

    @Test
    void testCitaNoEncontrada() {
        // Arrange
        UUID citaId = UUID.randomUUID();
        ModificarCitaCommand cmd = new ModificarCitaCommand(
                citaId, null, LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)
        );

        when(citaRepository.findbyId(citaId)).thenReturn(null);

        // Act & Assert
        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(cmd));
    }

    @Test
    void testFechaInicioEnPasado() {
        UUID citaId = UUID.randomUUID();
        Cita cita = mock(Cita.class);

        when(citaRepository.findbyId(citaId)).thenReturn(cita);

        ModificarCitaCommand cmd = new ModificarCitaCommand(
                citaId, null,
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusHours(2)
        );

        assertThrows(FechaInvalidaException.class, () -> handler.handle(cmd));
    }

    @Test
    void testFechaFinAntesQueInicio() {
        UUID citaId = UUID.randomUUID();
        Cita cita = mock(Cita.class);

        when(citaRepository.findbyId(citaId)).thenReturn(cita);

        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fin = inicio.minusHours(1);

        ModificarCitaCommand cmd = new ModificarCitaCommand(
                citaId, null, inicio, fin
        );

        assertThrows(FechaInvalidaException.class, () -> handler.handle(cmd));
    }

    @Test
    void testDoctorNoEncontrado() {
        UUID citaId = UUID.randomUUID();
        UUID doctorId = UUID.randomUUID();

        Cita cita = mock(Cita.class);
        when(citaRepository.findbyId(citaId)).thenReturn(cita);

        when(doctorRepository.findbyId(doctorId)).thenReturn(null);

        ModificarCitaCommand cmd = new ModificarCitaCommand(
                citaId, doctorId,
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1)
        );

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(cmd));
    }

    @Test
    void testVerificacionDoctorLanzaExcepcion() {
        UUID citaId = UUID.randomUUID();
        UUID doctorId = UUID.randomUUID();

        Cita cita = mock(Cita.class);
        Doctor doctor = mock(Doctor.class);

        when(citaRepository.findbyId(citaId)).thenReturn(cita);
        when(doctorRepository.findbyId(doctorId)).thenReturn(doctor);

        ModificarCitaCommand cmd = new ModificarCitaCommand(
                citaId, doctorId,
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1)
        );

        assertThrows(UnsupportedOperationException.class, () -> handler.handle(cmd));
    }

    @Test
    void testModificacionExitosa() throws DoctorNoDisponibleException, CitaNoEncontradaException, FechaInvalidaException {
        UUID citaId = UUID.randomUUID();
        Cita cita = mock(Cita.class);
        Cita citaActualizada = mock(Cita.class);
        CitaDto citaDto = new CitaDto();

        when(citaRepository.findbyId(citaId)).thenReturn(cita);
        when(citaRepository.update(cita)).thenReturn(citaActualizada);
        when(citaAssembler.toDto(citaActualizada)).thenReturn(citaDto);

        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fin = inicio.plusHours(1);

        ModificarCitaCommand cmd = new ModificarCitaCommand(
                citaId, null, inicio, fin
        );

        CitaDto result = handler.handle(cmd);

        assertNotNull(result);
        assertEquals(citaDto, result);
        verify(citaRepository).update(cita);
    }
}
