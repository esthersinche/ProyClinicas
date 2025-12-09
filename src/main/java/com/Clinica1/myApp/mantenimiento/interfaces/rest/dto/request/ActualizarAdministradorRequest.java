package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request;

import lombok.Data;

@Data
public class ActualizarAdministradorRequest {
    private String nombre;
    private String apellido;
}