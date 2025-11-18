package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;

import java.util.List;
import java.util.Objects;

public class Clinica {
    private IDEntidad id_cli;
    private String nom_clin;
    private Direccion dir_clin;
    private List<Doctor> doctorescli;
    private List<Paciente> pacientescli;

    public Clinica() {
    }

    public Clinica(IDEntidad id_cli, String nom_clin, Direccion dir_clin, List<Doctor> doctorescli, List<Paciente> pacientescli) {
        this.id_cli = id_cli;
        this.nom_clin = nom_clin;
        this.dir_clin = dir_clin;
        this.doctorescli = doctorescli;
        this.pacientescli = pacientescli;
    }

    public IDEntidad getId_cli() {
        return id_cli;
    }

    public String getNom_clin() {
        return nom_clin;
    }

    public Direccion getDir_clin() {
        return dir_clin;
    }

    public List<Doctor> getDoctorescli() {
        return doctorescli;
    }

    public List<Paciente> getPacientescli() {
        return pacientescli;
    }

    //por el momento, ya q esto debe ir en otro lado

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clinica clinica = (Clinica) o;
        return Objects.equals(id_cli, clinica.id_cli);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_cli);
    }
}
