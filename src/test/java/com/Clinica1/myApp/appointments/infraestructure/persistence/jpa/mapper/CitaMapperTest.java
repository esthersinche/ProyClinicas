package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.*;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.CitaEntity;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.Doc_info_cita_embeddable;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.Pac_info_cita_embeddable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMapperTest {

    private EspecialidadesMapper espeMap;
    private Pac_info_citaMapper pacinfoMap;
    private Doc_info_citaMapper docinfoMap;
    private CitaMapper mapper;

    @BeforeEach
    void setup() {
        espeMap = Mockito.mock(EspecialidadesMapper.class);
        pacinfoMap = Mockito.mock(Pac_info_citaMapper.class);
        docinfoMap = Mockito.mock(Doc_info_citaMapper.class);

        mapper = new CitaMapper(espeMap, pacinfoMap, docinfoMap);
    }

    @Test
    void toDomain_ok() {
        CitaEntity ent = CitaEntity.builder()
                .id_cita("ID1")
                .motivo_cita("Dolor")
                .estado_cita("Pendiente")
                .canal_cita("Virtual")
                .inicio_cita(LocalDateTime.now())
                .fin_cita(LocalDateTime.now().plusHours(1))
                .pac_id("PAC1")
                .doc_id("DOC1")
                .pac_info(new Pac_info_cita_embeddable("Luis", "12345678"))
                .doc_info(new Doc_info_cita_embeddable("Dr Juan", "Cardio", "C21", "CMP123"))
                .espe_cita(null)
                .build();

        Pac_info_cita pacInfo = new Pac_info_cita("Luis", "12345678");
        Doc_info_cita docInfo = new Doc_info_cita("Dr Juan", "Cardio", "C21", "CMP123");
        Especialidad espe = new Especialidad("Cardio");

        Mockito.when(pacinfoMap.ToDomain(ent.getPac_info())).thenReturn(pacInfo);
        Mockito.when(docinfoMap.ToDomain(ent.getDoc_info())).thenReturn(docInfo);
        Mockito.when(espeMap.ToDomain(ent.getEspe_cita())).thenReturn(espe);

        Cita cita = mapper.ToDomain(ent);

        assertEquals("ID1", cita.getId_cita().obtenerid());
        assertEquals("Dolor", cita.getMotivo_cita());
        assertEquals(Estado.Pendiente, cita.getEstado_cita());
        assertEquals(Canal.Virtual, cita.getCanal_cita());
        assertEquals("PAC1", cita.getPac_id().obtenerid());
        assertEquals("DOC1", cita.getDoc_id().obtenerid());
        assertEquals(pacInfo, cita.getInst_pac());
        assertEquals(docInfo, cita.getInst_doctor());
        assertEquals(espe, cita.getEspe_cita());
    }

    @Test
    void toEntity_ok() {
        IDEntidad id = IDEntidad.astring("ID2");
        IDEntidad pacId = IDEntidad.astring("PAC2");
        IDEntidad docId = IDEntidad.astring("DOC2");

        Pac_info_cita pacInfo = new Pac_info_cita("Ana", "99999999");
        Doc_info_cita docInfo = new Doc_info_cita("Dr Pepe", "Dermato", "C10", "CMP456");
        Especialidad espe = new Especialidad("Dermato");

        Cita cita = new Cita(id, "Revisión", Estado.Pendiente, Canal.Presencial,
                LocalDateTime.now(), LocalDateTime.now().plusHours(1),
                pacId, docId, pacInfo, docInfo, espe);

        Pac_info_cita_embeddable pacEmb = new Pac_info_cita_embeddable("Ana", "99999999");
        Doc_info_cita_embeddable docEmb = new Doc_info_cita_embeddable("Dr Pepe", "Dermato", "C10", "CMP456");

        Mockito.when(pacinfoMap.ToEntity(pacInfo)).thenReturn(pacEmb);
        Mockito.when(docinfoMap.ToEntity(docInfo)).thenReturn(docEmb);
        Mockito.when(espeMap.ToEntity(espe)).thenReturn(null);

        CitaEntity ent = mapper.ToEntity(cita);

        assertEquals("ID2", ent.getId_cita());
        assertEquals("Revisión", ent.getMotivo_cita());
        assertEquals("Pendiente", ent.getEstado_cita());
        assertEquals("Presencial", ent.getCanal_cita());
        assertEquals("PAC2", ent.getPac_id());
        assertEquals("DOC2", ent.getDoc_id());
        assertEquals(pacEmb, ent.getPac_info());
        assertEquals(docEmb, ent.getDoc_info());
    }
}
