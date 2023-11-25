package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Users;

import java.util.List;

public interface UsersDao {
    String addNewUser(String username,String password,String hash,String email,String phoneNumber,String address);
    String updateUserStatus(String email, String hash);
    String updateNewPassWord(String email, String password);
}
