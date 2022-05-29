package hellofx.mainController;

import hellofx.MusicControllers.MusicPlayController;
import hellofx.models.FreshChick;
import javafx.fxml.FXML;

import java.io.IOException;


public class DormController {
    @FXML
    public void backToDorm() throws IOException {
        ViewController.toDorm();
        MusicPlayController.checkNowStage();
    }

    @FXML
    public void chicklvup() throws  IOException{
        FreshChick.chLevel(0);
    }




}
