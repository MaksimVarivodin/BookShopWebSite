package uni.lab8.repository;

import BookShop.Realizations.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private static String INSERT_USER = "insert into users (username, pass, email) values (?, ?, ?);";
    private static String FIND_BY_MAIL = "select username, pass, email from users where (email = ?);";

    public void create(Connection con, User user) throws SQLException {
        try(PreparedStatement ps = con.prepareStatement(INSERT_USER)){
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());

            ps.executeUpdate();
        }
    }
    public User findByEmail (Connection con, String mail) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(FIND_BY_MAIL)){
            ps.setString(1, mail);
            ResultSet set = ps.executeQuery();
            if (set.next())
                return new User(set.getString("username"), set.getString("email"), set.getString("pass"));
            else return null;
        }
    }
}
