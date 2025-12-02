package com.Clinica1.myApp.IAMusuario.application.services;

import java.util.Set;

public interface RolRepositoryService {
    Set<String> findFuncionesByNombreRol(String nombrerol);
}
