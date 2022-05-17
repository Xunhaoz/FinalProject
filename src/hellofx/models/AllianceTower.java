package hellofx.models;

import hellofx.controller.FirstLevelController;
import javafx.fxml.FXML;
import javafx.scene.image.Image;

import javax.swing.text.Element;
import javafx.scene.image.ImageView;

public class AllianceTower {

    private final ImageView imageView;

    public AllianceTower(double x, double y){
        imageView = new ImageView(new Image("C:\\Users\\leo20\\Desktop\\FinalProject\\src\\hellofx\\resource\\tower\\grandpaTower.png"));
        double heigh = 30;
        imageView.setFitHeight(heigh);
        double width = 25;
        imageView.setFitWidth(width);
        imageView.setX(x);
        imageView.setY(y);
    }

    public ImageView getImageView(){
        return imageView;
    }



}
