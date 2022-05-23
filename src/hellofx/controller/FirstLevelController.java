package hellofx.controller;


import hellofx.models.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class FirstLevelController {
    public Button backButton;
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
    final private ArrayList<Yams> yamsAL = new ArrayList<>() ;
    private int moneyMax = 1000;
    final private Random randomInt = new Random();
    int moneyRate;
    int moneyLevel;

    @FXML
    public void initialize() {
        csieTower = new CSIETower(0, 180);
        grandpaTower = new GrandpaTower(1040, 100);
        csieTower.move();
        anchorPane.getChildren().addAll(csieTower.getImageview(), grandpaTower.getImageview());

        moneyRate = 2;
        moneyLevel = 1;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), e -> {
            this.money += moneyRate;
            if (money < moneyMax) {
                label.setText(String.format("%04d", money));
            } else {
                label.setText(String.format("%04d", moneyMax));
                money = moneyMax;
            }
            statusDetector();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void createYams() {
        if (Integer.parseInt(label.getText()) < 50) return;
        money -= 50;
        int ranInt = (randomInt.nextInt(4) - 2) * 20;
        Yams yams = new Yams(1000, 420 + ranInt, randomInt.nextInt(100)%3);
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
        FreshChick freshChick = new FreshChick(1000, 420 + ranInt);
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
        SalmonSteak salmonSteak = new SalmonSteak(1000, 420 + ranInt);
        salmonSteaksAL.add(salmonSteak);
        salmonSteak.portal(1);
        anchorPane.getChildren().add(salmonSteak.getImageview());
        salmonSteak.setBounds();
    }

    @FXML
    public void levelOneToLevel() throws IOException {
        ViewController.toLevel();
    }

    public void statusDetector() {
        for (FreshChick freshChick : freshChickAL) {
            if (freshChick.getHealth() < 0) {
                freshChick.portal(3);
                csieTower.minusHealth(freshChick.getATK());
            } else if (freshChick.getBounds().intersects(csieTower.getBounds())) {
                freshChick.portal(2);
            } else {
                freshChick.portal(1);
            }
        }

        for (SalmonSteak salmonSteak : salmonSteaksAL) {
            if (salmonSteak.getHealth() < 0) {
                salmonSteak.portal(3);
                csieTower.minusHealth(salmonSteak.getATK());
            } else if (salmonSteak.getBounds().intersects(csieTower.getBounds())) {
                salmonSteak.portal(2);
            } else {
                salmonSteak.portal(1);
            }
        }

        for (Yams yams: yamsAL) {
            if (yams.getHealth() < 0) {
                yams.portal(3);
                csieTower.minusHealth(yams.getATK());
            } else if (yams.getBounds().intersects(csieTower.getBounds())) {
                yams.portal(2);
            } else {
                yams.portal(1);
            }
        }
    }

    public void economic() {
        if (moneyLevel > 7 || money < (moneyMax / 2)) return;

        money -= (moneyMax / 2);
        moneyRate++;
        moneyMax += 200;
        moneyLevel++;
        labelMax.setText("/ " + Integer.toString(moneyMax));
        levelButton.setText("經濟 Level " + Integer.toString(moneyLevel));
    }
}
