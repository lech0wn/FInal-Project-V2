package org.example;

import org.example.Database;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrdersPage {

    // labels
    JLabel ordersLabel = new JLabel();
    JLabel mealNameLabel = new JLabel();
    JLabel quantityLabel = new JLabel();
    JLabel priceLabel = new JLabel();
    JLabel dateLabel = new JLabel();
    JLabel addOrderLabel = new JLabel();
    JLabel orderIdLabel = new JLabel();

    // buttons
    JButton backToMenuButton = new JButton();
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

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        // orders label
        ordersLabel.setText("Orders");
        ordersLabel.setForeground(Color.decode("#545454"));
        ordersLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 36));
        ordersLabel.setBounds(50, 30, 500, 50);
        frame.add(ordersLabel);

        // back to menu button
        backToMenuButton.setBounds(900, 20, 150, 40);
        backToMenuButton.setBackground(Color.decode("#8c9e42"));
        backToMenuButton.setText("Back to Menu");
        backToMenuButton.setFont(new Font("Arial", Font.BOLD, 16));
        backToMenuButton.setForeground(Color.white);
        backToMenuButton.setFocusable(false);
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuPage(frame);
            }
        });
        frame.add(backToMenuButton);

        // retrieve orders data and create table
        String[] columnNames = {"Order ID", "Date", "Subtotal Price", "Meal ID", "Meal Name", "Quantity"};
        List<String[]> orders = ordersDatabase.listOrders();
        String[][] data = orders.toArray(new String[0][]);

        JTable ordersTable = new JTable(data, columnNames);

        // Add table to scroll pane and set bounds
        JScrollPane scrollPane = new JScrollPane(ordersTable);
        scrollPane.setBounds(50, 100, 800, 400); // Adjust as needed
        frame.add(scrollPane);

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

            //back to menu page
            backToMenuButton.setBounds(900, 20, 150, 40);
            backToMenuButton.setBackground(Color.decode("#8c9e42"));
            backToMenuButton.setText("Back to Menu");
            backToMenuButton.setFont(new Font("Arial", Font.BOLD, 16));
            backToMenuButton.setForeground(Color.white);
            backToMenuButton.setFocusable(false);
            backToMenuButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MenuPage(frame);
                }
            });
            frame.add(backToMenuButton);

            //orders label
            ordersLabel.setText("Orders");
            ordersLabel.setForeground(Color.decode("#545454"));
            ordersLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 36));
            ordersLabel.setBounds(50, 30, 500, 50);
            frame.add(ordersLabel);

            //add order label
            addOrderLabel.setText("Add an Order");
            addOrderLabel.setForeground(Color.decode("#d87436"));
            addOrderLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 28));
            addOrderLabel.setBounds(50, 90, 500, 50);
            frame.add(addOrderLabel);

            //meal name label
            mealNameLabel.setText("Meal Name");
            mealNameLabel.setBounds(50, 170, 250, 30);
            mealNameLabel.setForeground(Color.decode("#d87436"));
            mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
            frame.add(mealNameLabel);

            //meal name text field
            mealNameTf.setBounds(50, 200, 250, 40);
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
            confirmOrderButton.setBounds(450, 370, 250, 40);
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

            // back to menu button
            backToMenuButton.setBounds(900, 20, 150, 40);
            backToMenuButton.setBackground(Color.decode("#8c9e42"));
            backToMenuButton.setText("Back to Menu");
            backToMenuButton.setFont(new Font("Arial", Font.BOLD, 16));
            backToMenuButton.setForeground(Color.white);
            backToMenuButton.setFocusable(false);
            backToMenuButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MenuPage(frame);
                }
            });
            frame.add(backToMenuButton);

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


