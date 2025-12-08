package com.Clinica1.myApp.adquisicion.domain.model;


import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class UsuarioWeb {
    private IDEntidad id_usuweb;
    private IDEntidad id_emp;//se crea un empleado automatico en admin
    private
    /*private IDEntidad id_usuweb;
    private IDEntidad idclinica_usuweb;
    private String razonsoc_usuweb;
    private String responsablecompra_usuweb;
    private String ruc_usuweb;
    private Direccioncli dircli_usuweb;
    private boolean pagorealizado_usuweb;
    private DateTimeFormat fechapago_usuweb;
    private float montopagado_usuweb;

    public UsuarioWeb() {
    }

    public UsuarioWeb(IDEntidad id_usuweb, IDEntidad idclinica_usuweb, String razonsoc_usuweb, String responsablecompra_usuweb, String ruc_usuweb,
                      Direccioncli dircli_usuweb, boolean pagorealizado_usuweb, DateTimeFormat fechapago_usuweb, float montopagado_usuweb) {
        this.id_usuweb = id_usuweb;
        this.idclinica_usuweb = idclinica_usuweb;
        this.razonsoc_usuweb = razonsoc_usuweb;
        this.responsablecompra_usuweb = responsablecompra_usuweb;
        this.ruc_usuweb = ruc_usuweb;
        this.dircli_usuweb = dircli_usuweb;
        this.pagorealizado_usuweb = pagorealizado_usuweb;
        this.fechapago_usuweb = fechapago_usuweb;
        this.montopagado_usuweb = montopagado_usuweb;
    }

    //metodo estatico factory
    public static UsuarioWeb crearusuweb(IDEntidad idclinica_usuweb, String razonsoc_usuweb, String responsablecompra_usuweb, String ruc_usuweb, Direccioncli dircli_usuweb, boolean pagorealizado_usuweb,
                                         DateTimeFormat fechapago_usuweb, float montopagado_usuweb){
        return new UsuarioWeb(IDEntidad.generar(), idclinica_usuweb, razonsoc_usuweb, responsablecompra_usuweb, ruc_usuweb, dircli_usuweb,
                pagorealizado_usuweb, fechapago_usuweb, montopagado_usuweb);
    }

    public IDEntidad getId_usuweb() {
        return id_usuweb;
    }

    public IDEntidad getIdclinica_usuweb() {
        return idclinica_usuweb;
    }

    public String getRazonsoc_usuweb() {
        return razonsoc_usuweb;
    }

    public String getResponsablecompra_usuweb() {
        return responsablecompra_usuweb;
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
    }*/



}
