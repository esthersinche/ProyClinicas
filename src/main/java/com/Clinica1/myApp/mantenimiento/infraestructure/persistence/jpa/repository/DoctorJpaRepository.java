package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.repository;


import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorJpaRepository extends JpaRepository<DoctorEntity, String> {
    Optional<DoctorEntity> findByCmp(String cmp);
    Optional<DoctorEntity> findByIdEmpleado(String idEmpleado);
    boolean existsByCmp(String cmp);
}