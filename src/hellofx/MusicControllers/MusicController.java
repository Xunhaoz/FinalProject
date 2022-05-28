package hellofx.MusicControllers;

import hellofx.mainController.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

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
