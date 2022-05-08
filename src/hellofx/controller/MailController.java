package hellofx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailController {
    @FXML
    ToggleGroup emailSelect;
    @FXML
    TextField textField;
    @FXML
    TextArea textArea;
    @FXML
    Label label;

    private String userName = "leo20020529@gmail.com"; // 寄件者信箱
    private String password = "jdamrgkzzsibowsw"; // 寄件者密碼
    private String[] customers = {"leo20020529@gmail.com", "boson13579@gmail.com", "leo20020529@gmail.com", "leo20020529@gmail.com"}; // 收件者郵箱
    private String subject;
    private String txt;

    @FXML
    public void sendMail() {
        if (check()) return;
        String index = emailSelect.getSelectedToggle().getUserData().toString();
        subject = textField.getText();
        txt = textArea.getText();

        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.debug", "true");

        Auth auth = new Auth(userName, password);
        Session session = Session.getDefaultInstance(prop, auth);
        MimeMessage message = new MimeMessage(session);
        try {
            InternetAddress sender = new InternetAddress(userName);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(customers[Integer.parseInt(index)]));
            message.setSubject(subject);
            message.setContent(txt, "text/html;charset = UTF-8");
            Transport transport = session.getTransport();
            transport.send(message);
            transport.close();

        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        label.setText("寄件成功");
        emailSelect.getSelectedToggle().setSelected(false);
        textArea.setText("");
        textField.setText("");
    }

    @FXML
    public void mailboxToStart() throws IOException {
        ViewController.toStart();
    }

    @FXML
    public void debugger() {
        System.out.println(Integer.parseInt(emailSelect.getSelectedToggle().getUserData().toString()));
    }

    public boolean check() {
        if (emailSelect.getSelectedToggle() == null) {
            label.setText("未選擇收件人");
            return true;
        }
        if (textField.getText().isEmpty()) {
            label.setText("未輸入標題");
            return true;
        }
        if (textArea.getText().isEmpty()) {
            label.setText("未輸入內容");
            return true;
        }
        return false;
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