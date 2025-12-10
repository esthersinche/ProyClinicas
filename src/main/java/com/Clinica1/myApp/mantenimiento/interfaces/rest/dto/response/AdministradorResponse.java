package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdministradorResponse {
    private String idAdministrador;
    private String idEmpleado;
    private String nombreEmpleado;
}