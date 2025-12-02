package com.Clinica1.myApp.mantenimiento.application.handler;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.ActualizarDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.exception.DomainException;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ActualizarDoctorCommandHandler {
    private final DoctorRepository doctorRepository;

    public Doctor handle(ActualizarDoctorCommand command) {

        // --- Validar ID ---
        if (command.getIdDoctor() == null)
            throw new DomainException("El ID del doctor es obligatorio");

        Doctor doctor = doctorRepository.findById(command.getIdDoctor());

        if (doctor == null)
            throw new DomainException("Doctor no encontrado");

        // --- Validaciones simples ---
        if (command.getCmp() == null || command.getCmp().isBlank())
            throw new DomainException("El CMP no puede estar vacío");

        if (command.getConsultorio() == null || command.getConsultorio().isBlank())
            throw new DomainException("El consultorio no puede estar vacío");

        if (command.getEspecialidades() == null || command.getEspecialidades().isEmpty())
            throw new DomainException("Debe registrar al menos una especialidad");


        // --- Evitar duplicado de CMP al actualizar ---
        Doctor existente = doctorRepository.findbyCMP(command.getCmp());
        if (existente != null && !existente.getIdDoctor().equals(command.getIdDoctor())) {
            throw new DomainException("Ya existe un doctor con el CMP " + command.getCmp());
        }

        // --- Actualizar el dominio ---
        doctor.actualizarDatos(
                command.getCmp(),
                command.getConsultorio(),
                command.getEspecialidades().stream()
                        .map(Especialidad::new)
                        .collect(Collectors.toList())
        );

        try {
            return doctorRepository.update(doctor);
        } catch (Exception e) {
            throw new DomainException("Error al actualizar el doctor: " + e.getMessage());
        }
    }
}