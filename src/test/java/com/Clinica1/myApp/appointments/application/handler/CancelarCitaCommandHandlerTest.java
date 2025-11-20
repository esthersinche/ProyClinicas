package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.command.CancelarCitaCommand;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CancelarCitaCommandHandlerTest {

    @Mock
    private CitaRepository citaRepository;
    
    private CancelarCitaCommandHandler handler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        handler = new CancelarCitaCommandHandler(citaRepository);
    }

    @Test
    void deberiaLanzarExcepcionCuandoCitaNoExiste() {
        CancelarCitaCommand command = new CancelarCitaCommand(1L, "Motivo");
        
        when(citaRepository.findbyId(any(UUID.class))).thenReturn(null);
        
        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaCancelarCitaExitosamente() throws CitaNoEncontradaException {
        CancelarCitaCommand command = new CancelarCitaCommand(1L, "Paciente no puede asistir");
        Cita cita = mock(Cita.class);
        
        when(citaRepository.findbyId(any(UUID.class))).thenReturn(cita);
        doNothing().when(citaRepository).delete(any(UUID.class));
        
        assertDoesNotThrow(() -> handler.handle(command));
        verify(citaRepository, times(1)).delete(any(UUID.class));
    }
}
