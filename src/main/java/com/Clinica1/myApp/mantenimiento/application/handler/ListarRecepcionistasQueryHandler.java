package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.dto.RecepcionistaListadoDto;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.mantenimiento.domain.repository.RecepcionistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarRecepcionistasQueryHandler {

    private final RecepcionistaRepository recepcionistaRepository;
    private final EmpleadoRepository empleadoRepository;

    public List<RecepcionistaListadoDto> handle() {

        return recepcionistaRepository.findall()
                .stream()
                .map(recep -> {
                    var emp = empleadoRepository
                            .findById(recep.getId_emp())
                            .orElse(null);

                    return new RecepcionistaListadoDto(
                            recep.getId_recep().obtenerid(),
                            recep.getId_emp().obtenerid(),
                            emp != null
                                    ? emp.getNombre() + " " + emp.getApellido()
                                    : "",
                            emp != null
                                    ? emp.getEmail().email_valor()
                                    : ""
                    );
                })
                .toList();
    }
}