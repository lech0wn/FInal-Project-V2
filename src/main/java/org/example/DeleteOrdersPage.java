package org.example;

import org.example.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteOrdersPage {

    // labels
    JLabel orderIdLabel = new JLabel();

    // text fields
    JTextField orderIdTf = new JTextField("");

    // button
    JButton backToMenuButton = new JButton();
    JButton deleteOrderButton = new JButton();

    DeleteOrdersPage(JFrame frame) {

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
