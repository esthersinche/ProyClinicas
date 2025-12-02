package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;

import java.util.Objects;

public class Recepcionista {
    private IDEntidad id_emp;
    private IDEntidad id_recep;
    private NombreCompleto nom_recep;

    public Recepcionista() {
    }

    public Recepcionista(IDEntidad id_emp, IDEntidad id_recep, NombreCompleto nom_recep) {
        this.id_emp = id_emp;
        this.id_recep = id_recep;
        this.nom_recep = nom_recep;
    }

    public static Recepcionista crearrecepcionista(IDEntidad id_emp, IDEntidad id_recep, NombreCompleto nom_recep){
        return new Recepcionista(id_emp, IDEntidad.generar(), nom_recep);
    }

    public IDEntidad getId_emp() {
        return id_emp;
    }

    public IDEntidad getId_recep() {
        return id_recep;
    }

    public NombreCompleto getNom_recep() {
        return nom_recep;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recepcionista that = (Recepcionista) o;
        return Objects.equals(getId_recep(), that.getId_recep());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_recep());
    }
}
