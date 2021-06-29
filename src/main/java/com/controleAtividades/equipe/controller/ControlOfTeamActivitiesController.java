package com.controleAtividades.equipe.controller;

import com.controleAtividades.equipe.entity.ChangeSpecificData;
import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import com.controleAtividades.equipe.entity.TipoStatus;
import com.controleAtividades.equipe.repository.ControlOfTeamActivitiesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST CONTROLOFTEAMACTIVITIES ")
@CrossOrigin(origins = "*")
public class ControlOfTeamActivitiesController {

    @Autowired
    ControlOfTeamActivitiesRepository controlOfTeamActivitiesRepository;


    @PostMapping("/controlOfTeamActivities")
    @ApiOperation(value = "SALVAR UMA HISTÓRIA ")
    public ControlOfTeamActivities salvaControlOfTeamActivities(@RequestBody ControlOfTeamActivities controlOfTeamActivities) {
        return controlOfTeamActivitiesRepository.save(controlOfTeamActivities);
    }

    @GetMapping("/controlOfTeamActivities")
    @ApiOperation(value = "RETORNA TODAS AS HISTÓRIAS DO SISTEMA")
    public List<ControlOfTeamActivities> listaControlOfTeamActivities() {
        return controlOfTeamActivitiesRepository.findAll();
    }

    @GetMapping("/controlOfTeamActivities/{id}")
    @ApiOperation(value = "RETORNA UMA ÚNICA HISTÓRIA DO SISTEMA")
    public Optional<ControlOfTeamActivities> listaControlOfTeamActivitiesUnico(@PathVariable(value = "id") long id) {
        return controlOfTeamActivitiesRepository.findById(id);
    }

    @GetMapping("/controlOfTeamActivities/status")
    @ApiOperation(value = "BUSCA UMA HISTÓRIA POR STATUS")
    public List<ControlOfTeamActivities> pesquisarPorStatus(@RequestParam TipoStatus status) {
        return controlOfTeamActivitiesRepository.findByStatus(status.toString());
    }

    @DeleteMapping("/controlOfTeamActivities/{id}")
    @ApiOperation(value = "DELETAR")
    public ResponseEntity deleteUnico(@PathVariable(value = "id") long id) {
       return controlOfTeamActivitiesRepository.findById(id)
          .map(user -> {
              if (user.getStatus() == TipoStatus.DESENVOLVER) {
                  controlOfTeamActivitiesRepository.deleteById(id);
              } else {
                   user.setStatus(TipoStatus.CANCELADO);
                   controlOfTeamActivitiesRepository.save(user);
              }

              return ResponseEntity.ok().body(user);
        }).orElse(ResponseEntity.notFound().build());

    }


    @PatchMapping(path = "controlOfTeamActivities/{id}")
    @ApiOperation(value = "ATUALIZA DADOS DO SISTEMA")
    public ResponseEntity  atualizacontrolOfTeamActivities(@PathVariable(value = "id") long id, @RequestBody ChangeSpecificData changeSpecificData){
        return controlOfTeamActivitiesRepository.findById(id)
                .map(user -> {
                    Date data = new Date();
                    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

                    user.setId(id);
                    user.setUltimaAtt(formater.format(data));

                    if (changeSpecificData.getStatus() != null){
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
                    controlOfTeamActivitiesRepository.save(user);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());


    }

}
























