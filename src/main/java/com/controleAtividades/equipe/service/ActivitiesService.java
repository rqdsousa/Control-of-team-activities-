package com.controleAtividades.equipe.service;

import com.controleAtividades.equipe.entity.ChangeSpecificData;
import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import com.controleAtividades.equipe.entity.StatusType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


public interface ActivitiesService {


    ControlOfTeamActivities newActivities(ControlOfTeamActivities controlOfTeamActivities);

    List<ControlOfTeamActivities> listControlOfTeamActivities();

    Optional<ControlOfTeamActivities> uniqueStory(long id);

    List<ControlOfTeamActivities> searchStatus(StatusType status);

    ResponseEntity deleteSingle(long id);

    ResponseEntity  updateData( long id,ChangeSpecificData changeSpecificData);
}
