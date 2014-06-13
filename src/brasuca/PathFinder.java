/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

/**
 *
 * @author Francisco
 */
public class PathFinder {

    public static String PathABandera(String n, String s) {
        switch (n) {
            case "Algeria": {
                return "/img/" + s + "/alg.png";
            }
            case "Argentina": {
                return "/img/" + s + "/arg.png";
            }
            case "Australia": {
                return "/img/" + s + "/aus.png";
            }
            case "Bélgica": {
                return "/img/" + s + "/bel.png";
            }
            case "Bosnia": {
                return "/img/" + s + "/bih.png";
            }
            case "Brasil": {
                return "/img/" + s + "/bra.png";
            }
            case "Chile": {
                return "/img/" + s + "/chi.png";
            }
            case "Costa de Marfil": {
                return "/img/" + s + "/civ.png";
            }
            case "Camerún": {
                return "/img/" + s + "/cmr.png";
            }
            case "Colombia": {
                return "/img/" + s + "/col.png";
            }
            case "Costa Rica": {
                return "/img/" + s + "/crc.png";
            }
            case "Croacia": {
                return "/img/" + s + "/cro.png";
            }
            case "Ecuador": {
                return "/img/" + s + "/ecu.png";
            }
            case "Inglaterra": {
                return "/img/" + s + "/eng.png";
            }
            case "España": {
                return "/img/" + s + "/esp.png";
            }
            case "Francia": {
                return "/img/" + s + "/fra.png";
            }
            case "Alemania": {
                return "/img/" + s + "/ger.png";
            }
            case "Ghana": {
                return "/img/" + s + "/gha.png";
            }
            case "Grecia": {
                return "/img/" + s + "/gre.png";
            }
            case "Honduras": {
                return "/img/" + s + "/hon.png";
            }
            case "Irán": {
                return "/img/" + s + "/irn.png";
            }
            case "Italia": {
                return "/img/" + s + "/ita.png";
            }
            case "Japón": {
                return "/img/" + s + "/jpn.png";
            }
            case "Corea del Sur": {
                return "/img/" + s + "/kor.png";
            }
            case "México": {
                return "/img/" + s + "/mex.png";
            }
            case "Holanda": {
                return "/img/" + s + "/ned.png";
            }
            case "Nigeria": {
                return "/img/" + s + "/nga.png";
            }
            case "Portugal": {
                return "/img/" + s + "/por.png";
            }
            case "Rusia": {
                return "/img/" + s + "/rus.png";
            }
            case "Suiza": {
                return "/img/" + s + "/sui.png";
            }
            case "Uruguay": {
                return "/img/" + s + "/uru.png";
            }
            case "EE.UU.": {
                return "/img/" + s + "/usa.png";
            }
        }
        return "/img/" + s + "/" + n + ".png";
    }

}
