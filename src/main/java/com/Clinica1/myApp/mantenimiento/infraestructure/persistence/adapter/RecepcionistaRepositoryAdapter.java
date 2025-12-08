package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.adapter;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Recepcionista;
import com.Clinica1.myApp.mantenimiento.domain.repository.RecepcionistaRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.RecepcionistaEntity;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.repository.JPARecepcionistaRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper.RecepcionistaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RecepcionistaRepositoryAdapter implements RecepcionistaRepository {
    private final JPARecepcionistaRepository recep_repo;
    private final RecepcionistaMapper recep_map;

    //metodo especifico
    @Override
    public Recepcionista findByIdEmp(IDEntidad id_emp){
        return recep_repo.findByIdEmp(id_emp.obtenerid())
                .map(recep_map::ToDomain)
                .orElse(null);
    }
    //ICRUD
    @Override
    public Recepcionista insert(Recepcionista recep){
        RecepcionistaEntity recep_ent= recep_map.ToEntity(recep);
        RecepcionistaEntity recep_saved= recep_repo.save(recep_ent);

        return recep_map.ToDomain(recep_saved);
    }

    @Override
    public Recepcionista update(Recepcionista recep2){
        RecepcionistaEntity recep_ent2= recep_map.ToEntity(recep2);
        RecepcionistaEntity recep_saved2= recep_repo.save(recep_ent2);

        return recep_map.ToDomain(recep_saved2);

    }

    @Override
    public Optional<Recepcionista> findById(IDEntidad id_recep){
        return recep_repo.findById(id_recep.obtenerid())
                .map(recep_map::ToDomain);
    }

    @Override
    public List<Recepcionista> findall(){
        return recep_repo.findAll()
                .stream().map(recep_map::ToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(IDEntidad id_recep){
        recep_repo.deleteById(id_recep.obtenerid());
    }
}
