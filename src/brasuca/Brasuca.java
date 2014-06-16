/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brasuca;

import impl.org.controlsfx.i18n.Localization;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Francisco
 */
public class Brasuca extends Application {

    BooleanProperty ready = new SimpleBooleanProperty(false);

    private void longStart() {
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                IOManager io = new IOManager();
                boolean b = io.Exists("Jugadores");
                ServiceManager.CargarGrupos(b);
                ServiceManager.CargarPartidos();
                ServiceManager.ActualizarPuntos();
                ServiceManager.CargarGoleador();
                ready.setValue(Boolean.TRUE);
                notifyPreloader(new StateChangeNotification(StateChangeNotification.Type.BEFORE_START));
                return null;
            }
        };
        new Thread(task).start();

    }

    private static final DoubleProperty dProgreso = new SimpleDoubleProperty();

    public static void setDProgreso(double value) {
        dProgreso.set(value);
    }

    static public DoubleProperty dProgresoProperty() {
        return dProgreso;
    }

    @Override
    @SuppressWarnings("Convert2Lambda")
    public void start(final Stage stage) throws Exception {
        longStart();
        Localization.setLocale(new Locale("es", "MX"));

        dProgresoProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                double d = (double) t1;
                notifyPreloader(new ProgressNotification(d));
            }
        });

        ready.addListener(
                (ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
                    if (Boolean.TRUE.equals(t1)) {
                        Platform.runLater(() -> {
                            Parent root = null;
                            try {
                                root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
                            } catch (IOException ex) {
                                Logger.getLogger(Brasuca.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            stage.setTitle("Brasil 2014");
                            stage.setScene(new Scene(root, 1140, 655));
                            stage.getIcons().add(new Image("/img/trophy.png"));
                            stage.setResizable(false);
                            stage.show();
                        });
                    }
                });
    }

    public static
            void main(String[] args) {
        Application.launch(Brasuca.class, args);
    }

    private void CambiarGoleador() throws IOException, ClassNotFoundException {
        IOManager io = new IOManager();
        io.LeerApuestas();
        ArrayList<Apostador> bets = io.getApostadores();
        for (Apostador bet : bets) {
            if (bet.getsUsuario().equals("Fidus")
                    || bet.getsUsuario().equals("ciroges")
                    || bet.getsUsuario().equals("emavillalba")) {
                bet.setGoleador("Thomas Mueller");
            }
        }
    }
}
