package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Nombrecompleto;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Administrador {

    private IDEntidad id_admin;
    private IDEntidad id_emp;
    private Nombrecompleto nomcom_admin;

    protected Administrador() {
    }

    private Administrador(
            IDEntidad id_admin,
            IDEntidad id_emp,
            Nombrecompleto nomcom_admin
    ) {
        this.id_admin = id_admin;
        this.id_emp = id_emp;
        this.nomcom_admin = nomcom_admin;
    }

    // ---------- FACTORY (CREACIÓN) ----------
    public static Administrador crear(
            IDEntidad id_emp,
            String nombre,
            String apellido
    ) {
        if (id_emp == null)
            throw new IllegalArgumentException("El ID del empleado es obligatorio");

        return new Administrador(
                IDEntidad.generar(),
                id_emp,
                Nombrecompleto.of(nombre, apellido)
        );
    }

    // ---------- RECONSTRUCCIÓN (PERSISTENCIA) ----------
    public static Administrador reconstruir(
            IDEntidad id_admin,
            IDEntidad id_emp,
            Nombrecompleto nombreCompleto
    ) {
        return new Administrador(id_admin, id_emp, nombreCompleto);
    }

    // ---------- COMPORTAMIENTO ----------
    public void actualizarNombre(String nombre, String apellido) {
        this.nomcom_admin = Nombrecompleto.of(nombre, apellido);
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