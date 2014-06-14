/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import eu.dataaccess.footballpool.ArrayOftGameInfo;
import eu.dataaccess.footballpool.ArrayOftGroupsCompetitors;
import eu.dataaccess.footballpool.ArrayOftTopGoalScorer;
import eu.dataaccess.footballpool.TFullTeamInfo;
import eu.dataaccess.footballpool.TGameInfo;
import eu.dataaccess.footballpool.TGroupsCompetitors;
import eu.dataaccess.footballpool.TTeamInfo;
import eu.dataaccess.footballpool.TTopGoalScorer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Francisco
 */
public class ServiceManager {

    private static ArrayList<String> sGoleador = new ArrayList<>();

    public static ArrayList<String> getsGoleador() {
        return sGoleador;
    }    

    public static void CargarGrupos(boolean b) throws IOException {
        List<TGroupsCompetitors> Groups = allGroupCompetitors().getTGroupsCompetitors();
        double d = 0.0, inc = 0.03125;
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador;
        for (TGroupsCompetitors grupo : Groups) {
            Grupo gr = new Grupo(grupo.getGroupInfo().getSCode());
            int i = 0;
            Equipo[] eqs = new Equipo[4];
            for (TTeamInfo equipo : grupo.getTeamsInGroup().getTTeamInfo()) {
                Equipo eq = new Equipo(Equipo.CorregirNombre(equipo.getSName()));
                if (!b) {
                    List<String> Defensores = fullTeamInfo(equipo.getSName()).getSDefenders().getString();
                    List<String> Mediocampitas = fullTeamInfo(equipo.getSName()).getSMidFields().getString();
                    List<String> Delanteros = fullTeamInfo(equipo.getSName()).getSForwards().getString();
                    jugador = new Jugador(Defensores, Mediocampitas, Delanteros, eq.getsNombre());
                    jugadores.add(jugador);
                }
                eqs[i] = eq;
                i++;
                d = d + inc;
                Brasuca.setDProgreso(d);
            }
            gr.seteEquipos(eqs);
        }
        if (!b) {
            IOManager io = new IOManager();
            io.EscribirJugadores(jugadores);
        }
    }

    public static void CargarPartidos() {
        for (TGameInfo partido : allGames().getTGameInfo()) {
            GregorianCalendar gc = partido.getDPlayDate().toGregorianCalendar();
            String s = Partido.ObtenerInstancia(partido.getSDescription());
            int id = partido.getIId();
            Equipo l = Equipo.BuscarEquipo(Equipo.CorregirNombre(partido.getTeam1().getSName()));
            Equipo v = Equipo.BuscarEquipo(Equipo.CorregirNombre(partido.getTeam2().getSName()));
            boolean b = !"U".equals(partido.getSResult());
            String string = partido.getSScore();
            String[] parts = string.split("-");
            String gollocal = parts[0];
            String golvisitante = parts[1];
            int gl = Integer.valueOf(gollocal);
            int gv = Integer.valueOf(golvisitante);
            Partido p = new Partido(gc, s, l, v, id, gl, gv, b);
            Grupo g = Grupo.BuscarGrupo(p.getsEtapa());
            if (g != null) {
                g.setPartido(p);
            }
        }
        Brasuca.setDProgreso(1);
    }

    public static void ActualizarPuntos() {
        Partido.getaPartidos().stream().filter((partido) -> (partido.isbJugado())).forEach((partido) -> {
            String fase = partido.getsEtapa();
            Grupo g = Grupo.BuscarGrupo(fase);
            if (g != null) {
                int ptsLocal, ptsVisitante,
                        golLocal = partido.getiGolesLocal(),
                        golVisitante = partido.getiGolesVisitante();
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
                for (int i = 0; i < g.geteEquipos().length; i++) {
                    Equipo e = g.geteEquipo(i);
                    if (e == partido.geteLocal()) {
                        g.setiGolesFavor(golLocal, i);
                        g.setiGolesContra(golVisitante, i);
                        g.setiPuntos(ptsLocal, i);
                    }
                    if (e == partido.geteVisitante()) {
                        g.setiGolesFavor(golVisitante, i);
                        g.setiGolesContra(golLocal, i);
                        g.setiPuntos(ptsVisitante, i);
                    }
                }
            }
        });
        Grupo.getaGrupos().stream().forEach((grupo) -> {
            Boolean b = true;
            for (Partido partido : grupo.getaPartidos()) {
                if (!partido.isbJugado()) {
                    b = false;
                }
            }
            if (b) {
                HashMap<String, Integer> mPtos = new HashMap<>();
                HashMap<String, Integer> mGFav = new HashMap<>();
                HashMap<String, Integer> mGDif = new HashMap<>();
                ArrayList<Equipo> equipos = new ArrayList<>();
                Equipo eq;
                grupo.setePrimero(null);
                grupo.seteSegundo(null);
                for (int i = 0; i < 4; i++) {
                    mPtos.put(grupo.geteEquipo(i).getsNombre(), grupo.getiPuntos(i));
                    mGFav.put(grupo.geteEquipo(i).getsNombre(), grupo.getiGolesFavor(i));
                    mGDif.put(grupo.geteEquipo(i).getsNombre(), grupo.getiGolesFavor(i) - grupo.getiGolesContra(i));
                }
                mPtos = sortHashMapByValuesD(mPtos);
                for (Map.Entry thisEntry : mPtos.entrySet()) {
                    equipos.add(Equipo.BuscarEquipo((String) thisEntry.getKey()));
                }
                Collections.reverse(equipos);
                for (int i = 0; i < equipos.size(); i++) {
                    if (i + 1 < equipos.size()) {
                        eq = ComparadorTabla(equipos.get(i), equipos.get(i + 1), mPtos, mGDif, mGFav);
                        if (eq != null) {
                            if (eq == equipos.get(i)) {
                                grupo.setePrimero(eq);
                                equipos.remove(i + 1);
                                i--;
                            } else {
                                grupo.setePrimero(eq);
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (grupo.getePrimero() != null) {
                    for (Map.Entry thisEntry : mPtos.entrySet()) {
                        equipos.add(Equipo.BuscarEquipo((String) thisEntry.getKey()));
                    }
                    Collections.reverse(equipos);
                    for (int i = 0; i < 4; i++) {
                        if (equipos.get(i) == grupo.getePrimero()) {
                            equipos.remove(i);
                        }
                    }
                    for (int i = 0; i < equipos.size(); i++) {
                        if (i + 1 < equipos.size()) {
                            eq = ComparadorTabla(equipos.get(i), equipos.get(i + 1), mPtos, mGDif, mGFav);
                            if (eq != null) {
                                if (eq == equipos.get(i)) {
                                    grupo.seteSegundo(eq);
                                    equipos.remove(i + 1);
                                    i--;
                                } else {
                                    grupo.seteSegundo(eq);
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        });
    }

    public static void CargarGoleador() {
        int x = 0;
        for(TTopGoalScorer goleador : topGoalScorers(0).getTTopGoalScorer()){
            if(goleador.getIGoals() > x){
                x = goleador.getIGoals();
                sGoleador = new ArrayList<>();
                sGoleador.add(goleador.getSName());
            }else{
                if(goleador.getIGoals() == x){
                    sGoleador.add(goleador.getSName());
                }else{
                    break;
                }
            }
        }
    }

    private static ArrayOftGroupsCompetitors allGroupCompetitors() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap12();
        return port.allGroupCompetitors();
    }

    private static ArrayOftGameInfo allGames() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap12();
        return port.allGames();
    }

    private static TFullTeamInfo fullTeamInfo(java.lang.String sTeamName) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap12();
        return port.fullTeamInfo(sTeamName);
    }

    private static ArrayOftTopGoalScorer topGoalScorers(int iTopN) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap12();
        return port.topGoalScorers(iTopN);
    }

    public static LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
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

    private static Equipo ComparadorTabla(Equipo eA, Equipo eB, HashMap<String, Integer> mPto, HashMap<String, Integer> mDif, HashMap<String, Integer> mFav) {
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
}
