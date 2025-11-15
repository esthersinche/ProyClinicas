package com.gestor.clinicas.appointments.application.command;

import java.time.LocalDateTime;

/**
 * Command para crear una nueva cita
 */
public class CrearCitaCommand {
    private String motivo;
    private String canal;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Long pacienteId;
    private Long doctorId;
    private Long clinicaId;
    private String especialidad;

    public CrearCitaCommand(String motivo, String canal, LocalDateTime inicio, LocalDateTime fin, 
                           Long pacienteId, Long doctorId, Long clinicaId, String especialidad) {
        this.motivo = motivo;
        this.canal = canal;
        this.inicio = inicio;
        this.fin = fin;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.clinicaId = clinicaId;
        this.especialidad = especialidad;
    }

    // Getters
    public String getMotivo() {
        return motivo;
    }

    public String getCanal() {
        return canal;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Long getClinicaId() {
        return clinicaId;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
