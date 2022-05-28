package hellofx.mainController;


import hellofx.models.LevelController;
import javafx.fxml.FXML;

import java.io.IOException;
import javafx.scene.control.Button;


public class MarketController {

    @FXML
    Button moneyrate;
    @FXML
    Button MaxR;
    @FXML
    Button addTowerHealth;


    public void dormToMap() throws IOException {
        ViewController.toMap();
    }

    public void addMaxM(){
        LevelController.changeMaxM(200);
    }
    public void addMaxR(){
        LevelController.changeRateM(2);
    }
    public void addTowerHealth(){

    }

}
