package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class Empleado {
    private IDEntidad id_emp;
    private String nombre;
    private String apellido;
    private String telefono;
    private Email email;//cambios?
    private Rol rolemp; //(admin, doctor, recepcionista)

    //referenciar a doctor del bc gestordecitas


    public Empleado(IDEntidad id_emp, String nombre, String apellido, String telefono, Email email, Rol rolemp) {
        this.id_emp = id_emp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.rolemp = rolemp;
    }

    public Empleado() {
    }

    public static Empleado crearemp(String nombre, String apellido, String telefono, Email email, Rol rolemp){
        return new Empleado(IDEntidad.generar(), nombre, apellido, telefono, email, rolemp);
    }

    public IDEntidad getId_emp() {
        return id_emp;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }

    public Rol getRolemp() {
        return rolemp;
    }
}
