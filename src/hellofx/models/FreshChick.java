package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FreshChick extends Role {

    public static int level = 0;
    public static void Levelup() {
        if (level <= 10)
            level++;
    }
    public FreshChick(int x, int y) {
        super(x, y);
        this.health = 720 + level*30;
        this.attack = 34;
        this.CD = 1;
        this.speed = 10;
        this.cost = 50;
        walkImagesArray = new ArrayList<>();
        attackImagesArray = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            walkImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\freshChick\\walk\\freshChickWalking" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 5; i++) {
            attackImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\freshChick\\attack\\freshChickAtk" + Integer.toString(i) + ".png"));
        }
        imageView = new ImageView(walkImagesArray.get(0));
        imageView.setX(this.x);
        imageView.setY(this.y);
    }



    private void move() {
        if (this.preStatus == 1) return;
        timeline.stop();

        AtomicInteger count = new AtomicInteger(randomInt.nextInt(4));
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

    private void attack() {
        if (this.preStatus == 2) return;
        timeline.stop();
        AtomicInteger count = new AtomicInteger(1);
        timeline = new Timeline(new KeyFrame(Duration.millis(110), e -> {
            if(count.get()%4 == 0) canAttack = true;
            imageView.setImage(attackImagesArray.get((count.getAndIncrement()) % 4));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    public void portal(int status) {
        preStatus = this.status;
        this.status = status;
        if (this.status == 1) {
            move();
        } else if (this.status == 2) {
            attack();
        } else if (this.status == 3) {
            die();
        }
    }
}
