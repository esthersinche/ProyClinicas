package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Sesion;
import com.Clinica1.myApp.IAMusuario.domain.repository.SesionRepository;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.SesionEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.SesionMapper;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository.JPASesionRepository;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SessionRepositoryAdapter implements SesionRepository {
    private final JPASesionRepository ses_repo;
    private final SesionMapper ses_map;

    public SessionRepositoryAdapter(JPASesionRepository ses_repo, SesionMapper ses_map) {
        this.ses_repo = ses_repo;
        this.ses_map = ses_map;
    }

    @Override
    public List<Sesion> findByUserId(IDEntidad usu_id){
        return ses_repo.findByUserId(usu_id.obtenerid())
                .stream().map(ses_map::ToDomain)
                .collect(Collectors.toList());
    }

    //ICRUD
    /*T insert(T tall);//guarda
    T update(T tall);// actualiza
    Optional<T> FindById(UUID id);//los encuentra
    List<T> getall();//obtiene todos
    void delete(UUID ID);//delete
*/

    @Override
    public Sesion insert(Sesion ses){
        SesionEntity ses_ent= ses_map.ToEntity(ses);
        SesionEntity ses_saved= ses_repo.save(ses_ent);
        return ses_map.ToDomain(ses_saved);

    }

    @Override
    public Sesion update(Sesion ses2){
        SesionEntity ses_ent2= ses_map.ToEntity(ses2);
        SesionEntity ses_saved2= ses_repo.save(ses_ent2);
        return ses_map.ToDomain(ses_saved2);
    }

    @Override
    public Optional<Sesion> FindById(IDEntidad id){
        return ses_repo.findById(id.obtenerid())
                .map(ses_map::ToDomain);
    }

    @Override
    public List<Sesion> getall(){
        return ses_repo.findAll()
                .stream()
                .map(ses_map::ToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(IDEntidad id){
        ses_repo.deleteById(id.obtenerid());
    }

}
