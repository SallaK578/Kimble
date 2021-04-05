package fi.utu.tech.gui.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class GameBoard {
    public Scene scene;
    @FXML
    private BorderPane gbPane;

    @FXML
    private GridPane gridPane;

    @FXML
    private Circle ruutu1;

    @FXML
    private Circle ruutu8;

    @FXML
    private Circle ruutu15;

    @FXML
    private Circle ruutu22;

    @FXML
    private Circle ruutu28;

    @FXML
    private Circle ruutu7;

    @FXML
    private Circle ruutu14;

    @FXML
    private Circle ruutu21;

    @FXML
    private Circle ruutu20;

    @FXML
    private Circle ruutu19;

    @FXML
    private Circle ruutu6;

    @FXML
    private Circle ruutu5;

    @FXML
    private Circle ruutu4;

    @FXML
    private Circle ruutu9;

    @FXML
    private Circle ruutu3;

    @FXML
    private Circle ruutu10;

    @FXML
    private Circle ruutu11;

    @FXML
    private Circle ruutu12;

    @FXML
    private Circle ruutu13;

    @FXML
    private Circle ruutu16;

    @FXML
    private Circle ruutu17;

    @FXML
    private Circle ruutu18;

    @FXML
    private Circle ruutu25;

    @FXML
    private Circle ruutu24;

    @FXML
    private Circle ruutu23;

    @FXML
    private Circle ruutu26;

    @FXML
    private Circle ruutu27;

    @FXML
    private Circle ruutu2;

    @FXML
    private Circle pPesa3;

    @FXML
    private Circle pPesa2;

    @FXML
    private Circle pPesa1;

    @FXML
    private Circle pPesa0;

    @FXML
    private Circle sPesa0;

    @FXML
    private Circle sPesa3;

    @FXML
    private Circle sPesa2;

    @FXML
    private Circle sPesa1;

    @FXML
    private Circle vPesa0;

    @FXML
    private Circle vPesa1;

    @FXML
    private Circle vpPesa2;

    @FXML
    private Circle vPesa3;

    @FXML
    private Circle kPesa3;

    @FXML
    private Circle kPesa2;

    @FXML
    private Circle kPesa1;

    @FXML
    private Circle kPesa0;

    @FXML
    private Circle pMaali1;

    @FXML
    private Circle pMaali2;

    @FXML
    private Circle pMaali3;

    @FXML
    private Circle pMaali4;

    @FXML
    private Circle sMaali1;

    @FXML
    private Circle sMaali4;

    @FXML
    private Circle sMaali3;

    @FXML
    private Circle sMaali2;

    @FXML
    private Circle vMaali4;

    @FXML
    private Circle vMaali3;

    @FXML
    private Circle vMaali2;

    @FXML
    private Circle vMaali1;

    @FXML
    private Circle kMaali4;

    @FXML
    private Circle kMaali3;

    @FXML
    private Circle kMaali2;

    @FXML
    private Circle kMaali1;

    @FXML
    private Label p1;

    @FXML
    private Label k1;

    @FXML
    private Label v1;

    @FXML
    private Label s1;

    @FXML
    private Label p2;

    @FXML
    private Label s2;

    @FXML
    private Label k2;

    @FXML
    private Label v2;

    @FXML
    private Label s4;

    @FXML
    private Label k3;

    @FXML
    private Label v3;

    @FXML
    private Label p3;

    @FXML
    private Label s3;

    @FXML
    private Label v4;

    @FXML
    private Label k4;

    @FXML
    private Label p4;

    @FXML
    private Button pBut1;

    @FXML
    private Button pBut3;

    @FXML
    private Button pBut4;

    @FXML
    private Button pBut2;

    @FXML
    private Button kBut4;

    @FXML
    private Button vBut1;

    @FXML
    private Button vBut2;

    @FXML
    private Button vBut3;

    @FXML
    private Button vBut4;

    @FXML
    private Button kBut3;

    @FXML
    private Button kBut2;

    @FXML
    private Button kBut1;

    @FXML
    private Button sBut4;

    @FXML
    private Button sBut3;

    @FXML
    private Button sBut2;

    @FXML
    private Button sBut1;

    @FXML
    private Label ohjeLabel;

    @FXML
    private Label silmaluku;

    // Normiruuduilla (ei kotipesät/maalialueet) sijaitsevat nappulat talletetaan tänne
    //Tällä tarkastetaan, onko ruutu jo varattu, tapahtuuko syöminen
    // Nappuloita liikutettaessa, tulee vanha sijainti luonnollisesti poistaa
    public ArrayList<Nappula> peliLauta = new ArrayList<Nappula>(27);

    private int vuoroLaskuri;

    public PeliManageri u;

    public GameBoard(PeliManageri u){
        this.u = u;
    }

    @FXML
    //liikutettavan nappulan valinta
    void liikutaBtn(ActionEvent event) {

    }
    @FXML
    //Noppaa heitetään
    void heitaNoppaa(ActionEvent event) {

    }
    public void initialize(){
        //testiä vaan
        System.out.println(u.getCoordinates(1)[0]+" " +u.getCoordinates(1)[1]);

    }
    public void setPeliManageri(PeliManageri u){
        this.u = u;
    }


}

