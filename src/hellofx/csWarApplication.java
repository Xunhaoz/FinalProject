package hellofx;

import javafx.application.Application;
import javafx.stage.Stage;
import hellofx.controller.ViewController;

import java.io.IOException;

public class csWarApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewController.nowStage = stage;
        ViewController.toStart();
        ViewController.nowStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}