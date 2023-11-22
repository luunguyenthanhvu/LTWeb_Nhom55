package nhom55.hcmuaf.services;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.database.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static UserService instance;

    public UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public String updateUserStatus(String email, String hash) {
        List<Users> users = JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT email, hash, status  FROM Users WHERE email = :email AND hash = :hash AND status = '0'")
                        .bind("email", email)
                        .bind("hash", hash)
                        .mapToBean(Users.class)
                        .stream()
                        .collect(Collectors.toList())
        );
        Users user = users.get (0);
        return JDBIConnector.get().withHandle(handle -> {
            handle.createUpdate("update Users set status = '1' where email = :email AND hash = :hash ")
                    .bind("hash", hash)
                    .bind("email", email)
                    .execute();
            return "SUCCESS";
        });
    }
}
