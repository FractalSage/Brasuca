/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 * @author Francisco
 */
public class ApuestaGrupo implements Serializable {

    private String sNombre;
    private Equipo[] eEquipos;
    private Integer[] iPuntos, iGolesFavor, iGolesContra;
    private Equipo ePrimero, eSegundo;
    private ArrayList<ApuestaPartido> aPartidos = new ArrayList<>();

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public Equipo[] geteEquipos() {
        return eEquipos;
    }

    public void seteEquipos(Equipo[] eEquipos) {
        this.eEquipos = eEquipos;
    }

    public Integer[] getiPuntos() {
        return iPuntos;
    }

    public void setiPuntos(Integer[] iPuntos) {
        this.iPuntos = iPuntos;
    }

    public Integer[] getiGolesFavor() {
        return iGolesFavor;
    }

    public void setiGolesFavor(Integer[] iGolesFavor) {
        this.iGolesFavor = iGolesFavor;
    }

    public Integer[] getiGolesContra() {
        return iGolesContra;
    }

    public void setiGolesContra(Integer[] iGolesContra) {
        this.iGolesContra = iGolesContra;
    }

    public Equipo getePrimero() {
        return ePrimero;
    }

    public void setePrimero(Equipo ePrimero) {
        this.ePrimero = ePrimero;
    }

    public Equipo geteSegundo() {
        return eSegundo;
    }

    public void seteSegundo(Equipo eSegundo) {
        this.eSegundo = eSegundo;
    }

    public ArrayList<ApuestaPartido> getaPartidos() {
        return aPartidos;
    }

    public void setaPartidos(ArrayList<ApuestaPartido> aPartidos) {
        this.aPartidos = aPartidos;
    }

    public void CalcularGrupo() {
        CalcularPuntos();
        HashMap<String, Integer> mPtos = new HashMap<>();
        HashMap<String, Integer> mGFav = new HashMap<>();
        HashMap<String, Integer> mGDif = new HashMap<>();
        ArrayList<Equipo> equipos = new ArrayList<>();
        Equipo eq = null;
        ePrimero = null;
        eSegundo = null;
        for (int i = 0; i < 4; i++) {
            mPtos.put(eEquipos[i].getsNombre(), iPuntos[i]);
            mGFav.put(eEquipos[i].getsNombre(), iGolesFavor[i]);
            mGDif.put(eEquipos[i].getsNombre(), iGolesFavor[i] - iGolesContra[i]);
        }
        mPtos = sortHashMapByValuesD(mPtos);
        for (Entry thisEntry : mPtos.entrySet()) {
            equipos.add(Equipo.BuscarEquipo((String) thisEntry.getKey()));
        }
        Collections.reverse(equipos);
        for (int i = 0; i < equipos.size(); i++) {
            if (i + 1 < equipos.size()) {
                eq = ComparadorTabla(equipos.get(i), equipos.get(i + 1), mPtos, mGDif, mGFav);
                if (eq != null) {
                    if (eq == equipos.get(i)) {
                        ePrimero = eq;
                        equipos.remove(i + 1);
                        i--;
                    } else {
                        ePrimero = eq;
                    }
                } else {
                    break;
                }
            }
        }
        if (ePrimero != null) {
            for (Entry thisEntry : mPtos.entrySet()) {
                equipos.add(Equipo.BuscarEquipo((String) thisEntry.getKey()));
            }
            Collections.reverse(equipos);
            for (int i = 0; i < 4; i++) {
                if (equipos.get(i) == ePrimero) {
                    equipos.remove(i);
                }
            }
            for (int i = 0; i < equipos.size(); i++) {
                if (i + 1 < equipos.size()) {
                    eq = ComparadorTabla(equipos.get(i), equipos.get(i + 1), mPtos, mGDif, mGFav);
                    if (eq != null) {
                        if (eq == equipos.get(i)) {
                            eSegundo = eq;
                            equipos.remove(i + 1);
                            i--;
                        } else {
                            eSegundo = eq;
                        }
                    } else {
                        break;
                    }
                }
            }
        }        
    }

    public void CalcularPuntos() {
        Arrays.fill(iPuntos, 0);
        Arrays.fill(iGolesFavor, 0);
        Arrays.fill(iGolesContra, 0);
        aPartidos.stream().forEach((partido) -> {
            int ptsLocal, ptsVisitante,
                    golLocal = partido.getiGolLocal(),
                    golVisitante = partido.getiGolVisitante();
            if (golLocal > golVisitante) {
                ptsLocal = 3;
                ptsVisitante = 0;
            } else {
                if (golLocal < golVisitante) {
                    ptsLocal = 0;
                    ptsVisitante = 3;
                } else {
                    ptsLocal = 1;
                    ptsVisitante = 1;
                }
            }
            for (int i = 0; i < eEquipos.length; i++) {
                Equipo e = eEquipos[i];
                if (e == partido.geteLocal()) {
                    iGolesFavor[i] += golLocal;
                    iGolesContra[i] += golVisitante;
                    iPuntos[i] += ptsLocal;
                }
                if (e == partido.geteVisitante()) {
                    iGolesFavor[i] += golVisitante;
                    iGolesContra[i] += golLocal;
                    iPuntos[i] += ptsVisitante;
                }
            }
        });
    }

    private LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
        List mapKeys = new ArrayList(passedMap.keySet());
        List mapValues = new ArrayList(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);
        LinkedHashMap sortedMap = new LinkedHashMap();
        Iterator valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Object val = valueIt.next();
            Iterator keyIt = mapKeys.iterator();
            while (keyIt.hasNext()) {
                Object key = keyIt.next();
                String comp1 = passedMap.get(key).toString();
                String comp2 = val.toString();
                if (comp1.equals(comp2)) {
                    passedMap.remove(key);
                    mapKeys.remove(key);
                    sortedMap.put((String) key, (Integer) val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    private Equipo ComparadorTabla(Equipo eA, Equipo eB, HashMap<String, Integer> mPto, HashMap<String, Integer> mDif, HashMap<String, Integer> mFav) {
        String sA = eA.getsNombre(), sB = eB.getsNombre();
        if (mPto.get(sA) > mPto.get(sB)) {
            return eA;
        } else {
            if (Objects.equals(mPto.get(sA), mPto.get(sB))) {
                if (mDif.get(sA) > mDif.get(sB)) {
                    return eA;
                } else {
                    if (Objects.equals(mDif.get(sA), mDif.get(sB))) {
                        if (mFav.get(sA) > mFav.get(sB)) {
                            return eA;
                        } else {
                            if (Objects.equals(mFav.get(sA), mFav.get(sB))) {
                                return null;
                            } else {
                                return eB;
                            }
                        }
                    } else {
                        return eB;
                    }
                }
            } else {
                return eB;
            }
        }
    }

    public ApuestaGrupo(String n) {
        this.sNombre = n;
        for (Grupo grupo : Grupo.getaGrupos()) {
            if (n.equals(grupo.getsNombre())) {
                this.eEquipos = grupo.geteEquipos();
                this.iPuntos = new Integer[]{0, 0, 0, 0};
                this.iGolesFavor = new Integer[]{0, 0, 0, 0};
                this.iGolesContra = new Integer[]{0, 0, 0, 0};
                for (Partido partido : grupo.getaPartidos()) {
                    ApuestaPartido ap = new ApuestaPartido(partido);
                    this.aPartidos.add(ap);
                }
            }
        }
    }
}
