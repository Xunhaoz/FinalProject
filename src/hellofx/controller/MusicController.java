package hellofx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media ;

import java.io.File;
import java.io.IOException;

public class MusicController {
    static private double volume = 0.5;


    @FXML
    Slider slider;

    @FXML
    public void initialize() {
        slider.setMax(1);
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
        volume = slider.getValue();
        MusicPlayController.mp3.setVolume(volume);
    }

    static public double getVolume(){
        return volume;
    }
    

}
