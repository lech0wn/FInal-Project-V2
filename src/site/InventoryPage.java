package src.site;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class InventoryPage extends JFrame {
    public InventoryPage() {
        setTitle("Cafe Inventory");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel for the inventory
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.decode("#D9E0B2")); // Example background color

        // Inventory items
        String[] inventoryItems = {
                "1. Coffee Beans - 100 units",
                "2. Tea Leaves - 50 units",
                "3. Bread - 30 units",
                "4. Milk - 20 units",
                "5. Sugar - 10 units"
        };

        // Create a label for each inventory item
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        for (int i = 0; i < inventoryItems.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(new JLabel(inventoryItems[i]), gbc);
        }

        // Add a button to go back to the selection page
        JButton backButton = new JButton("Back to Selection");
        gbc.gridy = inventoryItems.length + 1; // Place it after the "Back to Menu" button
        panel.add(backButton, gbc);

        // Add action listener to the "Back" button to return to SelectionPage
        backButton.addActionListener(e -> {
            SelectionPage selectionPage = new SelectionPage();
            selectionPage.setVisible(true);
            dispose(); // Close the inventory page
        });

        // Add panel to frame
        add(panel);
    }

    private String[] fetchInventoryItems() {
        ArrayList<String> items = new ArrayList<>();
        String query = "SELECT * FROM Inventory"; // Assuming you have an Inventory table

        try (Connection connection = DriverManager.getConnection(User.DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String itemName = resultSet.getString("item_name"); // Assuming column name
                int quantity = resultSet.getInt("quantity"); // Assuming column name
                items.add(itemName + " - " + quantity + " units");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items.toArray(new String[0]);
    }
}

