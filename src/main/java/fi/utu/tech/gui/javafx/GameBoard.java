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

        if(onkoKotip((Button)event.getSource()) && nopanTulos ==6){
            System.out.println("Nappi toimii" );
            gridPane.getChildren().remove((Button)event.getSource());
            switch(vuoroLaskuri){
                case 0:
                    System.out.println("case0 toimii");
                    Nappula nappula =liikutettava((Button)event.getSource());
                    nappula.setBtnCoordinates(1,7);
                    System.out.println(nappula.getBtnX());
                    gridPane.add(nappula.getNappi(), 1, 7);
                     break;
                case 1:
                    System.out.println("case1 toimii");
                    Nappula nappula1 =liikutettava((Button)event.getSource());
                    nappula1.setBtnCoordinates(10,1);
                    gridPane.add(nappula1.getNappi(), 10, 1);
                    break;
                case 2:
                    System.out.println("case2 toimii");
                    Nappula nappula2 =liikutettava((Button)event.getSource());
                    nappula2.setBtnCoordinates(17,7);
                    gridPane.add(nappula2.getNappi(), 17, 7);
                    break;
                case 3:
                    System.out.println("case3 toimii");
                    Nappula nappula3 =liikutettava((Button)event.getSource());
                    nappula3.setBtnCoordinates(7,17);
                    gridPane.add(nappula3.getNappi(),7, 17);
                    break;


            }


        }





    }
    @FXML
    void aloitaPeli(ActionEvent event) {
        //nappuloiden asetus
        for(int i= 0; i<4;i++){
            if(pm.getpelaajaLista().get(i) != null){
                for(int j=0; j<4;j++){
                    Nappula nappula = pm.getpelaajaLista().get(i).getNappulat()[j];
                    nappula.getNappi().setOnAction(this::liikutaBtn);
                    nappula.getNappi().setDisable(true);
                    gridPane.add(nappula.getNappi(), nappula.getBtnX(), nappula.getBtnY());

                }
            }

        }
        //poistetaan aloitusnappi
        gridPane.getChildren().remove(this.aloita);
        noppa.setOnAction(this::heitaNoppaa);
        vuoroLaskuri = 0;
        pelaajaLabel.setText(pm.getPelaaja(vuoroLaskuri).getNimi());
        ohjeLabel.setText(getOhje(1));
    }

    @FXML
    //Noppaa heitetään
    void heitaNoppaa(ActionEvent event) {
        nopanTulos = pm.roll();
        silmaluku.setText(Integer.toString(nopanTulos));
        if(pm.getPelaaja(vuoroLaskuri).kotipesaTaysi() && nopanTulos == 6) {
            ohjeLabel.setText(getOhje(3));
            pm.getPelaaja(vuoroLaskuri).disableNappulat(false);
        }else{
            if(vuoroLaskuri!=3) {
                vuoroLaskuri++;
            }else{
                vuoroLaskuri = 0;
            }
                pelaajaLabel.setText(pm.getPelaaja(vuoroLaskuri).getNimi());
                ohjeLabel.setText(getOhje(1));

            }


    }
    //&& pm.getPelaaja(vuoroLaskuri).kotipesaTyhja() != true
    public void initialize(){



    }
    public boolean onkoKotip(Button btn){
        for(int k=0; k<4; k++){
            if(pm.getPelaaja(vuoroLaskuri).getKotiPesa()[k].getNappi().equals(btn)) {
                return true;
            }
        }
        return false;
    }
    public Nappula liikutettava(Button btn){
        for(int k=0; k<4; k++){
            if(pm.getPelaaja(vuoroLaskuri).getNappulat()[k].getNappi().equals(btn)) {
                return pm.getPelaaja(vuoroLaskuri).getNappulat()[k];
            }
        }
        return null;
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
<<<<<<< HEAD
    
    
    // silmäluku talletetaan tähän
    int nopanTulos;
    nopanTulos = heitaNoppaa(event, nopanTulos);
    
    
    @FXML
    //Noppaa heitetään
    public int heitaNoppaa(ActionEvent event, int silmaLuku) {
    	
    	silmaLuku = u.roll();
    	return silmaLuku;
    	// uuden vuoron tarkistus jonnekin muualle?
    }
    
    @FXML
    //liikutettavan nappulan valinta
    void liikutaBtn(ActionEvent event, int askeleet){
    	
    	// tarkistus voiko kotipesästä liikuttaa
    	boolean kotipesasta = false;
    	if (nopanTulos == 6) {
    		kotipesasta = true;
    	}
    	
    	
    	
    	
    }

    public void initialize(){
        //testiä vaan
        System.out.println(u.getCoordinates(1)[0]+" " +u.getCoordinates(1)[1]);

    }
    public void setPeliManageri(PeliManageri u){
        this.u = u;
    }
=======

}
>>>>>>> salla



