package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AlienThrowingHand extends Role {

    public static int level = 0;
    public static int thisHp = 185;
    public static int thisAtk = 187;

    private int atkBuff = 0;

    public static void Levelup() {
        if (level < 10) level++;
        thisHp = thisHp + level * 27;
        thisAtk = thisAtk + level * 21;
    }

    public AlienThrowingHand(int x, int y) {
        super(x, y);
        this.health = thisHp;
        this.attack = thisAtk;
        this.CD = 22;
        this.speed = 10;
        this.cost = 450;
        walkImagesArray = new ArrayList<>();
        attackImagesArray = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            walkImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\alienThrowingHand\\walk\\alienWalk" + i + ".png"));
        }
        for (int i = 1; i < 20; i++) {
            attackImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\alienThrowingHand\\attack\\alienAtk" + i + ".png"));
        }
        imageView = new ImageView(walkImagesArray.get(0));
        imageView.setX(this.x);
        imageView.setY(this.y);
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
        atkBuff = 0;
        this.attack = thisAtk;
        AtomicInteger count = new AtomicInteger(1);
        timeline = new Timeline(new KeyFrame(Duration.millis(110), e -> {
            if (count.get() > attackImagesArray.size()) {
                if (this.health < thisHp) minusHealth(-12);
                if (atkBuff < 21) atkBuff ++;
                count.set(1);
            }
            if (count.get() > 11 && count.get() < 15) {
                this.attack = thisAtk + atkBuff * 2;
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
        if (this.status == 1 && canControll) {
            move();
        } else if (this.status == 2 && canControll) {
            attack();
        } else if (this.status == 3) {
            die();
        }
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
}
