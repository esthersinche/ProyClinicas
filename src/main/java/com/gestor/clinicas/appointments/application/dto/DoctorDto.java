package com.gestor.clinicas.appointments.application.dto;

import java.util.List;

/**
 * DTO para transferir datos de un doctor
 */
public class DoctorDto {
    private Long id;
    private String nombre;
    private String cmp;
    private String consultorio;
    private List<String> especialidades;

    // Constructor vacío
    public DoctorDto() {
    }

    // Constructor completo
    public DoctorDto(Long id, String nombre, String cmp, String consultorio, 
                    List<String> especialidades) {
        this.id = id;
        this.nombre = nombre;
        this.cmp = cmp;
        this.consultorio = consultorio;
        this.especialidades = especialidades;
    }

    // Getters y Setters
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
}
