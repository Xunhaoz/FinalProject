package hellofx.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FirstLevelController {
    @FXML
    VBox vBox;
    @FXML
    AnchorPane anchorPane;
    @FXML
    ScrollPane scrollPlane;
    @FXML
    HBox hBox;

    public void initialize() {
        scrollPlane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPlane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    }
}
