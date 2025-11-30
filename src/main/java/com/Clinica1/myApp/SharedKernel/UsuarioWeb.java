package com.Clinica1.myApp.SharedKernel;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;

import java.util.Objects;

public class UsuarioWeb {
    //usuario que hace la compra, solo habra uno por clinica, los empleados no entraran por aca
    private IDEntidad id_usu;
    private Email correo;
    private ContraHash passhash;
    private IDEntidad id_emp;//referencia a empleado ya q sera admin automaticamente
    private IDEntidad id_cli; //referencia a la clinica a la q esta afiliado
    //tanto id_emp e id_usu srean rellenados automaticamente, id_cli saldra de la creacion de la clinica dsps
    //de la venta


    public UsuarioWeb() {
    }

    public UsuarioWeb(IDEntidad id_usu, Email correo, ContraHash passhash, IDEntidad id_emp, IDEntidad id_cli) {
        this.id_usu = id_usu;
        this.correo = correo;
        this.passhash = passhash;
        this.id_emp = id_emp;
        this.id_cli = id_cli;
    }

    //metodo factory
    public static UsuarioWeb crearusu(Email correo, ContraHash passhash, IDEntidad id_emp, IDEntidad id_cli){
        return new UsuarioWeb(IDEntidad.generar(), correo, passhash, id_emp, id_cli);
    }

    public IDEntidad getId_usu() {
        return id_usu;
    }

    public Email getCorreo() {
        return correo;
    }

    public ContraHash getPasshash() {
        return passhash;
    }

    public IDEntidad getId_emp() {
        return id_emp;
    }

    public IDEntidad getId_cli() {
        return id_cli;
    }

    //todas las entidades deben tener equals y hashcode basados en su id solamente
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioWeb usuarioWeb = (UsuarioWeb) o;
        return Objects.equals(id_usu, usuarioWeb.id_usu);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_usu);
    }
}
