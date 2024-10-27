package src.site;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionPage extends JFrame {

    public SelectionPage() {
        setTitle("Select Option");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JButton menuButton = new JButton("Go to Menu");
        JButton inventoryButton = new JButton("Go to Inventory");

        // Add action listeners for each button
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open MenuPage and close this page
                MenuPage menuPage = new MenuPage();
                menuPage.setVisible(true);
                dispose(); // Close the SelectionPage
            }
        });

        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open InventoryPage and close this page
                InventoryPage inventoryPage = new InventoryPage();
                inventoryPage.setVisible(true);
                dispose(); // Close the SelectionPage
            }
        });

        // Add buttons to the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(menuButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(inventoryButton, gbc);

        // Add panel to frame
        add(panel);
    }
}
