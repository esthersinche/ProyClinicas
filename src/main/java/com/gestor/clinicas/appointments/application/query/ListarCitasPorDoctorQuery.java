package com.gestor.clinicas.appointments.application.query;

/**
 * Query para listar citas de un doctor específico
 */
public class ListarCitasPorDoctorQuery {
    private Long doctorId;
    private String estado; // PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA (opcional)
    
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
