package hellofx.Controller.MusicControllers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class CoinSoundController {
    static File file ;
    static String Mp3play ;
    static Media media ;
    static MediaPlayer mp3 ;

    public static String chaseButton;

    static public void soundPlay() {
        file = new File("src\\hellofx\\music\\FinalProjectmusic\\購買音效.mp3") ;

        try {
            Mp3play = file.toURI().toURL().toString() ;
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace()) ;
        }
        media = new Media(Mp3play) ;
        mp3 = new MediaPlayer(media) ;

        mp3.setVolume(MusicController.getButtonVolume());
        mp3.play();
    }

}
