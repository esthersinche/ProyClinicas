package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;

import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.DoctorEntity;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.NombreCompletoEmbeddable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class DoctorMapper {

    public Doctor toDomain(DoctorEntity entity) {
        if (entity == null) return null;

        try {
            List<Especialidad> especialidades = entity.getEspecialidades().stream()
                    .map(Especialidad::new)
                    .collect(Collectors.toList());

            Doctor doctor = Doctor.crear(
                    IDEntidad.astring(entity.getIdEmpleado()),
                    entity.getNombreCompleto().getNombre(),
                    entity.getNombreCompleto().getApellido(),
                    entity.getCmp(),
                    entity.getConsultorio(),
                    especialidades
            );

            // Setear el ID real
            setPrivateField(doctor, "idDoctor", IDEntidad.astring(entity.getIdDoctor()));

            return doctor;

        } catch (Exception e) {
            throw new RuntimeException("Error al mapear DoctorEntity a Doctor: " + e.getMessage(), e);
        }
    }

    public DoctorEntity toEntity(Doctor doctor) {
        if (doctor == null) return null;

        NombreCompletoEmbeddable nombreEmb = NombreCompletoEmbeddable.builder()
                .nombre(doctor.getNombreCompleto().nombre())
                .apellido(doctor.getNombreCompleto().apellido())
                .build();

        List<String> especialidades = doctor.getEspecialidades().stream()
                .map(Especialidad::nom_espe)
                .collect(Collectors.toList());

        return DoctorEntity.builder()
                .idDoctor(doctor.getIdDoctor().obtenerid())
                .idEmpleado(doctor.getIdEmpleado().obtenerid())
                .nombreCompleto(nombreEmb)
                .cmp(doctor.getCmp())
                .consultorio(doctor.getConsultorio())
                .especialidades(especialidades)
                .build();
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}