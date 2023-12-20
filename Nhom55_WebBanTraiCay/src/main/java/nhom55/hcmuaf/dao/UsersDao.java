package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UserService;

import java.time.LocalDate;
import java.util.List;

public interface UsersDao {
    Users getUserByEmail(String email);

    String addNewUser(String username, String password, String hash, String email, String phoneNumber, String address);

    String updateUserStatus(String email, String hash);

    String updateNewPassWord(String email, String password);

    Users getUser(int userId);
    boolean checkUser(int userId, String password);
    Users updateProfile(int userId, String newUserName, String newEmail, String newAddress, String newPhoneNumber, LocalDate newDateOfBirth);

    String updatePassWordUser(int userId, String password);
}

