package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SalmonSteak extends Role {
    public SalmonSteak(int x, int y) {
        super(x, y);
        this.health = 1500;
        this.attack = 20;
        this.CD = 1;
        this.speed = 5;
        this.cost = 100;
        walkImagesArray = new ArrayList<>();
        attackImagesArray = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            walkImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\salmonSteak\\walk\\salmonSteakWalking" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 7; i++) {
            attackImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\salmonSteak\\attack\\salmonSteakAtk" + Integer.toString(i) + ".png"));
        }
        imageView = new ImageView(walkImagesArray.get(0));
        imageView.setX(this.x);
        imageView.setY(this.y);
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

    private void move() {
        if (this.preStatus == 1) return;
        timeline.stop();
        AtomicInteger count = new AtomicInteger(randomInt.nextInt(5));
        timeline = new Timeline(new KeyFrame(Duration.millis(300), e -> {
            int jheight = (count.getAndIncrement()) % walkImagesArray.size();
            imageView.setImage(walkImagesArray.get(jheight));
            this.imageView.setY(this.y + jheight * 5);
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
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            if(count.get()%4 == 0) canAttack = true;
            imageView.setImage(attackImagesArray.get((count.getAndIncrement()) % attackImagesArray.size()));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


}
