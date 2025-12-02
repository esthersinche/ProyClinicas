package com.Clinica1.myApp.IAMusuario.domain.repository;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;

import java.util.Optional;


public interface UsuarioRepository extends ICRUD<UsuarioWeb>{
    //faltantes, no hay username solo email, idemp e idcli
    //Optional<UsuarioWeb> findbyUsername(String usu_username);
    //idemp
    Optional<UsuarioWeb> findById_Emp(IDEntidad id_usuweb_emp);
    //idclinica
    Optional<UsuarioWeb> findById_Cli(IDEntidad id_usuweb_cli);
    //porsia
    Optional<UsuarioWeb> findByEmail(Email email_usu_web);

}
