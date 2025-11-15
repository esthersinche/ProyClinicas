package com.gestor.clinicas.appointments.application.exception;

/**
 * Excepción lanzada cuando no se encuentra una cita
 */
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
