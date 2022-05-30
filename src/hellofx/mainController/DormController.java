package hellofx.mainController;

import hellofx.mainController.MusicControllers.ButtonSoundPlayController;
import hellofx.mainController.MusicControllers.MusicPlayController;
import hellofx.models.FreshChick;
import javafx.fxml.FXML;

import java.io.IOException;


public class DormController {
    @FXML
    public void backToDorm() throws IOException {
        ViewController.toDorm();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void chicklvup() throws  IOException{
        FreshChick.chLevel(0);
    }




}
