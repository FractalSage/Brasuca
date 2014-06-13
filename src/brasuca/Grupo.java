/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Francisco
 */
public class Grupo implements Serializable {

    static private ArrayList<Grupo> aGrupos = new ArrayList<>();
    private ArrayList<Partido> aPartidos = new ArrayList<>();
    private String sNombre;
    private Equipo[] eEquipos;
    private Integer[] iPuntos, iGolesFavor, iGolesContra;
    private Equipo ePrimero, eSegundo;

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public Equipo[] geteEquipos() {
        return eEquipos;
    }

    public Equipo geteEquipo(int i) {
        return eEquipos[i];
    }

    public void seteEquipo(Equipo eq, int i) {
        this.eEquipos[i] = eq;
    }

    public void seteEquipos(Equipo[] eEquipo) {
        this.eEquipos = eEquipo;
    }

    public Integer[] getiPuntos() {
        return iPuntos;
    }

    public void setiPuntos(Integer[] iPuntos) {
        this.iPuntos = iPuntos;
    }

    public Integer getiPuntos(int i) {
        return this.iPuntos[i];
    }

    public void setiPuntos(Integer p, int i) {
        this.iPuntos[i] += p;
    }

    public Integer[] getiGolesFavor() {
        return iGolesFavor;
    }

    public void setiGolesFavor(Integer[] iGolesFavor) {
        this.iGolesFavor = iGolesFavor;
    }

    public Integer getiGolesFavor(int i) {
        return this.iGolesFavor[i];
    }

    public void setiGolesFavor(Integer p, int i) {
        this.iGolesFavor[i] += p;
    }

    public Integer[] getiGolesContra() {
        return iGolesContra;
    }

    public void setiGolesContra(Integer[] iGolesContra) {
        this.iGolesContra = iGolesContra;
    }

    public Integer getiGolesContra(int i) {
        return this.iGolesContra[i];
    }

    public void setiGolesContra(Integer p, int i) {
        this.iGolesContra[i] += p;
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

    public static ArrayList<Grupo> getaGrupos() {
        return aGrupos;
    }

    public static void setaGrupos(ArrayList<Grupo> aGrupos) {
        Grupo.aGrupos = aGrupos;
    }

    public ArrayList<Partido> getaPartidos() {
        return aPartidos;
    }

    public void setaPartidos(ArrayList<Partido> aPartidos) {
        this.aPartidos = aPartidos;
    }

    public void setPartido(Partido p) {
        this.aPartidos.add(p);
    }

    public static Grupo BuscarGrupo(String s) {
        String n = "";
        switch (s) {
            case "GA": 
            case "A": {
                n = "A";
                break;
            }
            case "GB": 
            case "B": {
                n = "B";
                break;
            }
            case "GC": 
            case "C": {
                n = "C";
                break;
            }
            case "GD": 
            case "D": {
                n = "D";
                break;
            }
            case "GE": 
            case "E": {
                n = "E";
                break;
            }
            case "GF": 
            case "F": {
                n = "F";
                break;
            }
            case "GG": 
            case "G": {
                n = "G";
                break;
            }
            case "GH": 
            case "H": {
                n = "H";
                break;
            }            
        }
        for (Grupo grupo : aGrupos) {
            if (n.equals(grupo.getsNombre())) {
                return grupo;
            }
        }
        return null;
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public Grupo(String nombre) {
        this.sNombre = nombre;
        this.eEquipos = new Equipo[4];
        this.iPuntos = new Integer[]{0, 0, 0, 0};
        this.iGolesFavor = new Integer[]{0, 0, 0, 0};
        this.iGolesContra = new Integer[]{0, 0, 0, 0};
        aGrupos.add(this);
    }
    
    
}
