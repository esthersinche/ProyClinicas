package com.Clinica1.myApp.IAMusuario.domain.repository;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Sesion;
import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.List;

public interface SesionRepository extends ICRUD<Sesion> {
    //guardar es insert
    List<Sesion> findByUserId(IDEntidad usu_id);//cualquiera de los dos, usu_web o empleado
}
