package com.Clinica1.myApp.appointments.application.command;

import java.time.LocalDateTime;

public class ModificarCitaCommand {
    private Long citaId;
    private String motivo;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Long doctorId;
    private String especialidad;

    public ModificarCitaCommand(Long citaId, String motivo, LocalDateTime inicio, 
                               LocalDateTime fin, Long doctorId, String especialidad) {
        this.citaId = citaId;
        this.motivo = motivo;
        this.inicio = inicio;
        this.fin = fin;
        this.doctorId = doctorId;
        this.especialidad = especialidad;
    }

    public Long getCitaId() {
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

    public Long getDoctorId() {
        return doctorId;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
