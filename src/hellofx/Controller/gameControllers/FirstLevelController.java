package hellofx.Controller.gameControllers;


import hellofx.Controller.MarketController;
import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class FirstLevelController extends LevelController {
    public Button backButton;
    public ProgressBar csieTowerHP;
    public ProgressBar grandpaTowerHP;
    public Label csieHealthLable;
    public Label grandpaHealthLable;
    public ImageView economicImg;
    public ImageView fastFoodImg;
    public ImageView yamsImg;

    @FXML
    Label iceCreamLabel;
    @FXML
    Label labelMax;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Label label;

    private int money = 500; // need to be modified to 0
    private CSIETower csieTower;
    private GrandpaTower grandpaTower;
    final private ArrayList<FreshChick> freshChickAL = new ArrayList<>();
    final private ArrayList<SalmonSteak> salmonSteaksAL = new ArrayList<>();
    final private ArrayList<Yams> yamsAL = new ArrayList<>();
    final private ArrayList<TaA> taAAL = new ArrayList<>();
    final private ArrayList<TaB> taBAL = new ArrayList<>();
    final private ArrayList<TaC> taCAL = new ArrayList<>();
    final private ArrayList<Erhu> erhuAL = new ArrayList<>();
    final private Random randomInt = new Random();
    private int csieTowerHealth;
    private int grandpaTowerHealth;
    private int enemyCreateRate = 0;
    private int iceCream = 0;
    private boolean hasBoss = false;
    private int fastFoodShoot = 0;
    private AtomicInteger countUp = new AtomicInteger(0);
    private Boolean allTimelineStop;
    private boolean []canCreate = {true, true, true};
    //createYams createFreshChick createSalmonSteak

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

        if (csieTower.getHealth() <= (csieTowerHealth - 1) && enemyCreateRate % 500 == 0) {
            createErhu();
        }

        if (enemyCreateRate % 100 == 0) {
            createTaA();
        } else if (enemyCreateRate % 100 == 20) {
            createTaB();
        } else if (enemyCreateRate % 100 == 30) {
            createTaC();
        } else if (csieTower.getHealth() < 9500 && !hasBoss) {
            hasBoss = true;
            createErhu();
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

    @FXML
    public void initialize() throws IOException {
        System.out.println(canCreate[0]);
        allTimelineStop = false;
        iceCream = 0;
        iceCreamLabel.setText(String.format("%05d", iceCream));

        csieTower = new CSIETower(0, 180);
        grandpaTower = new GrandpaTower(1040, 180);

        csieTower.setBounds();
        grandpaTower.setBounds();

        csieTowerHealth = csieTower.getHealth();
        grandpaTowerHealth = grandpaTower.getHealth();

        csieTower.move();
        grandpaTower.move();

        anchorPane.getChildren().addAll(csieTower.getImageview(), grandpaTower.getImageview());

        moneyLevel = 1;
        labelMax.setText(Integer.toString(moneyMax));

        iceCream = MarketController.iceCreamNum;

        levelOneTimeline.setCycleCount(Timeline.INDEFINITE);
        levelOneTimeline.play();
    }

    @FXML
    public void createTaA() {
        int ranInt = (randomInt.nextInt(4) - 2) * 20;
        TaA taA = new TaA(140, 420 + ranInt);
        taAAL.add(taA);
        taA.portal(1);
        anchorPane.getChildren().add(taA.getImageview());
        taA.setBounds();
    }

    @FXML
    public void createTaB() {
        int ranInt = (randomInt.nextInt(4) - 2) * 20;
        TaB taB = new TaB(140, 360 + ranInt);
        taBAL.add(taB);
        taB.portal(1);
        anchorPane.getChildren().add(taB.getImageview());
        taB.setBounds();
    }

    @FXML
    public void createTaC() {
        int ranInt = (randomInt.nextInt(4) - 2) * 20;
        TaC taC = new TaC(140, 300 + ranInt);
        taCAL.add(taC);
        taC.portal(1);
        anchorPane.getChildren().add(taC.getImageview());
        taC.setBounds();
    }

    @FXML
    public void createErhu() {
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        Erhu erhu = new Erhu(40, 300 + ranInt);
        erhuAL.add(erhu);
        erhu.portal(1);
        anchorPane.getChildren().add(erhu.getImageview());
        erhu.setBounds();
        for (FreshChick freshChick : freshChickAL) {
            freshChick.lag();
        }
    }

    @FXML
    public void createYams() {
        if (Integer.parseInt(label.getText()) < 200 || !canCreate[0]) return;
        money -= 200;

        int ranCharacter = randomInt.nextInt(100) % 3;
        Yams yams = new Yams(1100, 355 + (randomInt.nextInt(4) - 2) * 10, ranCharacter);
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
        KeyFrame endKeyFrame = new KeyFrame(new Duration(yams.getCD()*1000), e->{canCreate[0] = true;});
        CDtimeline.getKeyFrames().addAll(startKeyFrame, endKeyFrame);
        CDtimeline.play();
    }

    @FXML
    public void createFreshChick() {
        if (Integer.parseInt(label.getText()) < 50 || !canCreate[1]) {
            return;
        }
        money -= 50;
        int ranInt = (randomInt.nextInt(4) - 2) * 20;
        FreshChick freshChick = new FreshChick(1100, 415 + ranInt);
        freshChickAL.add(freshChick);
        freshChick.portal(1);
        anchorPane.getChildren().add(freshChick.getImageview());
        freshChick.setBounds();

        Timeline CDtimeline = new Timeline();
        KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO, e->{canCreate[1] = false;});
        KeyFrame endKeyFrame = new KeyFrame(new Duration(freshChick.getCD()*1000), e->{canCreate[1] = true;});
        CDtimeline.getKeyFrames().addAll(startKeyFrame, endKeyFrame);
        CDtimeline.play();
    }

    @FXML
    public void createSalmonSteak() {
        if (Integer.parseInt(label.getText()) < 100 || !canCreate[2]) {
            return;
        }
        money -= 100;
        int ranInt = (randomInt.nextInt(4) - 2) * 5;
        SalmonSteak salmonSteak = new SalmonSteak(1100, 320 + ranInt);
        salmonSteaksAL.add(salmonSteak);
        salmonSteak.portal(1);
        anchorPane.getChildren().add(salmonSteak.getImageview());
        salmonSteak.setBounds();


        Timeline CDtimeline = new Timeline();
        KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO, e->{canCreate[2] = false;});
        KeyFrame endKeyFrame = new KeyFrame(new Duration(salmonSteak.getCD()*1000), e->{canCreate[2] = true;});
        CDtimeline.getKeyFrames().addAll(startKeyFrame, endKeyFrame);
        CDtimeline.play();
    }

    @FXML
    public void levelOneToLevel() throws IOException {
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

                for (int j = 0; j < erhuAL.size(); j++) {
                    Erhu erhu = erhuAL.get(j);
                    if (freshChick.getBounds().intersects(erhu.getBounds()) && erhu.getStatus() != 3) {
                        isDetect = true;
                        freshChick.portal(2);
                        if (freshChick.getCanAttack()) {
                            erhu.minusHealth(freshChick.getATK());
                            freshChick.initCanAttack();
                        }
                    }
                }
                if (isDetect) continue;
                freshChick.portal(1);
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

                for (int j = 0; j < erhuAL.size(); j++) {
                    Erhu erhu = erhuAL.get(j);
                    if (salmonSteak.getBounds().intersects(erhu.getBounds()) && erhu.getStatus() != 3) {
                        isDetect = true;
                        salmonSteak.portal(2);
                        if (salmonSteak.getCanAttack()) {
                            erhu.minusHealth(salmonSteak.getATK());
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

                for (int j = 0; j < erhuAL.size(); j++) {
                    Erhu erhu = erhuAL.get(j);
                    if (yams.getBounds().intersects(erhu.getBounds()) && erhu.getStatus() != 3) {
                        isDetect = true;
                        yams.portal(2);
                        if (yams.getCanAttack()) {
                            erhu.minusHealth(yams.getATK());
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
                    iceCream += 25;
                    money += 20;
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
                    money += 100;
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
                    iceCream += 250;
                    money += 400;
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
                if (isDetect) continue;

                taC.portal(1);
            }
        }

        for (int i = 0; i < erhuAL.size(); i++) {
            Erhu erhu = erhuAL.get(i);
            if (erhu.getHealth() < 0 || allTimelineStop) {
                erhu.portal(3);
                if (erhu.getCanDie()) {
                    anchorPane.getChildren().remove(erhu.getImageview());
                    erhu.stopTimeline();
                    erhuAL.remove(i);
                    iceCream += 500;
                    money += 1000;
                }
            } else if (erhu.getBounds().intersects(grandpaTower.getBounds())) {
                erhu.portal(2);
                if (erhu.getCanAttack()) {
                    grandpaTower.minusHealth(erhu.getATK());
                    erhu.initCanAttack();
                }
            } else {
                boolean isDetect = false;
                for (int j = 0; j < freshChickAL.size(); j++) {
                    FreshChick freshChick = freshChickAL.get(j);
                    if (erhu.getBounds().intersects(freshChick.getBounds()) && freshChick.getStatus() != 3) {
                        isDetect = true;
                        erhu.portal(2);
                        if (erhu.getCanAttack()) {
                            freshChick.minusHealth(erhu.getATK());
                            if (randomInt.nextInt(200) % 95 == 0) {
                                freshChick.minusHealth(erhu.getATK());
                            }
                            erhu.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < salmonSteaksAL.size(); j++) {
                    SalmonSteak salmonSteak = salmonSteaksAL.get(j);
                    if (erhu.getBounds().intersects(salmonSteak.getBounds()) && salmonSteak.getStatus() != 3) {
                        isDetect = true;
                        erhu.portal(2);
                        if (erhu.getCanAttack()) {
                            salmonSteak.minusHealth(erhu.getATK());
                            if (randomInt.nextInt(200) % 95 == 0) {
                                salmonSteak.minusHealth(erhu.getATK());
                            }
                            erhu.initCanAttack();
                        }
                    }
                }

                for (int j = 0; j < yamsAL.size(); j++) {
                    Yams yams = yamsAL.get(j);
                    int distance = yams.getX() - erhu.getX() - 170;
                    if (distance > -150 && distance < 0 && yams.getStatus() != 3) {
                        isDetect = true;
                        erhu.portal(2);
                        if (erhu.getCanAttack()) {
                            yams.minusHealth(erhu.getATK());
                            if (randomInt.nextInt(200) % 95 == 0) {
                                yams.minusHealth(erhu.getATK());
                            }
                            erhu.initCanAttack();
                        }
                    }
                }
                if (isDetect) continue;

                erhu.portal(1);
            }
        }
    }

    public void economic() {
        if (moneyLevel > 10 || money < (moneyMax / 2)) return;
        money -= (moneyMax / 2);
        moneyRate++;
        moneyMax += 200;
        moneyLevel++;
        economicImg.setImage(new Image("hellofx\\resource\\gameButton\\economy\\economy" + moneyLevel + ".png"));
        labelMax.setText(Integer.toString(moneyMax));
    }

    @FXML
    public void shootBoom() {
        if (fastFoodShoot != 10) return;

        ImageView fastFood = new ImageView(new Image("hellofx\\resource\\role\\Hero\\frenchFries.png"));
        fastFood.setFitWidth(350.0);
        fastFood.setFitHeight(75.0);
        long duration = 600;
        int minusHealth = 1000;
        KeyFrame startKey = new KeyFrame(Duration.ZERO, new KeyValue(fastFood.xProperty(), 930), new KeyValue(fastFood.yProperty(), 300));
        KeyFrame endKey = new KeyFrame(new Duration(duration), new KeyValue(fastFood.xProperty(), -350), new KeyValue(fastFood.yProperty(), 420));
        KeyFrame actKey = new KeyFrame(new Duration(800), e -> {
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
            for (Erhu erhu : erhuAL) {
                erhu.minusHealth(minusHealth);
            }
        });
        Timeline fastFoodTimeline = new Timeline();
        fastFoodTimeline.getKeyFrames().addAll(startKey, endKey, actKey);
        fastFoodTimeline.play();
        anchorPane.getChildren().add(fastFood);
        fastFoodShoot = 0;
    }
}
