package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanalTest {

    @Test
    void deberiaContenerLosValoresCorrectos() {
        assertNotNull(Canal.valueOf("Virtual"));
        assertNotNull(Canal.valueOf("Presencial"));
    }

    @Test
    void deberiaRetornarEnumCorrectoConValueOf() {
        Canal c1 = Canal.valueOf("Virtual");
        Canal c2 = Canal.valueOf("Presencial");

        assertEquals(Canal.Virtual, c1);
        assertEquals(Canal.Presencial, c2);
    }

    @Test
    void deberiaLanzarErrorConValorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Canal.valueOf("Telefono");
        });
    }

    @Test
    void deberiaTenerExactamenteDosValores() {
        Canal[] valores = Canal.values();
        assertEquals(2, valores.length);
    }
}
