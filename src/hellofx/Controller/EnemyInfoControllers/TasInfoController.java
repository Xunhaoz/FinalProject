package hellofx.Controller.EnemyInfoControllers;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

import static java.lang.Math.abs;

public class TasInfoController {
    @FXML Label tasStory;
    @FXML ProgressBar hpBar;
    @FXML ProgressBar atkBar;
    @FXML ProgressBar speedBar;
    @FXML ProgressBar atkDistance;
    @FXML ProgressBar dropEnergy;
    @FXML ProgressBar dropMoney;
    @FXML ImageView pic;

    private static int tasInfo;

    @FXML
    public void initialize() throws IOException {
        tasInfo = 0;
        tasStory.setText("Hint: 點擊角色左右的箭頭，查看每隻助教的介紹！");
        pic.setImage(new Image("hellofx\\resource\\roleInfo\\tasInfo.png"));
        hpBar.setProgress(0.5);
        atkBar.setProgress(0.5);
        speedBar.setProgress(0.5);
        atkDistance.setProgress(0.5);
        dropEnergy.setProgress(0.5);
        dropMoney.setProgress(0.5);
    }

    public void backToAd()  throws IOException {
        ViewController.toAd();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void turnRight() {
        tasInfo ++;

        if (tasInfo % 4 == 0) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\tasInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.5);
            atkDistance.setProgress(0.5);
            dropEnergy.setProgress(0.5);
            dropMoney.setProgress(0.5);
            tasStory.setText("Hint: 點擊角色左右的箭頭，查看每隻助教的介紹！");
        }
        else if (abs(tasInfo) % 4 == 1) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\taAInfo.png"));
            hpBar.setProgress(0.17);
            atkBar.setProgress(0.3);
            speedBar.setProgress(0.83);
            atkDistance.setProgress(0.17);
            dropEnergy.setProgress(0.17);
            dropMoney.setProgress(0.17);
            tasStory.setText("TaA： 鴨子中的王者，擁有所有鴨子中最大的腦容量，是敵人中智商最高的存在。頭部可以反抗重力，必須帶著重達2頓的帽子固定頭部，所以平時走起路來搖搖晃晃。");
        }
        else if (abs(tasInfo) % 4 == 2) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\taBInfo.png"));
            hpBar.setProgress(0.3);
            atkBar.setProgress(0.3);
            speedBar.setProgress(1.0);
            atkDistance.setProgress(0.3);
            dropEnergy.setProgress(0.3);
            dropMoney.setProgress(0.3);
            tasStory.setText("TaB： 愛好長槍的狐狸，24小時槍不離手，連吃飯、睡覺都要帶著長槍。動作敏捷，是敵人中速度最快的。單發攻擊力不高，但攻擊速度極快，是不可以小看的敵人。");
        }
        else if (abs(tasInfo) % 4 == 3) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\taCInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.67);
            atkDistance.setProgress(0.83);
            dropEnergy.setProgress(0.67);
            dropMoney.setProgress(0.67);
            tasStory.setText("TaC： 強大的戰爭機器，接受過TaA的改造，能藉由懸浮頭部的上下運動蓄力，從眼睛發射高功率的雷射光束，能一次造成遠距離且大範圍的巨大傷害。");
        }
    }

    public void turnLeft() {
        tasInfo --;

        if (abs(tasInfo) % 4 == 0) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\tasInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.5);
            atkDistance.setProgress(0.5);
            dropEnergy.setProgress(0.5);
            dropMoney.setProgress(0.5);
            tasStory.setText("Hint: 點擊角色左右的箭頭，查看每隻助教的介紹！");
        }
        else if (abs(tasInfo) % 4 == 1) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\taAInfo.png"));
            hpBar.setProgress(0.17);
            atkBar.setProgress(0.3);
            speedBar.setProgress(0.83);
            atkDistance.setProgress(0.17);
            dropEnergy.setProgress(0.17);
            dropMoney.setProgress(0.17);
            tasStory.setText("TaA： 鴨子中的王者，擁有所有鴨子中最大的腦容量，是敵人中智商最高的存在。頭部可以反抗重力，必須帶著重達2頓的帽子固定頭部，所以平時走起路來搖搖晃晃。");
        }
        else if (abs(tasInfo) % 4 == 2) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\taBInfo.png"));
            hpBar.setProgress(0.3);
            atkBar.setProgress(0.3);
            speedBar.setProgress(1.0);
            atkDistance.setProgress(0.3);
            dropEnergy.setProgress(0.3);
            dropMoney.setProgress(0.3);
            tasStory.setText("TaB： 愛好長槍的狐狸，24小時槍不離手，連吃飯、睡覺都要帶著長槍。動作敏捷，是敵人中速度最快的。單發攻擊力不高，但攻擊速度極快，是不可以小看的敵人。");
        }
        else if (abs(tasInfo) % 4 == 3) {
            pic.setImage(new Image("hellofx\\resource\\roleInfo\\taCInfo.png"));
            hpBar.setProgress(0.5);
            atkBar.setProgress(0.5);
            speedBar.setProgress(0.67);
            atkDistance.setProgress(0.83);
            dropEnergy.setProgress(0.67);
            dropMoney.setProgress(0.67);
            tasStory.setText("TaC： 強大的戰爭機器，接受過TaA的改造，能藉由懸浮頭部的上下運動蓄力，從眼睛發射高功率的雷射光束，能一次造成遠距離且大範圍的巨大傷害。");
        }
    }
}
