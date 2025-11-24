package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CancelarCitaCommandTest {

    @Test
    void deberiaCrearCancelarCitaCommandCorrectamente() {
        IDEntidad citaId = IDEntidad.astring("CITA123");
        String motivo = "Paciente no asistió";

        CancelarCitaCommand cmd = new CancelarCitaCommand(citaId, motivo);

        assertEquals("CITA123", cmd.getCitaId().obtenerid());
        assertEquals("Paciente no asistió", cmd.getMotivoCancelacion());
    }

    @Test
    void deberiaAceptarMotivoCancelacionVacio() {
        IDEntidad citaId = IDEntidad.astring("CITA999");

        CancelarCitaCommand cmd = new CancelarCitaCommand(citaId, "");

        assertEquals("CITA999", cmd.getCitaId().obtenerid());
        assertEquals("", cmd.getMotivoCancelacion());
    }

    @Test
    void deberiaAceptarMotivoCancelacionNull() {
        IDEntidad citaId = IDEntidad.astring("CITA777");

        CancelarCitaCommand cmd = new CancelarCitaCommand(citaId, null);

        assertEquals("CITA777", cmd.getCitaId().obtenerid());
        assertNull(cmd.getMotivoCancelacion());
    }
}
