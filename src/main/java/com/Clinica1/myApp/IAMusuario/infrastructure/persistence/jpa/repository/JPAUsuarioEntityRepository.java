package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository;


import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioWebEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAUsuarioEntityRepository extends JpaRepository<UsuarioWebEntity, String> {

    Optional<UsuarioWebEntity> findByUsername(String username);
    Optional<UsuarioWebEntity> findByEmail(String usuent_web_email);
}
