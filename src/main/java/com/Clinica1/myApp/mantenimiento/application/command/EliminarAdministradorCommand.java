package com.Clinica1.myApp.mantenimiento.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EliminarAdministradorCommand {
    private String idAdmin;
}
