package com.Clinica1.myApp.IAMusuario.domain.repository;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.List;

public interface EmpleadoRepository extends ICRUD<Empleado>{
    Empleado findbyEmail(Email email_emp);
    Empleado findbyNamecompleto(String emp_nom, String emp_ape);
    List<Empleado> findbyRol(IDEntidad rol_id);

}
