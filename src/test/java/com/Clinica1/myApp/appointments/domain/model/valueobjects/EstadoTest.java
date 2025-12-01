package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoTest {

    @Test
    void deberiaContenerLosTresEstados() {
        assertEquals(3, Estado.values().length);
        assertNotNull(Estado.Pendiente);
        assertNotNull(Estado.Asistio);
        assertNotNull(Estado.Desercion);
    }

    @Test
    void deberiaConvertirDesdeStringCorrectamente() {
        assertEquals(Estado.Pendiente, Estado.valueOf("Pendiente"));
        assertEquals(Estado.Asistio, Estado.valueOf("Asistio"));
        assertEquals(Estado.Desercion, Estado.valueOf("Desercion"));
    }

    @Test
    void deberiaLanzarErrorSiElNombreEsInvalido() {
        assertThrows(IllegalArgumentException.class, () -> Estado.valueOf("Inexistente"));
    }
}
