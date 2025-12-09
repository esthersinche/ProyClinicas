package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Nombrecompleto;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.AdministradorEntity;
import org.springframework.stereotype.Component;

@Component
public class AdministradorMapper {
    private final NombreCompletoMapper nomcom_map;

    public AdministradorMapper(NombreCompletoMapper nomcom_map) {
        this.nomcom_map = nomcom_map;
    }

    public Administrador ToDomain(AdministradorEntity admin_ent){
        Nombrecompleto nomcom_admin= nomcom_map.ToDomain(admin_ent.getNomcom_admin());
        return new Administrador(IDEntidad.astring(admin_ent.getId_admin()),
                IDEntidad.astring(admin_ent.getId_emp()), nomcom_admin);
    }

    public AdministradorEntity ToEntity(Administrador admin){
        return AdministradorEntity.builder()
                .id_admin(admin.getId_admin().obtenerid())
                .id_emp(admin.getId_emp().obtenerid())
                .build();
    }
}
