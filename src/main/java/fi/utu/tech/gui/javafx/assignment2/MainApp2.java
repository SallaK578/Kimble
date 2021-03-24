package fi.utu.tech.gui.javafx.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp2 extends Application {

    // Note that this exercise will end up terminating with an exception before modifications

    @Override
    public void start(Stage stage) throws Exception {
        // Getting the reference to "class object of this class"
        var resourceRoot = getClass();
        // The fxml filename that is in resources folder
        var form = "PasswordHashGen.fxml";

        // Give the FXML resource to the FXMLLoader
        var loader = new FXMLLoader(resourceRoot.getResource(form));

        // Load and parse the FXML into an Java object (Parent)
        Parent root = loader.load();

        // This is just the usual: Setting scene, showing stage
        var scene = new Scene(root);
        stage.setTitle("MD5sum");
        stage.setScene(scene);
        stage.show();


    }
    
}
