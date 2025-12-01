package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.time.LocalDateTime;
import java.util.UUID;

public class ModificarCitaCommand {

    private final IDEntidad citaId;
    private final LocalDateTime inicio;
    private final LocalDateTime fin;
   // opcional

    public ModificarCitaCommand(
            IDEntidad citaId,
            LocalDateTime inicio,
            LocalDateTime fin
    ) {
        this.citaId = citaId;
        this.inicio = inicio;
        this.fin = fin;
    }

    public IDEntidad getCitaId() {
        return citaId;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

}