package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EspecialidadEmbeddable {

    @Column(nullable = false)
    private String nom_espe;
}
