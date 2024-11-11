package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MenuPage {

    RoundedButton breakfastButton = new RoundedButton("BREAKFAST");
    RoundedButton lunchButton = new RoundedButton("LUNCH");
    RoundedButton dinnerButton = new RoundedButton("DINNER");

    MenuPage(JFrame frame) {

        frame.setTitle("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed
        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

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
        RoundedButton menuButton = new RoundedButton("Menu");
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
        RoundedButton inventoryButton = new RoundedButton("Inventory");
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
        RoundedButton ordersButton = new RoundedButton("Orders");
        ordersButton.setBounds(30, 450, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", 0, 32));
        ordersButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        ordersButton.setFocusable(true);
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

        //Add Meal Editor Button
        RoundedButton mealEditorButton = new RoundedButton("+");
        mealEditorButton.setBounds(140, 520, 50, 50);
        mealEditorButton.setBackground(Color.decode("#331402"));
        mealEditorButton.setBorder(new RoundedBorder(50, Color.decode("#752A00")));
        mealEditorButton.setForeground(Color.decode("#FACD97"));
        mealEditorButton.setFocusable(false);
        mealEditorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MealEditorPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(mealEditorButton);

        //Add Image
        ImageIcon img = new ImageIcon("src/main/java/org/example/img/menu.png");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(200,50, 500, 500);
        frame.add(imgLabel);

        //Add The Menu Label
        JLabel theLabel = new JLabel("The");
        theLabel.setBounds(550, 50, 500, 100);
        theLabel.setFont(new Font("Times New Roman", 1, 130));
        theLabel.setForeground(Color.decode("#FACD97"));
        frame.add(theLabel);
        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setBounds(700, 170, 500, 100);
        menuLabel.setFont(new Font("Times New Roman", 1, 130));
        menuLabel.setForeground(Color.decode("#FACD97"));
        frame.add(menuLabel);

        //Create Breakfast Button
        breakfastButton.setForeground(Color.decode("#EF9B39"));
        breakfastButton.setFont(new Font("Tahoma", 1, 24));
        breakfastButton.setBounds(550, 350, 230, 70);
        breakfastButton.setBackground(Color.decode("#752A00"));
        breakfastButton.setFocusable(false);
        breakfastButton.setBorder(new RoundedBorder(30, Color.decode("#331402")));
        breakfastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                breakfastPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(breakfastButton);

        //Create Lunch Button
        lunchButton.setForeground(Color.decode("#EF9B39"));
        lunchButton.setFont(new Font("Tahoma", 1, 24));
        lunchButton.setBounds(820, 350, 230, 70);
        lunchButton.setBackground(Color.decode("#752A00"));
        lunchButton.setFocusable(false);
        lunchButton.setBorder(new RoundedBorder(30, Color.decode("#331402")));
        frame.add(lunchButton);

        //Create Dinner Button
        dinnerButton.setForeground(Color.decode("#EF9B39"));
        dinnerButton.setFont(new Font("Arial", 1, 24));
        dinnerButton.setBounds(700, 450, 230, 70);
        dinnerButton.setBackground(Color.decode("#752A00"));
        dinnerButton.setFocusable(false);
        dinnerButton.setBorder(new RoundedBorder(30, Color.decode("#331402")));
        frame.add(dinnerButton);

        frame.setLayout(null);
        frame.setSize(1100, 630);
        frame.setVisible(true);
    }

    public void breakfastPage(JFrame frame) {

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
        sidePanel.add(inventoryButton);

        //Add Orders Button
        JButton ordersButton = new JButton("Orders");
        ordersButton.setBounds(30, 450, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", 0, 32));
        ordersButton.setFocusable(false);
        ordersButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        sidePanel.add(ordersButton);

        //Add Meal Editor Button
        JButton mealEditorButton = new JButton("+");
        mealEditorButton.setBounds(140, 520, 50, 50);
        mealEditorButton.setBackground(Color.decode("#331402"));
        mealEditorButton.setBorder(new RoundedBorder(50, Color.decode("#752A00")));
        mealEditorButton.setForeground(Color.decode("#FACD97"));
        mealEditorButton.setFocusable(false);
        mealEditorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MealEditorPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(mealEditorButton);


        //FRAME
        JTextField searchbar = new JTextField();
        searchbar.setBounds(370, 20, 550, 45);
        searchbar.setBackground(Color.decode("#FACD97"));
        searchbar.setBorder(new RoundedBorder(20, Color.decode("#331402")));
        frame.add(searchbar);

        RoundedButton breakfastButton = new RoundedButton("BREAKFAST");
        breakfastButton.setBounds(370, 90, 200, 45);
        breakfastButton.setBackground(Color.decode("#752A00"));
        breakfastButton.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        breakfastButton.setForeground(Color.decode("#EF9B39"));
        breakfastButton.setFont(new Font("Arial", 1, 20));
        frame.add(breakfastButton);

        RoundedButton lunchButton = new RoundedButton("LUNCH");
        lunchButton.setBounds(600, 90, 200, 45);
        lunchButton.setBackground(Color.decode("#752A00"));
        lunchButton.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        lunchButton.setForeground(Color.decode("#EF9B39"));
        lunchButton.setFont(new Font("Arial", 1, 20));
        frame.add(lunchButton);

        RoundedButton dinnerButton = new RoundedButton("DINNER");
        dinnerButton.setBounds(830, 90, 200, 45);
        dinnerButton.setBackground(Color.decode("#752A00"));
        dinnerButton.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        dinnerButton.setForeground(Color.decode("#EF9B39"));
        dinnerButton.setFont(new Font("Arial", 1, 20));
        frame.add(dinnerButton);

        // Create a panel to hold meal panels
        JPanel mealPanelContainer = new JPanel();
        mealPanelContainer.setBounds(370, 170, 670, 400);
        frame.add(mealPanelContainer);

        List<String[]> meals = mealsDatabase.getMeals();

        for (String[] meal : meals) {
            JPanel mealPanel = new JPanel();
            mealPanel.setPreferredSize(new Dimension(670, 150));
            mealPanel.setBackground(Color.decode("#FACD97"));
            mealPanel.setBorder(new RoundedBorder(40, Color.decode("#A8671C")));
            mealPanel.setBackground(Color.white);
            mealPanel.setLayout(null);

            JLabel nameLabel = new JLabel(meal[0]);
            nameLabel.setBounds(150, 20, 100, 50);
            nameLabel.setForeground(Color.decode("#551F01"));
            nameLabel.setFont(new Font("Arial", 0, 20));
            JLabel descriptionLabel = new JLabel(meal[1]);
            descriptionLabel.setBounds(150, 40, 100, 50);
            descriptionLabel.setForeground(Color.decode("#551F01"));
            descriptionLabel.setFont(new Font("Arial", 0, 20));
            JLabel categoryLabel = new JLabel(meal[2]);
            categoryLabel.setBounds(150, 60, 100, 50);
            categoryLabel.setForeground(Color.decode("#551F01"));
            categoryLabel.setFont(new Font("Arial", 0, 20));
            JLabel dietLabel = new JLabel(meal[3]);
            dietLabel.setBounds(300, 20, 100, 50);
            dietLabel.setForeground(Color.decode("#551F01"));
            dietLabel.setFont(new Font("Arial", 0, 20));
            JLabel spiceLabel = new JLabel(meal[4]);
            spiceLabel.setBounds(300, 40, 100, 50);
            spiceLabel.setForeground(Color.decode("#551F01"));
            spiceLabel.setFont(new Font("Arial", 0, 20));
            JLabel caloriesLabel = new JLabel(meal[5]);
            caloriesLabel.setBounds(300, 60, 100, 50);
            caloriesLabel.setForeground(Color.decode("#551F01"));
            caloriesLabel.setFont(new Font("Arial", 0, 20));

            mealPanel.add(nameLabel);
            mealPanel.add(descriptionLabel);
            mealPanel.add(categoryLabel);
            mealPanel.add(dietLabel);
            mealPanel.add(spiceLabel);
            mealPanel.add(caloriesLabel);
            mealPanelContainer.add(mealPanel);
        }


    }
}