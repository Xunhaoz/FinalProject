package hellofx.Controller.gameControllers;

import hellofx.Controller.MarketController;
import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.LANLANRUController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.MusicControllers.CoinSoundController;
import hellofx.Controller.ViewController;
import hellofx.models.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class secondLevelController extends LevelController {
    private boolean working = false;
    private int ranWork;
    private int workTime;
    public Button backButton;
    public ProgressBar csieTowerHP;
    public ProgressBar grandpaTowerHP;
    public Label csieHealthLable;
    public Label grandpaHealthLable;
    public ImageView economicImg;
    public ImageView fastFoodImg;
    public ImageView yamsImg;
    public Label ecoLvpNeed;
    public Label hint;

    private int money = 500; // need to be modified to 0
    private CSIETower csieTower;
    private GrandpaTower grandpaTower;
    final private ArrayList<FreshChick> freshChickAL = new ArrayList<>();
    final private ArrayList<SalmonSteak> salmonSteaksAL = new ArrayList<>();
    final private ArrayList<Yams> yamsAL = new ArrayList<>();
    final private ArrayList<AlienThrowingHand> alienAL = new ArrayList<>();
    final private ArrayList<Xunhaoz> xunhaozAL = new ArrayList<>();
    final private ArrayList<TaA> taAAL = new ArrayList<>();
    final private ArrayList<TaB> taBAL = new ArrayList<>();
    final private ArrayList<TaC> taCAL = new ArrayList<>();
    final private ArrayList<DreamBee> dreamBeeAL = new ArrayList<>();
    final private Random randomInt = new Random();
    private int csieTowerHealth;
    private int grandpaTowerHealth;
    private int enemyCreateRate = 0;
    private int iceCream = 0;
    private boolean hasBoss = false;
    private int fastFoodShoot = 0;
    private AtomicInteger countUp = new AtomicInteger(0);
    private boolean allTimelineStop;
    private boolean []canCreate = {true, true, true, true, true};
    //createYams creatXunhaoz createFreshChick createAlienThrowingHand createSalmonSteak

    @FXML
    Label iceCreamLabel;
    @FXML
    Label labelMax;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Label label;
    @FXML
    Button levelButton;

    private final Timeline levelOneTimeline = new Timeline(new KeyFrame(Duration.millis(200), e -> {
        this.enemyCreateRate++;
        this.money += moneyRate;
        iceCreamLabel.setText(String.format("%05d", iceCream));

        if (this.countUp.incrementAndGet() % 10 == 0 && fastFoodShoot < 10) {
            fastFoodShoot += 1;
            fastFoodImg.setImage(new Image("hellofx\\resource\\gameButton\\boom\\boom" + fastFoodShoot + ".png"));
        }

        if (money < moneyMax) {
            label.setText(String.format("%04d", money));
        } else {
            label.setText(String.format("%04d", moneyMax));
            money = moneyMax;
        }
        csieHealthLable.setText(csieTower.getHealth() + " / " + csieTowerHealth);
        grandpaHealthLable.setText(grandpaTower.getHealth() + " / " + grandpaTowerHealth);
        csieTowerHP.setProgress((double) csieTower.getHealth() / csieTowerHealth);
        grandpaTowerHP.setProgress((double) grandpaTower.getHealth() / grandpaTowerHealth);
        statusDetector();

        int ranInt = randomInt.nextInt(1000);
        if (ranInt % 25 == 0 && enemyCreateRate % 11 != 0) {
            createTaA();
        } else if (ranInt % 267 == 0 && enemyCreateRate % 13 != 0 && enemyCreateRate > 50) {
            createTaB();
        } else if (ranInt % 401 == 0 && enemyCreateRate % 17 != 0 && enemyCreateRate > 500) {
            createTaC();
        }

        if (enemyCreateRate % 100 == 0) {
            createTaA();
        } else if (enemyCreateRate % 100 == 20) {
            createTaB();
        } else if (enemyCreateRate % 100 == 30) {
            createTaC();
        } else if (csieTower.getHealth() <= csieTowerHealth * 2 / 3 && !hasBoss) {
            hasBoss = true;
            createDreamBee();
            for (FreshChick freshChick : freshChickAL) freshChick.lag();
            for (SalmonSteak salmonSteak : salmonSteaksAL) salmonSteak.lag();
            hint.setText("夢蜂華麗登場，施展催眠鱗粉，讓所有小菜雞和鮭魚排進入睡眠狀態！！！");
            hint.setVisible(true);
        }

        if (csieTower.getHealth() <= 0) {
            allTimelineStop = true;
            statusDetector();
            try {
                this.win();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (grandpaTower.getHealth() <= 0) {
            allTimelineStop = true;
            statusDetector();
            try {
                this.lose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }));

    @FXML
    public void initialize() throws IOException {
        allTimelineStop = false;
        working = false;

        iceCream = 0;
        iceCreamLabel.setText(String.format("%05d", iceCream));

        ecoLvpNeed.setText(String.valueOf(moneyMax / 2));

        csieTower = new CSIETower(0, 180);
        grandpaTower = new GrandpaTower(2300, 180);

        csieTower.setBounds();
        grandpaTower.setBounds();

        csieTower.chHealth(40000);
        csieTowerHealth = csieTower.getHealth();
        grandpaTowerHealth = grandpaTower.getHealth();

        csieTower.move();
        grandpaTower.move();

        anchorPane.getChildren().addAll(csieTower.getImageview(), grandpaTower.getImageview());

        moneyLevel = 1;
        labelMax.setText(Integer.toString(moneyMax));

        levelOneTimeline.setCycleCount(Timeline.INDEFINITE);
        levelOneTimeline.play();
    }

    @FXML
    public void createTaA() {
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        TaA taA = new TaA(140, 420 + ranInt);
        taAAL.add(taA);
        taA.portal(1);
        anchorPane.getChildren().add(taA.getImageview());
        taA.setBounds();
    }

    @FXML
    public void createTaB() {
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        TaB taB = new TaB(140, 360 + ranInt);
        taBAL.add(taB);
        taB.portal(1);
        anchorPane.getChildren().add(taB.getImageview());
        taB.setBounds();
    }

    @FXML
    public void createTaC() {
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        TaC taC = new TaC(140, 290 + ranInt);
        taCAL.add(taC);
        taC.portal(1);
        anchorPane.getChildren().add(taC.getImageview());
        taC.setBounds();
    }

    @FXML
    public void createDreamBee() {
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        DreamBee dreamBee = new DreamBee(40, 20+ ranInt);
        dreamBeeAL.add(dreamBee);
        dreamBee.portal(1);
        anchorPane.getChildren().add(dreamBee.getImageview());
        dreamBee.setBounds();
    }

    @FXML
    public void createYams() {
        if (Integer.parseInt(label.getText()) < 225 || !canCreate[0]){
            if (Integer.parseInt(label.getText()) < 225 && canCreate[0]) hint.setText("能量不足，無法召喚紫薯家族");
            else hint.setText("紫薯家族冷卻中");
            hint.setVisible(true);
            return;
        }
        hint.setVisible(false);
        money -= 225;
        int ranCharacter = randomInt.nextInt(100) % 3;
        Yams yams = new Yams(2300, 355 + (randomInt.nextInt(4) - 2) * 10, ranCharacter);
        if (ranCharacter == 0) {
            hint.setText("場上的小菜雞被混混紫薯帶壞，生命值和攻擊力大幅減少");
            hint.setVisible(true);
            for (FreshChick freshChick : freshChickAL) freshChick.addBuff(-50, -10);
        }
        else if (ranCharacter == 1) {
            hint.setText("九天玄女唯一指定高級紫薯降肉，小菜雞生命值和攻擊力大幅增加");
            hint.setVisible(true);
            for (FreshChick freshChick : freshChickAL) freshChick.addBuff(200, 10);
        }
        else {
            hint.setText("場上的小菜雞收到普通紫薯的歐趴糖，生命值和攻擊力小幅增加");
            hint.setVisible(true);
            for (FreshChick freshChick : freshChickAL) freshChick.addBuff(100, 8);
        }
        String[] yamsName = {"badRoll", "excellentRoll", "regularRoll", "yamsRoll"};
        Timeline yamsTimeline = new Timeline();
        for (int i = 1; i < 12; i++) {
            if (i < 7) {
                KeyFrame keyFrame = new KeyFrame(new Duration(i * 200), new KeyValue(yamsImg.imageProperty(), new Image("hellofx\\resource\\gameButton\\YamsButtons\\yamsRoll" + i + ".png")));
                yamsTimeline.getKeyFrames().add(keyFrame);
            } else if (i < 11) {
                KeyFrame keyFrame = new KeyFrame(new Duration(i * 200), new KeyValue(yamsImg.imageProperty(), new Image("hellofx\\resource\\gameButton\\YamsButtons\\" + yamsName[ranCharacter] + (i - 6) + ".png")));
                yamsTimeline.getKeyFrames().add(keyFrame);
            } else {
                KeyFrame keyFrame = new KeyFrame(new Duration(i * 200), new KeyValue(yamsImg.imageProperty(), new Image("hellofx\\resource\\role\\Hero\\yams\\miniYams.png")));
                yamsTimeline.getKeyFrames().add(keyFrame);
            }
        }
        yamsTimeline.play();

        yamsAL.add(yams);
        yams.portal(1);
        anchorPane.getChildren().add(yams.getImageview());
        yams.setBounds();
        Timeline CDtimeline = new Timeline();
        KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO, e->{canCreate[0] = false;});
        KeyFrame endKeyFrame = new KeyFrame(new Duration(yams.getCD()*200), e->{canCreate[0] = true;});
        CDtimeline.getKeyFrames().addAll(startKeyFrame, endKeyFrame);
        CDtimeline.play();
    }

    @FXML
    public void creatXunhaoz() {
        if (Integer.parseInt(label.getText()) < 275 || !canCreate[1]) {
            if (Integer.parseInt(label.getText()) < 275 && canCreate[1]) hint.setText("能量不足，無法召喚勛號列車");
            else hint.setText("勛號列車冷卻中");
            hint.setVisible(true);
            return;
        }
        hint.setVisible(false);
        money -= 275;
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        Xunhaoz xunhaoz = new Xunhaoz(2300, 420 + ranInt);
        xunhaozAL.add(xunhaoz);
        xunhaoz.portal(1);
        anchorPane.getChildren().add(xunhaoz.getImageview());
        xunhaoz.setBounds();
        Timeline CDtimeline = new Timeline();
        KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO, e->{canCreate[1] = false;});
        KeyFrame endKeyFrame = new KeyFrame(new Duration(xunhaoz.getCD()*200), e->{canCreate[1] = true;});
        CDtimeline.getKeyFrames().addAll(startKeyFrame, endKeyFrame);
        CDtimeline.play();
    }

    @FXML
    public void createFreshChick() {
        if (Integer.parseInt(label.getText()) < 50 || !canCreate[2]) {
            if (Integer.parseInt(label.getText()) < 50 && canCreate[2]) hint.setText("能量不足，無法召喚小菜雞");
            else hint.setText("小菜雞冷卻中");
            hint.setVisible(true);
            return;
        }
        hint.setVisible(false);
        money -= 50;
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        FreshChick freshChick = new FreshChick(2300, 420 + ranInt);
        freshChickAL.add(freshChick);
        freshChick.portal(1);
        anchorPane.getChildren().add(freshChick.getImageview());
        freshChick.setBounds();
        Timeline CDtimeline = new Timeline();
        KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO, e->{canCreate[2] = false;});
        KeyFrame endKeyFrame = new KeyFrame(new Duration(freshChick.getCD()*200), e->{canCreate[2] = true;});
        CDtimeline.getKeyFrames().addAll(startKeyFrame, endKeyFrame);
        CDtimeline.play();
    }

    @FXML
    public void createAlienThrowingHand() {
        if (Integer.parseInt(label.getText()) < 425 || !canCreate[3]) {
            if (Integer.parseInt(label.getText()) < 425 && canCreate[3]) hint.setText("能量不足，無法召喚外星「投手」");
            else hint.setText("外星「投手」冷卻中");
            hint.setVisible(true);
            return;
        }
        hint.setVisible(false);
        money -= 425;
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        AlienThrowingHand alienThrowingHand = new AlienThrowingHand(1900, 60 + ranInt);
        alienThrowingHand.portal(1);
        alienAL.add(alienThrowingHand);
        anchorPane.getChildren().add(alienThrowingHand.getImageview());
        alienThrowingHand.setBounds();

        Timeline CDtimeline = new Timeline();
        KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO, e->{canCreate[3] = false;});
        KeyFrame endKeyFrame = new KeyFrame(new Duration(alienThrowingHand.getCD()*200), e->{canCreate[3] = true;});
        CDtimeline.getKeyFrames().addAll(startKeyFrame, endKeyFrame);
        CDtimeline.play();
    }

    @FXML
    public void createSalmonSteak() {
        if (Integer.parseInt(label.getText()) < 100 || !canCreate[4]) {
            if (Integer.parseInt(label.getText()) < 100 && canCreate[4]) hint.setText("能量不足，無法召喚鮭魚排");
            else hint.setText("鮭魚排冷卻中");
            hint.setVisible(true);
            return;
        }
        hint.setVisible(false);
        money -= 100;
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        SalmonSteak salmonSteak = new SalmonSteak(2300, 340 + ranInt);
        salmonSteaksAL.add(salmonSteak);
        salmonSteak.portal(1);
        anchorPane.getChildren().add(salmonSteak.getImageview());
        salmonSteak.setBounds();
        Timeline CDtimeline = new Timeline();
        KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO, e->{canCreate[4] = false;});
        KeyFrame endKeyFrame = new KeyFrame(new Duration(salmonSteak.getCD()*200), e->{canCreate[4] = true;});
        CDtimeline.getKeyFrames().addAll(startKeyFrame, endKeyFrame);
        CDtimeline.play();
    }

    public void win() throws IOException {
        WinPageController.winIceCream = iceCream;
        MarketController.iceCreamNum += iceCream;
        levelOneTimeline.stop();
        ViewController.toWin();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void lose() throws IOException {
        levelOneTimeline.stop();
        ViewController.toLose();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void levelTwoToLevel() throws IOException {
        allTimelineStop = true;
        statusDetector();
        levelOneTimeline.stop();
        ViewController.toLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void statusDetector() {
        for (int i = 0; i < freshChickAL.size(); i++) {
            FreshChick freshChick = freshChickAL.get(i);

            if (freshChick.getHealth() < 0 || allTimelineStop) {

                freshChick.portal(3);

                if (freshChick.getCanDie()) {
                    anchorPane.getChildren().remove(freshChick.getImageview());
                    freshChick.stopTimeline();
                    freshChickAL.remove(i);
                }
            } else if (freshChick.getBounds().intersects(csieTower.getBounds())) {

                freshChick.portal(2);

                if (freshChick.getCanAttack()) {
                    csieTower.minusHealth(freshChick.getATK());
                    freshChick.initCanAttack();
                }
            } else {

                boolean isDetect = false;
                for (int j = 0; j < taAAL.size(); j++) {
                    TaA taA = taAAL.get(j);
                    if (freshChick.getBounds().intersects(taA.getBounds()) && taA.getStatus() != 3) {
                        isDetect = true;
                        freshChick.portal(2);
                        if (freshChick.getCanAttack()) {
                            taA.minusHealth(freshChick.getATK());
                            freshChick.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < taBAL.size(); j++) {
                    TaB taB = taBAL.get(j);
                    int distance = freshChick.getX() - taB.getX();
                    if (distance > 0 && distance < 164 && taB.getStatus() != 3) {
                        isDetect = true;
                        freshChick.portal(2);
                        if (freshChick.getCanAttack()) {
                            taB.minusHealth(freshChick.getATK());
                            freshChick.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < taCAL.size(); j++) {
                    TaC taC = taCAL.get(j);
                    int distance = freshChick.getX() - taC.getX();
                    if (distance > 0 && distance < 180 && taC.getStatus() != 3) {
                        isDetect = true;
                        freshChick.portal(2);
                        if (freshChick.getCanAttack()) {
                            taC.minusHealth(freshChick.getATK());
                            freshChick.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < dreamBeeAL.size(); j++) {
                    DreamBee dreamBee = dreamBeeAL.get(j);
                    int distance = freshChick.getX() - dreamBee.getX();
                    if (distance > 0 && distance < 293 && dreamBee.getStatus() != 3) {
                        isDetect = true;
                        freshChick.portal(2);
                        if (freshChick.getCanAttack()) {
                            dreamBee.minusHealth(freshChick.getATK());
                            freshChick.initCanAttack();
                        }
                    }
                }
                if (isDetect) continue;

                freshChick.portal(1);
            }
        }

        for (int i = 0; i < xunhaozAL.size(); i++) {
            Xunhaoz xunhaoz = xunhaozAL.get(i);

            if (xunhaoz.getHealth() < 0 || allTimelineStop || xunhaoz.getX() == -200) {

                xunhaoz.portal(3);

                if (xunhaoz.getCanDie()) {
                    anchorPane.getChildren().remove(xunhaoz.getImageview());
                    xunhaoz.stopTimeline();
                    alienAL.remove(i);
                }
            } else if (xunhaoz.getBounds().intersects(csieTower.getBounds())) {
                if (working && enemyCreateRate > workTime + 20) ranWork = randomInt.nextInt(100) % 3;
                if (enemyCreateRate > workTime + 24) working = false;

                if (ranWork == 0) {
                    if(!working) workTime = enemyCreateRate;
                    working = true;
                }
                else {
                    working = false;
                }

                if (working) xunhaoz.portal(2);
                else {
                    hint.setText("勛號列車什麼都沒做，恭喜你浪費了 275 點「歡樂爺爺速食能量」");
                    hint.setVisible(true);
                    xunhaoz.portal(1);
                }

                if (xunhaoz.getCanAttack()) {
                    int buff = randomInt.nextInt(3) + 1;
                    csieTower.minusHealth(xunhaoz.getATK() * buff);
                    hint.setText("勛號列車做事了，對「CSIE喵喵塔」造成 " + String.valueOf(xunhaoz.getATK() * buff) + " 點傷害");
                    hint.setVisible(true);
                    xunhaoz.initCanAttack();
                }
            } else {
                boolean isDetect = false;
                xunhaoz.portal(1);
            }
        }

        for (int i = 0; i < alienAL.size(); i++) {
            AlienThrowingHand alienThrowingHand = alienAL.get(i);

            if (alienThrowingHand.getHealth() < 0 || allTimelineStop) {

                alienThrowingHand.portal(3);

                if (alienThrowingHand.getCanDie()) {
                    anchorPane.getChildren().remove(alienThrowingHand.getImageview());
                    alienThrowingHand.stopTimeline();
                    alienAL.remove(i);
                }
            } else if (alienThrowingHand.getBounds().intersects(csieTower.getBounds())) {

                alienThrowingHand.portal(2);

                if (alienThrowingHand.getCanAttack()) {
                    csieTower.minusHealth(alienThrowingHand.getATK());
                    alienThrowingHand.initCanAttack();
                }
            } else {

                boolean isDetect = false;
                for (int j = 0; j < taAAL.size(); j++) {
                    TaA taA = taAAL.get(j);
                    if (alienThrowingHand.getBounds().intersects(taA.getBounds()) && taA.getStatus() != 3) {
                        isDetect = true;
                        alienThrowingHand.portal(2);
                        if (alienThrowingHand.getCanAttack()) {
                            taA.minusHealth(alienThrowingHand.getATK());
                            alienThrowingHand.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < taBAL.size(); j++) {
                    TaB taB = taBAL.get(j);
                    int distance = alienThrowingHand.getX() - taB.getX();
                    if (distance > 0 && distance < 164 && taB.getStatus() != 3) {
                        isDetect = true;
                        alienThrowingHand.portal(2);
                        if (alienThrowingHand.getCanAttack()) {
                            taB.minusHealth(alienThrowingHand.getATK());
                            alienThrowingHand.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < taCAL.size(); j++) {
                    TaC taC = taCAL.get(j);
                    int distance = alienThrowingHand.getX() - taC.getX();
                    if (distance > 0 && distance < 180 && taC.getStatus() != 3) {
                        isDetect = true;
                        alienThrowingHand.portal(2);
                        if (alienThrowingHand.getCanAttack()) {
                            taC.minusHealth(alienThrowingHand.getATK());
                            alienThrowingHand.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < dreamBeeAL.size(); j++) {
                    DreamBee dreamBee = dreamBeeAL.get(j);
                    int distance = alienThrowingHand.getX() - dreamBee.getX();
                    if (distance > 0 && distance < 293 && dreamBee.getStatus() != 3) {
                        isDetect = true;
                        alienThrowingHand.portal(2);
                        if (alienThrowingHand.getCanAttack()) {
                            dreamBee.minusHealth(alienThrowingHand.getATK());
                            alienThrowingHand.initCanAttack();
                        }
                    }
                }
                if (isDetect) continue;

                alienThrowingHand.portal(1);
            }
        }

        for (int i = 0; i < salmonSteaksAL.size(); i++) {
            SalmonSteak salmonSteak = salmonSteaksAL.get(i);
            if (salmonSteak.getHealth() < 0 || allTimelineStop) {
                salmonSteak.portal(3);

                if (salmonSteak.getCanDie()) {
                    anchorPane.getChildren().remove(salmonSteak.getImageview());
                    salmonSteak.stopTimeline();
                    salmonSteaksAL.remove(i);
                }

            } else if (salmonSteak.getBounds().intersects(csieTower.getBounds())) {
                salmonSteak.portal(2);
                if (salmonSteak.getCanAttack()) {
                    csieTower.minusHealth(salmonSteak.getATK());
                    salmonSteak.initCanAttack();
                }
            } else {

                boolean isDetect = false;
                for (int j = 0; j < taAAL.size(); j++) {
                    TaA taA = taAAL.get(j);
                    if (salmonSteak.getBounds().intersects(taA.getBounds()) && taA.getStatus() != 3) {
                        isDetect = true;
                        salmonSteak.portal(2);
                        if (salmonSteak.getCanAttack()) {
                            taA.minusHealth(salmonSteak.getATK());
                            salmonSteak.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < taBAL.size(); j++) {
                    TaB taB = taBAL.get(j);
                    int distance = salmonSteak.getX() - taB.getX();
                    if (distance > 0 && distance < 164 && taB.getStatus() != 3) {
                        isDetect = true;
                        salmonSteak.portal(2);
                        if (salmonSteak.getCanAttack()) {
                            taB.minusHealth(salmonSteak.getATK());
                            salmonSteak.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < taCAL.size(); j++) {
                    TaC taC = taCAL.get(j);
                    int distance = salmonSteak.getX() - taC.getX();
                    if (distance > 0 && distance < 180 && taC.getStatus() != 3) {
                        isDetect = true;
                        salmonSteak.portal(2);
                        if (salmonSteak.getCanAttack()) {
                            taC.minusHealth(salmonSteak.getATK());
                            salmonSteak.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < dreamBeeAL.size(); j++) {
                    DreamBee dreamBee = dreamBeeAL.get(j);
                    int distance = salmonSteak.getX() - dreamBee.getX();
                    if (distance > 0 && distance < 293 && dreamBee.getStatus() != 3) {
                        isDetect = true;
                        salmonSteak.portal(2);
                        if (salmonSteak.getCanAttack()) {
                            dreamBee.minusHealth(salmonSteak.getATK());
                            salmonSteak.initCanAttack();
                        }
                    }
                }
                if (isDetect) continue;

                salmonSteak.portal(1);
            }
        }

        for (int i = 0; i < yamsAL.size(); i++) {
            Yams yams = yamsAL.get(i);
            if (yams.getHealth() < 0 || allTimelineStop) {
                yams.portal(3);

                if (yams.getCanDie()) {
                    anchorPane.getChildren().remove(yams.getImageview());
                    yams.stopTimeline();
                    yamsAL.remove(i);
                }

            } else if (yams.getBounds().intersects(csieTower.getBounds())) {
                yams.portal(2);
                if (yams.getCanAttack()) {
                    csieTower.minusHealth(yams.getATK());
                    yams.initCanAttack();
                }
            } else {

                boolean isDetect = false;
                for (int j = 0; j < taAAL.size(); j++) {
                    TaA taA = taAAL.get(j);
                    if (yams.getBounds().intersects(taA.getBounds()) && taA.getStatus() != 3) {
                        isDetect = true;
                        yams.portal(2);
                        if (yams.getCanAttack()) {
                            taA.minusHealth(yams.getATK());
                            yams.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < taBAL.size(); j++) {
                    TaB taB = taBAL.get(j);
                    int distance = yams.getX() - taB.getX();
                    if (distance > 0 && distance < 164 && taB.getStatus() != 3) {
                        isDetect = true;
                        yams.portal(2);
                        if (yams.getCanAttack()) {
                            taB.minusHealth(yams.getATK());
                            yams.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < taCAL.size(); j++) {
                    TaC taC = taCAL.get(j);
                    int distance = yams.getX() - taC.getX();
                    if (distance > 0 && distance < 180 && taC.getStatus() != 3) {
                        isDetect = true;
                        yams.portal(2);
                        if (yams.getCanAttack()) {
                            taC.minusHealth(yams.getATK());
                            yams.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < dreamBeeAL.size(); j++) {
                    DreamBee dreamBee = dreamBeeAL.get(j);
                    int distance = yams.getX() - dreamBee.getX();
                    if (distance > 0 && distance < 293 && dreamBee.getStatus() != 3) {
                        isDetect = true;
                        yams.portal(2);
                        if (yams.getCanAttack()) {
                            dreamBee.minusHealth(yams.getATK());
                            yams.initCanAttack();
                        }
                    }
                }
                if (isDetect) continue;

                yams.portal(1);
            }
        }

        for (int i = 0; i < taAAL.size(); i++) {
            TaA taA = taAAL.get(i);
            if (taA.getHealth() < 0 || allTimelineStop) {
                taA.portal(3);
                if (taA.getCanDie()) {
                    anchorPane.getChildren().remove(taA.getImageview());
                    taA.stopTimeline();
                    taAAL.remove(i);
                    iceCream += 50;
                    money += 50;
                }
            } else if (taA.getBounds().intersects(grandpaTower.getBounds())) {
                taA.portal(2);
                if (taA.getCanAttack()) {
                    grandpaTower.minusHealth(taA.getATK());
                    taA.initCanAttack();
                }
            } else {
                boolean isDetect = false;
                for (int j = 0; j < freshChickAL.size(); j++) {
                    FreshChick freshChick = freshChickAL.get(j);
                    if (taA.getBounds().intersects(freshChick.getBounds()) && freshChick.getStatus() != 3) {
                        isDetect = true;
                        taA.portal(2);
                        if (taA.getCanAttack()) {
                            freshChick.minusHealth(taA.getATK());
                            taA.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < salmonSteaksAL.size(); j++) {
                    SalmonSteak salmonSteak = salmonSteaksAL.get(j);
                    if (taA.getBounds().intersects(salmonSteak.getBounds()) && salmonSteak.getStatus() != 3) {
                        isDetect = true;
                        taA.portal(2);
                        if (taA.getCanAttack()) {
                            salmonSteak.minusHealth(taA.getATK());
                            taA.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < yamsAL.size(); j++) {
                    Yams yams = yamsAL.get(j);
                    int distance = yams.getX() + 2 - taA.getX();
                    if (distance > -150 && distance < 0 && yams.getStatus() != 3) {
                        isDetect = true;
                        taA.portal(2);
                        if (taA.getCanAttack()) {
                            yams.minusHealth(taA.getATK());
                            taA.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < alienAL.size(); j++) {
                    AlienThrowingHand alienThrowingHand = alienAL.get(j);
                    int distance = alienThrowingHand.getX() + 49 - taA.getX();
                    if (distance > -209 && distance < 0 && alienThrowingHand.getStatus() != 3) {
                        isDetect = true;
                        taA.portal(2);
                        if (taA.getCanAttack()) {
                            alienThrowingHand.minusHealth(taA.getATK());
                            taA.initCanAttack();
                        }
                    }
                }
                if (isDetect) continue;

                taA.portal(1);
            }
        }

        for (int i = 0; i < taBAL.size(); i++) {
            TaB taB = taBAL.get(i);
            if (taB.getHealth() < 0 || allTimelineStop) {
                taB.portal(3);
                if (taB.getCanDie()) {
                    anchorPane.getChildren().remove(taB.getImageview());
                    taB.stopTimeline();
                    taBAL.remove(i);
                    iceCream += 125;
                    money += 150;
                }
            } else if (taB.getBounds().intersects(grandpaTower.getBounds())) {
                taB.portal(2);
                if (taB.getCanAttack()) {
                    grandpaTower.minusHealth(taB.getATK());
                    taB.initCanAttack();
                }
            } else {
                boolean isDetect = false;
                for (int j = 0; j < freshChickAL.size(); j++) {
                    FreshChick freshChick = freshChickAL.get(j);
                    if (taB.getBounds().intersects(freshChick.getBounds()) && freshChick.getStatus() != 3) {
                        isDetect = true;
                        taB.portal(2);
                        if (taB.getCanAttack()) {
                            freshChick.minusHealth(taB.getATK());
                            taB.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < salmonSteaksAL.size(); j++) {
                    SalmonSteak salmonSteak = salmonSteaksAL.get(j);
                    if (taB.getBounds().intersects(salmonSteak.getBounds()) && salmonSteak.getStatus() != 3) {
                        isDetect = true;
                        taB.portal(2);
                        if (taB.getCanAttack()) {
                            salmonSteak.minusHealth(taB.getATK());
                            taB.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < yamsAL.size(); j++) {
                    Yams yams = yamsAL.get(j);
                    int distance = yams.getX() - 184 - taB.getX();
                    if (distance > -90 && distance < 0 && yams.getStatus() != 3) {
                        isDetect = true;
                        taB.portal(2);
                        if (taB.getCanAttack()) {
                            yams.minusHealth(taB.getATK());
                            taB.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < alienAL.size(); j++) {
                    AlienThrowingHand alienThrowingHand = alienAL.get(j);
                    int distance = alienThrowingHand.getX() - 85 - taB.getX();
                    if (distance > -90 && distance < 0 && alienThrowingHand.getStatus() != 3) {
                        isDetect = true;
                        taB.portal(2);
                        if (taB.getCanAttack()) {
                            alienThrowingHand.minusHealth(taB.getATK());
                            taB.initCanAttack();
                        }
                    }
                }

                if (isDetect) continue;

                taB.portal(1);
            }
        }

        for (int i = 0; i < taCAL.size(); i++) {
            TaC taC = taCAL.get(i);
            if (taC.getHealth() < 0 || allTimelineStop) {
                taC.portal(3);
                if (taC.getCanDie()) {
                    anchorPane.getChildren().remove(taC.getImageview());
                    taC.stopTimeline();
                    taCAL.remove(i);
                    iceCream += 555;
                    money += 500;
                }
            } else if (taC.getBounds().intersects(grandpaTower.getBounds())) {
                taC.portal(2);
                if (taC.getCanAttack()) {
                    grandpaTower.minusHealth(taC.getATK());
                    taC.initCanAttack();
                }
            } else {
                boolean isDetect = false;
                for (int j = 0; j < freshChickAL.size(); j++) {
                    FreshChick freshChick = freshChickAL.get(j);
                    if (taC.getBounds().intersects(freshChick.getBounds()) && freshChick.getStatus() != 3) {
                        isDetect = true;
                        taC.portal(2);
                        if (taC.getCanAttack()) {
                            freshChick.minusHealth(taC.getATK());
                            taC.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < salmonSteaksAL.size(); j++) {
                    SalmonSteak salmonSteak = salmonSteaksAL.get(j);
                    if (taC.getBounds().intersects(salmonSteak.getBounds()) && salmonSteak.getStatus() != 3) {
                        isDetect = true;
                        taC.portal(2);
                        if (taC.getCanAttack()) {
                            salmonSteak.minusHealth(taC.getATK());
                            taC.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < yamsAL.size(); j++) {
                    Yams yams = yamsAL.get(j);
                    int distance = yams.getX() - taC.getX() - 276;
                    if (distance > -200 && distance < 0 && yams.getStatus() != 3) {
                        isDetect = true;
                        taC.portal(2);
                        if (taC.getCanAttack()) {
                            yams.minusHealth(taC.getATK());
                            taC.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < alienAL.size(); j++) {
                    AlienThrowingHand alienThrowingHand = alienAL.get(j);
                    int distance = alienThrowingHand.getX() - 177 - taC.getX();
                    if (distance > -353 && distance < 0 && alienThrowingHand.getStatus() != 3) {
                        isDetect = true;
                        taC.portal(2);
                        if (taC.getCanAttack()) {
                            alienThrowingHand.minusHealth(taC.getATK());
                            taC.initCanAttack();
                        }
                    }
                }

                if (isDetect) continue;

                taC.portal(1);
            }
        }

        for (int i = 0; i < dreamBeeAL.size(); i++) {
            DreamBee dreamBee = dreamBeeAL.get(i);
            if (dreamBee.getHealth() < 0 || allTimelineStop) {
                dreamBee.portal(3);
                if (dreamBee.getCanDie()) {
                    anchorPane.getChildren().remove(dreamBee.getImageview());
                    dreamBee.stopTimeline();
                    dreamBeeAL.remove(i);
                    iceCream += 12700;
                    money += 1000;
                }
            } else if (dreamBee.getBounds().intersects(grandpaTower.getBounds())) {
                dreamBee.portal(2);
                if (dreamBee.getCanAttack()) {
                    grandpaTower.minusHealth(dreamBee.getATK());
                    dreamBee.initCanAttack();
                }
            } else {
                boolean isDetect = false;
                for (int j = 0; j < freshChickAL.size(); j++) {
                    FreshChick freshChick = freshChickAL.get(j);
                    if (dreamBee.getBounds().intersects(freshChick.getBounds()) && freshChick.getStatus() != 3) {
                        isDetect = true;
                        dreamBee.portal(2);
                        if (dreamBee.getCanAttack()) {
                            freshChick.minusHealth(dreamBee.getATK());
                            dreamBee.initCanAttack();
                            if (randomInt.nextInt(200) % 97 == 0) {
                                freshChick.lag();
                                hint.setText("夢蜂施展催眠鱗粉，讓小菜雞進入睡眠狀態！");
                                hint.setVisible(true);
                            }
                        }
                    }
                }

                for (int j = 0; j < salmonSteaksAL.size(); j++) {
                    SalmonSteak salmonSteak = salmonSteaksAL.get(j);
                    if (dreamBee.getBounds().intersects(salmonSteak.getBounds()) && salmonSteak.getStatus() != 3) {
                        isDetect = true;
                        dreamBee.portal(2);
                        if (dreamBee.getCanAttack()) {
                            salmonSteak.minusHealth(dreamBee.getATK());
                            dreamBee.initCanAttack();
                            if (randomInt.nextInt(200) % 95 == 0) {
                                salmonSteak.lag();
                                hint.setText("夢蜂施展催眠鱗粉，讓鮭魚排進入睡眠狀態！");
                                hint.setVisible(true);
                            }
                        }
                    }
                }

                for (int j = 0; j < yamsAL.size(); j++) {
                    Yams yams = yamsAL.get(j);
                    int distance = yams.getX() - dreamBee.getX() - 422;
                    if (distance > -327 && distance < 0 && yams.getStatus() != 3) {
                        isDetect = true;
                        dreamBee.portal(2);
                        if (dreamBee.getCanAttack()) {
                            yams.minusHealth(dreamBee.getATK());
                            dreamBee.initCanAttack();
                            if (randomInt.nextInt(200) % 95 == 0) {
                                yams.minusHealth(dreamBee.getATK());
                                if (randomInt.nextInt(200) % 97 == 0) {
                                    yams.lag();
                                    hint.setText("夢蜂施展催眠鱗粉，讓紫薯進入睡眠狀態！");
                                    hint.setVisible(true);
                                }
                            }
                        }
                    }
                }

                for (int j = 0; j < alienAL.size(); j++) {
                    AlienThrowingHand alienThrowingHand = alienAL.get(j);
                    int distance = alienThrowingHand.getX() - dreamBee.getX() - 373;
                    if (distance > -327 && alienThrowingHand.getStatus() != 3) {
                        isDetect = true;
                        dreamBee.portal(2);
                        if (dreamBee.getCanAttack()) {
                            alienThrowingHand.minusHealth(dreamBee.getATK());
                            dreamBee.initCanAttack();
                            if (randomInt.nextInt(200) % 97 == 0) {
                                alienThrowingHand.lag();
                                hint.setText("夢蜂施展催眠鱗粉，讓外星投手進入睡眠狀態！");
                                hint.setVisible(true);
                            }
                        }
                    }
                }

                if (isDetect) continue;

                dreamBee.portal(1);
            }
        }
    }

    @FXML
    public void shootBoom() {
        if (fastFoodShoot != 10) {
            hint.setText("歡樂薯條飛彈冷卻中");
            hint.setVisible(true);
            return;
        }

        hint.setText("歡樂薯條飛彈發射，為你帶來歡樂無限！");
        hint.setVisible(true);
        ImageView fastFood = new ImageView(new Image("hellofx\\resource\\role\\Hero\\frenchFries.png"));
        fastFood.setFitWidth(350.0);
        fastFood.setFitHeight(75.0);
        long duration = 1000;
        int minusHealth = 800;
        KeyFrame startKey = new KeyFrame(Duration.ZERO, new KeyValue(fastFood.xProperty(), 2210), new KeyValue(fastFood.yProperty(), 250));
        KeyFrame endKey = new KeyFrame(new Duration(duration), new KeyValue(fastFood.xProperty(), -350), new KeyValue(fastFood.yProperty(), 420));
        KeyFrame actKey = new KeyFrame(new Duration(1200), e -> {
            hint.setText("吃我的大薯條吧！ 藍藍路 ~");
            hint.setVisible(true);
            LANLANRUController.LanLanRuPlay();
            anchorPane.getChildren().remove(fastFood);
            for (TaA taA : taAAL) {
                taA.minusHealth(minusHealth);
            }
            for (TaB taB : taBAL) {
                taB.minusHealth(minusHealth);
            }
            for (TaC taC : taCAL) {
                taC.minusHealth(minusHealth);
            }
            for (DreamBee dreamBee : dreamBeeAL) {
                dreamBee.minusHealth(minusHealth);
            }
        });
        Timeline fastFoodTimeline = new Timeline();
        fastFoodTimeline.getKeyFrames().addAll(startKey, endKey, actKey);
        fastFoodTimeline.play();
        anchorPane.getChildren().add(fastFood);
        fastFoodShoot = 0;
    }

    public void economic() {
        if (moneyLevel > 10 || money < (moneyMax / 2)) {
            if (moneyLevel > 10) hint.setText("已達最大等級");
            else hint.setText("升級所需能量不足");
            hint.setVisible(true);
            return;
        }
        hint.setText("升級成功");
        hint.setVisible(true);
        money -= (moneyMax / 2);
        moneyRate++;
        moneyMax += 200;
        ecoLvpNeed.setText(String.valueOf(moneyMax / 2));
        moneyLevel++;
        economicImg.setImage(new Image("hellofx\\resource\\gameButton\\economy\\economy" + moneyLevel + ".png"));
        labelMax.setText(Integer.toString(moneyMax));
    }
}
