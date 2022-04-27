package hellofx.controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewController {
    public static Stage nowStage;

    public static void toSetting() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/settingPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 設定選項");
        nowStage.setScene(scene);
    }

    public static void toMap() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/mapPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖");
        nowStage.setScene(scene);
    }

    public static void toStart() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/startPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 起始畫面");
        nowStage.setScene(scene);
    }

    public static void toMailbox() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/mailboxPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 信箱");
        nowStage.setScene(scene);
    }

    public static void toLevel() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/levelPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 工程五館 - 關卡選擇");
        nowStage.setScene(scene);
    }

    public static void toMarket() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/marketPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 市集 - 購買道具");
        nowStage.setScene(scene);
    }

    public static void toTrash() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/trashPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 垃圾場 - 隱藏功能");
        nowStage.setScene(scene);
    }

    public static void toDorm() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/dormPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 宿舍 - 我方圖鑑");
        nowStage.setScene(scene);
    }

    public static void toAd() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/adPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 敵方圖鑑");
        nowStage.setScene(scene);
    }

    public static void toVoice() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/voicePage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 選項 - 音量控制");
        nowStage.setScene(scene);
    }

    public static void toInfo() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/infoPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 選項 - 開發人員");
        nowStage.setScene(scene);
    }
}

