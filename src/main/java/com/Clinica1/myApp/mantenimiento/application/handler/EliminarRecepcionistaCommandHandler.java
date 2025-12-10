package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.EliminarRecepcionistaCommand;
import com.Clinica1.myApp.mantenimiento.domain.repository.RecepcionistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EliminarRecepcionistaCommandHandler {

    private final RecepcionistaRepository recepcionistaRepository;

    public void handle(EliminarRecepcionistaCommand command) {
        recepcionistaRepository.delete(
                IDEntidad.astring(command.getIdRecepcionista())
        );
    }
}
