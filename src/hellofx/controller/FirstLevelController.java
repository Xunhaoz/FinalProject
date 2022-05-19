package hellofx.controller;


import hellofx.models.CSIETower;
import hellofx.models.FreshChick;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

    private CSIETower csieTower;
    private int money = 0;
    ArrayList<FreshChick> freshChickAL = new ArrayList<>();
    Timeline timeline = new Timeline();
    int max = 1000;
    int moneyRate = 100;

    @FXML
    public void initialize() {
        csieTower = new CSIETower(0, 180);
        csieTower.move();
        anchorPane.getChildren().add(csieTower.getImageview());

        timeline = new Timeline(new KeyFrame(Duration.millis(moneyRate), e -> {
            this.money += 1;
            if (money < max) {
                label.setText(String.format("%04d", money));
            }
            else {
                label.setText(String.format("%04d", max));
                money = max;
            }
            statusDetector();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void createFreshChick() {
        if (Integer.parseInt(label.getText()) < 50) {
            return;
        }
        money -= 50;

        Random randomInt = new Random();
        int ranInt = (randomInt.nextInt(4) - 2) * 20;
        FreshChick freshChick = new FreshChick(1000, 420 + ranInt);
        freshChickAL.add(freshChick);
        freshChick.portal(1);
        anchorPane.getChildren().add(freshChick.getImageview());
        freshChick.setBounds();
    }

    @FXML
    public void levelOneToLevel() throws IOException {
        ViewController.toLevel();
    }

    public void statusDetector() {
        for (FreshChick freshChick : freshChickAL) {
            if (freshChick.getBounds().intersects(csieTower.getBounds())) {
                freshChick.portal(2);
                csieTower.minusHealth(freshChick.getATK());
                System.out.println(csieTower.getHealth());
            } else {
                freshChick.portal(1);
            }
        }
    }
}
