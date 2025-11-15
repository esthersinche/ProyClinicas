package com.Clinica1.myApp.appointments.application.query;

public class ListarCitasPorEspecialidadQuery {
    private String especialidad;
    private String estado;

    public ListarCitasPorEspecialidadQuery(String especialidad) {
        this.especialidad = especialidad;
    }

    public ListarCitasPorEspecialidadQuery(String especialidad, String estado) {
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getEstado() {
        return estado;
    }
}
