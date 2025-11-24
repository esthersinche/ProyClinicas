package com.Clinica1.myApp.appointments.interfaces.rest.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Pac_info_cita;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.Pac_info_citaRequest;
import org.springframework.stereotype.Component;

@Component
public class Pac_infoRequestMapper {
    //de pac_info_citarequest a pac_info_cita
    public Pac_info_cita toDomain(Pac_info_citaRequest pacinfo_req){
        return new Pac_info_cita(pacinfo_req.getNom_com_pac(), pacinfo_req.getDni_pac());
    }
}
