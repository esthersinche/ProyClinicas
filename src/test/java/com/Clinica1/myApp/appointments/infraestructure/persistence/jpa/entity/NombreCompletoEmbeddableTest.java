package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NombreCompletoEmbeddableTest {

    @Test
    void builder_ok() {
        NombreCompletoEmbeddable nom = NombreCompletoEmbeddable.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .build();

        assertEquals("Juan", nom.getNombre());
        assertEquals("Pérez", nom.getApellido());
    }

    @Test
    void noArgs_ok() {
        NombreCompletoEmbeddable nom = new NombreCompletoEmbeddable();
        assertNotNull(nom);
    }

    @Test
    void allArgs_ok() {
        NombreCompletoEmbeddable nom = new NombreCompletoEmbeddable("Ana", "Soto");

        assertEquals("Ana", nom.getNombre());
        assertEquals("Soto", nom.getApellido());
    }
}
