/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Francisco
 */
public class Apostador implements Serializable {

    private final String sUsuario;
    private String Goleador;
    private final Integer iContraseña;
    private final ArrayList<ApuestaPartido> aOctavos = new ArrayList<>(), aCuartos = new ArrayList<>(),
            aSemis = new ArrayList<>(), aFinales = new ArrayList<>();
    private final ArrayList<ApuestaGrupo> aGrupos = new ArrayList<>();
    private Equipo Campeon, Segundo, Tercero;

    public String getsUsuario() {
        return sUsuario;
    }

    public String getGoleador() {
        return Goleador;
    }

    public void setGoleador(String Goleador) {
        this.Goleador = Goleador;
    }

    public ArrayList<ApuestaPartido> getaOctavos() {
        return aOctavos;
    }

    public ArrayList<ApuestaPartido> getaCuartos() {
        return aCuartos;
    }

    public ArrayList<ApuestaPartido> getaSemis() {
        return aSemis;
    }

    public ArrayList<ApuestaPartido> getaFinales() {
        return aFinales;
    }

    public ArrayList<ApuestaGrupo> getaGrupos() {
        return aGrupos;
    }

    public Equipo getCampeon() {
        return Campeon;
    }

    public Equipo getSegundo() {
        return Segundo;
    }

    public Equipo getTercero() {
        return Tercero;
    }

    public Apostador(String u, String p) {
        this.sUsuario = u;
        this.iContraseña = p.hashCode();
        ApuestaGrupo ag = new ApuestaGrupo("A");
        this.aGrupos.add(ag);
        ag = new ApuestaGrupo("B");
        this.aGrupos.add(ag);
        ag = new ApuestaGrupo("C");
        this.aGrupos.add(ag);
        ag = new ApuestaGrupo("D");
        this.aGrupos.add(ag);
        ag = new ApuestaGrupo("E");
        this.aGrupos.add(ag);
        ag = new ApuestaGrupo("F");
        this.aGrupos.add(ag);
        ag = new ApuestaGrupo("G");
        this.aGrupos.add(ag);
        ag = new ApuestaGrupo("H");
        this.aGrupos.add(ag);
    }

    public void CrearOctavos() {
        while (!aOctavos.isEmpty()) {
            aOctavos.remove(0);
        }
        ApuestaPartido ap;
        ap = new ApuestaPartido();
        ap.seteLocal(aGrupos.get(0).getePrimero());
        ap.seteVisitante(aGrupos.get(1).geteSegundo());
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(49);
        ap.setsEtapa("O1");
        aOctavos.add(ap);
        ap = new ApuestaPartido();
        ap.seteLocal(aGrupos.get(2).getePrimero());
        ap.seteVisitante(aGrupos.get(3).geteSegundo());
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(50);
        ap.setsEtapa("O2");
        aOctavos.add(ap);
        ap = new ApuestaPartido();
        ap.seteLocal(aGrupos.get(1).getePrimero());
        ap.seteVisitante(aGrupos.get(0).geteSegundo());
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(51);
        ap.setsEtapa("O3");
        aOctavos.add(ap);
        ap = new ApuestaPartido();
        ap.seteLocal(aGrupos.get(3).getePrimero());
        ap.seteVisitante(aGrupos.get(2).geteSegundo());
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(52);
        ap.setsEtapa("O4");
        aOctavos.add(ap);
        ap = new ApuestaPartido();
        ap.seteLocal(aGrupos.get(4).getePrimero());
        ap.seteVisitante(aGrupos.get(5).geteSegundo());
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(53);
        ap.setsEtapa("O5");
        aOctavos.add(ap);
        ap = new ApuestaPartido();
        ap.seteLocal(aGrupos.get(6).getePrimero());
        ap.seteVisitante(aGrupos.get(7).geteSegundo());
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(54);
        ap.setsEtapa("O6");
        aOctavos.add(ap);
        ap = new ApuestaPartido();
        ap.seteLocal(aGrupos.get(5).getePrimero());
        ap.seteVisitante(aGrupos.get(4).geteSegundo());
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(55);
        ap.setsEtapa("O7");
        aOctavos.add(ap);
        ap = new ApuestaPartido();
        ap.seteLocal(aGrupos.get(7).getePrimero());
        ap.seteVisitante(aGrupos.get(6).geteSegundo());
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(56);
        ap.setsEtapa("O8");
        aOctavos.add(ap);
    }

    public void CrearCuartos() {
        while (!aCuartos.isEmpty()) {
            aCuartos.remove(0);
        }
        ApuestaPartido ap;
        int local, visitante;
        ap = new ApuestaPartido();
        local = aOctavos.get(0).getiGolLocal();
        visitante = aOctavos.get(0).getiGolVisitante();
        if (local > visitante) {
            ap.seteLocal(aOctavos.get(0).geteLocal());
        } else {
            ap.seteLocal(aOctavos.get(0).geteVisitante());
        }
        local = aOctavos.get(1).getiGolLocal();
        visitante = aOctavos.get(1).getiGolVisitante();
        if (local > visitante) {
            ap.seteVisitante(aOctavos.get(1).geteLocal());
        } else {
            ap.seteVisitante(aOctavos.get(1).geteVisitante());
        }
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(57);
        ap.setsEtapa("C1");
        aCuartos.add(ap);
        ap = new ApuestaPartido();
        local = aOctavos.get(4).getiGolLocal();
        visitante = aOctavos.get(4).getiGolVisitante();
        if (local > visitante) {
            ap.seteLocal(aOctavos.get(4).geteLocal());
        } else {
            ap.seteLocal(aOctavos.get(4).geteVisitante());
        }
        local = aOctavos.get(5).getiGolLocal();
        visitante = aOctavos.get(5).getiGolVisitante();
        if (local > visitante) {
            ap.seteVisitante(aOctavos.get(5).geteLocal());
        } else {
            ap.seteVisitante(aOctavos.get(5).geteVisitante());
        }
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(58);
        ap.setsEtapa("C2");
        aCuartos.add(ap);
        ap = new ApuestaPartido();
        local = aOctavos.get(2).getiGolLocal();
        visitante = aOctavos.get(2).getiGolVisitante();
        if (local > visitante) {
            ap.seteLocal(aOctavos.get(2).geteLocal());
        } else {
            ap.seteLocal(aOctavos.get(2).geteVisitante());
        }
        local = aOctavos.get(3).getiGolLocal();
        visitante = aOctavos.get(3).getiGolVisitante();
        if (local > visitante) {
            ap.seteVisitante(aOctavos.get(3).geteLocal());
        } else {
            ap.seteVisitante(aOctavos.get(3).geteVisitante());
        }
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(59);
        ap.setsEtapa("C3");
        aCuartos.add(ap);
        ap = new ApuestaPartido();
        local = aOctavos.get(6).getiGolLocal();
        visitante = aOctavos.get(6).getiGolVisitante();
        if (local > visitante) {
            ap.seteLocal(aOctavos.get(6).geteLocal());
        } else {
            ap.seteLocal(aOctavos.get(6).geteVisitante());
        }
        local = aOctavos.get(7).getiGolLocal();
        visitante = aOctavos.get(7).getiGolVisitante();
        if (local > visitante) {
            ap.seteVisitante(aOctavos.get(7).geteLocal());
        } else {
            ap.seteVisitante(aOctavos.get(7).geteVisitante());
        }
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(60);
        ap.setsEtapa("C4");
        aCuartos.add(ap);
    }

    public void CrearSemis() {
        while (!aSemis.isEmpty()) {
            aSemis.remove(0);
        }
        ApuestaPartido ap;
        int local, visitante;
        ap = new ApuestaPartido();
        local = aCuartos.get(0).getiGolLocal();
        visitante = aCuartos.get(0).getiGolVisitante();
        if (local > visitante) {
            ap.seteLocal(aCuartos.get(0).geteLocal());
        } else {
            ap.seteLocal(aCuartos.get(0).geteVisitante());
        }
        local = aCuartos.get(1).getiGolLocal();
        visitante = aCuartos.get(1).getiGolVisitante();
        if (local > visitante) {
            ap.seteVisitante(aCuartos.get(1).geteLocal());
        } else {
            ap.seteVisitante(aCuartos.get(1).geteVisitante());
        }
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(61);
        ap.setsEtapa("S1");
        aSemis.add(ap);
        ap = new ApuestaPartido();
        local = aCuartos.get(2).getiGolLocal();
        visitante = aCuartos.get(2).getiGolVisitante();
        if (local > visitante) {
            ap.seteLocal(aCuartos.get(2).geteLocal());
        } else {
            ap.seteLocal(aCuartos.get(2).geteVisitante());
        }
        local = aCuartos.get(3).getiGolLocal();
        visitante = aCuartos.get(3).getiGolVisitante();
        if (local > visitante) {
            ap.seteVisitante(aCuartos.get(3).geteLocal());
        } else {
            ap.seteVisitante(aCuartos.get(3).geteVisitante());
        }
        ap.setiGolLocal(0);
        ap.setiGolVisitante(0);
        ap.setsId(62);
        ap.setsEtapa("S2");
        aSemis.add(ap);
    }

    public void CrearFinal() {
        while (!aFinales.isEmpty()) {
            aFinales.remove(0);
        }
        ApuestaPartido apf = new ApuestaPartido(),
                apt = new ApuestaPartido();
        int local, visitante;
        local = aSemis.get(0).getiGolLocal();
        visitante = aSemis.get(0).getiGolVisitante();
        if (local > visitante) {
            apf.seteLocal(aSemis.get(0).geteLocal());
            apt.seteLocal(aSemis.get(0).geteVisitante());
        } else {
            apf.seteLocal(aSemis.get(0).geteVisitante());
            apt.seteLocal(aSemis.get(0).geteLocal());
        }
        local = aSemis.get(1).getiGolLocal();
        visitante = aSemis.get(1).getiGolVisitante();
        if (local > visitante) {
            apf.seteVisitante(aSemis.get(1).geteLocal());
            apt.seteVisitante(aSemis.get(1).geteVisitante());
        } else {
            apf.seteVisitante(aSemis.get(1).geteVisitante());
            apt.seteVisitante(aSemis.get(1).geteLocal());
        }
        apt.setiGolLocal(0);
        apt.setiGolVisitante(0);
        apt.setsId(63);
        apt.setsEtapa("F1");
        apf.setiGolLocal(0);
        apf.setiGolVisitante(0);
        apf.setsId(64);
        apf.setsEtapa("F2");
        aFinales.add(apt);
        aFinales.add(apf);
    }

    public void CrearPodio() {
        int local, visitante;
        local = aFinales.get(0).getiGolLocal();
        visitante = aFinales.get(0).getiGolVisitante();
        if (local > visitante) {
            Tercero = aFinales.get(0).geteLocal();
        } else {
            Tercero = aFinales.get(0).geteVisitante();
        }
        local = aFinales.get(1).getiGolLocal();
        visitante = aFinales.get(1).getiGolVisitante();
        if (local > visitante) {
            Campeon = aFinales.get(1).geteLocal();
            Segundo = aFinales.get(1).geteVisitante();
        } else {
            Campeon = aFinales.get(1).geteVisitante();
            Segundo = aFinales.get(1).geteLocal();
        }
    }

    public Boolean ValidarContraseña(String pass) {
        return pass.hashCode() == iContraseña;
    }    
}
