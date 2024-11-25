package org.example.WorkersPage;

import org.example.Databases.inventoryDatabase;
import org.example.Databases.ordersDatabase;
import org.example.Extensions.RoundedButton;
import org.example.Extensions.RoundedTextfield;
import org.example.SidePanels.WorkerSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WorkerOrderEditorPage {
    private static JLabel messageLabel;

    public WorkerOrderEditorPage(JFrame frame) {

        frame.setTitle("Worker Order Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        new WorkerSidePanel(frame);

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/meal editor.png");
        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(235, 50, 500, 500);
        frame.add(imageLabel);

        RoundedButton mealEditor = new RoundedButton("ORDER EDITOR");
        mealEditor.setBounds(650, 50, 365, 90);
        mealEditor.setBackground(Color.decode("#752A00"));
        mealEditor.setFont(new Font("Arial", Font.BOLD, 35));
        mealEditor.setForeground(Color.decode("#EF9B39"));
        frame.add(mealEditor);

        JLabel label = new JLabel("Hello! What would you like to do?");
        label.setBounds(650, 150, 1000, 100);
        label.setForeground(Color.decode("#752A00"));
        label.setFont(new Font("Arial", Font.PLAIN, 26));
        frame.add(label);

        RoundedButton addOrdersButton = new RoundedButton("Add Order");
        addOrdersButton.setBounds(650, 250, 365, 85);
        addOrdersButton.setBackground(Color.white);
        addOrdersButton.setFont(new Font("Arial", Font.BOLD, 32));
        addOrdersButton.setBorderThickness(2);
        addOrdersButton.setBorderColor(Color.decode("#331402"));
        addOrdersButton.setForeground(Color.decode("#551F01"));
        addOrdersButton.setFocusable(false);
        addOrdersButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            addOrdersPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(addOrdersButton);

        RoundedButton editOrdersButton = new RoundedButton("Edit Order");
        editOrdersButton.setBounds(650, 350, 365, 85);
        editOrdersButton.setBackground(Color.white);
        editOrdersButton.setFont(new Font("Arial", Font.BOLD, 32));
        editOrdersButton.setBorderThickness(2);
        editOrdersButton.setForeground(Color.decode("#551F01"));
        editOrdersButton.setFocusable(false);
        editOrdersButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            editOrdersPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(editOrdersButton);

        messageLabel = new JLabel();
        messageLabel.setBounds(650, 550, 365, 30); // Adjust the position and size as needed
        messageLabel.setForeground(Color.RED); // Default color for error messages
        frame.add(messageLabel);
    }

    public static void addOrdersPage(JFrame frame) {
        new WorkerSidePanel(frame);

        // Add order label
        JLabel addOrderLabel = new JLabel("ADD ORDER");
        addOrderLabel.setBounds(520, 50, 360, 80);
        addOrderLabel.setOpaque(true);
        addOrderLabel.setBackground(Color.decode("#752A00"));
        addOrderLabel.setForeground(Color.decode("#FACD97"));
        addOrderLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 40));
        addOrderLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        ImageIcon icon = new ImageIcon("src/main/java/org/example/img/addicon.png");
        addOrderLabel.setIcon(icon);
        addOrderLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        addOrderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(addOrderLabel);

        // Meal name label
        JLabel mealNameLabel = new JLabel("Meal Name");
        mealNameLabel.setBounds(370, 200, 300, 45);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(mealNameLabel);

        // Meal name text field
        RoundedTextfield mealNameTf = new RoundedTextfield();
        mealNameTf.setBounds(370, 240, 300, 45);
        mealNameTf.setBorderColor(Color.decode("#331402"));
        mealNameTf.setBorderThickness(2);
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        // Price label
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(700, 200, 300, 45);
        priceLabel.setForeground(Color.decode("#331402"));
        priceLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(priceLabel);

        // Price text field
        RoundedTextfield priceTf = new RoundedTextfield();
        priceTf.setBounds(700, 240, 300, 45);
        priceTf.setBorderColor(Color.decode("#331402"));
        priceTf.setBorderThickness(2);
        priceTf.setBackground(Color.white);
        frame.add(priceTf);

        // Quantity label
        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(370, 280, 300, 45);
        quantityLabel.setForeground(Color.decode("#331402"));
        quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(quantityLabel);

        // Quantity text field
        RoundedTextfield quantityTf = new RoundedTextfield();
        quantityTf.setBounds(370, 320, 300, 45);
        quantityTf.setBorderColor(Color.decode("#331402"));
        quantityTf.setBorderThickness(2);
        quantityTf.setBackground(Color.white);
        frame.add(quantityTf);

        // Date label
        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(700, 280, 300, 45);
        dateLabel.setForeground(Color.decode("#331402"));
        dateLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(dateLabel);

        // Date text field
        RoundedTextfield dateTf = new RoundedTextfield();
        dateTf.setBounds(700, 320, 300, 45);
        dateTf.setBorderColor(Color.decode("#331402"));
        dateTf.setBorderThickness(2);
        dateTf.setBackground(Color.white);
        frame.add(dateTf);

        // Confirmation label
        JLabel confirmationLabel = new JLabel();
        confirmationLabel.setBounds(650, 550, 365, 30); // Adjust the position and size as needed
        confirmationLabel.setForeground(Color.RED); // Default color for error messages
        frame.add(confirmationLabel);

        // Confirm order button
        JButton confirmOrderButton = new JButton("CONFIRM");
        confirmOrderButton.setBounds(850, 500, 160, 40);
        confirmOrderButton.setBackground(Color.decode("#551F01"));
        confirmOrderButton.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmOrderButton.setForeground(Color.white);
        confirmOrderButton.setFocusable(false);
        confirmOrderButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
        confirmOrderButton.addActionListener(e -> {
            String name = mealNameTf.getText();
            String quantityStr = quantityTf.getText();
            String priceStr = priceTf.getText();
            String date = dateTf.getText();

            // Check for empty fields
            if (name.isEmpty() || quantityStr.isEmpty() || priceStr.isEmpty() || date.isEmpty()) {
                confirmationLabel.setForeground(Color.RED);
                confirmationLabel.setText("All fields must have an input.");
                return;
            }

            // Validate input fields
            if (!isValidPrice(priceStr) || !isValidQuantity(quantityStr)) {
                confirmationLabel.setForeground(Color.RED);
                confirmationLabel.setText("Invalid input, please check fields.");
                return;
            }

            // Convert to numeric values
            int quantity = Integer.parseInt(quantityStr);
            double price = Double.parseDouble(priceStr);

            // Check inventory
            int availableStock = inventoryDatabase.getAvailableStock(name);
            if (availableStock < quantity) {
                confirmationLabel.setForeground(Color.RED);
                if (availableStock == 0) {
                    confirmationLabel.setText("Meal is out of stock.");
                } else {
                    confirmationLabel.setText("Only " + availableStock + " items available.");
                }
                return;
            }

            // Calculate subtotal price
            double subtotalPrice = price * quantity;

            // Add order to the database
            ordersDatabase.addOrders(name, String.valueOf(quantity), String.format("%.2f", subtotalPrice), date);

            // Update inventory stock
            inventoryDatabase.updateStock(name, availableStock - quantity);

            // Display success message
            confirmationLabel.setForeground(Color.GREEN);
            confirmationLabel.setText("Order has been added.");

            // Clear input fields for new entry
            mealNameTf.setText("");
            quantityTf.setText("");
            priceTf.setText("");
            dateTf.setText("");
        });
        frame.add(confirmOrderButton);
    }

    private static boolean isValidPrice(String price) {
        try {
            Double.parseDouble(price);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidQuantity(String quantity) {
        try {
            Integer.parseInt(quantity);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void editOrdersPage(JFrame frame) {
        new WorkerSidePanel(frame);

        // Error and confirmation message labels
        JLabel errorMessageLabel = new JLabel();
        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        errorMessageLabel.setBounds(585, 315, 500, 50);
        errorMessageLabel.setVisible(false);  // Initially hidden
        frame.add(errorMessageLabel);

        JLabel confirmationLabel = new JLabel();
        confirmationLabel.setBounds(585, 370, 500, 50);
        confirmationLabel.setForeground(Color.GREEN);
        confirmationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        confirmationLabel.setVisible(false);  // Initially hidden
        frame.add(confirmationLabel);

        RoundedButton inventoryLabel = new RoundedButton("EDIT ORDER");
        inventoryLabel.setBounds(550, 25, 300, 70);
        inventoryLabel.setBackground(Color.decode("#752A00"));
        inventoryLabel.setFont(new Font("Arial", Font.BOLD, 30));
        inventoryLabel.setForeground(Color.decode("#FACD97"));
        inventoryLabel.setFocusable(false);
        frame.add(inventoryLabel);

        JLabel inventoryIdLabel = new JLabel("Enter the order ID of the item you would like to edit:");
        inventoryIdLabel.setBounds(390, 190, 800, 45);
        inventoryIdLabel.setForeground(Color.decode("#331402"));
        inventoryIdLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(inventoryIdLabel);

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
            String orderIdStr = textField.getText().trim();

            // Check if the order ID field is empty
            if (orderIdStr.isEmpty()) {
                errorMessageLabel.setText("Order ID must be provided.");
                errorMessageLabel.setVisible(true);
                confirmationLabel.setVisible(false);
                return;
            }

            int orderId = Integer.parseInt(orderIdStr);

            // Check if the order exists
            if (!ordersDatabase.authenticateOrderId(orderId)) {
                errorMessageLabel.setText("Order ID does not exist!");
                errorMessageLabel.setVisible(true);
                confirmationLabel.setVisible(false);
            } else {
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.revalidate();

                new WorkerSidePanel(frame);

                RoundedButton inventoryLabel1 = new RoundedButton("EDIT ORDER");
                inventoryLabel1.setBounds(550, 25, 300, 70);
                inventoryLabel1.setBackground(Color.decode("#752A00"));
                inventoryLabel1.setFont(new Font("Arial", Font.BOLD, 25));
                inventoryLabel1.setForeground(Color.decode("#FACD97"));
                inventoryLabel1.setFocusable(false);
                frame.add(inventoryLabel1);

                // Meal name label
                JLabel mealNameLabel = new JLabel("Meal Name");
                mealNameLabel.setBounds(370, 200, 300, 45);
                mealNameLabel.setForeground(Color.decode("#331402"));
                mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(mealNameLabel);

                // Meal name text field
                RoundedTextfield mealNameTf = new RoundedTextfield();
                mealNameTf.setBounds(370, 240, 300, 45);
                mealNameTf.setBorderColor(Color.decode("#331402"));
                mealNameTf.setBorderThickness(2);
                mealNameTf.setBackground(Color.white);
                frame.add(mealNameTf);

                // Price label
                JLabel priceLabel = new JLabel("Subtotal Price");
                priceLabel.setBounds(700, 200, 300, 45);
                priceLabel.setForeground(Color.decode("#331402"));
                priceLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(priceLabel);

                // Price text field
                RoundedTextfield priceTf = new RoundedTextfield();
                priceTf.setBounds(700, 240, 300, 45);
                priceTf.setBorderColor(Color.decode("#331402"));
                priceTf.setBorderThickness(2);
                priceTf.setBackground(Color.white);
                frame.add(priceTf);

                // Quantity label
                JLabel quantityLabel = new JLabel("Quantity");
                quantityLabel.setBounds(370, 280, 300, 45);
                quantityLabel.setForeground(Color.decode("#331402"));
                quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(quantityLabel);

                // Quantity text field
                RoundedTextfield quantityTf = new RoundedTextfield();
                quantityTf.setBounds(370, 320, 300, 45);
                quantityTf.setBorderColor(Color.decode("#331402"));
                quantityTf.setBorderThickness(2);
                quantityTf.setBackground(Color.white);
                frame.add(quantityTf);

                // Date label
                JLabel dateLabel = new JLabel("Date");
                dateLabel.setBounds(700, 280, 300, 45);
                dateLabel.setForeground(Color.decode("#331402"));
                dateLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(dateLabel);

                // Date text field
                RoundedTextfield dateTf = new RoundedTextfield();
                dateTf.setBounds(700, 320, 300, 45);
                dateTf.setBorderColor(Color.decode("#331402"));
                dateTf.setBorderThickness(2);
                dateTf.setBackground(Color.white);
                frame.add(dateTf);

                JButton editOrderButton = new JButton("CONFIRM");
                editOrderButton.setBounds(850, 500, 160, 40);
                editOrderButton.setBackground(Color.decode("#551F01"));
                editOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
                editOrderButton.setForeground(Color.white);
                editOrderButton.setFocusable(false);

                editOrderButton.addActionListener(e2 -> {
                    String date = dateTf.getText().trim();
                    String mealName = mealNameTf.getText().trim();
                    String quantity = quantityTf.getText().trim();
                    String price = priceTf.getText().trim();

                    // Check for empty fields
                    if (date.isEmpty() || mealName.isEmpty() || quantity.isEmpty() || price.isEmpty()) {
                        errorMessageLabel.setText("All fields must have an input.");
                        errorMessageLabel.setVisible(true);
                        confirmationLabel.setVisible(false);
                        return;
                    }

                    Integer mealId = ordersDatabase.getMealIdByName(mealName);
                    if (mealId == null) {
                        errorMessageLabel.setText("Meal name not found.");
                        errorMessageLabel.setVisible(true);
                        confirmationLabel.setVisible(false);
                    } else {
                        // Update order
                        ordersDatabase.updateOrder(date, mealName, quantity, price, orderIdStr);
                        confirmationLabel.setText("Order ID " + orderIdStr + " has been edited.");
                        confirmationLabel.setVisible(true);
                        errorMessageLabel.setVisible(false);
                    }
                });
                frame.add(editOrderButton);
            }
        });
        frame.add(button);
        frame.setVisible(true);
    }
}