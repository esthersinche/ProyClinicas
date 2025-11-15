package com.gestor.clinicas.appointments.application.exception;

/**
 * Excepción lanzada cuando se intenta crear o modificar una cita con fechas inválidas
 */
public class FechaInvalidaException extends Exception {
    
    public FechaInvalidaException(String mensaje) {
        super(mensaje);
    }

    public FechaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
