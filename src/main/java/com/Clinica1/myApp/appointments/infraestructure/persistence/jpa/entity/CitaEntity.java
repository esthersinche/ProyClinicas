package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Clinica;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Cita")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaEntity {
    @Id
    private String id_cita;

    @Column(name = "motivo_cita", nullable = false, length = 2500)
    private String motivo_cita;

    @Column(name = "estado_cita", nullable = false, length = 9)
    private String estado_cita;

    @Column(name = "canal_cita", nullable = false, length = 10)
    private String canal_cita;

    @Temporal(TemporalType.TIMESTAMP)//fecha y hr
    @Column(name = "inicio_cita", nullable = false)
    private LocalDateTime inicio_cita; //cambiar a date y hora typeshi, luego cambiar a VO

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fin_cita", nullable = false)
    private LocalDateTime fin_cita;//luego cambiar a VO

    //otros
    @Column(name = "pac_id", nullable = false)
    private String pac_id;

    @Column(name = "doc_id", nullable = false)
    private String doc_id;

    @Embedded
    private Pac_info_cita_embeddable pac_info;

    @Embedded
    private Doc_info_cita_embeddable doc_info;
    //private Paciente inst_pac; //nombres, dni
    //private Doctor inst_doctor; //nombre, especialidad, consultorio por ahora
    @Embedded
    private EspecialidadEmbeddable espe_cita;// por si acaso
    /*
    private Clinica inst_clin; //nombre
    private Direccion dir_clin_cita;*/
}
