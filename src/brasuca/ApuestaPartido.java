/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import java.io.Serializable;

/**
 *
 * @author Francisco
 */
public class ApuestaPartido implements Serializable {

    private Integer sId;
    private String sEtapa;
    private Equipo eLocal, eVisitante;
    private Integer iGolLocal;
    private Integer iGolVisitante;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsEtapa() {
        return sEtapa;
    }

    public void setsEtapa(String sEtapa) {
        this.sEtapa = sEtapa;
    }

    public Equipo geteLocal() {
        return eLocal;
    }

    public void seteLocal(Equipo eLocal) {
        this.eLocal = eLocal;
    }

    public Equipo geteVisitante() {
        return eVisitante;
    }

    public void seteVisitante(Equipo eVisitante) {
        this.eVisitante = eVisitante;
    }

    public Integer getiGolLocal() {
        return iGolLocal;
    }

    public void setiGolLocal(Integer iGolLocal) {
        this.iGolLocal = iGolLocal;
    }

    public Integer getiGolVisitante() {
        return iGolVisitante;
    }

    public void setiGolVisitante(Integer iGolVisitante) {
        this.iGolVisitante = iGolVisitante;
    }

    public ApuestaPartido() {

    }

    ApuestaPartido(Partido p) {
        this.sId = p.getsId();
        this.sEtapa = p.getsEtapa();
        this.eLocal = p.geteLocal();
        this.eVisitante = p.geteVisitante();
        this.iGolLocal = 0;
        this.iGolVisitante = 0;
    }
}
