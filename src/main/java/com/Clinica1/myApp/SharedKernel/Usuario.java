package com.Clinica1.myApp.SharedKernel;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;

import java.util.Objects;

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

    //metodo factory
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

    //todas las entidades deben tener equals y hashcode basados en su id solamente
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id_usu, usuario.id_usu);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_usu);
    }
}
