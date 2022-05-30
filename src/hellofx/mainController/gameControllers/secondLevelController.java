package hellofx.mainController.gameControllers;

import hellofx.mainController.MusicControllers.ButtonSoundPlayController;
import hellofx.mainController.MusicControllers.MusicPlayController;
import hellofx.mainController.ViewController;

import java.io.IOException;

public class secondLevelController {
    public void levelTwoToLevel() throws IOException {
        ViewController.toLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}
