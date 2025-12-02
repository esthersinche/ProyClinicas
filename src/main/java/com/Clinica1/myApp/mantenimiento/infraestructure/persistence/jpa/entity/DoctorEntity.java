package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity;

import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.NombreCompletoEmbeddable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorEntity {

    @Id
    @Column(name = "id_doctor", length = 36)
    private String idDoctor;

    @Column(name = "id_empleado", nullable = false, unique = true)
    private String idEmpleado; // Solo FK, sin relación JPA

    @Embedded
    private NombreCompletoEmbeddable nombreCompleto;

    @Column(name = "cmp", nullable = false, unique = true, length = 20)
    private String cmp;

    @Column(name = "consultorio", nullable = false, length = 50)
    private String consultorio;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "doctor_especialidades",
            joinColumns = @JoinColumn(name = "id_doctor")
    )
    @Column(name = "especialidad")
    private List<String> especialidades;
}