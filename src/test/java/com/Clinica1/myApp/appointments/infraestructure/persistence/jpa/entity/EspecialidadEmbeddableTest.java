package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadEmbeddableTest {

    @Test
    void builder_ok() {
        EspecialidadEmbeddable esp = EspecialidadEmbeddable.builder()
                .nom_espe("Cardiología")
                .build();

        assertEquals("Cardiología", esp.getNom_espe());
    }

    @Test
    void noArgs_ok() {
        EspecialidadEmbeddable esp = new EspecialidadEmbeddable();
        assertNotNull(esp);
    }

    @Test
    void allArgs_ok() {
        EspecialidadEmbeddable esp = new EspecialidadEmbeddable("Dermatología");
        assertEquals("Dermatología", esp.getNom_espe());
    }
}
