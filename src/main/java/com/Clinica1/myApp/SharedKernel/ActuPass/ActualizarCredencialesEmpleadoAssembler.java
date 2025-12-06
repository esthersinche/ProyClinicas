package com.Clinica1.myApp.SharedKernel.ActuPass;

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