package com.controleAtividades.equipe.service.Impl;

import com.controleAtividades.equipe.entity.ChangeSpecificDataEntity;
import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import com.controleAtividades.equipe.entity.enums.StatusType;
import com.controleAtividades.equipe.error.ErrorResponse;
import com.controleAtividades.equipe.error.RestExceptionHandler;
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

    @Autowired
    RestExceptionHandler restExceptionHandler;

    String objectNames = "Válido somente os seguintes status: DESENVOLVER, DESENVOLVENDO, TESTAR, TESTANDO, HOMOLOGADO, AGUARDANDO_GMUD, GMUD_ABERTA, CONCLUIDO";

    public Boolean validateEnumExists(String status) {
        status = status.trim().toUpperCase();

        for (StatusType c : StatusType.values()) {
            if (c.name().equals(status)) {
                return true;
            }
        }
        return false;
    }

    public Boolean validateValueCancel(String status) {
        status = status.trim().toUpperCase();

        if(status.equalsIgnoreCase("CANCELADO")) {
            return true;
        }
        return false;
    }

    public ResponseEntity dispatchError(String message, int code, String status, String objectNames) {
        ErrorResponse errorResponse = new ErrorResponse(message, code , status, objectNames, null);
        return ResponseEntity.status(400).body(errorResponse);
    }

    @Override
    public ResponseEntity<Object> newActivities(ControlOfTeamActivities controlOfTeamActivities) {

        Boolean validateEnum = validateEnumExists(controlOfTeamActivities.getStatus());
        if(validateEnum == false) {
            return dispatchError("O status informado não existe.", 400,"Bad Request", objectNames);
        }

        Boolean validateValueCancel = validateValueCancel(controlOfTeamActivities.getStatus());
        if(validateValueCancel == true) {
            return dispatchError("A atividade não pode iniciar com o status Cancelado.",400,"Bad Request", objectNames);
        }

        controlOfTeamActivities.setStatus(controlOfTeamActivities.getStatus().trim().toUpperCase()) ;
        ControlOfTeamActivities save = repository.save(controlOfTeamActivities);
        return ResponseEntity.status(201).body(save);
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
                    if (user.getStatus().equals(StatusType.DESENVOLVER.toString())) {
                        repository.deleteById(id);
                    } else {
                        user.setStatus("CANCELADO");
                        repository.save(user);
                    }

                    return ResponseEntity.ok().body(user);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity updateData(long id, ChangeSpecificDataEntity changeSpecificData) {
        return repository.findById(id)
                .map(user -> {

                    Date data = new Date();
                    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

                    user.setId(id);
                    user.setUltimaAtt(formater.format(data));

                    if (changeSpecificData.getStatus() != null && !changeSpecificData.getStatus().isEmpty()) {

                        Boolean validateEnum = validateEnumExists(changeSpecificData.getStatus());
                        if(validateEnum == false) {
                            return dispatchError("O status informado não existe.", 400,"Bad Request", objectNames);
                        }

                        Boolean validateValueCancel = validateValueCancel(changeSpecificData.getStatus());
                        if(validateValueCancel == true) {
                            return dispatchError("A atividade não pode ser alterada para o status Cancelado.",400,"Bad Request", objectNames);
                        }

                        changeSpecificData.setStatus(changeSpecificData.getStatus().trim().toUpperCase()) ;
                        user.setStatus(changeSpecificData.getStatus());
                    }

                    if (changeSpecificData.getNovoNumero() != BigDecimal.valueOf(0)){
                        user.setNovoNumero(changeSpecificData.getNovoNumero());
                    }

                    if (changeSpecificData.getObs() != null && !changeSpecificData.getObs().isEmpty()){
                        user.setObs(changeSpecificData.getObs());
                    }
                    if (changeSpecificData.getImplantação() != null && !changeSpecificData.getImplantação().isEmpty()){
                        user.setImplantação(changeSpecificData.getImplantação());
                    }
                    if (changeSpecificData.getCADImplantação() != null && !changeSpecificData.getCADImplantação().isEmpty()){
                        user.setCADImplantação(changeSpecificData.getCADImplantação());
                    }
                    if (changeSpecificData.getGMUD() != null && !changeSpecificData.getGMUD().isEmpty()){
                        user.setGMUD(changeSpecificData.getGMUD());
                    }
                    if (changeSpecificData.getAPI() != null && !changeSpecificData.getAPI().isEmpty()){
                        user.setAPI(changeSpecificData.getAPI());
                    }

                    repository.save(user);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
