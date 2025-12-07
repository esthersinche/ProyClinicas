package com.Clinica1.myApp.adquisicion.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.adquisicion.domain.model.Pago;

import java.util.Optional;

public interface PagoRepository extends ICRUD<Pago> {
    //id del cliente
    Optional<Pago> findByIdCli(IDEntidad id_cli);

}
