package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Sesion;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.SesionEntity;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class SesionMapperTest {

    private final SesionMapper mapper = new SesionMapper();

    @Test
    void ToEntity_convierteCorrectamente() {
        IDEntidad token = IDEntidad.generar();
        IDEntidad usuario = IDEntidad.generar();
        Instant inicio = Instant.now();
        Instant fin = inicio.plusSeconds(300);

        Sesion sesion = new Sesion(token, usuario, inicio, fin);

        SesionEntity entity = mapper.ToEntity(sesion);

        assertNotNull(entity);
        assertEquals(token.obtenerid(), entity.getToken_id());
        assertEquals(usuario.obtenerid(), entity.getUsuweb_id());
        assertEquals(inicio, entity.getComienzo());
        assertEquals(fin, entity.getExpiracion());
    }

    @Test
    void ToDomain_convierteCorrectamente() {
        IDEntidad token = IDEntidad.generar();
        IDEntidad usuario = IDEntidad.generar();
        Instant inicio = Instant.now();
        Instant fin = inicio.plusSeconds(300);

        SesionEntity entity = SesionEntity.builder()
                .token_id(token.obtenerid())
                .usuweb_id(usuario.obtenerid())
                .comienzo(inicio)
                .expiracion(fin)
                .build();

        Sesion ses = mapper.ToDomain(entity);

        assertNotNull(ses);
        assertEquals(token.obtenerid(), ses.getToken_id().obtenerid());
        assertEquals(usuario.obtenerid(), ses.getUsuweb_id().obtenerid());
        assertEquals(inicio, ses.getComienzo());
        assertEquals(fin, ses.getExpiracion());
    }

    @Test
    void conversionBidireccional_mantieneInformacion() {
        IDEntidad token = IDEntidad.generar();
        IDEntidad usuario = IDEntidad.generar();
        Instant inicio = Instant.now();
        Instant fin = inicio.plusSeconds(300);

        Sesion original = new Sesion(token, usuario, inicio, fin);

        SesionEntity entity = mapper.ToEntity(original);
        Sesion convertido = mapper.ToDomain(entity);

        assertEquals(original.getToken_id().obtenerid(), convertido.getToken_id().obtenerid());
        assertEquals(original.getUsuweb_id().obtenerid(), convertido.getUsuweb_id().obtenerid());
        assertEquals(original.getComienzo(), convertido.getComienzo());
        assertEquals(original.getExpiracion(), convertido.getExpiracion());
    }
}
