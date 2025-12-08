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
public class DireccionEmbeddable {
    @Column(nullable = false)
    private String avenida;

    @Column(nullable = false)
    private String distrito;

    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private String provincia;



}
