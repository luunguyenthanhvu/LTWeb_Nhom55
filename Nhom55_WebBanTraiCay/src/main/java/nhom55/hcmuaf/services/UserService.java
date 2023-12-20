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

   public boolean checkUser(int id, String password) {
       return userDao.checkUser(id, password);
   }

    /**
     * update new password
     * @param
     * @return password
     */
    public String changePass(int id, String newPassword) {
        String encodePass = MyUtils.encodePass(newPassword); // Mã hóa mật khẩu mới ở đây
        String result = userDao.updatePassWordUser(id, encodePass);

        if (result.equals("SUCCESS")) {
            // Cập nhật giá trị hashedPassword trong đối tượng Users
            Users user = userDao.getUserById(id);
            if (user != null) {
                user.setHash(encodePass);
            }
        }
        return result;
    }


}
