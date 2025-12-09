package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;

import java.util.Objects;

public class EmpleadoIAM {
    private IDEntidad id_empiam;
    private String nom_empiam;
    private String ape_empiam;
    private Email email_empiam;
    private String passhash_empiam;//puede ser null
    private Roles rol_empiam;

    public EmpleadoIAM(IDEntidad id_empiam, String nom_empiam, String ape_empiam, Email email_empiam, String passhash_empiam, Roles rol_empiam) {
        this.id_empiam = id_empiam;
        this.nom_empiam = nom_empiam;
        this.ape_empiam = ape_empiam;
        this.email_empiam = email_empiam;
        this.passhash_empiam = passhash_empiam;
        this.rol_empiam = rol_empiam;
    }

    public static EmpleadoIAM crearempiam(String nom_empiam, String ape_empiamm, Email email_empiam, String passhash_empiam, Roles rol_empiam){
        return new EmpleadoIAM(IDEntidad.generar(), nom_empiam, ape_empiamm, email_empiam, passhash_empiam, rol_empiam);
    }

    public IDEntidad getId_empiam() {
        return id_empiam;
    }

    public String getNom_empiam() {
        return nom_empiam;
    }

    public String getApe_empiam() {
        return ape_empiam;
    }

    public Email getEmail_empiam() {
        return email_empiam;
    }

    public String getPasshash_empiam() {
        return passhash_empiam;
    }

    public Roles getRol_empiam() {
        return rol_empiam;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoIAM that = (EmpleadoIAM) o;
        return Objects.equals(getId_empiam(), that.getId_empiam());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_empiam());
    }
}
