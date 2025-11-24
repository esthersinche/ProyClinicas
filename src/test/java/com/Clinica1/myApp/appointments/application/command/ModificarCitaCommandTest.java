package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ModificarCitaCommandTest {

    @Test
    void deberiaCrearCommandConTodosLosDatos() {
        IDEntidad citaId = IDEntidad.astring("CITA001");
        IDEntidad doctorId = IDEntidad.astring("DOC123");

        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        ModificarCitaCommand cmd = new ModificarCitaCommand(
                citaId,
                "Control",
                inicio,
                fin,
                doctorId,
                "Cardiología"
        );

        assertEquals("CITA001", cmd.getCitaId().obtenerid());
        assertEquals("Control", cmd.getMotivo());
        assertEquals(inicio, cmd.getInicio());
        assertEquals(fin, cmd.getFin());
        assertEquals("DOC123", cmd.getDoctorId().obtenerid());
        assertEquals("Cardiología", cmd.getEspecialidad());
    }

    @Test
    void constructorIncompletoNoDeberiaAsignarCampos() {
        IDEntidad citaId = IDEntidad.astring("CITA002");
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(2);

        // este constructor no asigna nada en la clase lmao
        ModificarCitaCommand cmd = new ModificarCitaCommand(
                citaId,
                "MotivoTemporal",
                inicio,
                fin
        );

        // Todos deben quedar en null porque la implementación está vacía
        assertNull(cmd.getCitaId());
        assertNull(cmd.getMotivo());
        assertNull(cmd.getInicio());
        assertNull(cmd.getFin());
        assertNull(cmd.getDoctorId());
        assertNull(cmd.getEspecialidad());
    }
}

