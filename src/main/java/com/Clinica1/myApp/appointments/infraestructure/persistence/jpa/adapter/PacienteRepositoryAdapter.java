package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.adapter;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.PacienteEntity;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper.PacienteMapper;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.repository.JPAPacienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PacienteRepositoryAdapter implements PacienteRepository {

    private JPAPacienteRepository pacienteDao;
    private PacienteMapper mapper;

    @Override
    public Paciente insert(Paciente paciente) {
        PacienteEntity entity = mapper.ToEntity(paciente);
        return mapper.ToDomain(pacienteDao.save(entity));
    }

    @Override
    public Paciente update(Paciente paciente) {
        PacienteEntity entity = mapper.ToEntity(paciente);
        return mapper.ToDomain(pacienteDao.save(entity));
    }

    @Override
    public Optional<Paciente> findById(IDEntidad id) {
        return pacienteDao.findById(id.obtenerid())
                .map(mapper::ToDomain);
    }

    @Override
    public List<Paciente> findall() {
        return pacienteDao.findAll()
                .stream()
                .map(mapper::ToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(IDEntidad id) {
        pacienteDao.deleteById(id.obtenerid());
    }

    /* ======================
       DOMAIN QUERIES
       ====================== */

    @Override
    public Paciente findbyDNI(String dni_pac) {
        return pacienteDao.findByDni(dni_pac)
                .map(mapper::ToDomain)
                .orElse(null);
    }

    @Override
    public Paciente findbyEmail(Email email) {
        return pacienteDao.findByEmail(email.email_valor())
                .map(mapper::ToDomain)
                .orElse(null);
    }

    @Override
    public Paciente findbyName(String nom_com_pac) {
        return pacienteDao.findByNombreCompleto(nom_com_pac)
                .map(mapper::ToDomain)
                .orElse(null);
    }

}
