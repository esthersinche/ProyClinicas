package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.EmpleadoIAM;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;

import java.util.Map;

public interface TokenProvider {
    TokenDto generartokendeacceso(EmpleadoIAM emp);

    void validartokendeacceso(String token);

    String generarIdtoken();
    //long obtenerlossgdeexptoken();

    //parseo
    Map<String, Object> parsear(String token);
}
