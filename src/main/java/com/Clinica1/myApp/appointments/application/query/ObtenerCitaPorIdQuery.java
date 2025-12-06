package com.Clinica1.myApp.appointments.application.query;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.Getter;

@Getter
public class ObtenerCitaPorIdQuery {

    private final IDEntidad citaId;

    public ObtenerCitaPorIdQuery(IDEntidad citaId) {
        if (citaId == null) {
            throw new IllegalArgumentException("El ID de la cita es obligatorio");
        }
        this.citaId = citaId;
    }
}