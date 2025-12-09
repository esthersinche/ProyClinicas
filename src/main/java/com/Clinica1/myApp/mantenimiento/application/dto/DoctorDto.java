package com.Clinica1.myApp.mantenimiento.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private String idDoctor;
    private String idEmpleado;
    private String cmp;
    private String consultorio;
    private List<String> especialidades;
}