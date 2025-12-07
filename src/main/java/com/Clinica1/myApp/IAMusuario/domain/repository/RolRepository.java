package com.Clinica1.myApp.IAMusuario.domain.repository;


import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.SharedKernel.Roles;

import java.util.Optional;
import java.util.Set;

public interface RolRepository extends ICRUD<Rol> {
    Optional<Rol> findByNombre(Roles rol_nom);
    Set<Funcion> findFuncionesByNombre(Roles rol_nom);

}
