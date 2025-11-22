package com.Clinica1.myApp.appointments.application.dto;

import java.util.Collection;
import java.util.List;

public class DoctorDto {
    private Long id;
    private String nombre;
    public String cmp;
    public String consultorio;
    public List<String> especialidades;

    public DoctorDto() {
    }

    public DoctorDto(Long id, String nombre, String cmp, String consultorio, 
                    List<String> especialidades) {
        this.id = id;
        this.nombre = nombre;
        this.cmp = cmp;
        this.consultorio = consultorio;
        this.especialidades = especialidades;
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

    public String getCmp() {
        return cmp;
    }

    public void setCmp(String cmp) {
        this.cmp = cmp;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }

    public String nombreCompleto() {
        return "";
    }

    public String cmp() {
        return "";
    }

    public String consultorio() {
        return "";
    }

    public Collection<Object> especialidades() {
        return List.of();
    }
}
