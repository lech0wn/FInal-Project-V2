package org.example;
import java.sql.*;

import static org.example.inventoryDatabase.createInventoryTable;
import static org.example.mealsDatabase.createMealsTable;
import static org.example.ordersDatabase.createOrdersTable;
import static org.example.usersDatabase.createUsersTable;

public class Database {

    private static final String url = "jdbc:sqlite:database.db"; // Database URL

    public static void main(String[] args) {
        createUsersTable();
        createMealsTable();
        createOrdersTable();
        createInventoryTable();
    }
}
