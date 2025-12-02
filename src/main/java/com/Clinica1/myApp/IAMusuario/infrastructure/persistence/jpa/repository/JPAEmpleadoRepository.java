package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository;

import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JPAEmpleadoRepository extends JpaRepository<EmpleadoEntity, String> {

    Optional<EmpleadoEntity> findbyEmail (String email_empent);
    Optional<EmpleadoEntity> findbyNamecompleto (String nom_empent, String ape_empent);
    List<EmpleadoEntity> findbyRol (String idrol_empent);
}
