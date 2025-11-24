package com.Clinica1.myApp.appointments.application.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FechaInvalidaExceptionTest {

    @Test
    void fechaInvalidaExceptionMensajeCorrecto() {
        FechaInvalidaException ex = new FechaInvalidaException("Fecha inválida");
        assertEquals("Fecha inválida", ex.getMessage());
    }

    @Test
    void fechaInvalidaExceptionConCausa() {
        Throwable causa = new RuntimeException("Causa");
        FechaInvalidaException ex = new FechaInvalidaException("Fecha inválida", causa);
        assertEquals("Fecha inválida", ex.getMessage());
        assertEquals(causa, ex.getCause());
    }
}
