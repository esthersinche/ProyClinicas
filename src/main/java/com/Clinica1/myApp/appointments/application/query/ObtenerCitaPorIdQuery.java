package com.Clinica1.myApp.appointments.application.query;

public class ObtenerCitaPorIdQuery {
    private Long citaId;

    public ObtenerCitaPorIdQuery(Long citaId) {
        this.citaId = citaId;
    }

    public Long getCitaId() {
        return citaId;
    }
}
