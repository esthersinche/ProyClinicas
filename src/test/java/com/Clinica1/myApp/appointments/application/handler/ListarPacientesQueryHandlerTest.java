package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.dto.PacienteInfoDto;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ListarPacientesQueryHandlerTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private ListarPacientesQueryHandler handler;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deberiaListarPacientesCorrectamente() {

        Paciente p1 = mock(Paciente.class);
        Paciente p2 = mock(Paciente.class);

        when(p1.getNombre_com_pac()).thenReturn("Luis Perez");
        when(p1.getDni_pac()).thenReturn("12345678");

        when(p2.getNombre_com_pac()).thenReturn("Ana Torres");
        when(p2.getDni_pac()).thenReturn("87654321");

        when(pacienteRepository.findall()).thenReturn(Arrays.asList(p1, p2));

        List<PacienteInfoDto> result = handler.handle();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Luis Perez", result.get(0).getNombre());
        assertEquals("12345678", result.get(0).getDni());
        assertEquals("Ana Torres", result.get(1).getNombre());
        assertEquals("87654321", result.get(1).getDni());

        verify(pacienteRepository, times(1)).findall();
    }
}
