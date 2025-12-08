package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clinica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClinicaEntity {
    @Id
    @Column(name = "id_cli", nullable = false)
    private String id_clin;

    @Column(name = "nombre_cli", nullable = false)
    private String nombre_cli;

    @Embedded
    private DireccionEmbeddable dir_cli;

    @Column(name = "ruc_cli", nullable = false)
    private String ruc_cli;


    private List<EmpleadoEntity> emp_cli;

}
