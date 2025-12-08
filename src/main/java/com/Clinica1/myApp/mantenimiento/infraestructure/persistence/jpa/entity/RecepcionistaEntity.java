package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "recepcionista")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecepcionistaEntity {
    @Id
    @Column(name = "id_recep", nullable = false)
    private String id_recep;

    @Column(name = "id_emp", nullable = false)
    private String id_emp;
}
