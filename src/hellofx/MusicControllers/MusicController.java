package hellofx.MusicControllers;

import hellofx.mainController.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MusicController {
    static private double volume = 0.5;
    static private double buttonVolume = 0.5;
    @FXML
    Slider buttonSlider;

    @FXML
    Slider slider;

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
        MusicPlayController.mp3.setVolume(volume);
    }

    static public double getVolume(){
        return volume;
    }


    public void setButtonVolume() {
        buttonVolume = buttonSlider.getValue();
        ButtonSoundPlayController.mp3.setVolume(buttonVolume);
    }

    static public double getButtonVolume() {return buttonVolume;};
}
