package com.Clinica1.myApp.appointments.application.dto;

public class DoctorInfoDto {
    private String nombre;
    private String especialidad;
    private String consultorio;

    public DoctorInfoDto(String nombre, String especialidad, String consultorio) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
    }

    public DoctorInfoDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }
}