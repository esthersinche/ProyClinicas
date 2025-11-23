package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Pac_info_cita;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.Pac_info_cita_embeddable;
import org.springframework.stereotype.Component;

@Component
public class Pac_info_citaMapper {

    //de embedable a pac_info_cita(VO)
    public Pac_info_cita ToDomain(Pac_info_cita_embeddable pacinfo_emb){
        return new Pac_info_cita(pacinfo_emb.getNomb_com_pac(), pacinfo_emb.getDni_pac());
    }

    public Pac_info_cita_embeddable ToEntity(Pac_info_cita pacinfo_ent){
        return Pac_info_cita_embeddable.builder()
                .nomb_com_pac(pacinfo_ent.nomb_com_pac())
                .dni_pac(pacinfo_ent.dni_pac())
                .build();
    }
}
