package hellofx.Controller.MusicControllers;

import hellofx.Controller.ViewController;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicPlayController {
    static File file ;
    static String Mp3play ;
    static Media media ;
    static MediaPlayer mp3 ;
    static String preStage = "" ;

    static public void checkNowStage() {
        //System.out.println(ViewController.nowStageStr);
        // stage 一樣時不用換 music
        if (ViewController.nowStageStr.equals(preStage)) {
            // System.out.println(mp3.getVolume());
            return ;
        }

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
        else if (ViewController.nowStageStr.equals("level")) {
            file = new File("src\\hellofx\\music\\levelMusic.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("EnemyIntro")) {
            file = new File("src\\hellofx\\music\\EnemyInfo.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("HeroIntro")) {
            file = new File("src\\hellofx\\music\\HeroInfo.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("firstLevel")) {
            file = new File("src\\hellofx\\music\\firstLevelMusic.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("SecondLevel")) {
            file = new File("src\\hellofx\\music\\FinalProjectmusic\\stage2.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("ThirdLevel")) {
            file = new File("src\\hellofx\\music\\FinalProjectmusic\\stage3.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("market")) {
            file = new File("src\\hellofx\\music\\FinalProjectmusic\\shop.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("trash")) {
            file = new File("src\\hellofx\\music\\FinalProjectmusic\\垃圾場.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("Win")) {
            file = new File("src\\hellofx\\music\\FinalProjectmusic\\過關音效.mp3") ;
        }
        else if (ViewController.nowStageStr.equals("Lose")) {
            file = new File("src\\hellofx\\music\\FinalProjectmusic\\失敗音樂.mp3") ;
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
        mp3.setVolume(MusicController.getVolume());
        mp3.play();

        // System.out.println(mp3.getVolume());
    }
}
