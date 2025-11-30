package com.Clinica1.myApp.appointments.application.query;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObtenerCitaPorIdQueryTest {

    @Test
    void constructorYGetter() {
        IDEntidad citaId = "12345";
        ObtenerCitaPorIdQuery query = new ObtenerCitaPorIdQuery(citaId);

        assertEquals(citaId, query.getCitaId(), "El getter debe devolver el ID de la cita");
    }
}
