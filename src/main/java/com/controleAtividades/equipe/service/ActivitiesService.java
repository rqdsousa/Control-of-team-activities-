package com.controleAtividades.equipe.service;

import com.controleAtividades.equipe.entity.ChangeSpecificDataEntity;
import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import com.controleAtividades.equipe.entity.enums.StatusType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface ActivitiesService {


    ResponseEntity<Object> newActivities(ControlOfTeamActivities controlOfTeamActivities);

    List<ControlOfTeamActivities> listControlOfTeamActivities();

    Optional<ControlOfTeamActivities> uniqueStory(long id);

    List<ControlOfTeamActivities> searchStatus(StatusType status);

    ResponseEntity deleteSingle(long id);

    ResponseEntity  updateData(long id, ChangeSpecificDataEntity changeSpecificData);
}

