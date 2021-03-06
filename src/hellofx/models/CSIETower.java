package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CSIETower extends Role {

    public void chHealth(int a) {
        this.health += a;
    }

    public CSIETower(int x, int y) {
        super(x, y);
        this.attack = 10;
        this.health = 10000;
        walkImagesArray = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            walkImagesArray.add(new Image("hellofx\\resource\\role\\Enemy\\ciseTowers\\csieTower" + Integer.toString(i) + ".png"));
        }
        imageView = new ImageView(walkImagesArray.get(0));
        this.bounds = imageView.getLayoutBounds();
        imageView.setX(this.x);
        imageView.setY(this.y);
    }

    public void move() {
        timeline.stop();
        AtomicInteger count = new AtomicInteger(1);
        timeline = new Timeline(new KeyFrame(Duration.millis(600), e -> {
            imageView.setImage(walkImagesArray.get((count.getAndIncrement()) % 3));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }
}
