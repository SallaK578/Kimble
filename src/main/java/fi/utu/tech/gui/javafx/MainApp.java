package fi.utu.tech.gui.javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*koodirivien laskenta:
* git log --after="yyyy-mm-dd" --before="yyyy-mm-dd" --author="nimi" --shortstat -- src | grep -E "fil(e|es) changed"
* | awk '{files+=$1; inserted+=$4; deleted+=$6} END {print "files changed: ", files, "lines inserted: ", inserted, "lines deleted: ", deleted }'
* */

public class MainApp extends Application{
    Stage stage;

    

    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("Kimble");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("nimet.fxml")
        );
        Parent root = loader.load();
        PelaajatController controller = new PelaajatController();
        loader.setController(controller);


        Scene scene = new Scene(root);
        stage.setWidth(630);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show(); // Stage näkyväksi
        System.out.println("Aloitus scene");



    }


}
