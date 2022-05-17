package hellofx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import org.w3c.dom.events.Event;

import java.io.IOException;

public class MusicController {
    static private int volume = 50;


    @FXML
    Slider slider;

    @FXML
    public void initialize() {
        slider.setMax(100);
        slider.setMin(0);
        slider.setValue(volume);
        slider.setShowTickLabels(true);
    }

    @FXML
    public void voiceToSetting() throws IOException {
        ViewController.toSetting();
    }

    @FXML
    public void setVolume() {
        volume = (int) Math.round(slider.getValue());
        System.out.println(volume);
    }

    static public int getVolume(){
        return volume;
    }
}
