package com.Clinica1.myApp.adquisicion.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.adquisicion.domain.model.UsuarioWeb;

import java.util.List;
import java.util.Optional;

public interface UsuarioWebRepository extends ICRUD<UsuarioWeb> {
    //razon social
    Optional<UsuarioWeb> findByRazonSocial(String razsoc_usuweb);
    //ruc
    Optional<UsuarioWeb> findByRUC(String ruc_usuweb);
    //si relaizo el pago
    List<UsuarioWeb> findbyPagoRealizado(boolean pagoreal_usuweb);
    //por monto? como un filtro?
}
