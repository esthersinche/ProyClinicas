package com.Clinica1.myApp.appointments.application.query;

public class ObtenerCitaPorIdQuery {
    private String citaId;

    public ObtenerCitaPorIdQuery(String citaId) {
        this.citaId = citaId;
    }

    public String getCitaId() {
        return citaId;
    }
}
