package com.Clinica1.myApp.appointments.domain.repository;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;

public interface PacienteRepository extends ICRUD<Paciente> {
    //faltantes
    Paciente findbyName(String nom_com_pac);
    Paciente findbyDNI(String dni_pac);
    Paciente findbyEmail(Email email);
}
