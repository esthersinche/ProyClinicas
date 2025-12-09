package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Administrador {
    private IDEntidad id_admin;
    private IDEntidad id_emp;
    private NombreCompleto nomcom_admin;

    public Administrador() {
    }

    public Administrador(IDEntidad id_admin, IDEntidad id_emp, NombreCompleto nomcom_admin) {
        this.id_admin = id_admin;
        this.id_emp = id_emp;
        this.nomcom_admin = nomcom_admin;
    }

    //factory
    public static Administrador crearadmin(IDEntidad id_emp, String nom_admin, String ape_admin){
        return new Administrador(IDEntidad.generar(), id_emp, NombreCompleto.of(nom_admin, ape_admin));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(getId_admin(), that.getId_admin());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_admin());
    }
}
