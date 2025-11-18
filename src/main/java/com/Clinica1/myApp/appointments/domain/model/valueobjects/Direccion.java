package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import java.util.Objects;

public record Direccion(String avenida, String calle, String distrito, String pais) {

    public Direccion{
        if (avenida == null || avenida.trim().isEmpty()){
            throw new IllegalArgumentException("Avenida cannot be null or Empty");
        }

        if (calle == null || calle.trim().isEmpty()){
            throw new IllegalArgumentException("Calle cannot be null or Empty");
        }

        if (distrito == null || distrito.trim().isEmpty()){
            throw new IllegalArgumentException("Distrito cannot be null or Empty");
        }

        if (pais == null || pais.trim().isEmpty()){
            throw new IllegalArgumentException("País cannot be null or Empty");
        }
    }

    public static Direccion of(String avenida, String calle, String distrito, String pais){
        return new Direccion(avenida, calle, distrito, pais);
    }

    //record tiene equals y hashcode auto
}
