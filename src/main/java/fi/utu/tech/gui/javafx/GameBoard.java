package fi.utu.tech.gui.javafx;


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
    private Label ohjeLabel;

    @FXML
    private Label pelaajaLabel;

    @FXML
    private Label silmaluku;

    @FXML
    private Button noppa;

    @FXML
    private Button aloita;


    // Normiruuduilla (ei kotipesät/maalialueet) sijaitsevat nappulat talletetaan tänne
    //Tällä tarkastetaan, onko ruutu jo varattu, tapahtuuko syöminen
    // Nappuloita liikutettaessa, tulee vanha sijainti luonnollisesti poistaa
    public ArrayList<Nappula> peliLauta = new ArrayList<Nappula>(27);

    private int vuoroLaskuri;

    public PeliManageri pm;
    private int nopanTulos;

    public GameBoard(){





    }

    @FXML
    //liikutettavan nappulan valinta
    void liikutaBtn(ActionEvent event) {

        System.out.println("Nappi toimii" );

    }
    @FXML
    void aloitaPeli(ActionEvent event) {
        //nappuloiden asetus
        for(int i= 0; i<4;i++){
            if(pm.getpelaajaLista().get(i) != null){
                for(int j=0; j<4;j++){
                    Nappula nappula = pm.getpelaajaLista().get(i).getNappulat()[j];
                    nappula.getNappi().setOnAction(this::liikutaBtn);
                    gridPane.add(nappula.getNappi(), nappula.getBtnX(), nappula.getBtnY());

                }
            }

        }
        //poistetaan aloitusnappi
        gridPane.getChildren().remove(this.aloita);
        noppa.setOnAction(this::heitaNoppaa);
        pelaajaLabel.setText(pm.getPelaaja(vuoroLaskuri).getNimi());
        ohjeLabel.setText(getOhje(1));
    }

    @FXML
    //Noppaa heitetään
    void heitaNoppaa(ActionEvent event) {
        nopanTulos = pm.roll();
        silmaluku.setText(Integer.toString(nopanTulos));
        
    }
    public void initialize(){



    }

    public void setPeliManageri(PeliManageri u){
        this.pm = u;
    }



    //Palauttaa string muodossa ohjeen eri tilanteisiin
    public String getOhje(int skenaario){
        switch(skenaario){
            case 1:
                return "Heitä noppaa";

            case 2:
                return "Valitse liikutettava nappula";

            case 3:
                return "Sait numeron kuusi, voit liikuttaa nappulan pois kotipesästä";

            case 4:
                return "Sinulla ei ole mahdollisia siirtoja";

            case 5:
                return "Et voi siirtää tätä nappulaa";
        }
        return " ";
    }

}



