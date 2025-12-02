package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioWebEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.UsuarioMapper;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository.JPAUsuarioEntityRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
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

        UsuarioWebEntity usuweb_ent= usuarioMapper.ToEntity(usuarioWeb);
        UsuarioWebEntity usuweb_saved= jpaUsuarioRepository.save(usuweb_ent);
        return usuarioMapper.ToDomain(usuweb_saved);

    }

    @Override
    public UsuarioWeb update(UsuarioWeb usuarioWeb) {

        UsuarioWebEntity usuweb_ent2= usuarioMapper.ToEntity(usuarioWeb);
        UsuarioWebEntity usuweb_saved2= jpaUsuarioRepository.save(usuweb_ent2);
        return usuarioMapper.ToDomain(usuweb_saved2);

    }

    @Override
    public Optional<UsuarioWeb> FindById(IDEntidad id) {
        /*return jpaUsuarioRepository.findById(id.toString())
                .map(usuarioMapper::toDomain);*/
        return jpaUsuarioRepository.findById(id.obtenerid())
                .map(usuarioMapper::ToDomain);


    }

    @Override
    public List<UsuarioWeb> getall() {
        /*
        return jpaUsuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDomain)
                .collect(Collectors.toList());*/
        return jpaUsuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::ToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(IDEntidad id) {
        jpaUsuarioRepository.deleteById(id.toString());
    }

    /* ========== MÉTODO ESPECÍFICO ========== */

    @Override
    public Optional<UsuarioWeb> findById_Emp(IDEntidad id_usuweb_emp){
        return jpaUsuarioRepository.findById_Emp(id_usuweb_emp.obtenerid())
                .map(usuarioMapper::ToDomain);
    }

    @Override
    public Optional<UsuarioWeb> findById_Cli(IDEntidad id_usuweb_cli){
        return jpaUsuarioRepository.findById_Cli(id_usuweb_cli.obtenerid())
                .map(usuarioMapper::ToDomain);
    }

    @Override
    public Optional<UsuarioWeb> findByEmail(Email usuweb_email){
        /*return jpaUsuarioRepository.findByEmail(usuweb_email.toString());*/
        return jpaUsuarioRepository.findByEmail(usuweb_email.email_valor())
                .map(usuarioMapper::ToDomain);


    }


}
