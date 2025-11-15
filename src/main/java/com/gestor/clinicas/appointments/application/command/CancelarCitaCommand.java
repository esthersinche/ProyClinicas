package com.gestor.clinicas.appointments.application.command;

/**
 * Command para cancelar una cita existente
 */
public class CancelarCitaCommand {
    private Long citaId;
    private String motivoCancelacion;

    public CancelarCitaCommand(Long citaId, String motivoCancelacion) {
        this.citaId = citaId;
        this.motivoCancelacion = motivoCancelacion;
    }

    public Long getCitaId() {
        return citaId;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }
}
