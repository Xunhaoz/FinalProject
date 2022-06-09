package hellofx.Controller;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class RouteController {
    public Button backButton;
    public Button startButton;
    public Button selectButton;
    public Button mailBox;
    public Button level;
    public Button market;
    public Button dorm;
    public Button trash;
    public Button ad;
    public Button firstLevel;
    public Button secondLevel;
    public Button thirdLevel;
    public Label iceCreamLabel;

    public static boolean hasPassword = false;

    @FXML
    public void startToSetting() throws IOException {
        ViewController.toSetting();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void settingToStart() throws IOException {
        ViewController.toStart();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void startToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void mapToStart() throws IOException {
        ViewController.toStart();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void startToMailbox() throws IOException {
        ViewController.toMailbox();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void mapToLevel() throws IOException {
        if (!hasPassword) ViewController.toPass();
        else ViewController.toLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void levelToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void mapToMarket() throws IOException {
        ViewController.toMarket();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void marketToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void mapToTrash() throws IOException {
        ViewController.toTrash();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }



    @FXML
    public void mapToDorm() throws IOException {
        ViewController.toDorm();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }



    @FXML
    public void mapToAd() throws IOException {
        ViewController.toAd();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void adToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void settingToVoice() throws IOException {
        ViewController.toVoice();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void settingToInfo() throws IOException {
        ViewController.toInfo();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void infoToSetting() throws IOException {
        ViewController.toSetting();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void levelToFirstLevel() throws IOException {
        ViewController.toFirstLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void levelToSecondLevel() throws IOException {
        ViewController.toSecondLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void levelToThirdLevel() throws IOException {
        ViewController.toThirdLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    // 從行政大樓到敵人角色介紹
    public void adToSildeDragonInfoPage() throws IOException {
        ViewController.toSlideDragonInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void adToErhuInfoPage() throws IOException {
        ViewController.toErhuInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void adToDreamBeeInfoPage() throws IOException {
        ViewController.toDreamBeeInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void adToTasInfoPage() throws IOException {
        ViewController.toTasInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void adToWongInfoPage() throws IOException {
        ViewController.toWongInfoPage();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }



    public void backToAd()  throws IOException {
        ViewController.toAd();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void backToDorm() throws IOException {
        ViewController.toDorm();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}