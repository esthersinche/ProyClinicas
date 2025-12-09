package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.adapter;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.repository.DoctorJpaRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper.DoctorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DoctorRepositoryAdapter implements DoctorRepository {

    private final DoctorJpaRepository jpaRepository;
    private final DoctorMapper mapper;

    @Override
    @Transactional
    public Doctor insert(Doctor doctor) {
        var entity = mapper.toEntity(doctor);
        var saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    @Transactional
    public Doctor update(Doctor doctor) {
        if (!jpaRepository.existsById(doctor.getIdDoctor().obtenerid())) {
            throw new RuntimeException("Doctor no encontrado");
        }
        var entity = mapper.toEntity(doctor);
        var updated = jpaRepository.save(entity);
        return mapper.toDomain(updated);
    }

    @Override
    public Optional<Doctor> findById(IDEntidad id) {
        return jpaRepository.findById(id.obtenerid())
                .map(mapper::toDomain);
    }

    @Override
    public List<Doctor> findall() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(IDEntidad id) {
        jpaRepository.deleteById(id.obtenerid());
    }

    @Override
    public Doctor findByCmp(String cmp) {
        return jpaRepository.findByCmp(cmp)
                .map(mapper::toDomain)
                .orElse(null);
    }


    @Override
    public List<Doctor> findByEspecialidad(String nomEspe) {
        return jpaRepository
                .findByEspecialidades_NomEspeIgnoreCase(nomEspe)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Doctor> findByNombre(String nombre) {
        return jpaRepository
                .findByNombreCompleto_NombreContainingIgnoreCaseOrNombreCompleto_ApellidoContainingIgnoreCase(
                        nombre, nombre)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCmp(String cmp) {
        return jpaRepository.existsByCmp(cmp);
    }
}