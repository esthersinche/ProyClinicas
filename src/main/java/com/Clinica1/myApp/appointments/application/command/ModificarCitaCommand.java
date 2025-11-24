package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.time.LocalDateTime;
import java.util.UUID;

public class ModificarCitaCommand {
    private IDEntidad citaId;
    private String motivo;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private IDEntidad doctorId;
    private String especialidad;

    public ModificarCitaCommand(IDEntidad citaId, String motivo, LocalDateTime inicio,
                               LocalDateTime fin, IDEntidad doctorId, String especialidad) {
        this.citaId = citaId;
        this.motivo = motivo;
        this.inicio = inicio;
        this.fin = fin;
        this.doctorId = doctorId;
        this.especialidad = especialidad;
    }

    public ModificarCitaCommand(IDEntidad citaId, Object motivo, LocalDateTime inicio, LocalDateTime fin) {
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

    public String getEspecialidad() {
        return especialidad;
    }
}
