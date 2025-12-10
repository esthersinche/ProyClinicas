package com.Clinica1.myApp.mantenimiento.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EliminarRecepcionistaCommand {
    private String idRecepcionista;
}
