package com.controleAtividades.equipe.entity;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "ACTIVITIES")
public class ControlOfTeamActivities implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String historias;
    private String desenvolvedor;

    @NotNull(message = "Status não pode ser null")
    @NotBlank(message = "Status não pode estar em branco")
    private String status;

    private String ultimaAtt;
    private BigDecimal novoNumero;


    private String obs;
    private String implantação;
    private String CADImplantação;
    private String GMUD;
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

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public String getGMUD() {
        return GMUD;
    }

    public void setGMUD(String GMUD) {
        this.GMUD = GMUD;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }


    public ControlOfTeamActivities() {

    }

    public ControlOfTeamActivities(String historias, String desenvolvedor, String status, String ultimaAtt, BigDecimal novoNumero, String obs, String implantação, String CADImplantação, String GMUD, String API) {

        this.historias = historias;
        this.desenvolvedor = desenvolvedor;
        this.status = status;
        this.ultimaAtt = ultimaAtt;
        this.novoNumero = novoNumero;
        this.obs = obs;
        this.implantação = implantação;
        this.CADImplantação = CADImplantação;
        this.GMUD = GMUD;
        this.API = API;
    }


}
