package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Xunhaoz extends Role {


    public static int level = 0;

    public static void Levelup() {
        if (level <= 10) level++;
    }

    public Xunhaoz(int x, int y) {
        super(x, y);
        this.health = 200;
        this.attack = 34;
        this.CD = 1;
        this.speed = 10;
        this.cost = 50;
        walkImagesArray = new ArrayList<>();
        attackImagesArray = new ArrayList<>();

        walkImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\Xunhoaz\\xunhaozWalk1.png"));
        walkImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\Xunhoaz\\xunhaozWalk2.png"));
        attackImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\Xunhoaz\\xunhaozWalk1.png"));
        attackImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\Xunhoaz\\xunhaozWalk2.png"));
        imageView = new ImageView(walkImagesArray.get(0));
        imageView.setX(this.x);
        imageView.setY(this.y);
        imageView.setFitHeight(82);
        imageView.setFitWidth(183);
    }


    private void move() {
        if (this.preStatus == 1) return;
        timeline.stop();

        AtomicInteger count = new AtomicInteger(randomInt.nextInt(11));
        timeline = new Timeline(new KeyFrame(Duration.millis(300), e -> {
            imageView.setImage(walkImagesArray.get((count.getAndIncrement()) % walkImagesArray.size()));
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
            if (count.get() % attackImagesArray.size() == 0) canAttack = true;
            imageView.setImage(attackImagesArray.get((count.getAndIncrement()) % attackImagesArray.size()));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    public void portal(int status) {
        preStatus = this.status;
        this.status = status;
        if (this.status == 1 && canControll) {
            move();
        } else if (this.status == 2 && canControll) {
            attack();
        } else if (this.status == 3) {
            die();
        }
    }
}