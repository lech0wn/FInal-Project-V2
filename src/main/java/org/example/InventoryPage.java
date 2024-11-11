package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class InventoryPage {
    InventoryPage(JFrame frame){

        frame.setTitle("Inventory");  //set the title of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        //Add Side Panel
        JPanel sidePanel = new JPanel();
        sidePanel.setBounds(0,  0, 320, 600);
        sidePanel.setBackground(Color.decode("#752A00"));
        sidePanel.setLayout(null);
        frame.add(sidePanel);

        //Add Side Panel Java junction logo
        ImageIcon logo = new ImageIcon("src/main/java/org/example/img/SidePanelLogo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(10,0,300,300);
        sidePanel.add(logoLabel);

        //Add Side Panel Welcome Label
        JLabel welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setBounds(60, 230, 300, 100);
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setFont(new Font("Arial", 1, 40));
        sidePanel.add(welcomeLabel);

        //Add Menu Button
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(30, 330, 275, 45);
        menuButton.setBackground(Color.decode("#EF9B39"));
        menuButton.setFont(new Font("Arial", Font.PLAIN, 32));
        menuButton.setFocusable(false);
        menuButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MenuPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });

        sidePanel.add(menuButton);

        //Add Inventory Button
        JButton inventoryButton = new JButton("Inventory");
        inventoryButton.setBounds(30, 390, 275, 45);
        inventoryButton.setBackground(Color.decode("#EF9B39"));
        inventoryButton.setFont(new Font("Arial", 0, 32));
        inventoryButton.setFocusable(false);
        inventoryButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new InventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(inventoryButton);

        //Add Orders Button
        JButton ordersButton = new JButton("Orders");
        ordersButton.setBounds(30, 450, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", 0, 32));
        ordersButton.setFocusable(false);
        ordersButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new OrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(ordersButton);

        JTextField searchbar = new JTextField();
        searchbar.setBounds(370, 20, 550, 45);
        searchbar.setBackground(Color.decode("#FACD97"));
        searchbar.setBorder(new RoundedBorder(20, Color.decode("#331402")));
        frame.add(searchbar);

        //TO-D0: add shit for listing inventory

        JButton addInventoryButton = new JButton();
        addInventoryButton.setBounds(950, 20, 50, 50);
        addInventoryButton.setBackground(Color.decode("#752A00"));
        addInventoryButton.setText("+");
        addInventoryButton.setFont(new Font("Arial", Font.BOLD, 18));
        addInventoryButton.setForeground(Color.white);
        addInventoryButton.setFocusable(false);
        addInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                AddInventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(addInventoryButton);

        // Refresh frame components
        frame.revalidate();
        frame.repaint();

        //delete order button
        JButton deleteInventoryButton = new JButton();
        deleteInventoryButton.setBounds(1020, 20, 50, 50);
        deleteInventoryButton.setBackground(Color.decode("#752A00"));
        deleteInventoryButton.setText("-");
        deleteInventoryButton.setFont(new Font("Arial", Font.BOLD, 18));
        deleteInventoryButton.setForeground(Color.white);
        deleteInventoryButton.setFocusable(false);
        deleteInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                DeleteInventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(deleteInventoryButton);

        // Refresh frame components
        frame.revalidate();
        frame.repaint();
    }

    public void AddInventoryPage(JFrame frame){

        //Add Side Panel
        JPanel sidePanel = new JPanel();
        sidePanel.setBounds(0,  0, 320, 600);
        sidePanel.setBackground(Color.decode("#752A00"));
        sidePanel.setLayout(null);
        frame.add(sidePanel);

        //Add Side Panel Java junction logo
        ImageIcon logo = new ImageIcon("src/main/java/org/example/img/SidePanelLogo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(10,0,300,300);
        sidePanel.add(logoLabel);

        //Add Side Panel Welcome Label
        JLabel welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setBounds(60, 230, 300, 100);
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setFont(new Font("Arial", 1, 40));
        sidePanel.add(welcomeLabel);

        //Add Menu Button
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(30, 330, 275, 45);
        menuButton.setBackground(Color.decode("#EF9B39"));
        menuButton.setFont(new Font("Arial", Font.PLAIN, 32));
        menuButton.setFocusable(false);
        menuButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MenuPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });

        sidePanel.add(menuButton);

        //Add Inventory Button
        JButton inventoryButton = new JButton("Inventory");
        inventoryButton.setBounds(30, 390, 275, 45);
        inventoryButton.setBackground(Color.decode("#EF9B39"));
        inventoryButton.setFont(new Font("Arial", 0, 32));
        inventoryButton.setFocusable(false);
        inventoryButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new InventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(inventoryButton);

        //Add Orders Button
        JButton ordersButton = new JButton("Orders");
        ordersButton.setBounds(30, 450, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", 0, 32));
        ordersButton.setFocusable(false);
        ordersButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new OrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(ordersButton);

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
        mealNameLabel.setBounds(370, 280, 300, 45);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(mealNameLabel);

        // order ID text field
        JTextField mealNameTf = new JTextField("");
        mealNameTf.setBounds(370, 320, 300, 45);
        mealNameTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        JLabel quantityLabel = new JLabel();
        quantityLabel.setText("Quantity");
        quantityLabel.setBounds(700, 280, 300, 45);
        quantityLabel.setForeground(Color.decode("#331402"));
        quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(quantityLabel);

        JTextField quantityTf = new JTextField();
        quantityTf.setBounds(700, 320, 300, 45);
        quantityTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        quantityTf.setBackground(Color.white);
        frame.add(quantityTf);

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

                inventoryDatabase.addInventory(/* mealId, */ mealName, quantity); // Pass appropriate mealId if available
                mealNameTf.setText("");
                quantityTf.setText("");
            }
        });
        frame.add(confirmInventoryButton);

        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void DeleteInventoryPage(JFrame frame){

        //Add Side Panel
        JPanel sidePanel = new JPanel();
        sidePanel.setBounds(0,  0, 320, 600);
        sidePanel.setBackground(Color.decode("#752A00"));
        sidePanel.setLayout(null);
        frame.add(sidePanel);

        //Add Side Panel Java junction logo
        ImageIcon logo = new ImageIcon("src/main/java/org/example/img/SidePanelLogo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(10,0,300,300);
        sidePanel.add(logoLabel);

        //Add Side Panel Welcome Label
        JLabel welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setBounds(60, 230, 300, 100);
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setFont(new Font("Arial", 1, 40));
        sidePanel.add(welcomeLabel);

        //Add Menu Button
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(30, 330, 275, 45);
        menuButton.setBackground(Color.decode("#EF9B39"));
        menuButton.setFont(new Font("Arial", Font.PLAIN, 32));
        menuButton.setFocusable(false);
        menuButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MenuPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });

        sidePanel.add(menuButton);

        //Add Inventory Button
        JButton inventoryButton = new JButton("Inventory");
        inventoryButton.setBounds(30, 390, 275, 45);
        inventoryButton.setBackground(Color.decode("#EF9B39"));
        inventoryButton.setFont(new Font("Arial", 0, 32));
        inventoryButton.setFocusable(false);
        inventoryButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new InventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(inventoryButton);

        //Add Orders Button
        JButton ordersButton = new JButton("Orders");
        ordersButton.setBounds(30, 450, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", 0, 32));
        ordersButton.setFocusable(false);
        ordersButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new OrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(ordersButton);

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

                if (ordersDatabase.deleteOrder(Integer.parseInt(mealName))) {
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


