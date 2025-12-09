package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EspecialidadEmbeddable;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.NombreCompletoEmbeddable;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;

import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.DoctorEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorMapper {

    public Doctor toDomain(DoctorEntity entity) {
        if (entity == null) return null;

        return Doctor.reconstruir(
                IDEntidad.astring(entity.getIdDoctor()),
                IDEntidad.astring(entity.getIdEmpleado()),
                entity.getCmp(),
                entity.getConsultorio(),
                entity.getEspecialidades()
                        .stream()
                        .map(e -> Especialidad.of(e.getNom_espe()))
                        .toList()
        );
    }

    public DoctorEntity toEntity(Doctor doctor) {
        if (doctor == null) return null;

        return DoctorEntity.builder()
                .idDoctor(doctor.getIdDoctor().obtenerid())
                .idEmpleado(doctor.getIdEmpleado().obtenerid())
                .cmp(doctor.getCmp())
                .consultorio(doctor.getConsultorio())
                .especialidades(
                        doctor.getEspecialidades().stream()
                                .map(e -> EspecialidadEmbeddable.builder()
                                        .nom_espe(e.nom_espe())
                                        .build())
                                .toList()
                )
                .build();
    }

}