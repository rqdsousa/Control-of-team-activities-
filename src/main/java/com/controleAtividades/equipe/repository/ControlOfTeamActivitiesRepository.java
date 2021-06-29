package com.controleAtividades.equipe.repository;

import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ControlOfTeamActivitiesRepository extends JpaRepository<ControlOfTeamActivities, Long> {


    @Query(value = "SELECT * FROM SISTEMA_PARA_CONTROLE_DE_ATIVIDADES_DA_EQUIPE WHERE STATUS = :status", nativeQuery = true)
    List<ControlOfTeamActivities> findByStatus(@Param("status") String status);


}
