package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EspecialidadEmbeddable;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.NombreCompletoEmbeddable;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;

import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Nombrecompleto;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.DoctorEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class DoctorMapper {

    public Doctor toDomain(DoctorEntity entity) {
        if (entity == null) return null;

        List<Especialidad> especialidades = entity.getEspecialidades().stream()
                .map(e -> new Especialidad(e.getNom_espe()))
                .toList();

        return Doctor.reconstruir(
                IDEntidad.astring(entity.getIdDoctor()),
                IDEntidad.astring(entity.getIdEmpleado()),
                new Nombrecompleto(
                        entity.getNombreCompleto().getNombre(),
                        entity.getNombreCompleto().getApellido()
                ),
                entity.getCmp(),
                entity.getConsultorio(),
                especialidades
        );
    }

    public DoctorEntity toEntity(Doctor doctor) {
        if (doctor == null) return null;

        NombreCompletoEmbeddable nombreEmb = NombreCompletoEmbeddable.builder()
                .nombre(doctor.getNombreCompleto().nombre())
                .apellido(doctor.getNombreCompleto().apellido())
                .build();

        List<EspecialidadEmbeddable> especialidades = doctor.getEspecialidades().stream()
                .map(e -> EspecialidadEmbeddable.builder()
                        .nom_espe(e.nom_espe())
                        .build())
                .toList();

        return DoctorEntity.builder()
                .idDoctor(doctor.getIdDoctor().obtenerid())
                .idEmpleado(doctor.getIdEmpleado().obtenerid())
                .nombreCompleto(nombreEmb)
                .cmp(doctor.getCmp())
                .consultorio(doctor.getConsultorio())
                .especialidades(especialidades)
                .build();
    }

}