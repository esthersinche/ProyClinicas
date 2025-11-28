package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import java.util.Objects;

public record Direccion(String avenida, String distrito, String departamento, String provincia) {

    public Direccion{
        if (avenida == null || avenida.trim().isEmpty()){
            throw new IllegalArgumentException("Avenida cannot be null or Empty");
        }

        if (distrito == null || distrito.trim().isEmpty()){
            throw new IllegalArgumentException("Distrito cannot be null or Empty");
        }

        if (departamento == null || departamento.trim().isEmpty()){
            throw new IllegalArgumentException("Departamento cannot be null or Empty");
        }

        if (provincia == null || provincia.trim().isEmpty()){
            throw new IllegalArgumentException("Provincia cannot be null or Empty");
        }
    }

    public static Direccion of(String avenida, String distrito, String departamento, String provincia){
        return new Direccion(avenida, distrito, departamento, provincia);
    }

    //record tiene equals y hashcode auto
}
