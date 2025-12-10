package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity;

import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EspecialidadEmbeddable;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.NombreCompletoEmbeddable;
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
    @Column(name = "id_doc", length = 36)
    private String idDoctor;

    @Column(name = "id_empleado_doc", nullable = false, unique = true)
    private String idEmpleado; // Solo FK, sin relación JPA

    @Column(name = "cmp_doc", nullable = false, unique = true, length = 20)
    private String cmp;

    @Column(name = "consultorio_doc", nullable = false, length = 50)
    private String consultorio;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "Doctor_Especialidad",
            joinColumns = @JoinColumn(name = "id_doc")
    )
    private List<EspecialidadEmbeddable> especialidades;
}