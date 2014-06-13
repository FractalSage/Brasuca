/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Francisco Farías
 * @version 0.1
 */
public class IOManager {

    private final ArrayList<Apostador> apostadores = new ArrayList<>();
    private Stage stage;

    public ArrayList<Apostador> getApostadores() {
        return apostadores;
    }

    public void LeerApuestas() throws IOException, ClassNotFoundException {
        File dirActual = new File(".");
        File dirTrabajo = new File(dirActual, "apuestas");
        dirTrabajo.mkdir();
        File dir = new File("apuestas/");
        File[] files = dir.listFiles((File dir1, String name) -> name.toLowerCase().endsWith(".bet"));
        for (File file : files) {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("apuestas/" + file.getName()));
            this.apostadores.add((Apostador) obj.readObject());
        }
    }

    public ArrayList<Jugador> LeerJugadores() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("data/Jugadores.jug"));
        return (ArrayList<Jugador>) obj.readObject();
    }

    public Apostador LeerApostador(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("apuestas/" + nombre + ".bet"));
        return (Apostador) obj.readObject();
    }

    public boolean Exists(String s) {
        File dirActual = new File(".");
        File dirTrabajo = new File(dirActual, "data");
        dirTrabajo.mkdir();
        File dir = new File("data/");
        File[] files = dir.listFiles((File dir1, String name) -> name.toLowerCase().endsWith(".jug"));
        for (File file : files) {
            if ((s + ".jug").equals(file.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean BuscarApuesta(String s) {
        File dirActual = new File(".");
        File dirTrabajo = new File(dirActual, "apuestas");
        dirTrabajo.mkdir();
        File dir = new File("apuestas/");
        File[] files = dir.listFiles((File dir1, String name) -> name.toLowerCase().endsWith(".bet"));
        for (File file : files) {
            if ((s + ".bet").equals(file.getName())) {
                return true;
            }
        }
        return false;
    }

    public void EscribirJugadores(Object nombreObjeto) throws IOException {
        try {
            File file = new File("data/Jugadores.jug");
            FileOutputStream fileOut = new FileOutputStream(file);
            try (ObjectOutputStream objetctOut = new ObjectOutputStream(fileOut)) {
                objetctOut.writeObject(nombreObjeto);
                objetctOut.flush();
                objetctOut.close();
            }
            file.renameTo(new File("data/Jugadores.jug"));
        } catch (IOException e) {
            Dialogs.create()
                    .owner(stage)
                    .title("Error de Entrada Salida")
                    .masthead(null)
                    .message("Error al intentar escribir el archivo Jugadores.")
                    .showError();
            System.out.println(e.getMessage());
        }
    }

    public void EscribirApuesta(String nombreArchivo, Object nombreObjeto) throws IOException {
        try {
            File file = new File("apuestas/" + nombreArchivo + ".bet");
            FileOutputStream fileOut = new FileOutputStream(file);
            try (ObjectOutputStream objetctOut = new ObjectOutputStream(fileOut)) {
                objetctOut.writeObject(nombreObjeto);
                objetctOut.flush();
                objetctOut.close();
            }
            Dialogs.create()
                    .owner(stage)
                    .title("Creación de Archivo")
                    .masthead(null)
                    .message("Creacion exitosa")
                    .showInformation();
        } catch (IOException e) {
            Dialogs.create()
                    .owner(stage)
                    .title("Error de Entrada Salida")
                    .masthead(null)
                    .message("Error al intentar escribir el archivo " + nombreArchivo + ".")
                    .showError();
            System.out.println(e.getMessage());
        }
    }

    public void ImprimirApostador(Apostador a) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("resumen.txt"), "utf-8"));
            writer.write("FASE DE GRUPOS");
            writer.newLine();
            for (ApuestaGrupo grupo : a.getaGrupos()) {
                writer.write("Grupo " + grupo.getsNombre() + ": ");
                writer.newLine();
                for (ApuestaPartido partido : grupo.getaPartidos()) {
                    writer.write(partido.geteLocal().getsNombre() + " " + partido.getiGolLocal() + " - " + partido.getiGolVisitante() + " " + partido.geteVisitante().getsNombre());
                    writer.newLine();
                }
                writer.write("Primero: " + grupo.getePrimero().getsNombre());
                writer.newLine();
                writer.write("Segundo: " + grupo.geteSegundo().getsNombre());
                writer.newLine();
            }
            writer.newLine();
            writer.write("OCTAVOS DE FINAL");
            writer.newLine();
            for (ApuestaPartido partido : a.getaOctavos()) {
                writer.write(partido.geteLocal().getsNombre() + " " + partido.getiGolLocal() + " - " + partido.getiGolVisitante() + " " + partido.geteVisitante().getsNombre());
                writer.newLine();
            }
            writer.newLine();
            writer.write("CUARTOS DE FINAL");
            writer.newLine();
            for (ApuestaPartido partido : a.getaCuartos()) {
                writer.write(partido.geteLocal().getsNombre() + " " + partido.getiGolLocal() + " - " + partido.getiGolVisitante() + " " + partido.geteVisitante().getsNombre());
                writer.newLine();
            }
            writer.newLine();
            writer.write("SEMIFINALES");
            writer.newLine();
            for (ApuestaPartido partido : a.getaSemis()) {
                writer.write(partido.geteLocal().getsNombre() + " " + partido.getiGolLocal() + " - " + partido.getiGolVisitante() + " " + partido.geteVisitante().getsNombre());
                writer.newLine();
            }
            writer.newLine();
            writer.write("TERCER PUESTO");
            writer.newLine();
            writer.write(a.getaFinales().get(0).geteLocal().getsNombre() + " " + a.getaFinales().get(0).getiGolLocal() + " - " + a.getaFinales().get(0).getiGolVisitante() + " " + a.getaFinales().get(0).geteVisitante().getsNombre());
            writer.newLine();
            writer.newLine();
            writer.write("FINAL");
            writer.newLine();
            writer.write(a.getaFinales().get(1).geteLocal().getsNombre() + " " + a.getaFinales().get(1).getiGolLocal() + " - " + a.getaFinales().get(1).getiGolVisitante() + " " + a.getaFinales().get(1).geteVisitante().getsNombre());
        } catch (IOException ex) {
            Dialogs.create()
                    .owner(stage)
                    .title("Error de Entrada Salida")
                    .masthead(null)
                    .message("Error al intentar escribir el archivo resumen.txt")
                    .showError();
        } finally {
            try {
                writer.close();
                Dialogs.create()
                        .owner(stage)
                        .title("Creación de Archivo")
                        .masthead(null)
                        .message("Creacion exitosa")
                        .showInformation();
            } catch (IOException ex) {
                Dialogs.create()
                    .owner(stage)
                    .title("Error de Entrada Salida")
                    .masthead(null)
                    .message("Error al intentar escribir el archivo resumen.txt")
                    .showError();
            }
        }
    }
}
