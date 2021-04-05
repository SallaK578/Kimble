package fi.utu.tech.gui.javafx;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Pelaaja {
    String nimi;
    ArrayList<Nappula> kotiPesa = new ArrayList<Nappula>(4);
    ArrayList<Nappula> maaliAlue = new ArrayList<Nappula>(4);
    ArrayList<Nappula> nappulat = new ArrayList<>(4);


    public Pelaaja (String n) {
        nimi = n;
    }



    public String getNimi() {
        return nimi;
    }


    public void setNimi(String nimi) {
        this.nimi = nimi;
    }







}
