package com.Clinica1.myApp.IAMusuario.domain.repository;

import com.Clinica1.myApp.SharedKernel.*;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends ICRUD<Empleado> {
    Optional<Empleado> findbyEmail(Email email_emp);
    Optional<Empleado> findbyNamecompleto(String emp_nom, String emp_ape);
    List<Empleado> findbyRol(Roles nomrol_emp);

}
