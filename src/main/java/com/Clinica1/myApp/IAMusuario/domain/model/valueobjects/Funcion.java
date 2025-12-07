package com.Clinica1.myApp.IAMusuario.domain.model.valueobjects;

import java.util.Objects;

public class Funcion {
    private String nombre_fun;

    public Funcion(String nombre_fun) {
        this.nombre_fun = nombre_fun;
    }

    public String getNombre_fun() {
        return nombre_fun;
    }

    //metodo factory estatico, muy comun en ddd, permite ocultar constructor
    public static Funcion of(String nombre_fun){
        Objects.requireNonNull(nombre_fun); //no nulo
        return new Funcion(nombre_fun);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcion other)) return false;
        return nombre_fun.equalsIgnoreCase(other.nombre_fun);
    }

    @Override
    public int hashCode() {
        return nombre_fun.toLowerCase().hashCode();
    }

    @Override
    public String toString(){
        return nombre_fun;
    }
}
