package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Clinicas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClinicaEntity {
    @Id
    @Column(name = "id_cli")
    private String id_cli;

    @Column(name = "nom_clie", nullable = false, length = 40)
    private String nom_clin;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "avenida", column = @Column(name = "dir_av")),
            @AttributeOverride(name = "distrito", column = @Column(name = "distrito")),
            @AttributeOverride(name = "departamento", column = @Column(name = "departamento")),
            @AttributeOverride(name = "provincia", column = @Column(name = "provincia"))
    })
    private DireccionEmbeddable dir_clin;

    @OneToMany(mappedBy = "clinica")
    private List<DoctorEntity> doctorescli;

    @OneToMany(mappedBy = "clinica")
    private List<PacienteEntity> pacientescli;
}
