package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;

import java.util.List;
import java.util.Objects;

public class Doctor {//se quita la herencia para q no compartan persistencia
    private IDEntidad id_empleado_doc;//en referencia a id de empleado
    private IDEntidad id_doc; //en referencia a doctor solamente, ya q los dos bc tienen reglas e identidad
    //diferente
    private NombreCompleto nom_com_doc;
    private String cmp_doc;
    private String consultorio_doc;
    private List<Especialidad> especialidades;

    //para mapper

    public Doctor(IDEntidad id_empleado_doc, IDEntidad id_doc, NombreCompleto nom_com_doc, String cmp_doc,
                  String consultorio_doc, List<Especialidad> especialidades) {
        this.id_empleado_doc = id_empleado_doc;
        this.id_doc = id_doc;
        this.nom_com_doc = nom_com_doc;
        this.cmp_doc = cmp_doc;
        this.consultorio_doc = consultorio_doc;
        this.especialidades = especialidades;
    }
  
    /*
    public Doctor(String luis, String ramos, Object o) {
    }*/

    //metodo factory q devuelve instancia valida
    public static Doctor creardoc(IDEntidad id_empleado_doc, NombreCompleto nom_com_doc, String cmp_doc, String consultorio_doc,
                                  List<Especialidad> especialidades){
        return new Doctor(id_empleado_doc, IDEntidad.generar(),  nom_com_doc, cmp_doc, consultorio_doc, especialidades);

    }



    public IDEntidad getId_empleado_doc() {
        return id_empleado_doc;
    }

    public IDEntidad getId_doc() {
        return id_doc;
    }

    public NombreCompleto getNom_com_doc() {
        return nom_com_doc;
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

  /*
    public String getNombre() {
        return "";
    }

    public String getApellido() {
        return "";
    }*/
}
