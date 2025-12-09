package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request;

import lombok.Data;

@Data
public class CrearAdministradorRequest {
    private String idEmpleado; // YA EXISTE
    private String nombre;
    private String apellido;
}