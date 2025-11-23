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
public class Pac_info_cita_embeddable {

    @Column(nullable = false)
    private String nomb_com_pac;
    @Column(nullable = false)
    private String dni_pac;
}
