package src.site;

import java.sql.*;

public class Order {

    private static final String DB_URL = "jdbc:sqlite:C:/iAcademy/Database/groupdatabase.db";

    protected static void createOrdersTable(){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Orders ("
                + "orderId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "date TEXT NOT NULL, "
                + "subtotalPrice TEXT NOT NULL, "
                + "mealId TEXT NOT NULL, "
                + "quantity TEXT NOT NULL)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'Orders' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void addOrders(String date, String subtotalPrice, String mealId, String quantity) {
        String insertSQL = "INSERT INTO Orders (date, subtotalPrice, mealId, quantity) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, subtotalPrice);
            preparedStatement.setString(3, mealId);
            preparedStatement.setString(4, quantity);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Order added successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
