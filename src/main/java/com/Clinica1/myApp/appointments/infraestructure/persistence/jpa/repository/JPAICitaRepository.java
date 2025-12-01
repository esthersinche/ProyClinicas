package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.repository;

import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPAICitaRepository extends JpaRepository<CitaEntity, String> {

    //busquedas por nombre de paciente
    @Query("SELECT c FROM CitaEntity c WHERE LOWER(c.pac_info.nomb_com_pac)= :LOWER(nombre) ORDER BY c.inicio_cita DESC")
    List<CitaEntity> findByPacienteName(@Param("nombre") String nombre);

    //busquedas por especialidad
    @Query("SELECT c FROM CitaEntity c WHERE c.espe_cita.nom_espe = :esp ORDER BY c.inicio_cita DESC")
    List<CitaEntity> findByEspecialidad(@Param("esp") String especialidad);

    //busqueda por doctor
    @Query("SELECT c FROM CitaEntity c WHERE LOWER(c.doc_info.nombre_doc) = LOWER(:name) ORDER BY c.inicio_cita DESC")
    List<CitaEntity> findByNombreDoctor(@Param("name") String name);

    //busqueda por doctor y especialidad, aun no implemetada
    @Query("SELECT c FROM CitaEntity c WHERE LOWER(c.doc_info.nombre_doc) LIKE LOWER(concat('%', :name, '%')) " + " AND LOWER(c.espe_cita.nom_espe) = LOWER(:esp) ORDER BY c.inicio_cita DESC")
    List<CitaEntity> findByNombreDoctorYEspecialidad(@Param("name") String name, @Param("esp")String esp);

    //ns si falte aca el de busqueda de especialidades despues de doctor o si el de arriba ya lo hacexd
    List<CitaEntity> findByDoctorId(String docId);

}
