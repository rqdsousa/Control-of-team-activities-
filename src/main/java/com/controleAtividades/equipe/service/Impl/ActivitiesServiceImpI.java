package com.controleAtividades.equipe.service.Impl;

import com.controleAtividades.equipe.entity.ChangeSpecificData;
import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import com.controleAtividades.equipe.entity.StatusType;
import com.controleAtividades.equipe.repository.ControlOfTeamActivitiesRepository;
import com.controleAtividades.equipe.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ActivitiesServiceImpI implements ActivitiesService {

    @Autowired
    private ControlOfTeamActivitiesRepository repository;

    @Override
    public ControlOfTeamActivities newActivities(ControlOfTeamActivities controlOfTeamActivities) {
        if(controlOfTeamActivities.getStatus() == StatusType.CANCELADO){
           return null;
        }
        return repository.save(controlOfTeamActivities);
    }

    @Override
    public List<ControlOfTeamActivities> listControlOfTeamActivities() {
        return repository.findAll();
    }

    @Override
    public Optional<ControlOfTeamActivities> uniqueStory(long id) {
        return repository.findById(id);
    }

    @Override
    public List<ControlOfTeamActivities> searchStatus(StatusType status) {
        return repository.findByStatus(status.toString());
    }

    @Override
    public ResponseEntity deleteSingle(long id) {
        return repository.findById(id)
                .map(user -> {
                    if (user.getStatus() == StatusType.DESENVOLVER) {
                        repository.deleteById(id);
                    } else {
                        user.setStatus(StatusType.valueOf("CANCELADO"));
                        repository.save(user);
                    }

                    return ResponseEntity.ok().body(user);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity updateData(long id, ChangeSpecificData changeSpecificData) {
        return repository.findById(id)
                .map(user -> {
                    Date data = new Date();
                    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

                    user.setId(id);
                    user.setUltimaAtt(formater.format(data));

                if (changeSpecificData.getStatus() != null && changeSpecificData.getStatus().toString() != "CANCELADO"){
                        user.setStatus(changeSpecificData.getStatus());
                    }

                    if (changeSpecificData.getNovoNumero() != BigDecimal.valueOf(0)){
                        user.setNovoNumero(changeSpecificData.getNovoNumero());
                    }

                    if (changeSpecificData.getObs() != null){
                        user.setObs(changeSpecificData.getObs());
                    }
                    if (changeSpecificData.getImplantação() != null){
                        user.setImplantação(changeSpecificData.getImplantação());
                    }
                    if (changeSpecificData.getCADImplantação() != null){
                        user.setCADImplantação(changeSpecificData.getCADImplantação());
                    }
                    if (changeSpecificData.getGMDU() != null){
                        user.setGMDU(changeSpecificData.getGMDU());
                    }
                    if (changeSpecificData.getAPI() != null){
                        user.setAPI(changeSpecificData.getAPI());
                    }
                    repository.save(user);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
