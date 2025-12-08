package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UsuarioWeb")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioWebEntity {

    @Id
    @Column(name = "id_usuweb", length = 36)
    private String id_usuweb;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "passhash", nullable = false)
    private String passhash;

    @Column(name = "id_emp", nullable = false, length = 36)
    private String id_emp;
}
