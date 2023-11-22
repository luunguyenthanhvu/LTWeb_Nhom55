package nhom55.hcmuaf.services;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.dao.UsersDao;
import nhom55.hcmuaf.dao.UsersDaoImpl;
import nhom55.hcmuaf.database.JDBIConnector;
import nhom55.hcmuaf.sendmail.MailProperties;
import nhom55.hcmuaf.sendmail.SendEmail;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class RegisterService {
    private static RegisterService instance;
    private UsersDao usersDao;

    public RegisterService() {
        usersDao = new UsersDaoImpl ();
    }

    public static RegisterService getInstance() {
        if (instance == null) {
            instance = new RegisterService();
        }
        return instance;
    }

    public String RegisterUser(Users register) {
        String result = "";
        String username = register.getUsername ();
        String phoneNumber = register.getPhoneNumber ();
        String address = register.getAddress ();
        String email = register.getEmail ();
        String password = register.getPassword ();
        String hash = register.getHash ();

        List<Users> users = usersDao.getUserByEmail (email);

        if (users.size() > 0) return "had user";
        result = usersDao.addNewUser (username, password, hash, email, phoneNumber, address);

        verifyAccount (email, hash);

        return result;
    }

    public static void verifyAccount(String email, String hash) {
        Properties properties = MailProperties.getSMTPPro();
        Session session = Session.getInstance (properties,new javax.mail.Authenticator () {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication (MailProperties.getEmail (), MailProperties.getPassword ());
            }
        });

        try {
            Message message = new MimeMessage (session);
            message.setFrom (new InternetAddress (MailProperties.getEmail ()));
            message.addRecipient (Message.RecipientType.TO, new InternetAddress(email));
            message.setText ("Verification Link.....");
            message.setText ("Click Here :: " + "http://localhost:8080/AccountActive?key1="
                    + email + "&key2=" +hash);
            Transport.send (message);
        } catch (Exception e) {
            System.out.println ("SendEmail File Error " + e);
        }
    }
}
