package com.Clinica1.myApp.mantenimiento.interfaces.rest.mapper;

import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Recepcionista;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.response.RecepcionistaResponse;
import org.springframework.stereotype.Component;

@Component
public class RecepcionistaRestMapper {

    public RecepcionistaResponse fromDomain(Recepcionista recep) {
        if (recep == null) return null;

        return new RecepcionistaResponse(
                recep.getId_recep().obtenerid(),
                recep.getId_emp().obtenerid(),
                null // nombre no disponible aquí
        );
    }
}