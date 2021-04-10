package fi.utu.tech.gui.javafx;

import javafx.scene.control.Button;

public class Nappula {
    public int[] coordinates;
    public Button nappi;
    //id punanen = 0, sininen = 1, vihreä = 2, keltanen = 3
    public int id;
    public int liikututRuudut;

    public Nappula(int id, Button button, int[] coord){
        this.coordinates = coord;
        this.id = id;
        this.nappi = button;
    }
    public Button getNappi(){
        return nappi;
    }
    public int getId(){
        return id;
    }
    public void setBtnCoordinates(int x, int y){
        coordinates[0] = x;
        coordinates[1] = y;
    }
    public int[] getBtnCoordinates(){
        return coordinates;
    }
    public int getBtnX(){
        return coordinates[0];
    }
    public int getBtnY(){
        return coordinates[1];
    }
    public int getLiikututRuudut(){
        return liikututRuudut;
    }
    public void setLiikututRuudut(int ruudut){
        liikututRuudut = ruudut;

    }

    //disable nappula jos true, false -> able
    public void disable(boolean disable){
        this.nappi.setDisable(disable);
    }


}
