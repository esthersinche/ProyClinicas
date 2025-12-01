package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CancelarCitaCommand;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CancelarCitaCommandHandlerTest {

    private CitaRepository citaRepository;
    private CancelarCitaCommandHandler handler;

    @BeforeEach
    void setUp() {
        citaRepository = mock(CitaRepository.class);
        handler = new CancelarCitaCommandHandler(citaRepository);
    }

    @Test
    void deberiaCancelarCitaCorrectamente() throws CitaNoEncontradaException {
        IDEntidad citaId = IDEntidad.generar();

        Cita cita = mock(Cita.class);
        when(cita.getEstado_cita()).thenReturn(Estado.Pendiente);
        when(citaRepository.findById(citaId)).thenReturn(cita);

        CancelarCitaCommand command = new CancelarCitaCommand(citaId);

        handler.handle(command);

        // Verificar que se llamó delete en el repositorio
        verify(citaRepository, times(1)).delete(citaId);
    }

    @Test
    void deberiaLanzarExcepcionSiCitaNoExiste() {
        IDEntidad citaId = IDEntidad.generar();

        when(citaRepository.findById(citaId)).thenReturn(null);

        CancelarCitaCommand command = new CancelarCitaCommand(citaId);

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(command));
    }

    @Test
    void deberiaLanzarExcepcionSiCitaYaCancelada() {
        IDEntidad citaId = IDEntidad.generar();

        Cita cita = mock(Cita.class);
        when(cita.getEstado_cita()).thenReturn(Estado.Desercion);
        when(citaRepository.findById(citaId)).thenReturn(cita);

        CancelarCitaCommand command = new CancelarCitaCommand(citaId);

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(command));
    }
}
