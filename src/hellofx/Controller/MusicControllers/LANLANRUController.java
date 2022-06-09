package hellofx.Controller.MusicControllers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class LANLANRUController {
    static File file ;
    static String Mp3play ;
    static Media media ;
    static MediaPlayer mp3 ;

    static public void LanLanRuPlay() {
        file = new File("src\\hellofx\\music\\LANLANRU.mp3") ;

        try {
            Mp3play = file.toURI().toURL().toString() ;
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace()) ;
        }
        media = new Media(Mp3play) ;
        mp3 = new MediaPlayer(media) ;

        mp3.setVolume(1.0);
        mp3.play();
    }
}
