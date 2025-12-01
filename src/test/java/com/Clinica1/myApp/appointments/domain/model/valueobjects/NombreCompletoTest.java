package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NombreCompletoTest {

    @Test
    void deberiaCrearNombreCompletoCorrectamente() {
        NombreCompleto nombre = new NombreCompleto("Juan", "Pérez");

        assertEquals("Juan", nombre.nombre());
        assertEquals("Pérez", nombre.apellido());
    }

    @Test
    void deberiaCrearNombreCompletoConFactoryMethod() {
        NombreCompleto nombre = NombreCompleto.of("Ana", "García");

        assertEquals("Ana", nombre.nombre());
        assertEquals("García", nombre.apellido());
    }

    @Test
    void deberiaConcatenarNombreYApellidoCorrectamente() {
        NombreCompleto nombre = new NombreCompleto("Carlos", "Lopez");

        assertEquals("Carlos Lopez", nombre.completar());
    }

    @Test
    void deberiaLanzarErrorSiNombreEsNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new NombreCompleto(null, "Perez"));
    }

    @Test
    void deberiaLanzarErrorSiNombreEsVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> new NombreCompleto("   ", "Perez"));
    }

    @Test
    void deberiaLanzarErrorSiApellidoEsNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new NombreCompleto("Juan", null));
    }

    @Test
    void deberiaLanzarErrorSiApellidoEsVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> new NombreCompleto("Juan", "   "));
    }
}
