package hellofx;

import hellofx.Controller.MusicControllers.MusicPlayController;
import javafx.application.Application;
import javafx.stage.Stage;
import hellofx.Controller.ViewController;

import java.io.IOException;

public class csWarApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewController.nowStage = stage;
        ViewController.toStart() ;
        MusicPlayController.checkNowStage();

        ViewController.nowStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}