package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EspecialidadEmbeddable;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadesMapper {
    public Especialidad ToDomain(EspecialidadEmbeddable espe_emb){
        return new Especialidad(
                espe_emb.getNom_espe()
        );
    }

    public EspecialidadEmbeddable ToEntity(Especialidad espe){
        return EspecialidadEmbeddable.builder().nom_espe(espe.nom_espe()).build();
    }
}
