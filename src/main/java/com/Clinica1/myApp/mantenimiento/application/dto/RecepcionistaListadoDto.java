package com.Clinica1.myApp.mantenimiento.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecepcionistaListadoDto {

    private String idRecepcionista;
    private String idEmpleado;
    private String nombreCompleto;
    private String email;
}