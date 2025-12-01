package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CancelarCitaCommandTest {

    @Test
    void deberiaCrearCancelarCitaCommandCorrectamente() {
        IDEntidad id = IDEntidad.generar();
        String motivo = "Paciente no puede asistir";

        CancelarCitaCommand command = new CancelarCitaCommand(id, motivo);

        assertNotNull(command, "✔ El comando no debe ser nulo");
        assertEquals(id, command.getCitaId(), "✔ El ID debe coincidir");
        assertEquals(motivo, command.getMotivoCancelacion(), "✔ El motivo debe coincidir");
    }

    @Test
    void deberiaAceptarMotivoVacio() {
        IDEntidad id = IDEntidad.generar();
        String motivo = "";

        CancelarCitaCommand command = new CancelarCitaCommand(id, motivo);

        assertNotNull(command, "✔ El comando no debe ser nulo");
        assertEquals(id, command.getCitaId(), "✔ El ID debe coincidir");
        assertEquals("", command.getMotivoCancelacion(), "✔ El motivo vacío debe mantenerse");
    }

    @Test
    void deberiaAceptarMotivoNull() {
        IDEntidad id = IDEntidad.generar();
        String motivo = null;

        CancelarCitaCommand command = new CancelarCitaCommand(id, motivo);

        assertNotNull(command, "✔ El comando no debe ser nulo");
        assertEquals(id, command.getCitaId(), "✔ El ID debe coincidir");
        assertNull(command.getMotivoCancelacion(), "✔ El motivo null debe mantenerse null");
    }
}
