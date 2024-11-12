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

        //side panel call
        new SidePanel(frame);

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
        RoundedButton menuButton = new RoundedButton("Menu");
        menuButton.setLayout(null);
        ImageIcon menuLogo = new ImageIcon("src/main/java/org/example/img/Restaurant Menu.png");
        JLabel menuLogoLabel = new JLabel(menuLogo);
        menuLogoLabel.setBounds(62,6,30,30);
        menuButton.add(menuLogoLabel);
        menuButton.setBounds(30, 330, 275, 45);
        menuButton.setBackground(Color.decode("#EF9B39"));
        menuButton.setFont(new Font("Arial", Font.PLAIN, 32));
        menuButton.setFocusable(false);
        menuButton.setForeground(Color.BLACK);
        menuButton.setBorderThickness(0);
        menuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                menuButton.setBackground(Color.decode("#FACD97"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                menuButton.setBackground(Color.decode("#EF9B39"));
            }
        });
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
        inventoryButton.setLayout(null);
        ImageIcon inventoryLogo = new ImageIcon("src/main/java/org/example/img/Inventory.png");
        JLabel inventoryLogoLabel = new JLabel(inventoryLogo);
        inventoryLogoLabel.setBounds(45,6,30,30);
        inventoryButton.add(inventoryLogoLabel);
        inventoryButton.setBounds(30, 390, 275, 45);
        inventoryButton.setBackground(Color.decode("#EF9B39"));
        inventoryButton.setFont(new Font("Arial", 0, 32));
        inventoryButton.setForeground(Color.BLACK);
        inventoryButton.setFocusable(false);
        inventoryButton.setForeground(Color.BLACK);
        inventoryButton.setBorderThickness(0);
        inventoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                inventoryButton.setBackground(Color.decode("#FACD97"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                inventoryButton.setBackground(Color.decode("#EF9B39"));
            }
        });
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
        ordersButton.setLayout(null);
        ImageIcon ordersLogo = new ImageIcon("src/main/java/org/example/img/Orders.png");
        JLabel ordersLogoLabel = new JLabel(ordersLogo);
        ordersLogoLabel.setBounds(56,7,30,30);
        ordersButton.add(ordersLogoLabel);
        ordersButton.setBounds(30, 450, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", 0, 32));
        ordersButton.setForeground(Color.BLACK);
        ordersButton.setFocusable(false);
        ordersButton.setForeground(Color.BLACK);
        ordersButton.setBorderThickness(0);
        ordersButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ordersButton.setBackground(Color.decode("#FACD97"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ordersButton.setBackground(Color.decode("#EF9B39"));
            }
        });
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
        RoundedButton mealEditorButton = new RoundedButton("");
        mealEditorButton.setBounds(140, 520, 60, 60);
        mealEditorButton.setBackground(Color.decode("#331402"));
        mealEditorButton.setForeground(Color.decode("#FACD97"));
        mealEditorButton.setFocusable(false);
        mealEditorButton.setRound(50);
        mealEditorButton.setBorderThickness(0);
        mealEditorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mealEditorButton.setBackground(Color.decode("#9C9C9C"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mealEditorButton.setBackground(Color.decode("#331402"));
            }
        });
        mealEditorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MealEditorPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });

        //Add eDitor button img
        ImageIcon mealLogo = new ImageIcon("src/main/java/org/example/img/meal icon.png");
        JLabel mealLabel = new JLabel(mealLogo);
        mealLabel.setBounds(0,0,80,80);
        mealEditorButton.add(mealLabel);

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
        mealPanelContainer.setBackground(Color.decode("#EF9B39"));
        frame.add(mealPanelContainer);

        List<String[]> meals = mealsDatabase.getMeals();

        for (String[] meal : meals) {
            JPanel mealPanel = new JPanel();
            mealPanel.setPreferredSize(new Dimension(670, 150));
            mealPanel.setBackground(Color.decode("#FACD97"));
            mealPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#A8671C"), 2));
            mealPanel.setLayout(null);

            JLabel nameLabel = new JLabel(meal[0]);
            nameLabel.setBounds(150, 20, 100, 50);
            nameLabel.setForeground(Color.decode("#551F01"));
            nameLabel.setFont(new Font("Arial", 0, 20));

            JLabel id = new JLabel(meal[1]);
            id.setBounds(150, 40, 100, 50);
            id.setForeground(Color.decode("#551F01"));
            id.setFont(new Font("Arial", 0, 20));

            JLabel descriptionLabel = new JLabel(meal[2]);
            descriptionLabel.setBounds(150, 40, 100, 50);
            descriptionLabel.setForeground(Color.decode("#551F01"));
            descriptionLabel.setFont(new Font("Arial", 0, 20));

            JLabel categoryLabel = new JLabel(meal[3]);
            categoryLabel.setBounds(150, 60, 100, 50);
            categoryLabel.setForeground(Color.decode("#551F01"));
            categoryLabel.setFont(new Font("Arial", 0, 20));

            JLabel ingredients = new JLabel(meal[4]);

            JLabel dietLabel = new JLabel(meal[5]);
            dietLabel.setBounds(300, 20, 100, 50);
            dietLabel.setForeground(Color.decode("#551F01"));
            dietLabel.setFont(new Font("Arial", 0, 20));

            JLabel spiceLabel = new JLabel(meal[6]);
            spiceLabel.setBounds(300, 40, 100, 50);
            spiceLabel.setForeground(Color.decode("#551F01"));
            spiceLabel.setFont(new Font("Arial", 0, 20));

            JLabel servSize = new JLabel(meal[7]);
            servSize.setBounds(300, 60, 100, 50);
            servSize.setForeground(Color.decode("#551F01"));
            servSize.setFont(new Font("Arial", 0, 20));

            JLabel nutValue = new JLabel(meal[8]);
            nutValue.setBounds(300, 60, 100, 50);
            nutValue.setForeground(Color.decode("#551F01"));
            nutValue.setFont(new Font("Arial", 0, 20));

            mealPanel.add(nameLabel);
            mealPanel.add(id);
            mealPanel.add(descriptionLabel);
            mealPanel.add(categoryLabel);
            mealPanel.add(ingredients);
            mealPanel.add(dietLabel);
            mealPanel.add(spiceLabel);
            mealPanel.add(servSize);
            mealPanel.add(nutValue);
            mealPanelContainer.add(mealPanel);
        }
    }
}