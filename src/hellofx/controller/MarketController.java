package hellofx.controller;


import hellofx.models.LevelController;

import java.io.IOException;

public class MarketController {


    public void DorCharacterToSetting() throws IOException {
        ViewController.toSetting();
    }

    public void addMaxM(){
        LevelController.changeMaxM(200);
    }
}
