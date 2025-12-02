package com.Clinica1.myApp.mantenimiento.application.query;

public class BuscarDoctorPorCMPQuery {
    private final String cmp;

    public BuscarDoctorPorCMPQuery(String cmp) {
        this.cmp = cmp;
    }

    public String getCmp() {
        return cmp;
    }
}