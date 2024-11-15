package org.example;

import org.example.Databases.inventoryDatabase;
import org.example.SidePanels.InventorySidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        mealEditor.setFont(new Font("Arial", 1, 45));
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
        addInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                addInventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(addInventoryButton);

        RoundedButton editInventoryButton = new RoundedButton("Edit Inventory");
        editInventoryButton.setBounds(650, 350, 365, 85);
        editInventoryButton.setBackground(Color.white);
        editInventoryButton.setFont(new Font ("Arial", 1, 32));
        editInventoryButton.setBorderThickness(2);
        editInventoryButton.setForeground(Color.decode("#551F01"));
        editInventoryButton.setFocusable(false);
        editInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                editInventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
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
        deleteInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                deleteInventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(deleteInventoryButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void addInventoryPage(JFrame frame){

        //side panel
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

        //add this if naa nay image
//        ImageIcon icon = new ImageIcon("path/to/your/image.png"); // Replace with the path to your image
//        addOrderLabel.setIcon(icon);
//        addOrderLabel.setHorizontalTextPosition(SwingConstants.RIGHT); // Text on the right, image on the left

        addInventoryLabel.setHorizontalAlignment(SwingConstants.RIGHT); //align text to the right
        frame.add(addInventoryLabel);

        JLabel mealNameLabel = new JLabel();
        mealNameLabel.setText("Meal Name");
        mealNameLabel.setBounds(370, 240, 300, 45);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(mealNameLabel);

        // order ID text field
        RoundedTextfield mealNameTf = new RoundedTextfield();
        mealNameTf.setBounds(370, 280, 300, 45);
        mealNameTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        JLabel quantityLabel = new JLabel();
        quantityLabel.setText("Quantity");
        quantityLabel.setBounds(700, 240, 300, 45);
        quantityLabel.setForeground(Color.decode("#331402"));
        quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(quantityLabel);

        RoundedTextfield quantityTf = new RoundedTextfield();
        quantityTf.setBounds(700, 280, 300, 45);
        quantityTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
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
        priceTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        priceTf.setBackground(Color.white);
        frame.add(priceTf);

        JButton confirmInventoryButton = new JButton();
        confirmInventoryButton.setText("CONFIRM");
        confirmInventoryButton.setBounds(850, 500, 160, 40);
        confirmInventoryButton.setBackground(Color.decode("#551F01"));
        confirmInventoryButton.setFont(new Font("Arial", 1, 18));
        confirmInventoryButton.setForeground(Color.white);
        confirmInventoryButton.setFocusable(false);
        confirmInventoryButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
        confirmInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mealName = mealNameTf.getText();
                int quantity = Integer.parseInt(quantityTf.getText());
                int price = Integer.parseInt(priceTf.getText());

                inventoryDatabase.addInventory(/* mealId, */ mealName, quantity, price); // Pass appropriate mealId if available
                mealNameTf.setText("");
                quantityTf.setText("");
                priceTf.setText("");
            }
        });
        frame.add(confirmInventoryButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void editInventoryPage(JFrame frame){

        new InventorySidePanel(frame);
    }

    public static void deleteInventoryPage(JFrame frame){

        new InventorySidePanel(frame);

        // delete inventory button
        JLabel deleteInventoryLabel = new JLabel("DELETE INVENTORY");
        deleteInventoryLabel.setBounds(500, 50, 430, 80);
        deleteInventoryLabel.setOpaque(true);
        deleteInventoryLabel.setBackground(Color.decode("#752A00"));
        deleteInventoryLabel.setForeground(Color.decode("#FACD97"));
        deleteInventoryLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 40));
        deleteInventoryLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        //add this if naa nay image
//        ImageIcon icon = new ImageIcon("path/to/your/image.png"); // Replace with the path to your image
//        addOrderLabel.setIcon(icon);
//        addOrderLabel.setHorizontalTextPosition(SwingConstants.RIGHT); // Text on the right, image on the left

        deleteInventoryLabel.setHorizontalAlignment(SwingConstants.RIGHT); //align text to the right
        frame.add(deleteInventoryLabel);

        // order ID label
        JLabel mealNameLabel = new JLabel();
        mealNameLabel.setText("Enter the meal name of the inventory item you would like to delete:  ");
        mealNameLabel.setBounds(400, 190, 800, 45);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(mealNameLabel);

        // order ID text field
        JTextField mealNameTf = new JTextField("");
        mealNameTf.setBounds(460, 230, 500, 45);
        mealNameTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        // delete order button
        JButton deleteInventoryButton = new JButton();
        deleteInventoryButton.setText("CONFIRM");
        deleteInventoryButton.setBounds(580, 370, 250, 40);
        deleteInventoryButton.setBackground(Color.decode("#551F01"));
        deleteInventoryButton.setFont(new Font("Arial", Font.BOLD, 18));
        deleteInventoryButton.setForeground(Color.white);
        deleteInventoryButton.setFocusable(false);
        deleteInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mealName = mealNameTf.getText();

                if (inventoryDatabase.deleteInventory(mealName)) {
                    JOptionPane.showMessageDialog(frame, "Meal deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Meal name not found.");
                }

                mealNameTf.setText("");
            }
        });
        frame.add(deleteInventoryButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}

