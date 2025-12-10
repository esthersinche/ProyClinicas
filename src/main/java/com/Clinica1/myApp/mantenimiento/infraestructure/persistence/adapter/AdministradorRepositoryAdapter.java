package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.adapter;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;
import com.Clinica1.myApp.mantenimiento.domain.repository.AdministradorRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.repository.JPAAdministradorRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper.AdministradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdministradorRepositoryAdapter implements AdministradorRepository {
    private final JPAAdministradorRepository jpaRepository;
    private final AdministradorMapper mapper;

    @Override
    public Administrador findByIdEmp(IDEntidad id_emp) {
        return jpaRepository.findByIdEmp(id_emp.obtenerid())
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public Administrador insert(Administrador admin) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(admin))
        );
    }

    @Override
    public Administrador update(Administrador admin) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(admin))
        );
    }

    @Override
    public Optional<Administrador> findById(IDEntidad id_admin) {
        return jpaRepository.findById(id_admin.obtenerid())
                .map(mapper::toDomain);
    }

    @Override
    public List<Administrador> findall() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(IDEntidad id_admin) {
        jpaRepository.deleteById(id_admin.obtenerid());
    }
}
