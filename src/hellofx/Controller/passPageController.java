package hellofx.Controller;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.LANLANRUController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class passPageController {
    public Button backButton;
    public TextField textField;
    public Label label;
    public Button button;

    public void passToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
    public void passToLevel() throws IOException {
        if (!RouteController.hasPassword) return;
        ViewController.toLevel();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
    @FXML
    public void submitPassword() {
        if (textField.getText().equals("")) {
            label.setText("未輸入導師密碼卡，請去信箱寄信獲取導師密碼卡");
            label.setVisible(true);
        }
        else if (!textField.getText().equals("") && !textField.getText().equals("NEVER_CARE_U")){
            label.setText("導師密碼卡輸入錯誤，請確認過後重新輸入");
            label.setVisible(true);
        }
        else if (textField.getText().equals("NEVER_CARE_U")) {
            RouteController.hasPassword = true;
            label.setText("導師密碼卡輸入完成，點擊「開始選課」即可進行選課作業！");
            label.setVisible(true);
            button.setVisible(true);
        }
    }
}
