package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecepcionistaResponse {
    private String idRecepcionista;
    private String idEmpleado;
    private String nombreEmpleado;
}