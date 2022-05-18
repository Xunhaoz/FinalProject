package hellofx.controller;


import hellofx.models.CSIETower;
import hellofx.models.FreshChick;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class FirstLevelController {
    @FXML
    AnchorPane anchorPane;
    @FXML
    Label label;

    private CSIETower csieTower;
    private int money = 0;
    ArrayList<FreshChick> freshChickAL = new ArrayList<>();
    Timeline timeline = new Timeline();

    @FXML
    public void initialize() {
        csieTower = new CSIETower(0, 0);
        csieTower.move();
        anchorPane.getChildren().add(csieTower.getImageview());

        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            this.money += 1;
            label.setText(Integer.toString(money));
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

        FreshChick freshChick = new FreshChick(1000, 330);
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
