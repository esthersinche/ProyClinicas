package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;

import java.util.List;
import java.util.Objects;

public class Doctor {//se quita la herencia para q no compartan persistencia
    private IDEntidad id_empleado_doc;//en referencia a id de empleado
    private IDEntidad id_doc; //en referencia a doctor solamente, ya q los dos bc tienen reglas e identidad
    //diferente
    private String cmp_doc;
    private String consultorio_doc;
    private List<Especialidad> especialidades;

    //para mapper

    public Doctor(IDEntidad id_doc, IDEntidad id_empleado_doc, String cmp_doc, String consultorio_doc,
                  List<Especialidad> especialidades) {
        this.id_doc = id_doc;
        this.id_empleado_doc = id_empleado_doc;
        this.cmp_doc = cmp_doc;
        this.consultorio_doc = consultorio_doc;
        this.especialidades = especialidades;
    }



    public Doctor(String luis, String ramos, Object o) {
    }

    //metodo factory q devuelve instancia valida
    public static Doctor creardoc(Empleado empleado, String cmp_doc, String consultorio_doc,
                                  List<Especialidad> especialidades){
        return new Doctor(IDEntidad.generar(), empleado.getId_emp(), cmp_doc, consultorio_doc, especialidades);

    }

    public IDEntidad getId_empleado_doc() {
        return id_empleado_doc;
    }

    public IDEntidad getId_doc() {
        return id_doc;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getId_doc(), doctor.getId_doc());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_doc());
    }

    public String getNombre() {
        return "";
    }

    public String getApellido() {
        return "";
    }
}
