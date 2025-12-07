package com.Clinica1.myApp.SharedKernel;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Objects;

public class UsuarioWeb {
    private IDEntidad id_usuweb;
    private String razonsoc_usuweb;
    private String ruc_usuweb;
    private Direccioncli dircli_usuweb;
    private boolean pagorealizado_usuweb;
    private DateTimeFormat fechapago_usuweb;
    private float montopagado_usuweb;

    public UsuarioWeb() {
    }

    public UsuarioWeb(IDEntidad id_usuweb, String razonsoc_usuweb, String ruc_usuweb, Direccioncli dircli_usuweb, boolean pagorealizado_usuweb,
                      DateTimeFormat fechapago_usuweb, float montopagado_usuweb) {
        this.id_usuweb = id_usuweb;
        this.razonsoc_usuweb = razonsoc_usuweb;
        this.ruc_usuweb = ruc_usuweb;
        this.dircli_usuweb = dircli_usuweb;
        this.pagorealizado_usuweb = pagorealizado_usuweb;
        this.fechapago_usuweb = fechapago_usuweb;
        this.montopagado_usuweb = montopagado_usuweb;
    }

    //metodo estatico factory
    public static UsuarioWeb crearusuweb(String razonsoc_usuweb, String ruc_usuweb, Direccioncli dircli_usuweb, boolean pagorealizado_usuweb,
                                         DateTimeFormat fechapago_usuweb, float montopagado_usuweb){
        return new UsuarioWeb(IDEntidad.generar(), razonsoc_usuweb, ruc_usuweb, dircli_usuweb, pagorealizado_usuweb, fechapago_usuweb,
                montopagado_usuweb);
    }

    public IDEntidad getId_usuweb() {
        return id_usuweb;
    }

    public String getRazonsoc_usuweb() {
        return razonsoc_usuweb;
    }

    public String getRuc_usuweb() {
        return ruc_usuweb;
    }

    public Direccioncli getDircli_usuweb() {
        return dircli_usuweb;
    }

    public boolean isPagorealizado_usuweb() {
        return pagorealizado_usuweb;
    }

    public DateTimeFormat getFechapago_usuweb() {
        return fechapago_usuweb;
    }

    public float getMontopagado_usuweb() {
        return montopagado_usuweb;
    }

    //equals y hashcode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioWeb that = (UsuarioWeb) o;
        return Objects.equals(getId_usuweb(), that.getId_usuweb());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_usuweb());
    }


    /*//usuario que hace la compra, solo habra uno por clinica, los empleados no entraran por aca
    private IDEntidad id_usu;
    private Email correo;
    private String passhash;//luego vuelvo ya q hay contrahash en IAM
    private IDEntidad id_emp;//referencia a empleado ya q sera admin automaticamente
    private IDEntidad id_cli; //referencia a la clinica a la q esta afiliado
    //tanto id_emp e id_usu srean rellenados automaticamente, id_cli saldra de la creacion de la clinica dsps
    //de la venta


    public UsuarioWeb() {
    }

    public UsuarioWeb(IDEntidad id_usu, Email correo, String passhash, IDEntidad id_emp, IDEntidad id_cli) {
        this.id_usu = id_usu;
        this.correo = correo;
        this.passhash = passhash;
        this.id_emp = id_emp;
        this.id_cli = id_cli;
    }

    //metodo factory
    public static UsuarioWeb crearusu(Email correo, String passhash, IDEntidad id_emp, IDEntidad id_cli){
        return new UsuarioWeb(IDEntidad.generar(), correo, passhash, id_emp, id_cli);
    }

    public IDEntidad getId_usu() {
        return id_usu;
    }

    public Email getCorreo() {
        return correo;
    }

    public String getPasshash() {
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
    }*/

}
