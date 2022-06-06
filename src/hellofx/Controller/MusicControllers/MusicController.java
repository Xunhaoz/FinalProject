package hellofx.Controller.MusicControllers;

import hellofx.Controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.io.IOException;

public class MusicController {
    static private double volume = 0.5;
    static private double buttonVolume = 0.5;
    @FXML
    Slider buttonSlider;

    @FXML
    Slider slider;
    @FXML
    Label buttonLabel;
    @FXML
    Label backgroundLabel;


    @FXML
    public void initialize() {
        slider.setMax(1);
        slider.setMin(0);
        slider.setValue(volume);
        slider.setShowTickLabels(false);

        buttonSlider.setMax(1);
        buttonSlider.setMin(0);
        buttonSlider.setValue(buttonVolume);
        buttonSlider.setShowTickLabels(false);
    }

    @FXML
    public void voiceToSetting() throws IOException {
        ViewController.toSetting();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void setVolume() {
        volume = slider.getValue();
        backgroundLabel.setText(Math.round(slider.getValue()*100) + "%");
        MusicPlayController.mp3.setVolume(volume);
    }

    static public double getVolume(){
        return volume;
    }


    public void setButtonVolume() {
        buttonVolume = buttonSlider.getValue();
        buttonLabel.setText(Math.round(buttonSlider.getValue()*100) + "%");
        ButtonSoundPlayController.mp3.setVolume(buttonVolume);
    }

    static public double getButtonVolume() {return buttonVolume;};
}
