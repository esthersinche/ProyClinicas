package com.Clinica1.myApp.appointments.application.exception;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class DoctorNoDisponibleException extends Exception {
    
    public DoctorNoDisponibleException(String mensaje) {
        super(mensaje);
    }

    public DoctorNoDisponibleException(IDEntidad doctorId, String fecha) {
        super("El doctor con ID " + doctorId + " no está disponible para la fecha: " + fecha);
    }

    public DoctorNoDisponibleException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
