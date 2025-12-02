package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.IAMusuario.application.dto.SesionDto;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.Optional;

public interface SesionRepositoryService {
    void guardar(SesionDto ses_dto);
    Optional<SesionDto> findById(String id_ses);
    boolean eliminarById(String id_ses);
    boolean existeById(String id_ses);
}
