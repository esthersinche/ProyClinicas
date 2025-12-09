package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.CrearDoctorCommand;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CrearDoctorCommandHandler {

    private final DoctorRepository doctorRepository;
    private final EmpleadoRepository empleadoRepository;

    public void handle(CrearDoctorCommand command) {

        IDEntidad idEmpleado = IDEntidad.astring(command.getIdEmpleado());

        if (!empleadoRepository.existsById(idEmpleado))
            throw new IllegalArgumentException("Empleado no existe");

        if (doctorRepository.existsByCmp(command.getCmp()))
            throw new IllegalArgumentException("CMP ya registrado");

        Doctor doctor = Doctor.crear(
                idEmpleado,
                command.getCmp(),
                command.getConsultorio(),
                command.getEspecialidades()
                        .stream()
                        .map(Especialidad::of)
                        .toList()
        );

        doctorRepository.insert(doctor);
    }
}