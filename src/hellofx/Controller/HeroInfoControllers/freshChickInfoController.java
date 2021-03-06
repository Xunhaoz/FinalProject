package hellofx.Controller.HeroInfoControllers;

import hellofx.Controller.MarketController;
import hellofx.Controller.MusicControllers.BruhController;
import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.CoinSoundController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import hellofx.models.FreshChick;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class freshChickInfoController {
    @FXML Label levelLabel;
    @FXML Button backButton;
    @FXML Label levelUpCostLabel;
    @FXML Label hint;
    @FXML Label iceCreamLabel;
    @FXML ProgressBar hpBar;
    @FXML ProgressBar atkBar;
    @FXML ProgressBar speedBar;
    @FXML ProgressBar atkDistance;
    @FXML ProgressBar createEnergy;
    @FXML ProgressBar cdBar;

    @FXML Button levelUpButton;

    private static int levelUpCost = 250;

    @FXML
    public void initialize() throws IOException {
        levelLabel.setText("LEVEL " + String.format("%02d", FreshChick.level + 1));
        levelUpCostLabel.setText(String.format("%04d", levelUpCost));
        iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
        hpBar.setProgress(0.85);
        atkBar.setProgress(0.42);
        speedBar.setProgress(0.7);
        atkDistance.setProgress(0.14);
        createEnergy.setProgress(0.14);
        cdBar.setProgress(0.14);
    }

    public void levelUp() {
        if (FreshChick.level < 9) {
            if (MarketController.iceCreamNum >= levelUpCost && MarketController.iceCreamNum > 0){
                CoinSoundController.soundPlay();
                FreshChick.Levelup();
                MarketController.iceCreamNum -= levelUpCost;
                levelUpCost += 105;
                if (FreshChick.level == 9) {
                    levelLabel.setText("LEVEL MAX");
                    levelUpCostLabel.setText("????????????");
                    hint.setVisible(false);
                }
                else {
                    levelLabel.setText("LEVEL " + String.format("%02d", FreshChick.level + 1));
                    levelUpCostLabel.setText(String.format("%04d", levelUpCost));
                    hint.setText("????????????");
                    hint.setVisible(true);
                }
                iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
            }
            else {
                BruhController.bruhPlay();
                hint.setText("???????????????");
                hint.setVisible(true);
            }
        }
        else {
            BruhController.bruhPlay();
        }
    }

    public void backToDorm() throws IOException {
        ViewController.toDorm();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}
