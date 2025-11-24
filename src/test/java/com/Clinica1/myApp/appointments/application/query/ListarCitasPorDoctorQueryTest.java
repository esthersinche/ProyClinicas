package com.Clinica1.myApp.appointments.application.query;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListarCitasPorDoctorQueryTest {

    @Test
    void constructorConSoloDoctorId() {
        String doctorId = "doc123";
        ListarCitasPorDoctorQuery query = new ListarCitasPorDoctorQuery(doctorId);

        assertEquals(doctorId, query.getDoctorId());
        assertNull(query.getEstado(), "El estado debería ser null si no se pasa en el constructor");
    }

    @Test
    void constructorConDoctorIdYEstado() {
        String doctorId = "doc123";
        String estado = "ACTIVA";
        ListarCitasPorDoctorQuery query = new ListarCitasPorDoctorQuery(doctorId, estado);

        assertEquals(doctorId, query.getDoctorId());
        assertEquals(estado, query.getEstado());
    }
}

