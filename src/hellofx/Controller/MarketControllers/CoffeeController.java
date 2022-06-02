package hellofx.Controller.MarketControllers;

import hellofx.Controller.MarketController;
import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.ViewController;
import hellofx.models.LevelController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class CoffeeController {
    @FXML Label iceCreamLabel;
    @FXML Label hint;
    @FXML Label coffeeAmountLabel;
    @FXML Label amountLabel;
    @FXML Label totalLabel;
    private int amount = 0;
    private int total = 0;
    private final int coffeePrice = 95;
    private static int coffeeAmount = 0;

    @FXML
    public void initialize() {
        iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
        coffeeAmountLabel.setText(String.format("%04d", coffeeAmount));
    }

    public void backToMarket() throws IOException {
        ViewController.toMarket();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void addMaxR() {
        if (total <= MarketController.iceCreamNum){
            LevelController.changeRateM(amount);
            MarketController.iceCreamNum -= total;
            coffeeAmount += amount;
            amount = 0;
            total = 0;
            iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
            coffeeAmountLabel.setText(String.format("%04d", coffeeAmount));
            amountLabel.setText(String.format("%04d", amount));
            totalLabel.setText(String.format("%06d", total));
            hint.setVisible(true);
            hint.setText("購買成功");
        }
        else {
            amount = 0;
            total = 0;
            amountLabel.setText(String.format("%04d", amount));
            totalLabel.setText(String.format("%06d", total));
            hint.setVisible(true);
            hint.setText("冰淇淋不足");
        }
    }

    public void coffeePlus1() {
        amount++;
        total = coffeePrice * amount;
        amountLabel.setText(String.format("%04d", amount));
        totalLabel.setText(String.format("%06d", total));
    }

    public void coffeeMinus1() {
        amount--;
        total = coffeePrice * amount;
        amountLabel.setText(String.format("%04d", amount));
        totalLabel.setText(String.format("%06d", total));
    }
}
