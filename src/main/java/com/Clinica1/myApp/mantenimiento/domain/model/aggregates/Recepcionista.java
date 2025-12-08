package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Recepcionista {
    private IDEntidad id_recep;
    private IDEntidad id_emp;

    public Recepcionista() {
    }

    public Recepcionista(IDEntidad id_recep, IDEntidad id_emp) {
        this.id_recep = id_recep;
        this.id_emp = id_emp;
    }

    //factory
    public static Recepcionista crearrecep(IDEntidad id_emp){
        return new Recepcionista(IDEntidad.generar(), id_emp);
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
