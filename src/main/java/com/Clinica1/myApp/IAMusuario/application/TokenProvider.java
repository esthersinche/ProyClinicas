package com.Clinica1.myApp.IAMusuario.application;

import com.Clinica1.myApp.SharedKernel.UsuarioWeb;

import java.util.Map;

public interface TokenProvider {
    String generartokendeacceso(UsuarioWeb usu_web);

    void validartokendeacceso(String token);

    String generarIdtoken();
    //long obtenerlossgdeexptoken();

    //parseo
    Map<String, Object> parsear(String token);
}
