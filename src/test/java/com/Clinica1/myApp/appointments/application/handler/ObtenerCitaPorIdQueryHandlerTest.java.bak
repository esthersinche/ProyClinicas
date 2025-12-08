package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.query.ObtenerCitaPorIdQuery;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObtenerCitaPorIdQueryHandlerTest {

    @Test
    void deberiaRetornarCitaCorrectamente() throws Exception {

        // Arrange
        CitaRepository citaRepository = mock(CitaRepository.class);
        CitaAssembler citaAssembler = mock(CitaAssembler.class);

        ObtenerCitaPorIdQueryHandler handler = new ObtenerCitaPorIdQueryHandler(citaRepository, citaAssembler);

        IDEntidad id = IDEntidad.astring("CITA-123");
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(id);

        Cita citaMock = mock(Cita.class);
        CitaDto dtoMock = new CitaDto();

        when(citaRepository.findById(id)).thenReturn(citaMock);
        when(citaAssembler.toDto(citaMock)).thenReturn(dtoMock);

        // Act
        CitaDto resultado = handler.handle(query);

        // Assert
        assertNotNull(resultado);
        assertEquals(dtoMock, resultado);

        verify(citaRepository).findById(id);
        verify(citaAssembler).toDto(citaMock);
    }

    @Test
    void deberiaLanzarErrorSiNoExisteLaCita() {

        // Arrange
        CitaRepository citaRepository = mock(CitaRepository.class);
        CitaAssembler citaAssembler = mock(CitaAssembler.class);

        ObtenerCitaPorIdQueryHandler handler = new ObtenerCitaPorIdQueryHandler(citaRepository, citaAssembler);

        IDEntidad id = IDEntidad.astring("CITA-404");
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(id);

        when(citaRepository.findById(id)).thenReturn(null);

        // Act & Assert
        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(query));
    }
}
