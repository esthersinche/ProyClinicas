package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Doctor")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorEntity {
    @Id
    private String id_doc; //en referencia a doctor solamente, ya q los dos bc tienen reglas e identidad

    @Column(name = "id_emp_doc", nullable = false)
    private String id_empleado_doc;//en referencia a id de empleado
    //diferente

    @Column(name = "nom_com_doc", nullable = false)
    private NombreCompletoEmbeddable nom_com_doc;

    @Column(name= "cmp_doc", nullable = false)
    private String cmp_doc;

    @Column(name= "consultorio_doc", nullable = false)
    private String consultorio_doc;

    //persistir listas de VO
    @ElementCollection//anotacion q mapea una coleccion de basicos u objetos embeddable a una tabla separada en la bd
    //mapear non-entities
    @CollectionTable(name = "especialidades", joinColumns = @JoinColumn(name = "id_doc"))//usado con el de arriba para
    //dar nombre a la tabla, columna relacionada
    private List<EspecialidadEmbeddable> especialidades;

    /* @ManyToOne
    @JoinColumn(name = "clin_id")
    private ClinicaEntity clinica;*/


}
