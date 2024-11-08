package org.example;

import org.example.ordersDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrdersPage {

    // labels
    JLabel mealNameLabel = new JLabel();
    JLabel quantityLabel = new JLabel();
    JLabel priceLabel = new JLabel();
    JLabel dateLabel = new JLabel();
    JLabel addOrderLabel = new JLabel();
    JLabel orderIdLabel = new JLabel();

    // buttons
    JButton addOrdersButton = new JButton();
    JButton deleteOrdersButton = new JButton();
    JButton confirmOrderButton = new JButton();
    JButton deleteOrderButton = new JButton();

    //text fields
    JTextField mealNameTf = new JTextField("");
    JTextField quantityTf = new JTextField("");
    JTextField priceTf = new JTextField("");
    JTextField dateTf = new JTextField("");
    JTextField orderIdTf = new JTextField("");

    OrdersPage(JFrame frame) {

        frame.setTitle("Orders");  //set the title of the window
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

        JLabel dateOrdersLabel = new JLabel("Date");
        dateOrdersLabel.setBounds(370, 90, 80, 40);
        dateOrdersLabel.setOpaque(true);
        dateOrdersLabel.setBackground(Color.decode("#752A00"));
        dateOrdersLabel.setForeground(Color.decode("#EF9B39"));
        dateOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        dateOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));

        frame.add(dateOrdersLabel);

        JLabel orderIdOrdersLabel = new JLabel("Order ID");
        orderIdOrdersLabel.setBounds(470, 90, 110, 40);
        orderIdOrdersLabel.setOpaque(true);
        orderIdOrdersLabel.setBackground(Color.decode("#752A00"));
        orderIdOrdersLabel.setForeground(Color.decode("#EF9B39"));
        orderIdOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        orderIdOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));

        frame.add(orderIdOrdersLabel);

        JLabel mealOrdersLabel = new JLabel("Meal");
        mealOrdersLabel.setBounds(600, 90, 80, 40);
        mealOrdersLabel.setOpaque(true);
        mealOrdersLabel.setBackground(Color.decode("#752A00"));
        mealOrdersLabel.setForeground(Color.decode("#EF9B39"));
        mealOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        mealOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));

        frame.add(mealOrdersLabel);

        JLabel quantityOrdersLabel = new JLabel("Quantity");
        quantityOrdersLabel.setBounds(700, 90, 110, 40);
        quantityOrdersLabel.setOpaque(true);
        quantityOrdersLabel.setBackground(Color.decode("#752A00"));
        quantityOrdersLabel.setForeground(Color.decode("#EF9B39"));
        quantityOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        quantityOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));

        frame.add(quantityOrdersLabel);

        JLabel priceOrdersLabel = new JLabel("Total Price");
        priceOrdersLabel.setBounds(850, 90, 130, 40);
        priceOrdersLabel.setOpaque(true);
        priceOrdersLabel.setBackground(Color.decode("#752A00"));
        priceOrdersLabel.setForeground(Color.decode("#EF9B39"));
        priceOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        priceOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));

        frame.add(priceOrdersLabel);


        //add orders button
        addOrdersButton.setBounds(900, 120, 150, 40);
        addOrdersButton.setBackground(Color.decode("#8c9e42"));
        addOrdersButton.setText("Add Order");
        addOrdersButton.setFont(new Font("Arial", Font.BOLD, 18));
        addOrdersButton.setForeground(Color.white);
        addOrdersButton.setFocusable(false);
        addOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                addOrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(addOrdersButton);

        // Refresh frame components
        frame.revalidate();
        frame.repaint();

        //delete order button
        deleteOrdersButton.setBounds(900, 240, 150, 40);
        deleteOrdersButton.setBackground(Color.decode("#8c9e42"));
        deleteOrdersButton.setText("Delete Order");
        deleteOrdersButton.setFont(new Font("Arial", Font.BOLD, 18));
        deleteOrdersButton.setForeground(Color.white);
        deleteOrdersButton.setFocusable(false);
        deleteOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                deleteOrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(deleteOrdersButton);

        // Refresh frame components
        frame.revalidate();
        frame.repaint();
    }

    public void addOrdersPage(JFrame frame){

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

            //add order label
            addOrderLabel.setText("ADD ORDER");
            addOrderLabel.setForeground(Color.decode("#d87436"));
            addOrderLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 28));
            addOrderLabel.setBounds(50, 90, 500, 50);
            frame.add(addOrderLabel);

            //meal name label
            mealNameLabel.setText("Meal Name");
            mealNameLabel.setBounds(370, 100, 400, 45);
            mealNameLabel.setForeground(Color.decode("#331402"));
            mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
            frame.add(mealNameLabel);

            //meal name text field
            mealNameTf.setBounds(370, 140, 400, 45);
            mealNameTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            mealNameTf.setBackground(Color.white);
            frame.add(mealNameTf);

            //quantity label
            quantityLabel.setText("Quantity");
            quantityLabel.setBounds(50, 270, 250, 30);
            quantityLabel.setForeground(Color.decode("#d87436"));
            quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
            frame.add(quantityLabel);

            //quantity text field
            quantityTf.setBounds(50, 300, 250, 40);
            quantityTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            quantityTf.setBackground(Color.white);
            frame.add(quantityTf);

            //price label
            priceLabel.setText("Subtotal Price");
            priceLabel.setForeground(Color.decode("#d87436"));
            priceLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
            priceLabel.setBounds(50, 370, 250, 30);
            frame.add(priceLabel);

            //price text field
            priceTf.setBounds(50, 400, 250, 40);
            priceTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            priceTf.setBackground(Color.white);
            frame.add(priceTf);

            //date label
            dateLabel.setText("Date");
            dateLabel.setForeground(Color.decode("#d87436"));
            dateLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
            dateLabel.setBounds(50, 470, 250, 30);
            frame.add(dateLabel);

            //date text field
            dateTf.setBounds(50, 500, 250, 40);
            dateTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            dateTf.setBackground(Color.white);
            frame.add(dateTf);

            //confirm order button
            confirmOrderButton.setText("Confirm Order");
            confirmOrderButton.setBounds(930, 450, 108, 40);
            confirmOrderButton.setBackground(Color.decode("#d87436"));
            confirmOrderButton.setFont(new Font("Arial", 1, 18));
            confirmOrderButton.setForeground(Color.white);
            confirmOrderButton.setFocusable(false);
            confirmOrderButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
            confirmOrderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = mealNameTf.getText();
                    String quantity = quantityTf.getText();
                    String price = priceTf.getText();
                    String date = dateTf.getText();

                    ordersDatabase.addOrders(name, quantity, price, date);
                    mealNameTf.setText("");
                    quantityTf.setText("");
                    priceTf.setText("");
                    dateTf.setText("");
                }
            });
            frame.add(confirmOrderButton);

            frame.setLayout(null);
            frame.setVisible(true);

        }

        public void deleteOrdersPage(JFrame frame) {

            // delete order label
            deleteOrderButton.setText("Delete an Order");
            deleteOrderButton.setForeground(Color.decode("#d87436"));
            deleteOrderButton.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 28));
            deleteOrderButton.setBounds(50, 90, 500, 50);
            frame.add(deleteOrderButton);

            // order ID label
            orderIdLabel.setText("Order ID");
            orderIdLabel.setBounds(50, 170, 250, 30);
            orderIdLabel.setForeground(Color.decode("#d87436"));
            orderIdLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
            frame.add(orderIdLabel);

            // order ID text field
            orderIdTf.setBounds(50, 200, 250, 40);
            orderIdTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            orderIdTf.setBackground(Color.white);
            frame.add(orderIdTf);

            // delete order button
            deleteOrderButton.setText("Confirm Delete");
            deleteOrderButton.setBounds(450, 370, 250, 40);
            deleteOrderButton.setBackground(Color.decode("#d87436"));
            deleteOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
            deleteOrderButton.setForeground(Color.white);
            deleteOrderButton.setFocusable(false);
            deleteOrderButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
            deleteOrderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String orderId = orderIdTf.getText();

                    if (ordersDatabase.deleteOrder(Integer.parseInt(orderId))) {
                        JOptionPane.showMessageDialog(frame, "Order deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Order ID not found.");
                    }

                    orderIdTf.setText("");
                }
            });
            frame.add(deleteOrderButton);

            frame.setLayout(null);
            frame.setVisible(true);
        }
    }


