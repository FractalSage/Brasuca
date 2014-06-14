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

    private final String nombre, puntos, golesfavor, golescontra;
    private final Integer diferencia;

    public String getNombre() {
        return nombre;
    }   

    public String getPuntos() {
        return puntos;
    }   

    public String getGolesfavor() {
        return golesfavor;
    }    

    public String getGolescontra() {
        return golescontra;
    }    

    public GrupoModel(String n, String p, String gf, String gc) {
        this.nombre = n;
        this.puntos = p;
        this.golesfavor = gf;
        this.golescontra = gc;
        this.diferencia = Integer.valueOf(gf) - Integer.valueOf(gc);        
    }

    @Override
    public int compareTo(GrupoModel other) {
        int value1 = this.puntos.compareTo(other.puntos);
        if (value1 == 0) {
            int value2 = this.diferencia.compareTo(other.diferencia);
            if (value2 == 0) {
                int value3 = this.golesfavor.compareTo(other.golesfavor);
                if (value3 == 0) {
                    int value4 = this.golescontra.compareTo(other.golescontra);
                    return -value4;
                } else {
                    return value3;
                }
            }
            return value2;
        }
        return value1;
    }
}
