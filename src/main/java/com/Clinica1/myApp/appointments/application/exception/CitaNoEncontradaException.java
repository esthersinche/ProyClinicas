package com.Clinica1.myApp.appointments.application.exception;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class CitaNoEncontradaException extends Exception {

    public CitaNoEncontradaException(IDEntidad id) {
        super("No se encontró la cita con ID: " + id.toString());
    }

    public CitaNoEncontradaException(String mensaje) {
        super(mensaje);
    }

    public CitaNoEncontradaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
