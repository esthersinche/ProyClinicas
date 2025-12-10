package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Nombrecompleto;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.AdministradorEntity;
import org.springframework.stereotype.Component;

@Component
public class AdministradorMapper {

    public AdministradorEntity toEntity(Administrador admin) {
        return AdministradorEntity.builder()
                .id_admin(admin.getId_admin().obtenerid())
                .id_emp(admin.getId_emp().obtenerid())
                .build();
    }

    public Administrador toDomain(AdministradorEntity entity) {
        return Administrador.reconstruir(
                IDEntidad.astring(entity.getId_admin()),
                IDEntidad.astring(entity.getId_emp())
        );
    }
}
