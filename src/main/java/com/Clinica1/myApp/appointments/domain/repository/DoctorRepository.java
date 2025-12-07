package com.Clinica1.myApp.appointments.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;

import java.util.List;

public interface DoctorRepository extends ICRUD<Doctor> {
    //faltantes
    //codigo de colegiatura
    Doctor findbyCMP(String cmp_doc);
    List<Doctor> findByEspecialidad(String especialidad);

    List<Doctor> findByNombre(String nombreCompleto);

}
