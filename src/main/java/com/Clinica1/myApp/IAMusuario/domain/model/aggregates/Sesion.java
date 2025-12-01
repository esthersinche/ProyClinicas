package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.time.Instant;
import java.util.Objects;

public class Sesion {
    private IDEntidad token_id;
    private IDEntidad usuweb_id;//referencia a usuario o empleado q este adentro
    private Instant comienzo;
    //private boolean accesoconcedido;
    private Instant expiracion;

    public Sesion() {
    }

    public Sesion(IDEntidad token_id, IDEntidad usuweb_id, Instant comienzo, Instant expiracion) {
        this.token_id = token_id;
        this.usuweb_id = usuweb_id;
        this.comienzo = comienzo;
        this.expiracion = expiracion;
    }

    public static Sesion crearsesion(IDEntidad usuweb_id, Instant comienzo, Instant expiracion){
        return new Sesion(IDEntidad.generar(), usuweb_id, comienzo, expiracion);
    }



    public IDEntidad getToken_id() {
        return token_id;
    }

    public IDEntidad getUsuweb_id() {
        return usuweb_id;
    }

    public Instant getComienzo() {
        return comienzo;
    }

    public Instant getExpiracion() {
        return expiracion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sesion sesion = (Sesion) o;
        return Objects.equals(getToken_id(), sesion.getToken_id());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getToken_id());
    }
}
