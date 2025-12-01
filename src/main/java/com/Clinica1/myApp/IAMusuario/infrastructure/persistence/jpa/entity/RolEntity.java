package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Rol")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// luego en la BD hacer
public class RolEntity {

    @Id
    @Column(name = "id_rol", length = 36)
    private String id; // IDEntidad.obtenerid()

    @Column(name = "nombre_rol", nullable = false, unique = true, length = 50)
    private String nombreRol;

    // Guardamos Funciones como strings en una tabla aparte
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Rol_Funciones", joinColumns = @JoinColumn(name = "rol_id"))
    @Column(name = "funcion", nullable = false, length = 80)
    private Set<FuncionEmbeddable> funciones = new HashSet<>();


}
