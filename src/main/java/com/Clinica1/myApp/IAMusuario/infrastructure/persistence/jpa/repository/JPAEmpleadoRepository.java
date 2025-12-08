package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository;

import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmpleadoEntity;
import com.Clinica1.myApp.SharedKernel.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JPAEmpleadoRepository extends JpaRepository<EmpleadoEntity, String> {

    @Query("SELECT e FROM EmpleadoEntity e WHERE LOWER(e.email_emp.email_valor) = LOWER(:email_empent)")
    Optional<EmpleadoEntity> findbyEmail (@Param("email_empent")String email_empent);

    @Query("SELECT e FROM EmpleadoEntity e WHERE LOWER(e.nombresEmp) = LOWER(:nom_empent) AND LOWER(e.apellidosEmp) = LOWER(:ape_empent)")
    Optional<EmpleadoEntity> findbyNamecompleto (@Param("nom_empent") String nom_empent,
                                                 @Param("ape_empent") String ape_empent);

    @Query("SELECT e FROM EmpleadoEntity e WHERE e.rol = :nomrol_empent")
    List<EmpleadoEntity> findbyRol (@Param("nomrol_empent") Roles nomrol_empent);
}
