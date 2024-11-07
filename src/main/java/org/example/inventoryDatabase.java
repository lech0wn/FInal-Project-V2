package org.example;

import java.sql.*;

public class inventoryDatabase {

    private static final String url = "jdbc:sqlite:detabeso.db";

    //create Inventory table
    public static void createInventoryTable()
    {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Inventory ("
                + "inventoryId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "mealId TEXT NOT NULL, "
                + "quantity TEXT NOT NULL)";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement())
        {
            statement.execute(createTableSQL);
            System.out.println("Table 'Inventory' created successfully!");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //add inventory
    public static void addInventory(int mealId, int quantity){
        String insertSQL = "INSERT INTO Inventory (mealId, quantity) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL))
        {
            preparedStatement.setInt(1, mealId);
            preparedStatement.setInt(2, quantity);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0)
            {
                System.out.println("Inventory item added successfully!");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //edit inventory
    public static void editInventory(int mealId, int quantity) {
        String updateSQL = "UPDATE Inventory SET quantity = ? WHERE mealId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setInt(2, mealId);
            preparedStatement.setInt(1, quantity);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete inventory
    public static void deleteInventory(int mealId) {
        String deleteSQL = "DELETE FROM Inventory WHERE mealId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, mealId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //list inventory
    public static void listInventory() {
        String query = "SELECT * FROM Inventory";  // Corrected table name
        StringBuilder InventoryList = new StringBuilder("Inventory:\n");

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                InventoryList.append("Meal ID: ").append(resultSet.getInt("mealId"))
                        .append(", Quantity: ").append(resultSet.getInt("quantity"))
                        .append("\n");
            }

            System.out.println(InventoryList.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
