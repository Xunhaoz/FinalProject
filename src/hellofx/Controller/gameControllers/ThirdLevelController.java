package hellofx.Controller.gameControllers;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;

import java.io.IOException;

public class ThirdLevelController {
    public void levelThreeToLevel() throws IOException {
        ViewController.toLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}
