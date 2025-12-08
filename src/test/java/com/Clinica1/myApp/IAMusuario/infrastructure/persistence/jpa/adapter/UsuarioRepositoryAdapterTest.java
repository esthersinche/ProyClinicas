package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.EmailMapper;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.adquisicion.domain.model.UsuarioWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioRepositoryAdapterTest {

    private JPAUsuarioEntityRepository jpaRepo;
    private UsuarioMapper mapper;
    private UsuarioRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        jpaRepo = mock(JPAUsuarioEntityRepository.class);
        mapper = new UsuarioMapper(new EmailMapper());
        adapter = new UsuarioRepositoryAdapter(jpaRepo, mapper);
    }

    private UsuarioWeb crearUsuario() {
        IDEntidad id = IDEntidad.generar();
        IDEntidad idEmp = IDEntidad.generar();
        IDEntidad idCli = IDEntidad.generar();
        Email email = new Email("correo@test.com");

        return new UsuarioWeb(id, email, "hash123", idEmp, idCli);
    }

    @Test
    void insert_guardaYRetornaUsuario() {
        UsuarioWeb usuario = crearUsuario();
        UsuarioWebEntity entity = mapper.ToEntity(usuario);

        when(jpaRepo.save(any())).thenReturn(entity);

        UsuarioWeb result = adapter.insert(usuario);

        assertNotNull(result);
        assertEquals(usuario.getId_usu().obtenerid(), result.getId_usu().obtenerid());
        verify(jpaRepo, times(1)).save(any());
    }

    @Test
    void update_actualizaCorrectamente() {
        UsuarioWeb usuario = crearUsuario();
        UsuarioWebEntity entity = mapper.ToEntity(usuario);

        when(jpaRepo.save(any())).thenReturn(entity);

        UsuarioWeb result = adapter.update(usuario);

        assertNotNull(result);
        assertEquals(usuario.getCorreo().email_valor(), result.getCorreo().email_valor());
    }

    @Test
    void findById_encuentraUsuario() {
        UsuarioWeb usuario = crearUsuario();
        UsuarioWebEntity entity = mapper.ToEntity(usuario);

        when(jpaRepo.findById(usuario.getId_usu().obtenerid()))
                .thenReturn(Optional.of(entity));

        Optional<UsuarioWeb> result = adapter.FindById(usuario.getId_usu());

        assertTrue(result.isPresent());
        assertEquals(usuario.getId_usu().obtenerid(), result.get().getId_usu().obtenerid());
    }

    @Test
    void getall_retornaListaUsuarios() {
        UsuarioWeb usuario = crearUsuario();
        UsuarioWebEntity entity = mapper.ToEntity(usuario);

        when(jpaRepo.findAll()).thenReturn(List.of(entity));

        List<UsuarioWeb> lista = adapter.getall();

        assertEquals(1, lista.size());
        assertEquals(usuario.getCorreo().email_valor(), lista.get(0).getCorreo().email_valor());
    }

    @Test
    void delete_eliminaPorId() {
        IDEntidad id = IDEntidad.generar();

        adapter.delete(id);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(jpaRepo, times(1)).deleteById(captor.capture());
        assertEquals(id.toString(), captor.getValue());
    }

    @Test
    void findByUsername_encuentraCorrectamente() {
        UsuarioWeb usuario = crearUsuario();
        UsuarioWebEntity entity = mapper.ToEntity(usuario);

        when(jpaRepo.findByUsername("miusuario"))
                .thenReturn(Optional.of(entity));

        Optional<UsuarioWeb> result = adapter.findbyUsername("miusuario");

        assertTrue(result.isPresent());
    }

    @Test
    void findByEmail_encuentraCorrectamente() {
        UsuarioWeb usuario = crearUsuario();
        UsuarioWebEntity entity = mapper.ToEntity(usuario);

        when(jpaRepo.findByEmail("correo@test.com"))
                .thenReturn(Optional.of(entity));

        Optional<UsuarioWeb> result = adapter.findByEmail(new Email("correo@test.com"));

        assertTrue(result.isPresent());
    }
}
