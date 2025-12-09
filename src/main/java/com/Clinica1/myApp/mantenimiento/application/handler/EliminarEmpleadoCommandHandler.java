package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.EliminarEmpleadoCommand;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EliminarEmpleadoCommandHandler {
    private final EmpleadoRepository empleadoRepository;

    public void handle(EliminarEmpleadoCommand command) {
        empleadoRepository.delete(
                IDEntidad.astring(command.getId())
        );
    }
}
