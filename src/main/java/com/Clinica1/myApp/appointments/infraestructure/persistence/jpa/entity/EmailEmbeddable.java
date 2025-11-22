package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

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
public class EmailEmbeddable {
    //dto para la bd
    @Column(nullable = false)
    private String email_valor;
}
