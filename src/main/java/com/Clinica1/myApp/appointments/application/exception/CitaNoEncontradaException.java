package com.Clinica1.myApp.appointments.application.exception;

public class CitaNoEncontradaException extends Exception {
    
    public CitaNoEncontradaException(String mensaje) {
        super(mensaje);
    }

    public CitaNoEncontradaException(Long citaId) {
        super("No se encontró la cita con ID: " + citaId);
    }

    public CitaNoEncontradaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
