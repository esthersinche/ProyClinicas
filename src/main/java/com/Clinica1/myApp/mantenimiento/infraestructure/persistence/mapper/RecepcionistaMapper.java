package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Recepcionista;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.RecepcionistaEntity;
import org.springframework.stereotype.Component;

@Component
public class RecepcionistaMapper {

    // Entity -> Domain
    public Recepcionista toDomain(RecepcionistaEntity entity) {
        if (entity == null) return null;

        return Recepcionista.reconstruir(
                IDEntidad.astring(entity.getId_recep()),
                IDEntidad.astring(entity.getId_emp())
        );
    }

    // Domain -> Entity
    public RecepcionistaEntity toEntity(Recepcionista domain) {
        if (domain == null) return null;

        return RecepcionistaEntity.builder()
                .id_recep(domain.getId_recep().obtenerid())
                .id_emp(domain.getId_emp().obtenerid())
                .build();
    }
}