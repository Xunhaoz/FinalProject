package hellofx.MusicControllers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class ButtonSoundPlayController {
    static File file ;
    static String Mp3play ;
    static Media media ;
    static MediaPlayer mp3 ;

    static public void buttonSoundPlay() {
        file = new File("src\\hellofx\\MusicControllers\\sound\\buttonSound.mp3") ;

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
