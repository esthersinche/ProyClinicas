package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EmailEmbeddable;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.PacienteEntity;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PacienteMapperTest {

    private final EmailMapper emailMapper = new EmailMapper();
    private final PacienteMapper mapper = new PacienteMapper(emailMapper);

    @Test
    void toDomain_ok() {
        EmailEmbeddable emailEmb = EmailEmbeddable.builder()
                .email_valor("test@mail.com")
                .build();

        PacienteEntity entity = PacienteEntity.builder()
                .id_pac("ABC123")
                .nombre_com_pac("Carlos Ramos")
                .nacionalidad_pac("Peruana")
                .dni_pac("77889911")
                .tel_pac("987654321")
                .email_pac(emailEmb)
                .fec_nac_pac(new Date())
                .sexo_pac("Masculino")
                .build();

        Paciente p = mapper.ToDomain(entity);

        assertNotNull(p);
        assertEquals("Carlos Ramos", p.getNombre_com_pac());
        assertEquals("Peruana", p.getNacionalidad_pac());
        assertEquals("77889911", p.getDni_pac());
        assertEquals("987654321", p.getTel_pac());
        assertEquals("test@mail.com", p.getEmail_pac().email_valor());
        assertEquals("Masculino", p.getSexo_pac());
        assertEquals("ABC123", p.getId_pac().obtenerid());
    }

    @Test
    void toEntity_ok() {
        Paciente pac = new Paciente(
                IDEntidad.astring("ZZZ999"),
                "Ana Silva",
                "Chilena",
                "11223344",
                "912345678",
                new Email("ana@mail.com"),
                new Date(),
                "Femenino");

        PacienteEntity ent = mapper.ToEntity(pac);

        assertNotNull(ent);
        assertEquals("ZZZ999", ent.getId_pac());
        assertEquals("Ana Silva", ent.getNombre_com_pac());
        assertEquals("Chilena", ent.getNacionalidad_pac());
        assertEquals("11223344", ent.getDni_pac());
        assertEquals("912345678", ent.getTel_pac());
        assertEquals("ana@mail.com", ent.getEmail_pac().getEmail_valor());
        assertEquals("Femenino", ent.getSexo_pac());
    }
}
