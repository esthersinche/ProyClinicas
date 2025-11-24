package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.query.ListarCitasPorDoctorQuery;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ListarCitasPorDoctorQueryHandlerTest {

    private CitaRepository citaRepository;
    private CitaAssembler citaAssembler;
    private ListarCitasPorDoctorQueryHandler handler;

    @BeforeEach
    void setUp() {
        citaRepository = mock(CitaRepository.class);
        citaAssembler = mock(CitaAssembler.class);
        handler = new ListarCitasPorDoctorQueryHandler(citaRepository, citaAssembler);
    }

    @Test
    void deberiaListarCitasDeUnDoctor() {
        IDEntidad doctorId = IDEntidad.generar();
        ListarCitasPorDoctorQuery query = new ListarCitasPorDoctorQuery(doctorId.toString());

        // Datos simulados
        Cita cita1 = mock(Cita.class);
        Cita cita2 = mock(Cita.class);
        CitaDto dto1 = mock(CitaDto.class);
        CitaDto dto2 = mock(CitaDto.class);

        // Configurar comportamiento del repositorio y assembler
        when(citaRepository.findbyDoctor(doctorId.toString())).thenReturn(List.of(cita1, cita2));
        when(citaAssembler.toDto(cita1)).thenReturn(dto1);
        when(citaAssembler.toDto(cita2)).thenReturn(dto2);

        // Ejecutar el handler
        List<CitaDto> resultado = handler.handle(query);

        // Verificaciones
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(dto1));
        assertTrue(resultado.contains(dto2));

        verify(citaRepository, times(1)).findbyDoctor(doctorId.toString());
        verify(citaAssembler, times(1)).toDto(cita1);
        verify(citaAssembler, times(1)).toDto(cita2);
    }
    @Test
    void deberiaRetornarListaVaciaSiNoHayCitas() {
        IDEntidad doctorId = IDEntidad.generar();
        ListarCitasPorDoctorQuery query = new ListarCitasPorDoctorQuery(doctorId.toString());

        when(citaRepository.findbyDoctor(doctorId.toString())).thenReturn(List.of());

        List<CitaDto> resultado = handler.handle(query);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());

        verify(citaRepository, times(1)).findbyDoctor(doctorId.toString());
        verifyNoInteractions(citaAssembler);
    }
}
