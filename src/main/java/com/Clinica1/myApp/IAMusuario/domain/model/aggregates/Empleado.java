package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class Empleado {
    private final IDEntidad id_emp;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;//cambios?
    private Rol rolemp; //(admin, doctor, recepcionista)

    //referenciar a doctor del bc gestordecitas


    public Empleado(IDEntidad id_emp, String nombre, String apellido, String telefono, String email, Rol rolemp) {
        this.id_emp = id_emp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.rolemp = rolemp;
    }

    //falta factory method
}
