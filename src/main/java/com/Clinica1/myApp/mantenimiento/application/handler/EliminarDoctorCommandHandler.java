package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.command.EliminarDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.exception.DomainException;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EliminarDoctorCommandHandler {
    private final DoctorRepository doctorRepository;

    public void handle(EliminarDoctorCommand command) {

        // --- Validar ID ---
        if (command.getIdDoctor() == null)
            throw new DomainException("El ID del doctor es obligatorio");

        Doctor doctor = doctorRepository.findById(command.getIdDoctor());

        if (doctor == null)
            throw new DomainException("Doctor no encontrado");

        try {
            doctorRepository.delete(command.getIdDoctor());
        } catch (Exception e) {
            throw new DomainException("No se pudo eliminar el doctor: " + e.getMessage());
        }
    }
}