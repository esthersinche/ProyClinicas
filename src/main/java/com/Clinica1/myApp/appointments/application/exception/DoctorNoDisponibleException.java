package com.Clinica1.myApp.appointments.application.exception;

public class DoctorNoDisponibleException extends Exception {
    
    public DoctorNoDisponibleException(String mensaje) {
        super(mensaje);
    }

    public DoctorNoDisponibleException(Long doctorId, String fecha) {
        super("El doctor con ID " + doctorId + " no está disponible para la fecha: " + fecha);
    }

    public DoctorNoDisponibleException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
