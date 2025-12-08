package com.Clinica1.myApp.mantenimiento.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Clinica;

public interface ClinicaRepository extends ICRUD<Clinica> {
    //nombre clinica
    Clinica findByNombreCli(String nom_clin);
    //ruc
    Clinica findByRUCCli(String ruc_clin);
    //direccion
    Clinica findByDireccionCli(String dir_clin);
}
