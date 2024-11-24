package org.example.Databases;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usersDatabase {

    private static final String url = "jdbc:sqlite:database.db";

    //Create Users Table
    public static void createUsersTable() {
        String usersSql = "CREATE TABLE IF NOT EXISTS users (" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userName TEXT NOT NULL, " +
                "passWord TEXT NOT NULL," +
                "roles TEXT NOT NULL);";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.execute(usersSql);
                System.out.println("User table created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Add a new User
    public static void registerUser(String userName, String passWord, String roles) {
        String insertSql = "INSERT INTO users (userName, passWord, roles) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            preparedStatement.setString(3, roles);
            preparedStatement.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //Authenticate the credentials of User
    public static String authenticateUser(String username, String password) {
        String role = null;
        String query = "SELECT passWord, roles FROM users WHERE userName = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("passWord");
                role = rs.getString("roles");

                // Compare the passwords
                if (storedPassword.equals(password)) {
                    return role;  // Return the role if the password matches
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null; // return null if authentication fails
    }

    //Check if the username is already registered
    public static boolean isUsernameAvailable(String userName) {
        String checkSql = "SELECT * FROM users WHERE userName = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(checkSql)) {
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();

            return !resultSet.next();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

    public static List<String[]> getUsers() {
        List<String[]> userList = new ArrayList<>();
        String selectMeals = "SELECT userName, roles FROM users";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String username = resultSet.getString("userName");
                String role = resultSet.getString("roles");
                userList.add(new String[]{username, role});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public static boolean deleteUser(String username) {
        String deleteSql = "DELETE FROM users WHERE userName = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, username);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
            return false;
        }
    }
}
