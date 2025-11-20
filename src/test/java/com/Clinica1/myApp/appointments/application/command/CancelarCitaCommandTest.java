package com.Clinica1.myApp.appointments.application.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CancelarCitaCommandTest {

    @Test
    void deberiaCrearCommandConIdValido() {
        CancelarCitaCommand command = new CancelarCitaCommand(1L, "Paciente no puede asistir");
        
        assertNotNull(command);
        assertEquals(1L, command.getCitaId());
        assertEquals("Paciente no puede asistir", command.getMotivoCancelacion());
    }

    @Test
    void deberiaPermitirMotivoCancelacionNulo() {
        CancelarCitaCommand command = new CancelarCitaCommand(1L, null);
        
        assertNotNull(command);
        assertEquals(1L, command.getCitaId());
        assertNull(command.getMotivoCancelacion());
    }
}
