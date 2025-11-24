package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.DireccionEmbeddable;

import org.springframework.stereotype.Component;

@Component
public class DireccionMapper {
    // VO → Embeddable
    public static DireccionEmbeddable toEmbeddable(Direccion direccion) {
        if (direccion == null) return null;

        return DireccionEmbeddable.builder()
                .avenida(direccion.avenida())
                .calle(direccion.calle())
                .distrito(direccion.distrito())
                .pais(direccion.pais())
                .build();
    }

    // Embeddable → VO
    public static Direccion toDomain(DireccionEmbeddable embeddable) {
        if (embeddable == null) return null;

        return Direccion.of(
                embeddable.getAvenida(),
                embeddable.getCalle(),
                embeddable.getDistrito(),
                embeddable.getPais()
        );
    }
}
