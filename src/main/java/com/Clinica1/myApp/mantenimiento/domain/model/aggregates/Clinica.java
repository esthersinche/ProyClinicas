package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;

import java.util.List;
import java.util.Objects;

public class Clinica {
    private IDEntidad id_clinica;
    private String nombre_cli;
    private Direccion dir_cli;
    private String ruc_cli;//no editable
    List<Empleado> emp_cli;

    public Clinica() {
    }

    public Clinica(IDEntidad id_clinica, String nombre_cli, Direccion dir_cli, String ruc_cli, List<Empleado> emp_cli) {
        this.id_clinica = id_clinica;
        this.nombre_cli = nombre_cli;
        this.dir_cli = dir_cli;
        this.ruc_cli = ruc_cli;
        this.emp_cli = emp_cli;
    }

    //factory
    public static Clinica crearclinica(String nombre_cli, Direccion dir_cli, String ruc_cli, List<Empleado> emp_cli){
        return new Clinica(IDEntidad.generar(), nombre_cli, dir_cli, ruc_cli, emp_cli);
    }

    public IDEntidad getId_clinica() {
        return id_clinica;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public Direccion getDir_cli() {
        return dir_cli;
    }

    public String getRuc_cli() {
        return ruc_cli;
    }

    public List<Empleado> getEmp_cli() {
        return emp_cli;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clinica clinica = (Clinica) o;
        return Objects.equals(getId_clinica(), clinica.getId_clinica());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_clinica());
    }
}
