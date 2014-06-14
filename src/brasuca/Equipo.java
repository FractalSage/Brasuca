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
public class Equipo implements Serializable {

    private String sNombre;
    static private ArrayList<Equipo> aEquipo = new ArrayList<>();

    public String getsNombre() {
        return sNombre;
    }

    public static ArrayList<Equipo> getaEquipo() {
        return aEquipo;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public static void setaEquipo(ArrayList<Equipo> aEquipo) {
        Equipo.aEquipo = aEquipo;
    }

    public static Equipo BuscarEquipo(String nombre) {
        Equipo e = null;
        for (Equipo aEquipo1 : aEquipo) {
            e = aEquipo1;
            if (nombre.equals(e.sNombre)) {
                return e;
            }
        }
        return e;
    }

    public static String CorregirNombre(String n) {
        switch (n) {
            case "Brazil": {
                return "Brasil";
            }
            case "Croatia": {
                return "Croacia";
            }
            case "Cameroon": {
                return "Camerún";
            }
            case "Spain": {
                return "España";
            }
            case "Netherlands": {
                return "Holanda";
            }
            case "Columbia": {
                return "Colombia";
            }
            case "Greece": {
                return "Grecia";
            }
            case "Ivory Coast": {
                return "Costa de Marfil";
            }
            case "Japan": {
                return "Japón";
            }
            case "England": {
                return "Inglaterra";
            }
            case "South Korea": {
                return "Corea del Sur";
            }
            case "Russia": {
                return "Rusia";
            }
            case "Belgium": {
                return "Bélgica";
            }
            case "United States": {
                return "EE.UU.";
            }
            case "Germany": {
                return "Alemania";
            }
            case "Iran": {
                return "Irán";
            }
            case "Bosnia & Herzegovina": {
                return "Bosnia";
            }
            case "France": {
                return "Francia";
            }
            case "Switzerland": {
                return "Suiza";
            }
            case "Italy": {
                return "Italia";
            }
            case "Mexico": {
                return "México";
            }
            case "1A": {
                return "1A";
            }
            case "2B": {
                return "2B";
            }
            case "1C": {
                return "1C";
            }
            case "2D": {
                return "2D";
            }
            case "1B": {
                return "1B";
            }
            case "2A": {
                return "2A";
            }
            case "1D": {
                return "1D";
            }
            case "2C": {
                return "2C";
            }
            case "1E": {
                return "1E";
            }
            case "2F": {
                return "2F";
            }
            case "1G": {
                return "1G";
            }
            case "2H": {
                return "2H";
            }
            case "1F": {
                return "1F";
            }
            case "2E": {
                return "2E";
            }
            case "1H": {
                return "1H";
            }
            case "2G": {
                return "2G";
            }
            case "W53": {
                return "O5";
            }
            case "W54": {
                return "O6";
            }
            case "W49": {
                return "O1";
            }
            case "W50": {
                return "O2";
            }
            case "W55": {
                return "O7";
            }
            case "W56": {
                return "O8";
            }
            case "W51": {
                return "O3";
            }
            case "W52": {
                return "O4";
            }
            case "W57": {
                return "C1";
            }
            case "W58": {
                return "C2";
            }
            case "W59": {
                return "C3";
            }
            case "W60": {
                return "C4";
            }
            case "L61": {
                return "PS1";
            }
            case "W61": {
                return "GS1";
            }
            case "L62": {
                return "PS2";
            }
            case "W62": {
                return "GS2";
            }
        }
        return n;
    }

    public static String QuitarTilde(String n) {
        switch (n) {
            case "Holanda": {
                return "H  olanda";
            }
            case "Honduras": {
                return "H  onduras";
            }
            case "Chile": {
                return "Ch ile";
            }
            case "Ghana": {
                return "Gh ana";
            }
            case "España": {
                return "Espana";
            }
        }
        return n;
    }

    public Equipo(String nombre) {
        this.sNombre = nombre;
        aEquipo.add(this);
    }
}
