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

    // buttons
    JButton backToMenuButton = new JButton();
    JButton addOrdersButton = new JButton();
    JButton deleteOrdersButton = new JButton();

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
                new AddOrdersPage(frame);
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
                new DeleteOrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(deleteOrdersButton);

        // Refresh frame components
        frame.revalidate();
        frame.repaint();
    }
}
