package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.query.ListarCitasPorEspecialidadQuery;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ListarCitasPorEspecialidadQueryHandlerTest {

    @Test
    void testHandleFiltraYConvierteCorrectamente() {
        CitaRepository citaRepository = mock(CitaRepository.class);
        CitaAssembler citaAssembler = mock(CitaAssembler.class);

        ListarCitasPorEspecialidadQueryHandler handler =
                new ListarCitasPorEspecialidadQueryHandler(citaRepository, citaAssembler);

        ListarCitasPorEspecialidadQuery query =
                new ListarCitasPorEspecialidadQuery("Cardiología");

        Especialidad especialidad1 = mock(Especialidad.class);
        when(especialidad1.nom_espe()).thenReturn("Cardiología");

        Especialidad especialidad2 = mock(Especialidad.class);
        when(especialidad2.nom_espe()).thenReturn("Dermatología");

        Cita cita1 = mock(Cita.class);
        when(cita1.getEspe_cita()).thenReturn(especialidad1);

        Cita cita2 = mock(Cita.class);
        when(cita2.getEspe_cita()).thenReturn(especialidad2);

        Cita cita3 = mock(Cita.class);
        when(cita3.getEspe_cita()).thenReturn(especialidad1);

        when(citaRepository.findall()).thenReturn(List.of(cita1, cita2, cita3));

        CitaDto dto1 = new CitaDto();
        CitaDto dto3 = new CitaDto();

        when(citaAssembler.toDto(cita1)).thenReturn(dto1);
        when(citaAssembler.toDto(cita3)).thenReturn(dto3);

        List<CitaDto> resultado = handler.handle(query);

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(dto1));
        assertTrue(resultado.contains(dto3));

        verify(citaRepository, times(1)).findall();
        verify(citaAssembler, times(1)).toDto(cita1);
        verify(citaAssembler, times(1)).toDto(cita3);
        verify(citaAssembler, never()).toDto(cita2);

    }
}

