package com.Clinica1.myApp.mantenimiento.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;

import java.util.List;

public interface DoctorRepository extends ICRUD<Doctor> {
    Doctor findByCmp(String cmp);
    List<Doctor> findByEspecialidad(String nomEspe);
    List<Doctor> findByNombre(String nombre);
    boolean existsByCmp(String cmp);
}
