/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

/**
 *
 * @author Francisco
 */
public class GrupoModel implements Comparable<GrupoModel> {

    private String nombre, puntos, golesfavor, golescontra;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getGolesfavor() {
        return golesfavor;
    }

    public void setGolesfavor(String golesfavor) {
        this.golesfavor = golesfavor;
    }

    public String getGolescontra() {
        return golescontra;
    }

    public void setGolescontra(String golescontra) {
        this.golescontra = golescontra;
    }

    public GrupoModel(String n, String p, String gf, String gc) {
        this.nombre = n;
        this.puntos = p;
        this.golesfavor = gf;
        this.golescontra = gc;
    }

    @Override
    public int compareTo(GrupoModel other) {
        return this.puntos.compareTo(other.puntos);
    }
}
