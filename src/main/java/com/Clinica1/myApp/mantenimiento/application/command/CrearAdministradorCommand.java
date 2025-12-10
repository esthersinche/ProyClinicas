package com.Clinica1.myApp.mantenimiento.application.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class CrearAdministradorCommand {
    private String idEmpleado;
}
