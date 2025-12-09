package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.repository;

import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPAAdministradorRepository extends JpaRepository<AdministradorEntity, String> {

    Optional<AdministradorEntity> findByIdEmp(String id_emp);

}
