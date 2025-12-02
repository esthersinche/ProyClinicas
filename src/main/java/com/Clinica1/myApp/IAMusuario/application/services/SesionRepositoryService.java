package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.IAMusuario.application.dto.SesionDto;

public interface SesionRepositoryService {
    void guardar(SesionDto ses_dto);
    void eliminar(String id_ses);
}
