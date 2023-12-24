package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.database.JDBIConnector;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UsersDaoImpl implements UsersDao {

  /**
   * @param email
   * @return user
   */
  @Override
  public Users getUserByEmail(String email) {
    List<Users> users = JDBIConnector.get().withHandle(h ->
        h.createQuery(
                "SELECT id,username,email,phoneNumber,address,status,img,dateOfBirth,sexual FROM Users WHERE email = ?")
            .bind(0, email)
            .mapToBean(Users.class)
            .stream()
            .collect(Collectors.toList())
    );

    if (users.isEmpty()) {
      return null;
    }

    return users.get(0);
  }


  /**
   * @param username
   * @param password
   * @param hash
   * @param email
   * @param phoneNumber
   * @param address
   * @return String result
   */
  @Override
  public String addNewUser(String username, String password, String hash, String email,
      String phoneNumber, String address) {
    // check if exist
    List<Users> users = JDBIConnector.get().withHandle(h ->
        h.createQuery(
                "SELECT id,username,email,phoneNumber,address,status,img,dateOfBirth,sexual FROM Users WHERE email = ?")
            .bind(0, email)
            .mapToBean(Users.class)
            .stream()
            .collect(Collectors.toList())
    );
      if (!users.isEmpty()) {
          return "FAIL";
      }

    // add new user
    return JDBIConnector.get().withHandle(handle -> {
      handle.createUpdate(
              "INSERT INTO Users (username, password, hash, email, phoneNumber, address, status) VALUES (:username, :password, :hash, :email, :phoneNumber, :address, :status)")
          .bind("username", username)
          .bind("password", password)
          .bind("hash", hash)
          .bind("email", email)
          .bind("phoneNumber", phoneNumber)
          .bind("address", address)
          .bind("status", 0)
          .execute();
      return "SUCCESS";
    });
  }

  /**
   * @param email
   * @param hash
   * @return String result
   */
  @Override
  public String updateUserStatus(String email, String hash) {
    // check is exit
    List<Users> users = JDBIConnector.get().withHandle(h ->
        h.createQuery(
                "SELECT email, hash, status  FROM Users WHERE email = :email AND hash = :hash AND status = 0")
            .bind("email", email)
            .bind("hash", hash)
            .mapToBean(Users.class)
            .stream()
            .collect(Collectors.toList())
    );
      if (users.isEmpty()) {
          return "FAIL";
      }
    Users user = users.get(0);
    return JDBIConnector.get().withHandle(handle -> {
      handle.createUpdate("update Users set status = 1 where email = :email AND hash = :hash ")
          .bind("hash", hash)
          .bind("email", email)
          .execute();
      return "SUCCESS";
    });
  }

  /**
   * update new password for user
   *
   * @param email
   * @param password
   */
  @Override
  public String updateNewPassWord(String email, String password) {
    List<Users> users = JDBIConnector.get().withHandle(h ->
        h.createQuery("SELECT email, hash, status  FROM Users WHERE email = :email")
            .bind("email", email)
            .mapToBean(Users.class)
            .stream()
            .collect(Collectors.toList())
    );
      if (users.isEmpty()) {
          return "FAIL";
      }
    Users user = users.get(0);
    return JDBIConnector.get().withHandle(handle -> {
      handle.createUpdate("update Users set password = :password where email = :email")
          .bind("password", password)
          .bind("email", email)
          .execute();
      return "SUCCESS";
    });
  }

  public String addNewUserOfAdmin(String username, String password, String hash, String email,
                                  String phoneNumber, String address, Date dob, String gioiTinh, String img, int quyenHan) {
    // check if exist
    List<Users> users = JDBIConnector.get().withHandle(h ->
            h.createQuery(
                            "SELECT id,username,email,phoneNumber,address,status,img,dateOfBirth,sexual FROM Users WHERE email = ?")
                    .bind(0, email)
                    .mapToBean(Users.class)
                    .stream()
                    .collect(Collectors.toList())
    );
    if (!users.isEmpty()) {
      return "FAIL";
    }

    // add new user
    return JDBIConnector.get().withHandle(handle -> {
      handle.createUpdate(
                      "INSERT INTO Users (username, password, hash, email, phoneNumber, address, status,img,dateOfBirth,sexual,role) VALUES (:username, :password, :hash, :email, :phoneNumber, :address, :status, :img, :dateOfBirth, :sexual, :role)")
              .bind("username", username)
              .bind("password", password)
              .bind("hash", hash)
              .bind("email", email)
              .bind("phoneNumber", phoneNumber)
              .bind("address", address)
              .bind("status", 1)
              .bind("img",img)
              .bind("sexual",gioiTinh)
              .bind("dateOfBirth",dob)
              .bind("role",quyenHan)
              .execute();
      return "SUCCESS";
    });
  }
}