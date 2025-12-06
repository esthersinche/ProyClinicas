package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.adapter;

import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.ActuPass.EmpleadoRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.repository.EmpleadoJpaRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper.EmpleadoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EmpleadoRepositoryAdapter implements EmpleadoRepository {

    private final EmpleadoJpaRepository jpaRepository;
    private final EmpleadoMapper mapper;

    @Override
    @Transactional
    public Empleado insert(Empleado empleado) {
        var entity = mapper.toEntity(empleado);
        var saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    @Transactional
    public Empleado update(Empleado empleado) {
        if (!jpaRepository.existsById(empleado.getId_emp().obtenerid())) {
            throw new RuntimeException("Empleado no encontrado");
        }
        var entity = mapper.toEntity(empleado);
        var updated = jpaRepository.save(entity);
        return mapper.toDomain(updated);
    }

    @Override
    public Empleado findById(IDEntidad id) {
        return jpaRepository.findById(id.obtenerid()).map(mapper::toDomain).orElse(null);
    }

    @Override
    public List<Empleado> findall() {
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
    public Empleado findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(mapper::toDomain).orElse(null);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }
}