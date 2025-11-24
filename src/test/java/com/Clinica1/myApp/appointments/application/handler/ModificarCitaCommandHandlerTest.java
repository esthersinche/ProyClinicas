package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.ModificarCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;
import com.Clinica1.myApp.appointments.application.exception.DoctorNoDisponibleException;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ModificarCitaCommandHandlerTest {

    private CitaRepository citaRepository;
    private DoctorRepository doctorRepository;
    private CitaAssembler citaAssembler;
    private ModificarCitaCommandHandler handler;

    @BeforeEach
    void setUp() {
        citaRepository = mock(CitaRepository.class);
        doctorRepository = mock(DoctorRepository.class);
        citaAssembler = mock(CitaAssembler.class);
        handler = new ModificarCitaCommandHandler(citaRepository, doctorRepository, citaAssembler);
    }

    @Test
    void deberiaModificarCitaCorrectamente() throws Exception {
        IDEntidad citaId = IDEntidad.generar();
        IDEntidad doctorId = IDEntidad.generar();

        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fin = inicio.plusHours(1);

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                "Consulta modificada",
                inicio,
                fin,
                doctorId,
                "Cardiología"
        );

        Cita citaExistente = mock(Cita.class);
        Doctor doctor = mock(Doctor.class);
        Cita citaActualizada = mock(Cita.class);
        CitaDto dtoEsperado = mock(CitaDto.class);

        when(citaRepository.findById(citaId)).thenReturn(citaExistente);
        when(doctorRepository.findById(doctorId)).thenReturn(doctor);
        when(citaRepository.update(citaExistente)).thenReturn(citaActualizada);
        when(citaAssembler.toDto(citaActualizada)).thenReturn(dtoEsperado);

        CitaDto resultado = handler.handle(command);

        assertNotNull(resultado);
        assertEquals(dtoEsperado, resultado);

        verify(citaRepository, times(1)).update(citaExistente);
        verify(citaAssembler, times(1)).toDto(citaActualizada);
    }

    @Test
    void deberiaLanzarExcepcionSiCitaNoExiste() {
        IDEntidad citaId = IDEntidad.generar();

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                "Consulta",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1),
                null,
                null
        );

        when(citaRepository.findById(citaId)).thenReturn(null);

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionSiFechasInvalidas() {
        IDEntidad citaId = IDEntidad.generar();

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                "Consulta",
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusHours(1),
                null,
                null
        );

        Cita citaExistente = mock(Cita.class);
        when(citaRepository.findById(citaId)).thenReturn(citaExistente);

        assertThrows(FechaInvalidaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionSiDoctorNoExiste() throws Exception {
        IDEntidad citaId = IDEntidad.generar();
        IDEntidad doctorId = IDEntidad.generar();

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                "Consulta",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1),
                doctorId,
                "Cardiología"
        );

        Cita citaExistente = mock(Cita.class);
        when(citaRepository.findById(citaId)).thenReturn(citaExistente);
        when(doctorRepository.findById(doctorId)).thenReturn(null);

        assertThrows(DoctorNoDisponibleException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionSiDoctorNoDisponible() throws Exception {
        IDEntidad citaId = IDEntidad.generar();
        IDEntidad doctorId = IDEntidad.generar();

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                "Consulta",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1),
                doctorId,
                "Cardiología"
        );

        Cita citaExistente = mock(Cita.class);
        Doctor doctor = mock(Doctor.class);

        when(citaRepository.findById(citaId)).thenReturn(citaExistente);
        when(doctorRepository.findById(doctorId)).thenReturn(doctor);

        ModificarCitaCommandHandler spyHandler = spy(handler);

        assertThrows(DoctorNoDisponibleException.class, () -> spyHandler.handle(command));
    }
}
