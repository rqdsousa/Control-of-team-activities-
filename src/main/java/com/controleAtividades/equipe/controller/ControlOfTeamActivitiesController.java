package com.controleAtividades.equipe.controller;

import com.controleAtividades.equipe.entity.ChangeSpecificDataEntity;
import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import com.controleAtividades.equipe.entity.StatusType;
import com.controleAtividades.equipe.repository.ControlOfTeamActivitiesRepository;
import com.controleAtividades.equipe.service.ActivitiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST CONTROLOFTEAMACTIVITIES ")
@CrossOrigin(origins = "*")
public class ControlOfTeamActivitiesController {

    @Autowired
    ControlOfTeamActivitiesRepository controlOfTeamActivitiesRepository;

    @Autowired
    ActivitiesService service;

    @ApiImplicitParams({@ApiImplicitParam(allowableValues="ABERTO, PENDENTE, FECHADO")
    })
    @PostMapping("/newActivities")
    @ApiOperation(value = "CRIAR UMA NOVA HISTÓRIA ")
    public ControlOfTeamActivities newActivities(@RequestBody @Valid ControlOfTeamActivities controlOfTeamActivities) {
        return service.newActivities(controlOfTeamActivities);
    }

    @GetMapping("/listAll")
    @ApiOperation(value = "RETORNAR TODAS AS HISTÓRIAS DO SISTEMA")
    public List<ControlOfTeamActivities> listAll() {
        return service.listControlOfTeamActivities();
    }

    @GetMapping("/listId/{id}")
    @ApiOperation(value = "RETORNAR UMA ÚNICA HISTÓRIA DO SISTEMA")
    public Optional<ControlOfTeamActivities> listId(@PathVariable(value = "id") long id) {
        return service.uniqueStory(id);
    }

    @GetMapping("/listByStatus/status")
    @ApiOperation(value = "BUSCAR UMA HISTÓRIA POR STATUS")
    public List<ControlOfTeamActivities> listByStatus(@RequestParam StatusType status) {
        return service.searchStatus(status);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "DELETAR")
    public ResponseEntity delete(@PathVariable(value = "id") long id) {
       return service.deleteSingle(id);
    }

    @PatchMapping(path = "update/{id}")
    @ApiOperation(value = "ATUALIZAR OS DADOS DO SISTEMA")
    public ResponseEntity  update(@PathVariable(value = "id") long id, @RequestBody @Valid ChangeSpecificDataEntity changeSpecificData){
       return service.updateData(id,changeSpecificData);

    }

}
























