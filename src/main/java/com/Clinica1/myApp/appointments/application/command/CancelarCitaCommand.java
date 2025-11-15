package com.Clinica1.myApp.appointments.application.command;

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
