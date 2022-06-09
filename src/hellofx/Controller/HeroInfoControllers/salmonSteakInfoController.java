package hellofx.Controller.HeroInfoControllers;

import hellofx.Controller.MarketController;
import hellofx.Controller.MusicControllers.BruhController;
import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.CoinSoundController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import hellofx.models.FreshChick;
import hellofx.models.SalmonSteak;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class salmonSteakInfoController {
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

    private static int levelUpCost = 375;

    @FXML
    public void initialize() throws IOException {
        levelLabel.setText("LEVEL " + String.format("%02d", SalmonSteak.level + 1));
        levelUpCostLabel.setText(String.format("%04d", levelUpCost));
        iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
        hpBar.setProgress(1.0);
        atkBar.setProgress(0.28);
        speedBar.setProgress(0.28);
        atkDistance.setProgress(0.14);
        createEnergy.setProgress(0.42);
        cdBar.setProgress(0.28);
    }

    public void levelUp() {
        if (SalmonSteak.level < 9) {
            if (MarketController.iceCreamNum >= levelUpCost && MarketController.iceCreamNum > 0){
                CoinSoundController.soundPlay();
                SalmonSteak.Levelup();
                MarketController.iceCreamNum -= levelUpCost;
                levelUpCost += 145;
                if (SalmonSteak.level == 9) {
                    levelLabel.setText("LEVEL MAX");
                    levelUpCostLabel.setText("已達上限");
                    hint.setVisible(false);
                }
                else {
                    levelLabel.setText("LEVEL " + String.format("%02d", SalmonSteak.level + 1));
                    levelUpCostLabel.setText(String.format("%04d", levelUpCost));
                    hint.setText("升級成功");
                }
                iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
            }
            else {
                BruhController.bruhPlay();
                hint.setText("冰淇淋不足");
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
