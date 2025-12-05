package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;

import java.util.Set;

public interface RolRepositoryService {
    Set<Funcion> findFuncionesByNombreRol(String nombrerol);


}
