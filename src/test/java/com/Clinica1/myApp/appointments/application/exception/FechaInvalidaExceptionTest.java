package com.Clinica1.myApp.appointments.application.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FechaInvalidaExceptionTest {

    @Test
    void deberiaCrearExcepcionConMensaje() {
        String mensaje = "La fecha de inicio no puede ser en el pasado";
        FechaInvalidaException exception = new FechaInvalidaException(mensaje);
        
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void deberiaCrearExcepcionConMensajeYCausa() {
        String mensaje = "Error en fechas";
        Throwable causa = new IllegalArgumentException("Causa original");
        
        FechaInvalidaException exception = new FechaInvalidaException(mensaje, causa);
        
        assertEquals(mensaje, exception.getMessage());
        assertEquals(causa, exception.getCause());
    }
}
