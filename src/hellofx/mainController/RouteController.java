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

}