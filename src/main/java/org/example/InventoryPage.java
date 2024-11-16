package org.example;

import org.example.Databases.inventoryDatabase;
import org.example.Databases.mealsDatabase;
import org.example.Extensions.SearchBar;
import org.example.SidePanels.InventorySidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class InventoryPage extends JPanel {
    private JComboBox<String> filterComboBox;
    private final String[] categories = {"All", "Vegetarian", "Non-Vegetarian"};

    public InventoryPage(JFrame frame) {
        frame.setTitle("Inventory");  // Set the title of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the application when the window is closed

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        // Side panel
        new InventorySidePanel(frame);
        new SearchBar(frame);

        // Column labels
        JLabel inventoryIdLabel = new JLabel("Inventory ID");
        inventoryIdLabel.setBounds(350, 80, 150, 45);
        styleLabel(inventoryIdLabel);
        frame.add(inventoryIdLabel);

        JLabel mealIdLabel = new JLabel("Meal ID");
        mealIdLabel.setBounds(510, 80, 130, 45);
        styleLabel(mealIdLabel);
        frame.add(mealIdLabel);

        JLabel mealNameLabel = new JLabel("Meal Name");
        mealNameLabel.setBounds(650, 80, 140, 45);
        styleLabel(mealNameLabel);
        frame.add(mealNameLabel);

        JLabel quantityLabel = new JLabel("Stock");
        quantityLabel.setBounds(800, 80, 130, 45);
        styleLabel(quantityLabel);
        frame.add(quantityLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(940, 80, 130, 45);
        styleLabel(priceLabel);
        frame.add(priceLabel);

        // Create container for all column panels
        JPanel inventoryPanelContainer = new JPanel();
        inventoryPanelContainer.setLayout(null);  // Use null layout for precise positioning

        // Create individual containers for each column
        JPanel inventoryIdPanelContainer = new JPanel();
        inventoryIdPanelContainer.setLayout(new BoxLayout(inventoryIdPanelContainer, BoxLayout.Y_AXIS));

        JPanel mealIdPanelContainer = new JPanel();
        mealIdPanelContainer.setLayout(new BoxLayout(mealIdPanelContainer, BoxLayout.Y_AXIS));

        JPanel mealNamePanelContainer = new JPanel();
        mealNamePanelContainer.setLayout(new BoxLayout(mealNamePanelContainer, BoxLayout.Y_AXIS));

        JPanel quantityPanelContainer = new JPanel();
        quantityPanelContainer.setLayout(new BoxLayout(quantityPanelContainer, BoxLayout.Y_AXIS));

        JPanel pricePanelContainer = new JPanel();
        pricePanelContainer.setLayout(new BoxLayout(pricePanelContainer, BoxLayout.Y_AXIS));

        List<String[]> inventoryIds = inventoryDatabase.listInventory();

        // Loop through inventory entries
        for (String[] inventoryId : inventoryIds) {
            // Create and add panels for each entry
            addInventoryPanels(inventoryId, inventoryIdPanelContainer, mealIdPanelContainer, mealNamePanelContainer,
                    quantityPanelContainer, pricePanelContainer);
        }

        // Add individual column containers to the inventoryPanelContainer with exact positioning
        inventoryIdPanelContainer.setBounds(0, 0, 150, inventoryIds.size() * 55);
        mealIdPanelContainer.setBounds(160, 0, 130, inventoryIds.size() * 55);
        mealNamePanelContainer.setBounds(300, 0, 140, inventoryIds.size() * 55);
        quantityPanelContainer.setBounds(450, 0, 130, inventoryIds.size() * 55);
        pricePanelContainer.setBounds(590, 0, 130, inventoryIds.size() * 55);

        inventoryPanelContainer.setBackground(Color.decode("#EF9B39"));
        inventoryPanelContainer.add(inventoryIdPanelContainer);
        inventoryPanelContainer.add(mealIdPanelContainer);
        inventoryPanelContainer.add(mealNamePanelContainer);
        inventoryPanelContainer.add(quantityPanelContainer);
        inventoryPanelContainer.add(pricePanelContainer);

        // Create a scrollable area for inventory data
        JScrollPane scrollPane = new JScrollPane(inventoryPanelContainer);
        scrollPane.setBounds(350, 140, 735, 400); // Position and size of the scrolling area
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBackground(Color.decode("#EF9B39"));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the JScrollPane to the frame
        frame.add(scrollPane);

        // Filter combo box for categories
        filterComboBox = new JComboBox<>(categories);
        filterComboBox.setBounds(940, 20, 130, 40); // Smaller size and top-right position
        filterComboBox.setFont(new Font("Arial", Font.BOLD, 14)); // Optional font customization
        filterComboBox.setForeground(Color.decode("#EF9B39"));
        filterComboBox.setBackground(Color.decode("#752A00"));
        filterComboBox.setBorder(BorderFactory.createEmptyBorder());
        filterComboBox.setFocusable(false);
        frame.add(filterComboBox);
    }

    private void styleLabel(JLabel label) {
        label.setOpaque(true);
        label.setBackground(Color.decode("#752A00"));
        label.setForeground(Color.decode("#EF9B39"));
        label.setFont(new Font("Milonga", Font.BOLD, 18));
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void addInventoryPanels(String[] inventoryId, JPanel inventoryIdPanelContainer, JPanel mealIdPanelContainer,
                                    JPanel mealNamePanelContainer, JPanel quantityPanelContainer, JPanel pricePanelContainer) {
        // Inventory ID Panel
        JPanel inventoryIdPanel = createPanel(inventoryId[0]);
        inventoryIdPanelContainer.add(inventoryIdPanel);

        // Meal ID Panel
        JPanel mealIdPanel = createPanel(inventoryId[1]);
        mealIdPanelContainer.add(mealIdPanel);

        // Meal Name Panel
        JPanel mealNamePanel = createPanel(inventoryId[2]);
        mealNamePanelContainer.add(mealNamePanel);

        // Quantity Panel
        JPanel quantityPanel = createPanel(String.valueOf(inventoryId[3]));
        int quantity = Integer.parseInt(inventoryId[3]);
        JLabel quantityLabel = new JLabel(String.valueOf(quantity), SwingConstants.CENTER);
        if (quantity < 5) {
            quantityLabel.setForeground(Color.RED);
        } else {
            quantityLabel.setForeground(Color.decode("#EF9B39"));
        }
        quantityPanel.add(quantityLabel, BorderLayout.CENTER);
        quantityPanelContainer.add(quantityPanel);

        // Price Panel
        JPanel pricePanel = createPanel(inventoryId[4]);
        pricePanelContainer.add(pricePanel);
    }

    private JPanel createPanel(String text) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#752A00"));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(200, 50));
        panel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Milonga", Font.BOLD, 15));
        label.setForeground(Color.decode("#EF9B39"));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}