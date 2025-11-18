package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;

import java.util.List;

public class Doctor extends Empleado {
    private String cmp_doc;
    private String consultorio_doc;
    private List<Especialidad> especialidades;

    public Doctor() {
    }

    public Doctor(IDEntidad id_emp, String nombre, String apellido, String telefono, Email email, Rol rolemp, String cmp_doc, String consultorio_doc, List<Especialidad> especialidades) {
        super(id_emp, nombre, apellido, telefono, email, rolemp);
        this.cmp_doc = cmp_doc;
        this.consultorio_doc = consultorio_doc;
        this.especialidades = especialidades;
    }

    //metodo factory q devuelve instancia valida
    public static Doctor creardoc(){

    }
}
