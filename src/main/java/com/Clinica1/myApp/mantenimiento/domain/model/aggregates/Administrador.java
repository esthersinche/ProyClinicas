package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Administrador {
    private IDEntidad id_admin;
    private IDEntidad id_emp;

    public Administrador() {
    }

    public Administrador(IDEntidad id_admin, IDEntidad id_emp) {
        this.id_admin = id_admin;
        this.id_emp = id_emp;
    }

    //factory
    public static Administrador crearadmin(IDEntidad id_emp){
        return new Administrador(IDEntidad.generar(), id_emp);
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
