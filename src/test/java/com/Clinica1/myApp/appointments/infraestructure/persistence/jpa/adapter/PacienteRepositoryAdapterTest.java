package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.adapter;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.PacienteEntity;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper.PacienteMapper;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.repository.JPAPacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteRepositoryAdapterTest {

    @Mock
    private JPAPacienteRepository pacienteDao;

    @Mock
    private PacienteMapper mapper;

    @InjectMocks
    private PacienteRepositoryAdapter adapter;

    private Paciente paciente;
    private PacienteEntity entity;

    @BeforeEach
    void setUp() {
        paciente = mock(Paciente.class);
        entity = mock(PacienteEntity.class);
    }

    // ---------- INSERT ----------
    @Test
    void deberiaInsertarPacienteCorrectamente() {

        when(mapper.ToEntity(paciente)).thenReturn(entity);
        when(pacienteDao.save(entity)).thenReturn(entity);
        when(mapper.ToDomain(entity)).thenReturn(paciente);

        Paciente result = adapter.insert(paciente);

        assertNotNull(result);
        verify(pacienteDao).save(entity);
    }

    // ---------- UPDATE ----------
    @Test
    void deberiaActualizarPacienteCorrectamente() {

        when(mapper.ToEntity(paciente)).thenReturn(entity);
        when(pacienteDao.save(entity)).thenReturn(entity);
        when(mapper.ToDomain(entity)).thenReturn(paciente);

        Paciente result = adapter.update(paciente);

        assertNotNull(result);
        verify(pacienteDao).save(entity);
    }

    // ---------- FIND BY ID ----------
    @Test
    void deberiaBuscarPacientePorId() {

        IDEntidad id = IDEntidad.generar();

        when(pacienteDao.findById(id.obtenerid()))
                .thenReturn(Optional.of(entity));
        when(mapper.ToDomain(entity)).thenReturn(paciente);

        Optional<Paciente> result = adapter.findById(id);

        assertTrue(result.isPresent());
        verify(pacienteDao).findById(id.obtenerid());
    }

    // ---------- FIND ALL ----------
    @Test
    void deberiaListarPacientes() {

        when(pacienteDao.findAll()).thenReturn(List.of(entity));
        when(mapper.ToDomain(entity)).thenReturn(paciente);

        List<Paciente> result = adapter.findall();

        assertEquals(1, result.size());
        verify(pacienteDao).findAll();
    }

    // ---------- FIND BY DNI ----------
    @Test
    void deberiaBuscarPorDni() {

        when(pacienteDao.findByDni("12345678"))
                .thenReturn(Optional.of(entity));
        when(mapper.ToDomain(entity)).thenReturn(paciente);

        Paciente result = adapter.findbyDNI("12345678");

        assertNotNull(result);
        verify(pacienteDao).findByDni("12345678");
    }

    // ---------- FIND BY EMAIL ----------
    @Test
    void deberiaBuscarPorEmail() {

        Email email = Email.of("test@mail.com");

        when(pacienteDao.findByEmail(email.email_valor()))
                .thenReturn(Optional.of(entity));
        when(mapper.ToDomain(entity)).thenReturn(paciente);

        Paciente result = adapter.findbyEmail(email);

        assertNotNull(result);
        verify(pacienteDao).findByEmail(email.email_valor());
    }

    // ---------- FIND BY NAME ----------
    @Test
    void deberiaBuscarPorNombre() {

        when(pacienteDao.findByNombreCompleto("Juan Perez"))
                .thenReturn(Optional.of(entity));
        when(mapper.ToDomain(entity)).thenReturn(paciente);

        Paciente result = adapter.findbyName("Juan Perez");

        assertNotNull(result);
        verify(pacienteDao).findByNombreCompleto("Juan Perez");
    }

    // ---------- DELETE ----------
    @Test
    void deberiaEliminarPaciente() {

        IDEntidad id = IDEntidad.generar();

        adapter.delete(id);

        verify(pacienteDao).deleteById(id.obtenerid());
    }
}