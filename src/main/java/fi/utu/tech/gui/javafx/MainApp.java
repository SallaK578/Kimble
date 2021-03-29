package fi.utu.tech.gui.javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainApp extends Application{
    Stage stage;



    public void start(Stage stage) { //Throws exception
        this.stage = stage;
        stage.setTitle("Kimble");
        stage.show(); // Stage näkyväksi
        System.out.println("Aloitus scene");



    }


}
