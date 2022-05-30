package hellofx.gameControllers;

import hellofx.MusicControllers.ButtonSoundPlayController;
import hellofx.MusicControllers.MusicPlayController;
import hellofx.mainController.ViewController;
import javafx.event.ActionEvent;

import java.io.IOException;

public class secondLevelController {
    public void levelTwoToLevel() throws IOException {
        ViewController.toLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}
