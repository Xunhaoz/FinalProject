package hellofx.Controller.EnemyInfoControllers;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class SlideDragonInfoController {
    @FXML ProgressBar hpBar;
    @FXML ProgressBar atkBar;
    @FXML ProgressBar speedBar;
    @FXML ProgressBar atkDistance;
    @FXML ProgressBar dropEnergy;
    @FXML ProgressBar dropMoney;

    @FXML
    public void initialize() throws IOException {
        hpBar.setProgress(1.0);
        atkBar.setProgress(1.0);
        speedBar.setProgress(0.17);
        atkDistance.setProgress(1.0);
        dropEnergy.setProgress(1.0);
        dropMoney.setProgress(1.0);
    }

    public void backToAd()  throws IOException {
        ViewController.toAd();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}
