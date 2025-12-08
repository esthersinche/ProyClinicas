package com.Clinica1.myApp.appointments.interfaces.rest.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CrearCitaCommand;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.CrearCitaRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaRequestMapperTest {

    @Test
    void toCommand_ok() {
        CitaRequestMapper mapper = new CitaRequestMapper();

        CrearCitaRequest req = new CrearCitaRequest();
        req.setMotivo_cita("Dolor fuerte");
        req.setCanal_cita("Online");
        req.setInicio_cita(LocalDateTime.of(2025, 1, 10, 10, 0));
        req.setFin_cita(LocalDateTime.of(2025, 1, 10, 10, 30));
        req.setId_pac("PAC123");
        req.setId_doc("DOC555");
        req.setEspe_cita("Cardiología");

        CrearCitaCommand cmd = mapper.ToCommand(req);

        assertEquals("Dolor fuerte", cmd.getMotivo());
        assertEquals("Online", cmd.getCanal());
        assertEquals(req.getInicio_cita(), cmd.getInicio());
        assertEquals(req.getFin_cita(), cmd.getFin());
        assertEquals(IDEntidad.astring("PAC123"), cmd.getPacienteId());
        assertEquals(IDEntidad.astring("DOC555"), cmd.getDoctorId());
        assertEquals("Cardiología", cmd.getEspecialidad());
        assertNull(cmd.getClinicaId());
    }
}
