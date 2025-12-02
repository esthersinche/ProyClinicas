package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;

import java.util.Map;

public interface TokenProvider {
    TokenDto generartokendeacceso(Empleado emp);

    void validartokendeacceso(String token);

    String generarIdtoken();
    //long obtenerlossgdeexptoken();

    //parseo
    Map<String, Object> parsear(String token);
}
