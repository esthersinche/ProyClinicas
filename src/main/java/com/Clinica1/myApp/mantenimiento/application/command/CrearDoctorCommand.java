package com.Clinica1.myApp.mantenimiento.application.command;

import java.util.List;

public class CrearDoctorCommand {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String cmp;
    private String consultorio;
    private List<String> especialidades;

    public CrearDoctorCommand(String nombre, String apellido, String telefono,
                              String email, String cmp, String consultorio,
                              List<String> especialidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.cmp = cmp;
        this.consultorio = consultorio;
        this.especialidades = especialidades;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCmp() {
        return cmp;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }
}
