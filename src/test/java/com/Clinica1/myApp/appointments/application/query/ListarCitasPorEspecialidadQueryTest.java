package com.Clinica1.myApp.appointments.application.query;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListarCitasPorEspecialidadQueryTest {

    @Test
    void testConstructorSoloEspecialidad() {
        ListarCitasPorEspecialidadQuery query = new ListarCitasPorEspecialidadQuery("Cardiología");

        assertNotNull(query);
        assertEquals("Cardiología", query.getEspecialidad());
        assertNull(query.getEstado());
    }

    @Test
    void testConstructorEspecialidadYEstado() {
        ListarCitasPorEspecialidadQuery query =
                new ListarCitasPorEspecialidadQuery("Dermatología", "CANCELADA");

        assertNotNull(query);
        assertEquals("Dermatología", query.getEspecialidad());
        assertEquals("CANCELADA", query.getEstado());
    }
}

