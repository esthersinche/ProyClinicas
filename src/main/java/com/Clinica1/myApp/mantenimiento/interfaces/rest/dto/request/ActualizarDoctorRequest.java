package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class ActualizarDoctorRequest {
    private String cmp;
    private String consultorio;
    private List<String> especialidades;
}