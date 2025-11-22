package com.Clinica1.myApp.appointments.application.dto;

public class PacienteDto {
    private Long id;
    public String nombre;
    public String nacionalidad;
    public String dni;
    public String telefono;
    public String email;

    public PacienteDto() {
    }

    public PacienteDto(Long id, String nombre, String nacionalidad, String dni, 
                      String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String nombre() {
        return "";
    }

    public String nacionalidad() {
        return "";
    }

    public String dni() {
        return "";
    }

    public String telefono() {
        return "";
    }

    public String email() {
        return "";
    }
}
