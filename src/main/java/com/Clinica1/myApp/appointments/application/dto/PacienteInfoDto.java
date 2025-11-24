package com.Clinica1.myApp.appointments.application.dto;

public class PacienteInfoDto {
    private String nombre;
    private String dni;

    public PacienteInfoDto(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public PacienteInfoDto() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}