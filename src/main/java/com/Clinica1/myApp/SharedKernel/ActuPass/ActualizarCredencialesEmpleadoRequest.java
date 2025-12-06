package com.Clinica1.myApp.SharedKernel.ActuPass;
import lombok.Data;

@Data
public class ActualizarCredencialesEmpleadoRequest {
    private String idEmpleado;      // llega como string desde JSON
    private String nuevaPassword;
}