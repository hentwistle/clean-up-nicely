package edu.matc.persistence;

import edu.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

/**
 * Access users in the user table.
 *
 * @author hentwistle
 */
public class UserDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return executeQuery(sql);
    }

    public List<User> getUsersByHouseHold(String username) {
        String sql = "SELECT * FROM user where username like '%" + username + "%'";
        return executeQuery(sql);
    }

    public List<User> getUsersByLastName(String lastName) {
        String sql = "SELECT * FROM user where last_name like '%" + lastName + "%'";
        return executeQuery(sql);
    }

    private List<User> executeQuery(String sql) {

        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            addUserToList(users, results);

            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: ", e);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: ", e);
        }

        return users;
    }

    private void addUserToList(List<User> users, ResultSet results) throws SQLException {
        while (results.next()) {
            User newUser = createUserFromResults(results);
            users.add(newUser);
        }
    }

    //TODO add a method or methods to return a single user based on search criteria

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setUserid(results.getInt("user_id"));
        user.setUsername(results.getString("username"));
        user.setEmail(results.getString("email"));
        user.setPassword(results.getString("password"));
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setOwner(results.getBoolean("owner"));
        return user;
    }

}