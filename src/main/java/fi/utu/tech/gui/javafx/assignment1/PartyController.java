package fi.utu.tech.gui.javafx.assignment1;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class PartyController {

    Random craziness = new Random();

    @FXML
    private StackPane backgroundPane;

    @FXML
    private Slider partyAmountSlider;

    @FXML
    private Button partyButton;

    @FXML
    void partyBtnPressed(ActionEvent event) {
        int partyAmount = (int)partyAmountSlider.getValue();
        for (int i=0; i<partyAmount; i++) {
            var c = new Circle(craziness.nextInt(50), Color.rgb(craziness.nextInt(255), craziness.nextInt(255), craziness.nextInt(255)));
            backgroundPane.getChildren().add(c);
            var tran = new TranslateTransition(
                Duration.millis(1000), c);
            tran.setToX(500-craziness.nextInt(1000));
            tran.setToY(500-craziness.nextInt(1000));
            tran.setFromX(0);
            tran.setFromY(0);
            tran.setInterpolator(Interpolator.EASE_OUT);
            tran.play();
        }

    }

}
