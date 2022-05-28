package hellofx.mainController;

import hellofx.MusicControllers.MusicPlayController;
import hellofx.models.FreshChick;
import javafx.fxml.FXML;

import java.io.IOException;


public class DormController {
    @FXML
    public void dormToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void chicklvup() throws  IOException{
        FreshChick.chLevel(0);
    }




}
