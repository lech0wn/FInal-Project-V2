package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public static String url = "jdbc:sqlite:C:/iAcademy/Database/database.db";

    public static void createUsersTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "username TEXT NOT NULL UNIQUE, "
                + "password TEXT NOT NULL, "
                + "role TEXT NOT NULL)";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'Users' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void createMealsTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS meals ("
                + "mealId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "mealName TEXT NOT NULL, "
                + "description TEXT NOT NULL, "
                + "category TEXT NOT NULL, "
                + "dietType TEXT NOT NULL,"
                + "spicy TEXT NOT NULL, "
                + "calories INTEGER NOT NULL)";


        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'Meals' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void addMeal(String mealName, String description , String category, String dietType, String spicy, int calories) {
        String insertSQL = "INSERT INTO meals (mealName, description, category, dietType, spicy, calories) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, dietType);
            preparedStatement.setString(5, spicy);
            preparedStatement.setInt(6, calories);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Meal " + mealName + "added successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static List<String[]> listMeal() {
        String query = "SELECT * FROM meals";  // Ensure the table name is correct
        List<String[]> meals = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                String dietType = resultSet.getString("dietType");
                String spicy = resultSet.getString("spicy");
                String calories = resultSet.getString("calories");

                // Store the meal data in a String array
                String[] meal = {mealName, description, category, dietType, spicy, calories};
                meals.add(meal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meals; // Return the list of meals
    }

    public static void addUser(String username, String password, String role) {
        String insertSQL = "INSERT INTO Users (username, password, role) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

