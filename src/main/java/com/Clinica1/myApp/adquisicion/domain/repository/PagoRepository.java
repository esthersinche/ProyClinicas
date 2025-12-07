package com.Clinica1.myApp.adquisicion.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.adquisicion.domain.model.Pago;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.Optional;

public interface PagoRepository extends ICRUD<Pago> {
    //id del cliente
    Optional<Pago> findByIdCli(IDEntidad id_cli);
    //metodo de pago
    List<Pago> findByMetodoPago(String metodo_pago);
    //por fecha
    List<Pago> findByFechaPago(DateTimeFormat fecha_pago);
}
