package hellofx.controller;

import hellofx.models.AllianceTower;
import hellofx.models.SliderDragon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class FirstLevelController {
    ImageView allianceTower;
    Timeline timeline;
    ArrayList<ImageView> character;
    @FXML
    AnchorPane pane;

    @FXML
    public void firstLevelToLevel() throws IOException {
        ViewController.toLevel();
    }

    @FXML
    public void initialize() {
        SliderDragon sliderDragon = new SliderDragon(0, 400);
        pane.getChildren().addAll(sliderDragon.getImageView());
        timeline = new Timeline(new KeyFrame(Duration.millis(2000), e -> {
            pane.getChildren().remove(sliderDragon);
            sliderDragon.updateStatus();
            pane.getChildren().addAll(sliderDragon.getImageView());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


    }
}
