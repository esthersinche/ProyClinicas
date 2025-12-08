package com.Clinica1.myApp.mantenimiento.application.assembler;

import com.Clinica1.myApp.mantenimiento.application.dto.AdministradorDto;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;
import org.springframework.stereotype.Component;

@Component
public class AdministradorAssembler {
    public AdministradorDto ToDto(Administrador admin){
        //falta nombrecompleto, hacer eso
    }

}
