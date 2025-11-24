package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.time.LocalDateTime;

public class CrearCitaCommand {
    private String motivo;
    private String canal;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private IDEntidad pacienteId;
    private IDEntidad doctorId;
    private IDEntidad clinicaId;
    private String especialidad;

    public CrearCitaCommand(String motivo, String canal, LocalDateTime inicio, LocalDateTime fin,
                            IDEntidad pacienteId, IDEntidad doctorId, IDEntidad clinicaId, String especialidad) {
        this.motivo = motivo;
        this.canal = canal;
        this.inicio = inicio;
        this.fin = fin;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.clinicaId = clinicaId;
        this.especialidad = especialidad;
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

    public IDEntidad getClinicaId() {
        return clinicaId;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
