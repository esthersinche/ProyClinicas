package com.Clinica1.myApp.appointments.domain.model.valueobjects;

public record Doc_info_cita(String nombre_doc, String espe_doc,String consult_doc) {

    public Doc_info_cita{
        if (nombre_doc == null || nombre_doc.trim().isBlank()){
            throw new IllegalArgumentException("Name can't be empty");
        }

        if (espe_doc == null || espe_doc.trim().isBlank()){
            throw new IllegalArgumentException("Especialidad can't be empty");
        }

        if (consult_doc == null || consult_doc.trim().isBlank()){
            throw new IllegalArgumentException("Consultorio can't be empty");
        }

    }

    public static Doc_info_cita of(String nombre_doc, String espe_doc, String consult_doc){
        return new Doc_info_cita(nombre_doc, espe_doc, consult_doc);
    }


}
