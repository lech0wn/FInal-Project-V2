package org.example;

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
        String query = "SELECT orderId, mealId, mealName, quantity, subtotalPrice, date FROM Orders";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String orderId = String.valueOf(resultSet.getInt("orderId"));
                String mealId = String.valueOf(resultSet.getInt("mealId"));
                String mealName = resultSet.getString("mealName");
                String quantity = resultSet.getString("quantity");
                String subtotalPrice = resultSet.getString("subtotalPrice");
                String date = resultSet.getString("date");
                ordersList.add(new String[]{orderId, mealId, mealName, quantity, subtotalPrice, date});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ordersList;
    }

    //insert orders into orders table
    public static void addOrders(String mealName, String quantity, String subtotalPrice, String date) {
        String getMealIdSQL = "SELECT mealId FROM meals WHERE mealName = ?";
        String insertOrderSQL = "INSERT INTO Orders (mealId, mealName, quantity, subtotalPrice, date) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement getMealIdStmt = connection.prepareStatement(getMealIdSQL);
             PreparedStatement insertOrderStmt = connection.prepareStatement(insertOrderSQL)) {

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
            } else {
                System.out.println("No order found with ID '" + orderId + "'.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
