package com.Clinica1.myApp.appointments.domain.model.valueobjects;

public record Especialidad (String nom_espe){

    //si se necesita subespecialidad de especialidad tipo electrofisiologia de cardiologia ps creen otra nomas
    public Especialidad{
        if (nom_espe == null || nom_espe.trim().isBlank()){
            throw new IllegalArgumentException("Especialidad cannot be null or empty");
        }
    }

    //metodo factory, crea instancia sin usar new especialidad
    public static Especialidad of(String nom_espe){
        return new Especialidad(nom_espe);
    }

    //record tiene equals y hashcode auto

}
