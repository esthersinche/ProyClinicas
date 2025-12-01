package com.Clinica1.myApp.appointments.application.query;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObtenerCitaPorIdQueryTest {

    @Test
    void deberiaCrearQueryCorrectamente() {
        IDEntidad id = IDEntidad.astring("CITA-001");

        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(id);

        assertNotNull(query);
        assertEquals(id, query.getCitaId());
    }

    @Test
    void deberiaRetornarElMismoIdQueSeAsigno() {
        IDEntidad id = IDEntidad.astring("ABC-123");

        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(id);

        assertEquals("ABC-123", query.getCitaId().obtenerid());
    }
}
