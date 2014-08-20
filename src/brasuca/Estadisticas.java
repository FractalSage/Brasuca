/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Francisco
 */
public class Estadisticas {

    private String[] sGrupoA = new String[4], sGrupoB = new String[4], sGrupoC = new String[4], sGrupoD = new String[4],
            sGrupoE = new String[4], sGrupoF = new String[4], sGrupoG = new String[4], sGrupoH = new String[4];
    private HashMap<String, Integer> mGoleador = new HashMap<>();
    private HashMap<String, Integer> mCampeon = new HashMap<>();
    private HashMap<String, Integer> mSegundo = new HashMap<>();
    private HashMap<String, Integer> mTercero = new HashMap<>();

    public String[] getsGrupoA() {
        return sGrupoA;
    }

    public String[] getsGrupoB() {
        return sGrupoB;
    }

    public String[] getsGrupoC() {
        return sGrupoC;
    }

    public String[] getsGrupoD() {
        return sGrupoD;
    }

    public String[] getsGrupoE() {
        return sGrupoE;
    }

    public String[] getsGrupoF() {
        return sGrupoF;
    }

    public String[] getsGrupoG() {
        return sGrupoG;
    }

    public String[] getsGrupoH() {
        return sGrupoH;
    }

    public HashMap<String, Integer> getmGoleador() {
        return mGoleador;
    }

    public HashMap<String, Integer> getmCampeon() {
        return mCampeon;
    }

    public HashMap<String, Integer> getmSegundo() {
        return mSegundo;
    }

    public HashMap<String, Integer> getmTercero() {
        return mTercero;
    }

    public Estadisticas(ArrayList<Apostador> bets) throws IOException, ClassNotFoundException {
        int[] grupoA = new int[4], grupoB = new int[4], grupoC = new int[4], grupoD = new int[4],
                grupoE = new int[4], grupoF = new int[4], grupoG = new int[4], grupoH = new int[4];
        ArrayList<String> aGoleador = new ArrayList<>();
        ArrayList<String> aCampeon = new ArrayList<>();
        ArrayList<String> aSegundo = new ArrayList<>();
        ArrayList<String> aTercero = new ArrayList<>();
        int total = bets.size();
        Arrays.fill(grupoA, 0);
        Arrays.fill(grupoB, 0);
        Arrays.fill(grupoC, 0);
        Arrays.fill(grupoD, 0);
        Arrays.fill(grupoE, 0);
        Arrays.fill(grupoF, 0);
        Arrays.fill(grupoG, 0);
        Arrays.fill(grupoH, 0);
        for (Apostador bet : bets) {
            for (ApuestaGrupo group : bet.getaGrupos()) {
                switch (group.getsNombre()) {
                    case "A": {
                        for (int i = 0; i < group.geteEquipos().length; i++) {
                            if ((group.geteEquipos()[i] == group.getePrimero())
                                    || (group.geteEquipos()[i] == group.geteSegundo())) {
                                grupoA[i]++;
                            }
                        }
                        break;
                    }
                    case "B": {
                        for (int i = 0; i < group.geteEquipos().length; i++) {
                            if ((group.geteEquipos()[i] == group.getePrimero())
                                    || (group.geteEquipos()[i] == group.geteSegundo())) {
                                grupoB[i]++;
                            }
                        }
                        break;
                    }
                    case "C": {
                        for (int i = 0; i < group.geteEquipos().length; i++) {
                            if ((group.geteEquipos()[i] == group.getePrimero())
                                    || (group.geteEquipos()[i] == group.geteSegundo())) {
                                grupoC[i]++;
                            }
                        }
                        break;
                    }
                    case "D": {
                        for (int i = 0; i < group.geteEquipos().length; i++) {
                            if ((group.geteEquipos()[i] == group.getePrimero())
                                    || (group.geteEquipos()[i] == group.geteSegundo())) {
                                grupoD[i]++;
                            }
                        }
                        break;
                    }
                    case "E": {
                        for (int i = 0; i < group.geteEquipos().length; i++) {
                            if ((group.geteEquipos()[i] == group.getePrimero())
                                    || (group.geteEquipos()[i] == group.geteSegundo())) {
                                grupoE[i]++;
                            }
                        }
                        break;
                    }
                    case "F": {
                        for (int i = 0; i < group.geteEquipos().length; i++) {
                            if ((group.geteEquipos()[i] == group.getePrimero())
                                    || (group.geteEquipos()[i] == group.geteSegundo())) {
                                grupoF[i]++;
                            }
                        }
                        break;
                    }
                    case "G": {
                        for (int i = 0; i < group.geteEquipos().length; i++) {
                            if ((group.geteEquipos()[i] == group.getePrimero())
                                    || (group.geteEquipos()[i] == group.geteSegundo())) {
                                grupoG[i]++;
                            }
                        }
                        break;
                    }
                    case "H": {
                        for (int i = 0; i < group.geteEquipos().length; i++) {
                            if ((group.geteEquipos()[i] == group.getePrimero())
                                    || (group.geteEquipos()[i] == group.geteSegundo())) {
                                grupoH[i]++;
                            }
                        }
                        break;
                    }
                }
            }
            aGoleador.add(bet.getGoleador());
            aCampeon.add(Equipo.QuitarTilde(bet.getCampeon().getsNombre()));
            aSegundo.add(Equipo.QuitarTilde(bet.getSegundo().getsNombre()));
            aTercero.add(Equipo.QuitarTilde(bet.getTercero().getsNombre()));
        }
        for (int i = 0; i < 4; i++) {
            sGrupoA[i] = String.valueOf(grupoA[i] * 100 / total) + "%";
            sGrupoB[i] = String.valueOf(grupoB[i] * 100 / total) + "%";
            sGrupoC[i] = String.valueOf(grupoC[i] * 100 / total) + "%";
            sGrupoD[i] = String.valueOf(grupoD[i] * 100 / total) + "%";
            sGrupoE[i] = String.valueOf(grupoE[i] * 100 / total) + "%";
            sGrupoF[i] = String.valueOf(grupoF[i] * 100 / total) + "%";
            sGrupoG[i] = String.valueOf(grupoG[i] * 100 / total) + "%";
            sGrupoH[i] = String.valueOf(grupoH[i] * 100 / total) + "%";
        }
        aGoleador.stream().forEach((s) -> {
            if (mGoleador.containsKey(s)) {
                mGoleador.put(s, mGoleador.get(s) + 1);
            } else {
                mGoleador.put(s, 1);
            }
        });
        aCampeon.stream().forEach((s) -> {
            if (mCampeon.containsKey(s)) {
                mCampeon.put(s, mCampeon.get(s) + 1);
            } else {
                mCampeon.put(s, 1);
            }
        });
        aSegundo.stream().forEach((s) -> {
            if (mSegundo.containsKey(s)) {
                mSegundo.put(s, mSegundo.get(s) + 1);
            } else {
                mSegundo.put(s, 1);
            }
        });
        aTercero.stream().forEach((s) -> {
            if (mTercero.containsKey(s)) {
                mTercero.put(s, mTercero.get(s) + 1);
            } else {
                mTercero.put(s, 1);
            }
        });
        mCampeon = sortHashMapByValuesD(mCampeon);
        mSegundo = sortHashMapByValuesD(mSegundo);
        mTercero = sortHashMapByValuesD(mTercero);
        mGoleador = sortHashMapByValuesD(mGoleador);
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

    @Override
    public String toString() {
        String out = "";
        out += "Grupo A: \n";
        for (int i = 0; i < 4; i++) {
            out += Grupo.BuscarGrupo("A").geteEquipo(i).getsNombre() + " " + sGrupoA[i] + " \n";
        }
        out += "Grupo B: \n";
        for (int i = 0; i < 4; i++) {
            out += Grupo.BuscarGrupo("B").geteEquipo(i).getsNombre() + " " + sGrupoB[i] + " \n";
        }
        out += "Grupo C: \n";
        for (int i = 0; i < 4; i++) {
            out += Grupo.BuscarGrupo("C").geteEquipo(i).getsNombre() + " " + sGrupoC[i] + " \n";
        }
        out += "Grupo D: \n";
        for (int i = 0; i < 4; i++) {
            out += Grupo.BuscarGrupo("D").geteEquipo(i).getsNombre() + " " + sGrupoD[i] + " \n";
        }
        out += "Grupo E: \n";
        for (int i = 0; i < 4; i++) {
            out += Grupo.BuscarGrupo("E").geteEquipo(i).getsNombre() + " " + sGrupoE[i] + " \n";
        }
        out += "Grupo F: \n";
        for (int i = 0; i < 4; i++) {
            out += Grupo.BuscarGrupo("F").geteEquipo(i).getsNombre() + " " + sGrupoF[i] + " \n";
        }
        out += "Grupo G: \n";
        for (int i = 0; i < 4; i++) {
            out += Grupo.BuscarGrupo("G").geteEquipo(i).getsNombre() + " " + sGrupoG[i] + " \n";
        }
        out += "Grupo H: \n";
        for (int i = 0; i < 4; i++) {
            out += Grupo.BuscarGrupo("H").geteEquipo(i).getsNombre() + " " + sGrupoH[i] + " \n";
        }
        out += mGoleador + "\n";
        out += mCampeon + "\n";
        out += mSegundo + "\n";
        out += mTercero + "\n";
        return out;
    }
}
