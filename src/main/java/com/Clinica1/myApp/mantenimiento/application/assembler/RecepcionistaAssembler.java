package com.Clinica1.myApp.mantenimiento.application.assembler;

import com.Clinica1.myApp.mantenimiento.application.dto.RecepcionistaDto;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Recepcionista;
import org.springframework.stereotype.Component;

@Component
public class RecepcionistaAssembler {

    public RecepcionistaDto toDto(Recepcionista recep) {
        if (recep == null) return null;

        return new RecepcionistaDto(
                recep.getId_recep().obtenerid(),
                recep.getId_emp().obtenerid()
        );
    }
}