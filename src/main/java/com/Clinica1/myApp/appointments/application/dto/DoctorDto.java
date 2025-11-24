package com.Clinica1.myApp.appointments.application.dto;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import java.util.Collection;
import java.util.List;

public class DoctorDto {
    private String  id;
    private String nombre;
    private String cmp;
    private String consultorio;
    private List<String> especialidades;

    public DoctorDto() {
    }

    public DoctorDto(String  id, String nombre, String cmp, String consultorio,
                     List<String> especialidades) {
        this.id = id;
        this.nombre = nombre;
        this.cmp = cmp;
        this.consultorio = consultorio;
        this.especialidades = especialidades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
