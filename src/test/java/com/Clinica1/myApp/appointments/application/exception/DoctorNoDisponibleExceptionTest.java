package com.Clinica1.myApp.appointments.application.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorNoDisponibleExceptionTest {

    @Test
    void deberiaCrearExcepcionConMensaje() {
        String mensaje = "Doctor no disponible";
        DoctorNoDisponibleException exception = new DoctorNoDisponibleException(mensaje);
        
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void deberiaCrearExcepcionConDoctorIdYFecha() {
        Long doctorId = 456L;
        String fecha = "2025-11-21";
        
        DoctorNoDisponibleException exception = new DoctorNoDisponibleException(doctorId, fecha);
        
        assertTrue(exception.getMessage().contains("456"));
        assertTrue(exception.getMessage().contains("2025-11-21"));
    }

    @Test
    void deberiaCrearExcepcionConMensajeYCausa() {
        String mensaje = "Error de disponibilidad";
        Throwable causa = new RuntimeException("Causa original");
        
        DoctorNoDisponibleException exception = new DoctorNoDisponibleException(mensaje, causa);
        
        assertEquals(mensaje, exception.getMessage());
        assertEquals(causa, exception.getCause());
    }
}
