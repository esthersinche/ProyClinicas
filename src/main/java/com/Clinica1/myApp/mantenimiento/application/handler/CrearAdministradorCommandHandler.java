package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.CrearAdministradorCommand;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;
import com.Clinica1.myApp.mantenimiento.domain.repository.AdministradorRepository;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrearAdministradorCommandHandler {
    private final AdministradorRepository administradorRepository;
    private final EmpleadoRepository empleadoRepository;

    public String handle(CrearAdministradorCommand command) {

        IDEntidad idEmpleado = IDEntidad.astring(command.getIdEmpleado());

        if (!empleadoRepository.existsById(idEmpleado))
            throw new IllegalArgumentException("Empleado no existe");

        if (administradorRepository.findByIdEmp(idEmpleado) != null)
            throw new IllegalArgumentException("El empleado ya es administrador");

        Administrador admin = Administrador.crear(idEmpleado);

        administradorRepository.insert(admin);
        return admin.getId_admin().obtenerid();
    }
}
