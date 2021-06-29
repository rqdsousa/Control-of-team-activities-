package com.controleAtividades.equipe.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "SISTEMA_PARA_CONTROLE_DE_ATIVIDADES_DA_EQUIPE")
public class ChangeSpecificData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private long id ;

    @Enumerated(value = EnumType.STRING)
    private TipoStatus status = null;

    private String ultimaAtt = null;
    private BigDecimal novoNumero = BigDecimal.valueOf(0);
    private String obs = null;
    private String implantação = null;
    private String CADImplantação = null;
    private String GMDU = null;
    private String API = null;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
