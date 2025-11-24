package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.query.ObtenerCitaPorIdQuery;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ObtenerCitaPorIdQueryHandlerTest {

    private CitaRepository citaRepository;
    private CitaAssembler citaAssembler;
    private ObtenerCitaPorIdQueryHandler handler;

    @BeforeEach
    void setUp() {
        citaRepository = mock(CitaRepository.class);
        citaAssembler = mock(CitaAssembler.class);
        handler = new ObtenerCitaPorIdQueryHandler(citaRepository, citaAssembler);
    }

    @Test
    void deberiaObtenerCitaCorrectamente() throws CitaNoEncontradaException {
        IDEntidad citaId = IDEntidad.generar();
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(citaId.toString());

        Cita cita = mock(Cita.class);
        CitaDto dtoEsperado = mock(CitaDto.class);

        when(citaRepository.findById(citaId)).thenReturn(cita);
        when(citaAssembler.toDto(cita)).thenReturn(dtoEsperado);

        CitaDto resultado = handler.handle(query);

        assertNotNull(resultado);
        assertEquals(dtoEsperado, resultado);

        verify(citaRepository, times(1)).findById(citaId);
        verify(citaAssembler, times(1)).toDto(cita);
    }

    @Test
    void deberiaLanzarExcepcionSiCitaNoExiste() {
        IDEntidad citaId = IDEntidad.generar();
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(citaId.toString());

        when(citaRepository.findById(citaId)).thenReturn(null);

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(query));

        verify(citaRepository, times(1)).findById(citaId);
        verifyNoInteractions(citaAssembler);
    }
}


