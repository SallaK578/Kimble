package fi.utu.tech.gui.javafx;



import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class Pelaaja {
    String nimi;
    String väri;
    Nappula[] kotiPesa = new Nappula[4];
    Nappula[] maaliAlue = new Nappula[4];
    Nappula[] nappulat = new Nappula[4];
    HashMap<Integer, int[]> maaliKoord = new HashMap<>();
    HashMap<Integer, int[]> kotiKoord = new HashMap<>();
    PeliManageri pm;
    public Pelaaja (String n, PeliManageri u, String väri) {
        nimi = n;
        this.väri = väri;
        this.pm = u;
        switch(väri){
            case "pun":
                initPun();
                System.out.println("punainen pelaaja luotu " + " kotipesän ruutu1 y: "+ kotiKoord.get(1)[1] + " x: " + kotiKoord.get(1)[0]);
                break;
            case "sin":
                initSin();
                System.out.println("sininen pelaaja luotu " + " kotipesän ruutu1 y: "+ kotiKoord.get(1)[1] + " x: " + kotiKoord.get(1)[0]);
                break;
            case "vih":
                initVih();
                System.out.println("vihreä pelaaja luotu " + " kotipesän ruutu1 y: "+ kotiKoord.get(1)[1] + " x: " + kotiKoord.get(1)[0]);
                break;
            case "kel":
                initKel();
                System.out.println("keltainen pelaaja luotu" + " kotipesän ruutu1 y: "+ kotiKoord.get(1)[1] + " x: " + kotiKoord.get(1)[0]);
                break;

        }
    }



    public String getNimi() {
        return nimi;
    }
    //pitää ehk muuttaa sillee et parametriks nappula vaan
    public void setKotiPesa(Nappula[] kotiPesa) {
        this.kotiPesa = kotiPesa;
    }
    public Nappula[] getKotiPesa(){
        return kotiPesa;
    }
    public void setMaaliAlue(){

    }
    public Nappula[] getMaaliAlue() {
        return maaliAlue;
    }

    public Nappula[] getNappulat() {
        return nappulat;
    }
    private void initPun(){
        //kotipesän koordinaatit punaiselle
        int apux = 6;
        for(int i = 1; i <5; i++) {
            int[] apu = new int[2];
            apu[0] = 0;
            apu[1] = apux+i;
            kotiKoord.put(i,apu);
        }
        //maalialueen koordinaatit: avain 1-4 arvo koordinaatit int[]
        for(int k=1; k<5; k++){
            int[] apu = new int[2];
            apu[0] = 1+k;
            apu[1] = 8 + k%2;
            maaliKoord.put(k,apu);
        }
        //Nappulaoliot luodaan ja lisätään nappulat arrayhin
        for(int j = 0;j<4;j++){
            Button btn = new Button();
            btn.getStyleClass().add("nappula");
            btn.getStyleClass().add("pNappula");
            int[] apu = new int[2];
            apu[0] = 0;
            apu[1] = 7+j;
            nappulat[j]= new Nappula(0, btn, apu);
        }



    }
    private void initSin(){
        //kotipesän koordinaatit siniselle
        int apux = 6;
        for(int i = 1; i <5; i++) {
            int[] apu = new int[2];
            apu[0] = apux+i;
            apu[1] = 0;
            kotiKoord.put(i,apu);
        }
        //maalialueen koordinaatit
        for(int k=1; k<5; k++){
            int[] apu = new int[2];
            apu[0] = 9 - k%2;
            apu[1] = 1+k;
            maaliKoord.put(k,apu);
        }
        //Nappulaoliot luodaan ja lisätään nappulat arrayhin
        for(int j = 0;j<4;j++){
            Button btn = new Button();
            btn.getStyleClass().add("nappula");
            btn.getStyleClass().add("sNappula");
            int[] apu = new int[2];
            apu[0] = 7+j;
            apu[1] = 0;
            nappulat[j]= new Nappula(0, btn, apu);
        }
    }
    private void initVih(){
        //kotipesän koordinaatit keltaiselle
        int apux = 6;
        for(int i = 1; i <5; i++) {
            int[] apu = new int[2];
            apu[0] = 17;
            apu[1] = apux+i;
            kotiKoord.put(i,apu);
        }
        //maalialueen koordinaatit
        for(int k=1; k<5; k++){
            int[] apu = new int[2];
            apu[0] = 16-k;
            apu[1] = 9 - k%2;
            maaliKoord.put(k,apu);
        }
        //Nappulaoliot luodaan ja lisätään nappulat arrayhin
        for(int j = 0;j<4;j++){
            Button btn = new Button();
            btn.getStyleClass().add("nappula");
            btn.getStyleClass().add("vNappula");
            int[] apu = new int[2];
            apu[0] = 17;
            apu[1] = 7+j;
            nappulat[j]= new Nappula(0, btn, apu);
        }
    }
    private void initKel(){
        //kotipesän koordinaatit keltaiselle
        int apux = 6;
        for(int i = 1; i <5; i++) {
            int[] apu = new int[2];
            apu[0] = apux+i;
            apu[1] = 17;
            kotiKoord.put(i,apu);
        }
        //maalialueen koordinaatit
        for(int k=1; k<5; k++){
            int[] apu = new int[2];
            apu[1] = 16-k;
            apu[0] = 8 + k%2;
            maaliKoord.put(k,apu);
        }
        //Nappulaoliot luodaan ja lisätään nappulat arrayhin
        for(int j = 0;j<4;j++){
            Button btn = new Button();
            btn.getStyleClass().add("nappula");
            btn.getStyleClass().add("kNappula");
            int[] apu = new int[2];
            apu[0] = 7+j;
            apu[1] = 17;
            nappulat[j]= new Nappula(0, btn, apu);
        }
    }


}
