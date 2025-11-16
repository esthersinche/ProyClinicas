package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class Usuario {
    private IDEntidad id_usu;
    private String username;
    private ContraHash passhash;
    private Empleado emp;

    public Usuario() {
    }

    public Usuario(IDEntidad id_usu, String username, ContraHash passhash, Empleado emp) {
        this.id_usu = id_usu;
        this.username = username;
        this.passhash = passhash;
        this.emp = emp;
    }

    public static Usuario crearusu(String username, ContraHash passhash, Empleado emp){
        return new Usuario(IDEntidad.generar(), username, passhash, emp);
    }

    public IDEntidad getId_usu() {
        return id_usu;
    }

    public String getUsername() {
        return username;
    }

    public ContraHash getPasshash() {
        return passhash;
    }

    public Empleado getEmp() {
        return emp;
    }
}
