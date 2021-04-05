package fi.utu.tech.gui.javafx;

import javafx.scene.control.Button;

public class Nappula {
    public int[] coordinates;
    public Button nappi;
    public int id;

    public Nappula(Button nappula, int[] coordinates, int id){
        this.nappi = nappula;
        this.coordinates = coordinates;
        this.id = id;
    }

}
