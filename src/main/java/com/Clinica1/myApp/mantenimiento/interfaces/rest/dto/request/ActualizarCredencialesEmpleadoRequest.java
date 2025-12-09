package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request;
import lombok.Data;

@Data
public class ActualizarCredencialesEmpleadoRequest {
    private String idEmpleado;      // llega como string desde JSON
    private String nuevaPassword;
}