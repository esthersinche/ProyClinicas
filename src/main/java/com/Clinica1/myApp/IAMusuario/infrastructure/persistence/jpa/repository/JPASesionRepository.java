package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Sesion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPASesionRepository extends JpaRepository<Sesion, String> {

    List<Sesion> findByUserId(IDEntidad usu_id);
}
