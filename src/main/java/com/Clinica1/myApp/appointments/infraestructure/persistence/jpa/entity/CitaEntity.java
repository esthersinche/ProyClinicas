package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

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
    @Column(name = "id_cita")
    private String id_cita;

    @Column(name = "motivo_cita", nullable = false, length = 2500)
    private String motivo_cita;

    @Column(name = "estado_cita", nullable = false, length = 9)
    private String estado_cita;

    @Column(name = "canal_cita", nullable = false, length = 10)
    private String canal_cita;

    @Column(name = "inicio_cita", nullable = false)
    private LocalDateTime inicio_cita; // cambiar a date y hora typeshi, luego cambiar a VO

    @Column(name = "fin_cita", nullable = false)
    private LocalDateTime fin_cita;// luego cambiar a VO

    // otros
    @Column(name = "pac_id", nullable = false)
    private String pac_id;

    @Column(name = "doc_id", nullable = false)
    private String doc_id;

    // ============================
    // EMBEBIDO PACIENTE
    // ============================
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nombreCompleto", column = @Column(name = "nomb_com_pac")),
            @AttributeOverride(name = "dni", column = @Column(name = "dni_pac"))
    })
    private Pac_info_cita_embeddable pac_info;

    // ============================
    // EMBEBIDO DOCTOR
    // ============================
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nombreCompleto", column = @Column(name = "nombre_doc")),
            @AttributeOverride(name = "especialidad", column = @Column(name = "espe_doc")),
            @AttributeOverride(name = "consultorio", column = @Column(name = "consult_doc")),
            @AttributeOverride(name = "cmp", column = @Column(name = "cmp_doc"))
    })
    private Doc_info_cita_embeddable doc_info;
    // private Paciente inst_pac; //nombres, dni
    // private Doctor inst_doctor; //nombre, especialidad, consultorio por ahora

    // ============================
    // EMBEBIDO ESPECIALIDAD
    // ============================
    @Embedded
    @AttributeOverride(name = "nombreEspecialidad", column = @Column(name = "nom_espe"))

    private EspecialidadEmbeddable espe_cita;// por si acaso
    /*
     * private Clinica inst_clin; //nombre
     * private Direccion dir_clin_cita;
     */
}
