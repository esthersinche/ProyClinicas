package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DireccionEmbeddableTest {

    @Test
    void builder_ok() {
        DireccionEmbeddable dir = DireccionEmbeddable.builder()
                .avenida("Av. Lima")
                .distrito("Chorrillos")
                .departamento("Lima")
                .provincia("Lima")
                .build();

        assertEquals("Av. Lima", dir.getAvenida());
        assertEquals("Chorrillos", dir.getDistrito());
        assertEquals("Lima", dir.getDepartamento());
        assertEquals("Lima", dir.getProvincia());
    }

    @Test
    void noArgs_ok() {
        DireccionEmbeddable dir = new DireccionEmbeddable();
        assertNotNull(dir);
    }

    @Test
    void allArgs_ok() {
        DireccionEmbeddable dir = new DireccionEmbeddable(
                "Av. Arequipa",
                "Miraflores",
                "Lima",
                "Lima");

        assertEquals("Av. Arequipa", dir.getAvenida());
        assertEquals("Miraflores", dir.getDistrito());
        assertEquals("Lima", dir.getDepartamento());
        assertEquals("Lima", dir.getProvincia());
    }
}
