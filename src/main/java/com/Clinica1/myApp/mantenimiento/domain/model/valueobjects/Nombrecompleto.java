package com.Clinica1.myApp.mantenimiento.domain.model.valueobjects;

public record Nombrecompleto(String nombre, String apellido) {
    public Nombrecompleto{
        if (nombre == null || nombre.trim().isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (apellido == null || apellido.trim().isBlank()){
            throw new IllegalArgumentException("Surname cannot be null or empty");
        }
    }

    //metodo factory, crea instancia sin usar new especialidad
    public static Nombrecompleto of(String nombre, String apellido){

        return new Nombrecompleto(nombre, apellido);
    }

    public String completar(){
        return nombre+ " " + apellido;
    }
}
