package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.FuncionEmbeddable;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface JPARolRepository extends JpaRepository<RolEntity, String> {

    @Query("SELECT r FROM RolEntity r WHERE r.nombreRol = :nom_rol")
    Optional<RolEntity> findByNombre(@Param("nom_rol") String nom_rol);

    @Query("SELECT r.funciones FROM RolEntity r WHERE r.nombreRol = :nom_rol")
    Set<FuncionEmbeddable> findFuncionesByNombre(@Param("nom_rol") String nom_rol);
}
