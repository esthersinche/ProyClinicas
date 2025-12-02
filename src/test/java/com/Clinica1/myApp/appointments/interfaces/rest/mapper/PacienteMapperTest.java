package com.Clinica1.myApp.appointments.interfaces.rest.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CrearPacienteCommand;
import com.Clinica1.myApp.appointments.application.dto.PacienteDto;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PacienteMapperTest {

    private final PacienteRestMapper mapper = new PacienteRestMapper();

    @Test
    void toCommand_ok() {
        PacienteDto dto = new PacienteDto();
        IDEntidad id = IDEntidad.astring("123");

        dto.setId(id);
        dto.setNombre("Luis Ramos");
        dto.setNacionalidad("Peruana");
        dto.setDni("12345678");
        dto.setTel("987654321");
        dto.setEmail("luis@mail.com");
        Date fecha = new Date();
        dto.setFec_nac(fecha);
        dto.setSexo("Masculino");

        CrearPacienteCommand cmd = mapper.toCommand(dto);

        assertEquals(id, cmd.getId());
        assertEquals("Luis Ramos", cmd.getNombre());
        assertEquals("Peruana", cmd.getNacionalidad());
        assertEquals("12345678", cmd.getDni());
        assertEquals("987654321", cmd.getTel());
        assertEquals("luis@mail.com", cmd.getEmail());
        assertEquals(fecha, cmd.getFec_nac());
        assertEquals("Masculino", cmd.getSexo());
    }

    @Test
    void toDto_ok() {
        IDEntidad id = IDEntidad.astring("ABC");
        Date fecha = new Date();

        CrearPacienteCommand cmd = CrearPacienteCommand.builder()
                .id(id)
                .nombre("Ana Lopez")
                .nacionalidad("Chilena")
                .dni("87654321")
                .tel("912345678")
                .email("ana@mail.com")
                .fec_nac(fecha)
                .sexo("Femenino")
                .build();

        PacienteDto dto = mapper.toDto(cmd);

        assertEquals(id, dto.getId());
        assertEquals("Ana Lopez", dto.getNombre());
        assertEquals("Chilena", dto.getNacionalidad());
        assertEquals("87654321", dto.getDni());
        assertEquals("912345678", dto.getTel());
        assertEquals("ana@mail.com", dto.getEmail());
        assertEquals(fecha, dto.getFec_nac());
        assertEquals("Femenino", dto.getSexo());
    }
}
