package org.example.Databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ordersDatabase {

    private static final String url = "jdbc:sqlite:database.db";

    //create Orders table
    public static void createOrdersTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Orders ("
                + "orderId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "mealId INTEGER, "   // Add mealId column to store the meal ID
                + "mealName TEXT NOT NULL, "
                + "quantity TEXT NOT NULL, "
                + "subtotalPrice TEXT NOT NULL, "
                + "date TEXT NOT NULL, "
                + "FOREIGN KEY (mealId) REFERENCES meals(mealId))"; // Link mealId to meals table
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'Orders' created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //retrieve orders
    public static List<String[]> listOrders() {
        List<String[]> ordersList = new ArrayList<>();
        String query = "SELECT orderId, date, mealName, quantity, subtotalPrice FROM Orders ORDER BY orderId";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String orderId = String.format("%03d", resultSet.getInt("orderId"));
                String date = resultSet.getString("date");// Formatting orderId to 3 digits
                String mealName = resultSet.getString("mealName");
                String quantity = String.valueOf(resultSet.getInt("quantity"));
                String subtotalPrice = String.format("₱%.2f", resultSet.getDouble("subtotalPrice"));  // Format price to 2 decimal places


                ordersList.add(new String[]{orderId, date, mealName, quantity, subtotalPrice});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordersList;
    }

    //insert orders into orders table
    public static void addOrders(String mealName, String quantity, String subtotalPrice, String date) {
        String getMealIdSQL = "SELECT mealId FROM meals WHERE mealName = ?";
        String insertOrderSQL = "INSERT INTO Orders (mealId, mealName, quantity, subtotalPrice, date) VALUES (?, ?, ?, ?, ?)";
        String updateInventorySQL = "UPDATE Inventory SET quantity = quantity - ? WHERE mealId = ?";  // SQL to decrement quantity in Inventory

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement getMealIdStmt = connection.prepareStatement(getMealIdSQL);
             PreparedStatement insertOrderStmt = connection.prepareStatement(insertOrderSQL);
             PreparedStatement updateInventoryStmt = connection.prepareStatement(updateInventorySQL)) {

            // Retrieve mealId based on mealName
            getMealIdStmt.setString(1, mealName);
            ResultSet resultSet = getMealIdStmt.executeQuery();

            if (resultSet.next()) {
                int mealId = resultSet.getInt("mealId");

                // Insert order with retrieved mealId
                insertOrderStmt.setInt(1, mealId);
                insertOrderStmt.setString(2, mealName);
                insertOrderStmt.setString(3, quantity);
                insertOrderStmt.setString(4, subtotalPrice);
                insertOrderStmt.setString(5, date);

                int rowsAffected = insertOrderStmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Order added successfully!");

                    // Decrease inventory quantity
                    updateInventoryStmt.setInt(1, Integer.parseInt(quantity));  // Decrease by the ordered quantity
                    updateInventoryStmt.setInt(2, mealId);

                    int inventoryUpdated = updateInventoryStmt.executeUpdate();
                    if (inventoryUpdated > 0) {
                        System.out.println("Inventory updated: Quantity decreased.");
                    } else {
                        System.out.println("Error updating inventory.");
                    }
                }
            } else {
                System.out.println("Meal name not found in meals table.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean deleteOrder(int orderId) {
        String deleteSQL = "DELETE FROM Orders WHERE orderId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, orderId);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Order with ID '" + orderId + "' was deleted successfully.");
                return true;
            } else {
                System.out.println("No order found with ID '" + orderId + "'.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}