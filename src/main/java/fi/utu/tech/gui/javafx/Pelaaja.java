package fi.utu.tech.gui.javafx;



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
        this.pm = u;
        switch(väri){
            case "pun":
                initPun();
                System.out.println("ei tulostunu" + kotiKoord.get(1)[1]);
                break;
            case "sin":
                initSin();
                break;
            case "vih":
                initVih();
                break;
            case "kel":
                initKel();
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
    }

}
