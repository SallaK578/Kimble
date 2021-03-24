package fi.utu.tech.gui.javafx.assignment5;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp5 extends Application {

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

        // Label for showing the password quality
        var resultLabel = new Label();

        resultLabel.textProperty().bind(Bindings
                .when(passwordField.textProperty().length().greaterThan(12))
                .then ("Good")
                .otherwise ("Poor"));
        resultLabel.textFillProperty().bind(Bindings
                .when(passwordField.textProperty().length().greaterThan(12))
                .then (Color.GREEN)
                .otherwise (Color.RED));

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
