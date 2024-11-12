package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mealsDatabase {

    private static final String url = "jdbc:sqlite:database.db";


    //Create Meals Table
    public static void createMealsTable() {
        String mealsSql= "CREATE TABLE IF NOT EXISTS meals (" +
                "mealId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "mealName TEXT, " +
                "description TEXT, " +
                "category TEXT, " +
                "ingredients TEXT, " +
                "dietType TEXT, " +
                "spice TEXT, " +
                "servingSize TEXT, " +
                "nutritionalValue TEXT);";

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

    //Add Meals
    public static void addMeals(String mealName, String description, String category, String ingredients, String dietType, String spice, String servingSize, String nutritionalValue) {
        String insertMeals = "INSERT INTO meals (mealName, description, category, ingredients, dietType, spice, servingSize, nutritionalValue) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertMeals)) {
            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, ingredients);
            preparedStatement.setString(5, dietType);
            preparedStatement.setString(6, spice);
            preparedStatement.setString(7, servingSize);
            preparedStatement.setString(8, nutritionalValue);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Update Meals
    public static void updateMeals (String mealName, String description, String category, String ingredients, String dietType, String spice, String servingSize, String nutritionalValue) {
        String updateMeals = "UPDATE meals SET description = ?, category = ?, ingredients = ?, dietType = ?, spice = ?, servingSize = ?, nutritionalValue = ? WHERE mealName = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(updateMeals)) {

            preparedStatement.setString(1, description);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, ingredients);
            preparedStatement.setString(4, dietType);
            preparedStatement.setString(5, spice);
            preparedStatement.setString(6, servingSize);
            preparedStatement.setString(7, nutritionalValue);
            preparedStatement.setString(8, mealName);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Delete Meals
    public static void deleteMeal(int mealId) {
        String deleteSQL = "DELETE FROM Meals WHERE mealId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            if (connection!=null) {
                System.out.println("Meal deleted successfully");
            }

            preparedStatement.setInt(1, mealId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Get Meals to display in the Menu Page
    public static List<String[]> getMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, category, ingredients, dietType, spice, servingSize, nutritionalValue FROM meals"; // Adjust SQL query

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                menu.add(new String[]{mealName, mealId, description, category, ingredients, dietType, spice, servingSize, nutritionalValue}); // Add meal name and description as an array
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    // Authenticate if the meal exists
    public static boolean authenticateMealName(String mealName) {
        String selectSQL = "SELECT * FROM meals WHERE mealName = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, mealName);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Get Meal Id to delete by Meal Name
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
}
