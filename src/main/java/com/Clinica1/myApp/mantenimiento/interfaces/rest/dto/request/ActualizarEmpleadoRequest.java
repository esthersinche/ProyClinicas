package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request;

import lombok.Data;

@Data
public class ActualizarEmpleadoRequest {
    private String nombre;
    private String apellido;
    private String telefono;
}
