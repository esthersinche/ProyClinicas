package com.Clinica1.myApp.appointments.application.query;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class ObtenerCitaPorIdQuery {
    private IDEntidad citaId;

    public ObtenerCitaPorIdQuery(IDEntidad citaId) {
        this.citaId = citaId;
    }

    public IDEntidad getCitaId() {
        return citaId;
    }
}
