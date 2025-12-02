package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository;


import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioWebEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAUsuarioEntityRepository extends JpaRepository<UsuarioWebEntity, String> {
//no existe username en usuarioweb, solo email e ids
    //Optional<UsuarioWebEntity> findByUsername(String username);
    //id_emp
    Optional<UsuarioWebEntity> findById_Emp(String usuent_web_idemp);
    //id_cli
    Optional<UsuarioWebEntity> findById_Cli(String usuwnt_web_idcli);
    Optional<UsuarioWebEntity> findByEmail(String usuent_web_email);
}
