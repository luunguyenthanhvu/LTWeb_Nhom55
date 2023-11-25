package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.database.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class UsersDaoImpl implements UsersDao{
    /**
     *
     * @param email
     * @return List<User>
     */
    @Override
    public List<Users> getUserByEmail(String email) {
        return JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT * FROM Users WHERE email = ?")
                        .bind(0, email)
                        .mapToBean(Users.class)
                        .stream()
                        .collect(Collectors.toList())
        );
    }

    /**
     *
     * @param username
     * @param password
     * @param hash
     * @param email
     * @param phoneNumber
     * @param address
     * @return String result
     */
    @Override
    public String addNewUser(String username, String password, String hash, String email, String phoneNumber, String address) {
        return JDBIConnector.get().withHandle(handle -> {
            handle.createUpdate("INSERT INTO Users (username, password, hash, email, phoneNumber, address, status) VALUES (:username, :password, :hash, :email, :phoneNumber, :address, :status)")
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
     *
     * @param email
     * @param hash
     * @return String result
     */
    @Override
    public String updateUserStatus(String email, String hash) {
        List<Users> users = JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT email, hash, status  FROM Users WHERE email = :email AND hash = :hash AND status = 0")
                        .bind("email", email)
                        .bind("hash", hash)
                        .mapToBean(Users.class)
                        .stream()
                        .collect(Collectors.toList())
        );
        Users user = users.get (0);
        return JDBIConnector.get().withHandle(handle -> {
            handle.createUpdate("update Users set status = 1 where email = :email AND hash = :hash ")
                    .bind("hash", hash)
                    .bind("email", email)
                    .execute();
            return "SUCCESS";
        });
    }
}