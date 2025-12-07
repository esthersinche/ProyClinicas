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
    private Pac_info_citaMapper pacinfo_map;
    private Doc_info_citaMapper docinfo_map;

    public CitaMapper(
            EspecialidadesMapper espe_map,
            Pac_info_citaMapper pacinfo_map,
            Doc_info_citaMapper docinfo_map
    ) {
        this.espe_map = espe_map;
        this.pacinfo_map = pacinfo_map;
        this.docinfo_map = docinfo_map;
    }

    public Cita ToDomain(CitaEntity e) {
        return new Cita(
                IDEntidad.astring(e.getId_cita()),
                e.getMotivo_cita(),
                Estado.valueOf(e.getEstado_cita()),
                Canal.valueOf(e.getCanal_cita()),
                e.getInicio_cita(),
                e.getFin_cita(),
                IDEntidad.astring(e.getPac_id()),
                IDEntidad.astring(e.getDoc_id()),
                pacinfo_map.ToDomain(e.getPac_info()),
                docinfo_map.ToDomain(e.getDoc_info()),
                espe_map.ToDomain(e.getEspe_cita())
        );
    }

    public CitaEntity ToEntity(Cita c) {
        return CitaEntity.builder()
                .id_cita(c.getId_cita().obtenerid())
                .motivo_cita(c.getMotivo_cita())
                .estado_cita(c.getEstado_cita().name())
                .canal_cita(c.getCanal_cita().name())
                .inicio_cita(c.getInicio_cita())
                .fin_cita(c.getFin_cita())
                .pac_id(c.getPac_id().obtenerid())
                .doc_id(c.getDoc_id().obtenerid())
                .pac_info(pacinfo_map.ToEntity(c.getInst_pac()))
                .doc_info(docinfo_map.ToEntity(c.getInst_doctor()))
                .espe_cita(espe_map.ToEntity(c.getEspe_cita()))
                .build();
    }
}
