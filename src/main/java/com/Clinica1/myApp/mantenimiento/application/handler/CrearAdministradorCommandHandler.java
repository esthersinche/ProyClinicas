package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.CrearAdministradorCommand;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;
import com.Clinica1.myApp.mantenimiento.domain.repository.AdministradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrearAdministradorCommandHandler {
    private final AdministradorRepository repository;

    public void handle(CrearAdministradorCommand command) {

        IDEntidad idEmpleado = IDEntidad.astring(command.getIdEmpleado());


        if (repository.findByIdEmp(idEmpleado) != null) {
            throw new IllegalStateException("El empleado ya tiene rol de administrador");
        }

        Administrador admin = Administrador.crear(
                idEmpleado,
                command.
        );

        repository.insert(admin);
    }
}
