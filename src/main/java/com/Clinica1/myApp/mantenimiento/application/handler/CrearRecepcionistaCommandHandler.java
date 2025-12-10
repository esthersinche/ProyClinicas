package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.CrearRecepcionistaCommand;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Recepcionista;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.mantenimiento.domain.repository.RecepcionistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrearRecepcionistaCommandHandler {

    private final RecepcionistaRepository recepcionistaRepository;
    private final EmpleadoRepository empleadoRepository;

    public String handle(CrearRecepcionistaCommand command) {

        IDEntidad idEmpleado = IDEntidad.astring(command.getIdEmpleado());

        if (!empleadoRepository.existsById(idEmpleado))
            throw new IllegalArgumentException("Empleado no existe");

        if (recepcionistaRepository.findByIdEmp(idEmpleado) != null)
            throw new IllegalArgumentException("El empleado ya es recepcionista");

        Recepcionista recep = Recepcionista.crear(idEmpleado);

        recepcionistaRepository.insert(recep);

        return recep.getId_recep().obtenerid();
    }
}