package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.ActualizarEmpleadoCommand;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActualizarEmpleadoCommandHandler {

    private final EmpleadoRepository empleadoRepository;

    public void handle(ActualizarEmpleadoCommand command) {
        IDEntidad empleadoId = IDEntidad.astring(command.getId());

        Empleado emp = empleadoRepository
                .findById(empleadoId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Empleado no encontrado")
                );

        emp.actualizarDatos(
                command.getNombre(),
                command.getApellido(),
                command.getTelefono()
        );

        empleadoRepository.update(emp);

    }
}