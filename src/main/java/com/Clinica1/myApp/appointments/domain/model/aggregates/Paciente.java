package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.Date;
import java.util.Objects;

public class Paciente {
    private IDEntidad id_pac;
    private String nombre_com_pac;
    private String nacionalidad_pac;
    private String dni_pac;
    private String tel_pac;
    private Email email_pac;
    //historial medico por incluir
    private Date fec_nac_pac;
    private String sexo_pac;

    public Paciente() {//jpa
    }

    public Paciente(IDEntidad id_pac, String nombre_com_pac, String nacionalidad_pac, String dni_pac, String tel_pac,
                    Email email_pac, Date fec_nac_pac, String sexo_pac) {
        this.id_pac = id_pac;
        this.nombre_com_pac = nombre_com_pac;
        this.nacionalidad_pac = nacionalidad_pac;
        this.dni_pac = dni_pac;
        this.tel_pac = tel_pac;
        this.email_pac = email_pac;
        this.fec_nac_pac = fec_nac_pac;
        this.sexo_pac = sexo_pac;
    }

    public Paciente(String juan, String perez, String number) {
    }

    //metodo builder por la cantidad de parametros
    public static Paciente createpac(String id_pac, String nacionalidad_pac, String dni_pac, String tel_pac,
                                     Email email_pac, Date fec_nac_pac, String sexo_pac){
        return new Paciente(IDEntidad.generar(), id_pac, nacionalidad_pac, dni_pac, tel_pac, email_pac,
                fec_nac_pac, sexo_pac);

    }

    public IDEntidad getId_pac() {
        return id_pac;
    }

    public String getNombre_com_pac() {
        return nombre_com_pac;
    }

    public String getNacionalidad_pac() {
        return nacionalidad_pac;
    }

    public String getDni_pac() {
        return dni_pac;
    }

    public String getTel_pac() {
        return tel_pac;
    }

    public Email getEmail_pac() {
        return email_pac;
    }

    public Date getFec_nac_pac() {
        return fec_nac_pac;
    }

    public String getSexo_pac() {
        return sexo_pac;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id_pac, paciente.id_pac);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_pac);
    }
}
