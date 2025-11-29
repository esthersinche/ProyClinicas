package com.Clinica1.myApp.mantenimiento.domain.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;

import java.util.List;
import java.util.Objects;

public class Admin {
    private IDEntidad idemp_ad;
    private IDEntidad id_admin;
    private String nombrecom;

    public Admin() {
    }

    public Admin(IDEntidad idemp_ad, IDEntidad id_admin, String nombrecom) {
        this.idemp_ad = idemp_ad;
        this.id_admin = id_admin;
        this.nombrecom = nombrecom;
    }

    public static Admin crearadmin(IDEntidad idemp_ad, IDEntidad id_admin, String nombrecom){
        return new Admin(idemp_ad, IDEntidad.generar(), nombrecom);

    }



    public IDEntidad getIdemp_ad() {
        return idemp_ad;
    }

    public IDEntidad getId_admin() {
        return id_admin;
    }

    public String getNombrecom() {
        return nombrecom;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(getId_admin(), admin.getId_admin());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_admin());
    }
}
