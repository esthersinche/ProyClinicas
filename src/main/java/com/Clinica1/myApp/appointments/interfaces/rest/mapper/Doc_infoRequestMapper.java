package com.Clinica1.myApp.appointments.interfaces.rest.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.Doc_info_citaRequest;
import org.springframework.stereotype.Component;

@Component
public class Doc_infoRequestMapper {

    public Doc_info_cita toDomain(Doc_info_citaRequest docinfo_req){
        return new Doc_info_cita(docinfo_req.getNom_com_doc(), docinfo_req.getEspe_doc(), docinfo_req.getConsult_doc(), docinfo_req.getCmp_doc());

    }
}
