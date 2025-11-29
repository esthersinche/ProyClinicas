package com.Clinica1.myApp.mantenimiento.domain.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;

public class Doctor {
    private IDEntidad id_emp;
    private IDEntidad id_doc;
    private NombreCompleto nom_doc;
    private String cmp;
    private String consultorio_doc;
    List<Especialidades> especialidades;
}
