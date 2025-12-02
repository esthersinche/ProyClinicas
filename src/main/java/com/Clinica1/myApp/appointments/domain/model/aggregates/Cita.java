package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.*;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cita {
    private IDEntidad id_cita;
    private String motivo_cita;
    private Estado estado_cita;
    private Canal canal_cita;
    private LocalDateTime inicio_cita; //cambiar a date y hora typeshi, luego cambiar a VO
    private LocalDateTime fin_cita;//luego cambiar a VO

    //referencias a paciente y doctor
    private IDEntidad pac_id;
    private IDEntidad doc_id;

    //otros, cambios 221125
    private Pac_info_cita inst_pac; //nombres, dni
    private Doc_info_cita inst_doctor; //nombre, especialidad, consultorio por ahora
    private Especialidad espe_cita;// por si acaso

    public Cita() {//jpa
    }

    public Cita(IDEntidad id_cita, String motivo_cita, Estado estado_cita, Canal canal_cita,
                LocalDateTime inicio_cita, LocalDateTime fin_cita, IDEntidad pac_id, IDEntidad doc_id,
                Pac_info_cita inst_pac, Doc_info_cita inst_doctor, Especialidad espe_cita) {
        this.id_cita = id_cita;
        this.motivo_cita = motivo_cita;
        this.estado_cita = estado_cita;
        this.canal_cita = canal_cita;
        this.inicio_cita = inicio_cita;
        this.fin_cita = fin_cita;
        this.pac_id = pac_id;
        this.doc_id = doc_id;
        this.inst_pac = inst_pac;
        this.inst_doctor = inst_doctor;
        this.espe_cita = espe_cita;
    }

    //factory pq builder m da miedo
    public static Cita crearcita(
            String motivo_cita,
            Canal canal_cita,
            LocalDateTime inicio_cita,
            LocalDateTime fin_cita,
            Paciente pac_cita,
            Doctor doc_cita,
            Especialidad espe_cita
    ) {

        // 1. Construir VO del paciente
        Pac_info_cita pacInfo = new Pac_info_cita(
                pac_cita.getNombre_com_pac(),
                pac_cita.getDni_pac()
        );

        // 2. Obtener la especialidad principal del doctor
        String especialidadDoctor = doc_cita.getEspecialidades() != null
                && !doc_cita.getEspecialidades().isEmpty()
                ? doc_cita.getEspecialidades().get(0).nom_espe()
                : "Sin especialidad";

        // 3. Construir VO del doctor
        Doc_info_cita docInfo = Doc_info_cita.of(
                doc_cita.getNom_com_doc().completar(),
                especialidadDoctor,
                doc_cita.getConsultorio_doc()
        );

        // 4. Crear entidad cita final
        return new Cita(
                IDEntidad.generar(),
                motivo_cita,
                Estado.Pendiente,
                canal_cita,
                inicio_cita,
                fin_cita,
                pac_cita.getId_pac(),
                doc_cita.getId_doc(),
                pacInfo,
                docInfo,
                espe_cita
        );
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

    public IDEntidad getPac_id() {
        return pac_id;
    }

    public IDEntidad getDoc_id() {
        return doc_id;
    }

    public Pac_info_cita getInst_pac() {
        return inst_pac;
    }

    public Doc_info_cita getInst_doctor() {
        return inst_doctor;
    }

    public Especialidad getEspe_cita() {
        return espe_cita;
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


    public void modificar(String motivo_cita, LocalDateTime inicio_cita, LocalDateTime fin_cita) {
        this.motivo_cita = motivo_cita;
        this.inicio_cita = inicio_cita;
        this.fin_cita = fin_cita;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.espe_cita = especialidad;
    }
}
