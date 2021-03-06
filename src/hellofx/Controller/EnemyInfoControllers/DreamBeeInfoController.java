package hellofx.Controller.EnemyInfoControllers;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class DreamBeeInfoController {
    @FXML ProgressBar hpBar;
    @FXML ProgressBar atkBar;
    @FXML ProgressBar speedBar;
    @FXML ProgressBar atkDistance;
    @FXML ProgressBar dropEnergy;
    @FXML ProgressBar dropMoney;

    @FXML
    public void initialize() throws IOException {
        hpBar.setProgress(0.83);
        atkBar.setProgress(0.67);
        speedBar.setProgress(0.3);
        atkDistance.setProgress(0.67);
        dropEnergy.setProgress(0.83);
        dropMoney.setProgress(0.83);
    }

    public void backToAd()  throws IOException {
        ViewController.toAd();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}
