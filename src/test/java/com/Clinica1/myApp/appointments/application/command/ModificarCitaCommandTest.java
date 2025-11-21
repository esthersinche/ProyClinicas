package com.Clinica1.myApp.appointments.application.command;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ModificarCitaCommandTest {

    @Test
    void testConstructorYGetters() {
        Long citaId = 100L;
        String motivo = "Actualización de diagnóstico";
        LocalDateTime inicio = LocalDateTime.of(2025, 3, 15, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2025, 3, 15, 10, 30);
        Long doctorId = 20L;
        String especialidad = "Pediatría";

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId, motivo, inicio, fin, doctorId, especialidad
        );

        assertNotNull(command);

        assertEquals(100L, command.getCitaId());
        assertEquals("Actualización de diagnóstico", command.getMotivo());
        assertEquals(inicio, command.getInicio());
        assertEquals(fin, command.getFin());
        assertEquals(20L, command.getDoctorId());
        assertEquals("Pediatría", command.getEspecialidad());
    }
}

