package hellofx.mainController;

import hellofx.MusicControllers.ButtonSoundPlayController;
import hellofx.MusicControllers.MusicPlayController;
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
