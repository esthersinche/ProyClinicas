package com.Clinica1.myApp.IAMusuario.domain.repository;

import com.Clinica1.myApp.SharedKernel.UsuarioWeb;

import java.util.Optional;


public interface UsuarioRepository extends ICRUD<UsuarioWeb>{
    //faltantes
    Optional<UsuarioWeb> findbyUsername(String usu_username);
    //porsia
    Optional<UsuarioWeb> findByEmail(String email_usu_web);

}
