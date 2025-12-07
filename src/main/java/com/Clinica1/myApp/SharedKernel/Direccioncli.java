package com.Clinica1.myApp.SharedKernel;

public record Direccioncli (String avenida, String distrito, String departamento, String provincia){

    public Direccioncli{
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

    public static Direccioncli of(String avenida, String distrito, String departamento, String provincia){
        return new Direccioncli(avenida, distrito, departamento, provincia);
    }
}
