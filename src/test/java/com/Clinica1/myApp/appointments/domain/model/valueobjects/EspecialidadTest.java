package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    void deberiaCrearEspecialidadCorrectamente() {
        Especialidad especialidad = new Especialidad("Cardiología");

        assertEquals("Cardiología", especialidad.nom_espe());
    }

    @Test
    void deberiaCrearEspecialidadConFactory() {
        Especialidad especialidad = Especialidad.of("Dermatología");

        assertEquals("Dermatología", especialidad.nom_espe());
    }

    @Test
    void deberiaFallarSiNombreEsNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Especialidad(null));
    }

    @Test
    void deberiaFallarSiNombreEsVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Especialidad("   "));
    }

    @Test
    void deberiaAceptarEspecialidadValida() {
        assertDoesNotThrow(() -> new Especialidad("Gastroenterología"));
    }
}
