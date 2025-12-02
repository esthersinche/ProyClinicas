package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.SharedKernel.UsuarioWeb;

import java.util.Optional;

public interface UsuarioWebRepositoryService {
    Optional<UsuarioWeb> findByEmail(String usuweb_email);
    Optional<UsuarioWeb> findById_Emp(String id_usuweb_emp);
    Optional<UsuarioWeb> findById_Cli(String id_usuweb_cli);
}
