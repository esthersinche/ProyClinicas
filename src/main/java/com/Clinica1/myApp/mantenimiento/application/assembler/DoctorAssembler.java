package com.Clinica1.myApp.mantenimiento.application.assembler;

import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DoctorAssembler {
    public DoctorDto toDto(Doctor doctor) {
        if (doctor == null) return null;

        return new DoctorDto(
                doctor.getIdDoctor().obtenerid(),
                doctor.getIdEmpleado().obtenerid(),
                doctor.getNombreCompleto().completar(),
                doctor.getCmp(),
                doctor.getConsultorio(),
                doctor.getEspecialidades()
                        .stream()
                        .map(e -> e.nom_espe())
                        .collect(Collectors.toList())
        );
    }
}
