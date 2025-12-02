package com.Clinica1.myApp.mantenimiento.domain.repository;

import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;


public interface EmpleadoRepository extends ICRUD<Empleado> {
    boolean existsByEmail(String email);
    Empleado findByEmail(String email);
}
