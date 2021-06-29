package com.controleAtividades.equipe.controller;

import com.controleAtividades.equipe.entity.ChangeSpecificData;
import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import com.controleAtividades.equipe.entity.StatusType;
import com.controleAtividades.equipe.repository.ControlOfTeamActivitiesRepository;
import com.controleAtividades.equipe.service.ActivitiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    ActivitiesService service;


    @PostMapping("/newActivities")
    @ApiOperation(value = "CRIAR UMA NOVA HISTÓRIA ")
    public ControlOfTeamActivities newActivities(@RequestBody ControlOfTeamActivities controlOfTeamActivities) {
        return service.newActivities(controlOfTeamActivities);
    }

    @GetMapping("/controlOfTeamActivities")
    @ApiOperation(value = "RETORNAR TODAS AS HISTÓRIAS DO SISTEMA")
    public List<ControlOfTeamActivities> listControlOfTeamActivities() {
        return service.listControlOfTeamActivities();
    }

    @GetMapping("/uniqueStory/{id}")
    @ApiOperation(value = "RETORNAR UMA ÚNICA HISTÓRIA DO SISTEMA")
    public Optional<ControlOfTeamActivities> uniqueStory(@PathVariable(value = "id") long id) {
        return service.uniqueStory(id);
    }

    @GetMapping("/searchStatus/status")
    @ApiOperation(value = "BUSCAR UMA HISTÓRIA POR STATUS")
    public List<ControlOfTeamActivities> searchStatus(@RequestParam StatusType status) {
        return service.searchStatus(status);
    }

    @DeleteMapping("/deleteSingle/{id}")
    @ApiOperation(value = "DELETAR")
    public ResponseEntity deleteSingle(@PathVariable(value = "id") long id) {
       return service.deleteSingle(id);
    }

    @PatchMapping(path = "updateData/{id}")
    @ApiOperation(value = "ATUALIZAR OS DADOS DO SISTEMA")
    public ResponseEntity  updateData(@PathVariable(value = "id") long id, @RequestBody ChangeSpecificData changeSpecificData){
       return service.updateData(id,changeSpecificData);

    }

}
























