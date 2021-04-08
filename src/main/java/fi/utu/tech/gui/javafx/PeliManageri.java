package fi.utu.tech.gui.javafx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class PeliManageri {


    Random noppa = new Random();
    //tallennetaan pelaajat -> indeksi 0=punainen, 1=sininen, 2=vihreä, 3=keltainen
    ArrayList<Pelaaja> pelaajaLista = new ArrayList<Pelaaja>();

    HashMap<Integer, int[]> koordinaatit = new HashMap<>(28);
    public PeliManageri(){

    }
    public int roll() {
        return noppa.nextInt(6)+1;
    }

    public Pelaaja getPelaaja(int indeksi) {
        return pelaajaLista.get(indeksi);
    }
    public ArrayList<Pelaaja> getpelaajaLista(){
        return pelaajaLista;
    }

    public void setPelaaja(int indeksi, Pelaaja pelaaja) {
        pelaajaLista.add(indeksi, pelaaja);
}

    public int[] getCoordinates(int ruutu){
        return koordinaatit.get(ruutu);

    }
    public void setCoordinates(HashMap koordinaatit){
        this.koordinaatit = koordinaatit;
    }

    public void addCoordinate(int ruutu, int[] koord){
        koordinaatit.put(ruutu, koord);
    }
}
