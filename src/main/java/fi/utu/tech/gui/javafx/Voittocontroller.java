package fi.utu.tech.gui.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class Voittocontroller {

    @FXML
    private Label voittaja;

    @FXML
    private Label onnittelut;

    @FXML
    private Button uudestaan;

    public String nimi;

    @FXML
    void uudestaan(ActionEvent event) {
        try {

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("nimet.fxml")
            );


            Parent root = loader.load();

            PelaajatController controller = loader.getController();
            loader.setController(controller);


            Scene scene = new Scene(root);
            scene.getStylesheets().addAll(this.getClass().getResource("styles.css").toExternalForm());//asetetaan tyyli

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

}

    void setVoittaja(String nimi){
        this.nimi = nimi;
        voittaja.setText(nimi);
    }
}
