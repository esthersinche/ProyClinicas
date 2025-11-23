package com.IAMusuario.adapter;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter.UsuarioRepositoryAdapter;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.UsuarioMapper;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository.JPAUsuarioRepository;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Usuario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioRepositoryAdapterTest {

    private JPAUsuarioRepository jpaRepo;
    private UsuarioMapper mapper;
    private UsuarioRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        jpaRepo = mock(JPAUsuarioRepository.class);
        mapper = mock(UsuarioMapper.class);
        adapter = new UsuarioRepositoryAdapter(jpaRepo, mapper);
    }

    @Test
    void testInsert() {
        Usuario usuario = new Usuario();
        UsuarioEntity entity = new UsuarioEntity();
        UsuarioEntity savedEntity = new UsuarioEntity();
        Usuario mappedBack = new Usuario();

        when(mapper.toEntity(usuario)).thenReturn(entity);
        when(jpaRepo.save(entity)).thenReturn(savedEntity);
        when(mapper.toDomain(savedEntity)).thenReturn(mappedBack);

        Usuario result = adapter.insert(usuario);

        assertNotNull(result);
        assertEquals(mappedBack, result);

        verify(mapper).toEntity(usuario);
        verify(jpaRepo).save(entity);
        verify(mapper).toDomain(savedEntity);
    }

    @Test
    void testUpdate() {
        Usuario usuario = new Usuario();
        UsuarioEntity entity = new UsuarioEntity();
        UsuarioEntity savedEntity = new UsuarioEntity();
        Usuario mappedBack = new Usuario();

        when(mapper.toEntity(usuario)).thenReturn(entity);
        when(jpaRepo.save(entity)).thenReturn(savedEntity);
        when(mapper.toDomain(savedEntity)).thenReturn(mappedBack);

        Usuario result = adapter.update(usuario);

        assertNotNull(result);
        assertEquals(mappedBack, result);
    }

    @Test
    void testFindById_found() {
        UUID id = UUID.randomUUID();
        UsuarioEntity entity = new UsuarioEntity();
        Usuario usuario = new Usuario();

        when(jpaRepo.findById(id.toString())).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(usuario);

        Usuario result = adapter.FindById(id);

        assertNotNull(result);
        assertEquals(usuario, result);
    }

    @Test
    void testFindById_notFound() {
        UUID id = UUID.randomUUID();

        when(jpaRepo.findById(id.toString())).thenReturn(Optional.empty());

        Usuario result = adapter.FindById(id);

        assertNull(result);
    }

    @Test
    void testGetAll() {
        UsuarioEntity e1 = new UsuarioEntity();
        UsuarioEntity e2 = new UsuarioEntity();

        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();

        when(jpaRepo.findAll()).thenReturn(List.of(e1, e2));
        when(mapper.toDomain(e1)).thenReturn(u1);
        when(mapper.toDomain(e2)).thenReturn(u2);

        List<Usuario> result = adapter.getall();

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
        Usuario usuario = new Usuario();

        when(jpaRepo.findByUsername(username)).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(usuario);

        Usuario result = adapter.findbyUsername(username);

        assertNotNull(result);
        assertEquals(usuario, result);
    }

    @Test
    void testFindByUsername_notFound() {
        String username = "no-existe";

        when(jpaRepo.findByUsername(username)).thenReturn(Optional.empty());

        Usuario result = adapter.findbyUsername(username);

        assertNull(result);
    }
}
