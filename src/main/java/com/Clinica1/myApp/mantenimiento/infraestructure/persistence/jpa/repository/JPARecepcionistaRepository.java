package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.repository;

import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.RecepcionistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPARecepcionistaRepository extends JpaRepository<RecepcionistaEntity, String> {

    Optional<RecepcionistaEntity> findByIdEmp(String id_emp);
}
