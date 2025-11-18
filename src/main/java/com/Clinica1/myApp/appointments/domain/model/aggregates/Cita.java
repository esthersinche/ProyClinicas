package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Cita {
    private IDEntidad id_cita;
    private String motivo_cita;
    private Estado estado_cita;
    private String canal_cita;
    private LocalDateTime inicio_cita; //cambiar a date y hora typeshi
    private LocalDateTime fin_cita;

    //otros
    private Paciente inst_pac; //nombres, dni
    private Doctor inst_doctor; //nombre, especialidad, consultorio por ahora
    private Especialidad espe_cita;// por si acaso
    private Clinica inst_clin; //nombre
    private Direccion dir_clin_cita;

    public Cita() {
    }

    public Cita(IDEntidad id_cita, String motivo_cita, Estado estado_cita, String canal_cita,
                LocalDateTime inicio_cita, LocalDateTime fin_cita, Paciente inst_pac, Doctor inst_doctor,
                Especialidad espe_cita, Clinica inst_clin, Direccion dir_clin_cita) {
        this.id_cita = id_cita;
        this.motivo_cita = motivo_cita;
        this.estado_cita = estado_cita;
        this.canal_cita = canal_cita;
        this.inicio_cita = inicio_cita;
        this.fin_cita = fin_cita;
        this.inst_pac = inst_pac;
        this.inst_doctor = inst_doctor;
        this.espe_cita = espe_cita;
        this.inst_clin = inst_clin;
        this.dir_clin_cita = dir_clin_cita;
    }




}
