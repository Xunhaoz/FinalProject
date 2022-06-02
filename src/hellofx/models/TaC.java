package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TaC extends Role {
    public TaC(int x, int y) {
        super(x, y);
        this.health = 800;
        this.attack = 45;
        this.CD = 1;
        this.speed = 2;
        this.cost = 50;
        walkImagesArray = new ArrayList<>();
        attackImagesArray = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            walkImagesArray.add(new Image("hellofx\\resource\\role\\Enemy\\taC\\walk\\taCWalk" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 5; i++) {
            attackImagesArray.add(new Image("hellofx\\resource\\role\\Enemy\\taC\\attack\\taCAtk" + Integer.toString(i) + ".png"));
        }
        imageView = new ImageView(walkImagesArray.get(0));
        imageView.setX(this.x);
        imageView.setY(this.y);
    }

    private void move() {
        if (this.preStatus == 1) return;
        timeline.stop();
        AtomicInteger count = new AtomicInteger(randomInt.nextInt(3));
        timeline = new Timeline(new KeyFrame(Duration.millis(400), e -> {
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
        timeline = new Timeline(new KeyFrame(Duration.millis(350), e -> {
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
