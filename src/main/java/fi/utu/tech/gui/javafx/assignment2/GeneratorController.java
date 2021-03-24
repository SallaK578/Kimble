package fi.utu.tech.gui.javafx.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class GeneratorController {

    @FXML
    private PasswordField passwdInputField;

    @FXML
    private TextArea md5sumField;

    @FXML
    private Button generateHashBtn;

    @FXML
    void generateHashPressed(ActionEvent event) {
        try {

            String passwdInput = passwdInputField.getText();
            String passwdOutput = MD5Sum.calculateMD5Sum(passwdInput);
            System.out.println("Salasana: " + passwdInput + " Häshätty salasana:  " +passwdOutput);
            md5sumField.setText(passwdOutput);
        }

        catch(Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Nyt meni väärin.");
            alert.setContentText("Yritäppä uudestaan.");

            alert.showAndWait();
        }

    }


}

