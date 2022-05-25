package hellofx;

import hellofx.controller.MusicController;
import hellofx.controller.MusicPlayController;
import javafx.application.Application;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import hellofx.controller.ViewController;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

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