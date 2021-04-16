package fi.utu.tech.gui.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class PelaajatController {

    PeliManageri u;

    @FXML
    private TextField punainen;

    @FXML
    private TextField sininen;

    @FXML
    private TextField vihrea;

    @FXML
    private TextField keltainen;

    @FXML
    private ChoiceBox<?> maaradrop;

    @FXML
    private Button valmis;
    @FXML
    private BorderPane bp;
    @FXML
    private HBox alaboksi1;
    @FXML
    private Label ohje1;


    public GameBoard gb;

    public PelaajatController(){

    }

    @FXML
    void valmisBtnPressed(ActionEvent event) {
        //luodaan uusi pelimanageri tietojen tallentamiseen
        this.u = new PeliManageri();

        int pelaajat = 0; //apumuuttuja pelaajamäärän tarkistamiseen
        //Talletetaan pelaajien nimet pelaajaolioihin, jotka PeliManageriin
        if(!punainen.getText().equals("")){

            Pelaaja pun = new Pelaaja(punainen.getText(), u, "pun");
            u.setPelaaja(0,pun);
            pelaajat++;
        }else{u.setPelaaja(0,null);}

        if(!sininen.getText().equals("")){
            Pelaaja sin = new Pelaaja(sininen.getText(), u, "sin");
            u.setPelaaja(1,sin);
            pelaajat++;
        }else{u.setPelaaja(1,null);}

        if(!vihrea.getText().equals("")){
            Pelaaja vih = new Pelaaja(vihrea.getText(), u, "vih");
            u.setPelaaja(2,vih);
            pelaajat++;
        }else{u.setPelaaja(2,null);}

        if(!keltainen.getText().equals("")){
            Pelaaja kel = new Pelaaja(keltainen.getText(), u, "kel");
            u.setPelaaja(3,kel);
            pelaajat++;
        }else{u.setPelaaja(3,null);}

        //Testataan onko pelaajia tarpeeksi
        if(pelaajat<2){
            ohje1.setText("Pelaajia tulee olla vähintään kaksi.");

        }else{
            //alustetaan koordinaatit pelimanagerille
            initCoord();
            //Ladataan GameBoard näkymä
            try {

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //gb = new GameBoard();
                //this.u = u;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("kimble.fxml")
                );


                Parent root = loader.load();

                GameBoard controller = loader.getController();
                controller.setPeliManageri(u);
                loader.setController(controller);


                //BorderPane gbPane = loader.load();

                Scene scene = new Scene(root);
                scene.getStylesheets().addAll(this.getClass().getResource("styles.css").toExternalForm());//asetetaan tyyli

                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
            }

    }

    public void initialize() {


    }

    public void initCoord() {
        //Vähän kökkö, mutta tallennetaan normi peliruutujen GridPane koordinaatit PeliManageriin (hashmappiin),
        //josta ne ovat haettavissa ruudun numerolla, kun pitää liikkua
        //Pysyy vakiona
        if (this.u != null) {
            int apux = 0;
            int apuy = 8;
            int apux2 = 9;
            int apuy2 = 10;
            int apu3 = 16;
            for (int i = 1; i <= 28; i++) {
                if (i <= 7) {
                    int[] apu = new int[2];
                    apux++;
                    apuy--;
                    apu[0] = apux;
                    apu[1] = apuy;
                    u.addCoordinate(i, apu);
                }
                //apux 7 apuy1
                if (i <= 14 && i > 7) {
                    int[] apu = new int[2];
                    apux2++;
                    apu[0] = apux2;
                    apu[1] = apuy;
                    u.addCoordinate(i, apu);

                    apuy++;
                }
                // apux7 apuy8 apux2 16
                if (i <= 21 && i > 14) {
                    int[] apu = new int[2];
                    apu[0] = apux2;
                    apu[1] = apuy2;
                    u.addCoordinate(i, apu);
                    apux2--;
                    apuy2++;
                }
                // apux 7 apuy8 apux2 9 apuy2 17 apu3 16
                if (i > 21) {
                    int[] apu = new int[2];
                    apu[0] = apux;
                    apu[1] = apu3;
                    u.addCoordinate(i, apu);
                    apux--;
                    apu3--;
                }

            }
            //testiprintti
            for (int k = 1; k <= 28; k++) {
                System.out.println("ruudun " + k + " koordinaatit " + u.getCoordinates(k)[0] + " ja " + u.getCoordinates(k)[1]);
            }
        }

    }
}
