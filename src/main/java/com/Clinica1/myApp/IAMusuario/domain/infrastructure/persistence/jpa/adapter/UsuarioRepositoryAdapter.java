package com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.entity.UsuarioEntity;
import com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.mapper.UsuarioMapper;
import com.Clinica1.myApp.IAMusuario.domain.infrastructure.persistence.jpa.repository.JPAUsuarioRepository;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Usuario;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final JPAUsuarioRepository jpaUsuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioRepositoryAdapter(JPAUsuarioRepository jpaUsuarioRepository,
            UsuarioMapper usuarioMapper) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    /* ========== ICRUD ========== */

    @Override
    public Usuario insert(Usuario usuario) {
        UsuarioEntity entity = usuarioMapper.toEntity(usuario);
        UsuarioEntity saved = jpaUsuarioRepository.save(entity);
        return usuarioMapper.toDomain(saved);
    }

    @Override
    public Usuario update(Usuario usuario) {
        UsuarioEntity entity = usuarioMapper.toEntity(usuario);
        UsuarioEntity saved = jpaUsuarioRepository.save(entity);
        return usuarioMapper.toDomain(saved);
    }

    @Override
    public Usuario FindById(UUID id) {
        return jpaUsuarioRepository.findById(id.toString())
                .map(usuarioMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Usuario> getall() {
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
    public Usuario findbyUsername(String usu_username) {
        return jpaUsuarioRepository.findByUsername(usu_username)
                .map(usuarioMapper::toDomain)
                .orElse(null);
    }
}
