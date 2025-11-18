package com.Clinica1.myApp.IAMusuario.domain.repository;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Usuario;


public interface UsuarioRepository extends ICRUD<Usuario>{
    //faltantes
    Usuario findbyUsername(String usu_username);

}
