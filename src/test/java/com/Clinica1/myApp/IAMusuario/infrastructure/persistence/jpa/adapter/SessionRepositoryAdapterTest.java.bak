package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Sesion;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.SesionEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.SesionMapper;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository.JPASesionRepository;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SessionRepositoryAdapterTest {

    private JPASesionRepository jpaRepo;
    private SesionMapper mapper;
    private SessionRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        jpaRepo = mock(JPASesionRepository.class);
        mapper = new SesionMapper();
        adapter = new SessionRepositoryAdapter(jpaRepo, mapper);
    }

    @Test
    void insert_guardaYRetornaSesion() {
        IDEntidad idUser = IDEntidad.generar();
        Sesion sesion = Sesion.crearsesion(idUser, Instant.now(), Instant.now().plusSeconds(3600));

        SesionEntity entity = mapper.ToEntity(sesion);

        when(jpaRepo.save(any(SesionEntity.class))).thenReturn(entity);

        Sesion result = adapter.insert(sesion);

        assertNotNull(result);
        assertEquals(sesion.getToken_id().obtenerid(), result.getToken_id().obtenerid());
        verify(jpaRepo, times(1)).save(any(SesionEntity.class));
    }

    @Test
    void update_actualizaYRetornaSesion() {
        IDEntidad idUser = IDEntidad.generar();
        Sesion sesion = Sesion.crearsesion(idUser, Instant.now(), Instant.now().plusSeconds(3600));

        SesionEntity entity = mapper.ToEntity(sesion);
        when(jpaRepo.save(any(SesionEntity.class))).thenReturn(entity);

        Sesion updated = adapter.update(sesion);

        assertNotNull(updated);
        assertEquals(sesion.getToken_id().obtenerid(), updated.getToken_id().obtenerid());
    }

    @Test
    void findById_encuentraSesion() {
        IDEntidad id = IDEntidad.generar();
        IDEntidad idUser = IDEntidad.generar();

        Sesion sesion = Sesion.crearsesion(idUser, Instant.now(), Instant.now().plusSeconds(3600));
        SesionEntity entity = mapper.ToEntity(sesion);

        when(jpaRepo.findById(id.obtenerid())).thenReturn(Optional.of(entity));

        Optional<Sesion> result = adapter.FindById(id);

        assertTrue(result.isPresent());
        assertEquals(sesion.getToken_id().obtenerid(), result.get().getToken_id().obtenerid());
    }

    @Test
    void findByUserId_devuelveListaCorrecta() {
        IDEntidad idUser = IDEntidad.generar();

        Sesion ses1 = Sesion.crearsesion(idUser, Instant.now(), Instant.now().plusSeconds(3600));
        Sesion ses2 = Sesion.crearsesion(idUser, Instant.now(), Instant.now().plusSeconds(7200));

        when(jpaRepo.findByUserId(idUser.obtenerid()))
                .thenReturn(List.of(mapper.ToEntity(ses1), mapper.ToEntity(ses2)));

        List<Sesion> lista = adapter.findByUserId(idUser);

        assertEquals(2, lista.size());
    }

    @Test
    void delete_eliminaSesionPorId() {
        IDEntidad id = IDEntidad.generar();

        adapter.delete(id);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(jpaRepo, times(1)).deleteById(captor.capture());
        assertEquals(id.obtenerid(), captor.getValue());
    }

    @Test
    void getall_retornaSesiones() {
        IDEntidad idUser = IDEntidad.generar();
        Sesion ses1 = Sesion.crearsesion(idUser, Instant.now(), Instant.now().plusSeconds(3600));

        when(jpaRepo.findAll()).thenReturn(List.of(mapper.ToEntity(ses1)));

        List<Sesion> lista = adapter.getall();

        assertEquals(1, lista.size());
    }
}
