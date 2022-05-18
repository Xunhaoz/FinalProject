package hellofx.models;

import hellofx.controller.FirstLevelController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FreshChick extends Role {


    public FreshChick(int x, int y) {
        super(x, y);
        this.health = 100;
        this.attack = 10;
        this.CD = 1;
        this.speed = 5;
        walkImagesArray = new ArrayList<>();
        attackImagesArray = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            walkImagesArray.add(new Image("C:\\Users\\leo20\\Desktop\\FinalProject\\src\\hellofx\\resource\\role\\Hero\\freshChick\\walk\\freshChickWalking" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 5; i++) {
            attackImagesArray.add(new Image("C:\\Users\\leo20\\Desktop\\FinalProject\\src\\hellofx\\resource\\role\\Hero\\freshChick\\attack\\freshChickAtk" + Integer.toString(i) + ".png"));
        }
        imageView = new ImageView(walkImagesArray.get(0));
        imageView.setX(this.x);
        imageView.setY(this.y);
    }

    private void move(int preStatus) {
        if(preStatus == 1) return;
        timeline.stop();
        AtomicInteger count = new AtomicInteger(1);
        timeline = new Timeline(new KeyFrame(Duration.millis(300), e -> {

            imageView.setImage(walkImagesArray.get((count.getAndIncrement()) % 5));
            this.imageView.setY(this.y);
            this.imageView.setX(this.x);
            this.x -= this.speed;
            this.bounds = imageView.getBoundsInParent();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void attack(int preStatus) {
        if(preStatus == 2) return;
        AtomicInteger count = new AtomicInteger(1);
        timeline.stop();
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            imageView.setImage(attackImagesArray.get((count.getAndIncrement()) % 4));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    private void die() {
        imageView.setImage(new Image("C:\\Users\\leo20\\Desktop\\FinalProject\\src\\hellofx\\resource\\role\\death.png"));
    }



    public void portal(int status) {
        int preStatus = this.status;
        this.status = status;
        if (this.status == 1) {
            move(preStatus);
        } else if (this.status == 2) {
            attack(preStatus);
        } else if (this.status == 3) {
            die();
        }
    }

    public void setBounds(){
        this.bounds = imageView.getBoundsInParent();
    }

}
