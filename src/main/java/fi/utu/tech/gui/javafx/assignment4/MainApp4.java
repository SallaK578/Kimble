package fi.utu.tech.gui.javafx.assignment4;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class MainApp4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Layout properties
        stage.setTitle("Password strength meter");
        var root = new BorderPane();
        var grid = new GridPane();
        root.setPadding(new Insets(25, 25, 25, 25));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Init components
        var passwordLabel = new Label("Password: ");
        var passwordField = new PasswordField();
        // Label for showing the length
        var resultLabel = new Label();

        resultLabel.textProperty().bind(Bindings.convert(passwordField.textProperty().length()));


        // Add components to layout
        grid.add(passwordLabel, 0, 0);
        grid.add(passwordField, 1, 0);

        root.setTop(new Label("Password strength meter"));
        root.setCenter(grid);
        root.setBottom(resultLabel);

        // Start up
        var scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}


