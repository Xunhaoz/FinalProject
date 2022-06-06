package hellofx.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Role {
    protected int health = 0;
    protected int attack = 0;
    protected int speed = 0;
    protected int CD = 0;
    protected int cost = 0;
    protected int x;
    protected int y;
    protected ImageView imageView;
    protected int status = -1;
    protected int preStatus;
    // 1 : move, 2 : attack, 3 : die
    protected boolean canAttack;
    protected boolean canDie;
    //0 can't attack 1 can attack
    protected Timeline timeline = new Timeline();
    protected ArrayList<Image> walkImagesArray;
    protected ArrayList<Image> attackImagesArray;
    protected Random randomInt = new Random();
    protected Bounds bounds;
    protected boolean canControll = true;

    public Role(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public ImageView getImageview() {
        return this.imageView;
    }

    public void minusHealth(int minus) {
        this.health -= minus;
    }

    public int getATK() {
        return attack;
    }

    public int getHealth() {
        return this.health;
    }

    public int getX() {return this.x;}

    public void setBounds() {
        this.bounds = imageView.getBoundsInParent();
    }

    protected void die() {
        if (preStatus == 3) return;
        timeline.stop();
        AtomicInteger count = new AtomicInteger();
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            count.getAndIncrement();
            this.y -= count.get() * 3;
            imageView.setY(this.y);
            imageView.setOpacity(1 - (count.floatValue() * 0.125));
            if (count.get() == 8) canDie = true;
            imageView.setImage(new Image("hellofx\\resource\\role\\death.png"));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public boolean getCanAttack() {
        return canAttack;
    }

    public boolean getCanDie() {
        return canDie;
    }

    public void initCanAttack() {
        canAttack = false;
    }

    public void stopTimeline() {
        timeline.stop();
    }

    public int getStatus() {
        return status;
    }

    public void lag() {
        this.x += 20;
        timeline.stop();
        canControll = false;
        AtomicInteger count = new AtomicInteger();
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            count.getAndIncrement();
            if(count.get() == 50){
                canControll = true;
            }

            if (count.get() % 2 == 0) this.x += 5;
            else this.x -= 5;
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

}
