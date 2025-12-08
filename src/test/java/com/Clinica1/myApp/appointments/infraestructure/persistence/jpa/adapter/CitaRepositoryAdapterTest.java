package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.adapter;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.CitaEntity;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper.CitaMapper;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.repository.JPAICitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CitaRepositoryAdapterTest {

    @Mock
    private JPAICitaRepository citadao;

    @Mock
    private CitaMapper cit_map;

    @InjectMocks
    private CitaRepositoryAdapter adapter;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_ok() {
        IDEntidad id = mock(IDEntidad.class);
        when(id.obtenerid()).thenReturn("1");

        CitaEntity entity = mock(CitaEntity.class);
        Cita cita = mock(Cita.class);

        when(citadao.findById("1")).thenReturn(Optional.of(entity));
        when(cit_map.ToDomain(entity)).thenReturn(cita);

        Optional<Cita> result = adapter.findById(id);
        assertTrue(result.isPresent());
        assertEquals(cita, result.get());
    }

    @Test
    void findById_notFound() {
        IDEntidad id = mock(IDEntidad.class);
        when(id.obtenerid()).thenReturn("99");

        when(citadao.findById("99")).thenReturn(Optional.empty());

        Optional<Cita> result = adapter.findById(id);
        assertFalse(result.isPresent());
    }

    @Test
    void insert_ok() {
        Cita cita = mock(Cita.class);
        CitaEntity entity = mock(CitaEntity.class);
        CitaEntity saved = mock(CitaEntity.class);
        Cita expected = mock(Cita.class);

        when(cit_map.ToEntity(cita)).thenReturn(entity);
        when(citadao.save(entity)).thenReturn(saved);
        when(cit_map.ToDomain(saved)).thenReturn(expected);

        assertEquals(expected, adapter.insert(cita));
    }

    @Test
    void update_ok() {
        Cita cita = mock(Cita.class);
        CitaEntity entity = mock(CitaEntity.class);
        CitaEntity saved = mock(CitaEntity.class);
        Cita expected = mock(Cita.class);

        when(cit_map.ToEntity(cita)).thenReturn(entity);
        when(citadao.save(entity)).thenReturn(saved);
        when(cit_map.ToDomain(saved)).thenReturn(expected);

        assertEquals(expected, adapter.update(cita));
    }

    @Test
    void findAll_ok() {
        List<CitaEntity> entities = List.of(mock(CitaEntity.class));
        Cita cita = mock(Cita.class);

        when(citadao.findAll()).thenReturn(entities);
        when(cit_map.ToDomain(any())).thenReturn(cita);

        assertEquals(1, adapter.findall().size());
    }

    @Test
    void delete_ok() {
        IDEntidad id = mock(IDEntidad.class);
        when(id.obtenerid()).thenReturn("5");

        adapter.delete(id);

        verify(citadao).deleteById("5");
    }

    @Test
    void findByDoctorId_ok() {
        IDEntidad id = mock(IDEntidad.class);
        when(id.obtenerid()).thenReturn("3");

        List<CitaEntity> entities = List.of(mock(CitaEntity.class));
        Cita cita = mock(Cita.class);

        when(citadao.findByDoctorId("3")).thenReturn(entities);
        when(cit_map.ToDomain(any())).thenReturn(cita);

        assertEquals(1, adapter.findByDoctorId(id).size());
    }
}
