package nhom55.hcmuaf.services;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.dao.UsersDaoImpl;
import nhom55.hcmuaf.util.MyUtils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;

public class UserService {

  private static UserService instance;
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
   *
   * @param
   */
  public List<Users> showInfoUser() {
    return userDao.getUser();
  }

  public Users getUserById(int id) {
    return userDao.getUserById(id);
  }

  /**
   * update profile no ima
   *
   * @param
   */
  public Users updateProfileNoImage(int userId, String newUserName, String newEmail,
      String newAddress, String newPhoneNumber, LocalDate newDateOfBirth, String newSexual) {
    return userDao.updateProfileNoImage(userId, newUserName, newEmail, newAddress, newPhoneNumber,
        newDateOfBirth, newSexual);
  }

  /**
   * update profile with img
   *
   * @param
   */
  public Users updateProfileWithImage(int userId, String newUserName, String newEmail,
      String newAddress, String newPhoneNumber, LocalDate newDateOfBirth, String img,
      String newSexual) {
    return userDao.updateProfileWithImage(userId, newUserName, newEmail, newAddress, newPhoneNumber,
        newDateOfBirth, img, newSexual);
  }

  public boolean checkPassUser(int id, String password) {
    return userDao.checkPassUser(id, password);
  }

  /**
   * update new password
   *
   * @param
   * @return password
   */
  public String changePass(int id, String newPassword) {
    String encodePass = MyUtils.encodePass(newPassword); // Mã hóa mật khẩu mới ở đây
    return userDao.updatePassWordUser(id, encodePass);
  }


}
