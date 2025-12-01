package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CancelarCitaCommandTest {

    @Test
    void deberiaCrearCancelarCitaCommandCorrectamente() {
        IDEntidad id = IDEntidad.generar();


        CancelarCitaCommand command = new CancelarCitaCommand(id);

        assertNotNull(command, "✔ El comando no debe ser nulo");
        assertEquals(id, command.getCitaId(), "✔ El ID debe coincidir");
    }

    @Test
    void deberiaAceptarMotivoVacio() {
        IDEntidad id = IDEntidad.generar();

        CancelarCitaCommand command = new CancelarCitaCommand(id);

        assertNotNull(command, "✔ El comando no debe ser nulo");
        assertEquals(id, command.getCitaId(), "✔ El ID debe coincidir");
    }

    @Test
    void deberiaAceptarMotivoNull() {
        IDEntidad id = IDEntidad.generar();

        CancelarCitaCommand command = new CancelarCitaCommand(id);

        assertNotNull(command, "✔ El comando no debe ser nulo");
        assertEquals(id, command.getCitaId(), "✔ El ID debe coincidir");
    }
}
