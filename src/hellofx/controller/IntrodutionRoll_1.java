package hellofx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;




public class IntrodutionRoll_1  {
    @FXML
    public Button last;
    @FXML
    public Button next;
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    @FXML
    public Button button_close;
    @FXML
    TextField textFile;
    @FXML
    TextArea textArea;


    @FXML
    public void page_last() throws IOException{


    }


    @FXML
    public void page_close() throws IOException {
        ViewController.toDorm();
    }
    //close introduction of character's page

    @FXML
    public void page_1() throws IOException {
        ViewController.toPage_1();
        // turn to page1 of introduction of character

    }

    @FXML
    public void page_2()throws IOException{
        ViewController.toPage_2();
        // turn to page2 of introduction of character
    }

    @FXML
    public void page_3()throws IOException{
        ViewController.toPage_3();
        // turn to page3 of introduction of character
    }

    @FXML
    public void page_4()throws IOException{
        ViewController.toPage_4();
        // turn to page4 of introduction of character
    }

    public void DorCharacterToSetting() throws IOException {
        ViewController.toSetting();
    }
}
