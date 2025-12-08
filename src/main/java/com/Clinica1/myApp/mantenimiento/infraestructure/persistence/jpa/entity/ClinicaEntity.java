package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "clinica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClinicaEntity {
    private String id_clin;
    private String nombre_cli;

}
