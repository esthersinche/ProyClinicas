package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.Doc_info_cita_embeddable;
import org.springframework.stereotype.Component;

@Component
public class Doc_info_citaMapper {

    public Doc_info_cita ToDomain(Doc_info_cita_embeddable docinfo_emb){
        return new Doc_info_cita(docinfo_emb.getNombre_doc(), docinfo_emb.getEspe_doc(),
                docinfo_emb.getConsult_doc());
    }

    public Doc_info_cita_embeddable ToEntity(Doc_info_cita docinfo_ent){
        return Doc_info_cita_embeddable.builder()
                .nombre_doc(docinfo_ent.nombre_doc())
                .espe_doc(docinfo_ent.espe_doc())
                .consult_doc(docinfo_ent.consult_doc())
                .build();
    }
}
