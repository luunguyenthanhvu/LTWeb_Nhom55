package nhom55.hcmuaf.services;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.dao.UsersDaoImpl;
import nhom55.hcmuaf.util.MyUtils;

import java.util.Date;
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
    return userDao.showInfoUser();
  }

  public Users getUserById(int id) {
    return userDao.getUserById(id);
  }

  /**
   * update profile no ima
   *
   * @param
   */
  public void updateProfile(int userId, String newUserName, String newEmail,  String newAddress, String newPhoneNumber, Date newDateOfBirth, String newSexual, int newStatus, int newRole) {
      userDao.updateProfile(userId, newUserName, newEmail, newAddress, newPhoneNumber, newDateOfBirth, newSexual, newStatus, newRole);
  }

  /**
   * update profile with img
   *
   * @param
   */
  public String updateProfileWithImage(int userId, String newUserName, String newEmail, String newAddress, String newPhoneNumber, Date newDateOfBirth, String img, String newSexual) {
    return userDao.updateProfileWithImage(userId, newUserName, newEmail, newAddress, newPhoneNumber, newDateOfBirth, img, newSexual);
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

  public List<Users> get5UsersForEachPage(int index, int quantityDefault) {
    return userDao.get5UsersForEachPage(index,quantityDefault);
  }
  public int countResultSearchingUser(String txtSearch) {
    return userDao.countResultSearchingUser(txtSearch);
  }

  public List<Users> search(String search, int index, int sizePage) {
    return  userDao.search(search,index,sizePage);
  }
  public List<Users> searchFilter(String sortBy, String order, String search, int index, int sizePage) {
    return  userDao.searchFilter(sortBy,order,search,index,sizePage);
  }

  public int countTotalUserInDatabase(){
    return userDao.countTotalRowUserInDatabase();
  }

  public List<Users> sortByFilter(int index, int role, String sortBy, String order) {
    return  userDao.sortByFilter(index,role,sortBy,order);
  }

  public void deleteUser(int id) {
      userDao.deleteUser(id);
  }

}
