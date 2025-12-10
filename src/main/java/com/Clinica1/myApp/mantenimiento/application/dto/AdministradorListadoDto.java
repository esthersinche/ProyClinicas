package com.Clinica1.myApp.mantenimiento.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdministradorListadoDto {

    private String idAdmin;
    private String idEmpleado;
    private String nombreCompleto;
}