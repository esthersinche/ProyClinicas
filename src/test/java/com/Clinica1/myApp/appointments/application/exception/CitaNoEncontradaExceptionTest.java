package com.Clinica1.myApp.appointments.application.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CitaNoEncontradaExceptionTest {

    @Test
    void deberiaCrearExcepcionConMensaje() {
        String mensaje = "Cita no encontrada";
        CitaNoEncontradaException exception = new CitaNoEncontradaException(mensaje);
        
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void deberiaCrearExcepcionConId() {
        Long citaId = 123L;
        CitaNoEncontradaException exception = new CitaNoEncontradaException(citaId);
        
        assertTrue(exception.getMessage().contains("123"));
    }

    @Test
    void deberiaCrearExcepcionConMensajeYCausa() {
        String mensaje = "Error al buscar cita";
        Throwable causa = new RuntimeException("Causa original");
        
        CitaNoEncontradaException exception = new CitaNoEncontradaException(mensaje, causa);
        
        assertEquals(mensaje, exception.getMessage());
        assertEquals(causa, exception.getCause());
    }
}
