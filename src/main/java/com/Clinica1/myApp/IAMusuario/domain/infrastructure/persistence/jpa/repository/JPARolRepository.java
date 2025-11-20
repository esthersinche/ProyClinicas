package com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.repository;

import com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPARolRepository extends JpaRepository<RolEntity, String> {

    Optional<RolEntity> findByNombreRol(String nombreRol);
}
