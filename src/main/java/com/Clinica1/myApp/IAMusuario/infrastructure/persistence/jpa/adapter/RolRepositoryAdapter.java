package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.IAMusuario.domain.repository.RolRepository;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.FuncionEmbeddable;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.RolEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.FuncionMapper;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.RolMapper;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository.JPARolRepository;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RolRepositoryAdapter implements RolRepository {
    private final JPARolRepository rol_repo;
    private final RolMapper rol_map;
    private final FuncionMapper fun_map;

    public RolRepositoryAdapter(JPARolRepository rol_repo, RolMapper rol_map, FuncionMapper fun_map) {
        this.rol_repo = rol_repo;
        this.rol_map = rol_map;
        this.fun_map = fun_map;
    }

    //metodos especificos
    @Override
    public Optional<Rol> findByNombre(Roles rol_nom){
        return rol_repo.findByNombre(rol_nom.name())
                .map(rol_map::ToDomain);

    }

    @Override
    public Set<Funcion> findFuncionesByNombre(Roles rol_nom) {
        Set<FuncionEmbeddable> fun_emb= rol_repo.findFuncionesByNombre(rol_nom.name());
        return fun_emb
                .stream()
                .map(fun_map::ToDomain)
                .collect(Collectors.toSet());


    }

    //ICRUD
    @Override
    public Rol insert(Rol rol){
        RolEntity rol_ent= rol_map.ToEntity(rol);
        RolEntity rol_ent_saved= rol_repo.save(rol_ent);

        return rol_map.ToDomain(rol_ent_saved);
    }

    @Override
    public Rol update(Rol rol2){
        RolEntity rol_ent2= rol_map.ToEntity(rol2);
        RolEntity rol_ent_saved2= rol_repo.save(rol_ent2);

        return rol_map.ToDomain(rol_ent_saved2);
    }

    @Override
    public Optional<Rol> findById(IDEntidad id){
        return rol_repo.findById(id.obtenerid())
                .map(rol_map::ToDomain);
    }

    @Override
    public List<Rol> findall(){
        return rol_repo.findAll()
                .stream()
                .map(rol_map::ToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(IDEntidad id){
        rol_repo.deleteById(id.obtenerid());
    }

}
