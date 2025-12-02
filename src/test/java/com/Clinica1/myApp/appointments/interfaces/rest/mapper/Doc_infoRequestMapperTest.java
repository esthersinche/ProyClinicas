package com.Clinica1.myApp.appointments.interfaces.rest.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.Doc_info_citaRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Doc_infoRequestMapperTest {

    @Test
    void toDomain_ok() {
        Doc_infoRequestMapper mapper = new Doc_infoRequestMapper();

        Doc_info_citaRequest req = new Doc_info_citaRequest();
        req.setNom_com_doc("Luis Ramos");
        req.setEspe_doc("Cardiología");
        req.setConsult_doc("C201");

        Doc_info_cita vo = mapper.toDomain(req);

        assertEquals("Luis Ramos", vo.nombre_doc());
        assertEquals("Cardiología", vo.espe_doc());
        assertEquals("C201", vo.consult_doc());
    }
}
