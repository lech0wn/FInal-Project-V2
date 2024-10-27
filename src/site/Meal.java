package src.site;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Meal {

    private static final String DB_URL = "jdbc:sqlite:C:/iAcademy/Database/groupdatabase.db";

    protected static void createMealsTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Meals ("
                + "mealId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "mealName TEXT NOT NULL, "
                + "description TEXT NOT NULL, "
                + "category TEXT NOT NULL, "
                + "dietType TEXT NOT NULL,"
                + "spicy TEXT NOT NULL, "
                + "servingSize TEXT NOT NULL, "
                + "nutritionalValue TEXT NOT NULL, "
                + "quantity TEXT NOT NULL, "
                + "ingredients TEXT NOT NULL)";


        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'Meals' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void addMeal(String mealName, String description , String category, String dietType, String spicy, String servingSize, String nutritionalValue, String quantity, String ingredients) {
        String insertSQL = "INSERT INTO Meals (mealName, description, category, dietType, spicy, servingSize, nutritionalValue, quantity, ingredients) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, dietType);
            preparedStatement.setString(5, spicy);
            preparedStatement.setString(6, servingSize);
            preparedStatement.setString(7, nutritionalValue);
            preparedStatement.setString(8, quantity);
            preparedStatement.setString(9, ingredients);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Meal " + mealName + "added successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void editMeal(String mealName, String description , String category, String dietType, String spicy, String servingSize, String nutritionalValue, String quantity, String ingredients, int mealId) {
        String updateSQL = "UPDATE Meals SET mealName = ?, description = ?, category = ?, dietType = ?, spicy = ?, servingSize = ?, nutritionalValue = ?, quantity = ?, ingredients = ? WHERE mealId = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, dietType);
            preparedStatement.setString(5, spicy);
            preparedStatement.setString(6, servingSize);
            preparedStatement.setString(7, nutritionalValue);
            preparedStatement.setString(8, quantity);
            preparedStatement.setString(9, ingredients);
            preparedStatement.setInt(10,mealId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void deleteMeal(int mealId) {
        String deleteSQL = "DELETE FROM Meals WHERE mealId = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, mealId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void listMeal() {
        String query = "SELECT * FROM Meals";  // Corrected table name
        StringBuilder mealList = new StringBuilder("Meals:\n");

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                mealList.append("Meal Name: ").append(resultSet.getString("mealName"))
                        .append(", Description: ").append(resultSet.getString("description"))
                        .append(", Category: ").append(resultSet.getString("category"))
                        .append(", Diet Type: ").append(resultSet.getString("dietType"))
                        .append(", Spicy: ").append(resultSet.getString("spicy"))
                        .append(", Serving Size: ").append(resultSet.getString("servingSize"))
                        .append(", Nutritional Value: ").append(resultSet.getString("nutritionalValue"))
                        .append(", Quantity: ").append(resultSet.getString("quantity"))
                        .append(", Ingredients: ").append(resultSet.getString("ingredients"))
                        .append("\n");
            }

            System.out.println(mealList.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
