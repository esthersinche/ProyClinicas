package com.Clinica1.myApp.appointments.application.query;

public class ListarCitasPorDoctorQuery {
    private Long doctorId;
    private String estado;
    
    public ListarCitasPorDoctorQuery(Long doctorId) {
        this.doctorId = doctorId;
    }

    public ListarCitasPorDoctorQuery(Long doctorId, String estado) {
        this.doctorId = doctorId;
        this.estado = estado;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public String getEstado() {
        return estado;
    }
}
