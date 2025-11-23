package com.Clinica1.myApp.appointments.domain.model.valueobjects;

public record NombreCompleto(String nombre, String apellido) {

    //si se necesita subespecialidad de especialidad tipo electrofisiologia de cardiologia ps creen otra nomas
    public NombreCompleto{
        if (nombre == null || nombre.trim().isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (apellido == null || apellido.trim().isBlank()){
            throw new IllegalArgumentException("Surname cannot be null or empty");
        }
    }

    //metodo factory, crea instancia sin usar new especialidad
    public static NombreCompleto of(String nombre, String apellido){

        return new NombreCompleto(nombre, apellido);
    }

    public String completar(){
        return nombre+ " " + apellido;
    }

    //record tiene equals y hashcode auto
}
