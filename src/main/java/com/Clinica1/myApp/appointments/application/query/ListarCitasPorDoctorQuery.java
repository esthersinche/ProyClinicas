package com.Clinica1.myApp.appointments.application.query;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class ListarCitasPorDoctorQuery {
    private String doctorId;
    private String estado;
    
    public ListarCitasPorDoctorQuery(String doctorId) {
        this.doctorId = doctorId;
    }

    public ListarCitasPorDoctorQuery(String doctorId, String estado) {
        this.doctorId = doctorId;
        this.estado = estado;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getEstado() {
        return estado;
    }
}
