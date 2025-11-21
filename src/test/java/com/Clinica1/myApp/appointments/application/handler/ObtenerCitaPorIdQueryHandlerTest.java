package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.query.ObtenerCitaPorIdQuery;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ObtenerCitaPorIdQueryHandlerTest {

    @Mock
    private CitaRepository citaRepository;

    @Mock
    private CitaAssembler citaAssembler;

    private ObtenerCitaPorIdQueryHandler handler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        handler = new ObtenerCitaPorIdQueryHandler(citaRepository, citaAssembler);
    }

    @Test
    void testHandle_CitaExiste_RetornaDto() throws CitaNoEncontradaException {
        long citaId = 10L;
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(citaId);

        Cita citaMock = mock(Cita.class);
        CitaDto citaDtoMock = mock(CitaDto.class);
        when(citaRepository.findById(citaId)).thenReturn(citaMock);
        when(citaAssembler.toDto(citaMock)).thenReturn(citaDtoMock);
        CitaDto result = handler.handle(query);
        assertNotNull(result);
        assertEquals(citaDtoMock, result);

        verify(citaRepository).findById(citaId);
        verify(citaAssembler).toDto(citaMock);
    }

    @Test
    void testHandle_CitaNoExiste_LanzaExcepcion() {
        long citaId = 200L;
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(citaId);

        when(citaRepository.findById(citaId)).thenReturn(null);

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(query));

        verify(citaRepository).findById(citaId);
        verifyNoInteractions(citaAssembler);
    }
}


