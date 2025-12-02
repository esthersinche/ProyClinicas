package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.DireccionEmbeddable;

import org.springframework.stereotype.Component;

@Component
public class DireccionMapper {
    // VO → Embeddable
    public static DireccionEmbeddable toEmbeddable(Direccion direccion) {
        if (direccion == null)
            return null;

        return DireccionEmbeddable.builder()
                .avenida(direccion.avenida())
                .distrito(direccion.distrito())
                .departamento(direccion.departamento())
                .provincia(direccion.provincia())
                .build();
    }

    // Embeddable → VO
    public static Direccion toDomain(DireccionEmbeddable embeddable) {
        if (embeddable == null)
            return null;

        return Direccion.of(
                embeddable.getAvenida(),
                embeddable.getDistrito(),
                embeddable.getDepartamento(),
                embeddable.getProvincia());
    }
}
