package com.Clinica1.myApp.appointments.domain.model.valueobjects;

public class Doc_info_cita {
    private String nombre_doc;
    private String espe_doc;
    private String consult_doc;

    public Doc_info_cita() {
    }

    public Doc_info_cita(String nombre_doc, String espe_doc, String consult_doc) {
        this.nombre_doc = nombre_doc;
        this.espe_doc = espe_doc;
        this.consult_doc = consult_doc;
    }
}
