package hellofx.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class GrandpaTower extends Role {
    public GrandpaTower(int x, int y) {
        super(x, y);
        this.health = 100;
        this.attack = 10;
        walkImagesArray = new ArrayList<>();
        walkImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\grandpaTower\\grandpaTower.png"));
        imageView = new ImageView(walkImagesArray.get(0));
        this.bounds = imageView.getLayoutBounds();
        imageView.setX(this.x);
        imageView.setY(this.y);
        imageView.setFitHeight(330.6);
        imageView.setFitWidth(239.3);
    }
}
