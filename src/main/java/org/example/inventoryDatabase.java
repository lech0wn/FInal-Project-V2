package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class inventoryDatabase {

    private static final String url = "jdbc:sqlite:database.db";

    // Create Inventory table
    public static void createInventoryTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Inventory ("
                + "inventoryId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "mealId INTEGER, "
                + "mealName TEXT NOT NULL, "
                + "price TEXT NOT NULL, "
                + "quantity INTEGER NOT NULL, "
                + "FOREIGN KEY (mealId) REFERENCES meals(mealId))"; // Link mealId to meals table;

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'Inventory' created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Helper method to check if a meal name exists in the meals table and retrieve its mealId
    private static Integer getMealIdByName(String mealName) {
        String query = "SELECT mealId FROM meals WHERE mealName = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, mealName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("mealId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if meal name does not exist
    }

    // Add inventory item only if mealName exists in meals table
    public static void addInventory(String mealName, int quantity, double price) {
        Integer mealId = getMealIdByName(mealName);
        if (mealId == null) {
            System.out.println("Meal name not found in meals table. Cannot add to inventory.");
            return;
        }

        String insertSQL = "INSERT INTO Inventory (mealId, mealName, price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setInt(1, mealId);
            preparedStatement.setString(2, mealName);
            preparedStatement.setDouble(3, price);  // Set the price
            preparedStatement.setInt(4, quantity);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inventory item added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete inventory item only if mealName exists in meals table
    public static void deleteInventory(String mealName) {
        Integer mealId = getMealIdByName(mealName);
        if (mealId == null) {
            System.out.println("Meal name not found in meals table. Cannot delete from inventory.");
            return;
        }

        String deleteSQL = "DELETE FROM Inventory WHERE mealName = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, mealName);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Inventory item deleted successfully!");
            } else {
                System.out.println("No inventory item found with meal name '" + mealName + "'.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //list inventory
    protected static List<String[]> listInventory() {
        List<String[]> inventoryData = new ArrayList<>();
        String query = "SELECT inventoryId, mealId, mealName, quantity, price FROM Inventory ORDER BY inventoryId";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String inventoryId = String.format("%03d", resultSet.getInt("inventoryId"));
                String mealId = String.valueOf(resultSet.getInt("mealId"));
                String mealName = resultSet.getString("mealName");  // Fetch meal name from the result set
                String quantity = String.valueOf(resultSet.getInt("quantity"));
                String price = String.format("%.2f", resultSet.getDouble("price"));
                inventoryData.add(new String[]{inventoryId, mealId, mealName, quantity, price});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inventoryData;
    }


}
