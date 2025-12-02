package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.command.CrearDoctorCommand;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CrearDoctorCommandHandler {

    private final DoctorRepository doctorRepository;

    public String handle(CrearDoctorCommand command) {

        Doctor doctor = Doctor.crear(
                command.getNombre(),
                command.getApellido(),
                command.getTelefono(),
                Email.of(command.getEmail()),
                command.getCmp(),
                command.getConsultorio(),
                command.getEspecialidades().stream()
                        .map(Especialidad::new)
                        .collect(Collectors.toList())
        );

        doctorRepository.insert(doctor);
        return doctor.getIdDoctor().obtenerid();
    }
}