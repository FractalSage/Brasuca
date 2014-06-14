/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Francisco
 */
public class ApostadorModel implements Comparable<ApostadorModel> {

    private String grupoA, grupoB, grupoC, grupoD, grupoE,
            grupoF, grupoG, grupoH, octavos, cuartos, semis,
            tercer, sfinal, podio, goleador, total, usuario, posicion;
    private Integer iGrupoA = 0, iGrupoB = 0, iGrupoC = 0, iGrupoD = 0, iGrupoE = 0,
            iGrupoF = 0, iGrupoG = 0, iGrupoH = 0, iOctavos = 0, iCuartos = 0, iSemis = 0,
            iTercer = 0, iFinal = 0, iPodio = 0, iGoleador = 0;
    private final Integer iTotal;

    public String getGrupoA() {
        return grupoA;
    }

    public void setGrupoA(String grupoA) {
        this.grupoA = grupoA;
    }

    public String getGrupoB() {
        return grupoB;
    }

    public void setGrupoB(String grupoB) {
        this.grupoB = grupoB;
    }

    public String getGrupoC() {
        return grupoC;
    }

    public void setGrupoC(String grupoC) {
        this.grupoC = grupoC;
    }

    public String getGrupoD() {
        return grupoD;
    }

    public void setGrupoD(String grupoD) {
        this.grupoD = grupoD;
    }

    public String getGrupoE() {
        return grupoE;
    }

    public void setGrupoE(String grupoE) {
        this.grupoE = grupoE;
    }

    public String getGrupoF() {
        return grupoF;
    }

    public void setGrupoF(String grupoF) {
        this.grupoF = grupoF;
    }

    public String getGrupoG() {
        return grupoG;
    }

    public void setGrupoG(String grupoG) {
        this.grupoG = grupoG;
    }

    public String getGrupoH() {
        return grupoH;
    }

    public void setGrupoH(String grupoH) {
        this.grupoH = grupoH;
    }

    public String getOctavos() {
        return octavos;
    }

    public void setOctavos(String octavos) {
        this.octavos = octavos;
    }

    public String getCuartos() {
        return cuartos;
    }

    public void setCuartos(String cuartos) {
        this.cuartos = cuartos;
    }

    public String getSemis() {
        return semis;
    }

    public void setSemis(String semis) {
        this.semis = semis;
    }

    public String getTercer() {
        return tercer;
    }

    public void setTercer(String tercer) {
        this.tercer = tercer;
    }

    public String getSfinal() {
        return sfinal;
    }

    public void setSfinal(String sfinal) {
        this.sfinal = sfinal;
    }

    public String getPodio() {
        return podio;
    }

    public void setPodio(String podio) {
        this.podio = podio;
    }

    public String getGoleador() {
        return goleador;
    }

    public void setGoleador(String goleador) {
        this.goleador = goleador;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public ApostadorModel(Apostador apostador) {
        Equipo pri = null, seg = null, ter = null;
        ArrayList<Grupo> grupos = Grupo.getaGrupos();
        ArrayList<Partido> partidos;
        ArrayList<ApuestaGrupo> betgrupos = apostador.getaGrupos();
        ArrayList<ApuestaPartido> betpartidos;
        ApuestaGrupo betgrupo;
        Partido partido;
        ApuestaPartido betpartido;
        int i = 0;
        for (Grupo grupo : grupos) {
            betgrupo = betgrupos.get(i);
            partidos = grupo.getaPartidos();
            betpartidos = betgrupos.get(i).getaPartidos();
            for (int j = 0; j < partidos.size(); j++) {
                partido = partidos.get(j);
                betpartido = betpartidos.get(j);
                if (partido.isbJugado()) {
                    if (((partido.getiGolesLocal() > partido.getiGolesVisitante())
                            && (betpartido.getiGolLocal() > betpartido.getiGolVisitante()))
                            || ((partido.getiGolesLocal() < partido.getiGolesVisitante())
                            && (betpartido.getiGolLocal() < betpartido.getiGolVisitante()))
                            || ((Objects.equals(partido.getiGolesLocal(), partido.getiGolesVisitante()))
                            && (Objects.equals(betpartido.getiGolLocal(), betpartido.getiGolVisitante())))) {
                        switch (i) {
                            case 0: {
                                iGrupoA += 2;
                                break;
                            }
                            case 1: {
                                iGrupoB += 2;
                                break;
                            }
                            case 2: {
                                iGrupoC += 2;
                                break;
                            }
                            case 3: {
                                iGrupoD += 2;
                                break;
                            }
                            case 4: {
                                iGrupoE += 2;
                                break;
                            }
                            case 5: {
                                iGrupoF += 2;
                                break;
                            }
                            case 6: {
                                iGrupoG += 2;
                                break;
                            }
                            case 7: {
                                iGrupoH += 2;
                                break;
                            }
                        }
                    }
                    if ((Objects.equals(partido.getiGolesLocal(), betpartido.getiGolLocal())
                            && Objects.equals(partido.getiGolesVisitante(), betpartido.getiGolVisitante()))) {
                        switch (i) {
                            case 0: {
                                iGrupoA += 3;
                                break;
                            }
                            case 1: {
                                iGrupoB += 3;
                                break;
                            }
                            case 2: {
                                iGrupoC += 3;
                                break;
                            }
                            case 3: {
                                iGrupoD += 3;
                                break;
                            }
                            case 4: {
                                iGrupoE += 3;
                                break;
                            }
                            case 5: {
                                iGrupoF += 3;
                                break;
                            }
                            case 6: {
                                iGrupoG += 3;
                                break;
                            }
                            case 7: {
                                iGrupoH += 3;
                                break;
                            }
                        }
                    }
                }
            }
            if ((grupo.getePrimero() == betgrupo.getePrimero())
                    && (grupo.geteSegundo() == betgrupo.geteSegundo())) {
                switch (i) {
                    case 0: {
                        iGrupoA += 3;
                        break;
                    }
                    case 1: {
                        iGrupoB += 3;
                        break;
                    }
                    case 2: {
                        iGrupoC += 3;
                        break;
                    }
                    case 3: {
                        iGrupoD += 3;
                        break;
                    }
                    case 4: {
                        iGrupoE += 3;
                        break;
                    }
                    case 5: {
                        iGrupoF += 3;
                        break;
                    }
                    case 6: {
                        iGrupoG += 3;
                        break;
                    }
                    case 7: {
                        iGrupoH += 3;
                        break;
                    }
                }
            }
            i++;
        }
        ArrayList<Partido> playoffs = Partido.getaPartidos();
        ArrayList<ApuestaPartido> oct = apostador.getaOctavos();
        ArrayList<ApuestaPartido> cto = apostador.getaCuartos();
        ArrayList<ApuestaPartido> semi = apostador.getaSemis();
        ArrayList<ApuestaPartido> finales = apostador.getaFinales();
        for (Partido llave : playoffs) {
            for (ApuestaPartido betllave : oct) {
                if (Objects.equals(betllave.getsId(), llave.getsId())) {
                    if (llave.isbJugado()) {
                        if ((llave.getiGolesLocal() > llave.getiGolesVisitante())
                                && (betllave.getiGolLocal() > betllave.getiGolVisitante())
                                || (llave.getiGolesLocal() < llave.getiGolesVisitante())
                                && (betllave.getiGolLocal() < betllave.getiGolVisitante())) {
                            iOctavos += 2;
                        }
                        if ((Objects.equals(llave.getiGolesLocal(), betllave.getiGolLocal()))
                                && (Objects.equals(llave.getiGolesVisitante(), betllave.getiGolVisitante()))) {
                            iOctavos += 3;
                        }
                    }
                }
            }
            for (ApuestaPartido betllave : cto) {
                if (Objects.equals(betllave.getsId(), llave.getsId())) {
                    if (llave.isbJugado()) {
                        if ((llave.getiGolesLocal() > llave.getiGolesVisitante())
                                && (betllave.getiGolLocal() > betllave.getiGolVisitante())
                                || (llave.getiGolesLocal() < llave.getiGolesVisitante())
                                && (betllave.getiGolLocal() < betllave.getiGolVisitante())) {
                            iCuartos += 2;
                        }
                        if ((Objects.equals(llave.getiGolesLocal(), betllave.getiGolLocal()))
                                && (Objects.equals(llave.getiGolesVisitante(), betllave.getiGolVisitante()))) {
                            iCuartos += 3;
                        }
                    }
                }
            }
            for (ApuestaPartido betllave : semi) {
                if (Objects.equals(betllave.getsId(), llave.getsId())) {
                    if (llave.isbJugado()) {
                        if ((llave.getiGolesLocal() > llave.getiGolesVisitante())
                                && (betllave.getiGolLocal() > betllave.getiGolVisitante())
                                || (llave.getiGolesLocal() < llave.getiGolesVisitante())
                                && (betllave.getiGolLocal() < betllave.getiGolVisitante())) {
                            iSemis += 2;
                        }
                        if ((Objects.equals(llave.getiGolesLocal(), betllave.getiGolLocal()))
                                && (Objects.equals(llave.getiGolesVisitante(), betllave.getiGolVisitante()))) {
                            iSemis += 3;
                        }
                    }
                }
            }
            for (ApuestaPartido betllave : finales) {
                if (Objects.equals(betllave.getsId(), llave.getsId())) {
                    if (llave.isbJugado()) {
                        if ((llave.getiGolesLocal() > llave.getiGolesVisitante())) {
                            switch (llave.getsId()) {
                                case 63: {
                                    ter = llave.geteLocal();
                                    break;
                                }
                                case 64: {
                                    pri = llave.geteLocal();
                                    seg = llave.geteVisitante();
                                    iFinal += 2;
                                    break;
                                }
                            }
                        } else {
                            switch (llave.getsId()) {
                                case 63: {
                                    ter = llave.geteVisitante();
                                    break;
                                }
                                case 64: {
                                    pri = llave.geteVisitante();
                                    seg = llave.geteLocal();
                                    iFinal += 2;
                                    break;
                                }
                            }
                        }
                        if ((llave.getiGolesLocal() > llave.getiGolesVisitante())
                                && (betllave.getiGolLocal() > betllave.getiGolVisitante())
                                || (llave.getiGolesLocal() < llave.getiGolesVisitante())
                                && (betllave.getiGolLocal() < betllave.getiGolVisitante())) {
                            switch (llave.getsId()) {
                                case 63: {
                                    iTercer += 2;
                                    break;
                                }
                                case 64: {
                                    iFinal += 2;
                                    break;
                                }
                            }
                        }
                        if ((Objects.equals(llave.getiGolesLocal(), betllave.getiGolLocal()))
                                && (Objects.equals(llave.getiGolesVisitante(), betllave.getiGolVisitante()))) {
                            switch (llave.getsId()) {
                                case 63: {
                                    iTercer += 2;
                                    break;
                                }
                                case 64: {
                                    iFinal += 2;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (Partido.getPartido(64).isbJugado()) {
            for (String gol : ServiceManager.getsGoleador()) {
                if (apostador.getGoleador().equals(gol)) {
                    iGoleador += 66;
                }
            }
        }
        if ((apostador.getCampeon() == pri || apostador.getCampeon() == seg || apostador.getCampeon() == ter)
                && (apostador.getSegundo() == pri || apostador.getSegundo() == seg || apostador.getSegundo() == ter)
                && (apostador.getTercero() == pri || apostador.getTercero() == seg || apostador.getTercero() == ter)) {
            iPodio += 30;
        }
        if (apostador.getCampeon() == pri
                && apostador.getSegundo() == seg
                && apostador.getTercero() == ter) {
            iPodio += 60;
        }
        iTotal = iGrupoA + iGrupoB + iGrupoC + iGrupoD + iGrupoE + iGrupoF + iGrupoG + iGrupoH
                + iOctavos + iCuartos + iSemis + iTercer + iFinal + iGoleador + iPodio;
        this.usuario = apostador.getsUsuario();
        this.grupoA = iGrupoA.toString();
        this.grupoB = iGrupoB.toString();
        this.grupoC = iGrupoC.toString();
        this.grupoD = iGrupoD.toString();
        this.grupoE = iGrupoE.toString();
        this.grupoF = iGrupoF.toString();
        this.grupoG = iGrupoG.toString();
        this.grupoH = iGrupoH.toString();
        this.octavos = iOctavos.toString();
        this.cuartos = iCuartos.toString();
        this.semis = iSemis.toString();
        this.tercer = iTercer.toString();
        this.sfinal = iFinal.toString();
        this.podio = iPodio.toString();
        this.goleador = iGoleador.toString();
        this.total = iTotal.toString();        
    }

    @Override
    public int compareTo(ApostadorModel other) {
        return this.iTotal.compareTo(other.iTotal);
    }
}
