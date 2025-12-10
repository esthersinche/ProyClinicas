package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.dto.AdministradorListadoDto;
import com.Clinica1.myApp.mantenimiento.domain.repository.AdministradorRepository;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarAdministradoresQueryHandler {

    private final AdministradorRepository administradorRepository;
    private final EmpleadoRepository empleadoRepository;

    public List<AdministradorListadoDto> handle() {

        return administradorRepository.findall()
                .stream()
                .map(admin -> {
                    var emp = empleadoRepository
                            .findById(admin.getId_emp())
                            .orElse(null);

                    return new AdministradorListadoDto(
                            admin.getId_admin().obtenerid(),
                            admin.getId_emp().obtenerid(),
                            emp != null
                                    ? emp.getNombre() + " " + emp.getApellido()
                                    : ""
                    );
                })
                .toList();
    }
}
