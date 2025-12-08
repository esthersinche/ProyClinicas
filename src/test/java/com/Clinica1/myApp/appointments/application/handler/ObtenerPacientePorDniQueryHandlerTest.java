package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.assembler.PacienteAssembler;
import com.Clinica1.myApp.appointments.application.dto.PacienteDto;
import com.Clinica1.myApp.appointments.application.query.ObtenerPacientePorDniQuery;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerPacientePorDniQueryHandlerTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private PacienteAssembler assembler;

    @InjectMocks
    private ObtenerPacientePorDniQueryHandler handler;

    @Test
    void deberiaRetornarPacienteDtoCuandoExiste() {

        // -------- Arrange --------
        String dni = "12345678";
        ObtenerPacientePorDniQuery query = new ObtenerPacientePorDniQuery(dni);

        Paciente paciente = mock(Paciente.class);
        PacienteDto dtoEsperado = mock(PacienteDto.class);

        when(pacienteRepository.findbyDNI(dni)).thenReturn(paciente);
        when(assembler.toDto(paciente)).thenReturn(dtoEsperado);

        // -------- Act --------
        PacienteDto resultado = handler.handle(query);

        // -------- Assert --------
        assertNotNull(resultado);
        assertEquals(dtoEsperado, resultado);

        verify(pacienteRepository).findbyDNI(dni);
        verify(assembler).toDto(paciente);
    }

    @Test
    void deberiaRetornarNullCuandoPacienteNoExiste() {

        // -------- Arrange --------
        String dni = "99999999";
        ObtenerPacientePorDniQuery query = new ObtenerPacientePorDniQuery(dni);

        when(pacienteRepository.findbyDNI(dni)).thenReturn(null);

        // -------- Act --------
        PacienteDto resultado = handler.handle(query);

        // -------- Assert --------
        assertNull(resultado);

        verify(pacienteRepository).findbyDNI(dni);
        verify(assembler, never()).toDto(any());
    }
}