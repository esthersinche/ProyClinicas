package com.Clinica1.myApp.appointments.application.query;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObtenerPacientePorDniQueryTest {

    @Test
    void deberiaCrearQueryConDniCorrecto() {

        // Arrange
        String dni = "12345678";

        // Act
        ObtenerPacientePorDniQuery query = new ObtenerPacientePorDniQuery(dni);

        // Assert
        assertNotNull(query);
        assertEquals(dni, query.getDni());
    }
}