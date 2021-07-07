package com.controleAtividades.equipe;

import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import com.controleAtividades.equipe.service.Impl.ActivitiesServiceImpI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiesServiceImpITests {

    @Autowired
    ActivitiesServiceImpI service;

    @Test
    public void testValidateEnumExists() {
        Boolean value = service.validateEnumExists("testando");
        assertTrue(value);
    }

    @Test
    public void testValidateEnumNotExist() {
        Boolean value = service.validateEnumExists("negativo");
        assertFalse(value);
    }

    @Test
    public void testValidateValueCancel() {
        Boolean value = service.validateValueCancel("cancelado");
        assertTrue(value);
    }

    @Test
    public void testValidateValueNotCancel() {
        Boolean value = service.validateValueCancel("testando");
        assertFalse(value);
    }

    @Test
    public void testNewActivities() {
        ControlOfTeamActivities data = new ControlOfTeamActivities("Dev", "Raquel", "Desenvolvendo",null, BigDecimal.valueOf(123), "rodando", "agendada", "testes", "agendada", "desenvolvendo");
        ResponseEntity value = service.newActivities(data);

        assertEquals(value.getStatusCodeValue(), 201);
    }

    @Test
    public void testNewActivitiesStatusNotExist() {
        ControlOfTeamActivities data = new ControlOfTeamActivities("Dev", "Raquel", "negativo",null, BigDecimal.valueOf(123), "rodando", "agendada", "testes", "agendada", "desenvolvendo");
        ResponseEntity value = service.newActivities(data);

        assertEquals(value.getStatusCodeValue(), 400);
    }

    @Test
    public void testNewActivitiesStatusCancel() {
        ControlOfTeamActivities data = new ControlOfTeamActivities("Dev", "Raquel", "cancelado",null, BigDecimal.valueOf(123), "rodando", "agendada", "testes", "agendada", "desenvolvendo");
        ResponseEntity value = service.newActivities(data);

        assertEquals(value.getStatusCodeValue(), 400);
    }

}

