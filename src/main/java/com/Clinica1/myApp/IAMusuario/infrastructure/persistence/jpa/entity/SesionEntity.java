package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "iam_sesion")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SesionEntity {
    @Id

    private String token_id;

    @Column(name = "usuweb_id", nullable = false)
    private String usuweb_id;

    @Column(name = "comienzo", nullable = false)
    private Instant comienzo;

    @Column(name = "expiracion", nullable = false)
    private Instant expiracion;
}
