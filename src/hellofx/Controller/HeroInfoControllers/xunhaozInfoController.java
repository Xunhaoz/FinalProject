package hellofx.Controller.HeroInfoControllers;

import hellofx.Controller.MarketController;
import hellofx.Controller.MusicControllers.BruhController;
import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.CoinSoundController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import hellofx.models.FreshChick;
import hellofx.models.Xunhaoz;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class xunhaozInfoController {
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

    private static int levelUpCost = 1115;

    @FXML
    public void initialize() throws IOException {
        levelLabel.setText("LEVEL " + String.format("%02d", Xunhaoz.level + 1));
        levelUpCostLabel.setText(String.format("%04d", levelUpCost));
        iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
        hpBar.setProgress(0.14);
        atkBar.setProgress(0.85);
        speedBar.setProgress(1.0);
        atkDistance.setProgress(0.14);
        createEnergy.setProgress(0.85);
        cdBar.setProgress(0.70);
    }

    public void levelUp() {
        if (Xunhaoz.level < 9) {
            if (MarketController.iceCreamNum >= levelUpCost && MarketController.iceCreamNum > 0){
                CoinSoundController.soundPlay();
                Xunhaoz.Levelup();
                MarketController.iceCreamNum -= levelUpCost;
                levelUpCost += 185;
                if (Xunhaoz.level == 9) {
                    levelLabel.setText("LEVEL MAX");
                    levelUpCostLabel.setText("已達上限");
                    hint.setVisible(false);
                }
                else {
                    levelLabel.setText("LEVEL " + String.format("%02d", Xunhaoz.level + 1));
                    levelUpCostLabel.setText(String.format("%04d", levelUpCost));
                    hint.setText("升級成功");
                    hint.setVisible(true);
                }
                iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
            }
            else {
                BruhController.bruhPlay();
                hint.setText("冰淇淋不足");
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
