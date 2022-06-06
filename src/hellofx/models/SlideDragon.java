package hellofx.models;

import hellofx.Controller.MusicControllers.SlideDragonSoundController;
import hellofx.Controller.gameControllers.ThirdLevelController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SlideDragon extends Role {
    public SlideDragon(int x, int y) {
        super(x, y);
        this.health = 400;
        this.attack = 48;
        this.CD = 1;
        this.speed = 50;
        this.cost = 50;
        walkImagesArray = new ArrayList<>();
        attackImagesArray = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            walkImagesArray.add(new Image("hellofx\\resource\\role\\Enemy\\slideDragon\\newWalk\\slideDragonWalking" + i + ".png"));
        }
        for (int i = 1; i < 36; i++) {
            attackImagesArray.add(new Image("hellofx\\resource\\role\\Enemy\\slideDragon\\attack\\slideDragonAtk" + i + ".png"));
        }
        imageView = new ImageView(walkImagesArray.get(0));
        imageView.setX(this.x);
        imageView.setY(this.y);
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
        timeline = new Timeline(new KeyFrame(Duration.millis(400), e -> {
            if (count.get() > attackImagesArray.size()) {
                count.set(1);
            }
            if (count.get() == 15 && !ThirdLevelController.allTimelineStop) {
                SlideDragonSoundController.dragonSoundPlay();
            }
            if (count.get() > 26 && count.get() < 33) {
                canAttack = true;
            }
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
