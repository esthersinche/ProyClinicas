package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.query.ListarCitasPorEspecialidadQuery;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ListarCitasPorEspecialidadQueryHandlerTest {

    private CitaRepository citaRepository;
    private CitaAssembler citaAssembler;
    private ListarCitasPorEspecialidadQueryHandler handler;

    @BeforeEach
    void setUp() {
        citaRepository = mock(CitaRepository.class);
        citaAssembler = mock(CitaAssembler.class);
        handler = new ListarCitasPorEspecialidadQueryHandler(citaRepository, citaAssembler);
    }

    @Test
    void deberiaListarCitasSegunEspecialidad() {
        String especialidad = "Cardiología";

        ListarCitasPorEspecialidadQuery query = new ListarCitasPorEspecialidadQuery(especialidad);

        // Mock de las citas
        Cita cita1 = mock(Cita.class);
        Cita cita2 = mock(Cita.class);
        Cita cita3 = mock(Cita.class); // esta no coincide

        CitaDto dto1 = mock(CitaDto.class);
        CitaDto dto2 = mock(CitaDto.class);

        when(citaRepository.findall()).thenReturn(List.of(cita1, cita2, cita3));
        when(cita1.getEspe_cita()).thenReturn(Especialidad.of(especialidad));
        when(cita2.getEspe_cita()).thenReturn(Especialidad.of(especialidad));
        when(cita3.getEspe_cita()).thenReturn(Especialidad.of("Pediatría"));

        when(citaAssembler.toDto(cita1)).thenReturn(dto1);
        when(citaAssembler.toDto(cita2)).thenReturn(dto2);

        List<CitaDto> resultado = handler.handle(query);

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(dto1));
        assertTrue(resultado.contains(dto2));

        verify(citaRepository, times(1)).findall();
        verify(citaAssembler, times(1)).toDto(cita1);
        verify(citaAssembler, times(1)).toDto(cita2);
    }

    @Test
    void deberiaRetornarListaVaciaSiNoHayCitasConEspecialidad() {
        String especialidad = "Dermatología";
        ListarCitasPorEspecialidadQuery query = new ListarCitasPorEspecialidadQuery(especialidad);

        Cita cita1 = mock(Cita.class);
        when(citaRepository.findall()).thenReturn(List.of(cita1));
        when(cita1.getEspe_cita()).thenReturn(Especialidad.of("Cardiología"));

        List<CitaDto> resultado = handler.handle(query);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());

        verify(citaRepository, times(1)).findall();
        verify(citaAssembler, never()).toDto(any());
    }
}

