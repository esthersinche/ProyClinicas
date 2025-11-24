package com.Clinica1.myApp.appointments.application.query;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListarCitasPorEspecialidadQueryTest {

    @Test
    void constructorConSoloEspecialidad() {
        String especialidad = "Cardiología";
        ListarCitasPorEspecialidadQuery query = new ListarCitasPorEspecialidadQuery(especialidad);

        assertEquals(especialidad, query.getEspecialidad());
        assertNull(query.getEstado(), "El estado debería ser null si no se pasa en el constructor");
    }

    @Test
    void constructorConEspecialidadYEstado() {
        String especialidad = "Cardiología";
        String estado = "ACTIVA";
        ListarCitasPorEspecialidadQuery query = new ListarCitasPorEspecialidadQuery(especialidad, estado);

        assertEquals(especialidad, query.getEspecialidad());
        assertEquals(estado, query.getEstado());
    }
}

