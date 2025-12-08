package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionEmbeddableTest {

    @Test
    void constructorYGetters_funcionanCorrectamente() {
        FuncionEmbeddable fun = new FuncionEmbeddable("Atender");

        assertEquals("Atender", fun.getNombre_fun());
    }

    @Test
    void builder_creaInstanciaCorrecta() {
        FuncionEmbeddable fun = FuncionEmbeddable.builder()
                .nombre_fun("Buscar")
                .build();

        assertEquals("Buscar", fun.getNombre_fun());
    }

    @Test
    void toString_retornaValorCorrecto() {
        FuncionEmbeddable fun = new FuncionEmbeddable("Registrar");

        assertEquals("Registrar", fun.toString());
    }
}
