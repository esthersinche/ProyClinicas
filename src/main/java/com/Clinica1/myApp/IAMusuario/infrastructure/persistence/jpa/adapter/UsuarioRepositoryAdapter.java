package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.UsuarioMapper;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository.JPAUsuarioEntityRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final JPAUsuarioEntityRepository jpaUsuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioRepositoryAdapter(JPAUsuarioEntityRepository jpaUsuarioRepository,
                                    UsuarioMapper usuarioMapper) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    /* ========== ICRUD ========== */

    @Override
    public UsuarioWeb insert(UsuarioWeb usuarioWeb) {
        UsuarioEntity entity = usuarioMapper.toEntity(usuarioWeb);
        UsuarioEntity saved = jpaUsuarioRepository.save(entity);
        return usuarioMapper.toDomain(saved);
    }

    @Override
    public UsuarioWeb update(UsuarioWeb usuarioWeb) {
        UsuarioEntity entity = usuarioMapper.toEntity(usuarioWeb);
        UsuarioEntity saved = jpaUsuarioRepository.save(entity);
        return usuarioMapper.toDomain(saved);
    }

    @Override
    public Optional<UsuarioWeb> FindById(UUID id) {
        return jpaUsuarioRepository.findById(id.toString())
                .map(usuarioMapper::toDomain);
    }

    @Override
    public List<UsuarioWeb> getall() {
        return jpaUsuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        jpaUsuarioRepository.deleteById(id.toString());
    }

    /* ========== MÉTODO ESPECÍFICO ========== */

    @Override
    public Optional<UsuarioWeb> findbyUsername(String usu_username) {
        return jpaUsuarioRepository.findByUsername(usu_username)
                .map(usuarioMapper::toDomain);
    }
}
