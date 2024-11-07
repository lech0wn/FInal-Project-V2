package org.example;

import org.example.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddOrdersPage {

    //labels
    JLabel mealNameLabel = new JLabel();
    JLabel quantityLabel = new JLabel();
    JLabel priceLabel = new JLabel();
    JLabel dateLabel = new JLabel();
    JLabel ordersLabel = new JLabel();
    JLabel addOrderLabel = new JLabel();

    //text fields
    JTextField mealNameTf = new JTextField("");
    JTextField quantityTf = new JTextField("");
    JTextField priceTf = new JTextField("");
    JTextField dateTf = new JTextField("");

    //button
    JButton backToMenuButton = new JButton();
    JButton confirmOrderButton = new JButton();

    AddOrdersPage(JFrame frame){

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
}
