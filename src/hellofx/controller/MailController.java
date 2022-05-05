package hellofx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.io.IOException;
import java.util.Properties;

public class MailController {
    @FXML
    ToggleGroup emailSelect = new ToggleGroup();
    @FXML
    TextField textField = new TextField();
    @FXML
    TextArea textArea = new TextArea();

    @FXML
    Label label = new Label();

    String[] emailList = {"leo20020529@gmail.com", "boson13579@gmail.com", "leo20020529@gmail.com", "leo20020529@gmail.com"};

    public void warning() {
        label.setText("選項、寄件人信箱、內容 不得為空");
    }


    private String userName = "leo20020529@gmail.com"; // 寄件者信箱
    private String password = "iwannagf"; // 寄件者密碼
    private String customer = "boson13579@gmail.com"; // 收件者郵箱
    private String subject = "測試郵件"; // 標題
    private String txt = "<h1>郵件內容</h1><h2>文字內容</h2>"; // 內容

    @FXML
    public void send() {
        // ---------------------------------------------------------連線設定
        Properties prop = new Properties();

        // 設定連線為smtp
        prop.setProperty("mail.transport.protocol", "smtp");

        // host主機:smtp.gmail.com
        prop.setProperty("mail.host", "smtp.gmail.com");

        // host port:465
        prop.put("mail.smtp.port", "465");

        // 寄件者帳號需要驗證：是
        prop.put("mail.smtp.auth", "true");

        // 需要安全資料傳輸層 (SSL)：是
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // 安全資料傳輸層 (SSL) 通訊埠：465
        prop.put("mail.smtp.socketFactory.port", "465");

        // 顯示連線資訊
        prop.put("mail.debug", "true");

        // ---------------------------------------------------------驗證
        // ---------------------------------------------------------Session默認屬性設定值
        // 匿名類別
//		Session session = Session.getDefaultInstance(prop, new Authenticator() {
//
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(userName, password);
//			}
//		});

        // class
        Auth auth = new Auth(userName, password);
        Session session = Session.getDefaultInstance(prop, auth);

        // ---------------------------------------------------------Message郵件格式
        MimeMessage message = new MimeMessage(session);

        try {
            // 寄件者
            // 匿名類別
            // message.setSender(new InternetAddress(userName));

            // class
            InternetAddress sender = new InternetAddress(userName);
            message.setSender(sender);

            // 收件者
            message.setRecipient(RecipientType.TO, new InternetAddress(customer));

            // 標題
            message.setSubject(subject);

            // 內容/格式
            message.setContent(txt, "text/html;charset = UTF-8");


            // ---------------------------------------------------------Transport傳送Message
            Transport transport = session.getTransport();

            // transport將message送出
            transport.send(message);

            // 關閉Transport
            transport.close();

        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    @FXML
    public void mailboxToStart() throws IOException {
        ViewController.toStart();
    }
}

class Auth extends Authenticator {

    private String userName;
    private String password;

    public Auth(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication pa = new PasswordAuthentication(userName, password);
        return pa;
    }

}