package hellofx.Controller.EnemyInfoControllers;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class WongInfoController {
    @FXML ProgressBar hpBar;
    @FXML ProgressBar atkBar;
    @FXML ProgressBar speedBar;
    @FXML ProgressBar atkDistance;
    @FXML ProgressBar dropEnergy;
    @FXML ProgressBar dropMoney;

    @FXML
    public void initialize() throws IOException {
        hpBar.setProgress(1.0);
        atkBar.setProgress(0.2);
        speedBar.setProgress(0.2);
        atkDistance.setProgress(0.2);
        dropEnergy.setProgress(0.5);
        dropMoney.setProgress(0.2);
    }

    public void backToAd()  throws IOException {
        ViewController.toAd();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}
