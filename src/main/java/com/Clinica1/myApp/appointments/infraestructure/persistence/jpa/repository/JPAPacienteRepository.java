package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.repository;

import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  JPAPacienteRepository extends JpaRepository<PacienteEntity, String> {
    Optional<PacienteEntity> findByDni(String dni);

    Optional<PacienteEntity> findByEmail(String email);

    Optional<PacienteEntity> findByNombreCompleto(String nombreCompleto);
}
