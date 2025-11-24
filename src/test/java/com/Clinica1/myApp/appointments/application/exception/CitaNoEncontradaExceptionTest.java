package com.Clinica1.myApp.appointments.application.exception;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CitaNoEncontradaExceptionTest {

    @Test
    void deberiaCrearExcepcionConMensaje() {
        CitaNoEncontradaException ex = new CitaNoEncontradaException("Cita no encontrada");
        assertEquals("Cita no encontrada", ex.getMessage());
    }

    @Test
    void deberiaCrearExcepcionConId() {
        IDEntidad citaId = IDEntidad.generar();
        CitaNoEncontradaException ex = new CitaNoEncontradaException(citaId);
        assertEquals("No se encontró la cita con ID: " + citaId, ex.getMessage());
    }

    @Test
    void deberiaCrearExcepcionConMensajeYCausa() {
        Throwable causa = new RuntimeException("Causa");
        CitaNoEncontradaException ex = new CitaNoEncontradaException("Cita no encontrada", causa);
        assertEquals("Cita no encontrada", ex.getMessage());
        assertEquals(causa, ex.getCause());
    }
}
