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
    //palauttaa maalikoordinaatti
    public int[] getMaaliKoo(int ruutu){
        return maaliKoord.get(ruutu);
    }

    //palauttaa kotikoordinaatti
    public int[] getKotiKoo(int ruutu){
        return kotiKoord.get(ruutu);
    }

    //palauttaa pelaajan nimen ja värin
    public String getNimi() {
        return nimi + " " +väri;
    }


    //Yksittäisen nappulan asettaminen kotipesään
    public void asetaKotiPesaan(Nappula n) {
        for(int i= 0; i<4; i++){
            if(this.kotiPesa[i] == null){
                this.kotiPesa[i] = n;
                n.setBtnCoordinates(kotiKoord.get(i+1)[0],kotiKoord.get(i+1)[1]);
                break;
            }
        }
    }
    //kotipesä arrayn asettaminen(ei ehkä tarpeellinen, alustetaan jo alussa)
    public void setKotipesa(Nappula[] kPesa){
        this.kotiPesa = kPesa;
    }

    public Nappula[] getKotiPesa(){

        return kotiPesa;
    }

    //yksittäisen nappulan asettaminen maaliin
    //testataanko siirron mahdollisuus jo tässä?
    public boolean asetaMaaliin2(int ruutu, Nappula n){
        if(maaliAlue[ruutu-1] == null) {
            maaliAlue[ruutu - 1] = n;
            n.setBtnCoordinates(maaliKoord.get(ruutu)[0], maaliKoord.get(ruutu)[1]);
            return true;
        }else{
            return false;
        }
    }
    public void asetaMaaliin(int ruutu, Nappula n){

        maaliAlue[ruutu-1] = n;
        n.setLiikututRuudut(0);
        n.setBtnCoordinates(maaliKoord.get(ruutu)[0], maaliKoord.get(ruutu)[1]);

    }

    //nappulan poisto kotipesästä tai maalialueelta
    //poistetaan kotipesästä kun koti=true, poistetaan maalialueelta kun koti=false
    public void removeNappula(Nappula n, boolean koti){
        if(koti){
            for(int i= 0; i<4; i++){
                if(kotiPesa[i] != null && kotiPesa[i].equals(n)){
                    kotiPesa[i] = null;
                }
            }
        }else{
            for(int k= 0; k<4; k++){
                if(maaliAlue[k] != null && maaliAlue[k].equals(n)){
                    maaliAlue[k] = null;
                }
            }

        }

    }

    public void setMaaliAlue(Nappula[] maali){
        this.maaliAlue = maali;
    }

    public Nappula[] getMaaliAlue() {
        return maaliAlue;
    }


    //Nappulat käyttöön/pois käytöstä
    public void disableNappulat(boolean disable){
        for(int i= 0; i<4; i++){
            getNappulat()[i].disable(disable);
        }
    }
    //testaa onko kotipesä tyhjä, jos on: true
    //jos ei: false
    public boolean kotipesaTyhja(){
        for(int i= 0; i<4; i++){
            if(kotiPesa[i] != null) {
                return false;
            }
        }
        return true;
    }
    //tarkistaa onko kotipesä täynnä
    public boolean kotipesaTaysi(){
        for(int i= 0; i<4; i++){
            if(kotiPesa[i] == null) {
                return false;
            }
        }
        return true;
    }
    // tarkistaa onko maalialue täynnä, eli onko pelaaja voittanut
    //jos täysi: true
    public boolean maalialueTaysi(){
        for(int i= 0; i<4; i++){
            if(maaliAlue[i] == null) {
                return false;
            }
        }
        return true;
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
            kotiPesa[j] = nappulat[j];
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
            nappulat[j]= new Nappula(1, btn, apu);
            kotiPesa[j] = nappulat[j];
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
            nappulat[j]= new Nappula(2, btn, apu);

            kotiPesa[j] = nappulat[j];
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
        //Nappulaoliot luodaan ja lisätään nappulat arrayhin ja kotipesaan
        for(int j = 0;j<4;j++){
            Button btn = new Button();
            btn.getStyleClass().add("nappula");
            btn.getStyleClass().add("kNappula");
            int[] apu = new int[2];
            apu[0] = 7+j;
            apu[1] = 17;
            nappulat[j]= new Nappula(3, btn, apu);
            kotiPesa[j] = nappulat[j];
        }
    }
    

}
