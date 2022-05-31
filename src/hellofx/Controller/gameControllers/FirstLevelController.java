package hellofx.Controller.gameControllers;


import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import hellofx.models.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class FirstLevelController extends LevelController {
    public Button backButton;
    public ProgressBar csieTowerHP;
    public ProgressBar grandpaTowerHP;
    public Label csieHealthLable;
    public Label grandpaHealthLable;
    @FXML
    Label labelMax;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Label label;
    @FXML
    Button levelButton;

    private int money = 500; // need to be modified to 0
    private CSIETower csieTower;
    private GrandpaTower grandpaTower;
    final private ArrayList<FreshChick> freshChickAL = new ArrayList<>();
    final private ArrayList<SalmonSteak> salmonSteaksAL = new ArrayList<>();
    final private ArrayList<Yams> yamsAL = new ArrayList<>();
    final private ArrayList<TaA> taAAL = new ArrayList<>();
    final private Random randomInt = new Random();
    private int csieTowerHealt;
    private int grandpaTowerHealt;


    @FXML
    public void initialize() {
        csieTower = new CSIETower(0, 180);
        grandpaTower = new GrandpaTower(1040, 180);

        csieTower.setBounds();
        grandpaTower.setBounds();

        csieTowerHealt = csieTower.getHealth();
        grandpaTowerHealt = grandpaTower.getHealth();

        csieTower.move();
        grandpaTower.move();

        anchorPane.getChildren().addAll(csieTower.getImageview(), grandpaTower.getImageview());

        moneyLevel = 1;
        labelMax.setText(Integer.toString(moneyMax));

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), e -> {
            this.money += moneyRate;
            if (money < moneyMax) {
                label.setText(String.format("%04d", money));
            } else {
                label.setText(String.format("%04d", moneyMax));
                money = moneyMax;
            }
            csieHealthLable.setText(csieTower.getHealth() + " / " + csieTowerHealt);
            grandpaHealthLable.setText(grandpaTower.getHealth() + " / " + grandpaTowerHealt);
            csieTowerHP.setProgress((double) csieTower.getHealth() / csieTowerHealt);
            grandpaTowerHP.setProgress((double) grandpaTower.getHealth() / grandpaTowerHealt);
            statusDetector();
            if (randomInt.nextInt(200) % 100 == 0) {
                createTaA();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
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
    public void createYams() {
        if (Integer.parseInt(label.getText()) < 200) return;
        money -= 200;
        int ranInt = (randomInt.nextInt(4) - 2) * 20;
        Yams yams = new Yams(1100, 360 + ranInt, randomInt.nextInt(100) % 3);
        yamsAL.add(yams);
        yams.portal(1);
        anchorPane.getChildren().add(yams.getImageview());
        yams.setBounds();
    }

    @FXML
    public void createFreshChick() {
        if (Integer.parseInt(label.getText()) < 50) {
            return;
        }
        money -= 50;
        int ranInt = (randomInt.nextInt(4) - 2) * 20;
        FreshChick freshChick = new FreshChick(1100, 420 + ranInt);
        freshChickAL.add(freshChick);
        freshChick.portal(1);
        anchorPane.getChildren().add(freshChick.getImageview());
        freshChick.setBounds();
    }

    @FXML
    public void createSalmonSteak() {
        if (Integer.parseInt(label.getText()) < 100) {
            return;
        }
        money -= 100;
        int ranInt = (randomInt.nextInt(4) - 2) * 20;
        SalmonSteak salmonSteak = new SalmonSteak(1100, 370 + ranInt);
        salmonSteaksAL.add(salmonSteak);
        salmonSteak.portal(1);
        anchorPane.getChildren().add(salmonSteak.getImageview());
        salmonSteak.setBounds();
    }

    @FXML
    public void levelOneToLevel() throws IOException {
        ViewController.toLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void statusDetector() {
        for (int i = 0; i < freshChickAL.size(); i++) {
            FreshChick freshChick = freshChickAL.get(i);

            if (freshChick.getHealth() < 0) {

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
                if (isDetect) continue;

                freshChick.portal(1);
            }
        }

        for (int i = 0; i < salmonSteaksAL.size(); i++) {
            SalmonSteak salmonSteak = salmonSteaksAL.get(i);
            if (salmonSteak.getHealth() < 0) {
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
                if (isDetect) continue;

                salmonSteak.portal(1);
            }
        }

        for (int i = 0; i < yamsAL.size(); i++) {
            Yams yams = yamsAL.get(i);
            if (yams.getHealth() < 0) {
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
                if (isDetect) continue;

                yams.portal(1);
            }
        }

        for (int i = 0; i < taAAL.size(); i++) {
            TaA taA = taAAL.get(i);
            if (taA.getHealth() < 0) {
                taA.portal(3);
                if (taA.getCanDie()) {
                    anchorPane.getChildren().remove(taA.getImageview());
                    taA.stopTimeline();
                    taAAL.remove(i);
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
                    if (taA.getBounds().intersects(yams.getBounds()) && yams.getStatus() != 3) {
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
    }

    public void economic() {
        if (moneyLevel > 7 || money < (moneyMax / 2)) return;
        money -= (moneyMax / 2);
        moneyRate++;
        moneyMax += 200;
        moneyLevel++;
        labelMax.setText(Integer.toString(moneyMax));
        levelButton.setText("經濟 Level " + Integer.toString(moneyLevel));
    }

}
