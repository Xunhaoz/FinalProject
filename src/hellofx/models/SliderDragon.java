package hellofx.models;

import hellofx.controller.FirstLevelController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class SliderDragon {
    ImageView imageView;

    String[] statuses = {"attack", "move", "die"};
    private String status = "";

    static private int imageIndex = 0;
    ArrayList<ImageView> imageViewList = new ArrayList<>();
    private double x;
    private double y;
    double heigh = 200;
    double width = 200;


    public SliderDragon(double x, double y) {
        imageView = new ImageView(new Image("C:\\Users\\leo20\\Desktop\\FinalProject\\src\\hellofx\\resource\\sliderDragon\\sliderDragon00.png"));
        for(int i=0;i<7;i++){
            imageViewList.add(new ImageView(new Image("C:\\Users\\leo20\\Desktop\\FinalProject\\src\\hellofx\\resource\\sliderDragon\\sliderDragon0" + Integer.toString(i) + ".png")));

        }
        imageView.setFitHeight(heigh);
        imageView.setFitWidth(width);
        this.x = x;
        this.y = y;
        imageView.setX(this.x);
        imageView.setY(this.y);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void move() {
        System.out.println(imageIndex);
        this.x += 10;

        imageView.setX(this.x);
        if(imageIndex == 7) imageIndex = 0;

        imageView = imageViewList.get(imageIndex);
        imageView.setFitWidth(this.width);
        imageView.setFitHeight(this.heigh);
        imageView.setX(this.x);
        imageView.setX(this.y);
        imageIndex++;
    }

    public double getX() {
        return this.x;
    }



    public void updateStatus(){
        if(false){
            status = statuses[0];
        }
        else{
            status = statuses[1];
            move();
        }
    }
}
