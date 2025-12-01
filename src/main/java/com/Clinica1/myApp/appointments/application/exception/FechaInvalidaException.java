package com.Clinica1.myApp.appointments.application.exception;

public class FechaInvalidaException extends RuntimeException {
    
    public FechaInvalidaException(String mensaje) {
        super(mensaje);
    }

    public FechaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
