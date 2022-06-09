package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FreshChick extends Role {

    public static int level = 0;
    public static int thisHp = 320;
    public static int thisAtk = 12;

    public static void Levelup() {
        if (level < 10) level++;
        thisHp = thisHp + level * 25;
        thisAtk = thisAtk + level * 2;
    }

    public FreshChick(int x, int y) {
        super(x, y);
        this.health = thisHp;
        this.attack = thisAtk;
        this.CD = 4;
        this.speed = 14;
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
            if (count.get() % 4 == 0) canAttack = true;
            imageView.setImage(attackImagesArray.get((count.getAndIncrement()) % 4));
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

    public void addBuff(int hp, int atk) {
        if (hp < 0) {
            this.health += hp * Yams.level + level * 5 - 10;
            this.attack += atk * Yams.level + level - 1;
        }
        else {
            this.health += hp * Yams.level;
            this.attack += atk * Yams.level;
        }
    }
}
