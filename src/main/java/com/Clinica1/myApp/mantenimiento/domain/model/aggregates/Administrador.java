package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Administrador {

    private IDEntidad id_admin;
    private IDEntidad id_emp;


    protected Administrador() {
    }

    private Administrador(
            IDEntidad id_admin,
            IDEntidad id_emp
    ) {
        this.id_admin = id_admin;
        this.id_emp = id_emp;
    }

    // ---------- FACTORY (CREACIÓN) ----------
    public static Administrador crear(
            IDEntidad id_emp
    ) {
        if (id_emp == null)
            throw new IllegalArgumentException("El ID del empleado es obligatorio");

        return new Administrador(
                IDEntidad.generar(),
                id_emp
        );
    }


    // ---------- RECONSTRUCCIÓN (PERSISTENCIA) ----------
    public static Administrador reconstruir(
            IDEntidad id_admin,
            IDEntidad id_emp
    ) {
        return new Administrador(id_admin, id_emp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrador)) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(id_admin, that.id_admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_admin);
    }
}