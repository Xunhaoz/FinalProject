package hellofx.Controller.HeroInfoControllers;

import hellofx.Controller.MarketController;
import hellofx.Controller.MusicControllers.BruhController;
import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.CoinSoundController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import hellofx.models.FreshChick;
import hellofx.models.Yams;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

import static java.lang.Math.abs;

public class YamsInfoController {
    @FXML ImageView pic;
    @FXML Label yamStory;
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

    private static int levelUpCost = 580;
    private int yamsInfo = 0;

    @FXML
    public void initialize() throws IOException {
        yamsInfo = 0;
        levelLabel.setText("LEVEL " + String.format("%02d", Yams.level + 1));
        levelUpCostLabel.setText(String.format("%04d", levelUpCost));
        iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
        hpBar.setProgress(0.5);
        atkBar.setProgress(0.5);
        speedBar.setProgress(0.5);
        atkDistance.setProgress(0.5);
        createEnergy.setProgress(0.5);
        cdBar.setProgress(0.5);
    }

    public void levelUp() {
        if (Yams.level < 9) {
            if (MarketController.iceCreamNum >= levelUpCost && MarketController.iceCreamNum > 0){
                CoinSoundController.soundPlay();
                Yams.Levelup();
                MarketController.iceCreamNum -= levelUpCost;
                levelUpCost += 105;
                if (Yams.level == 9) {
                    levelLabel.setText("LEVEL MAX");
                    levelUpCostLabel.setText("????????????");
                    hint.setVisible(false);
                }
                else {
                    levelLabel.setText("LEVEL " + String.format("%02d", Yams.level + 1));
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

    public void turnRight() {
        yamsInfo ++;

        if (abs(yamsInfo) % 4 == 0) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\yamsInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.5);
            atkDistance.setProgress(0.5);
            createEnergy.setProgress(0.5);
            cdBar.setProgress(0.5);
            yamStory.setText("Hint: ????????????????????????????????????????????????????????????");
        }
        else if (abs(yamsInfo) % 4 == 1) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\excellentYamInfo.png"));
            hpBar.setProgress(0.42);
            atkBar.setProgress(0.7);
            speedBar.setProgress(0.42);
            atkDistance.setProgress(1.0);
            createEnergy.setProgress(0.57);
            cdBar.setProgress(0.42);
            yamStory.setText("????????????????????????????????????????????????????????????????????????????????????");
        }
        else if (abs(yamsInfo) % 4 == 2) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\regularYamInfo.png"));
            hpBar.setProgress(0.7);
            atkBar.setProgress(0.57);
            speedBar.setProgress(0.7);
            atkDistance.setProgress(0.85);
            createEnergy.setProgress(0.57);
            cdBar.setProgress(0.42);
            yamStory.setText("???????????????????????????????????????????????????????????????????????????");
        }
        else if (abs(yamsInfo) % 4 == 3) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\badYamInfo.png"));
            hpBar.setProgress(0.28);
            atkBar.setProgress(0.14);
            speedBar.setProgress(0.85);
            atkDistance.setProgress(0.42);
            createEnergy.setProgress(0.57);
            cdBar.setProgress(0.42);
            yamStory.setText("??????????????????????????????????????????????????????????????????????????????");
        }
    }

    public void turnLeft() {
        yamsInfo --;

        if (abs(yamsInfo) % 4 == 0) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\yamsInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.5);
            atkDistance.setProgress(0.5);
            createEnergy.setProgress(0.5);
            cdBar.setProgress(0.5);
            yamStory.setText("Hint: ????????????????????????????????????????????????????????????");
        }
        else if (abs(yamsInfo) % 4 == 1) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\excellentYamInfo.png"));
            hpBar.setProgress(0.42);
            atkBar.setProgress(0.7);
            speedBar.setProgress(0.42);
            atkDistance.setProgress(1.0);
            createEnergy.setProgress(0.57);
            cdBar.setProgress(0.42);
            yamStory.setText("????????????????????????????????????????????????????????????????????????????????????");
        }
        else if (abs(yamsInfo) % 4 == 2) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\regularYamInfo.png"));
            hpBar.setProgress(0.7);
            atkBar.setProgress(0.57);
            speedBar.setProgress(0.7);
            atkDistance.setProgress(0.85);
            createEnergy.setProgress(0.57);
            cdBar.setProgress(0.42);
            yamStory.setText("???????????????????????????????????????????????????????????????????????????");
        }
        else if (abs(yamsInfo) % 4 == 3) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\badYamInfo.png"));
            hpBar.setProgress(0.28);
            atkBar.setProgress(0.14);
            speedBar.setProgress(0.85);
            atkDistance.setProgress(0.42);
            createEnergy.setProgress(0.57);
            cdBar.setProgress(0.42);
            yamStory.setText("??????????????????????????????????????????????????????????????????????????????");
        }
    }
}
