package iana.ui;

import java.io.IOException;

import iana.Iana;
import iana.ui.controller.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    /** An instance of Iana */
    private Iana iana = new Iana();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setIana(iana);
            stage.show();
            fxmlLoader.<MainWindow>getController().welcome();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}