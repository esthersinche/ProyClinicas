package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

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
public class FuncionEmbeddable {
    @Column(nullable = false)
    private String nombre_fun;

    @Override
    public String toString() {
        return nombre_fun;
    }
}
