package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public class CrearCitaCommand {
    private IDEntidad pacienteId;
    private IDEntidad doctorId;
    private String motivo;
    private String especialidad;
    private String canal;
    private LocalDateTime inicio;
    private LocalDateTime fin;

    public CrearCitaCommand(IDEntidad pacienteId, IDEntidad doctorId, String motivo,
                            String especialidad, String canal,
                            LocalDateTime inicio, LocalDateTime fin) {
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.motivo = motivo;
        this.especialidad = especialidad;
        this.canal = canal;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getCanal() {
        return canal;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public IDEntidad getPacienteId() {
        return pacienteId;
    }

    public IDEntidad getDoctorId() {
        return doctorId;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
