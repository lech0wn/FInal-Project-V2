package src.site;

import java.sql.*;

public class Sales {

    private static final String DB_URL = "jdbc:sqlite:C:/iAcademy/Database/groupdatabase.db";

    protected static void createSalesTable(){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Sales ("
                + "salesId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "date TEXT NOT NULL, "
                + "orderId TEXT NOT NULL, "
                + "revenue TEXT NOT NULL)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'Sales' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void addSales(String date, String orderId, String revenue) {
        String insertSQL = "INSERT INTO Sales (date, orderId, revenue) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, orderId);
            preparedStatement.setString(3, revenue);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sales " + revenue + " added successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
