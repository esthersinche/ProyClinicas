package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
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
    @Column(name = "id_usuweb") //
    // no es necesario poner column name
    private String id_usuweb;

    // ============================
    // EMAIL EMBEBIDO — OVERRIDE
    // ============================
    @Embedded
    @AttributeOverride(name = "email_valor", column = @Column(name = "email_valor", nullable = false))
    private EmailEmbeddable correo_usuweb;

    @Column(name = "passhash", nullable = false)
    private String passhash;

    @Column(name = "id_emp", nullable = false)
    private String id_emp;

    @Column(name = "id_cli", nullable = false)
    private String id_cli;

    /*
     * @OneToOne(fetch = FetchType.EAGER)
     * 
     * @MapsId
     * 
     * @JoinColumn(name = "id_emp")
     * private EmpleadoEntity empleado;
     * 
     * @Column(name = "username", nullable = false, unique = true, length = 50)
     * private String username;
     * 
     * @Column(name = "pass", nullable = false, length = 120)
     * private String pass;
     * 
     * @Column(name = "rol_emp", length = 50)
     * private String rolEmp;
     * 
     * @Column(name = "id_cli")
     * private Integer idCli;
     * 
     * @Column(name = "id_esp")
     * private Integer idEsp;
     */

}
