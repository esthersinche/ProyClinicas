package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.IAMusuario.application.services.ContraService;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.Roles;
import com.Clinica1.myApp.mantenimiento.application.command.CrearEmpleadoCommand;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrearEmpleadoCommandHandler {

    private final EmpleadoRepository empleadoRepository;
    private final ContraService contraService;

    public void handle(CrearEmpleadoCommand command) {

        if (empleadoRepository.existsByEmail(command.getEmail()))
            throw new IllegalArgumentException("Email ya registrado");

        String hash = contraService.hash(command.getPassword());

        Empleado empleado = Empleado.crearemp(
                command.getNombre(),
                command.getApellido(),
                command.getTelefono(),
                new Email(command.getEmail()),
                hash,
                Roles.valueOf(command.getRol())
        );

        empleadoRepository.insert(empleado);
    }
}