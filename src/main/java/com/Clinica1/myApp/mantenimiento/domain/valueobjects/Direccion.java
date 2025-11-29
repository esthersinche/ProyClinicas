package com.Clinica1.myApp.mantenimiento.domain.valueobjects;

public record Direccion(String avenida, String calle, String distrito, String departamento) {
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

        if (departamento == null || departamento.trim().isEmpty()){
            throw new IllegalArgumentException("Departamento cannot be null or Empty");
        }
    }

    public static Direccion of(String avenida, String calle, String distrito, String departamento){
        return new Direccion(avenida, calle, distrito, departamento);
    }

}
