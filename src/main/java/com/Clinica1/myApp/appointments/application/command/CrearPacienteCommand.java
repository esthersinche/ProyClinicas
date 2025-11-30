package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.Builder;

import java.util.Date;

@Builder
public class CrearPacienteCommand {
    private IDEntidad id;
    private String nombre;
    private String nacionalidad;
    private String dni;
    private String tel;
    private String email;
    private Date fec_nac;
    private String sexo;

    public CrearPacienteCommand(IDEntidad id, String nombre, String nacionalidad,
                                String dni, String tel, String email, Date fec_nac,
                                String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.dni = dni;
        this.tel = tel;
        this.email = email;
        this.fec_nac = fec_nac;
        this.sexo = sexo;
    }

    public IDEntidad getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDni() {
        return dni;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public Date getFec_nac() {
        return fec_nac;
    }

    public String getSexo() {
        return sexo;
    }
}
