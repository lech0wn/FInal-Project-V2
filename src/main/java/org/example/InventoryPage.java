package org.example;

import org.example.Databases.inventoryDatabase;
import org.example.Extensions.SearchBar;
import org.example.SidePanels.InventorySidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InventoryPage extends JPanel{

    public InventoryPage(JFrame frame){

        frame.setTitle("Inventory");  //set the title of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        //side panel
        new InventorySidePanel(frame);
        new SearchBar(frame);


        JLabel inventoryIdLabel = new JLabel("Inventory ID");
        inventoryIdLabel.setBounds(350, 80, 150, 45);
        inventoryIdLabel.setOpaque(true);
        inventoryIdLabel.setBackground(Color.decode("#752A00"));
        inventoryIdLabel.setForeground(Color.decode("#EF9B39"));
        inventoryIdLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        inventoryIdLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        inventoryIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(inventoryIdLabel);

        // Meal ID Label
        JLabel mealIdLabel = new JLabel("Meal ID");
        mealIdLabel.setBounds(510, 80, 130, 45);
        mealIdLabel.setOpaque(true);
        mealIdLabel.setBackground(Color.decode("#752A00"));
        mealIdLabel.setForeground(Color.decode("#EF9B39"));
        mealIdLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        mealIdLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        mealIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(mealIdLabel);

        //meal name label
        JLabel mealNameLabel = new JLabel("Meal Name");
        mealNameLabel.setBounds(650, 80, 140, 45);
        mealNameLabel.setOpaque(true);
        mealNameLabel.setBackground(Color.decode("#752A00"));
        mealNameLabel.setForeground(Color.decode("#EF9B39"));
        mealNameLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        mealNameLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        mealNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(mealNameLabel);

        // Quantity Label
        JLabel quantityLabel = new JLabel("Stock");
        quantityLabel.setBounds(800, 80, 130, 45);
        quantityLabel.setOpaque(true);
        quantityLabel.setBackground(Color.decode("#752A00"));
        quantityLabel.setForeground(Color.decode("#EF9B39"));
        quantityLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        quantityLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(quantityLabel);

        // Price Label
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(940, 80, 130, 45);
        priceLabel.setOpaque(true);
        priceLabel.setBackground(Color.decode("#752A00"));
        priceLabel.setForeground(Color.decode("#EF9B39"));
        priceLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        priceLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(priceLabel);

        // Create panel to hold inventory id panels
        JPanel inventoryIdPanelContainer = new JPanel();
        inventoryIdPanelContainer.setLayout(new BoxLayout(inventoryIdPanelContainer, BoxLayout.Y_AXIS)); // Using BoxLayout for vertical layout

        // Create panel to hold meal id panels
        JPanel mealIdPanelContainer = new JPanel();
        mealIdPanelContainer.setLayout(new BoxLayout(mealIdPanelContainer, BoxLayout.Y_AXIS));

        // Create panel to hold meal name panels
        JPanel mealNamePanelContainer = new JPanel();
        mealNamePanelContainer.setLayout(new BoxLayout(mealNamePanelContainer, BoxLayout.Y_AXIS));

        // Create panel to hold quantity panels
        JPanel quantityPanelContainer = new JPanel();
        quantityPanelContainer.setLayout(new BoxLayout(quantityPanelContainer, BoxLayout.Y_AXIS));

        // Create panel to hold price panels
        JPanel pricePanelContainer = new JPanel();
        pricePanelContainer.setLayout(new BoxLayout(pricePanelContainer, BoxLayout.Y_AXIS));

        List<String[]> inventoryIds = inventoryDatabase.listInventory();

        // Loop through inventory entries
        for (String[] inventoryId : inventoryIds){
            // Create inventoryId panel
            JPanel inventoryIdPanel = new JPanel();
            inventoryIdPanel.setLayout(new BorderLayout());
            inventoryIdPanel.setPreferredSize(new Dimension(200, 50));
            inventoryIdPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            inventoryIdPanel.setBackground(Color.decode("#752A00"));

            JLabel idLabel = new JLabel(inventoryId[0], SwingConstants.CENTER);
            idLabel.setFont(new Font("Milonga", Font.BOLD, 14));
            idLabel.setForeground(Color.decode("#EF9B39"));
            inventoryIdPanel.add(idLabel, BorderLayout.CENTER);

            // Add inventoryIdPanel to container
            inventoryIdPanelContainer.add(inventoryIdPanel);

            // Create mealId panel
            JPanel mealIdPanel = new JPanel();
            mealIdPanel.setLayout(new BorderLayout());
            mealIdPanel.setPreferredSize(new Dimension(200, 50));
            mealIdPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            mealIdPanel.setBackground(Color.decode("#752A00"));

            JLabel mealIdLabel2 = new JLabel(inventoryId[1], SwingConstants.CENTER);
            mealIdLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            mealIdLabel2.setForeground(Color.decode("#EF9B39"));
            mealIdPanel.add(mealIdLabel2, BorderLayout.CENTER);

            // Add mealIdPanel to container
            mealIdPanelContainer.add(mealIdPanel);

            // Create mealName panel
            JPanel mealNamePanel = new JPanel();
            mealNamePanel.setLayout(new BorderLayout());
            mealNamePanel.setPreferredSize(new Dimension(200, 50));
            mealNamePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            mealNamePanel.setBackground(Color.decode("#752A00"));

            JLabel mealNameLabel2 = new JLabel(inventoryId[2], SwingConstants.CENTER);
            mealNameLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            mealNameLabel2.setForeground(Color.decode("#EF9B39"));
            mealNamePanel.add(mealNameLabel2, BorderLayout.CENTER);
            mealNamePanelContainer.add(mealNamePanel);


            // Create quantity panel
            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new BorderLayout());
            quantityPanel.setPreferredSize(new Dimension(200, 50));
            quantityPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            quantityPanel.setBackground(Color.decode("#752A00"));

            int quantity = Integer.parseInt(inventoryId[3]);  // Assuming quantity is at index 3
            JLabel quantityLabel2 = new JLabel(String.valueOf(quantity), SwingConstants.CENTER);
            quantityLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            quantityLabel2.setForeground(Color.decode("#EF9B39"));

            if (quantity < 5) {
                quantityLabel2.setForeground(Color.RED);
            }

            quantityPanel.add(quantityLabel2, BorderLayout.CENTER);

            // Add quantityPanel to container
            quantityPanelContainer.add(quantityPanel);

            // Create price panel
            JPanel pricePanel = new JPanel();
            pricePanel.setLayout(new BorderLayout());
            pricePanel.setPreferredSize(new Dimension(200, 50));
            pricePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            pricePanel.setBackground(Color.decode("#752A00"));

            JLabel priceLabel2 = new JLabel(inventoryId[4], SwingConstants.CENTER);
            priceLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            priceLabel2.setForeground(Color.decode("#EF9B39"));
            pricePanel.add(priceLabel2, BorderLayout.CENTER);

            // Add pricePanel to container
            pricePanelContainer.add(pricePanel);
        }

        // Create a single container for all columns
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(null); // Use null layout for precise positioning
        dataPanel.setBackground(Color.decode("#EF9B39"));
        dataPanel.setPreferredSize(new Dimension(750, inventoryIds.size() * 55)); // Adjust height based on number of rows

        // Add individual column containers to dataPanel
        inventoryIdPanelContainer.setBounds(0, 0, 150, inventoryIds.size() * 55);
        mealIdPanelContainer.setBounds(160, 0, 130, inventoryIds.size() * 55);
        mealNamePanelContainer.setBounds(300, 0, 140, inventoryIds.size() * 55);
        quantityPanelContainer.setBounds(450, 0, 130, inventoryIds.size() * 55);
        pricePanelContainer.setBounds(590, 0, 130, inventoryIds.size() * 55);

        dataPanel.add(inventoryIdPanelContainer);
        dataPanel.add(mealIdPanelContainer);
        dataPanel.add(mealNamePanelContainer);
        dataPanel.add(quantityPanelContainer);
        dataPanel.add(pricePanelContainer);

        // Add dataPanel to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(dataPanel);
        scrollPane.setBounds(350, 140, 735, 400); // Position and size of the scrolling area
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the JScrollPane to the frame
        frame.add(scrollPane);
    }
}


