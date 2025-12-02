package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Paciente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacienteEntity {
    @Id
    @Column(name = "id_pac")
    private String id_pac;
    // jpa no sabe como persistir el uuid
    @Column(name = "nombre_com_pac", nullable = false, length = 200)
    private String nombre_com_pac;

    @Column(name = "nacionalidad_pac", nullable = false, length = 20)
    private String nacionalidad_pac;

    @Column(name = "dni_pac", nullable = false, length = 10)
    private String dni_pac;

    @Column(name = "tel_pac", nullable = false, length = 9)
    private String tel_pac;

    // =============================
    // EMAIL EMBEBIDO MAPEADO
    // =============================
    @Embedded
    @AttributeOverride(name = "email_valor", column = @Column(name = "email_valor"))
    private EmailEmbeddable email_pac;

    // historial medico por incluir
    @Temporal(TemporalType.DATE) // solo fecha, anotacion usada para mapear fecha y hora de objetos date y
                                 // calendar
    // a su correspondiente tipo de columna en la bd

    @Column(name = "fec_pac", nullable = false)
    private Date fec_nac_pac;

    @Column(name = "sexo_pac", nullable = false, length = 10)
    private String sexo_pac;
    /*
     * porsia
     * 
     * @ManyToOne
     * 
     * @JoinColumn(name = "clin_id")
     * private ClinicaEntity clinica;
     */
}
