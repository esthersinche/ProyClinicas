package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.repository;

import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAICitaRepository extends JpaRepository<CitaEntity, String> {
}
