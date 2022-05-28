package hellofx.mainController;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewController {
    public static Stage nowStage;
    public static String nowStageStr ;

    public static void toSetting() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/settings/settingPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 選項");
        nowStage.setScene(scene);
        nowStageStr = "setting" ;
    }

    public static void toMap() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/maps/mapPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖");
        nowStage.setScene(scene);
        nowStageStr = "start" ;
    }

    public static void toStart() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/startPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 歡迎來到資工大戰爭");
        nowStage.setScene(scene);
        nowStageStr = "start" ;
    }

    public static void toMailbox() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/mailboxPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 信箱");
        nowStage.setScene(scene);
        nowStageStr = "mailbox" ;
    }

    public static void toLevel() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/maps/levelPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 工程五館: 關卡選擇");
        nowStage.setScene(scene);
        nowStageStr = "level" ;
    }

    public static void toMarket() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/maps/marketPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 市集: 購買道具");
        nowStage.setScene(scene);
        nowStageStr = "market" ;
    }

    public static void toTrash() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/maps/trashPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 垃圾場: 隱藏功能");
        nowStage.setScene(scene);
        nowStageStr = "trash" ;
    }

    public static void toDorm() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/maps/dormPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 宿舍: 我方圖鑑");
        nowStage.setScene(scene);
        nowStageStr = "dorm" ;
    }

    public static void toAd() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/maps/adPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓: 敵方圖鑑");
        nowStage.setScene(scene);
        nowStageStr = "ad" ;
    }

    public static void toVoice() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/settings/voicePage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 選項 - 音量控制");
        nowStage.setScene(scene);
        nowStageStr = "setting" ;
    }

    public static void toInfo() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/settings/infoPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 選項 - 開發人員");
        nowStage.setScene(scene);
        nowStageStr = "setting" ;
    }

    public static void toFirstLevel() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/games/firstLevelPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 工程五館 - 第一關");
        nowStage.setScene(scene);
        nowStageStr = "firstLevel" ;
    }
    public static void toPage_1() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/maps/dorm1/dor_1.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 腳色介紹 - p1");
        nowStage.setScene(scene);
        nowStageStr = "characterIntro" ;
    }
    public static void toPage_2() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/maps/dorm1/dor_1.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 腳色介紹 - p2");
        nowStage.setScene(scene);
        nowStageStr = "characterIntro" ;
    }
    public static void toPage_3() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/dorm1/dor_1.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 腳色介紹 - p3");
        nowStage.setScene(scene);
        nowStageStr = "characterIntro" ;
    }
    public static void toPage_4() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/dorm1/dor_1.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 腳色介紹 - p4");
        nowStage.setScene(scene);
        nowStageStr = "characterIntro" ;
    }

}
