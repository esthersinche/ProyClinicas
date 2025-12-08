package com.Clinica1.myApp.mantenimiento.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Recepcionista;

public interface RecepcionistaRepository extends ICRUD<Recepcionista> {
    Recepcionista findByIdEmp(IDEntidad id_emp);
}
