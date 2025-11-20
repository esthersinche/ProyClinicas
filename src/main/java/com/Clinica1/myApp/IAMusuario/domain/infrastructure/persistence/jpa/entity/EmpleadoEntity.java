package com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleado")
public class EmpleadoEntity {

    @Id
    @Column(name = "id_emp", length = 36)
    private String idEmp;

    @Column(name = "nombres_emp", nullable = false, length = 80)
    private String nombresEmp;

    @Column(name = "apellidos_emp", nullable = false, length = 80)
    private String apellidosEmp;

    @Column(name = "telefono_emp", length = 20)
    private String telefonoEmp;

    @Column(name = "email_emp", nullable = false, unique = true, length = 120)
    private String emailEmp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false) // luego en BD crear esta FK
    private RolEntity rol;

    public EmpleadoEntity() {
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getNombresEmp() {
        return nombresEmp;
    }

    public void setNombresEmp(String nombresEmp) {
        this.nombresEmp = nombresEmp;
    }

    public String getApellidosEmp() {
        return apellidosEmp;
    }

    public void setApellidosEmp(String apellidosEmp) {
        this.apellidosEmp = apellidosEmp;
    }

    public String getTelefonoEmp() {
        return telefonoEmp;
    }

    public void setTelefonoEmp(String telefonoEmp) {
        this.telefonoEmp = telefonoEmp;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public void setEmailEmp(String emailEmp) {
        this.emailEmp = emailEmp;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }
}
