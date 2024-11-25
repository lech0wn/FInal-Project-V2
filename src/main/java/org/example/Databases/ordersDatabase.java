package org.example.Databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ordersDatabase {

    private static final String url = "jdbc:sqlite:database.db";

    // Create Orders table with price column
    public static void createOrdersTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Orders ("
                + "orderId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "mealId INTEGER, "
                + "mealName TEXT NOT NULL, "
                + "quantity TEXT NOT NULL, "
                + "price TEXT NOT NULL, "
                + "date TEXT NOT NULL, "
                + "status TEXT DEFAULT 'Pending', "
                + "isDeleted INTEGER DEFAULT 0, " // New column to track deleted orders
                + "FOREIGN KEY (mealId) REFERENCES meals(mealId))"; // Link mealId to meals table
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'Orders' created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all orders
    public static List<String[]> listOrders() {
        return getOrdersByStatus(null, false);
    }

    // Retrieve completed orders
    public static List<String[]> listCompletedOrders() {
        return getOrdersByStatus("Completed", false);
    }

    // Retrieve deleted orders
    public static List<String[]> listDeletedOrders() {
        return getOrdersByStatus(null, true);
    }

    // Helper method to retrieve orders by status or deletion flag
    private static List<String[]> getOrdersByStatus(String status, boolean isDeleted) {
        List<String[]> ordersList = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT orderId, date, mealName, quantity, price, status FROM Orders WHERE isDeleted = ?");

        if (status != null) {
            query.append(" AND status = ?");
        }

        query.append(" ORDER BY orderId");

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(query.toString())) {

            statement.setInt(1, isDeleted ? 1 : 0);
            if (status != null) {
                statement.setString(2, status);
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String orderId = String.format("%03d", resultSet.getInt("orderId"));
                String date = resultSet.getString("date");
                String mealName = resultSet.getString("mealName");
                String quantity = String.valueOf(resultSet.getInt("quantity"));
                String price = String.format("₱%.2f", resultSet.getDouble("price"));
                String orderStatus = resultSet.getString("status");

                ordersList.add(new String[]{orderId, date, mealName, quantity, price, orderStatus});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordersList;
    }

    public static Integer getMealIdByName(String mealName) {
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

    // Insert orders into orders table
    public static void addOrders(String mealName, String quantity, String price, String date) {
        String getMealIdSQL = "SELECT mealId FROM meals WHERE mealName = ?";
        String insertOrderSQL = "INSERT INTO Orders (mealId, mealName, quantity, price, date, status) VALUES (?, ?, ?, ?, ?, 'Pending')";
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
                insertOrderStmt.setString(4, price);
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

    // Delete order by order ID
    public static boolean deleteOrder(int orderId) {
        String deleteSQL = "UPDATE Orders SET isDeleted = 1 WHERE orderId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, orderId);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Order with ID '" + orderId + "' was marked as deleted successfully.");
                return true;
            } else {
                System.out.println("No order found with ID '" + orderId + "'.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update order details
    public static void updateOrder(String date, String mealName, String quantity, String price, String orderId) {
        String updateInventorySQL = "UPDATE Orders SET date = ?, mealName = ?, quantity = ?, price = ? WHERE orderId = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(updateInventorySQL)) {

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, mealName);
            preparedStatement.setString(3, quantity);
            preparedStatement.setString(4, price);  // Update price
            preparedStatement.setString(5, orderId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Order updated successfully!");
            } else {
                System.out.println("No order found with the specified ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update the order status
    public static void updateOrderStatus(int orderId, String status) {
        String updateStatusSQL = "UPDATE Orders SET status = ? WHERE orderId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(updateStatusSQL)) {

            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, orderId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Order status updated successfully for Order ID: " + orderId);
            } else {
                System.out.println("No order found with Order ID: " + orderId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> getOrderByMealName(String mealName) {
        List<String[]> orders = new ArrayList<>();
        String query = "SELECT orderId, date, mealName, quantity, price, status FROM Orders WHERE LOWER(mealName) = LOWER(?) AND isDeleted = 0";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, mealName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String orderId = String.format("%03d", resultSet.getInt("orderId"));
                String date = resultSet.getString("date");
                String mealName1 = resultSet.getString("mealName");
                String quantity = String.valueOf(resultSet.getInt("quantity"));
                String price = String.format("₱%.2f", resultSet.getDouble("price"));
                String status = resultSet.getString("status");

                orders.add(new String[]{orderId, date, mealName1, quantity, price, status});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Authenticate if the order ID exists
    public static boolean authenticateOrderId(int orderId) {
        String selectSQL = "SELECT * FROM Orders WHERE orderId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, orderId);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}