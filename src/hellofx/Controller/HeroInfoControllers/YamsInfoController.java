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
            CoinSoundController.soundPlay();
            if (MarketController.iceCreamNum >= levelUpCost && MarketController.iceCreamNum > 0){
                Yams.Levelup();
                MarketController.iceCreamNum -= levelUpCost;
                levelUpCost += 105;
                if (Yams.level == 9) {
                    levelLabel.setText("LEVEL MAX");
                    levelUpCostLabel.setText("已達上限");
                    hint.setVisible(false);
                }
                else {
                    levelLabel.setText("LEVEL " + String.format("%02d", Yams.level + 1));
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

    public void turnRight() {
        yamsInfo ++;

        if (yamsInfo % 4 == 0) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\yamsInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.5);
            atkDistance.setProgress(0.5);
            createEnergy.setProgress(0.5);
            cdBar.setProgress(0.5);
        }
        else if (abs(yamsInfo) % 4 == 1) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\excellentYamInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.2);
            speedBar.setProgress(0.2);
            atkDistance.setProgress(0.2);
            createEnergy.setProgress(0.5);
            cdBar.setProgress(0.5);
        }
        else if (abs(yamsInfo) % 4 == 2) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\regularYamInfo.png"));
            hpBar.setProgress(0.4);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.5);
            atkDistance.setProgress(0.5);
            createEnergy.setProgress(0.5);
            cdBar.setProgress(0.5);
        }
        else if (abs(yamsInfo) % 4 == 3) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\badYamInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.5);
            atkDistance.setProgress(0.6);
            createEnergy.setProgress(0.5);
            cdBar.setProgress(0.5);
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
            yamStory.setText("Hint: 點擊角色左右的箭頭，查看每隻紫薯的介紹！");
        }
        else if (abs(yamsInfo) % 4 == 1) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\excellentYamInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.2);
            speedBar.setProgress(0.2);
            atkDistance.setProgress(0.2);
            createEnergy.setProgress(0.5);
            cdBar.setProgress(0.5);
            yamStory.setText("高級紫薯：神獸珍貴般的存在，讓天選之雞們打遍天下無敵手。");
        }
        else if (abs(yamsInfo) % 4 == 2) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\regularYamInfo.png"));
            hpBar.setProgress(0.4);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.5);
            atkDistance.setProgress(0.5);
            createEnergy.setProgress(0.5);
            cdBar.setProgress(0.5);
            yamStory.setText("普通紫薯：菜雞雞品尚可，期中期末給菜雞們補補雞血。");
        }
        else if (abs(yamsInfo) % 4 == 3) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\badYamInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.5);
            atkDistance.setProgress(0.6);
            createEnergy.setProgress(0.5);
            cdBar.setProgress(0.5);
            yamStory.setText("混混紫薯：擁有此紫薯乃小菜雞之人生大不幸，哀哉哀哉。");
        }
    }
}
