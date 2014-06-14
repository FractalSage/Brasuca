/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Francisco
 */
public class Jugador implements Serializable {

    private String sNombre;
    private List<String> Defensores, Mediocampistas, Delanteros;

    public String getsNombre() {
        return sNombre;
    }

    public List<String> getDefensores() {
        return Defensores;
    }

    public List<String> getMediocampistas() {
        return Mediocampistas;
    }

    public List<String> getDelanteros() {
        return Delanteros;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public void setDefensores(List<String> Defensores) {
        this.Defensores = Defensores;
    }

    public void setMediocampistas(List<String> Mediocampistas) {
        this.Mediocampistas = Mediocampistas;
    }

    public void setDelanteros(List<String> Delanteros) {
        this.Delanteros = Delanteros;
    }
    
    

    public Jugador(List<String> def, List<String> mid, List<String> fwd, String name) {
        this.sNombre = name;
        this.Defensores = def;
        this.Mediocampistas = mid;
        this.Delanteros = fwd;
    }
}
