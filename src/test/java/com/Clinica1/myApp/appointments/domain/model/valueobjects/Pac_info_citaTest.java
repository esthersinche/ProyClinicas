package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pac_info_citaTest {

    @Test
    void deberiaCrearPacInfoCorrectamente() {
        Pac_info_cita info = new Pac_info_cita("Juan Pérez", "12345678");

        assertEquals("Juan Pérez", info.nomb_com_pac());
        assertEquals("12345678", info.dni_pac());
    }

    @Test
    void deberiaCrearPacInfoConFactoryMethod() {
        Pac_info_cita info = Pac_info_cita.of("Ana Gomez", "98765432");

        assertEquals("Ana Gomez", info.nomb_com_pac());
        assertEquals("98765432", info.dni_pac());
    }

    @Test
    void deberiaLanzarErrorSiNombreEsNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pac_info_cita(null, "12345678"));
    }

    @Test
    void deberiaLanzarErrorSiNombreEsVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pac_info_cita("   ", "12345678"));
    }

    @Test
    void deberiaLanzarErrorSiDniEsNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pac_info_cita("Juan Pérez", null));
    }

    @Test
    void deberiaLanzarErrorSiDniEsVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pac_info_cita("Juan Pérez", "   "));
    }
}
