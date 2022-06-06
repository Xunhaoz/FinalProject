package hellofx.Controller.gameControllers;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class LosePageController {

    public Button backButton;
    public Button restart;

    @FXML
    public void initialize() throws IOException {
    }

    public void gameToLevel() throws IOException {
        ViewController.toLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
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
