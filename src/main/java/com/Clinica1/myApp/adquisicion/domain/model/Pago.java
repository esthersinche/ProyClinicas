package com.Clinica1.myApp.adquisicion.domain.model;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Objects;

public class Pago {
    private IDEntidad id_pago;
    private IDEntidad id_cli;//ref a cliente/usuarioweb
    private float monto_pago;
    private DateTimeFormat fecha_pago;
    private String metodo_pago;
    //ref a transaccion(?


    public Pago() {
    }

    public Pago(IDEntidad id_pago, IDEntidad id_cli, float monto_pago, DateTimeFormat fecha_pago, String metodo_pago) {
        this.id_pago = id_pago;
        this.id_cli = id_cli;
        this.monto_pago = monto_pago;
        this.fecha_pago = fecha_pago;
        this.metodo_pago = metodo_pago;
    }

    //metodo factory
    public static Pago crearpago(IDEntidad id_cli, float monto_pago, DateTimeFormat fecha_pago, String metodo_pago){
        return new Pago(IDEntidad.generar(), id_cli, monto_pago, fecha_pago, metodo_pago);
    }

    public IDEntidad getId_pago() {
        return id_pago;
    }

    public IDEntidad getId_cli() {
        return id_cli;
    }

    public float getMonto_pago() {
        return monto_pago;
    }

    public DateTimeFormat getFecha_pago() {
        return fecha_pago;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pago pago = (Pago) o;
        return Objects.equals(getId_pago(), pago.getId_pago());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_pago());
    }
}
