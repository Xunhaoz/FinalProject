package hellofx.models;

import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Role {
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
    protected Timeline timeline = new Timeline();
    protected ArrayList<Image> walkImagesArray;
    protected ArrayList<Image> attackImagesArray;
    protected Bounds bounds;

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

    public void setBounds() {
        this.bounds = imageView.getBoundsInParent();
    }

    protected void die() {
        timeline.stop();
        imageView.setImage(new Image("hellofx\\resource\\role\\role\\death.png"));
    }

    protected int getCost() {
        return cost;
    }

}
