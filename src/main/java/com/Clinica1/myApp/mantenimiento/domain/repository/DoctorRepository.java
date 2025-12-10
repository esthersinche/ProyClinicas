package com.Clinica1.myApp.mantenimiento.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends ICRUD<Doctor> {
    Optional<Doctor> findByCmp(String cmp);
    List<Doctor> findByEspecialidad(String nomEspe);
    boolean existsByCmp(String cmp);
    Optional<Doctor> findByIdEmpleado(IDEntidad idEmpleado);
}
