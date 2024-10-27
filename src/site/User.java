package src.site;

import javax.swing.*;
import java.sql.*;

public class User {

    protected static final String DB_URL = "jdbc:sqlite:C:/iAcademy/Database/groupdatabase.db";

    protected static void createUsersTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "username TEXT NOT NULL UNIQUE, "
                + "password TEXT NOT NULL, "
                + "role TEXT NOT NULL)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'Users' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void addUser(String username, String password, String role) {
        String insertSQL = "INSERT INTO Users (username, password, role) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User '" + username + "' added successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Login successful! Role: " + resultSet.getString("role"));
                return true; // Authentication success
            } else {
                return false; // Authentication failed
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Handle SQL errors
        }
    }
}