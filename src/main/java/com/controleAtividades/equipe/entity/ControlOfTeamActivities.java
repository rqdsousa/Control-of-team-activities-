package com.controleAtividades.equipe.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "SISTEMA_PARA_CONTROLE_DE_ATIVIDADES_DA_EQUIPE")
public class ControlOfTeamActivities implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String historias;
    private String desenvolvendo;

    @Enumerated(value = EnumType.STRING)
    private TipoStatus status;

    private String ultimaAtt;
    private BigDecimal novoNumero;
    private String obs;
    private String implantação;
    private String CADImplantação;
    private String GMDU;
    private String API;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHistorias() {
        return historias;
    }

    public void setHistorias(String historias) {
        this.historias = historias;
    }

    public String getDesenvolvendo() {
        return desenvolvendo;
    }

    public void setDesenvolvendo(String desenvolvendo) {
        this.desenvolvendo = desenvolvendo;
    }

    public TipoStatus getStatus() {
        return status;
    }

    public void setStatus(TipoStatus status) {
        this.status = status;
    }

    public String getUltimaAtt() {
        return ultimaAtt;
    }

    public void setUltimaAtt(String ultimaAtt) {
        this.ultimaAtt = ultimaAtt;
    }

    public BigDecimal getNovoNumero() {
        return novoNumero;
    }

    public void setNovoNumero(BigDecimal novoNumero) {
        this.novoNumero = novoNumero;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getImplantação() {
        return implantação;
    }

    public void setImplantação(String implantação) {
        this.implantação = implantação;
    }

    public String getCADImplantação() {
        return CADImplantação;
    }

    public void setCADImplantação(String CADImplantação) {
        this.CADImplantação = CADImplantação;
    }

    public String getGMDU() {
        return GMDU;
    }

    public void setGMDU(String GMDU) {
        this.GMDU = GMDU;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }


    public ControlOfTeamActivities() {

    }

    public ControlOfTeamActivities(String historias, String desenvolvendo, TipoStatus status, String ultimaAtt, BigDecimal novoNumero, String obs, String implantação, String CADImplantação, String GMDU, String API) {

        this.historias = historias;
        this.desenvolvendo = desenvolvendo;
        this.status = status;
        this.ultimaAtt = ultimaAtt;
        this.novoNumero = novoNumero;
        this.obs = obs;
        this.implantação = implantação;
        this.CADImplantação = CADImplantação;
        this.GMDU = GMDU;
        this.API = API;
    }


}
