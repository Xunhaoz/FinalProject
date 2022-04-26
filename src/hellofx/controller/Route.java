package hellofx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Route{
    public Button backButton;
    public Button startButton;
    public Button selectButton;
    public Button mailBox;
    public Button level;
    public Button market;
    public Button dorm;
    public Button trash;
    public Button ad;

    // 從 startPage 跳轉至其他頁面再跳回來的部分
    @FXML
    public void startToSetting() throws IOException {
        ViewController.toSetting();
    }

    @FXML
    public void settingToStart() throws IOException {
        ViewController.toStart();
    }

    @FXML
    public void startToMap() throws IOException {
        ViewController.toMap();
    }

    @FXML
    public void mapToStart() throws IOException {
        ViewController.toStart();
    }

    @FXML
    public void startToMailbox() throws IOException {
        ViewController.toMailbox();
    }

    @FXML
    public void mailboxToStart() throws IOException {
        ViewController.toStart();
    }

    // 從 mapPage 跳轉至其他頁面再跳回來的部分
    @FXML
    public void mapToLevel() throws IOException {
        ViewController.toLevel();
    }

    @FXML
    public void levelToMap() throws IOException {
        ViewController.toMap();
    }

    @FXML
    public void mapToMarket() throws IOException {
        ViewController.toMarket();
    }

    @FXML
    public void marketToMap() throws IOException {
        ViewController.toMap();
    }

    @FXML
    public void mapToTrash() throws IOException {
        ViewController.toTrash();
    }

    @FXML
    public void trashToMap() throws IOException {
        ViewController.toMap();
    }

    @FXML
    public void mapToDorm() throws IOException {
        ViewController.toDorm();
    }

    @FXML
    public void dormToMap() throws IOException {
        ViewController.toMap();
    }

    @FXML
    public void mapToAd() throws IOException {
        ViewController.toAd();
    }

    @FXML
    public void adToMap() throws IOException {
        ViewController.toMap();
    }
}