package hellofx.Controller;


import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.models.GrandpaTower;
import hellofx.models.LevelController;
import javafx.fxml.FXML;

import java.io.IOException;

import javafx.scene.control.Button;


public class MarketController {

    @FXML
    Button moneyrate;
    @FXML
    Button MaxR;
    @FXML
    Button addTowerHealth;


    public void dormToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void addMaxM() {
        LevelController.changeMaxM(200);
    }

    public void addMaxR() {
        LevelController.changeRateM(1);
    }

    public void addTowerHealth() {
        GrandpaTower.chHealth(1);
    }

}
