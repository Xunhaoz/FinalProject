package hellofx.Controller;


import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.models.GrandpaTower;
import hellofx.models.LevelController;
import javafx.fxml.FXML;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class MarketController {

    @FXML Label iceCreamLabel;
    @FXML Button rice;
    @FXML Button ham;
    @FXML Button coffee;

    public static int iceCreamNum = 0;

    @FXML
    public void initialize() {
        iceCreamLabel.setText(String.format("%06d", iceCreamNum));
    }

    public void marketToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
    public void marketToRice() throws IOException {
        ViewController.toRice();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void marketToCoffee() throws IOException {
        ViewController.toCoffee();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void marketToHam() throws IOException {
        ViewController.toHam();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}
