package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ModificarCitaCommandTest {

    @Test
    void deberiaCrearModificarCitaCommandCorrectamente() {
        IDEntidad citaId = IDEntidad.generar();
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                inicio,
                fin);

        assertNotNull(command, "✔ El comando no debe ser nulo");
        assertEquals(citaId, command.getCitaId(), "✔ El ID de la cita debe coincidir");
        assertEquals(inicio, command.getInicio(), "✔ La fecha/hora de inicio debe coincidir");
        assertEquals(fin, command.getFin(), "✔ La fecha/hora de fin debe coincidir");
    }

    @Test
    void deberiaPermitirDoctorIdNull() {
        IDEntidad citaId = IDEntidad.generar();
        String motivo = "Reprogramación sin cambio de doctor";
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(2);

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                inicio,
                fin);

        assertNotNull(command, "✔ El comando no debe ser nulo");
        assertEquals(citaId, command.getCitaId(), "✔ El ID de la cita debe coincidir");
    }

    @Test
    void deberiaPermitirMotivoNull() {
        IDEntidad citaId = IDEntidad.generar();
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                inicio,
                fin);

        assertNotNull(command, "✔ El comando no debe ser nulo");
    }
}
