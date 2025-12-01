package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class CancelarCitaCommand {
    private IDEntidad citaId;
    private String motivoCancelacion;

    public CancelarCitaCommand(IDEntidad citaId) {
        this.citaId = citaId;

    }

    public IDEntidad getCitaId() {
        return citaId;
    }

}
