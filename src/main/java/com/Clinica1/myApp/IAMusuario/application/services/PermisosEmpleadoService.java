package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.IAMusuario.application.command.PermisosEmpleadosCommand;
import com.Clinica1.myApp.IAMusuario.application.dto.FuncionesDto;

public interface PermisosEmpleadoService {
    FuncionesDto obtenerFunciones(PermisosEmpleadosCommand peremp_com);
}
