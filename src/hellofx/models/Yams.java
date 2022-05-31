package hellofx.models;

import com.sun.mail.handlers.image_gif;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Yams extends Role {

    private ArrayList<ArrayList<Image>> allWalkImagesArray;
    private ArrayList<ArrayList<Image>> allAttackImagesArray;
    private int characteristic = -1;
    //0 green 1 yellow 2 purple


    private void getResource() {
        ArrayList<Image> bad_walkImagesArray = new ArrayList<>();
        ArrayList<Image> excellent_walkImagesArray = new ArrayList<>();
        ArrayList<Image> regular_walkImageArray = new ArrayList<>();
        ArrayList<Image> bad_attackImagesArray = new ArrayList<>();
        ArrayList<Image> excellent_attackImagesArray = new ArrayList<>();
        ArrayList<Image> regular_attackImageArray = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            bad_walkImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\yams\\badYam\\walk\\badYamWalk" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 4; i++) {
            excellent_walkImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\yams\\excellentYam\\walk\\excellentYamWalk" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 4; i++) {
            regular_walkImageArray.add(new Image("hellofx\\resource\\role\\Hero\\yams\\regularYam\\walk\\regularYamWalk" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 5; i++) {
            bad_attackImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\yams\\badYam\\attack\\badYamAtk" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 12; i++) {
            excellent_attackImagesArray.add(new Image("hellofx\\resource\\role\\Hero\\yams\\excellentYam\\attack\\excellentYamAtk" + Integer.toString(i) + ".png"));
        }
        for (int i = 1; i < 8; i++) {
            regular_attackImageArray.add(new Image("hellofx\\resource\\role\\Hero\\yams\\regularYam\\attack\\regularYamAtk" + Integer.toString(i) + ".png"));
        }

        allWalkImagesArray = new ArrayList<>();
        allWalkImagesArray.add(bad_walkImagesArray);
        allWalkImagesArray.add(excellent_walkImagesArray);
        allWalkImagesArray.add(regular_walkImageArray);

        allAttackImagesArray = new ArrayList<>();
        allAttackImagesArray.add(bad_attackImagesArray);
        allAttackImagesArray.add(excellent_attackImagesArray);
        allAttackImagesArray.add(regular_attackImageArray);
    }

    public Yams(int x, int y, int characteristic) {
        super(x, y);
        this.health = 100;
        this.attack = 50;
        this.CD = 1;
        this.speed = 5;
        this.cost = 200;
        getResource();
        this.characteristic = characteristic;
        this.imageView = new ImageView(allWalkImagesArray.get(this.characteristic).get(0));
        if (this.characteristic == 0)
            this.x = 947;
        else if (this.characteristic == 1)
            this.x = 763;
        else if (this.characteristic == 2)
            this.x = 830;
        imageView.setX(this.x);
        imageView.setY(this.y);
    }

    public void move() {
        if (this.preStatus == 1) return;
        timeline.stop();
        AtomicInteger count = new AtomicInteger(randomInt.nextInt(2));
        timeline = new Timeline(new KeyFrame(Duration.millis(300), e -> {
            imageView.setImage(allWalkImagesArray.get(this.characteristic).get(count.getAndIncrement() % allWalkImagesArray.get(this.characteristic).size()));
            this.imageView.setY(this.y);
            this.imageView.setX(this.x);
            this.x -= this.speed;
            this.bounds = imageView.getBoundsInParent();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    public void attack() {
        if (this.preStatus == 2) return;
        timeline.stop();
        AtomicInteger count = new AtomicInteger(1);
        int finalChangePics = allAttackImagesArray.get(this.characteristic).size();
        timeline = new Timeline(new KeyFrame(Duration.millis(250), e -> {
            if(count.get()%4 == 0) canAttack = true;
            imageView.setImage(allAttackImagesArray.get(this.characteristic).get(count.getAndIncrement() % finalChangePics));
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
