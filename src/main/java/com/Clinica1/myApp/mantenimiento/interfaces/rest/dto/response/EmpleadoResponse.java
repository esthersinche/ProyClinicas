package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpleadoResponse {
    private String idEmpleado;
    private String nombreCompleto;
    private String telefono;
    private String email;
    private String rol;
}
