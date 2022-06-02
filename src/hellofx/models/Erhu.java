package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Erhu extends Role {
    public Erhu(int x, int y) {
        super(x, y);
        this.health = 4000;
        this.attack = 42;
        this.CD = 1;
        this.speed = 2;
        this.cost = 50;
        walkImagesArray = new ArrayList<>();
        attackImagesArray = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            walkImagesArray.add(new Image("hellofx\\resource\\role\\Enemy\\erhu\\walk\\erhuWalk" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 6; i++) {
            attackImagesArray.add(new Image("hellofx\\resource\\role\\Enemy\\erhu\\attack\\erhuAtk" + Integer.toString(i) + ".png"));
        }
        imageView = new ImageView(walkImagesArray.get(0));
        imageView.setX(this.x);
        imageView.setY(this.y);
        imageView.setFitWidth(270.0);
        imageView.setFitHeight(224.7);
    }

    private void move() {
        if (this.preStatus == 1) return;
        timeline.stop();
        AtomicInteger count = new AtomicInteger(randomInt.nextInt(3));
        timeline = new Timeline(new KeyFrame(Duration.millis(250), e -> {
            imageView.setImage(walkImagesArray.get((count.getAndIncrement()) % walkImagesArray.size()));
            this.imageView.setY(this.y);
            this.imageView.setX(this.x);
            this.x += this.speed;
            this.bounds = imageView.getBoundsInParent();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void attack() {
        if (this.preStatus == 2) return;
        timeline.stop();
        AtomicInteger count = new AtomicInteger(1);
        timeline = new Timeline(new KeyFrame(Duration.millis(295), e -> {
            if(count.get()%3 == 0) canAttack = true;
            imageView.setImage(attackImagesArray.get((count.getAndIncrement()) % attackImagesArray.size()));
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

