package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Canal;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.Objects;

public class Cita {
    private IDEntidad id_cita;
    private String motivo_cita;
    private Estado estado_cita;
    private Canal canal_cita;
    private LocalDateTime inicio_cita; //cambiar a date y hora typeshi, luego cambiar a VO
    private LocalDateTime fin_cita;//luego cambiar a VO

    //otros
    private Paciente inst_pac; //nombres, dni
    private Doctor inst_doctor; //nombre, especialidad, consultorio por ahora
    private Especialidad espe_cita;// por si acaso
    private Clinica inst_clin; //nombre
    private Direccion dir_clin_cita;

    public Cita() {//jpa
    }

    public Cita(IDEntidad id_cita, String motivo_cita, Estado estado_cita, Canal canal_cita, LocalDateTime inicio_cita,
                LocalDateTime fin_cita, Paciente inst_pac, Doctor inst_doctor, Especialidad espe_cita,
                Clinica inst_clin, Direccion dir_clin_cita) {
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

    //factory pq builder m da miedo
    public static Cita crearcita(String motivo_cita, Canal canal_cita, LocalDateTime inicio_cita,
                                 LocalDateTime fin_cita, Paciente inst_pac, Doctor inst_doctor, Especialidad espe_cita,
                                 Clinica inst_clin, Direccion dir_clin_cita){
        return new Cita(IDEntidad.generar(), motivo_cita, Estado.Pendiente, canal_cita, inicio_cita, fin_cita,
                inst_pac, inst_doctor, espe_cita, inst_clin, dir_clin_cita);

    }

    public IDEntidad getId_cita() {
        return id_cita;
    }

    public String getMotivo_cita() {
        return motivo_cita;
    }

    public Estado getEstado_cita() {
        return estado_cita;
    }

    public Canal getCanal_cita() {
        return canal_cita;
    }

    public LocalDateTime getInicio_cita() {
        return inicio_cita;
    }

    public LocalDateTime getFin_cita() {
        return fin_cita;
    }

    public Paciente getInst_pac() {
        return inst_pac;
    }

    public Doctor getInst_doctor() {
        return inst_doctor;
    }

    public Especialidad getEspe_cita() {
        return espe_cita;
    }

    public Clinica getInst_clin() {
        return inst_clin;
    }

    public Direccion getDir_clin_cita() {
        return dir_clin_cita;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita = (Cita) o;
        return Objects.equals(getId_cita(), cita.getId_cita());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_cita());
    }
}
