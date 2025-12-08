package com.Clinica1.myApp.adquisicion.domain.model;


import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.List;
import java.util.Objects;

public class Clinica {
    private IDEntidad id_clinadqui;
    private String nom_clinadqui;
    //private Direccioncli dir_clinadqui;
    private String ruc_clinadqui;
    List<Empleado> listemp_clinadqui;

    //ref a usuweb
    private IDEntidad idusuweb_clinadqui;

    public Clinica() {
    }

    public Clinica(IDEntidad id_clinadqui, String nom_clinadqui, String ruc_clinadqui, List<Empleado> listemp_clinadqui, IDEntidad idusuweb_clinadqui) {
        this.id_clinadqui = id_clinadqui;
        this.nom_clinadqui = nom_clinadqui;
        this.ruc_clinadqui = ruc_clinadqui;
        this.listemp_clinadqui = listemp_clinadqui;
        this.idusuweb_clinadqui = idusuweb_clinadqui;
    }

    //factory
    public static Clinica crearclinica(String nom_clinadqui, String ruc_clinadqui, List<Empleado> listemp_clinadqui, IDEntidad idusuweb_clinadqui){
        return new Clinica(IDEntidad.generar(), nom_clinadqui, ruc_clinadqui, listemp_clinadqui, idusuweb_clinadqui);
    }

    public IDEntidad getId_clinadqui() {
        return id_clinadqui;
    }

    public String getNom_clinadqui() {
        return nom_clinadqui;
    }

    public String getRuc_clinadqui() {
        return ruc_clinadqui;
    }

    public List<Empleado> getListemp_clinadqui() {
        return listemp_clinadqui;
    }

    public IDEntidad getIdusuweb_clinadqui() {
        return idusuweb_clinadqui;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clinica clinica = (Clinica) o;
        return Objects.equals(getId_clinadqui(), clinica.getId_clinadqui());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_clinadqui());
    }
}
