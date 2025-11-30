package com.Clinica1.myApp.appointments.application.exception;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class CitaNoEncontradaException extends Exception {
    
    public CitaNoEncontradaException(IDEntidad mensaje) {
        super(mensaje);
    }

    public CitaNoEncontradaException(IDEntidad citaId) {
        super("No se encontró la cita con ID: " + citaId);
    }

    public CitaNoEncontradaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
