package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.SesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPASesionRepository extends JpaRepository<SesionEntity, String> {

    @Query("SELECT s FROM SeseionEntity s WHERE s.usuweb_id = :usu_id")
    List<SesionEntity> findByUserId(@Param("usu_id") String usu_id);
}
