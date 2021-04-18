package fi.utu.tech.gui.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    @FXML
    private Button skipBtn;
    @FXML
    private Button rageBtn;


    // Normiruuduilla (ei kotipesät/maalialueet) sijaitsevat nappulat talletetaan tänne
    //Tällä tarkastetaan, onko ruutu jo varattu, tapahtuuko syöminen
    // Nappuloita liikutettaessa, tulee vanha sijainti luonnollisesti poistaa
    public ArrayList<Nappula> peliLauta = new ArrayList<Nappula>(27);

    private int vuoroLaskuri;

    public PeliManageri pm;
    private int nopanTulos;

    public GameBoard() {


    }

    @FXML
        //liikutettavan nappulan valinta

    void liikutaBtn(ActionEvent event) {
        //jos nappula kotipesässä ja noppa 6 liikutetaan värikohtaiseen aloitusruutuun
        // switch (true) {
        /*if (onkoKotip((Button) event.getSource()) && nopanTulos == 6 && voiko1Liikkua(liikutettava((Button) event.getSource()))){

                ensimmäinenNappula((Button) event.getSource());
                ohjeLabel.setText(getOhje(6));
                System.out.println("kotipesästä liikutus ");

            }*/
            //jos nappula kotipesässä, mutta noppa EI 6
            if (onkoKotip((Button) event.getSource()) && nopanTulos != 6) {
                ohjeLabel.setText(getOhje(5));
                System.out.println("liikutusyritys kotipesästä -> ei luvallinen ");
            }
            //jos nappulaa voi liikuttaa
            else if (voiko1Liikkua(liikutettava((Button) event.getSource()))) {
                if(onkoKotip((Button) event.getSource())){
                    ensimmäinenNappula((Button) event.getSource());
                }else{
                    System.out.println("liikutus muualla ");
                    siirto((Button) event.getSource());
                }
                if(nopanTulos == 6){
                    ohjeLabel.setText(getOhje(6));
                }

            }
            //jos nappulaa ei voi liikuttaa
            else if (voiko1Liikkua(liikutettava((Button) event.getSource())) == false) {
                ohjeLabel.setText(getOhje(5));

            }



        }


    @FXML
    void skippaaVuoro(ActionEvent event) {
        seuraava();
    }

    @FXML
    void rageQuit(ActionEvent event) {
        try {

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("quit.fxml")
            );


            Parent root = loader.load();

            quitController controller = loader.getController();

            loader.setController(controller);
            controller.setNimi(pm.getPelaaja(vuoroLaskuri).getPelkkaNimi());
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
        //Noppaa heitetään
    void heitaNoppaa(ActionEvent event) {
        nopanTulos = pm.roll();
        silmaluku.setText(Integer.toString(nopanTulos));
        //voiko liikuttaa
        if (voikoLiikkua()) {
            if(nopanTulos == 6){
            ohjeLabel.setText(getOhje(3));
            }else{
                ohjeLabel.setText(getOhje(2));
            }
            pm.getPelaaja(vuoroLaskuri).disableNappulat(false);
        }
        if (!voikoLiikkua()) {
 
        	if (nopanTulos != 6) {
        	noppa.setDisable(true);
        	ohjeLabel.setText(getOhje(4));
        	}
        
        	else {
        	ohjeLabel.setText(getOhje(7));
        	}
        }
        
        if (nopanTulos != 6) {
        	noppa.setDisable(true);
        }
        
    }


    public void ensimmäinenNappula(Button btn) {
        //poistetaan gridpanesta
        gridPane.getChildren().remove(btn);
        switch (vuoroLaskuri) {
            case 0:
                System.out.println("case0 toimii");
                Nappula nappula = liikutettava(btn);
                liikutettava(btn).setLiikututRuudut(0);
                if (peliLauta.get(0) != null && peliLauta.get(0).getId() != 0) {
                    syo(peliLauta.get(0));
                    System.out.println("syötiin1");
                }
                nappula.setBtnCoordinates(1, 7);
                //lisätään nappula pelilauta arraylistiin
                peliLauta.set(0, nappula);
                //testiprintti
                if(peliLauta.get(0) != null && peliLauta.get(0).getId() == 0){
                    System.out.println("pelilautaan lisäys onnistui");
                }
                //poistetaan nappula kotipesästä
                pm.getPelaaja(vuoroLaskuri).removeNappula(nappula, true);
                //lisätään gridpaneen
                System.out.println(nappula.getBtnX());
                gridPane.add(btn, 1, 7);

                pm.getPelaaja(vuoroLaskuri).disableNappulat(true);
                break;
            case 1:
                System.out.println("case1 toimii");
                Nappula nappula1 = liikutettava(btn);
                liikutettava(btn).setLiikututRuudut(0);
                if (peliLauta.get(7) != null && peliLauta.get(7).getId() != 1) {
                    syo(peliLauta.get(7));
                    System.out.println("syötiin 8");
                }
                nappula1.setBtnCoordinates(10, 1);
                //lisätään nappula pelilauta arraylistiin
                peliLauta.set(7, nappula1);
                //testiprintti
                if(peliLauta.get(7) != null && peliLauta.get(7).getId() == 1){
                    System.out.println("pelilautaan lisäys onnistui");
                }
                //poistetaan nappula kotipesästä
                pm.getPelaaja(vuoroLaskuri).removeNappula(nappula1, true);
                //lisätään gridpaneen
                gridPane.add(btn, 10, 1);

                pm.getPelaaja(vuoroLaskuri).disableNappulat(true);
                break;
            case 2:
                System.out.println("case2 toimii");
                Nappula nappula2 = liikutettava(btn);
                liikutettava(btn).setLiikututRuudut(0);
                nappula2.setBtnCoordinates(16, 10);
                if (peliLauta.get(14) != null && peliLauta.get(14).getId() != 2) {
                    syo(peliLauta.get(14));
                    System.out.println("syötiin 15");
                }
                //lisätään nappula pelilauta arraylistiin
                peliLauta.set(14, nappula2);
                //testiprintti
                if(peliLauta.get(14) != null && peliLauta.get(14).getId() == 2){
                    System.out.println("pelilautaan lisäys onnistui");
                }
                //poistetaan nappula kotipesästä
                pm.getPelaaja(vuoroLaskuri).removeNappula(nappula2, true);
                //lisätään gridpaneen
                gridPane.add(btn, 16, 10);

                pm.getPelaaja(vuoroLaskuri).disableNappulat(true);
                break;
            case 3:
                System.out.println("case3 toimii");
                Nappula nappula3 = liikutettava(btn);
                liikutettava(btn).setLiikututRuudut(0);
                if (peliLauta.get(21) != null && peliLauta.get(21).getId() != 3) {
                    syo(peliLauta.get(21));
                    System.out.println("syötiin 22");
                }
                nappula3.setBtnCoordinates(7, 16);
                //lisätään nappula pelilauta arraylistiin
                peliLauta.set(21, nappula3);
                //testiprintti
                if(peliLauta.get(21) != null && peliLauta.get(21).getId() == 3){
                    System.out.println("pelilautaan lisäys onnistui");
                }
                //poistetaan nappula kotipesästä
                pm.getPelaaja(vuoroLaskuri).removeNappula(nappula3, true);
                //lisätään gridpaneen
                gridPane.add(btn, 7, 16);

                pm.getPelaaja(vuoroLaskuri).disableNappulat(true);
                break;
        }

    }

    public void siirto(Button btn) {
        Nappula n = liikutettava(btn);
        //Onko kyseinen nappula laudalla
        if (peliLauta.contains(n)) {
            //missä ruudussa nappula ??vai indeksi?
            int vanha = peliLauta.indexOf(n)+1;
            int uusi = vanha + nopanTulos;
            //Kierros ympäri
            if (uusi > 28) {
                //-1 oli -2
                uusi = uusi - 28;
            }
            //Mennäänkö jo maalialueelle
            if (n.getLiikututRuudut() + nopanTulos > 27) {
                //Pääseekö maaliin
                int erotus = (n.getLiikututRuudut()+nopanTulos)-27;
                if (pm.getPelaaja(vuoroLaskuri).getMaaliAlue()[erotus-1] == null) {
                    // OBS liikutetaan maaliin
                    maaliSiirto(btn, erotus);
                }
            } else {
                //Onko uusi sijainti tyhjä, jos ei, syödään nappula

                if (peliLauta.get(uusi-1) != null ) {
                    syo(peliLauta.get(uusi-1));
                }
                // muuten liikutetaan
                normiSiirto(btn, uusi);
            }
        }else{

                // jos maalialueella, liikutetaan siellä
                	//siirretään maalialueella

            for (int i = 1; i <= 4 ; i++) {
                if (pm.getPelaaja(vuoroLaskuri).getMaaliAlue()[i-1] != null && pm.getPelaaja(vuoroLaskuri).getMaaliAlue()[i-1].equals(liikutettava(btn)) && pm.getPelaaja(vuoroLaskuri).getMaaliAlue()[(i+nopanTulos)-1] == null) {
                    System.out.println("Liikutetaan maalialueella ruudusta: " + i  + "ruutuun " + (i+nopanTulos));
                    System.out.println("");
                    //poistetaan gridpanelta
                    gridPane.getChildren().remove(btn);
                    //poistetaan pelaajan maalialueelta
                    pm.getPelaaja(vuoroLaskuri).removeNappula(liikutettava(btn), false);
                    //lisätään gridpanelle maaliin
                    gridPane.add(btn, pm.getPelaaja(vuoroLaskuri).getMaaliKoo(i+nopanTulos)[0], pm.getPelaaja(vuoroLaskuri).getMaaliKoo(i+nopanTulos)[1]);
                    //lisätään pelaajan maaliin
                    pm.getPelaaja(vuoroLaskuri).asetaMaaliin(i+nopanTulos, liikutettava(btn));
                    if(nopanTulos != 6) {
                        seuraava();
                    }
                    break;
                    }
            }

        }

        pm.getPelaaja(vuoroLaskuri).disableNappulat(true);

    }


    //Nappula syödään eli poistuu ruudusta ja siirtyy omaan kotipesäänsä
    public void syo(Nappula n) {
        System.out.println("Syönti metodi");
        //poistetaan gridpanelta
        gridPane.getChildren().remove(n.getNappi());
        //poistetaan lauta arraylististä
        peliLauta.set(peliLauta.indexOf(n), null);
        //lisätään laudalle kotipesään
        for (int i = 0; i < 4; i++) {
            if (pm.getPelaaja(n.getId()).getKotiPesa()[i] == null) {
                gridPane.add(n.getNappi(), pm.getPelaaja(n.getId()).getKotiKoo(i+1)[0], pm.getPelaaja(n.getId()).getKotiKoo(i+1)[1]);
                //tallennetaan pelaajan kotipesään
                pm.getPelaaja(n.getId()).asetaKotiPesaan(n);
                break;
            }
        }
    }


    //liikutaan maalialueelle/a
    public void maaliSiirto(Button btn, int ruutu){
    	System.out.println("maaliin siirtyminen ruutuun:  " + ruutu);

        //siirretään maaliin
        if(pm.getPelaaja(vuoroLaskuri).getMaaliAlue()[ruutu-1] == null && peliLauta.contains(liikutettava(btn))){
            //poistetaan gridpanelta
            gridPane.getChildren().remove(btn);
            // poistetaan pelilauta arraylistasta
            peliLauta.set(peliLauta.indexOf(liikutettava(btn)), null);
            //lisätään gridpanelle maaliin
            gridPane.add(btn, pm.getPelaaja(vuoroLaskuri).getMaaliKoo(ruutu)[0], pm.getPelaaja(vuoroLaskuri).getMaaliKoo(ruutu)[1]);
            //lisätään pelaajan maalialueelle
            pm.getPelaaja(vuoroLaskuri).asetaMaaliin(ruutu, liikutettava(btn));
            if(pm.getPelaaja(vuoroLaskuri).maalialueTaysi()){
                voitto(btn);
            }

            if(nopanTulos != 6) {
                seuraava();
            }

        }

    }

    //liikutaan laudalla uusi => ruutuina
    public void normiSiirto(Button btn, int uusi){
        //poistetaan gridpanelta
        gridPane.getChildren().remove(btn);
        //poistetaan arraylistiltä
        peliLauta.set(peliLauta.indexOf(liikutettava(btn)), null);

        //lisätään gridpane
        //OBS lisätty uusi +1
        gridPane.add(btn, pm.koordinaatit.get(uusi)[0], pm.koordinaatit.get(uusi)[1]);
        System.out.println("koordinaatit: " + pm.koordinaatit.get(uusi)[0] +" " + pm.koordinaatit.get(uusi)[1]);
        //lisätään arraylistiin
        peliLauta.set(uusi-1, liikutettava(btn));
        System.out.println("lisätty pelilautaan indeksi: " + peliLauta.indexOf(liikutettava(btn)));
        //lisätään nappulalle liikutut ruudut
        liikutettava(btn).setLiikututRuudut(liikutettava(btn).getLiikututRuudut()+nopanTulos);
        if(pm.getPelaaja(vuoroLaskuri).maalialueTaysi()){
            voitto(btn);
        }

        if(nopanTulos != 6) {
            seuraava();
        }



    }

    public boolean voikoLiikkua() {
        //Käydään pelaajan nappulat läpi
        for (int k = 0; k < 4; k++) {
            //testataan voiko nappula liikkua
            // jos yksikin voi, palauttaa true
            if(voiko1Liikkua(pm.getPelaaja(vuoroLaskuri).getNappulat()[k])){
                return true;
            }
        }
        return false;
        

    }
    public boolean voiko1Liikkua(Nappula n){
        //Onko kyseinen nappula laudalla
        if(peliLauta.contains(n)){
            System.out.println("ainakin yks nappula laudalla");
            //nappulan indeksi pelilaudalla
            int vanha = peliLauta.indexOf(n);
            int uusi = vanha + nopanTulos;
            //Kierros ympäri
            if(uusi>27){
                uusi = (uusi-27)-1;
            }
            //Mennäänkö jo maalialueelle
            if(n.getLiikututRuudut()+nopanTulos >27){
                //Pääseekö maaliin
                int erotus = (n.getLiikututRuudut()+nopanTulos)-27;
                try{
                    if(pm.getPelaaja(vuoroLaskuri).getMaaliAlue()[erotus-1] == null){
                        return true;
                    }
                }catch(IndexOutOfBoundsException e){
                    System.out.println("Ei voi liikkua, ei pääse maaliin");
                    return false;
                }
            }else {
                //Onko uusi sijainti tyhjä, tai toisen pelaajan nappula
                if (peliLauta.get(uusi) == null ||peliLauta.get(uusi).getId() != vuoroLaskuri  ) {
                    return true;
                }
            }
        }
        // jos maalialueella, voiko liikkua siellä?
        try{
            for(int j = 0; j < 4; j++){
                if(pm.getPelaaja(vuoroLaskuri).getMaaliAlue()[j] != null && pm.getPelaaja(vuoroLaskuri).getMaaliAlue()[j].equals(n) && pm.getPelaaja(vuoroLaskuri).getMaaliAlue()[j+nopanTulos] == null){
                    return true;
                }
            }
        }catch(IndexOutOfBoundsException e){
            return false;
        }
        // jos kotipesässä, voiko liikkua sieltä?
        for(int j = 0; j<4;j++){
            if(pm.getPelaaja(vuoroLaskuri).getKotiPesa()[j] != null && pm.getPelaaja(vuoroLaskuri).getKotiPesa()[j].equals(n) && nopanTulos ==6){
                switch(vuoroLaskuri){
                    case 0:
                        if(peliLauta.get(0) == null || peliLauta.get(0).getId() != 0){
                            return true;
                        }else{
                            return false;
                        }
                    case 1:
                        if(peliLauta.get(7) == null || peliLauta.get(7).getId() != 1){
                            return true;
                        }else{
                        return false;
                    }

                    case 2:
                        if(peliLauta.get(14) == null || peliLauta.get(14).getId() != 2){
                            return true;
                        }else{
                            return false;
                        }
                    case 3:
                        if(peliLauta.get(21) == null || peliLauta.get(21).getId() != 3){
                            return true;
                        }else{
                            return false;
                        }
                }

            }
        }
        return false;
    }




    //Vaihtaa vuoroon seuraavan pelaajan
    public void seuraava(){
        //vuorolaskurin päivitys -> uusi vuoro alkaa
        if(pm.getPelaaja(vuoroLaskuri) != null){
            pm.getPelaaja(vuoroLaskuri).disableNappulat(true);
        }
        if(vuoroLaskuri!=3) {
            vuoroLaskuri++;
        }else{
            vuoroLaskuri = 0;
        }
        //jos pelaajaa ei ole, siirrytään yli
        if(pm.getPelaaja(vuoroLaskuri)!=null) {
            pelaajaLabel.setText(pm.getPelaaja(vuoroLaskuri).getNimi());
            ohjeLabel.setText(getOhje(1));
        }else{seuraava();}
        //noppa käyttöön
        noppa.setDisable(false);
    }

    public void initialize(){
        for(int k=0; k< 28; k++) {
            peliLauta.add(null);
        }

    }

    public boolean onkoKotip(Button btn){
        for(int k=0; k<4; k++){
            if(pm.getPelaaja(vuoroLaskuri).getKotiPesa()[k] != null && pm.getPelaaja(vuoroLaskuri).getKotiPesa()[k].getNappi().equals(btn) ) {
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
                return "Sait numeron kuusi, voit liikuttaa nappuloita kotipesästä";

            case 4:
                return "Sinulla ei ole mahdollisia siirtoja, joudut skippaamaan vuorosi";

            case 5:
                return "Et voi siirtää tätä nappulaa";
            case 6:
                return "Saat heittää uudelleen";
             
            case 7:
                return "Ei mahdollisia siirtoja, mutta voit heittää uudelleen";
        }
        return " ";
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

        skipBtn.setDisable(false);
        rageBtn.setDisable(false);
        noppa.setDisable(false);
        vuoroLaskuri = 0;
        //Määritetään ensimmäinen pelaaja
        for(int i = vuoroLaskuri; i<4; i++){
            if(pm.getPelaaja(vuoroLaskuri) != null) {
                pelaajaLabel.setText(pm.getPelaaja(vuoroLaskuri).getNimi());
                break;
            }else{
                vuoroLaskuri++;
            }
        }
        ohjeLabel.setText(getOhje(1));
    }

    public void voitto(Button btn){
        try {

            Node node = (Node) btn;
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("voitto.fxml")
            );

            Parent root = loader.load();

            Voittocontroller controller = loader.getController();

            loader.setController(controller);
            controller.setVoittaja(pm.getPelaaja(vuoroLaskuri).getPelkkaNimi());
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}



