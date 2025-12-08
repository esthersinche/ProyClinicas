package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.query.ObtenerCitaPorIdQuery;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerCitaPorIdQueryHandlerTest {

    @Mock
    private CitaRepository citaRepository;

    @Mock
    private CitaAssembler citaAssembler;

    @InjectMocks
    private ObtenerCitaPorIdQueryHandler handler;

    @Test
    void deberiaRetornarCitaDtoCuandoExiste() {

        // -------- Arrange --------
        IDEntidad citaId = IDEntidad.generar();
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(citaId);

        Cita cita = mock(Cita.class);
        CitaDto dtoEsperado = mock(CitaDto.class);

        when(citaRepository.findById(citaId)).thenReturn(Optional.of(cita));
        when(citaAssembler.toDto(cita)).thenReturn(dtoEsperado);

        // -------- Act --------
        CitaDto resultado = handler.handle(query);

        // -------- Assert --------
        assertNotNull(resultado);
        assertEquals(dtoEsperado, resultado);

        verify(citaRepository).findById(citaId);
        verify(citaAssembler).toDto(cita);
    }

    @Test
    void deberiaLanzarExcepcionCuandoCitaNoExiste() {

        // -------- Arrange --------
        IDEntidad citaId = IDEntidad.generar();
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(citaId);

        when(citaRepository.findById(citaId)).thenReturn(Optional.empty());

        // -------- Act & Assert --------
        assertThrows(CitaNoEncontradaException.class, () ->
                handler.handle(query)
        );

        verify(citaRepository).findById(citaId);
        verify(citaAssembler, never()).toDto(any());
    }
}