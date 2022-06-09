package hellofx.Controller;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;

public class DormPageController {

    @FXML Button backButton;
    @FXML Label iceCreamLabel;

    @FXML
    public void initialize() {
        iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
    }

    @FXML
    public void dormToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
    @FXML
    public void dormToFreshChickInfoPage() throws IOException {
        ViewController.toFreshChickInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void dormToSalmonSteakInfoPage() throws IOException {
        ViewController.toSalmonSteakInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void dormToYamsInfoPage() throws IOException {
        ViewController.toYamsInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void dormToXunhoazBuBuInfoPage() throws IOException {
        ViewController.toXunhaozBuBuInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void dormToAlienThrowingHandInfoPage() throws IOException {
        ViewController.toAlienThrowingHandInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}
