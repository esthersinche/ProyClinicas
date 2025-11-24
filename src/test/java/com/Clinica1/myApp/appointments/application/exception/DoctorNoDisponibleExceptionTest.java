package com.Clinica1.myApp.appointments.application.exception;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorNoDisponibleExceptionTest {

    @Test
    void doctorNoDisponibleExceptionMensajeCorrecto() {
        DoctorNoDisponibleException ex = new DoctorNoDisponibleException("Doctor no disponible");
        assertEquals("Doctor no disponible", ex.getMessage());
    }

    @Test
    void doctorNoDisponibleExceptionConId() {
        IDEntidad doctorId = IDEntidad.generar();
        String fecha = "2025-11-24";
        DoctorNoDisponibleException ex = new DoctorNoDisponibleException(doctorId, fecha);
        assertEquals("El doctor con ID " + doctorId + " no está disponible para la fecha: " + fecha,
                ex.getMessage());
    }

    @Test
    void doctorNoDisponibleExceptionConCausa() {
        Throwable causa = new RuntimeException("Causa");
        DoctorNoDisponibleException ex = new DoctorNoDisponibleException("Doctor no disponible", causa);
        assertEquals("Doctor no disponible", ex.getMessage());
        assertEquals(causa, ex.getCause());
    }
}
