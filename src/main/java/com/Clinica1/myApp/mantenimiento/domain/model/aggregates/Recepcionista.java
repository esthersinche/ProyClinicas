package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Recepcionista {
    private IDEntidad id_recep;
    private IDEntidad id_emp;
    private NombreCompleto nomcom_recep;

    public Recepcionista() {
    }

    public Recepcionista(IDEntidad id_recep, IDEntidad id_emp, NombreCompleto nomcom_recep) {
        this.id_recep = id_recep;
        this.id_emp = id_emp;
        this.nomcom_recep = nomcom_recep;
    }

    //factory
    public static Recepcionista crearrecep(IDEntidad id_emp, String nom_recep, String ape_recep){
        return new Recepcionista(IDEntidad.generar(), id_emp, NombreCompleto.of(nom_recep, ape_recep));
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
