package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.FuncionEmbeddable;
import com.Clinica1.myApp.SharedKernel.Email;
import org.springframework.stereotype.Component;

@Component
public class FuncionMapper {

    public Funcion ToDomain(FuncionEmbeddable fun_emb){
        return new Funcion(fun_emb.getNombre_fun());
    }

    public FuncionEmbeddable ToEmbeddable(Funcion fun){
        return FuncionEmbeddable.builder()
                .nombre_fun(fun.getNombre_fun())
                .build();
    }
}
