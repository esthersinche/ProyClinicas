package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;

import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Nombrecompleto;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.NombreCompletoEmbeddable;

public class NombreCompletoMapper {
    public Nombrecompleto ToDomain(NombreCompletoEmbeddable nomcom_emb){
        return new Nombrecompleto(nomcom_emb.getNombre(), nomcom_emb.getApellido());
    }

    public NombreCompletoEmbeddable ToEmbeddable(Nombrecompleto nomnom){
        return NombreCompletoEmbeddable.builder()
                .nombre(nomnom.nombre())
                .apellido(nomnom.apellido())
                .build();
    }
}
