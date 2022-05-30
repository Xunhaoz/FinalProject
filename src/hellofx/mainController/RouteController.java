package hellofx.mainController;

import hellofx.MusicControllers.MusicPlayController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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

    @FXML
    public void startToSetting() throws IOException {
        ViewController.toSetting();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void settingToStart() throws IOException {
        ViewController.toStart();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void startToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void mapToStart() throws IOException {
        ViewController.toStart();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void startToMailbox() throws IOException {
        ViewController.toMailbox();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void mapToLevel() throws IOException {
        ViewController.toLevel();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void levelToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void mapToMarket() throws IOException {
        ViewController.toMarket();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void marketToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void mapToTrash() throws IOException {
        ViewController.toTrash();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void trashToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void mapToDorm() throws IOException {
        ViewController.toDorm();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void dormToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void mapToAd() throws IOException {
        ViewController.toAd();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void adToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void settingToVoice() throws IOException {
        ViewController.toVoice();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void settingToInfo() throws IOException {
        ViewController.toInfo();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void infoToSetting() throws IOException {
        ViewController.toSetting();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void levelToFirstLevel() throws IOException {
        ViewController.toFirstLevel();
        MusicPlayController.checkNowStage();
    }

    public void levelToSecondLevel() throws IOException {
        ViewController.toSecondLevel();
        MusicPlayController.checkNowStage();
    }

    public void levelToThirdLevel() throws IOException {
        ViewController.toThirdLevel();
        MusicPlayController.checkNowStage();
    }

    // 從行政大樓到敵人角色介紹
    public void adToSildeDragonInfoPage() throws IOException {
        ViewController.toSlideDragonInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void adToErhuInfoPage() throws IOException {
        ViewController.toErhuInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void adToDreamBeeInfoPage() throws IOException {
        ViewController.toDreamBeeInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void adToTasInfoPage() throws IOException {
        ViewController.toTasInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void adToWongInfoPage() throws IOException {
        ViewController.toWongInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void dormToFreshChickInfoPage() throws IOException {
        ViewController.toFreshChickInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void dormToSalmonSteakInfoPage() throws IOException {
        ViewController.toSalmonSteakInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void dormToYamsInfoPage() throws IOException {
        ViewController.toYamsInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void dormToElecGodInfoPage() throws IOException {
        ViewController.toElecGodInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void dormToXunhoazBuBuInfoPage() throws IOException {
        ViewController.toXunhaozBuBuInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void dormToAlienThrowingHandInfoPage() throws IOException {
        ViewController.toAlienThrowingHandInfoPage();
        MusicPlayController.checkNowStage();
    }

    public void backToAd()  throws IOException {
        ViewController.toAd();
        MusicPlayController.checkNowStage();
    }

    public void backToDorm() throws IOException {
        ViewController.toDorm();
        MusicPlayController.checkNowStage();
    }
}