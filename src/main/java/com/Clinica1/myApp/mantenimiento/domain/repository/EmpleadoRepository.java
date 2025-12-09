package com.Clinica1.myApp.mantenimiento.domain.repository;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.SharedKernel.ICRUD;


public interface EmpleadoRepository extends ICRUD<Empleado> {
    boolean existsByEmail(String email);
    Empleado findByEmail(String email);
    boolean existsById(IDEntidad idEmpleado);
}
