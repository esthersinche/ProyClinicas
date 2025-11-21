package com.Clinica1.myApp.appointments.application.query;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListarCitasPorDoctorQueryTest {

    @Test
    void testConstructorSoloDoctorId() {
        ListarCitasPorDoctorQuery query = new ListarCitasPorDoctorQuery(10L);

        assertNotNull(query);
        assertEquals(10L, query.getDoctorId());
        assertNull(query.getEstado());
    }

    @Test
    void testConstructorDoctorIdYEstado() {
        ListarCitasPorDoctorQuery query = new ListarCitasPorDoctorQuery(5L, "AGENDADA");

        assertNotNull(query);
        assertEquals(5L, query.getDoctorId());
        assertEquals("AGENDADA", query.getEstado());
    }
}

