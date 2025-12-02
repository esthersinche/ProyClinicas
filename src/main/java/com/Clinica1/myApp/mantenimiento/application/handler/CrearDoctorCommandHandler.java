package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.command.CrearDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.exception.DomainException;
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
        // ----- VALIDACIONES PREVIAS -----

        if (command.getNombre() == null || command.getNombre().isBlank())
            throw new DomainException("El nombre no puede estar vacío");

        if (command.getApellido() == null || command.getApellido().isBlank())
            throw new DomainException("El apellido no puede estar vacío");

        if (command.getEmail() == null)
            throw new DomainException("El email es obligatorio");

        if (command.getCmp() == null || command.getCmp().isBlank())
            throw new DomainException("El CMP es obligatorio");

        // Validar duplicado por CMP
        Doctor existente = doctorRepository.findbyCMP(command.getCmp());
        if (existente != null)
            throw new DomainException("Ya existe un doctor con el CMP " + command.getCmp());


        // ----- CREAR EMAIL (PUEDE FALLAR) -----
        Email email;
        try {
            email = Email.of(command.getEmail());
        } catch (IllegalArgumentException e) {
            throw new DomainException("Email inválido: " + e.getMessage());
        }

        // ----- CREAR DOCTOR -----
        Doctor doctor = Doctor.crear(
                command.getNombre(),
                command.getApellido(),
                command.getTelefono(),
                Email.of(command.getEmail()),
                command.getPassword(),
                command.getCmp(),
                command.getConsultorio(),
                command.getEspecialidades().stream()
                        .map(Especialidad::new)
                        .collect(Collectors.toList())
        );

        // ----- INSERTAR -----
        try {
            doctorRepository.insert(doctor);
        } catch (Exception e) {
            throw new DomainException("Error al guardar el doctor: " + e.getMessage());
        }

        return doctor.getIdDoctor().obtenerid();
    }
}