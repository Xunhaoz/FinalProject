package hellofx.mainController;

import hellofx.MusicControllers.ButtonSoundPlayController;
import hellofx.MusicControllers.MusicPlayController;
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

    final private String[] customers = {"leo20020529@gmail.com", "sundayevening2249@gmail.com", "orianna901001@gmail.com", "leo20020529@gmail.com"};

    @FXML
    public void sendMail() {
        if (check()) return;

        String index = emailSelect.getSelectedToggle().getUserData().toString();
        String subject = textField.getText();
        String txt = textArea.getText();

        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.debug", "true");

        String userName = "leo20020529@gmail.com";
        String password = "jdamrgkzzsibowsw";

        Auth auth = new Auth(userName, password);
        Session session = Session.getDefaultInstance(prop, auth);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(customers[Integer.parseInt(index)]));
            message.setSubject(subject);
            message.setContent(txt, "text/html;charset = UTF-8");
            Transport transport = session.getTransport();
            Transport.send(message);
            transport.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        label.setText("寄件成功");
        emailSelect.getSelectedToggle().setSelected(false);
        textArea.setText("");
        textField.setText("");
        ButtonSoundPlayController.buttonSoundPlay();
    }

    @FXML
    public void mailboxToStart() throws IOException {
        ViewController.toStart();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
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

    final private String userName;
    final private String password;

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