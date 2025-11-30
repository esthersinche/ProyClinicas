package com.Clinica1.myApp.IAMusuario.domain.repository;

import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.List;

public interface EmpleadoRepository extends ICRUD<Empleado>{
    Empleado findbyEmail(Email email_emp);
    Empleado findbyNamecompleto(String emp_nom, String emp_ape);
    List<Empleado> findbyRol(IDEntidad rol_id);

}
