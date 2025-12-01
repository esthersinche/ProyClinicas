package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DireccionTest {

    @Test
    void deberiaCrearDireccionCorrectamente() {
        Direccion d = new Direccion(
                "Av. Los Héroes",
                "Chorrillos",
                "Lima",
                "Lima");

        assertEquals("Av. Los Héroes", d.avenida());
        assertEquals("Chorrillos", d.distrito());
        assertEquals("Lima", d.departamento());
        assertEquals("Lima", d.provincia());
    }

    @Test
    void deberiaCrearDireccionConFactory() {
        Direccion d = Direccion.of(
                "Av. Grau",
                "Miraflores",
                "Lima",
                "Lima");

        assertEquals("Av. Grau", d.avenida());
        assertEquals("Miraflores", d.distrito());
    }

    @Test
    void deberiaFallarSiAvenidaEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Direccion(null, "Chorrillos", "Lima", "Lima"));

        assertThrows(IllegalArgumentException.class, () -> new Direccion("   ", "Chorrillos", "Lima", "Lima"));
    }

    @Test
    void deberiaFallarSiDistritoEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Direccion("Av. Lima", null, "Lima", "Lima"));

        assertThrows(IllegalArgumentException.class, () -> new Direccion("Av. Lima", "", "Lima", "Lima"));
    }

    @Test
    void deberiaFallarSiDepartamentoEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Direccion("Av. Lima", "Barranco", null, "Lima"));

        assertThrows(IllegalArgumentException.class, () -> new Direccion("Av. Lima", "Barranco", " ", "Lima"));
    }

    @Test
    void deberiaFallarSiProvinciaEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Direccion("Av. Lima", "Barranco", "Lima", null));

        assertThrows(IllegalArgumentException.class, () -> new Direccion("Av. Lima", "Barranco", "Lima", "  "));
    }
}
