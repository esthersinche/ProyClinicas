package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAUsuarioEntityRepository extends JpaRepository<UsuarioEntity, String> {

    Optional<UsuarioEntity> findByUsername(String username);
    Optional<UsuarioEntity> findByEmail(String usuent_web_email);
}
