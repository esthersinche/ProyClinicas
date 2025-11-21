package com.Clinica1.myApp.appointments.application.query;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObtenerCitaPorIdQueryTest {

    @Test
    void testConstructorYGetter() {
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(99L);

        assertNotNull(query);
        assertEquals(99L, query.getCitaId());
    }
}
