package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.adapter;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.CitaEntity;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper.CitaMapper;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper.Doc_info_citaMapper;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper.Pac_info_citaMapper;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.repository.JPAICitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
//acl(?
public class CitaRepositoryAdapter implements CitaRepository {

    private final JPAICitaRepository citadao;
    private final Pac_info_citaMapper pacinfo_map;
    private final Doc_info_citaMapper docinfo_map;
    private final CitaMapper cit_map;


    @Override
    public List<Cita> findbyNombrepac(String nombre_pac_cita){
        return citadao.findByPacienteName(nombre_pac_cita)
                .stream().map(cit_map::ToDomain).collect(Collectors.toList());
    }

    @Override
    public List<Cita> findbyDoctor(String nom_doc_cita){
        return citadao.findByNombreDoctor(nom_doc_cita)
                .stream().map(cit_map::ToDomain).collect(Collectors.toList());
    }

    @Override
    public List<Cita> findbyEspecialidad(String nom_espe){
        return citadao.findByEspecialidad(nom_espe)
                .stream().map(cit_map::ToDomain).collect(Collectors.toList());
    }

    //crud
    @Override
    public Cita findById(IDEntidad cita_id){
        return citadao.findById(cita_id.obtenerid()).map(cit_map::ToDomain)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Cita insert(Cita cita){
        CitaEntity cita_ent= cit_map.ToEntity(cita);
        CitaEntity savedcita_ent= citadao.save(cita_ent);
        return cit_map.ToDomain(savedcita_ent);
    }

    @Override
    public Cita update(Cita cita){
        //faltan tipo, if's para verificar q este bien
        CitaEntity cita_ent= cit_map.ToEntity(cita);
        CitaEntity savedcita_ent= citadao.save(cita_ent);
        return cit_map.ToDomain(savedcita_ent);
    }

    @Override
    public List<Cita> findall(){
        return List.of();
    }

    @Override
    public void delete(IDEntidad identidad){

    }


}
