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
    public Doctor insert(Doctor doctor) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(doctor)));
    }

    @Override
    public Doctor update(Doctor doctor) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(doctor)));
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
                .toList();
    }

    @Override
    public void delete(IDEntidad id) {
        jpaRepository.deleteById(id.obtenerid());
    }

    @Override
    public Optional<Doctor> findByCmp(String cmp) {
        return jpaRepository.findByCmp(cmp)
                .map(mapper::toDomain);
    }

    @Override
    public List<Doctor> findByEspecialidad(String nomEspe) {
        return jpaRepository.findByEspecialidades_NomEspeIgnoreCase(nomEspe)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCmp(String cmp) {
        return jpaRepository.existsByCmp(cmp);
    }

    @Override
    public Optional<Doctor> findByIdEmpleado(IDEntidad idEmpleado) {
        return jpaRepository.findByIdEmpleado(idEmpleado.obtenerid())
                .map(mapper::toDomain);
    }
}