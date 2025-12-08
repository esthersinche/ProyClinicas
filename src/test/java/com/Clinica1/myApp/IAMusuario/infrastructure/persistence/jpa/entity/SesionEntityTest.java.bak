package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class SesionEntityTest {

    @Test
    void constructorYGetters_funcionanCorrectamente() {
        Instant inicio = Instant.now();
        Instant fin = inicio.plusSeconds(3600);

        SesionEntity sesion = new SesionEntity(
                "TOKEN123",
                "USER987",
                inicio,
                fin);

        assertEquals("TOKEN123", sesion.getToken_id());
        assertEquals("USER987", sesion.getUsuweb_id());
        assertEquals(inicio, sesion.getComienzo());
        assertEquals(fin, sesion.getExpiracion());
    }

    @Test
    void builder_creaInstanciaCorrecta() {
        Instant inicio = Instant.now();
        Instant fin = inicio.plusSeconds(7200);

        SesionEntity sesion = SesionEntity.builder()
                .token_id("TOKEN555")
                .usuweb_id("USER111")
                .comienzo(inicio)
                .expiracion(fin)
                .build();

        assertEquals("TOKEN555", sesion.getToken_id());
        assertEquals("USER111", sesion.getUsuweb_id());
        assertEquals(inicio, sesion.getComienzo());
        assertEquals(fin, sesion.getExpiracion());
    }

    @Test
    void setters_noExisten_peroGetterDevuelveCorrecto() {
        Instant inicio = Instant.now();
        Instant fin = inicio.plusSeconds(3000);

        SesionEntity sesion = new SesionEntity(
                "TOK",
                "USR",
                inicio,
                fin);

        assertNotNull(sesion.getToken_id());
        assertNotNull(sesion.getUsuweb_id());
        assertNotNull(sesion.getComienzo());
        assertNotNull(sesion.getExpiracion());
    }
}
