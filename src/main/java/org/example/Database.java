package org.example;
import java.sql.*;

import static org.example.mealsDatabase.createMealsTable;
import static org.example.usersDatabase.createUsersTable;

public class Database {

    private static final String url = "jdbc:sqlite:detabeso.db"; // Database URL

    public static void main(String[] args) {
        createUsersTable();
        createMealsTable();
        createOrdersTable();
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
}
