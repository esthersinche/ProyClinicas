package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.repository;

import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAIDoctorRepository extends JpaRepository<DoctorEntity, String> {
}
