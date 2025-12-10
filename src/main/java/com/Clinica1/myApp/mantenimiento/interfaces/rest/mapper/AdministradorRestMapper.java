package com.Clinica1.myApp.mantenimiento.interfaces.rest.mapper;

import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.response.AdministradorResponse;
import org.springframework.stereotype.Component;

// Mapper SOLO para dominio → response
@Component
public class AdministradorRestMapper {

    public AdministradorResponse fromDomain(Administrador admin) {
        return new AdministradorResponse(
                admin.getId_admin().obtenerid(),
                admin.getId_emp().obtenerid(),
                null // nombre no disponible aquí
        );
    }
}