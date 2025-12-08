package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Recepcionista;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.RecepcionistaEntity;
import org.springframework.stereotype.Component;

@Component
public class RecepcionistaMapper {

    public Recepcionista ToDomain(RecepcionistaEntity recep_ent){
        return new Recepcionista(IDEntidad.astring(recep_ent.getId_recep()),
                IDEntidad.astring(recep_ent.getId_emp()));
    }

    public RecepcionistaEntity ToEntity(Recepcionista recep){
        return RecepcionistaEntity.builder()
                .id_recep(recep.getId_recep().obtenerid())
                .id_emp(recep.getId_recep().obtenerid())
                .build();
    }
}
