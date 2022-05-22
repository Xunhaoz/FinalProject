package hellofx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media ;

import java.io.File;
import java.io.IOException;

public class MusicController {
    static private double volume = 0.5;
    static File file ;
    static String Mp3play ;
    static Media media ;
    static MediaPlayer mp3 ;
    static String preStage = "" ;

    @FXML
    Slider slider;

    @FXML
    public void initialize() {
        slider.setMax(1);
        slider.setMin(0);
        slider.setValue(volume);
        slider.setShowTickLabels(true);
    }

    @FXML
    public void voiceToSetting() throws IOException {
        ViewController.toSetting();
    }

    @FXML
    public void setVolume() {
        volume = slider.getValue();
        mp3.setVolume(volume);
    }

    static public double getVolume(){
        return volume;
    }
    
    static public void checkNowStage() {
        System.out.println(ViewController.nowStageStr);
        // stage 一樣時不用換 music
        if (ViewController.nowStageStr.equals(preStage)) return ;

        // 進入遊戲後不用停掉上個 stage 的音樂
        if (!preStage.equals("")) {
            mp3.stop();
        }

        preStage = ViewController.nowStageStr ;

        if (ViewController.nowStageStr.equals("start")) {
            file = new File("src\\hellofx\\music\\startPageMusic.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("setting")) {
            file = new File("src\\hellofx\\music\\settingMusic.mp3") ;
        }
        // else if ()
        else {
            mp3.stop();
            return;
        }

        try {
            Mp3play = file.toURI().toURL().toString() ;
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace()) ;
        }
        media = new Media(Mp3play) ;
        mp3 = new MediaPlayer(media) ;

        // 循環播放
        mp3.setCycleCount(MediaPlayer.INDEFINITE);
        mp3.play();
    }
}
