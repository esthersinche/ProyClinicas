package com.Clinica1.myApp.IAMusuario.application.assembler;

import com.Clinica1.myApp.IAMusuario.application.dto.SesionDto;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Sesion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Builder
public class SesionAssembler {

    public SesionDto ToDto(Sesion ses){
        if (ses == null){
            throw new NullPointerException("La sesion es nula");
        }

        return SesionDto.builder()
                .token_id(ses.getToken_id().obtenerid())
                .emp_id(ses.getUsuweb_id().obtenerid())
                .comienzo_dto(ses.getComienzo())
                .expiracion_dto(ses.getExpiracion())
                .build();
    }

    public Sesion ToDomain(SesionDto ses_dto){
        if (ses_dto == null){
            throw new NullPointerException("La sesion es nula");
        }

        return new Sesion(IDEntidad.astring(ses_dto.getToken_id()), IDEntidad.astring(ses_dto.getEmp_id()),
                ses_dto.getComienzo_dto(), ses_dto.getExpiracion_dto());
    }

}
