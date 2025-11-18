package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;

import java.util.List;
import java.util.Objects;

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
    public static Doctor creardoc(String nombre, String apellido, String telefono, Email email, Rol rolemp,
                                  String cmp_doc, String consultorio_doc, List<Especialidad> especialidades){
        return new Doctor(IDEntidad.generar(), nombre, apellido, telefono, email, Rol.doctor, cmp_doc,consultorio_doc, especialidades);
    }

    public String getCmp_doc() {
        return cmp_doc;
    }

    public String getConsultorio_doc() {
        return consultorio_doc;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    //empleado ya tiene equals y hashcode causas
}
