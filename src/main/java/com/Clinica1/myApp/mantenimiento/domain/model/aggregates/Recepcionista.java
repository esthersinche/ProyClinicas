package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Recepcionista {

    private IDEntidad id_recep;
    private IDEntidad id_emp;

    protected Recepcionista() {}

    private Recepcionista(IDEntidad id_recep, IDEntidad id_emp) {
        this.id_recep = id_recep;
        this.id_emp = id_emp;
    }

    // ---------- FACTORY ----------
    public static Recepcionista crear(IDEntidad id_emp) {
        if (id_emp == null)
            throw new IllegalArgumentException("El ID del empleado es obligatorio");

        return new Recepcionista(IDEntidad.generar(), id_emp);
    }

    // ---------- RECONSTRUCCIÓN ----------
    public static Recepcionista reconstruir(
            IDEntidad id_recep,
            IDEntidad id_emp
    ) {
        return new Recepcionista(id_recep, id_emp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recepcionista)) return false;
        Recepcionista that = (Recepcionista) o;
        return Objects.equals(id_recep, that.id_recep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_recep);
    }
}