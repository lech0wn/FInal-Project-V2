package org.example;

import org.example.Databases.inventoryDatabase;
import org.example.Extensions.RoundedButton;
import org.example.Extensions.RoundedTextfield;
import org.example.SidePanels.InventorySidePanel;
import org.example.SidePanels.MealSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InventoryEditorPage {

    public InventoryEditorPage(JFrame frame){

        frame.setTitle("Inventory Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        new InventorySidePanel(frame);

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/meal editor.png");
        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(235, 50, 500, 500);
        frame.add(imageLabel);

        RoundedButton mealEditor = new RoundedButton("INVENTORY EDITOR");
        mealEditor.setBounds(650, 50, 365, 90);
        mealEditor.setBackground(Color.decode("#752A00"));
        mealEditor.setFont(new Font("Arial", 1, 30));
        mealEditor.setForeground(Color.decode("#EF9B39"));
        frame.add(mealEditor);

        JLabel label = new JLabel("Hello! What would you like to do?");
        label.setBounds(650, 150, 1000, 100);
        label.setForeground(Color.decode("#752A00"));
        label.setFont(new Font("Arial", 0, 26));
        frame.add(label);

        RoundedButton addInventoryButton = new RoundedButton("Add Inventory");
        addInventoryButton.setBounds(650, 250, 365, 85);
        addInventoryButton.setBackground(Color.white);
        addInventoryButton.setFont(new Font ("Arial", 1, 32));
        addInventoryButton.setBorderThickness(2);
        addInventoryButton.setBorderColor(Color.decode("#331402"));
        addInventoryButton.setForeground(Color.decode("#551F01"));
        addInventoryButton.setFocusable(false);
        addInventoryButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            addInventoryPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(addInventoryButton);

        RoundedButton editInventoryButton = new RoundedButton("Edit Inventory");
        editInventoryButton.setBounds(650, 350, 365, 85);
        editInventoryButton.setBackground(Color.white);
        editInventoryButton.setFont(new Font ("Arial", 1, 32));
        editInventoryButton.setBorderThickness(2);
        editInventoryButton.setForeground(Color.decode("#551F01"));
        editInventoryButton.setFocusable(false);
        editInventoryButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            editInventoryPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(editInventoryButton);

        RoundedButton deleteInventoryButton = new RoundedButton("Delete Inventory");
        deleteInventoryButton.setBounds(650, 450, 365, 85);
        deleteInventoryButton.setBackground(Color.white);
        deleteInventoryButton.setFont(new Font ("Arial", 1, 32));
        deleteInventoryButton.setBorderThickness(2);
        deleteInventoryButton.setBorderColor(Color.decode("#331402"));
        deleteInventoryButton.setForeground(Color.decode("#551F01"));
        deleteInventoryButton.setFocusable(false);
        deleteInventoryButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            deleteInventoryPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(deleteInventoryButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void addInventoryPage(JFrame frame) {
        // Side panel
        new InventorySidePanel(frame);

        JLabel addInventoryLabel = new JLabel("ADD INVENTORY");
        addInventoryLabel.setBounds(500, 50, 430, 80);
        addInventoryLabel.setOpaque(true);
        addInventoryLabel.setBackground(Color.decode("#752A00"));
        addInventoryLabel.setForeground(Color.decode("#FACD97"));
        addInventoryLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 40));
        addInventoryLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        ImageIcon icon = new ImageIcon("src/main/java/org/example/img/addicon.png"); // Replace with the path to your image
        addInventoryLabel.setIcon(icon);
        addInventoryLabel.setHorizontalTextPosition(SwingConstants.RIGHT); // Text on the right, image on the left
        addInventoryLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right
        frame.add(addInventoryLabel);

        JLabel mealNameLabel = new JLabel("Meal Name");
        mealNameLabel.setBounds(370, 240, 300, 45);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(mealNameLabel);

        // Meal Name text field
        RoundedTextfield mealNameTf = new RoundedTextfield();
        mealNameTf.setBounds(370, 280, 300, 45);
        mealNameTf.setBorderColor(Color.decode("#331402"));
        mealNameTf.setBorderThickness(2);
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(700, 240, 300, 45);
        quantityLabel.setForeground(Color.decode("#331402"));
        quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(quantityLabel);

        // Quantity text field
        RoundedTextfield quantityTf = new RoundedTextfield();
        quantityTf.setBounds(700, 280, 300, 45);
        quantityTf.setBorderColor(Color.decode("#331402"));
        quantityTf.setBorderThickness(2);
        quantityTf.setBackground(Color.white);
        frame.add(quantityTf);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(370, 320, 300, 45);
        priceLabel.setForeground(Color.decode("#331402"));
        priceLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(priceLabel);

        // Price text field
        RoundedTextfield priceTf = new RoundedTextfield();
        priceTf.setBounds(370, 360, 300, 45);
        priceTf.setBorderColor(Color.decode("#331402"));
        priceTf.setBorderThickness(2);
        priceTf.setBackground(Color.white);
        frame.add(priceTf);

        // Error label (persistent, updated on validation failure)
        JLabel errorLabel = new JLabel("");
        errorLabel.setBounds(370, 420, 630, 45);
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(errorLabel);

        JLabel confirmLabel = new JLabel("Inventory item added!");
        confirmLabel.setBounds(370, 420, 630, 45);
        confirmLabel.setForeground(Color.GREEN);
        confirmLabel.setFont(new Font("Arial", Font.BOLD, 16));
        confirmLabel.setVisible(false);
        frame.add(confirmLabel);


        JButton confirmInventoryButton = new JButton("CONFIRM");
        confirmInventoryButton.setBounds(850, 500, 160, 40);
        confirmInventoryButton.setBackground(Color.decode("#551F01"));
        confirmInventoryButton.setFont(new Font("Arial", Font.BOLD, 18));
        confirmInventoryButton.setForeground(Color.white);
        confirmInventoryButton.setFocusable(false);
        confirmInventoryButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));

        confirmInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mealName = mealNameTf.getText();
                String quantityStr = quantityTf.getText();
                String priceStr = priceTf.getText();

                // Reset error label before validation
                errorLabel.setText("");

                // Validate inputs
                if (mealName.isEmpty()) {
                    errorLabel.setText("Meal Name cannot be empty.");
                    return;
                }
                if (!quantityStr.matches("\\d+")) {
                    errorLabel.setText("Quantity must be a numeric value.");
                    return;
                }
                if (!priceStr.matches("\\d+")) {
                    errorLabel.setText("Price must be a numeric value.");
                    return;
                }

                int quantity = Integer.parseInt(quantityStr);
                int price = Integer.parseInt(priceStr);

                // Check if the meal exists in the database
                if (!inventoryDatabase.doesMealExist(mealName)) {
                    errorLabel.setText("Meal does not exist.");
                    return;
                }

                // Add inventory to the database
                inventoryDatabase.addInventory(mealName, quantity, price);
                mealNameTf.setText("");
                quantityTf.setText("");
                priceTf.setText("");
                errorLabel.setText(""); // Clear error message

                confirmLabel.setVisible(true);
            }
        });

        frame.add(confirmInventoryButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }


    public static void editInventoryPage(JFrame frame) {

        new InventorySidePanel(frame);

        JLabel errorMessageLabel = new JLabel();
        errorMessageLabel.setText("Inventory ID not found!");
        errorMessageLabel.setForeground(Color.red);
        errorMessageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        errorMessageLabel.setBounds(585, 315, 500, 50);
        errorMessageLabel.setVisible(false);  //initially hidden

        //edit inventory
        RoundedButton inventoryLabel = new RoundedButton("EDIT INVENTORY");
        inventoryLabel.setBounds(550, 25, 300, 70);
        inventoryLabel.setBackground(Color.decode("#752A00"));
        inventoryLabel.setFont(new Font("Arial", Font.BOLD, 25));
        inventoryLabel.setForeground(Color.decode("#FACD97"));
        inventoryLabel.setFocusable(false);
        frame.add(inventoryLabel);

        JLabel inventoryIdlabel = new JLabel();
        inventoryIdlabel.setText("Enter the inventory ID of the item to edit:  ");
        inventoryIdlabel.setBounds(470, 190, 800, 45);
        inventoryIdlabel.setForeground(Color.decode("#331402"));
        inventoryIdlabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 25));
        frame.add(inventoryIdlabel);

        RoundedTextfield textField = new RoundedTextfield();
        textField.setBounds(450, 250, 500, 70);
        textField.setBorderColor(Color.decode("#331402"));
        textField.setBorderThickness(4);
        textField.setBackground(Color.WHITE);
        frame.add(textField);

        RoundedButton button = new RoundedButton("CONFIRM");
        button.setBounds(600, 370, 200, 50);
        button.setForeground(Color.white);
        button.setBackground(Color.decode("#551F01"));
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusable(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setBackground(Color.decode("#A8775C"));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBackground(Color.decode("#551F01"));
            }
        });
        button.addActionListener(e -> {
            int inventoryId = Integer.parseInt(textField.getText().trim());

            if(inventoryDatabase.authenticateInventoryId(inventoryId)) {
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.revalidate();

                new MealSidePanel(frame);

                RoundedButton inventoryLabel1 = new RoundedButton("EDIT INVENTORY");
                inventoryLabel1.setBounds(550, 25, 300, 70);
                inventoryLabel1.setBackground(Color.decode("#752A00"));
                inventoryLabel1.setFont(new Font("Arial", Font.BOLD, 25));
                inventoryLabel1.setForeground(Color.decode("#FACD97"));
                inventoryLabel1.setFocusable(false);
                frame.add(inventoryLabel1);

                JLabel mealNameLabel = new JLabel();
                mealNameLabel.setText("Meal Name");
                mealNameLabel.setBounds(370, 240, 300, 45);
                mealNameLabel.setForeground(Color.decode("#331402"));
                mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(mealNameLabel);

                RoundedTextfield mealNameTf = new RoundedTextfield();
                mealNameTf.setBounds(370, 280, 300, 45);
                mealNameTf.setBorderColor(Color.decode("#331402"));
                mealNameTf.setBorderThickness(4);
                mealNameTf.setBackground(Color.WHITE);
                frame.add(mealNameTf);

                JLabel quantityLabel = new JLabel();
                quantityLabel.setText("Quantity");
                quantityLabel.setBounds(700, 240, 300, 45);
                quantityLabel.setForeground(Color.decode("#331402"));
                quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(quantityLabel);

                RoundedTextfield quantityTf = new RoundedTextfield();
                quantityTf.setBounds(700, 280, 300, 45);
                quantityTf.setBorderColor(Color.decode("#331402"));
                quantityTf.setBorderThickness(4);
                quantityTf.setBackground(Color.white);
                frame.add(quantityTf);

                JLabel priceLabel = new JLabel();
                priceLabel.setText("Price");
                priceLabel.setBounds(370, 320, 300, 45);
                priceLabel.setForeground(Color.decode("#331402"));
                priceLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(priceLabel);

                RoundedTextfield priceTf = new RoundedTextfield();
                priceTf.setBounds(370, 360, 300, 45);
                priceTf.setBorderColor(Color.decode("#331402"));
                priceTf.setBorderThickness(4);
                priceTf.setBackground(Color.white);
                frame.add(priceTf);

                JButton editInventoryButton = new JButton();
                editInventoryButton.setText("CONFIRM");
                editInventoryButton.setBounds(850, 500, 160, 40);
                editInventoryButton.setBackground(Color.decode("#551F01"));
                editInventoryButton.setFont(new Font("Arial", Font.BOLD, 18));
                editInventoryButton.setForeground(Color.white);
                editInventoryButton.setFocusable(false);

                editInventoryButton.addActionListener(e1 -> {
                    String mealName = mealNameTf.getText();
                    String quantity = quantityTf.getText();
                    String price = priceTf.getText();
                    String inventoryId1 = textField.getText();

                    Integer mealId = inventoryDatabase.getMealIdByName(mealName);
                    if (mealId == null) {
                        //show error message if meal name is not found
                        errorMessageLabel.setVisible(true);
                        frame.add(errorMessageLabel);
                    } else {
                        //update inventory
                        inventoryDatabase.updateInventory(mealName, quantity, price, inventoryId1);
                        new InventoryPage(frame);
                    }
                });
                frame.add(editInventoryButton);

            } else {
                errorMessageLabel.setVisible(true);
                frame.add(errorMessageLabel);
            }
        });
        frame.add(errorMessageLabel);
        frame.add(button);
        frame.setVisible(true);
    }

    public static void deleteInventoryPage (JFrame frame){

        new InventorySidePanel(frame);

        // delete inventory button
        JLabel deleteInventoryLabel = new JLabel("DELETE INVENTORY");
        deleteInventoryLabel.setBounds(500, 50, 430, 80);
        deleteInventoryLabel.setOpaque(true);
        deleteInventoryLabel.setBackground(Color.decode("#752A00"));
        deleteInventoryLabel.setForeground(Color.decode("#FACD97"));
        deleteInventoryLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 32));
        deleteInventoryLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        ImageIcon icon = new ImageIcon("src/main/java/org/example/img/deleteicon.png"); // Replace with the path to your image
        deleteInventoryLabel.setIcon(icon);
        deleteInventoryLabel.setHorizontalTextPosition(SwingConstants.RIGHT); // Text on the right, image on the left
        deleteInventoryLabel.setHorizontalAlignment(SwingConstants.RIGHT); //align text to the right
        frame.add(deleteInventoryLabel);

        // inventory id delete label
        JLabel inventoryLabel = new JLabel();
        inventoryLabel.setText("Enter the inventory ID of the inventory item you would like to delete:  ");
        inventoryLabel.setBounds(400, 190, 800, 45);
        inventoryLabel.setForeground(Color.decode("#331402"));
        inventoryLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(inventoryLabel);

        // inventory ID text field
        RoundedTextfield inventoryIdTf = new RoundedTextfield();
        inventoryIdTf.setBounds(460, 230, 500, 70);
        inventoryIdTf.setBorderColor(Color.decode("#331402"));
        inventoryIdTf.setBorderThickness(4);
        inventoryIdTf.setBackground(Color.white);
        frame.add(inventoryIdTf);

        // Error/Confirmation Label
        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(460, 290, 500, 45);
        statusLabel.setForeground(Color.RED); // Default to error color
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(statusLabel);

        // delete order button
        JButton deleteInventoryButton = new JButton();
        deleteInventoryButton.setText("CONFIRM");
        deleteInventoryButton.setBounds(580, 370, 250, 40);
        deleteInventoryButton.setBackground(Color.decode("#551F01"));
        deleteInventoryButton.setFont(new Font("Arial", Font.BOLD, 18));
        deleteInventoryButton.setForeground(Color.white);
        deleteInventoryButton.addActionListener(e -> {
            String inventoryIdStr = inventoryIdTf.getText();

            // Clear previous status message
            statusLabel.setText("");

            // Validate input
            if (inventoryIdStr.isEmpty()) {
                statusLabel.setText("Inventory ID cannot be empty.");
                return;
            }

            if (!inventoryIdStr.matches("\\d+")) {
                statusLabel.setText("Inventory ID must be a numeric value.");
                return;
            }

            int inventoryId = Integer.parseInt(inventoryIdStr);

            // Attempt to delete the inventory
            if (inventoryDatabase.deleteInventory(inventoryId)) {
                statusLabel.setForeground(new Color(0, 128, 0)); // Change to green for success
                statusLabel.setText("Inventory ID deleted successfully.");
                inventoryIdTf.setText(""); // Clear input field
            } else {
                statusLabel.setForeground(Color.RED); // Red for errors
                statusLabel.setText("Inventory ID not found.");
            }
        });
        frame.add(deleteInventoryButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
