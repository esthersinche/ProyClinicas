package com.Clinica1.myApp.appointments.domain.model.valueobjects;

//para no agregar tantos atributos a citaentity, y que sea como posible cambiarlo o añadirle cosas yknow
public record Pac_info_cita(String nomb_com_pac, String dni_pac) {

    public Pac_info_cita {

        if (nomb_com_pac == null || nomb_com_pac.trim().isBlank()){
            throw new IllegalArgumentException("Name can't be empty");
        }

        if (dni_pac == null || dni_pac.trim().isBlank()){
            throw new IllegalArgumentException("DNI can't be empty");
        }
    }

    public static Pac_info_cita of(String nomb_com_pac, String dni_pac){
        return new Pac_info_cita(nomb_com_pac, dni_pac);
    }


}
