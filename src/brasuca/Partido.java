/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Francisco
 */
public class Partido implements Serializable, Comparable<Partido> {

    private Calendar cFecha;
    private String sEtapa;
    private Equipo eLocal, eVisitante;
    private Integer sId, iGolesLocal, iGolesVisitante;
    private Boolean bJugado;
    static private ArrayList<Partido> aPartidos = new ArrayList<>();

    public Integer getsId() {
        return sId;
    }

    public Calendar getcFecha() {
        return cFecha;
    }

    public String getsEtapa() {
        return sEtapa;
    }

    public Equipo geteLocal() {
        return eLocal;
    }

    public Equipo geteVisitante() {
        return eVisitante;
    }

    public Integer getiGolesLocal() {
        return iGolesLocal;
    }

    public Integer getiGolesVisitante() {
        return iGolesVisitante;
    }

    public Boolean isbJugado() {
        return bJugado;
    }

    public static Calendar calendarFor(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal;
    }

    public static ArrayList<Partido> getaPartidos() {
        return aPartidos;
    }

    public static Partido getPartido(int i) {
        for (Partido p : aPartidos) {
            if (p.sId == i) {
                return p;
            }
        }
        return null;
    }

    public void setcFecha(Calendar cFecha) {
        this.cFecha = cFecha;
    }

    public void setsEtapa(String sEtapa) {
        this.sEtapa = sEtapa;
    }

    public void seteLocal(Equipo eLocal) {
        this.eLocal = eLocal;
    }

    public void seteVisitante(Equipo eVisitante) {
        this.eVisitante = eVisitante;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public void setiGolesLocal(Integer iGolesLocal) {
        this.iGolesLocal = iGolesLocal;
    }

    public void setiGolesVisitante(Integer iGolesVisitante) {
        this.iGolesVisitante = iGolesVisitante;
    }

    public void setbJugado(Boolean bJugado) {
        this.bJugado = bJugado;
    }

    public static void setaPartidos(ArrayList<Partido> aPartidos) {
        Partido.aPartidos = aPartidos;
    }

    public Partido(GregorianCalendar date, String etapa, Equipo local, Equipo visitante, Integer id, int gollocal, int golvisitante, boolean b) {
        this.sId = id;
        this.cFecha = calendarFor(2014, date.get(Calendar.MONTH) + 1, date.get(Calendar.DAY_OF_MONTH));
        this.sEtapa = etapa;
        this.eLocal = local;
        this.eVisitante = visitante;
        this.iGolesLocal = gollocal;
        this.iGolesVisitante = golvisitante;
        this.bJugado = b;
        aPartidos.add(this);
    }

    @Override
    public int compareTo(Partido other) {
        return this.sId.compareTo(other.sId);
    }

    public static String ObtenerInstancia(String s) {
        switch (s) {
            case "Match 1":
            case "Match 2":
            case "Match 17":
            case "Match 18":
            case "Match 33":
            case "Match 34": {
                return "GA";
            }
            case "Match 3":
            case "Match 4":
            case "Match 19":
            case "Match 20":
            case "Match 35":
            case "Match 36": {
                return "GB";
            }
            case "Match 5":
            case "Match 6":
            case "Match 21":
            case "Match 22":
            case "Match 37":
            case "Match 38": {
                return "GC";
            }
            case "Match 7":
            case "Match 8":
            case "Match 23":
            case "Match 24":
            case "Match 39":
            case "Match 40": {
                return "GD";
            }
            case "Match 9":
            case "Match 10":
            case "Match 25":
            case "Match 26":
            case "Match 41":
            case "Match 42": {
                return "GE";
            }
            case "Match 11":
            case "Match 12":
            case "Match 27":
            case "Match 28":
            case "Match 43":
            case "Match 44": {
                return "GF";
            }
            case "Match 13":
            case "Match 14":
            case "Match 29":
            case "Match 30":
            case "Match 45":
            case "Match 46": {
                return "GG";
            }
            case "Match 15":
            case "Match 16":
            case "Match 31":
            case "Match 32":
            case "Match 47":
            case "Match 48": {
                return "GH";
            }
            case "Match 49": {
                return "O1";
            }
            case "Match 50": {
                return "O2";
            }
            case "Match 51": {
                return "O3";
            }
            case "Match 52": {
                return "O4";
            }
            case "Match 53": {
                return "O5";
            }
            case "Match 54": {
                return "O6";
            }
            case "Match 55": {
                return "O7";
            }
            case "Match 56": {
                return "O8";
            }
            case "Match 57": {
                return "C1";
            }
            case "Match 58": {
                return "C2";
            }
            case "Match 59": {
                return "C3";
            }
            case "Match 60": {
                return "C4";
            }
            case "Match 61": {
                return "S1";
            }
            case "Match 62": {
                return "S2";
            }
            case "Match 63": {
                return "F2";
            }
            case "Match 64": {
                return "F1";
            }
        }
        return "";
    }
}
