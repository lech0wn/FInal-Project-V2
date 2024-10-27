package src.site;

import java.sql.*;

public class Promotions {

    private static final String DB_URL = "jdbc:sqlite:C:/iAcademy/Database/groupdatabase.db";

    protected static void createPromotionsTable(){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Promotions ("
                + "promotionId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "promotionType TEXT NOT NULL, "
                + "salesId TEXT NOT NULL)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'Promotions' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void addPromotions(String promotionType, String salesId) {
        String insertSQL = "INSERT INTO Promotions (promotionType, salesId) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, promotionType);
            preparedStatement.setString(2, salesId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Promotions" + promotionType + "successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
