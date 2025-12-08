package com.Clinica1.myApp.mantenimiento.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;

public interface AdministradorRepository extends ICRUD<Administrador> {
    Administrador findByIdEmp(IDEntidad id_emp);
}
