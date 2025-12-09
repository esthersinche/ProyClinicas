package com.Clinica1.myApp.mantenimiento.application.command;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CrearDoctorCommand {
    private String idEmpleado;
    private String nombre;
    private String apellido;
    private String cmp;
    private String consultorio;
    private List<String> especialidades;
}