package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Users;

import java.time.LocalDate;
import java.util.List;

public interface UsersDao {
    Users getUserByEmail(String email);

    String addNewUser(String username, String password, String hash, String email, String phoneNumber, String address);

    String updateUserStatus(String email, String hash);

    String updateNewPassWord(String email, String password);

    Users getUser(int userId);
    Users updateProfile(int userId, String newUserName, String newEmail, String newAddress, String newPhoneNumber, LocalDate newDateOfBirth);
    Users checkUser(int userId, String password);
    String updatePassWordUser(int userId, String password);
}

