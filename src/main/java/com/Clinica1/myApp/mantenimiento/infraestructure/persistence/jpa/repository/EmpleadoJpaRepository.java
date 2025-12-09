package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.repository;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoJpaRepository extends JpaRepository<EmpleadoEntity, String> {
    Optional<EmpleadoEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsById(IDEntidad id);
}
