package com.Clinica1.myApp.SharedKernel;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;

import java.util.Objects;

public class Empleado {
    private IDEntidad id_emp;
    private String nombre;
    private String apellido;
    private String telefono;
    private Email email;//cambios?
    private String passhash_emp;
    private Roles rolemp; //(admin, doctor, recepcionista)

    //referenciar a doctor del bc gestordecitas
    public Empleado() {//jpa
    }

    //este tendra el id ya creado

    // Constructor para tests (6 parámetros)
    public Empleado(IDEntidad id_emp, String nombre, String apellido, String telefono, Email email, Roles rolemp) {
        this.id_emp = id_emp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.rolemp = rolemp;
    }

    public Empleado(IDEntidad id_emp, String nombre, String apellido, String telefono, Email email, String passhash_emp, Roles rolemp) {
        this.id_emp = id_emp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.passhash_emp = passhash_emp;
        this.rolemp = rolemp;
    }

    //metodo factory para tests (5 parámetros)
    public static Empleado crearemp(String nombre, String apellido,
                                    String telefono, Email email, Roles rolemp){
        return new Empleado(IDEntidad.generar(), nombre,
                apellido, telefono, email, rolemp);
    }

    //metodo factory, genera un id valido al crear un empleado y asi no hay null en id c:
    public static Empleado crearemp(String nombre, String apellido,
                                    String telefono, Email email,
                                    String passhash_emp, Roles rolemp, IDEntidad id_clinica){
        return new Empleado(IDEntidad.generar(), nombre,
                apellido, telefono, email,
                passhash_emp, rolemp);
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

    public String getPasshash_emp() {
        return passhash_emp;
    }

    public Roles getRolemp() {
        return rolemp;
    }


    public void asignarCredenciales(String password) {
        this.passhash_emp = password;  // por ahora sin hash
    }

    public void asignarRol(Roles rol) {
        this.rolemp = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(getId_emp(), empleado.getId_emp());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_emp());
    }

}
