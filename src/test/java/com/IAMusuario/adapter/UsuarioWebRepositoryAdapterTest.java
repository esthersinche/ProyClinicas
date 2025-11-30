package com.IAMusuario.adapter;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter.UsuarioRepositoryAdapter;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.UsuarioMapper;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository.JPAUsuarioEntityRepository;

import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioWebRepositoryAdapterTest {

    private JPAUsuarioEntityRepository jpaRepo;
    private UsuarioMapper mapper;
    private UsuarioRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        jpaRepo = mock(JPAUsuarioEntityRepository.class);
        mapper = mock(UsuarioMapper.class);
        adapter = new UsuarioRepositoryAdapter(jpaRepo, mapper);
    }

    @Test
    void testInsert() {
        UsuarioWeb usuarioWeb = new UsuarioWeb();
        UsuarioEntity entity = new UsuarioEntity();
        UsuarioEntity savedEntity = new UsuarioEntity();
        UsuarioWeb mappedBack = new UsuarioWeb();

        when(mapper.toEntity(usuarioWeb)).thenReturn(entity);
        when(jpaRepo.save(entity)).thenReturn(savedEntity);
        when(mapper.toDomain(savedEntity)).thenReturn(mappedBack);

        UsuarioWeb result = adapter.insert(usuarioWeb);

        assertNotNull(result);
        assertEquals(mappedBack, result);

        verify(mapper).toEntity(usuarioWeb);
        verify(jpaRepo).save(entity);
        verify(mapper).toDomain(savedEntity);
    }

    @Test
    void testUpdate() {
        UsuarioWeb usuarioWeb = new UsuarioWeb();
        UsuarioEntity entity = new UsuarioEntity();
        UsuarioEntity savedEntity = new UsuarioEntity();
        UsuarioWeb mappedBack = new UsuarioWeb();

        when(mapper.toEntity(usuarioWeb)).thenReturn(entity);
        when(jpaRepo.save(entity)).thenReturn(savedEntity);
        when(mapper.toDomain(savedEntity)).thenReturn(mappedBack);

        UsuarioWeb result = adapter.update(usuarioWeb);

        assertNotNull(result);
        assertEquals(mappedBack, result);
    }

    @Test
    void testFindById_found() {
        UUID id = UUID.randomUUID();
        UsuarioEntity entity = new UsuarioEntity();
        UsuarioWeb usuarioWeb = new UsuarioWeb();

        when(jpaRepo.findById(id.toString())).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(usuarioWeb);

        UsuarioWeb result = adapter.FindById(id);

        assertNotNull(result);
        assertEquals(usuarioWeb, result);
    }

    @Test
    void testFindById_notFound() {
        UUID id = UUID.randomUUID();

        when(jpaRepo.findById(id.toString())).thenReturn(Optional.empty());

        UsuarioWeb result = adapter.FindById(id);

        assertNull(result);
    }

    @Test
    void testGetAll() {
        UsuarioEntity e1 = new UsuarioEntity();
        UsuarioEntity e2 = new UsuarioEntity();

        UsuarioWeb u1 = new UsuarioWeb();
        UsuarioWeb u2 = new UsuarioWeb();

        when(jpaRepo.findAll()).thenReturn(List.of(e1, e2));
        when(mapper.toDomain(e1)).thenReturn(u1);
        when(mapper.toDomain(e2)).thenReturn(u2);

        List<UsuarioWeb> result = adapter.getall();

        assertEquals(2, result.size());
        assertTrue(result.contains(u1));
        assertTrue(result.contains(u2));
    }

    @Test
    void testDelete() {
        UUID id = UUID.randomUUID();

        adapter.delete(id);

        verify(jpaRepo).deleteById(id.toString());
    }

    @Test
    void testFindByUsername_found() {
        String username = "juan123";

        UsuarioEntity entity = new UsuarioEntity();
        UsuarioWeb usuarioWeb = new UsuarioWeb();

        when(jpaRepo.findByUsername(username)).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(usuarioWeb);

        UsuarioWeb result = adapter.findbyUsername(username);

        assertNotNull(result);
        assertEquals(usuarioWeb, result);
    }

    @Test
    void testFindByUsername_notFound() {
        String username = "no-existe";

        when(jpaRepo.findByUsername(username)).thenReturn(Optional.empty());

        UsuarioWeb result = adapter.findbyUsername(username);

        assertNull(result);
    }
}
