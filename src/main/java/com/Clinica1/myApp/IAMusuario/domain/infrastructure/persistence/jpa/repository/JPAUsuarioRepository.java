package com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.repository;

import com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAUsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    Optional<UsuarioEntity> findByUsername(String username);
}
