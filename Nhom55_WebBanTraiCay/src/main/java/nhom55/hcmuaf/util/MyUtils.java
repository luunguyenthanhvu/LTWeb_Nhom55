package nhom55.hcmuaf.util;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.cart.Cart;
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

    /**
     * Store user info in Session.
     * @param session
     * @param loginedUser
     */
    public static void storeLoginedUser(HttpSession session, Users loginedUser) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }

    /**
     * Create a new cart for user
     * @param session
     * @param cart
     */
    public static void storeCart(HttpSession session, Cart cart) {
        session.setAttribute("cart",cart);
    }

    /**
     * remove their cart from session
     * @param session
     */
    public static void removeCart(HttpSession session) {
        session.removeAttribute("cart");
    }

    /**
     * Get the user information stored in the session.
     * @param session
     * @return
     */
    public static Users getLoginedUser(HttpSession session) {
        Users loginedUser = (Users) session.getAttribute("loginedUser");
        return loginedUser;
    }

    /**
     * logout user
     * @param session
     */
    public static void removeLoginedUser(HttpSession session) {
        session.removeAttribute("loginedUser");
    }

    /**
     * set role for authentication
     * @param session
     * @param role
     */
    public static void setUserRole(HttpSession session, String role) {
        session.setAttribute("role", role);
    }
}
