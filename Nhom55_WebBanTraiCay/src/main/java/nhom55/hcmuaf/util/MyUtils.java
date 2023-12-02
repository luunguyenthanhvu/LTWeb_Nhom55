package nhom55.hcmuaf.util;

import nhom55.hcmuaf.beans.Users;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.Random;

public class MyUtils {
    public static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
    public MyUtils() {
        super();
    }
    public static String encodePass(String pass) {
        return DigestUtils.md5Hex(pass);
    }
    public static String createHash() {
        Random random = new Random ();
        random.nextInt (999999);
        return DigestUtils.md5Hex (random.toString ());
    }

    // Store user info in Session.
    public static void storeLoginedUser(HttpSession session, Users loginedUser) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }

    // Get the user information stored in the session.
    public static Users getLoginedUser(HttpSession session) {
        Users loginedUser = (Users) session.getAttribute("loginedUser");
        return loginedUser;
    }
    public static void removeLoginedUser(HttpSession session) {
        session.removeAttribute("loginedUser");
    }
}
