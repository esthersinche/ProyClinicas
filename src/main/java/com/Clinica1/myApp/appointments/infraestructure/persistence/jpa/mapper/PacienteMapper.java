package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EmailEmbeddable;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.PacienteEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {
    private EmailMapper ema_map;

    //inyeccion

    public PacienteMapper(EmailMapper ema_map) {
        this.ema_map = ema_map;
    }

    public Paciente ToDomain(PacienteEntity pac_ent){
        Email email= ema_map.ToDomain(pac_ent.getEmail_pac());
        return new Paciente(IDEntidad.astring(pac_ent.getId_pac()), pac_ent.getNombre_com_pac(),
                pac_ent.getNacionalidad_pac(), pac_ent.getDni_pac(), pac_ent.getTel_pac(), email,
                pac_ent.getFec_nac_pac(), pac_ent.getSexo_pac());
    }

    public PacienteEntity ToEntity(Paciente pac){
        EmailEmbeddable email_emb= ema_map.ToEmbeddable(pac.getEmail_pac());
        return PacienteEntity.builder().id_pac(pac.getId_pac().obtenerid())
                .nombre_com_pac(pac.getNombre_com_pac())
                .nacionalidad_pac(pac.getNacionalidad_pac())
                .dni_pac(pac.getDni_pac())
                .tel_pac(pac.getTel_pac())
                .email_pac(email_emb)
                .fec_nac_pac(pac.getFec_nac_pac())
                .sexo_pac(pac.getSexo_pac())
                .build();
    }
}
