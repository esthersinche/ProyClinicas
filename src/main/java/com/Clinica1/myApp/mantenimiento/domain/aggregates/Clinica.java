package com.Clinica1.myApp.mantenimiento.domain.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;

import java.util.List;

public class Clinica {
    private IDEntidad id_clinica;
    private String nombre_cli;
    private Direccion dir_cli;
    private String ruc_cli;
    List<Doctor> doctores_cli;

}
