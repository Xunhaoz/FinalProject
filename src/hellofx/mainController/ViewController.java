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
        nowStageStr = "HeroIntro" ;
    }

    public static void toAd() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/maps/adPage.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓: 敵方圖鑑");
        nowStage.setScene(scene);
        nowStageStr = "EnemyIntro" ;
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
    public static void toSlideDragonInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/enemyInfoPage/slideDragon.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 敵方圖鑑 - 滑龍爺爺");
        nowStage.setScene(scene);
        nowStageStr = "EnemyIntro" ;
    }

    public static void toErhuInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/enemyInfoPage/erhu.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 敵方圖鑑 - 二胡伯伯");
        nowStage.setScene(scene);
        nowStageStr = "EnemyIntro" ;
    }

    public static void toTasInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/enemyInfoPage/tas.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 敵方圖鑑 - 助教ABC");
        nowStage.setScene(scene);
        nowStageStr = "EnemyIntro" ;
    }

    public static void toWongInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/enemyInfoPage/Wong.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 敵方圖鑑 - 王家慶記");
        nowStage.setScene(scene);
        nowStageStr = "EnemyIntro" ;
    }

    public static void toDreamBeeInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/enemyInfoPage/dreamBee.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 行政大樓 - 敵方圖鑑 - 夢蜂");
        nowStage.setScene(scene);
        nowStageStr = "EnemyIntro" ;
    }

    public static void toFreshChickInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/heroInfoPage/freshChick.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 宿舍 - 我方圖鑑 - 大一菜雞");
        nowStage.setScene(scene);
        nowStageStr = "HeroIntro" ;
    }

    public static void toYamsInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/heroInfoPage/yams.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 宿舍 - 我方圖鑑 - 紫薯");
        nowStage.setScene(scene);
        nowStageStr = "HeroIntro" ;
    }

    public static void toSalmonSteakInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/heroInfoPage/salmonSteak.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 宿舍 - 我方圖鑑 - 鮭魚排");
        nowStage.setScene(scene);
        nowStageStr = "HeroIntro" ;
    }

    public static void toElecGodInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/heroInfoPage/elecGod.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 宿舍 - 我方圖鑑 - 電神");
        nowStage.setScene(scene);
        nowStageStr = "HeroIntro" ;
    }

    public static void toAlienThrowingHandInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/heroInfoPage/alienThrowingHand.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 宿舍 - 我方圖鑑 - 外星「投手」");
        nowStage.setScene(scene);
        nowStageStr = "HeroIntro" ;
    }

    public static void toXunhaozBuBuInfoPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewController.class.getResource("../views/heroInfoPage/XunhaozBuBu.fxml")));
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        nowStage.setTitle("資工系大戰爭 - 地圖 - 宿舍 - 我方圖鑑 - 勛皓列車");
        nowStage.setScene(scene);
        nowStageStr = "HeroIntro" ;
    }
}
