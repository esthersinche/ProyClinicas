package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.DoctorEntity;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EspecialidadEmbeddable;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.NombreCompletoEmbeddable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorMapperTest {

    private EspecialidadesMapper espeMap;
    private NombreCompletoMapper nomMap;
    private DoctorMapper mapper;

    @BeforeEach
    void setup() {
        espeMap = Mockito.mock(EspecialidadesMapper.class);
        nomMap = Mockito.mock(NombreCompletoMapper.class);
        mapper = new DoctorMapper(espeMap, nomMap);
    }

    @Test
    void toDomain_ok() {
        NombreCompletoEmbeddable nomEmb = new NombreCompletoEmbeddable("Luis", "Ramos");
        EspecialidadEmbeddable espEmb = new EspecialidadEmbeddable("Cardiología");

        DoctorEntity ent = DoctorEntity.builder()
                .id_doc("DOC1")
                .id_empleado_doc("EMP1")
                .nom_com_doc(nomEmb)
                .cmp_doc("CMP123")
                .consultorio_doc("C21")
                .especialidades(List.of(espEmb))
                .build();

        NombreCompleto nom = new NombreCompleto("Luis", "Ramos");
        Especialidad esp = new Especialidad("Cardiología");

        Mockito.when(nomMap.ToDomain(nomEmb)).thenReturn(nom);
        Mockito.when(espeMap.ToDomain(espEmb)).thenReturn(esp);

        Doctor doc = mapper.ToDomain(ent);

        assertEquals("EMP1", doc.getId_empleado_doc().obtenerid());
        assertEquals("DOC1", doc.getId_doc().obtenerid());
        assertEquals("CMP123", doc.getCmp_doc());
        assertEquals("C21", doc.getConsultorio_doc());
        assertEquals(nom, doc.getNom_com_doc());
        assertEquals(1, doc.getEspecialidades().size());
        assertEquals(esp, doc.getEspecialidades().get(0));
    }

    @Test
    void toEntity_ok() {
        IDEntidad empId = IDEntidad.astring("EMP2");
        IDEntidad docId = IDEntidad.astring("DOC2");

        NombreCompleto nom = new NombreCompleto("Ana", "Soto");
        Especialidad esp = new Especialidad("Dermato");

        Doctor doc = new Doctor(empId, docId, nom, "CMP999", "B11", List.of(esp));

        NombreCompletoEmbeddable nomEmb = new NombreCompletoEmbeddable("Ana", "Soto");
        EspecialidadEmbeddable espEmb = new EspecialidadEmbeddable("Dermato");

        Mockito.when(nomMap.ToEmbeddable(nom)).thenReturn(nomEmb);
        Mockito.when(espeMap.ToEntity(esp)).thenReturn(espEmb);

        DoctorEntity ent = mapper.ToEntity(doc);

        assertEquals("DOC2", ent.getId_doc());
        assertEquals("EMP2", ent.getId_empleado_doc());
        assertEquals("CMP999", ent.getCmp_doc());
        assertEquals("B11", ent.getConsultorio_doc());
        assertEquals(nomEmb, ent.getNom_com_doc());
        assertEquals(1, ent.getEspecialidades().size());
        assertEquals(espEmb, ent.getEspecialidades().get(0));
    }
}
