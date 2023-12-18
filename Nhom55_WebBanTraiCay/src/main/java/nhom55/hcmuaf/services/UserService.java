package nhom55.hcmuaf.services;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.dao.UsersDaoImpl;
import nhom55.hcmuaf.util.MyUtils;

import java.security.SecureRandom;
import java.time.LocalDate;

public class UserService {
    private static UserService instance;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*";
    private UsersDaoImpl userDao;

    public UserService() {
        userDao = new UsersDaoImpl();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }


    /**
     * show profile
     * @param
     */
    public Users showInfoUser(int id) {
        return userDao.getUser(id);
    }

    /**
     * update profile
     * @param
     */
   public Users updateProfile(int userId, String newUserName, String newEmail, String newAddress, String newPhoneNumber, LocalDate newDateOfBirth) {
       return userDao.updateProfile(userId, newUserName, newEmail, newAddress, newPhoneNumber, newDateOfBirth);
   }

   public Users checkUser(int userId, String password) {
       return userDao.checkUser(userId,password);
   }

   public String updatePass(int userId, String password) {
       return userDao.updatePassWordUser(userId,password);
   }
    /**
     * update new password
     * @param
     * @return password
     */
    public String changePass(int id) {
        String result;
        // generate
        String newPass = generateNewPass ();
        String endCodePass = MyUtils.encodePass (newPass);
        result = userDao.updatePassWordUser(id, endCodePass);
        return result;
    }

        /**
         * generate newRandomPassWord
         * @return
         */
        public static String generateNewPass() {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(randomIndex));
        }

        return password.toString();
    }

}
