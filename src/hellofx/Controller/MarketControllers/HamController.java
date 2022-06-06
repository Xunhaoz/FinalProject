package hellofx.Controller.MarketControllers;

import hellofx.Controller.MarketController;
import hellofx.Controller.MusicControllers.BruhController;
import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import hellofx.Controller.MusicControllers.CoinSoundController;
import hellofx.Controller.ViewController;
import hellofx.models.GrandpaTower;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HamController {
    public Button backButton;
    @FXML Label iceCreamLabel;
    @FXML Label hint;
    @FXML Label amountLabel;
    @FXML Label totalLabel;
    @FXML Label hamAmountLabel;
    private int amount = 0;
    private int total = 0;
    private final int hamPrice = 285;
    private static int hamAmount = 0;

    @FXML
    public void initialize() {
        iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
        hamAmountLabel.setText(String.format("%04d", hamAmount));
    }

    public void backToMarket() throws IOException {
        ViewController.toMarket();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }

    public void addTowerHealth() {
        if (total <= MarketController.iceCreamNum && amount > 0){
            CoinSoundController.soundPlay();
            GrandpaTower.chHealth(amount);
            MarketController.iceCreamNum -= total;
            hamAmount += amount;
            amount = 0;
            total = 0;
            iceCreamLabel.setText(String.format("%06d", MarketController.iceCreamNum));
            hamAmountLabel.setText(String.format("%04d", hamAmount));
            amountLabel.setText(String.format("%04d", amount));
            totalLabel.setText(String.format("%06d", total));
            hint.setVisible(true);
            hint.setText("購買成功");
        }
        else if (amount == 0) {
            hint.setVisible(true);
            hint.setText("請選擇購買數量");
            BruhController.bruhPlay();
        }
        else {
            amount = 0;
            total = 0;
            amountLabel.setText(String.format("%04d", amount));
            totalLabel.setText(String.format("%06d", total));
            hint.setVisible(true);
            hint.setText("冰淇淋不足");
            BruhController.bruhPlay();
        }
    }

    public void hamPlus1() {
        if (amount >= 10) {
            hint.setVisible(true);
            hint.setText("一次最多購買10個");
            BruhController.bruhPlay();
        }
        else amount++;
        total = hamPrice * amount;
        amountLabel.setText(String.format("%04d", amount));
        totalLabel.setText(String.format("%06d", total));
    }

    public void hamMinus1() {
        if (amount <= 0) {
            hint.setVisible(true);
            hint.setText("數量不能為負");
            BruhController.bruhPlay();
        }
        else amount--;
        total = hamPrice * amount;
        amountLabel.setText(String.format("%04d", amount));
        totalLabel.setText(String.format("%06d", total));
    }
}
