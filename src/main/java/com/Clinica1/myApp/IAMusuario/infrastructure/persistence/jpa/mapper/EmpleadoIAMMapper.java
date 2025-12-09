package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.EmpleadoIAM;
import com.Clinica1.myApp.IAMusuario.infrastructure.integration.EmpleadoMinDto;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoIAMMapper {

    public EmpleadoIAM ToDomain(EmpleadoMinDto emp_min_dto){
        return new EmpleadoIAM(IDEntidad.astring(emp_min_dto.getId_empiam()), emp_min_dto.getNom_empiam(),
                emp_min_dto.getApe_empiam(),null, null, Roles.valueOf(emp_min_dto.getRol_empiam()));
    }

    public EmpleadoMinDto ToEntityDto(EmpleadoIAM emp_iam){
        return EmpleadoMinDto.builder()
                .id_empiam(emp_iam.getId_empiam().obtenerid())
                .nom_empiam(emp_iam.getNom_empiam())
                .ape_empiam(emp_iam.getApe_empiam())
                .rol_empiam(emp_iam.getRol_empiam().name())
                .build();
    }
}
