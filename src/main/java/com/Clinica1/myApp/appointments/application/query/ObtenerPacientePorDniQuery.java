package com.Clinica1.myApp.appointments.application.query;

public class ObtenerPacientePorDniQuery {
    private final String dni;

    public ObtenerPacientePorDniQuery(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }
}