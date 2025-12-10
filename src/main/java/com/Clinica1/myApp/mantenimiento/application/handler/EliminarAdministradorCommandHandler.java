package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.EliminarAdministradorCommand;
import com.Clinica1.myApp.mantenimiento.domain.repository.AdministradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EliminarAdministradorCommandHandler {

    private final AdministradorRepository administradorRepository;

    public void handle(EliminarAdministradorCommand command) {
        administradorRepository.delete(IDEntidad.astring(command.getIdAdmin()));
    }
}