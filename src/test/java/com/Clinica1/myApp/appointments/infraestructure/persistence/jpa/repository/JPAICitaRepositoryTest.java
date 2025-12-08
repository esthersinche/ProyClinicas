package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.repository;

import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.CitaEntity;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.Doc_info_cita_embeddable;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EspecialidadEmbeddable;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.Pac_info_cita_embeddable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class JPAICitaRepositoryTest {

    @Autowired
    private JPAICitaRepository repository;

    @Test
    void deberiaBuscarPorNombrePaciente() {

        // given
        CitaEntity cita = CitaEntity.builder()
                .id_cita("1")
                .inicio_cita(LocalDateTime.now())
                .pac_info(
                        Pac_info_cita_embeddable.builder()
                                .nomb_com_pac("Juan Perez")
                                .build()
                )
                .build();

        repository.save(cita);

        // when
        List<CitaEntity> result =
                repository.findByPacienteName("juan perez");

        // then
        assertThat(result).isNotEmpty();
    }

    @Test
    void deberiaBuscarPorEspecialidad() {

        CitaEntity cita = CitaEntity.builder()
                .id_cita("2")
                .inicio_cita(LocalDateTime.now())
                .espe_cita(
                        EspecialidadEmbeddable.builder()
                                .nom_espe("Cardiologia")
                                .build()
                )
                .build();

        repository.save(cita);

        List<CitaEntity> result =
                repository.findByEspecialidad("Cardiologia");

        assertThat(result).hasSize(1);
    }

    @Test
    void deberiaBuscarPorNombreDoctor() {

        CitaEntity cita = CitaEntity.builder()
                .id_cita("3")
                .inicio_cita(LocalDateTime.now())
                .doc_info(
                        Doc_info_cita_embeddable.builder()
                                .nombre_doc("Dr. House")
                                .build()
                )
                .build();

        repository.save(cita);

        List<CitaEntity> result =
                repository.findByNombreDoctor("dr. house");

        assertThat(result).hasSize(1);
    }

    @Test
    void deberiaBuscarPorDoctorYEspecialidad() {

        CitaEntity cita = CitaEntity.builder()
                .id_cita("4")
                .inicio_cita(LocalDateTime.now())
                .doc_info(
                        Doc_info_cita_embeddable.builder()
                                .nombre_doc("Juan")
                                .build()
                )
                .espe_cita(
                        EspecialidadEmbeddable.builder()
                                .nom_espe("Pediatria")
                                .build()
                )
                .build();

        repository.save(cita);

        List<CitaEntity> result =
                repository.findByNombreDoctorYEspecialidad("juan", "pediatria");

        assertThat(result).hasSize(1);
    }

    @Test
    void deberiaBuscarPorDoctorId() {

        CitaEntity cita = CitaEntity.builder()
                .id_cita("5")
                .doc_id("DOC-1")
                .inicio_cita(LocalDateTime.now())
                .build();

        repository.save(cita);

        List<CitaEntity> result =
                repository.findByDoctorId("DOC-1");

        assertThat(result).hasSize(1);
    }
}