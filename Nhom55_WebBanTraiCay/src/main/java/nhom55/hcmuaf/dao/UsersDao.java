package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UserService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UsersDao {
    Users getUserByEmail(String email);

    String addNewUser(String username, String password, String hash, String email, String phoneNumber, String address);

    String updateUserStatus(String email, String hash);

    String updateNewPassWord(String email, String password);

    List<Users> showInfoUser();

    Users getUserById(int userId);

    boolean checkPassUser(int userId, String password);

    String updateProfileNoImage(int userId, String newUserName, String newEmail, String newAddress, String newPhoneNumber, Date newDateOfBirth, String sexual);

    String updateProfileWithImage(int userId, String newUserName, String newEmail, String newAddress, String newPhoneNumber, Date newDateOfBirth, String img, String sexual);

    String updatePassWordUser(int userId, String password);

    int countResultSearchingUser(String txtSearch);

    List<Users> search(String search, int index, int sizePage);

    List<Users> searchFilter(String sortBy, String order, String search, int index, int sizePage);

    List<Users> sortByFilter(int index, int quantityDefault, String sortBy, String order);

    int countTotalRowUserInDatabase();
    List<Users> get5UsersForEachPage(int index, int quantityDefault);

    void deleteUser(int id);

}





