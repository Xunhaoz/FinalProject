package hellofx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

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
    public Button firstLevel;
    public ToggleGroup emailSelect;

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

    // 從 settingPage 跳轉至其他畫面
    @FXML
    public void settingToVoice(ActionEvent actionEvent) throws IOException {
        ViewController.toVoice();
    }

    @FXML
    public void voiceToSetting(ActionEvent actionEvent) throws IOException {
        ViewController.toSetting();
    }

    @FXML
    public void settingToInfo(ActionEvent actionEvent) throws IOException {
        ViewController.toInfo();
    }

    @FXML
    public void infoToSetting(ActionEvent actionEvent) throws IOException{
        ViewController.toSetting();
    }

    @FXML
    public void levelToFirstLevel(ActionEvent actionEvent) throws IOException {
        ViewController.toFirstLevel();
    }

    @FXML
    public void firstLevelToLevel(ActionEvent actionEvent) throws IOException {
        ViewController.toLevel();
    }
}