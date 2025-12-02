package com.Clinica1.myApp.appointments.interfaces.rest.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Pac_info_cita;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.Pac_info_citaRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pac_infoRequestMapperTest {

    @Test
    void toDomain_ok() {
        Pac_infoRequestMapper mapper = new Pac_infoRequestMapper();

        Pac_info_citaRequest req = new Pac_info_citaRequest();
        req.setNom_com_pac("Ana Torres");
        req.setDni_pac("87654321");

        Pac_info_cita vo = mapper.toDomain(req);

        assertEquals("Ana Torres", vo.nomb_com_pac());
        assertEquals("87654321", vo.dni_pac());
    }
}
