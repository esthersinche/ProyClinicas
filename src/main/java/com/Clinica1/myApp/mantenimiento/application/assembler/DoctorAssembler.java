package com.Clinica1.myApp.mantenimiento.application.assembler;

import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DoctorAssembler {
    public DoctorDto toDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getIdDoctor().obtenerid(),
                doctor.getNombreCompleto().nombre(),
                doctor.getNombreCompleto().apellido(),
                doctor.getCmp(),
                doctor.getConsultorio(),
                doctor.getEspecialidades().stream()
                        .map(Especialidad::nom_espe)
                        .toList()
        );
    }
}
