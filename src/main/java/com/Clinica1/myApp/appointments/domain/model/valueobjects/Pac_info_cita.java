package com.Clinica1.myApp.appointments.domain.model.valueobjects;

//para no agregar tantos atributos a citaentity, y que sea como posible cambiarlo o añadirle cosas yknow
public class Pac_info_cita {

    private String nomb_com_pac;
    private String dni_pac;

    public Pac_info_cita() {
    }

    public Pac_info_cita(String nomb_com_pac, String dni_pac) {
        this.nomb_com_pac = nomb_com_pac;
        this.dni_pac = dni_pac;
    }
}
