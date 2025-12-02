package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Empleado")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoEntity {

    @Id
    @Column(name = "id_emp", length = 36)
    private String id_Emp;

    @Column(name = "nombres_emp", nullable = false, length = 80)
    private String nombresEmp;

    @Column(name = "apellidos_emp", nullable = false, length = 80)
    private String apellidosEmp;

    @Column(name = "telefono_emp", length = 20)
    private String telefonoEmp;

    @Embedded
    private EmailEmbeddable email_emp;
/*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false) // luego en BD crear esta FK*/

    @Column(name = "passhash_emp", nullable = false)
    private String passhash_emp;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_emp", nullable = false)
    private Roles rol;//este es el enum, no cambiar, ya que se convalidara con el nombre de rol la clase aggregate de domain


    public void setNombre(String luis) {

    }

    public void setApellido(String ramos) {

    }
}
