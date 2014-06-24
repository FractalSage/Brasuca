/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import brasuca.Apostador;
import brasuca.ApostadorModel;
import brasuca.ApuestaPartido;
import brasuca.Brasuca;
import brasuca.Equipo;
import brasuca.Estadisticas;
import brasuca.Grupo;
import brasuca.GrupoModel;
import brasuca.IOManager;
import brasuca.Jugador;
import brasuca.Partido;
import brasuca.PathFinder;
import brasuca.ServiceManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Francisco
 */
public class MainController implements Initializable {

    private static final Font brasil = Font.loadFont(Brasuca.class.getResource("/font/Brasil 2014.ttf").toExternalForm(), 20);
    private static Apostador apostador;
    private static int indice;
    private static boolean b;
    private static GrupoModel grupoModel;
    private static Equipo A1 = null, A2 = null, B1 = null, B2 = null,
            C1 = null, C2 = null, D1 = null, D2 = null,
            E1 = null, E2 = null, F1 = null, F2 = null,
            G1 = null, G2 = null, H1 = null, H2 = null,
            Oct1 = null, Oct2 = null, Oct3 = null, Oct4 = null,
            Oct5 = null, Oct6 = null, Oct7 = null, Oct8 = null,
            Cto1 = null, Cto2 = null, Cto3 = null, Cto4 = null,
            WSemi1 = null, WSemi2 = null, LSemi1 = null, LSemi2 = null;
    private Stage stage;
    @FXML
    public Button botonIngresar, botonGuardarGrupo, botonGuardarLlaves, botonResumen, botonSalir,
            botonGuardarGoleador, botonOctavos, botonCuartos, botonSemifinales,
            botonFinal, botonReiniciar, botonEditar, botonNuevaApuesta, botonActualizar;
    public ChoiceBox ListaPais, ListaJugador;
    public Label labelFecha1, labelFecha2, labelFecha3, labelFecha4, labelFecha5, labelFecha6,
            labelLocal1, labelLocal2, labelLocal3, labelLocal4, labelLocal5, labelLocal6,
            labelVisitante1, labelVisitante2, labelVisitante3, labelVisitante4, labelVisitante5, labelVisitante6,
            labelOctLocal1, labelOctLocal2, labelOctLocal3, labelOctLocal4,
            labelOctLocal5, labelOctLocal6, labelOctLocal7, labelOctLocal8,
            labelOctVisitante1, labelOctVisitante2, labelOctVisitante3, labelOctVisitante4,
            labelOctVisitante5, labelOctVisitante6, labelOctVisitante7, labelOctVisitante8,
            labelCtoLocal1, labelCtoLocal2, labelCtoLocal3, labelCtoLocal4,
            labelCtoVisitante1, labelCtoVisitante2, labelCtoVisitante3, labelCtoVisitante4,
            labelSemiLocal1, labelSemiLocal2, labelSemiVisitante1, labelSemiVisitante2,
            labelFinalLocal1, labelFinalVisitante1, labelFinalLocal2, labelFinalVisitante2,
            labelA1, labelA2, labelA3, labelA4, labelB1, labelB2, labelB3, labelB4,
            labelC1, labelC2, labelC3, labelC4, labelD1, labelD2, labelD3, labelD4,
            labelE1, labelE2, labelE3, labelE4, labelF1, labelF2, labelF3, labelF4,
            labelG1, labelG2, labelG3, labelG4, labelH1, labelH2, labelH3, labelH4,
            labelGol1, labelGol2, labelGol3, labelGol4, labelGol5,
            label1ro1, label1ro2, label1ro3, label1ro4, label1ro5,
            label2do1, label2do2, label2do3, label2do4, label2do5,
            label3ro1, label3ro2, label3ro3, label3ro4, label3ro5,
            labelGName1, labelGName2, labelGName3, labelGName4, labelGName5,
            labelGNumber1, labelGNumber2, labelGNumber3, labelGNumber4, labelGNumber5,
            labelGrupo;
    public PasswordField pwdfldContraseña;
    public TextField textUsuario,
            textP1L, textP2L, textP3L, textP4L, textP5L, textP6L,
            textP1V, textP2V, textP3V, textP4V, textP5V, textP6V,
            textOct1L, textOct2L, textOct3L, textOct4L, textOct5L, textOct6L, textOct7L, textOct8L,
            textOct1V, textOct2V, textOct3V, textOct4V, textOct5V, textOct6V, textOct7V, textOct8V,
            textCto1L, textCto2L, textCto3L, textCto4L, textCto1V, textCto2V, textCto3V, textCto4V,
            textSemi1L, textSemi2L, textSemi1V, textSemi2V, textFinalL, textFinalV, textTercerL, textTercerV;
    public TextArea textGolLocal1, textGolLocal2, textGolLocal3, textGolLocal4, textGolLocal5, textGolLocal6,
            textGolVisitante1, textGolVisitante2, textGolVisitante3, textGolVisitante4, textGolVisitante5, textGolVisitante6,
            textGolOctLocal1, textGolOctLocal2, textGolOctLocal3, textGolOctLocal4,
            textGolOctLocal5, textGolOctLocal6, textGolOctLocal7, textGolOctLocal8,
            textGolOctVisitante1, textGolOctVisitante2, textGolOctVisitante3, textGolOctVisitante4,
            textGolOctVisitante5, textGolOctVisitante6, textGolOctVisitante7, textGolOctVisitante8,
            textGolCtoLocal1, textGolCtoLocal2, textGolCtoLocal3, textGolCtoLocal4,
            textGolCtoVisitante1, textGolCtoVisitante2, textGolCtoVisitante3, textGolCtoVisitante4,
            textGolSemiLocal1, textGolSemiLocal2, textGolSemiVisitante1, textGolSemiVisitante2,
            textGolFinalLocal1, textGolFinalVisitante1, textGolFinalLocal2, textGolFinalVisitante2;
    public ImageView imagenBanderaA1 = new ImageView(), imagenBanderaA2 = new ImageView(),
            imagenBanderaA3 = new ImageView(), imagenBanderaA4 = new ImageView(),
            imagenBanderaB1 = new ImageView(), imagenBanderaB2 = new ImageView(),
            imagenBanderaB3 = new ImageView(), imagenBanderaB4 = new ImageView(),
            imagenBanderaC1 = new ImageView(), imagenBanderaC2 = new ImageView(),
            imagenBanderaC3 = new ImageView(), imagenBanderaC4 = new ImageView(),
            imagenBanderaD1 = new ImageView(), imagenBanderaD2 = new ImageView(),
            imagenBanderaD3 = new ImageView(), imagenBanderaD4 = new ImageView(),
            imagenBanderaE1 = new ImageView(), imagenBanderaE2 = new ImageView(),
            imagenBanderaE3 = new ImageView(), imagenBanderaE4 = new ImageView(),
            imagenBanderaF1 = new ImageView(), imagenBanderaF2 = new ImageView(),
            imagenBanderaF3 = new ImageView(), imagenBanderaF4 = new ImageView(),
            imagenBanderaH1 = new ImageView(), imagenBanderaH2 = new ImageView(),
            imagenBanderaH3 = new ImageView(), imagenBanderaH4 = new ImageView(),
            imagenBanderaG1 = new ImageView(), imagenBanderaG2 = new ImageView(),
            imagenBanderaG3 = new ImageView(), imagenBanderaG4 = new ImageView(),
            imgOct1L = new ImageView(), imgOct3V = new ImageView(), imgOct3L = new ImageView(), imgOct1V = new ImageView(),
            imgOct2L = new ImageView(), imgOct4V = new ImageView(), imgOct4L = new ImageView(), imgOct2V = new ImageView(),
            imgOct5L = new ImageView(), imgOct7V = new ImageView(), imgOct7L = new ImageView(), imgOct5V = new ImageView(),
            imgOct6L = new ImageView(), imgOct8V = new ImageView(), imgOct8L = new ImageView(), imgOct6V = new ImageView(),
            imgCto1L = new ImageView(), imgCto1V = new ImageView(), imgCto2L = new ImageView(), imgCto2V = new ImageView(),
            imgCto3L = new ImageView(), imgCto3V = new ImageView(), imgCto4L = new ImageView(), imgCto4V = new ImageView(),
            imgSemi1L = new ImageView(), imgSemi1V = new ImageView(), imgSemi2L = new ImageView(), imgSemi2V = new ImageView(),
            imgFinalL = new ImageView(), imgFinalV = new ImageView(), imgTercerL = new ImageView(), imgTercerV = new ImageView(),
            imgPart1L = new ImageView(), imgPart2L = new ImageView(), imgPart3L = new ImageView(),
            imgPart4L = new ImageView(), imgPart5L = new ImageView(), imgPart6L = new ImageView(),
            imgPart1V = new ImageView(), imgPart2V = new ImageView(), imgPart3V = new ImageView(),
            imgPart4V = new ImageView(), imgPart5V = new ImageView(), imgPart6V = new ImageView(),
            imgCampeon = new ImageView(), imgSubCampeon = new ImageView(), imgTercerPuesto = new ImageView(),
            imgFlechaIzq = new ImageView(), imgFlechaDer = new ImageView();
    public TableView<GrupoModel> tablaGrupoA, tablaGrupoB, tablaGrupoC, tablaGrupoD,
            tablaGrupoE, tablaGrupoF, tablaGrupoG, tablaGrupoH;
    public TableView<ApostadorModel> tablaResultados;
    public TableColumn<GrupoModel, String> columnaEquipoA, columnaPuntosA, columnaGolesFavorA, columnaGolesContraA,
            columnaEquipoB, columnaPuntosB, columnaGolesFavorB, columnaGolesContraB,
            columnaEquipoC, columnaPuntosC, columnaGolesFavorC, columnaGolesContraC,
            columnaEquipoD, columnaPuntosD, columnaGolesFavorD, columnaGolesContraD,
            columnaEquipoE, columnaPuntosE, columnaGolesFavorE, columnaGolesContraE,
            columnaEquipoF, columnaPuntosF, columnaGolesFavorF, columnaGolesContraF,
            columnaEquipoG, columnaPuntosG, columnaGolesFavorG, columnaGolesContraG,
            columnaEquipoH, columnaPuntosH, columnaGolesFavorH, columnaGolesContraH;
    public TableColumn<ApostadorModel, String> columnaPosicion, columnaUsuario,
            columnaGrupoA, columnaGrupoB, columnaGrupoC, columnaGrupoD,
            columnaGrupoE, columnaGrupoF, columnaGrupoG, columnaGrupoH,
            columnaOctavos, columnaCuartos, columnaSemis, columnaFinal, columnaTercer,
            columnaPodio, columnaGoleador, columnaTotal;

    @Override
    @SuppressWarnings("Convert2Lambda")
    public void initialize(URL url, ResourceBundle rb) {
        botonSalir.setDisable(true);
        Grupo.getaGrupos().stream().forEach((grupo) -> {
            Collections.sort(grupo.getaPartidos());
        });
        indice = 0;
        Desabilitar();
        ArmarTabla();
        ArmarPlayoffs();
        try {
            ArmarResultados();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CargarPartidos(Grupo.BuscarGrupo("GA"));

        tablaGrupoA.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                CargarPartidos(Grupo.BuscarGrupo("GA"));
            }
        });

        tablaGrupoB.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                CargarPartidos(Grupo.BuscarGrupo("GB"));
            }
        });

        tablaGrupoC.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                CargarPartidos(Grupo.BuscarGrupo("GC"));
            }
        });

        tablaGrupoD.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                CargarPartidos(Grupo.BuscarGrupo("GD"));
            }
        });

        tablaGrupoE.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                CargarPartidos(Grupo.BuscarGrupo("GE"));
            }
        });

        tablaGrupoF.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                CargarPartidos(Grupo.BuscarGrupo("GF"));
            }
        });

        tablaGrupoG.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                CargarPartidos(Grupo.BuscarGrupo("GG"));
            }
        });

        tablaGrupoH.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                CargarPartidos(Grupo.BuscarGrupo("GH"));
            }
        });

        botonIngresar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                String sUser = textUsuario.getText();
                String sPass = pwdfldContraseña.getText();
                if (sUser.length() > 4 && sPass.length() > 4) {
                    IOManager io = new IOManager();
                    if (io.BuscarApuesta(sUser)) {
                        try {
                            Apostador ap = io.LeerApostador(sUser);
                            if (ap.ValidarContraseña(sPass)) {
                                Action response = Dialogs.create()
                                        .owner(stage)
                                        .title("Usuario Existente")
                                        .message("El Usuario ingresado ya existe y la contraseña ingresada es correcta."
                                                + " ¿Desea continuar y vaciar los resultados cargados y rellenarlos nuevamente? \n"
                                                + "Presione Aceptar para continuar o Cancelar para salir. \n"
                                                + "Si desea solamente editar los resultados presione Editar en vez de Nuevo.")
                                        .actions(Dialog.Actions.OK, Dialog.Actions.CANCEL)
                                        .showConfirm();
                                if (response == Dialog.Actions.OK) {
                                    b = false;
                                    apostador = new Apostador(sUser, sPass);
                                    Habilitar();
                                    botonSalir.setDisable(false);
                                    CargarGrupoApuesta(indice);
                                }
                            } else {
                                Dialogs.create()
                                        .owner(stage)
                                        .title("Error en Usuario/Contraseña")
                                        .masthead(null)
                                        .message("La Contraseña ingresada es incorrecta")
                                        .showError();
                                pwdfldContraseña.clear();
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        b = false;
                        apostador = new Apostador(sUser, sPass);
                        Habilitar();
                        botonSalir.setDisable(false);
                        CargarGrupoApuesta(indice);
                    }
                } else {
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en Usuario/Contraseña")
                            .masthead(null)
                            .message("Debe ingresar un Usuario y Contraseña de más de 4 caracteres")
                            .showError();
                }
            }
        });

        botonReiniciar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Action response = Dialogs.create()
                        .owner(stage)
                        .title("Reiniciar Apuesta")
                        .message("¿Está seguro de que desea vaciar todos los resultados cargados?")
                        .actions(Dialog.Actions.OK, Dialog.Actions.CANCEL)
                        .showConfirm();
                if (response == Dialog.Actions.OK) {
                    Action rp = Dialogs.create()
                            .owner(stage)
                            .title("Reiniciar Apuesta")
                            .message("¿Desea ingresar un nuevo Usuario? \n"
                                    + "Si presiona NO continuará con el Usuario actual.")
                            .showConfirm();
                    if (rp == Dialog.Actions.YES) {
                        textUsuario.clear();
                        pwdfldContraseña.clear();
                        Desabilitar();
                        textUsuario.setDisable(false);
                        pwdfldContraseña.setDisable(false);
                        botonIngresar.setDisable(false);
                        botonEditar.setDisable(false);
                        VaciarImagenes();
                    } else {
                        if (rp == Dialog.Actions.NO) {
                            indice = 0;
                            String sUser = textUsuario.getText();
                            String sPass = pwdfldContraseña.getText();
                            apostador = new Apostador(sUser, sPass);
                            Desabilitar();
                            Habilitar();
                            VaciarImagenes();
                            CargarGrupoApuesta(indice);
                        }
                    }
                }
            }
        });

        imgFlechaIzq.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if (indice == 0) {
                    indice = 7;
                } else {
                    indice--;
                }
                CargarGrupoApuesta(indice);
            }
        });

        imgFlechaDer.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if (indice == 7) {
                    indice = 0;
                } else {
                    indice++;
                }
                CargarGrupoApuesta(indice);
            }
        });

        botonGuardarGrupo.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                ArrayList<ApuestaPartido> partidos = apostador.getaGrupos().get(indice).getaPartidos();
                try {
                    partidos.get(0).setiGolLocal(Integer.valueOf(textP1L.getText()));
                    partidos.get(0).setiGolVisitante(Integer.valueOf(textP1V.getText()));
                    partidos.get(1).setiGolLocal(Integer.valueOf(textP2L.getText()));
                    partidos.get(1).setiGolVisitante(Integer.valueOf(textP2V.getText()));
                    partidos.get(2).setiGolLocal(Integer.valueOf(textP3L.getText()));
                    partidos.get(2).setiGolVisitante(Integer.valueOf(textP3V.getText()));
                    partidos.get(3).setiGolLocal(Integer.valueOf(textP4L.getText()));
                    partidos.get(3).setiGolVisitante(Integer.valueOf(textP4V.getText()));
                    partidos.get(4).setiGolLocal(Integer.valueOf(textP5L.getText()));
                    partidos.get(4).setiGolVisitante(Integer.valueOf(textP5V.getText()));
                    partidos.get(5).setiGolLocal(Integer.valueOf(textP6L.getText()));
                    partidos.get(5).setiGolVisitante(Integer.valueOf(textP6V.getText()));
                } catch (NumberFormatException e) {
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en Resultados cargados")
                            .masthead(null)
                            .message("Revise los valores cargados. Solo se admiten valores numéricos iguales o mayores a cero. \n" + e.getMessage())
                            .showError();
                }
            }
        });

        botonOctavos.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                try {
                    apostador.getaGrupos().stream().forEach((grupo) -> {
                        grupo.CalcularGrupo();
                        grupo.getePrimero().getsNombre();
                    });
                    apostador.CrearOctavos();
                    CargarOctavos();
                } catch (NullPointerException e) {
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en fase de Grupos")
                            .masthead(null)
                            .message("Los resultados ingresados generan un doble, triple o cuádruple empate en uno o más grupos. "
                                    + "El programa no puede continuar ya que es imposible predecir qué equipo avanzará a los octavos de final.")
                            .showError();
                }
            }
        });

        botonCuartos.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                ArrayList<ApuestaPartido> partidos = apostador.getaOctavos();
                int local, visitante;
                boolean exito = true;
                try {
                    local = Integer.valueOf(textOct1L.getText());
                    visitante = Integer.valueOf(textOct1V.getText());
                    if (local >= 0 && visitante >= 0 && local != visitante) {
                        partidos.get(0).setiGolLocal(local);
                        partidos.get(0).setiGolVisitante(visitante);
                    } else {
                        partidos.get(0).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 1 de Octavos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textOct2L.getText());
                    visitante = Integer.valueOf(textOct2V.getText());
                    if (local >= 0 && visitante >= 0 && local != visitante) {
                        partidos.get(1).setiGolLocal(local);
                        partidos.get(1).setiGolVisitante(visitante);
                    } else {
                        partidos.get(1).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 2 de Octavos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textOct3L.getText());
                    visitante = Integer.valueOf(textOct3V.getText());
                    if (local >= 0 && visitante >= 0 && local != visitante) {
                        partidos.get(2).setiGolLocal(local);
                        partidos.get(2).setiGolVisitante(visitante);
                    } else {
                        partidos.get(2).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 3 de Octavos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textOct4L.getText());
                    visitante = Integer.valueOf(textOct4V.getText());
                    if (local >= 0 && visitante >= 0 && local != visitante) {
                        partidos.get(3).setiGolLocal(local);
                        partidos.get(3).setiGolVisitante(visitante);
                    } else {
                        partidos.get(3).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 4 de Octavos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textOct5L.getText());
                    visitante = Integer.valueOf(textOct5V.getText());
                    if (local >= 0 && visitante >= 0 && local != visitante) {
                        partidos.get(4).setiGolLocal(local);
                        partidos.get(4).setiGolVisitante(visitante);
                    } else {
                        partidos.get(4).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 5 de Octavos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textOct6L.getText());
                    visitante = Integer.valueOf(textOct6V.getText());
                    if (local >= 0 && visitante >= 0 && local != visitante) {
                        partidos.get(5).setiGolLocal(local);
                        partidos.get(5).setiGolVisitante(visitante);
                    } else {
                        partidos.get(5).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 6 de Octavos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textOct7L.getText());
                    visitante = Integer.valueOf(textOct7V.getText());
                    if (local >= 0 && visitante >= 0 && local != visitante) {
                        partidos.get(6).setiGolLocal(local);
                        partidos.get(6).setiGolVisitante(visitante);
                    } else {
                        partidos.get(6).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 7 de Octavos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textOct8L.getText());
                    visitante = Integer.valueOf(textOct8V.getText());
                    if (local >= 0 && visitante >= 0 && local != visitante) {
                        partidos.get(7).setiGolLocal(local);
                        partidos.get(7).setiGolVisitante(visitante);
                    } else {
                        partidos.get(7).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 8 de Octavos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                if (exito) {
                    apostador.CrearCuartos();
                    CargarCuartos();
                }
            }
        });

        botonSemifinales.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                ArrayList<ApuestaPartido> partidos = apostador.getaCuartos();
                int local, visitante;
                boolean exito = true;
                try {
                    local = Integer.valueOf(textCto1L.getText());
                    visitante = Integer.valueOf(textCto1V.getText());
                    if ((local >= 0) && (visitante >= 0) && (local != visitante)) {
                        partidos.get(0).setiGolLocal(local);
                        partidos.get(0).setiGolVisitante(visitante);
                    } else {
                        partidos.get(0).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 1 de Cuartos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textCto2L.getText());
                    visitante = Integer.valueOf(textCto2V.getText());
                    if ((local >= 0) && (visitante >= 0) && (local != visitante)) {
                        partidos.get(1).setiGolLocal(local);
                        partidos.get(1).setiGolVisitante(visitante);
                    } else {
                        partidos.get(1).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 2 de Cuartos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textCto3L.getText());
                    visitante = Integer.valueOf(textCto3V.getText());
                    if ((local >= 0) && (visitante >= 0) && (local != visitante)) {
                        partidos.get(2).setiGolLocal(local);
                        partidos.get(2).setiGolVisitante(visitante);
                    } else {
                        partidos.get(2).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 3 de Cuartos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textCto4L.getText());
                    visitante = Integer.valueOf(textCto4V.getText());
                    if ((local >= 0) && (visitante >= 0) && (local != visitante)) {
                        partidos.get(3).setiGolLocal(local);
                        partidos.get(3).setiGolVisitante(visitante);
                    } else {
                        partidos.get(3).setiGolLocal(Integer.valueOf("string"));
                    }

                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 4 de Cuartos")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                if (exito) {
                    apostador.CrearSemis();
                    CargarSemis();
                }
            }
        });

        botonFinal.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                ArrayList<ApuestaPartido> partidos = apostador.getaSemis();
                int local, visitante;
                boolean exito = true;
                try {
                    local = Integer.valueOf(textSemi1L.getText());
                    visitante = Integer.valueOf(textSemi1V.getText());
                    if ((local >= 0) && (visitante >= 0) && (local != visitante)) {
                        partidos.get(0).setiGolLocal(local);
                        partidos.get(0).setiGolVisitante(visitante);
                    } else {
                        partidos.get(0).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 1 de Semifinales")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textSemi2L.getText());
                    visitante = Integer.valueOf(textSemi2V.getText());
                    if ((local >= 0) && (visitante >= 0) && (local != visitante)) {
                        partidos.get(1).setiGolLocal(local);
                        partidos.get(1).setiGolVisitante(visitante);
                    } else {
                        partidos.get(1).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la llave 2 de Semifinales")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                if (exito) {
                    apostador.CrearFinal();
                    CargarFinales();
                }
            }
        });

        botonGuardarLlaves.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t
            ) {
                ArrayList<ApuestaPartido> partidos = apostador.getaFinales();
                int local, visitante;
                boolean exito = true;
                try {
                    local = Integer.valueOf(textTercerL.getText());
                    visitante = Integer.valueOf(textTercerV.getText());
                    if ((local >= 0) && (visitante >= 0) && (local != visitante)) {
                        partidos.get(0).setiGolLocal(local);
                        partidos.get(0).setiGolVisitante(visitante);
                    } else {
                        partidos.get(0).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en el Tercer Puesto")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                try {
                    local = Integer.valueOf(textFinalL.getText());
                    visitante = Integer.valueOf(textFinalV.getText());
                    if ((local >= 0) && (visitante >= 0) && (local != visitante)) {
                        partidos.get(1).setiGolLocal(local);
                        partidos.get(1).setiGolVisitante(visitante);
                    } else {
                        partidos.get(1).setiGolLocal(Integer.valueOf("string"));
                    }
                } catch (NumberFormatException e) {
                    exito = false;
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la Final")
                            .masthead(null)
                            .message("No se admiten empates y solo se admiten valores numéricos mayores a cero. \n" + e.getMessage())
                            .showError();
                }
                if (exito) {
                    apostador.CrearPodio();
                    CargarPodio();
                }
            }
        });

        ListaPais.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue ov, Number value, Number new_value
            ) {
                final List<String> paises = ListaPais.getItems();
                try {
                    CargarListaJugadores(paises.get(new_value.intValue()));
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        botonGuardarGoleador.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                try {
                    String eleccion = ListaJugador.getValue().toString();
                    apostador.setGoleador(eleccion);
                    botonGuardarGoleador.setDisable(true);
                    ListaJugador.setDisable(true);
                    ListaPais.setDisable(true);
                    IOManager iom = new IOManager();
                    iom.EscribirApuesta(apostador.getsUsuario(), apostador);
                } catch (IOException e) {
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en la selección del Goleador")
                            .masthead(null)
                            .message("No se ha escogido el Jugador o el País. \n" + e.getMessage())
                            .showError();
                }
                botonNuevaApuesta.setDisable(false);
                botonResumen.setDisable(false);
            }
        });

        botonNuevaApuesta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Desabilitar();
                textUsuario.setDisable(false);
                pwdfldContraseña.setDisable(false);
                botonIngresar.setDisable(false);
                botonEditar.setDisable(false);
                VaciarImagenes();
                botonSalir.setDisable(true);
            }
        });

        botonResumen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                try {
                    IOManager io = new IOManager();
                    io.ImprimirApostador(io.LeerApostador(apostador.getsUsuario()));
                } catch (IOException | ClassNotFoundException e) {
                }
            }
        });

        botonSalir.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Desabilitar();
                textUsuario.setDisable(false);
                pwdfldContraseña.setDisable(false);
                botonIngresar.setDisable(false);
                botonEditar.setDisable(false);
                VaciarImagenes();
                botonSalir.setDisable(true);
            }
        });

        botonEditar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                String sUser = textUsuario.getText();
                String sPass = pwdfldContraseña.getText();
                apostador = null;
                if (sUser.length() > 4 && sPass.length() > 4) {
                    IOManager io = new IOManager();
                    if (io.BuscarApuesta(sUser)) {
                        try {
                            apostador = io.LeerApostador(sUser);
                            if (apostador.ValidarContraseña(sPass)) {
                                b = true;
                                Habilitar();
                                botonSalir.setDisable(false);
                                botonResumen.setDisable(false);
                                indice = 0;
                                CargarGrupoApuesta(indice);
                            } else {
                                Dialogs.create()
                                        .owner(stage)
                                        .title("Error en de Usuario/Contraseña")
                                        .masthead(null)
                                        .message("La combinación Usuario/Contraseña ingresada no es correcta.")
                                        .showError();
                                pwdfldContraseña.clear();
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        Dialogs.create()
                                .owner(stage)
                                .title("Error en la lectura del Archivo")
                                .masthead(null)
                                .message("No se encuentra el archivo especificado.")
                                .showError();
                        pwdfldContraseña.clear();
                    }
                } else {
                    Dialogs.create()
                            .owner(stage)
                            .title("Error en de Usuario/Contraseña")
                            .masthead(null)
                            .message("Debe ingresar un Usuario y Contraseña de más de 4 caracteres")
                            .showError();
                }
            }
        });

        botonActualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                try {
                    ArmarResultados();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        textP1L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP2L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP3L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP4L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP5L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP6L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP1V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP2V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP3V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP4V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP5V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textP6V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct1L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct2L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct3L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct4L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct5L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct6L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct7L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct8L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct1V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct2V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct3V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct4V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct5V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct6V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct7V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textOct8V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textCto1L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textCto2L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textCto3L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textCto4L.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textCto1V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textCto2V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textCto3V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        textCto4V.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });
    }

    private void CargarPartidos(Grupo g) {
        ArrayList<Partido> p = g.getaPartidos();
        labelFecha1.setFont(brasil);
        labelFecha2.setFont(brasil);
        labelFecha3.setFont(brasil);
        labelFecha4.setFont(brasil);
        labelFecha5.setFont(brasil);
        labelFecha6.setFont(brasil);
        labelFecha1.setText(Integer.toString(p.get(0).getcFecha().get(Calendar.DAY_OF_MONTH))
                + "/" + Integer.toString(p.get(0).getcFecha().get(Calendar.MONTH)));
        labelFecha2.setText(Integer.toString(p.get(1).getcFecha().get(Calendar.DAY_OF_MONTH))
                + "/" + Integer.toString(p.get(1).getcFecha().get(Calendar.MONTH)));
        labelFecha3.setText(Integer.toString(p.get(2).getcFecha().get(Calendar.DAY_OF_MONTH))
                + "/" + Integer.toString(p.get(2).getcFecha().get(Calendar.MONTH)));
        labelFecha4.setText(Integer.toString(p.get(3).getcFecha().get(Calendar.DAY_OF_MONTH))
                + "/" + Integer.toString(p.get(3).getcFecha().get(Calendar.MONTH)));
        labelFecha5.setText(Integer.toString(p.get(4).getcFecha().get(Calendar.DAY_OF_MONTH))
                + "/" + Integer.toString(p.get(4).getcFecha().get(Calendar.MONTH)));
        labelFecha6.setText(Integer.toString(p.get(5).getcFecha().get(Calendar.DAY_OF_MONTH))
                + "/" + Integer.toString(p.get(5).getcFecha().get(Calendar.MONTH)));
        labelLocal1.setFont(brasil);
        labelLocal3.setFont(brasil);
        labelLocal4.setFont(brasil);
        labelLocal5.setFont(brasil);
        labelLocal6.setFont(brasil);
        labelVisitante1.setFont(brasil);
        labelVisitante2.setFont(brasil);
        labelVisitante4.setFont(brasil);
        labelVisitante5.setFont(brasil);
        if ("C".equals(g.getsNombre())) {
            labelLocal2.setFont(Font.loadFont(Brasuca.class.getResource("/font/Brasil 2014.ttf").toExternalForm(), 18));
            labelVisitante3.setFont(Font.loadFont(Brasuca.class.getResource("/font/Brasil 2014.ttf").toExternalForm(), 18));
            labelVisitante6.setFont(Font.loadFont(Brasuca.class.getResource("/font/Brasil 2014.ttf").toExternalForm(), 18));
        } else {
            labelLocal2.setFont(brasil);
            labelVisitante3.setFont(brasil);
            labelVisitante6.setFont(brasil);
        }
        labelLocal1.setText(Equipo.QuitarTilde(p.get(0).geteLocal().getsNombre()));
        labelLocal2.setText(Equipo.QuitarTilde(p.get(1).geteLocal().getsNombre()));
        labelLocal3.setText(Equipo.QuitarTilde(p.get(2).geteLocal().getsNombre()));
        labelLocal4.setText(Equipo.QuitarTilde(p.get(3).geteLocal().getsNombre()));
        labelLocal5.setText(Equipo.QuitarTilde(p.get(4).geteLocal().getsNombre()));
        labelLocal6.setText(Equipo.QuitarTilde(p.get(5).geteLocal().getsNombre()));
        labelVisitante1.setText(Equipo.QuitarTilde(p.get(0).geteVisitante().getsNombre()));
        labelVisitante2.setText(Equipo.QuitarTilde(p.get(1).geteVisitante().getsNombre()));
        labelVisitante3.setText(Equipo.QuitarTilde(p.get(2).geteVisitante().getsNombre()));
        labelVisitante4.setText(Equipo.QuitarTilde(p.get(3).geteVisitante().getsNombre()));
        labelVisitante5.setText(Equipo.QuitarTilde(p.get(4).geteVisitante().getsNombre()));
        labelVisitante6.setText(Equipo.QuitarTilde(p.get(5).geteVisitante().getsNombre()));
        if (p.get(0).isbJugado()) {
            textGolLocal1.setText(p.get(0).getiGolesLocal().toString());
            textGolVisitante1.setText(p.get(0).getiGolesVisitante().toString());
        } else {
            textGolLocal1.clear();
            textGolVisitante1.clear();
        }
        if (p.get(1).isbJugado()) {
            textGolLocal2.setText(p.get(1).getiGolesLocal().toString());
            textGolVisitante2.setText(p.get(1).getiGolesVisitante().toString());
        } else {
            textGolLocal2.clear();
            textGolVisitante2.clear();
        }
        if (p.get(2).isbJugado()) {
            textGolLocal3.setText(p.get(2).getiGolesLocal().toString());
            textGolVisitante3.setText(p.get(2).getiGolesVisitante().toString());
        } else {
            textGolLocal3.clear();
            textGolVisitante3.clear();
        }
        if (p.get(3).isbJugado()) {
            textGolLocal4.setText(p.get(3).getiGolesLocal().toString());
            textGolVisitante4.setText(p.get(3).getiGolesVisitante().toString());
        } else {
            textGolLocal4.clear();
            textGolVisitante4.clear();
        }
        if (p.get(4).isbJugado()) {
            textGolLocal5.setText(p.get(4).getiGolesLocal().toString());
            textGolVisitante5.setText(p.get(4).getiGolesVisitante().toString());
        } else {
            textGolLocal5.clear();
            textGolVisitante5.clear();
        }
        if (p.get(5).isbJugado()) {
            textGolLocal6.setText(p.get(5).getiGolesLocal().toString());
            textGolVisitante6.setText(p.get(5).getiGolesVisitante().toString());
        } else {
            textGolLocal6.clear();
            textGolVisitante6.clear();
        }
    }

    private void ArmarTabla() {
        ArrayList<GrupoModel> aGrupoModel = new ArrayList<>();
        ArrayList<Grupo> aGrupo = Grupo.getaGrupos();
        for (Grupo grupo : aGrupo) {
            String nombre = grupo.getsNombre();
            Equipo[] equipos = grupo.geteEquipos();
            Integer[] puntos = grupo.getiPuntos();
            Integer[] golfavor = grupo.getiGolesFavor();
            Integer[] golcontra = grupo.getiGolesContra();
            for (int i = 0; i < 4; i++) {
                grupoModel = new GrupoModel(equipos[i].getsNombre(), puntos[i].toString(), golfavor[i].toString(), golcontra[i].toString());
                aGrupoModel.add(grupoModel);
            }
            Boolean bool = false;
            for (int i = 0; i < 4; i++) {
                if (!("0".equals(aGrupoModel.get(i).getPuntos()))) {
                    bool = true;
                }
            }
            if (bool) {
                Collections.sort(aGrupoModel, Collections.reverseOrder());
            }
            AsignarBanderas(nombre, aGrupoModel);
            switch (nombre) {
                case "A": {
                    final ObservableList<GrupoModel> dataA = FXCollections.observableArrayList(aGrupoModel);
                    columnaEquipoA.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    columnaEquipoA.setCellFactory(getCustomCellFactory("20", "Arial", "black", false));
                    columnaPuntosA.setCellValueFactory(new PropertyValueFactory<>("puntos"));
                    columnaPuntosA.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesFavorA.setCellValueFactory(new PropertyValueFactory<>("golesfavor"));
                    columnaGolesFavorA.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesContraA.setCellValueFactory(new PropertyValueFactory<>("golescontra"));
                    columnaGolesContraA.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    tablaGrupoA.setItems(dataA);
                    break;
                }
                case "B": {
                    final ObservableList<GrupoModel> dataB = FXCollections.observableArrayList(aGrupoModel);
                    columnaEquipoB.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    columnaEquipoB.setCellFactory(getCustomCellFactory("20", "Arial", "black", false));
                    columnaPuntosB.setCellValueFactory(new PropertyValueFactory<>("puntos"));
                    columnaPuntosB.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesFavorB.setCellValueFactory(new PropertyValueFactory<>("golesfavor"));
                    columnaGolesFavorB.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesContraB.setCellValueFactory(new PropertyValueFactory<>("golescontra"));
                    columnaGolesContraB.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    tablaGrupoB.setItems(dataB);
                    break;
                }
                case "C": {
                    final ObservableList<GrupoModel> dataC = FXCollections.observableArrayList(aGrupoModel);
                    columnaEquipoC.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    columnaEquipoC.setCellFactory(getCustomCellFactory("20", "Arial", "black", false));
                    columnaPuntosC.setCellValueFactory(new PropertyValueFactory<>("puntos"));
                    columnaPuntosC.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesFavorC.setCellValueFactory(new PropertyValueFactory<>("golesfavor"));
                    columnaGolesFavorC.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesContraC.setCellValueFactory(new PropertyValueFactory<>("golescontra"));
                    columnaGolesContraC.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    tablaGrupoC.setItems(dataC);
                    break;
                }
                case "D": {
                    final ObservableList<GrupoModel> dataD = FXCollections.observableArrayList(aGrupoModel);
                    columnaEquipoD.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    columnaEquipoD.setCellFactory(getCustomCellFactory("20", "Arial", "black", false));
                    columnaPuntosD.setCellValueFactory(new PropertyValueFactory<>("puntos"));
                    columnaPuntosD.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesFavorD.setCellValueFactory(new PropertyValueFactory<>("golesfavor"));
                    columnaGolesFavorD.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesContraD.setCellValueFactory(new PropertyValueFactory<>("golescontra"));
                    columnaGolesContraD.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    tablaGrupoD.setItems(dataD);
                    break;
                }
                case "E": {
                    final ObservableList<GrupoModel> dataE = FXCollections.observableArrayList(aGrupoModel);
                    columnaEquipoE.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    columnaEquipoE.setCellFactory(getCustomCellFactory("20", "Arial", "black", false));
                    columnaPuntosE.setCellValueFactory(new PropertyValueFactory<>("puntos"));
                    columnaPuntosE.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesFavorE.setCellValueFactory(new PropertyValueFactory<>("golesfavor"));
                    columnaGolesFavorE.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesContraE.setCellValueFactory(new PropertyValueFactory<>("golescontra"));
                    columnaGolesContraE.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    tablaGrupoE.setItems(dataE);
                    break;
                }
                case "F": {
                    final ObservableList<GrupoModel> dataF = FXCollections.observableArrayList(aGrupoModel);
                    columnaEquipoF.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    columnaEquipoF.setCellFactory(getCustomCellFactory("20", "Arial", "black", false));
                    columnaPuntosF.setCellValueFactory(new PropertyValueFactory<>("puntos"));
                    columnaPuntosF.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesFavorF.setCellValueFactory(new PropertyValueFactory<>("golesfavor"));
                    columnaGolesFavorF.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesContraF.setCellValueFactory(new PropertyValueFactory<>("golescontra"));
                    columnaGolesContraF.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    tablaGrupoF.setItems(dataF);
                    break;
                }
                case "G": {
                    final ObservableList<GrupoModel> dataG = FXCollections.observableArrayList(aGrupoModel);
                    columnaEquipoG.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    columnaEquipoG.setCellFactory(getCustomCellFactory("20", "Arial", "black", false));
                    columnaPuntosG.setCellValueFactory(new PropertyValueFactory<>("puntos"));
                    columnaPuntosG.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesFavorG.setCellValueFactory(new PropertyValueFactory<>("golesfavor"));
                    columnaGolesFavorG.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesContraG.setCellValueFactory(new PropertyValueFactory<>("golescontra"));
                    columnaGolesContraG.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    tablaGrupoG.setItems(dataG);
                    break;
                }
                case "H": {
                    final ObservableList<GrupoModel> dataH = FXCollections.observableArrayList(aGrupoModel);
                    columnaEquipoH.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    columnaEquipoH.setCellFactory(getCustomCellFactory("20", "Arial", "black", false));
                    columnaPuntosH.setCellValueFactory(new PropertyValueFactory<>("puntos"));
                    columnaPuntosH.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesFavorH.setCellValueFactory(new PropertyValueFactory<>("golesfavor"));
                    columnaGolesFavorH.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    columnaGolesContraH.setCellValueFactory(new PropertyValueFactory<>("golescontra"));
                    columnaGolesContraH.setCellFactory(getCustomCellFactory("20", "Arial", "black", true));
                    tablaGrupoH.setItems(dataH);
                    break;
                }
            }
            aGrupoModel.clear();
        }
    }

    private void AsignarBanderas(String s, ArrayList<GrupoModel> agm) {
        switch (s) {
            case "A": {
                imagenBanderaA1.setImage(new Image(PathFinder.PathABandera(agm.get(0).getNombre(), "flags")));
                imagenBanderaA2.setImage(new Image(PathFinder.PathABandera(agm.get(1).getNombre(), "flags")));
                imagenBanderaA3.setImage(new Image(PathFinder.PathABandera(agm.get(2).getNombre(), "flags")));
                imagenBanderaA4.setImage(new Image(PathFinder.PathABandera(agm.get(3).getNombre(), "flags")));
                break;
            }
            case "B": {
                imagenBanderaB1.setImage(new Image(PathFinder.PathABandera(agm.get(0).getNombre(), "flags")));
                imagenBanderaB2.setImage(new Image(PathFinder.PathABandera(agm.get(1).getNombre(), "flags")));
                imagenBanderaB3.setImage(new Image(PathFinder.PathABandera(agm.get(2).getNombre(), "flags")));
                imagenBanderaB4.setImage(new Image(PathFinder.PathABandera(agm.get(3).getNombre(), "flags")));
                break;
            }
            case "C": {
                imagenBanderaC1.setImage(new Image(PathFinder.PathABandera(agm.get(0).getNombre(), "flags")));
                imagenBanderaC2.setImage(new Image(PathFinder.PathABandera(agm.get(1).getNombre(), "flags")));
                imagenBanderaC3.setImage(new Image(PathFinder.PathABandera(agm.get(2).getNombre(), "flags")));
                imagenBanderaC4.setImage(new Image(PathFinder.PathABandera(agm.get(3).getNombre(), "flags")));
                break;
            }
            case "D": {
                imagenBanderaD1.setImage(new Image(PathFinder.PathABandera(agm.get(0).getNombre(), "flags")));
                imagenBanderaD2.setImage(new Image(PathFinder.PathABandera(agm.get(1).getNombre(), "flags")));
                imagenBanderaD3.setImage(new Image(PathFinder.PathABandera(agm.get(2).getNombre(), "flags")));
                imagenBanderaD4.setImage(new Image(PathFinder.PathABandera(agm.get(3).getNombre(), "flags")));
                break;
            }
            case "E": {
                imagenBanderaE1.setImage(new Image(PathFinder.PathABandera(agm.get(0).getNombre(), "flags")));
                imagenBanderaE2.setImage(new Image(PathFinder.PathABandera(agm.get(1).getNombre(), "flags")));
                imagenBanderaE3.setImage(new Image(PathFinder.PathABandera(agm.get(2).getNombre(), "flags")));
                imagenBanderaE4.setImage(new Image(PathFinder.PathABandera(agm.get(3).getNombre(), "flags")));
                break;
            }
            case "F": {
                imagenBanderaF1.setImage(new Image(PathFinder.PathABandera(agm.get(0).getNombre(), "flags")));
                imagenBanderaF2.setImage(new Image(PathFinder.PathABandera(agm.get(1).getNombre(), "flags")));
                imagenBanderaF3.setImage(new Image(PathFinder.PathABandera(agm.get(2).getNombre(), "flags")));
                imagenBanderaF4.setImage(new Image(PathFinder.PathABandera(agm.get(3).getNombre(), "flags")));
                break;
            }
            case "G": {
                imagenBanderaG1.setImage(new Image(PathFinder.PathABandera(agm.get(0).getNombre(), "flags")));
                imagenBanderaG2.setImage(new Image(PathFinder.PathABandera(agm.get(1).getNombre(), "flags")));
                imagenBanderaG3.setImage(new Image(PathFinder.PathABandera(agm.get(2).getNombre(), "flags")));
                imagenBanderaG4.setImage(new Image(PathFinder.PathABandera(agm.get(3).getNombre(), "flags")));
                break;
            }
            case "H": {
                imagenBanderaH1.setImage(new Image(PathFinder.PathABandera(agm.get(0).getNombre(), "flags")));
                imagenBanderaH2.setImage(new Image(PathFinder.PathABandera(agm.get(1).getNombre(), "flags")));
                imagenBanderaH3.setImage(new Image(PathFinder.PathABandera(agm.get(2).getNombre(), "flags")));
                imagenBanderaH4.setImage(new Image(PathFinder.PathABandera(agm.get(3).getNombre(), "flags")));
                break;
            }
        }
    }

    private void ArmarPlayoffs() {
        ArmarGoleadores();
        ArrayList<Grupo> aGrupo = Grupo.getaGrupos();
        try {
            A1 = aGrupo.get(0).getePrimero();
            labelOctLocal1.setText("");
            labelOctLocal1.setGraphic(new ImageView(new Image(PathFinder.PathABandera(A1.getsNombre(), "banners"))));
        } catch (NullPointerException e) {
            labelOctLocal1.setText("1ro Grupo A");
            labelOctLocal1.setFont(brasil);
            labelOctLocal1.setAlignment(Pos.CENTER);
        }
        try {
            B2 = aGrupo.get(1).geteSegundo();
            labelOctVisitante1.setGraphic(new ImageView(new Image(PathFinder.PathABandera(B2.getsNombre(), "banners"))));
            labelOctVisitante1.setText("");
        } catch (NullPointerException e) {
            labelOctVisitante1.setText("2do Grupo B");
            labelOctVisitante1.setFont(brasil);
            labelOctVisitante1.setAlignment(Pos.CENTER);
        }
        try {
            C1 = aGrupo.get(2).getePrimero();
            labelOctLocal2.setGraphic(new ImageView(new Image(PathFinder.PathABandera(C1.getsNombre(), "banners"))));
            labelOctLocal2.setText("");
        } catch (NullPointerException e) {
            labelOctLocal2.setText("1ro Grupo C");
            labelOctLocal2.setFont(brasil);
            labelOctLocal2.setAlignment(Pos.CENTER);
        }
        try {
            D2 = aGrupo.get(3).geteSegundo();
            labelOctVisitante2.setGraphic(new ImageView(new Image(PathFinder.PathABandera(D2.getsNombre(), "banners"))));
            labelOctVisitante2.setText("");
        } catch (NullPointerException e) {
            labelOctVisitante2.setText("2do Grupo D");
            labelOctVisitante2.setFont(brasil);
            labelOctVisitante2.setAlignment(Pos.CENTER);
        }
        try {
            B1 = aGrupo.get(1).getePrimero();
            labelOctLocal3.setGraphic(new ImageView(new Image(PathFinder.PathABandera(B1.getsNombre(), "banners"))));
            labelOctLocal3.setText("");
        } catch (NullPointerException e) {
            labelOctLocal3.setText("1ro Grupo B");
            labelOctLocal3.setFont(brasil);
            labelOctLocal3.setAlignment(Pos.CENTER);
        }
        try {
            A2 = aGrupo.get(0).geteSegundo();
            labelOctVisitante3.setGraphic(new ImageView(new Image(PathFinder.PathABandera(A2.getsNombre(), "banners"))));
            labelOctVisitante3.setText("");
        } catch (NullPointerException e) {
            labelOctVisitante3.setText("2do Grupo A");
            labelOctVisitante3.setFont(brasil);
            labelOctVisitante3.setAlignment(Pos.CENTER);
        }
        try {
            D1 = aGrupo.get(3).getePrimero();
            labelOctLocal4.setGraphic(new ImageView(new Image(PathFinder.PathABandera(D1.getsNombre(), "banners"))));
            labelOctLocal4.setText("");
        } catch (NullPointerException e) {
            labelOctLocal4.setText("1ro Grupo D");
            labelOctLocal4.setFont(brasil);
            labelOctLocal4.setAlignment(Pos.CENTER);
        }
        try {
            C2 = aGrupo.get(2).geteSegundo();
            labelOctVisitante4.setGraphic(new ImageView(new Image(PathFinder.PathABandera(C2.getsNombre(), "banners"))));
            labelOctVisitante4.setText("");
        } catch (NullPointerException e) {
            labelOctVisitante4.setText("2do Grupo C");
            labelOctVisitante4.setFont(brasil);
            labelOctVisitante4.setAlignment(Pos.CENTER);
        }
        try {
            E1 = aGrupo.get(4).getePrimero();
            labelOctLocal5.setGraphic(new ImageView(new Image(PathFinder.PathABandera(E1.getsNombre(), "banners"))));
            labelOctLocal5.setText("");
        } catch (NullPointerException e) {
            labelOctLocal5.setText("1ro Grupo E");
            labelOctLocal5.setFont(brasil);
            labelOctLocal5.setAlignment(Pos.CENTER);
        }
        try {
            F2 = aGrupo.get(5).geteSegundo();
            labelOctVisitante5.setGraphic(new ImageView(new Image(PathFinder.PathABandera(F2.getsNombre(), "banners"))));
            labelOctVisitante5.setText("");
        } catch (NullPointerException e) {
            labelOctVisitante5.setText("2do Grupo F");
            labelOctVisitante5.setFont(brasil);
            labelOctVisitante5.setAlignment(Pos.CENTER);
        }
        try {
            G1 = aGrupo.get(6).getePrimero();
            labelOctLocal6.setGraphic(new ImageView(new Image(PathFinder.PathABandera(G1.getsNombre(), "banners"))));
            labelOctLocal6.setText("");
        } catch (NullPointerException e) {
            labelOctLocal6.setText("1ro Grupo G");
            labelOctLocal6.setFont(brasil);
            labelOctLocal6.setAlignment(Pos.CENTER);
        }
        try {
            H2 = aGrupo.get(7).geteSegundo();
            labelOctVisitante6.setGraphic(new ImageView(new Image(PathFinder.PathABandera(H2.getsNombre(), "banners"))));
            labelOctVisitante6.setText("");
        } catch (NullPointerException e) {
            labelOctVisitante6.setText("2do Grupo H");
            labelOctVisitante6.setFont(brasil);
            labelOctVisitante6.setAlignment(Pos.CENTER);
        }
        try {
            F1 = aGrupo.get(5).getePrimero();
            labelOctLocal7.setGraphic(new ImageView(new Image(PathFinder.PathABandera(F1.getsNombre(), "banners"))));
            labelOctLocal7.setText("");
        } catch (NullPointerException e) {
            labelOctLocal7.setText("1ro Grupo F");
            labelOctLocal7.setFont(brasil);
            labelOctLocal7.setAlignment(Pos.CENTER);
        }
        try {
            E2 = aGrupo.get(4).geteSegundo();
            labelOctVisitante7.setGraphic(new ImageView(new Image(PathFinder.PathABandera(E2.getsNombre(), "banners"))));
            labelOctVisitante7.setText("");
        } catch (NullPointerException e) {
            labelOctVisitante7.setText("2do Grupo E");
            labelOctVisitante7.setFont(brasil);
            labelOctVisitante7.setAlignment(Pos.CENTER);
        }
        try {
            H1 = aGrupo.get(7).getePrimero();
            labelOctLocal8.setGraphic(new ImageView(new Image(PathFinder.PathABandera(H1.getsNombre(), "banners"))));
            labelOctLocal8.setText("");
        } catch (NullPointerException e) {
            labelOctLocal8.setText("1ro Grupo H");
            labelOctLocal8.setFont(brasil);
            labelOctLocal8.setAlignment(Pos.CENTER);
        }
        try {
            G2 = aGrupo.get(6).geteSegundo();
            labelOctVisitante8.setGraphic(new ImageView(new Image(PathFinder.PathABandera(G2.getsNombre(), "banners"))));
            labelOctVisitante8.setText("");
        } catch (NullPointerException e) {
            labelOctVisitante8.setText("2do Grupo G");
            labelOctVisitante8.setFont(brasil);
            labelOctVisitante8.setAlignment(Pos.CENTER);
        }
        Partido.getaPartidos().stream().map((partido) -> {
            if ("O1".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolOctLocal1.setText(partido.getiGolesLocal().toString());
                textGolOctVisitante1.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).map((partido) -> {
            if ("O2".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolOctLocal2.setText(partido.getiGolesLocal().toString());
                textGolOctVisitante2.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).map((partido) -> {
            if ("O3".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolOctLocal3.setText(partido.getiGolesLocal().toString());
                textGolOctVisitante3.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).map((partido) -> {
            if ("O4".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolOctLocal4.setText(partido.getiGolesLocal().toString());
                textGolOctVisitante4.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).map((partido) -> {
            if ("O5".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolOctLocal5.setText(partido.getiGolesLocal().toString());
                textGolOctVisitante5.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).map((partido) -> {
            if ("O6".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolOctLocal6.setText(partido.getiGolesLocal().toString());
                textGolOctVisitante6.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).map((partido) -> {
            if ("O7".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolOctLocal7.setText(partido.getiGolesLocal().toString());
                textGolOctVisitante7.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).filter((partido) -> ("O8".equals(partido.getsEtapa()) && partido.isbJugado())).map((partido) -> {
            textGolOctLocal8.setText(partido.getiGolesLocal().toString());
            return partido;
        }).forEach((partido) -> {
            textGolOctVisitante8.setText(partido.getiGolesVisitante().toString());
        });
        ArmarCuartos();
    }

    private void ArmarCuartos() {
        try {
            Integer gol = Integer.valueOf(textGolOctLocal1.getText());
            Integer gov = Integer.valueOf(textGolOctVisitante1.getText());
            labelCtoLocal1.setText("");
            if (gol > gov) {
                Oct1 = A1;
            } else {
                Oct1 = B2;
            }
            labelCtoLocal1.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Oct1.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelCtoLocal1.setText("Ganador O1");
            labelCtoLocal1.setFont(brasil);
            labelCtoLocal1.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolOctLocal2.getText());
            Integer gov = Integer.valueOf(textGolOctVisitante2.getText());
            labelCtoVisitante1.setText("");
            if (gol > gov) {
                Oct2 = C1;
            } else {
                Oct2 = D2;
            }
            labelCtoVisitante1.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Oct2.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelCtoVisitante1.setText("Ganador O2");
            labelCtoVisitante1.setFont(brasil);
            labelCtoVisitante1.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolOctLocal5.getText());
            Integer gov = Integer.valueOf(textGolOctVisitante5.getText());
            labelCtoLocal2.setText("");
            if (gol > gov) {
                Oct5 = E1;
            } else {
                Oct5 = F2;
            }
            labelCtoLocal2.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Oct5.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelCtoLocal2.setText("Ganador O5");
            labelCtoLocal2.setFont(brasil);
            labelCtoLocal2.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolOctLocal6.getText());
            Integer gov = Integer.valueOf(textGolOctVisitante6.getText());
            labelCtoVisitante2.setText("");
            if (gol > gov) {
                Oct6 = G1;
            } else {
                Oct6 = H2;
            }
            labelCtoVisitante2.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Oct6.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelCtoVisitante2.setText("Ganador O6");
            labelCtoVisitante2.setFont(brasil);
            labelCtoVisitante2.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolOctLocal3.getText());
            Integer gov = Integer.valueOf(textGolOctVisitante3.getText());
            labelCtoLocal3.setText("");
            if (gol > gov) {
                Oct3 = B1;
            } else {
                Oct3 = A2;
            }
            labelCtoLocal3.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Oct3.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelCtoLocal3.setText("Ganador O3");
            labelCtoLocal3.setFont(brasil);
            labelCtoLocal3.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolOctLocal4.getText());
            Integer gov = Integer.valueOf(textGolOctVisitante4.getText());
            labelCtoVisitante3.setText("");
            if (gol > gov) {
                Oct4 = D1;
            } else {
                Oct4 = C2;
            }
            labelCtoVisitante3.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Oct4.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelCtoVisitante3.setText("Ganador O4");
            labelCtoVisitante3.setFont(brasil);
            labelCtoVisitante3.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolOctLocal7.getText());
            Integer gov = Integer.valueOf(textGolOctVisitante7.getText());
            labelCtoLocal4.setText("");
            if (gol > gov) {
                Oct7 = F1;
            } else {
                Oct7 = E2;
            }
            labelCtoLocal4.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Oct7.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelCtoLocal4.setText("Ganador O7");
            labelCtoLocal4.setFont(brasil);
            labelCtoLocal4.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolOctLocal8.getText());
            Integer gov = Integer.valueOf(textGolOctVisitante8.getText());
            labelCtoVisitante4.setText("");
            if (gol > gov) {
                Oct8 = H1;
            } else {
                Oct8 = G2;
            }
            labelCtoVisitante4.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Oct8.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelCtoVisitante4.setText("Ganador O8");
            labelCtoVisitante4.setFont(brasil);
            labelCtoVisitante4.setAlignment(Pos.CENTER);
        }
        Partido.getaPartidos().stream().map((partido) -> {
            if ("C1".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolCtoLocal1.setText(partido.getiGolesLocal().toString());
                textGolCtoVisitante1.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).map((partido) -> {
            if ("C2".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolCtoLocal2.setText(partido.getiGolesLocal().toString());
                textGolCtoVisitante2.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).map((partido) -> {
            if ("C3".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolCtoLocal3.setText(partido.getiGolesLocal().toString());
                textGolCtoVisitante3.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).filter((partido) -> ("C4".equals(partido.getsEtapa()) && partido.isbJugado())).map((partido) -> {
            textGolCtoLocal4.setText(partido.getiGolesLocal().toString());
            return partido;
        }).forEach((partido) -> {
            textGolCtoVisitante4.setText(partido.getiGolesVisitante().toString());
        });
        ArmarSemifinales();
    }

    private void ArmarSemifinales() {
        try {
            Integer gol = Integer.valueOf(textGolCtoLocal1.getText());
            Integer gov = Integer.valueOf(textGolCtoVisitante1.getText());
            labelSemiLocal1.setText("");
            if (gol > gov) {
                Cto1 = Oct1;
            } else {
                Cto1 = Oct2;
            }
            labelSemiLocal1.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Cto1.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelSemiLocal1.setText("Ganador C1");
            labelSemiLocal1.setFont(brasil);
            labelSemiLocal1.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolCtoLocal2.getText());
            Integer gov = Integer.valueOf(textGolCtoVisitante2.getText());
            labelSemiVisitante1.setText("");
            if (gol > gov) {
                Cto2 = Oct5;
            } else {
                Cto2 = Oct6;
            }
            labelSemiVisitante1.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Cto2.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelSemiVisitante1.setText("Ganador C2");
            labelSemiVisitante1.setFont(brasil);
            labelSemiVisitante1.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolCtoLocal3.getText());
            Integer gov = Integer.valueOf(textGolCtoVisitante3.getText());
            labelSemiLocal2.setText("");
            if (gol > gov) {
                Cto3 = Oct3;
            } else {
                Cto3 = Oct4;
            }
            labelSemiLocal2.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Cto3.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelSemiLocal2.setText("Ganador C3");
            labelSemiLocal2.setFont(brasil);
            labelSemiLocal2.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolCtoLocal4.getText());
            Integer gov = Integer.valueOf(textGolCtoVisitante4.getText());
            labelSemiVisitante2.setText("");
            if (gol > gov) {
                Cto4 = Oct7;
            } else {
                Cto4 = Oct8;
            }
            labelSemiVisitante2.setGraphic(new ImageView(new Image(PathFinder.PathABandera(Cto4.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelSemiVisitante2.setText("Ganador C4");
            labelSemiVisitante2.setFont(brasil);
            labelSemiVisitante2.setAlignment(Pos.CENTER);
        }
        Partido.getaPartidos().stream().map((partido) -> {
            if ("S1".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolSemiLocal1.setText(partido.getiGolesLocal().toString());
                textGolSemiVisitante1.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).filter((partido) -> ("S2".equals(partido.getsEtapa()) && partido.isbJugado())).map((partido) -> {
            textGolSemiLocal2.setText(partido.getiGolesLocal().toString());
            return partido;
        }).forEach((partido) -> {
            textGolSemiVisitante2.setText(partido.getiGolesVisitante().toString());
        });
        ArmarFinal();
    }

    private void ArmarFinal() {
        try {
            Integer gol = Integer.valueOf(textGolSemiLocal1.getText());
            Integer gov = Integer.valueOf(textGolSemiVisitante1.getText());
            labelFinalLocal1.setText("");
            labelFinalLocal2.setText("");
            if (gol > gov) {
                WSemi1 = Cto1;
                LSemi1 = Cto2;
            } else {
                WSemi1 = Cto2;
                LSemi1 = Cto1;
            }
            labelFinalLocal1.setGraphic(new ImageView(new Image(PathFinder.PathABandera(WSemi1.getsNombre(), "banners"))));
            labelFinalLocal2.setGraphic(new ImageView(new Image(PathFinder.PathABandera(LSemi1.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelFinalLocal1.setText("Ganador S1");
            labelFinalLocal2.setText("Perdedor S1");
            labelFinalLocal1.setFont(brasil);
            labelFinalLocal2.setFont(brasil);
            labelFinalLocal1.setAlignment(Pos.CENTER);
            labelFinalLocal2.setAlignment(Pos.CENTER);
        }
        try {
            Integer gol = Integer.valueOf(textGolSemiLocal2.getText());
            Integer gov = Integer.valueOf(textGolSemiVisitante2.getText());
            labelFinalVisitante1.setText("");
            labelFinalVisitante2.setText("");
            if (gol > gov) {
                WSemi2 = Cto3;
                LSemi2 = Cto4;
            } else {
                WSemi2 = Cto4;
                LSemi2 = Cto3;
            }
            labelFinalVisitante1.setGraphic(new ImageView(new Image(PathFinder.PathABandera(WSemi2.getsNombre(), "banners"))));
            labelFinalVisitante2.setGraphic(new ImageView(new Image(PathFinder.PathABandera(LSemi2.getsNombre(), "banners"))));
        } catch (NumberFormatException e) {
            labelFinalVisitante1.setText("Ganador S2");
            labelFinalVisitante2.setText("Perdedor S2");
            labelFinalVisitante1.setFont(brasil);
            labelFinalVisitante2.setFont(brasil);
            labelFinalVisitante1.setAlignment(Pos.CENTER);
            labelFinalVisitante2.setAlignment(Pos.CENTER);
        }
        Partido.getaPartidos().stream().map((partido) -> {
            if ("F1".equals(partido.getsEtapa()) && partido.isbJugado()) {
                textGolFinalLocal1.setText(partido.getiGolesLocal().toString());
                textGolFinalVisitante1.setText(partido.getiGolesVisitante().toString());
            }
            return partido;
        }).filter((partido) -> ("F2".equals(partido.getsEtapa()) && partido.isbJugado())).map((partido) -> {
            textGolFinalLocal2.setText(partido.getiGolesLocal().toString());
            return partido;
        }).forEach((partido) -> {
            textGolFinalVisitante2.setText(partido.getiGolesVisitante().toString());
        });
    }

    private void CargarGrupoApuesta(int indice) {
        labelGrupo.setText("GRUPO " + apostador.getaGrupos().get(indice).getsNombre());
        ArrayList<ApuestaPartido> partido = apostador.getaGrupos().get(indice).getaPartidos();
        imgPart1L.setImage(new Image(PathFinder.PathABandera(partido.get(0).geteLocal().getsNombre(), "banners")));
        textP1L.setText(partido.get(0).getiGolLocal().toString());
        imgPart1V.setImage(new Image(PathFinder.PathABandera(partido.get(0).geteVisitante().getsNombre(), "banners")));
        textP1V.setText(partido.get(0).getiGolVisitante().toString());
        imgPart2L.setImage(new Image(PathFinder.PathABandera(partido.get(1).geteLocal().getsNombre(), "banners")));
        textP2L.setText(partido.get(1).getiGolLocal().toString());
        imgPart2V.setImage(new Image(PathFinder.PathABandera(partido.get(1).geteVisitante().getsNombre(), "banners")));
        textP2V.setText(partido.get(1).getiGolVisitante().toString());
        imgPart3L.setImage(new Image(PathFinder.PathABandera(partido.get(2).geteLocal().getsNombre(), "banners")));
        textP3L.setText(partido.get(2).getiGolLocal().toString());
        imgPart3V.setImage(new Image(PathFinder.PathABandera(partido.get(2).geteVisitante().getsNombre(), "banners")));
        textP3V.setText(partido.get(2).getiGolVisitante().toString());
        imgPart4L.setImage(new Image(PathFinder.PathABandera(partido.get(3).geteLocal().getsNombre(), "banners")));
        textP4L.setText(partido.get(3).getiGolLocal().toString());
        imgPart4V.setImage(new Image(PathFinder.PathABandera(partido.get(3).geteVisitante().getsNombre(), "banners")));
        textP4V.setText(partido.get(3).getiGolVisitante().toString());
        imgPart5L.setImage(new Image(PathFinder.PathABandera(partido.get(4).geteLocal().getsNombre(), "banners")));
        textP5L.setText(partido.get(4).getiGolLocal().toString());
        imgPart5V.setImage(new Image(PathFinder.PathABandera(partido.get(4).geteVisitante().getsNombre(), "banners")));
        textP5V.setText(partido.get(4).getiGolVisitante().toString());
        imgPart6L.setImage(new Image(PathFinder.PathABandera(partido.get(5).geteLocal().getsNombre(), "banners")));
        textP6L.setText(partido.get(5).getiGolLocal().toString());
        imgPart6V.setImage(new Image(PathFinder.PathABandera(partido.get(5).geteVisitante().getsNombre(), "banners")));
        textP6V.setText(partido.get(5).getiGolVisitante().toString());
    }

    private void CargarOctavos() {
        botonCuartos.setDisable(false);
        imgFlechaDer.setDisable(true);
        imgFlechaDer.setVisible(false);
        imgFlechaIzq.setDisable(true);
        imgFlechaIzq.setVisible(false);
        textP1L.setDisable(true);
        textP2L.setDisable(true);
        textP3L.setDisable(true);
        textP4L.setDisable(true);
        textP5L.setDisable(true);
        textP6L.setDisable(true);
        textP1V.setDisable(true);
        textP2V.setDisable(true);
        textP3V.setDisable(true);
        textP4V.setDisable(true);
        textP5V.setDisable(true);
        textP6V.setDisable(true);
        textOct1L.setDisable(false);
        textOct1V.setDisable(false);
        textOct2L.setDisable(false);
        textOct2V.setDisable(false);
        textOct3L.setDisable(false);
        textOct3V.setDisable(false);
        textOct4L.setDisable(false);
        textOct4V.setDisable(false);
        textOct5L.setDisable(false);
        textOct5V.setDisable(false);
        textOct6L.setDisable(false);
        textOct6V.setDisable(false);
        textOct7L.setDisable(false);
        textOct7V.setDisable(false);
        textOct8L.setDisable(false);
        textOct8V.setDisable(false);
        botonOctavos.setDisable(true);
        botonGuardarGrupo.setDisable(true);
        ArrayList<ApuestaPartido> match = apostador.getaOctavos();
        String gollocal, golvisitante;
        if (b) {
            gollocal = match.get(0).getiGolLocal().toString();
            golvisitante = match.get(0).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textOct1L.setText(gollocal);
        textOct1V.setText(golvisitante);
        if (b) {
            gollocal = match.get(1).getiGolLocal().toString();
            golvisitante = match.get(1).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textOct2L.setText(gollocal);
        textOct2V.setText(golvisitante);
        if (b) {
            gollocal = match.get(2).getiGolLocal().toString();
            golvisitante = match.get(2).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textOct3L.setText(gollocal);
        textOct3V.setText(golvisitante);
        if (b) {
            gollocal = match.get(3).getiGolLocal().toString();
            golvisitante = match.get(3).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textOct4L.setText(gollocal);
        textOct4V.setText(golvisitante);
        if (b) {
            gollocal = match.get(4).getiGolLocal().toString();
            golvisitante = match.get(4).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textOct5L.setText(gollocal);
        textOct5V.setText(golvisitante);
        if (b) {
            gollocal = match.get(5).getiGolLocal().toString();
            golvisitante = match.get(5).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textOct6L.setText(gollocal);
        textOct6V.setText(golvisitante);
        if (b) {
            gollocal = match.get(6).getiGolLocal().toString();
            golvisitante = match.get(6).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textOct7L.setText(gollocal);
        textOct7V.setText(golvisitante);
        if (b) {
            gollocal = match.get(7).getiGolLocal().toString();
            golvisitante = match.get(7).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textOct8L.setText(gollocal);
        textOct8V.setText(golvisitante);
        imgOct1L.setImage(new Image(PathFinder.PathABandera(match.get(0).geteLocal().getsNombre(), "banners")));
        imgOct1V.setImage(new Image(PathFinder.PathABandera(match.get(0).geteVisitante().getsNombre(), "banners")));
        imgOct2L.setImage(new Image(PathFinder.PathABandera(match.get(1).geteLocal().getsNombre(), "banners")));
        imgOct2V.setImage(new Image(PathFinder.PathABandera(match.get(1).geteVisitante().getsNombre(), "banners")));
        imgOct3L.setImage(new Image(PathFinder.PathABandera(match.get(2).geteLocal().getsNombre(), "banners")));
        imgOct3V.setImage(new Image(PathFinder.PathABandera(match.get(2).geteVisitante().getsNombre(), "banners")));
        imgOct4L.setImage(new Image(PathFinder.PathABandera(match.get(3).geteLocal().getsNombre(), "banners")));
        imgOct4V.setImage(new Image(PathFinder.PathABandera(match.get(3).geteVisitante().getsNombre(), "banners")));
        imgOct5L.setImage(new Image(PathFinder.PathABandera(match.get(4).geteLocal().getsNombre(), "banners")));
        imgOct5V.setImage(new Image(PathFinder.PathABandera(match.get(4).geteVisitante().getsNombre(), "banners")));
        imgOct6L.setImage(new Image(PathFinder.PathABandera(match.get(5).geteLocal().getsNombre(), "banners")));
        imgOct6V.setImage(new Image(PathFinder.PathABandera(match.get(5).geteVisitante().getsNombre(), "banners")));
        imgOct7L.setImage(new Image(PathFinder.PathABandera(match.get(6).geteLocal().getsNombre(), "banners")));
        imgOct7V.setImage(new Image(PathFinder.PathABandera(match.get(6).geteVisitante().getsNombre(), "banners")));
        imgOct8L.setImage(new Image(PathFinder.PathABandera(match.get(7).geteLocal().getsNombre(), "banners")));
        imgOct8V.setImage(new Image(PathFinder.PathABandera(match.get(7).geteVisitante().getsNombre(), "banners")));
    }

    private void CargarCuartos() {
        textCto1L.setDisable(false);
        textCto1V.setDisable(false);
        textCto2L.setDisable(false);
        textCto2V.setDisable(false);
        textCto3L.setDisable(false);
        textCto3V.setDisable(false);
        textCto4L.setDisable(false);
        textCto4V.setDisable(false);
        botonCuartos.setDisable(true);
        textOct1L.setDisable(true);
        textOct1V.setDisable(true);
        textOct2L.setDisable(true);
        textOct2V.setDisable(true);
        textOct3L.setDisable(true);
        textOct3V.setDisable(true);
        textOct4L.setDisable(true);
        textOct4V.setDisable(true);
        textOct5L.setDisable(true);
        textOct5V.setDisable(true);
        textOct6L.setDisable(true);
        textOct6V.setDisable(true);
        textOct7L.setDisable(true);
        textOct7V.setDisable(true);
        textOct8L.setDisable(true);
        textOct8V.setDisable(true);
        botonSemifinales.setDisable(false);
        ArrayList<ApuestaPartido> match = apostador.getaCuartos();
        String gollocal, golvisitante;
        if (b) {
            gollocal = match.get(0).getiGolLocal().toString();
            golvisitante = match.get(0).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textCto1L.setText(gollocal);
        textCto1V.setText(golvisitante);
        if (b) {
            gollocal = match.get(1).getiGolLocal().toString();
            golvisitante = match.get(1).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textCto2L.setText(gollocal);
        textCto2V.setText(golvisitante);
        if (b) {
            gollocal = match.get(2).getiGolLocal().toString();
            golvisitante = match.get(2).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textCto3L.setText(gollocal);
        textCto3V.setText(golvisitante);
        if (b) {
            gollocal = match.get(3).getiGolLocal().toString();
            golvisitante = match.get(3).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textCto4L.setText(gollocal);
        textCto4V.setText(golvisitante);
        imgCto1L.setImage(new Image(PathFinder.PathABandera(match.get(0).geteLocal().getsNombre(), "banners")));
        imgCto1V.setImage(new Image(PathFinder.PathABandera(match.get(0).geteVisitante().getsNombre(), "banners")));
        imgCto2L.setImage(new Image(PathFinder.PathABandera(match.get(1).geteLocal().getsNombre(), "banners")));
        imgCto2V.setImage(new Image(PathFinder.PathABandera(match.get(1).geteVisitante().getsNombre(), "banners")));
        imgCto3L.setImage(new Image(PathFinder.PathABandera(match.get(2).geteLocal().getsNombre(), "banners")));
        imgCto3V.setImage(new Image(PathFinder.PathABandera(match.get(2).geteVisitante().getsNombre(), "banners")));
        imgCto4L.setImage(new Image(PathFinder.PathABandera(match.get(3).geteLocal().getsNombre(), "banners")));
        imgCto4V.setImage(new Image(PathFinder.PathABandera(match.get(3).geteVisitante().getsNombre(), "banners")));
    }

    private void CargarSemis() {
        botonFinal.setDisable(false);
        textSemi1L.setDisable(false);
        textSemi1V.setDisable(false);
        textSemi2L.setDisable(false);
        textSemi2V.setDisable(false);
        botonSemifinales.setDisable(true);
        textCto1L.setDisable(true);
        textCto1V.setDisable(true);
        textCto2L.setDisable(true);
        textCto2V.setDisable(true);
        textCto3L.setDisable(true);
        textCto3V.setDisable(true);
        textCto4L.setDisable(true);
        textCto4V.setDisable(true);
        ArrayList<ApuestaPartido> match = apostador.getaSemis();
        String gollocal, golvisitante;
        if (b) {
            gollocal = match.get(0).getiGolLocal().toString();
            golvisitante = match.get(0).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textSemi1L.setText(gollocal);
        textSemi1V.setText(golvisitante);
        if (b) {
            gollocal = match.get(1).getiGolLocal().toString();
            golvisitante = match.get(1).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textSemi2L.setText(gollocal);
        textSemi2V.setText(golvisitante);
        imgSemi1L.setImage(new Image(PathFinder.PathABandera(match.get(0).geteLocal().getsNombre(), "banners")));
        imgSemi1V.setImage(new Image(PathFinder.PathABandera(match.get(0).geteVisitante().getsNombre(), "banners")));
        imgSemi2L.setImage(new Image(PathFinder.PathABandera(match.get(1).geteLocal().getsNombre(), "banners")));
        imgSemi2V.setImage(new Image(PathFinder.PathABandera(match.get(1).geteVisitante().getsNombre(), "banners")));
    }

    private void CargarFinales() {
        botonGuardarLlaves.setDisable(false);
        textFinalL.setDisable(false);
        textFinalV.setDisable(false);
        textTercerL.setDisable(false);
        textTercerV.setDisable(false);
        botonFinal.setDisable(true);
        textSemi1L.setDisable(true);
        textSemi1V.setDisable(true);
        textSemi2L.setDisable(true);
        textSemi2V.setDisable(true);
        ArrayList<ApuestaPartido> match = apostador.getaFinales();
        String gollocal, golvisitante;
        if (b) {
            gollocal = match.get(0).getiGolLocal().toString();
            golvisitante = match.get(0).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textTercerL.setText(gollocal);
        textTercerV.setText(golvisitante);
        if (b) {
            gollocal = match.get(1).getiGolLocal().toString();
            golvisitante = match.get(1).getiGolVisitante().toString();
        } else {
            gollocal = "0";
            golvisitante = "0";
        }
        textFinalL.setText(gollocal);
        textFinalV.setText(golvisitante);
        imgTercerL.setImage(new Image(PathFinder.PathABandera(match.get(0).geteLocal().getsNombre(), "banners")));
        imgTercerV.setImage(new Image(PathFinder.PathABandera(match.get(0).geteVisitante().getsNombre(), "banners")));
        imgFinalL.setImage(new Image(PathFinder.PathABandera(match.get(1).geteLocal().getsNombre(), "banners")));
        imgFinalV.setImage(new Image(PathFinder.PathABandera(match.get(1).geteVisitante().getsNombre(), "banners")));
    }

    private void CargarPodio() {
        botonGuardarGoleador.setDisable(false);
        botonGuardarLlaves.setDisable(true);
        textFinalL.setDisable(true);
        textFinalV.setDisable(true);
        textTercerL.setDisable(true);
        textTercerV.setDisable(true);
        imgCampeon.setImage(new Image(PathFinder.PathABandera(apostador.getCampeon().getsNombre(), "banners")));
        imgSubCampeon.setImage(new Image(PathFinder.PathABandera(apostador.getSegundo().getsNombre(), "banners")));
        imgTercerPuesto.setImage(new Image(PathFinder.PathABandera(apostador.getTercero().getsNombre(), "banners")));
        ListaJugador.setDisable(false);
        ListaPais.setDisable(false);
        CargarListaPais();
    }

    private void Habilitar() {
        botonReiniciar.setDisable(false);
        textUsuario.setDisable(true);
        pwdfldContraseña.setDisable(true);
        botonIngresar.setDisable(true);
        botonEditar.setDisable(true);
        botonGuardarGrupo.setDisable(false);
        botonOctavos.setDisable(false);
        imgFlechaDer.setDisable(false);
        imgFlechaDer.setVisible(true);
        imgFlechaIzq.setDisable(false);
        imgFlechaIzq.setVisible(true);
        textP1L.setDisable(false);
        textP2L.setDisable(false);
        textP3L.setDisable(false);
        textP4L.setDisable(false);
        textP5L.setDisable(false);
        textP6L.setDisable(false);
        textP1V.setDisable(false);
        textP2V.setDisable(false);
        textP3V.setDisable(false);
        textP4V.setDisable(false);
        textP5V.setDisable(false);
        textP6V.setDisable(false);
    }

    private void Desabilitar() {
        botonResumen.setDisable(true);
        botonReiniciar.setDisable(true);
        botonNuevaApuesta.setDisable(true);
        ListaJugador.setDisable(true);
        ListaPais.setDisable(true);
        labelGrupo.setText("");
        botonCuartos.setDisable(true);
        botonOctavos.setDisable(true);
        botonSemifinales.setDisable(true);
        botonFinal.setDisable(true);
        botonGuardarGrupo.setDisable(true);
        botonGuardarGoleador.setDisable(true);
        botonGuardarLlaves.setDisable(true);
        imgFlechaDer.setDisable(true);
        imgFlechaDer.setVisible(false);
        imgFlechaIzq.setDisable(true);
        imgFlechaIzq.setVisible(false);
        imgPart1L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart2L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart3L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart4L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart5L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart6L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart1V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart2V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart3V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart4V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart5V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgPart6V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        textP1L.clear();
        textP2L.clear();
        textP3L.clear();
        textP4L.clear();
        textP5L.clear();
        textP6L.clear();
        textP1V.clear();
        textP2V.clear();
        textP3V.clear();
        textP4V.clear();
        textP5V.clear();
        textP6V.clear();
        textOct1L.clear();
        textOct1V.clear();
        textOct2L.clear();
        textOct2V.clear();
        textOct3L.clear();
        textOct3V.clear();
        textOct4L.clear();
        textOct4V.clear();
        textOct5L.clear();
        textOct5V.clear();
        textOct6L.clear();
        textOct6V.clear();
        textOct7L.clear();
        textOct7V.clear();
        textOct8L.clear();
        textOct8V.clear();
        textCto1L.clear();
        textCto1V.clear();
        textCto2L.clear();
        textCto2V.clear();
        textCto3L.clear();
        textCto3V.clear();
        textCto4L.clear();
        textCto4V.clear();
        textSemi1L.clear();
        textSemi1V.clear();
        textSemi2L.clear();
        textSemi2V.clear();
        textFinalL.clear();
        textFinalV.clear();
        textTercerL.clear();
        textTercerV.clear();
        textP1L.setDisable(true);
        textP2L.setDisable(true);
        textP3L.setDisable(true);
        textP4L.setDisable(true);
        textP5L.setDisable(true);
        textP6L.setDisable(true);
        textP1V.setDisable(true);
        textP2V.setDisable(true);
        textP3V.setDisable(true);
        textP4V.setDisable(true);
        textP5V.setDisable(true);
        textP6V.setDisable(true);
        textOct1L.setDisable(true);
        textOct1V.setDisable(true);
        textOct2L.setDisable(true);
        textOct2V.setDisable(true);
        textOct3L.setDisable(true);
        textOct3V.setDisable(true);
        textOct4L.setDisable(true);
        textOct4V.setDisable(true);
        textOct5L.setDisable(true);
        textOct5V.setDisable(true);
        textOct6L.setDisable(true);
        textOct6V.setDisable(true);
        textOct7L.setDisable(true);
        textOct7V.setDisable(true);
        textOct8L.setDisable(true);
        textOct8V.setDisable(true);
        textCto1L.setDisable(true);
        textCto1V.setDisable(true);
        textCto2L.setDisable(true);
        textCto2V.setDisable(true);
        textCto3L.setDisable(true);
        textCto3V.setDisable(true);
        textCto4L.setDisable(true);
        textCto4V.setDisable(true);
        textSemi1L.setDisable(true);
        textSemi1V.setDisable(true);
        textSemi2L.setDisable(true);
        textSemi2V.setDisable(true);
        textFinalL.setDisable(true);
        textFinalV.setDisable(true);
        textTercerL.setDisable(true);
        textTercerV.setDisable(true);
    }

    private void CargarListaJugadores(String p) throws IOException, FileNotFoundException, ClassNotFoundException {
        IOManager io = new IOManager();
        ArrayList<String> jugadores = new ArrayList<>();
        ArrayList<Jugador> players = io.LeerJugadores();
        players.stream().filter((jugador) -> (p.equals(jugador.getsNombre()))).map((jugador) -> {
            jugador.getDefensores().stream().forEach((defensor) -> {
                jugadores.add(defensor);
            });
            return jugador;
        }).map((Jugador jugador) -> {
            jugador.getMediocampistas().stream().forEach((mediocampista) -> {
                jugadores.add(mediocampista);
            });
            return jugador;
        }).forEach((jugador) -> {
            jugador.getDelanteros().stream().forEach((delantero) -> {
                jugadores.add(delantero);
            });
        });
        ListaJugador.setItems(FXCollections.observableArrayList(jugadores));
    }

    private void CargarListaPais() {
        ArrayList<String> paises = new ArrayList<>();
        Equipo.getaEquipo().stream().forEach((equipo) -> {
            paises.add(equipo.getsNombre());
            Collections.sort(paises);
        });
        ListaPais.setItems(FXCollections.observableArrayList(paises));
    }

    private void VaciarImagenes() {
        imgOct1L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct1V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct2L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct2V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct3L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct3V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct4L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct4V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct5L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct5V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct6L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct6V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct7L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct7V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct8L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgOct8V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgCto1L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgCto1V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgCto2L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgCto2V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgCto3L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgCto3V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgCto4L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgCto4V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgSemi1L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgSemi1V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgSemi2L.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgSemi2V.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgFinalL.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgFinalV.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgTercerL.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgTercerV.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgCampeon.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgSubCampeon.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        imgTercerPuesto.setImage(new Image(PathFinder.PathABandera("non", "banners")));
        textOct1L.clear();
        textOct1V.clear();
        textOct2L.clear();
        textOct2V.clear();
        textOct3L.clear();
        textOct3V.clear();
        textOct4L.clear();
        textOct4V.clear();
        textOct5L.clear();
        textOct5V.clear();
        textOct6L.clear();
        textOct6V.clear();
        textOct7L.clear();
        textOct7V.clear();
        textOct8L.clear();
        textOct8V.clear();
        textCto1L.clear();
        textCto1V.clear();
        textCto2L.clear();
        textCto2V.clear();
        textCto3L.clear();
        textCto3V.clear();
        textCto4L.clear();
        textCto4V.clear();
        textSemi1L.clear();
        textSemi1V.clear();
        textSemi2L.clear();
        textSemi2V.clear();
        textFinalL.clear();
        textFinalV.clear();
        textTercerL.clear();
        textTercerV.clear();
    }

    private void ArmarResultados() throws IOException, ClassNotFoundException {
        IOManager io = new IOManager();
        io.LeerApuestas();
        ArrayList<Apostador> bets = io.getApostadores();
        Estadisticas stats = null;
        if (bets.size() > 0) {
            stats = new Estadisticas(bets);
        }
        CargarEstadisticas(stats);
        ArrayList<ApostadorModel> betmodel = new ArrayList<>();
        if (bets.size() > 0) {
            for (Apostador bet : bets) {
                betmodel.add(new ApostadorModel(bet));
            }
            Collections.sort(betmodel, Collections.reverseOrder());
            for (int i = 0; i < betmodel.size(); i++) {
                Integer c = i + 1;
                betmodel.get(i).setPosicion(c.toString());
            }
            final ObservableList<ApostadorModel> data = FXCollections.observableArrayList(betmodel);
            columnaPosicion.setCellValueFactory(new PropertyValueFactory<>("posicion"));
            columnaPosicion.setCellFactory(getCustomCellFactory("20", "Arial", "grey", true, 0));
            columnaUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
            columnaUsuario.setCellFactory(getCustomCellFactory("20", "Arial", "black", false, 0));
            columnaGrupoA.setCellValueFactory(new PropertyValueFactory<>("grupoA"));
            columnaGrupoA.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaGrupoB.setCellValueFactory(new PropertyValueFactory<>("grupoB"));
            columnaGrupoB.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaGrupoC.setCellValueFactory(new PropertyValueFactory<>("grupoC"));
            columnaGrupoC.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaGrupoD.setCellValueFactory(new PropertyValueFactory<>("grupoD"));
            columnaGrupoD.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaGrupoE.setCellValueFactory(new PropertyValueFactory<>("grupoE"));
            columnaGrupoE.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaGrupoF.setCellValueFactory(new PropertyValueFactory<>("grupoF"));
            columnaGrupoF.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaGrupoG.setCellValueFactory(new PropertyValueFactory<>("grupoG"));
            columnaGrupoG.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaGrupoH.setCellValueFactory(new PropertyValueFactory<>("grupoH"));
            columnaGrupoH.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaOctavos.setCellValueFactory(new PropertyValueFactory<>("octavos"));
            columnaOctavos.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaCuartos.setCellValueFactory(new PropertyValueFactory<>("cuartos"));
            columnaCuartos.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaSemis.setCellValueFactory(new PropertyValueFactory<>("semis"));
            columnaSemis.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaTercer.setCellValueFactory(new PropertyValueFactory<>("tercer"));
            columnaTercer.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaFinal.setCellValueFactory(new PropertyValueFactory<>("sfinal"));
            columnaFinal.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaPodio.setCellValueFactory(new PropertyValueFactory<>("podio"));
            columnaPodio.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaGoleador.setCellValueFactory(new PropertyValueFactory<>("goleador"));
            columnaGoleador.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            columnaTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
            columnaTotal.setCellFactory(getCustomCellFactory("20", "Arial", "black", true, 0));
            tablaResultados.setItems(data);
        }
    }

    private Callback<TableColumn<GrupoModel, String>, TableCell<GrupoModel, String>> getCustomCellFactory(final String size, final String family, final String color, final boolean b) {
        return (TableColumn<GrupoModel, String> param) -> {
            TableCell<GrupoModel, String> cell = new TableCell<GrupoModel, String>() {
                @Override
                public void updateItem(final String item, boolean empty) {
                    if (item != null) {
                        setText(item);
                        setStyle("-fx-font-size: " + size + "; -fx-font-family: " + family + "; -fx-text-fill: " + color + ";");
                    }
                }
            };
            if (b) {
                cell.setAlignment(Pos.CENTER);
            }
            return cell;
        };
    }

    private Callback<TableColumn<ApostadorModel, String>, TableCell<ApostadorModel, String>> getCustomCellFactory(final String size, final String family, final String color, final boolean b, int moot) {
        return (TableColumn<ApostadorModel, String> param) -> {
            TableCell<ApostadorModel, String> cell = new TableCell<ApostadorModel, String>() {
                @Override
                public void updateItem(final String item, boolean empty) {
                    if (item != null) {
                        setText(item);
                        setStyle("-fx-font-size: " + size + "; -fx-font-family: " + family + "; -fx-text-fill: " + color + ";");
                    }
                }
            };
            if (b) {
                cell.setAlignment(Pos.BASELINE_CENTER);
            }
            return cell;
        };
    }

    private void CargarEstadisticas(Estadisticas stats) {
        try {
            ArrayList<String> aGol = new ArrayList<>();
            ArrayList<String> a1ro = new ArrayList<>();
            ArrayList<String> a2do = new ArrayList<>();
            ArrayList<String> a3ro = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : stats.getmCampeon().entrySet()) {
                a1ro.add(entry.getKey());
            }
            Collections.reverse(a1ro);
            while (a1ro.size() < 5) {
                a1ro.add("");
            }
            for (Map.Entry<String, Integer> entry : stats.getmSegundo().entrySet()) {
                a2do.add(entry.getKey());
            }
            Collections.reverse(a2do);
            while (a2do.size() < 5) {
                a2do.add("");
            }
            for (Map.Entry<String, Integer> entry : stats.getmTercero().entrySet()) {
                a3ro.add(entry.getKey());
            }
            Collections.reverse(a3ro);
            while (a3ro.size() < 5) {
                a3ro.add("");
            }
            for (Map.Entry<String, Integer> entry : stats.getmGoleador().entrySet()) {
                aGol.add(entry.getKey());
            }
            Collections.reverse(aGol);
            while (aGol.size() < 5) {
                aGol.add("");
            }
            labelA1.setText(stats.getsGrupoA()[0]);
            labelA2.setText(stats.getsGrupoA()[1]);
            labelA3.setText(stats.getsGrupoA()[2]);
            labelA4.setText(stats.getsGrupoA()[3]);
            labelB1.setText(stats.getsGrupoB()[0]);
            labelB2.setText(stats.getsGrupoB()[1]);
            labelB3.setText(stats.getsGrupoB()[2]);
            labelB4.setText(stats.getsGrupoB()[3]);
            labelC1.setText(stats.getsGrupoC()[0]);
            labelC2.setText(stats.getsGrupoC()[1]);
            labelC3.setText(stats.getsGrupoC()[2]);
            labelC4.setText(stats.getsGrupoC()[3]);
            labelD1.setText(stats.getsGrupoD()[0]);
            labelD2.setText(stats.getsGrupoD()[1]);
            labelD3.setText(stats.getsGrupoD()[2]);
            labelD4.setText(stats.getsGrupoD()[3]);
            labelE1.setText(stats.getsGrupoE()[0]);
            labelE2.setText(stats.getsGrupoE()[1]);
            labelE3.setText(stats.getsGrupoE()[2]);
            labelE4.setText(stats.getsGrupoE()[3]);
            labelF1.setText(stats.getsGrupoF()[0]);
            labelF2.setText(stats.getsGrupoF()[1]);
            labelF3.setText(stats.getsGrupoF()[2]);
            labelF4.setText(stats.getsGrupoF()[3]);
            labelG1.setText(stats.getsGrupoG()[0]);
            labelG2.setText(stats.getsGrupoG()[1]);
            labelG3.setText(stats.getsGrupoG()[2]);
            labelG4.setText(stats.getsGrupoG()[3]);
            labelH1.setText(stats.getsGrupoH()[0]);
            labelH2.setText(stats.getsGrupoH()[1]);
            labelH3.setText(stats.getsGrupoH()[2]);
            labelH4.setText(stats.getsGrupoH()[3]);
            label1ro1.setText(a1ro.get(0));
            label1ro2.setText(a1ro.get(1));
            label1ro3.setText(a1ro.get(2));
            label1ro4.setText(a1ro.get(3));
            label1ro5.setText(a1ro.get(4));
            label2do1.setText(a2do.get(0));
            label2do2.setText(a2do.get(1));
            label2do3.setText(a2do.get(2));
            label2do4.setText(a2do.get(3));
            label2do5.setText(a2do.get(4));
            label3ro1.setText(a3ro.get(0));
            label3ro2.setText(a3ro.get(1));
            label3ro3.setText(a3ro.get(2));
            label3ro4.setText(a3ro.get(3));
            label3ro5.setText(a3ro.get(4));
            labelGol1.setText(aGol.get(0));
            labelGol2.setText(aGol.get(1));
            labelGol3.setText(aGol.get(2));
            labelGol4.setText(aGol.get(3));
            labelGol5.setText(aGol.get(4));

        } catch (NullPointerException e) {
            labelA1.setText("0%");
            labelA2.setText("0%");
            labelA3.setText("0%");
            labelA4.setText("0%");
            labelB1.setText("0%");
            labelB2.setText("0%");
            labelB3.setText("0%");
            labelB4.setText("0%");
            labelC1.setText("0%");
            labelC2.setText("0%");
            labelC3.setText("0%");
            labelC4.setText("0%");
            labelD1.setText("0%");
            labelD2.setText("0%");
            labelD3.setText("0%");
            labelE4.setText("0%");
            labelE1.setText("0%");
            labelE2.setText("0%");
            labelE3.setText("0%");
            labelE4.setText("0%");
            labelF1.setText("0%");
            labelF2.setText("0%");
            labelF3.setText("0%");
            labelF4.setText("0%");
            labelG1.setText("0%");
            labelG2.setText("0%");
            labelG3.setText("0%");
            labelG4.setText("0%");
            labelH1.setText("0%");
            labelH2.setText("0%");
            labelH3.setText("0%");
            labelH4.setText("0%");
            label1ro1.setText("");
            label1ro2.setText("");
            label1ro3.setText("");
            label1ro4.setText("");
            label1ro5.setText("");
            label2do1.setText("");
            label2do2.setText("");
            label2do3.setText("");
            label2do4.setText("");
            label2do5.setText("");
            label3ro1.setText("");
            label3ro2.setText("");
            label3ro3.setText("");
            label3ro4.setText("");
            label3ro5.setText("");
            labelGol1.setText("");
            labelGol2.setText("");
            labelGol3.setText("");
            labelGol4.setText("");
            labelGol5.setText("");
        }
    }

    //Usado para cambiar el goleador de Ema y Fido. No se tiene que usar más.
    private void CambiarGoleador() throws IOException, ClassNotFoundException {
        IOManager io = new IOManager();
        io.LeerApuestas();
        ArrayList<Apostador> bets = io.getApostadores();
        for (Apostador bet : bets) {
            if (bet.getsUsuario().equals("Fidus") || bet.getsUsuario().equals("emavillalba")) {
                bet.setGoleador("Thomas Mueller");
                io.EscribirApuesta(bet.getsUsuario(), bet);
            }
        }
    }

    private void ArmarGoleadores() {
        labelGName1.setText("");
        labelGNumber1.setText("");
        labelGName2.setText("");
        labelGNumber2.setText("");
        labelGName3.setText("");
        labelGNumber3.setText("");
        labelGName4.setText("");
        labelGNumber4.setText("");
        labelGName5.setText("");
        labelGNumber5.setText("");
        try {
            labelGName1.setText(ServiceManager.getsGoleadores().get(0));
            labelGNumber1.setText(ServiceManager.getsGoles().get(0));
            try {
                labelGName2.setText(ServiceManager.getsGoleadores().get(1));
                labelGNumber2.setText(ServiceManager.getsGoles().get(1));
                try {
                    labelGName3.setText(ServiceManager.getsGoleadores().get(2));
                    labelGNumber3.setText(ServiceManager.getsGoles().get(2));
                    try {
                        labelGName4.setText(ServiceManager.getsGoleadores().get(3));
                        labelGNumber4.setText(ServiceManager.getsGoles().get(3));
                        try {
                            labelGName5.setText(ServiceManager.getsGoleadores().get(4));
                            labelGNumber5.setText(ServiceManager.getsGoles().get(4));
                        } catch (Exception e) {
                        }
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
}
