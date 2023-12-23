package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.database.JDBIConnector;

import java.time.LocalDate;
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

    /**
     * show List user
     * @return  id , username, hash ,password, email, address, phoneNumber, dateOfBirth, img , status, role
     */
    @Override
    public List<Users> getUser() {
        return JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT * FROM users")
                        .mapToBean(Users.class)
                        .stream()
                        .collect(Collectors.toList())
        );
    }


    /**
     * get User show profile
     * @return  id , username, password, email, address, phoneNumber, dateOfBirth, img , status, role
     */
    @Override
    public Users getUserById(int userId) {
       return JDBIConnector.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM users where id = :id")
                        .bind("id", userId)
                        .mapToBean(Users.class)
                        .findOne()
                        .orElse(null)
        );
    }
    @Override
    public boolean checkUser(int id, String password) {
        Users user = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM Users WHERE id = :id AND password = :password")
                        .bind("id", id)
                        .bind("password", password)
                        .mapToBean(Users.class)
                        .findOne()
                        .orElse(null));
        return user != null;
    }

    /**
     * update profile: change one or more than
     * @return username, email, address, phoneNumber, datOfBirth
     */
    public Users updateProfileNoImage(int userId, String newUserName, String newEmail, String newAddress, String newPhoneNumber, LocalDate newDateOfBirth, String newSexual) {
        return JDBIConnector.get().withHandle(handle -> {
            int rowCount = handle.createUpdate("UPDATE Users SET username = :username, email = :email, address = :address, phoneNumber = :phoneNumber, dateOfBirth = :dateOfBirth, sexual =:sexual WHERE id = :id")
                    .bind("id", userId)
                    .bind("username", newUserName)
                    .bind("email", newEmail)
                    .bind("address", newAddress)
                    .bind("phoneNumber", newPhoneNumber)
                    .bind("dateOfBirth", newDateOfBirth)
                    .bind("sexual", newSexual)

                    .execute();

            return (rowCount > 0) ? handle.createQuery("SELECT id, username, email, address, phoneNumber, dateOfBirth, img, sexual FROM Users WHERE id = :id")
                    .bind("id", userId)
                    .mapToBean(Users.class)
                    .findOne()
                    .orElse(null) : null;
       });
    }

    /**
     * update profile: change one or more than
     * @return username, email, address, phoneNumber, datOfBirth, img
     */
    @Override
    public Users updateProfileWithImage(int userId, String newUserName, String newEmail, String newAddress, String newPhoneNumber, LocalDate newDateOfBirth , String img, String newSexual) {
        return JDBIConnector.get().withHandle(handle -> {
            int rowCount = handle.createUpdate("UPDATE Users SET username = :username, email = :email, address = :address, phoneNumber = :phoneNumber, dateOfBirth = :dateOfBirth , img = :img, sexual = :sexual WHERE id = :id")
                    .bind("id", userId)
                    .bind("username", newUserName)
                    .bind("email", newEmail)
                    .bind("address", newAddress)
                    .bind("phoneNumber", newPhoneNumber)
                    .bind("dateOfBirth", newDateOfBirth)
                    .bind("img", img)
                    .bind("sexual", newSexual)
                    .execute();

            return (rowCount > 0) ? handle.createQuery("SELECT username, email, address, phoneNumber, dateOfBirth, img, sexual FROM Users WHERE id = :id")
                    .bind("id", userId)
                    .mapToBean(Users.class)
                    .findOne()
                    .orElse(null) : null;
        });
    }

    /**
     * update new password for user in user-profile
     * @return  id, password
     */
    public String updatePassWordUser(int id, String password) {
        Users user = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("SELECT id,hash FROM Users WHERE id = :id")
                        .bind("id", id)
                        .mapToBean(Users.class)
                        .findOne()
                        .orElse(null));
        if (user == null) {
            return "FAIL"; // User not found
        }
        int rowsUpdated = JDBIConnector.get().withHandle(handle ->
                handle.createUpdate("UPDATE Users SET password = :password WHERE id = :id")
                        .bind("password", password)
                        .bind("id", id)
                        .execute());
        if (rowsUpdated > 0) {
            return "SUCCESS";
        }
        return "FAIL";
    }
}