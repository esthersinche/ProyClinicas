package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.time.LocalDateTime;
import java.util.UUID;

public class ModificarCitaCommand {

    private final IDEntidad citaId;
    private final String motivo;
    private final LocalDateTime inicio;
    private final LocalDateTime fin;
    private final IDEntidad doctorId;  // opcional

    public ModificarCitaCommand(
            IDEntidad citaId,
            String motivo,
            LocalDateTime inicio,
            LocalDateTime fin,
            IDEntidad doctorId
    ) {
        this.citaId = citaId;
        this.motivo = motivo;
        this.inicio = inicio;
        this.fin = fin;
        this.doctorId = doctorId;
    }

    public IDEntidad getCitaId() {
        return citaId;
    }

    public String getMotivo() {
        return motivo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public IDEntidad getDoctorId() {
        return doctorId;
    }
}