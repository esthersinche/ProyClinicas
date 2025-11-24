package com.Clinica1.myApp.appointments.application.dto;

import java.time.LocalDateTime;

public class CitaDto {
    private String  id;
    public String motivo;
    public String estado;
    public String canal;
    public LocalDateTime inicio;
    public LocalDateTime fin;
    public PacienteInfoDto  paciente;
    public DoctorInfoDto  doctor;
    private String clinica;
    public String especialidad;

    public CitaDto() {
    }

    public CitaDto(String id, String motivo, String estado, String canal,
                   LocalDateTime inicio, LocalDateTime fin, PacienteInfoDto paciente,
                   DoctorInfoDto  doctor, String clinica, String especialidad) {
        this.id = id;
        this.motivo = motivo;
        this.estado = estado;
        this.canal = canal;
        this.inicio = inicio;
        this.fin = fin;
        this.paciente = paciente;
        this.doctor = doctor;
        this.clinica = clinica;
        this.especialidad = especialidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public PacienteInfoDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteInfoDto paciente) {
        this.paciente = paciente;
    }

    public DoctorInfoDto  getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorInfoDto  doctor) {
        this.doctor = doctor;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


}
