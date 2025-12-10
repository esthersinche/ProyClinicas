package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Nombrecompleto;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.AdministradorEntity;
import org.springframework.stereotype.Component;

@Component
public class AdministradorMapper {

    // Entity -> Domain
    public Administrador toDomain(AdministradorEntity entity) {
        if (entity == null) return null;

        return Administrador.reconstruir(
                IDEntidad.astring(entity.getId_admin()),
                IDEntidad.astring(entity.getId_emp())
        );
    }

    // Domain -> Entity
    public AdministradorEntity toEntity(Administrador domain) {
        if (domain == null) return null;

        return AdministradorEntity.builder()
                .id_admin(domain.getId_admin().obtenerid())
                .id_emp(domain.getId_emp().obtenerid())
                .build();
    }
}