package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SalmonSteak extends Role {
    public static int level = 0;

    public static void Levelup() {
        if (level < 10) level++;
    }

    public SalmonSteak(int x, int y) {
        super(x, y);
        this.health = 540 + level * 55;
        this.attack = 5 + level;
        this.CD = 6;
        this.speed = 13;
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
        timeline = new Timeline(new KeyFrame(Duration.millis(200), e -> {
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

    public void lag() {
        this.x += 20;
        timeline.stop();
        canControll = false;
        timeline = new Timeline();
        for (int i = 0; i < 25; i++) {
            KeyFrame keyFrame;
            if (i == 0) {
                keyFrame = new KeyFrame(new Duration(1800), e -> {
                    canControll = false;
                });
            } else if (i == 24) {
                keyFrame = new KeyFrame(new Duration(150 * i), e -> {
                    canControll = true;
                    status = 4;
                });
            } else if (i % 2 == 0) {
                keyFrame = new KeyFrame(new Duration(150 * i), e -> {
                    this.x -= 5;
                    imageView.setX(this.x);
                });
            } else {
                keyFrame = new KeyFrame(new Duration(150 * i), e -> {
                    this.x += 5;
                    imageView.setX(this.x);
                });
            }
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }

    public void knockBack() {
        timeline.stop();
        canControll = false;
        timeline = new Timeline();
        for (int i = 0; i < 25; i++) {
            KeyFrame keyFrame;
            if (i == 0) {
                keyFrame = new KeyFrame(new Duration(25), e -> {
                    canControll = false;
                });
            } else if (i == 24) {
                keyFrame = new KeyFrame(new Duration(25 * i), e -> {
                    canControll = true;
                    status = 4;
                });
            } else if (i < 12) {
                keyFrame = new KeyFrame(new Duration(25 * i), e -> {
                    this.x += 5;
                    this.y -= 6;
                    imageView.setX(this.x);
                    imageView.setY(this.y);
                });
            } else {
                keyFrame = new KeyFrame(new Duration(25 * i), e -> {
                    this.x += 5;
                    this.y +=6;
                    imageView.setX(this.x);
                    imageView.setY(this.y);
                });
            }
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }
}
