package hellofx.Controller.gameControllers;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class WinPageController {

    public Label iceCreamLabel;
    public Button backButton;
    public static int winIceCream;
    public Button nextLevelButton;

    @FXML
    public void initialize() throws IOException {
        iceCreamLabel.setText(String.format("%05d", winIceCream));
        winIceCream = 0;
    }

    public void gameToLevel() throws IOException {
        ViewController.toLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void toNext() throws IOException {
        if (ViewController.lastStageStr.equals("firstLevel")) {
            ViewController.toSecondLevel();
            MusicPlayController.checkNowStage();
            ButtonSoundPlayController.buttonSoundPlay();
        }
        else if (ViewController.lastStageStr.equals("SecondLevel")) {
            ViewController.toThirdLevel();
            MusicPlayController.checkNowStage();
            ButtonSoundPlayController.buttonSoundPlay();
        }
        else if (ViewController.lastStageStr.equals("ThirdLevel")) {
            ViewController.toFirstLevel();
            MusicPlayController.checkNowStage();
            ButtonSoundPlayController.buttonSoundPlay();
        }
    }

    public void backToGame() throws IOException {
        if (ViewController.lastStageStr.equals("firstLevel")) {
            ViewController.toFirstLevel();
            MusicPlayController.checkNowStage();
            ButtonSoundPlayController.buttonSoundPlay();
        }
        else if (ViewController.lastStageStr.equals("SecondLevel")) {
            ViewController.toSecondLevel();
            MusicPlayController.checkNowStage();
            ButtonSoundPlayController.buttonSoundPlay();
        }
        else if (ViewController.lastStageStr.equals("ThirdLevel")) {
            ViewController.toThirdLevel();
            MusicPlayController.checkNowStage();
            ButtonSoundPlayController.buttonSoundPlay();
        }
    }
}
