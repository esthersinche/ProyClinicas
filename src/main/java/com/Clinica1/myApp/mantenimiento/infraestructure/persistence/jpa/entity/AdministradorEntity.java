package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "administrador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdministradorEntity {
    @Id
    @Column(name = "id_admin", nullable = false)
    private String id_admin;

    @Column(name = "id_emp", nullable = false)
    private String id_emp;

    @Column(name = "nomcom_admin", nullable = false)
    private NombreCompletoEmbeddable nomcom_admin;
}
