package com.Clinica1.myApp.IAMusuario.application.assembler;

import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.EmpleadoIAM;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Builder
public class TokenAssembler {

    public TokenDto ToDto(EmpleadoIAM emp, String jwt, long expiracion, List<String> funciones){

        return TokenDto.builder()
                .accesstoken(jwt)
                .id_emp(emp.getId_empiam().obtenerid())
                .expiracion(expiracion)
                .funciones(funciones)
                .build();

    }
}
