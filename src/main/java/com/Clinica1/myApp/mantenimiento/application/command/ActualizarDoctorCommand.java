package com.Clinica1.myApp.mantenimiento.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.List;

public class ActualizarDoctorCommand {
    private IDEntidad idDoctor;
    private String cmp;
    private String consultorio;
    private List<String> especialidades;
}
