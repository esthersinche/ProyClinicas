package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import jakarta.persistence.*;

@Entity
@Table(name = "UsuarioWeb")
public class UsuarioEntity {

    @Id
    @Column(name = "id_emp", length = 36)
    private IDEntidad idEmp;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "id_emp")
    private EmpleadoEntity empleado;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "pass", nullable = false, length = 120)
    private String pass;

    @Column(name = "rol_emp", length = 50)
    private String rolEmp;

    @Column(name = "id_cli")
    private Integer idCli;

    @Column(name = "id_esp")
    private Integer idEsp;

    public UsuarioEntity() {
    }

    public IDEntidad getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(IDEntidad idEmp) {
        this.idEmp = idEmp;
    }

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRolEmp() {
        return rolEmp;
    }

    public void setRolEmp(String rolEmp) {
        this.rolEmp = rolEmp;
    }

    public Integer getIdCli() {
        return idCli;
    }

    public void setIdCli(Integer idCli) {
        this.idCli = idCli;
    }

    public Integer getIdEsp() {
        return idEsp;
    }

    public void setIdEsp(Integer idEsp) {
        this.idEsp = idEsp;
    }
}
