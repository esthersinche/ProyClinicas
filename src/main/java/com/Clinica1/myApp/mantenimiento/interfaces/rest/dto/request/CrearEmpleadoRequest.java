package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request;

import lombok.Data;

@Data
public class CrearEmpleadoRequest {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    private String rol;
}