package com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Rol") // luego en la BD hacer
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
    private Set<String> funciones = new HashSet<>();

    public RolEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Set<String> getFunciones() {
        return funciones;
    }

    public void setFunciones(Set<String> funciones) {
        this.funciones = funciones;
    }
}
