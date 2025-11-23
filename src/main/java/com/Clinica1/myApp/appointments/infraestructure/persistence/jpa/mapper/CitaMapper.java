package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Canal;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.CitaEntity;
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {
    private EspecialidadesMapper espe_map;
    private DoctorMapper doc_map;
    private PacienteMapper pac_map;
    private Pac_info_citaMapper pacinfo_map;
    private Doc_info_citaMapper docinfo_map;

    public CitaMapper(EspecialidadesMapper espe_map, DoctorMapper doc_map, PacienteMapper pac_map,
                      Pac_info_citaMapper pacinfo_map, Doc_info_citaMapper docinfo_map) {
        this.espe_map = espe_map;
        this.doc_map = doc_map;
        this.pac_map = pac_map;
        this.pacinfo_map = pacinfo_map;
        this.docinfo_map = docinfo_map;
    }

    //de citaentity a cita
    public Cita ToDomain(CitaEntity cita_ent){
        return new Cita(IDEntidad.astring(cita_ent.getId_cita()), cita_ent.getMotivo_cita(),
                Estado.valueOf(cita_ent.getEstado_cita()), Canal.valueOf(cita_ent.getCanal_cita()),
                cita_ent.getInicio_cita(), cita_ent.getFin_cita(), IDEntidad.astring(cita_ent.getPac_id()),
                IDEntidad.astring(cita_ent.getDoc_id()), pacinfo_map.ToDomain(cita_ent.getPac_info()),
                docinfo_map.ToDomain(cita_ent.getDoc_info()),espe_map.ToDomain(cita_ent.getEspe_cita()));
    }

    public CitaEntity ToEntity(Cita cita_dom){
        return CitaEntity.builder()
                .id_cita(cita_dom.getId_cita().obtenerid())
                .motivo_cita(cita_dom.getMotivo_cita())
                .estado_cita(cita_dom.getEstado_cita().name())
                .canal_cita(cita_dom.getCanal_cita().name())
                .inicio_cita(cita_dom.getInicio_cita())
                .fin_cita(cita_dom.getFin_cita())
                .pac_id(cita_dom.getPac_id().obtenerid())
                .doc_id(cita_dom.getDoc_id().obtenerid())
                .pac_info(pacinfo_map.ToEntity(cita_dom.getInst_pac()))
                .doc_info(docinfo_map.ToEntity(cita_dom.getInst_doctor()))
                .espe_cita(espe_map.ToEntity(cita_dom.getEspe_cita()))
                .build();
    }
}
