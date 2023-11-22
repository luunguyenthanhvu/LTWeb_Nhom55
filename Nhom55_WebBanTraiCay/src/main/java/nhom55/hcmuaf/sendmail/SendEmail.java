package nhom55.hcmuaf.sendmail;

import nhom55.hcmuaf.services.RegisterService;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    private String userEmail;
    private String hash;

    public SendEmail(String userEmail, String hash) {
        super();
        this.userEmail =userEmail;
        this.hash = hash;
    }

    public void sendEmail() {
        RegisterService.verifyAccount (userEmail, hash);

    }
}
