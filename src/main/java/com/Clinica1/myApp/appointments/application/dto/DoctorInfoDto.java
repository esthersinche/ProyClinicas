package com.Clinica1.myApp.appointments.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorInfoDto {
    private String nombre;
    private String especialidad;
    private String consultorio;
    private String cmp;
}