package org.example.models;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String url = "jdbc:sqlite:detabeso.db"; // Database URL

    public static void main(String[] args) {
        createTable();
        createMealsTable();
        createOrdersTable();
    }

    //Create Users Table
    public static void createTable() {
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

    //Create Meals Table
    public static void createMealsTable() {
        String mealsSql= "CREATE TABLE IF NOT EXISTS meals (" +
                "mealId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "mealName TEXT, " +
                "description TEXT, " +
                "category TEXT, " +
                "dietType TEXT, " +
                "spice TEXT, " +
                "calories INTEGER);";

        try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.execute(mealsSql);
                System.out.println("Meals table created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Create Orders Table
    public static void createOrdersTable() {
        String createOrder = "CREATE TABLE IF NOT EXISTS orders ("
                + "orderId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "dateOrdered TEXT NOT NULL, "
                + "totalPrice INTEGER NOT NULL, "
                + "mealId TEXT FOREIGNKEY NOT NULL, "
                + "quantity INTEGER NOT NULL);";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.execute(createOrder);
                System.out.println("Order table created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Insert meals to meals table
    public static void addMeals(String mealName, String description, String category, String dietType, String spice, int calories) {
        String insertMeals = "INSERT INTO meals (mealName, description, category, dietType, spice, calories) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertMeals)) {
            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, dietType);
            preparedStatement.setString(5, spice);
            preparedStatement.setInt(6, calories);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Retrieve meals from the meals table
    public static List<String[]> getMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, description FROM meals"; // Adjust SQL query

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String description = resultSet.getString("description");
                menu.add(new String[]{mealName, description}); // Add meal name and description as an array
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Update meals
    public static void updateData (String mealName, String description, String category, String dietType, String spice) {
        String updateMeals = "UPDATE meals SET description = ?, category = ?, dietType = ?, spice =? WHERE mealName = ?";

        try (Connection connection = DriverManager.getConnection(url);
        PreparedStatement preparedStatement = connection.prepareStatement(updateMeals)) {

            preparedStatement.setString(1, description); // Description
            preparedStatement.setString(2, category);    // Category
            preparedStatement.setString(3, dietType);    // Diet Type
            preparedStatement.setString(4, spice);        // Spice Level
            preparedStatement.setString(5, mealName);     // Meal Name (WHERE clause)

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void mealsSelector(JComboBox<String> mealsDropdown) {
        List<String> meals = new ArrayList<>();
        String query = "SELECT mealName FROM meals";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                meals.add(resultSet.getString("mealName"));
            }

            for (String meal : meals) {
                mealsDropdown.addItem(meal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMeal(int mealId) {
        String deleteSQL = "DELETE FROM Meals WHERE mealId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, mealId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getMealIdByName(String mealName) {
        int mealId = -1;
        String selectMealIdSQL = "SELECT mealId FROM Meals WHERE mealName = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMealIdSQL)) {

            preparedStatement.setString(1, mealName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    mealId = resultSet.getInt("mealId");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mealId;
    }

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

    public static boolean authenticateUser(String userName, String passWord) {
        String selectSql = "SELECT * FROM users WHERE userName = ? AND passWord = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }
}
