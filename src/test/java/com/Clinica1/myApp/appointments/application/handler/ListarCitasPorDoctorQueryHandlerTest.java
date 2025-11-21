package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.query.ListarCitasPorDoctorQuery;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ListarCitasPorDoctorQueryHandlerTest {

    @Test
    void testHandleRetornaListaDeCitasDto() {
        CitaRepository citaRepository = mock(CitaRepository.class);
        CitaAssembler citaAssembler = mock(CitaAssembler.class);

        ListarCitasPorDoctorQueryHandler handler =
                new ListarCitasPorDoctorQueryHandler(citaRepository, citaAssembler);

        ListarCitasPorDoctorQuery query = new ListarCitasPorDoctorQuery(10L);

        Cita cita1 = new Cita();
        Cita cita2 = new Cita();

        when(citaRepository.findbyDoctor("10"))
                .thenReturn(List.of(cita1, cita2));

        CitaDto dto1 = new CitaDto(null, "Motivo1", "AGENDADA",
                "PRESENCIAL", null, null, null, null, null, null);

        CitaDto dto2 = new CitaDto(null, "Motivo2", "CANCELADA",
                "VIRTUAL", null, null, null, null, null, null);

        when(citaAssembler.toDto(cita1)).thenReturn(dto1);
        when(citaAssembler.toDto(cita2)).thenReturn(dto2);

        List<CitaDto> resultado = handler.handle(query);

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Motivo1", resultado.get(0).getMotivo());
        assertEquals("Motivo2", resultado.get(1).getMotivo());


        verify(citaRepository, times(1)).findbyDoctor("10");
        verify(citaAssembler, times(1)).toDto(cita1);
        verify(citaAssembler, times(1)).toDto(cita2);
    }
}
