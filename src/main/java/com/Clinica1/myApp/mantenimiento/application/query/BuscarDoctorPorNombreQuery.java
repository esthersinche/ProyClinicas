package com.Clinica1.myApp.mantenimiento.application.query;

public class BuscarDoctorPorNombreQuery {
    private final String texto;

    public BuscarDoctorPorNombreQuery(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
