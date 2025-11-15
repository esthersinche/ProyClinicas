package com.gestor.clinicas.appointments.application.query;

/**
 * Query para obtener una cita por su ID
 */
public class ObtenerCitaPorIdQuery {
    private Long citaId;

    public ObtenerCitaPorIdQuery(Long citaId) {
        this.citaId = citaId;
    }

    public Long getCitaId() {
        return citaId;
    }
}
