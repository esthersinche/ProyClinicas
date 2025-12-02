package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepositoryService {
    Optional<Empleado> findById(String id_emp);
    Optional<Empleado> findbyEmail(String email_emp);
    Optional<Empleado> findbyNamecompleto(String nom_emp, String ape_emp);
    List<Empleado> findbyRol(String idrol_emp);
}
