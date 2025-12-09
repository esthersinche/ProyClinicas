package com.Clinica1.myApp.IAMusuario.domain.repository;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.EmpleadoIAM;
import com.Clinica1.myApp.SharedKernel.*;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends ICRUD<EmpleadoIAM> {
    Optional<EmpleadoIAM> findbyEmail(Email email_empiam);
    Optional<EmpleadoIAM> findbyNamecompleto(String nom_empaim, String ape_empiam);
    List<EmpleadoIAM> findbyRol(Roles rol_empiam);
    Optional<EmpleadoIAM> validaryobtenerporemail(String email_empiam, String passhash_empiam);

}
