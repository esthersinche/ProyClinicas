package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.DoctorEntity;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EspecialidadEmbeddable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorMapper {

    private EspecialidadesMapper espe_map;

    //inyeccion
    public DoctorMapper(EspecialidadesMapper espe_map) {
        this.espe_map = espe_map;
    }

    public Doctor ToDomain(DoctorEntity doc_ent){
        //cambiar de especialidadesembbedable a especialidades
        List<Especialidad> listacambiada= doc_ent.getEspecialidades().stream()
                .map(espe_map::ToDomain).toList();
        return new Doctor(IDEntidad.astring(doc_ent.getId_doc()), IDEntidad.astring(doc_ent.getId_empleado_doc()),
                doc_ent.getCmp_doc(), doc_ent.getConsultorio_doc(), listacambiada);
    }

    public DoctorEntity ToEntity(Doctor doc){
        List<EspecialidadEmbeddable> listacambiada2= doc.getEspecialidades().stream()
                .map(espe_map::ToEntity).toList();
        return DoctorEntity.builder().id_doc(doc.getId_doc().obtenerid())
                .id_empleado_doc(doc.getId_empleado_doc().obtenerid())
                .cmp_doc(doc.getCmp_doc())
                .consultorio_doc(doc.getConsultorio_doc())
                .especialidades(listacambiada2)
                .build();
    }
}
