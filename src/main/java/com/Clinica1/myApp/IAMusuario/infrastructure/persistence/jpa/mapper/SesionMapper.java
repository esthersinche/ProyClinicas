package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Sesion;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.SesionEntity;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class SesionMapper {

    public Sesion ToDomain(SesionEntity ses_ent){
        return new Sesion(IDEntidad.astring(ses_ent.getToken_id()), IDEntidad.astring(ses_ent.getUsuweb_id()),
                ses_ent.getComienzo(), ses_ent.getExpiracion());
    }

    public SesionEntity ToEntity(Sesion ses){
        return SesionEntity.builder().token_id(ses.getToken_id().obtenerid())
                .usuweb_id(ses.getUsuweb_id().obtenerid())
                .comienzo(ses.getComienzo())
                .expiracion(ses.getExpiracion())
                .build();
    }
}
