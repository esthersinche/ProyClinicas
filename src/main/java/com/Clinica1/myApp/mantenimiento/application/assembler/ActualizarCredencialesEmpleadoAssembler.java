package com.Clinica1.myApp.mantenimiento.application.assembler;

import com.Clinica1.myApp.mantenimiento.application.command.ActualizarCredencialesEmpleadoCommand;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.ActualizarCredencialesEmpleadoRequest;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.stereotype.Component;

@Component
public class ActualizarCredencialesEmpleadoAssembler {

    public ActualizarCredencialesEmpleadoCommand toCommand(ActualizarCredencialesEmpleadoRequest req) {
        return new ActualizarCredencialesEmpleadoCommand(
                IDEntidad.astring(req.getIdEmpleado()),
                req.getNuevaPassword()
        );
    }
}