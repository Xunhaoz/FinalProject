package hellofx.Controller;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
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
        FreshChick.Levelup();
    }




}
