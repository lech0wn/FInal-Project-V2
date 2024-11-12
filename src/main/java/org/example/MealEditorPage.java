package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MealEditorPage {

    RoundedButton menuPageButton = new RoundedButton("Menu Page");
    JLabel mealNameLabel = new JLabel();
    RoundedTextfield mealNameTf = new RoundedTextfield();
    RoundedButton breakfastButton = new RoundedButton("breakfast");
    RoundedButton lunchButton = new RoundedButton("lunch");
    RoundedButton dinnerButton = new RoundedButton("dinner");
    RoundedButton vegButton = new RoundedButton("vegetarian");
    RoundedButton nonvegButton = new RoundedButton("non-vegetarian");
    RoundedButton spicyButton = new RoundedButton("spicy");
    RoundedButton nonspicyButton = new RoundedButton("not-spicy");
    RoundedButton addButton = new RoundedButton("Add");
    RoundedButton addMeal = new RoundedButton("ADD MEAL");
    RoundedButton editMeal = new RoundedButton("EDIT MEAL");
    RoundedButton removeMeal = new RoundedButton("REMOVE MEAL");
    JLabel error = new JLabel("Meal not found");
    String category = "breakfast";
    String dietType = "non-vegetarian";
    String spiceType = "not-spicy";

    MealEditorPage(JFrame frame) {

        frame.setTitle("Meal Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed

        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        //side panel
        new SidePanel(frame);

        //Frame
        ImageIcon img = new ImageIcon("src/main/java/org/example/img/meal editor.png");
        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(235, 50, 500, 500);
        frame.add(imageLabel);

        RoundedButton mealEditor = new RoundedButton("MEAL EDITOR");
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


        addMeal.setBounds(650, 250, 365, 85);
        addMeal.setBackground(Color.white);
        addMeal.setFont(new Font ("Arial", 1, 32));
        addMeal.setBorderThickness(2);
        addMeal.setBorderColor(Color.decode("#331402"));
        addMeal.setForeground(Color.decode("#551F01"));
        addMeal.setFocusable(false);
        addMeal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                addMeal(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(addMeal);

        editMeal.setBounds(650, 350, 365, 85);
        editMeal.setBackground(Color.white);
        editMeal.setFont(new Font ("Arial", 1, 32));
        editMeal.setBorderThickness(2);
        editMeal.setForeground(Color.decode("#551F01"));
        editMeal.setFocusable(false);
        editMeal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                editMeal(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(editMeal);

        removeMeal.setBounds(650, 450, 365, 85);
        removeMeal.setBackground(Color.white);
        removeMeal.setFont(new Font ("Arial", 1, 32));
        removeMeal.setBorderThickness(2);
        removeMeal.setBorderColor(Color.decode("#331402"));
        removeMeal.setForeground(Color.decode("#551F01"));
        removeMeal.setFocusable(false);
        removeMeal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                deleteMeal(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(removeMeal);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void addMeal(JFrame frame) {

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

        //Add Meal
        RoundedButton meallLabel = new RoundedButton("ADD MEAL");
        mealLabel.setBounds(550, 25, 300, 70);
        mealLabel.setBackground(Color.decode("#752A00"));
        mealLabel.setFont(new Font("Arial", 1, 35));
        mealLabel.setForeground(Color.decode("#FACD97"));
        mealLabel.setFocusable(false);
        frame.add(mealLabel);

        //Add Meal Name Label
        mealNameLabel.setText("Meal Name");
        mealNameLabel.setBounds(350, 130, 250, 30);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(mealNameLabel);

        //Add Meal Name TextField
        mealNameTf.setBounds(350, 160, 300, 50);
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        //Add Description Label
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds(350, 230, 250, 30);
        descriptionLabel.setForeground(Color.decode("#331402"));
        descriptionLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(descriptionLabel);

        //Add Description TextField
        RoundedTextfield descriptionTf = new RoundedTextfield ();
        descriptionTf.setBounds(350, 260, 300, 50);
        descriptionTf.setBackground(Color.white);
        frame.add(descriptionTf);

        //Add Category Label
        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(350, 330, 250, 30);
        categoryLabel.setForeground(Color.decode("#331402"));
        categoryLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(categoryLabel);

        //Add Category Button
        breakfastButton.setBounds(350, 360, 90, 50);
        breakfastButton.setBackground(Color.white);
        breakfastButton.setForeground(Color.black);
        breakfastButton.setFocusable(false);
        breakfastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakfastButton.setBackground(Color.decode("#551F01"));
                dinnerButton.setBackground(Color.white);
                lunchButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.white);
                lunchButton.setForeground(Color.black);
                dinnerButton.setForeground(Color.black);
                category = "breakfast";
            }
        });
        frame.add(breakfastButton);
        lunchButton.setBounds(450, 360, 90, 50);
        lunchButton.setBackground(Color.white);
        lunchButton.setForeground(Color.black);
        lunchButton.setFocusable(false);
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunchButton.setBackground(Color.decode("#551F01"));
                breakfastButton.setBackground(Color.white);
                dinnerButton.setBackground(Color.white);
                lunchButton.setForeground(Color.white);
                breakfastButton.setForeground(Color.black);
                dinnerButton.setForeground(Color.black);
                category = "lunch";
            }
        });
        frame.add(lunchButton);
        dinnerButton.setBounds(550, 360, 90, 50);
        dinnerButton.setBackground(Color.white);
        dinnerButton.setForeground(Color.black);
        dinnerButton.setFocusable(false);
        dinnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dinnerButton.setBackground(Color.decode("#551F01"));
                breakfastButton.setBackground(Color.white);
                lunchButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.white);
                lunchButton.setForeground(Color.black);
                breakfastButton.setForeground(Color.black);
                category = "dinner";
            }
        });
        frame.add(dinnerButton);

        //Add Ingredients Label
        JLabel ingredientsLabel = new JLabel("Ingredients");
        ingredientsLabel.setBounds(350, 430, 250, 30);
        ingredientsLabel.setForeground(Color.decode("#331402"));
        ingredientsLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(ingredientsLabel);

        //Add Ingredients TextField
        RoundedTextfield ingredientsTf = new RoundedTextfield();
        ingredientsTf.setBounds(350, 460, 300, 50);
        ingredientsTf.setBackground(Color.white);
        frame.add(ingredientsTf);

        //Add Diet Type Label
        JLabel dietTypeLabel = new JLabel("Diet Type");
        dietTypeLabel.setBounds(700, 130, 250, 30);
        dietTypeLabel.setForeground(Color.decode("#331402"));
        dietTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(dietTypeLabel);

        //Add Diet Type buttons
        vegButton.setBounds(700, 160, 145, 50);
        vegButton.setBackground(Color.white);
        vegButton.setForeground(Color.black);
        vegButton.setFocusable(false);
        vegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vegButton.setBackground(Color.decode("#551F01"));
                nonvegButton.setBackground(Color.white);
                vegButton.setForeground(Color.white);
                nonvegButton.setForeground(Color.black);
                dietType = "vegetarian";
            }
        });
        frame.add(vegButton);
        nonvegButton.setBounds(860, 160, 145, 50);
        nonvegButton.setBackground(Color.white);
        nonvegButton.setForeground(Color.black);
        nonvegButton.setFocusable(false);
        nonvegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonvegButton.setBackground(Color.decode("#551F01"));
                vegButton.setBackground(Color.white);
                nonvegButton.setForeground(Color.white);
                vegButton.setForeground(Color.black);
                dietType = "non-vegetarian";
            }
        });
        frame.add(nonvegButton);

        //Add Spice Type Label
        JLabel spiceTypeLabel = new JLabel("Spice Type");
        spiceTypeLabel.setBounds(700, 230, 250, 30);
        spiceTypeLabel.setForeground(Color.decode("#331402"));
        spiceTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(spiceTypeLabel);

        //Add Spic Type Buttons
        spicyButton.setBounds(700, 260, 145, 50);
        spicyButton.setBackground(Color.white);
        spicyButton.setForeground(Color.black);
        spicyButton.setFocusable(false);
        spicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spicyButton.setBackground(Color.decode("#551F01"));
                nonspicyButton.setBackground(Color.white);
                spicyButton.setForeground(Color.white);
                nonspicyButton.setForeground(Color.black);
                spiceType = "spicy";
            }
        });
        frame.add(spicyButton);
        nonspicyButton.setBounds(860, 260, 145,50);
        nonspicyButton.setBackground(Color.white);
        nonspicyButton.setForeground(Color.black);
        nonspicyButton.setFocusable(false);
        nonspicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonspicyButton.setBackground(Color.decode("#551F01"));
                spicyButton.setBackground(Color.white);
                nonspicyButton.setForeground(Color.white);
                spicyButton.setForeground(Color.black);
                spiceType = "not-spicy";
            }
        });
        frame.add(nonspicyButton);

        //Add Serving Size Label
        JLabel servingSizeLabel = new JLabel("Serving Size");
        servingSizeLabel.setBounds(700, 330, 250, 30);
        servingSizeLabel.setForeground(Color.decode("#331402"));
        servingSizeLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(servingSizeLabel);

        //Add Serving Size TextField
        RoundedTextfield servingSizeTf = new RoundedTextfield();
        servingSizeTf.setBounds(700, 360, 300, 50);
        servingSizeTf.setBackground(Color.white);
        frame.add(servingSizeTf);

        //Add Nutritional Value Label
        JLabel nutValueLabel = new JLabel("Nutritional Value ");
        nutValueLabel.setBounds(700, 430, 250, 30);
        nutValueLabel.setForeground(Color.decode("#331402"));
        nutValueLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(nutValueLabel);

        //Add Nutritional Value TextField
        RoundedTextfield nutValueTf = new RoundedTextfield();
        nutValueTf.setBounds(700, 460, 300, 50);
        nutValueTf.setBackground(Color.white);
        frame.add(nutValueTf);

        //Add Add Meal button
        addButton.setText("CONFIRM");
        addButton.setBounds(820, 530, 180, 45);
        addButton.setBackground(Color.decode("#551F01"));
        addButton.setFont(new Font("Arial", 1, 14));
        addButton.setForeground(Color.white);
        addButton.setFocusable(false);
        addButton.setBorder(new RoundedBorder(50, Color.decode("#EF9B39")));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = mealNameTf.getText();
                String description = descriptionTf.getText();
                String categ = category;
                String ingredients = ingredientsTf.getText();
                String diet = dietType;
                String spice = spiceType;
                String servingSize = servingSizeTf.getText();
                String nutritionalValue = nutValueTf.getText();
                mealsDatabase.addMeals(name, description, categ, ingredients, diet, spice, servingSize, nutritionalValue);
                mealNameTf.setText("");
                descriptionTf.setText("");
                ingredientsTf.setText("");
                servingSizeTf.setText("");
                nutValueTf.setText("");
                breakfastButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                breakfastButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.black);
                lunchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                lunchButton.setBackground(Color.white);
                lunchButton.setForeground(Color.black);
                dinnerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                dinnerButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.black);
                vegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                vegButton.setBackground(Color.white);
                vegButton.setForeground(Color.black);
                nonvegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                nonvegButton.setBackground(Color.white);
                nonvegButton.setForeground(Color.black);
                spicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                spicyButton.setBackground(Color.white);
                spicyButton.setForeground(Color.black);
                nonspicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                nonspicyButton.setBackground(Color.white);
                nonspicyButton.setForeground(Color.black);
            }
        });
        frame.add(addButton);
    }

    public void editMeal(JFrame frame) {

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
        JLabel meallLabel = new JLabel(mealLogo);
        meallLabel.setBounds(0,0,80,80);
        mealEditorButton.add(meallLabel);

        sidePanel.add(mealEditorButton);

        //Edit Meal
        RoundedButton mealLabel = new RoundedButton("EDIT MEAL");
        mealLabel.setBounds(550, 25, 300, 70);
        mealLabel.setBackground(Color.decode("#752A00"));
        mealLabel.setFont(new Font("Arial", 1, 35));
        mealLabel.setForeground(Color.decode("#FACD97"));
        mealLabel.setFocusable(false);
        frame.add(mealLabel);

        JLabel label = new JLabel("Enter the name of the meal you would like to edit:");
        label.setBounds(450, 200, 1000, 50);
        label.setForeground(Color.decode("#331402"));
        label.setFont(new Font("Arial", 0, 26));
        frame.add(label);

        RoundedTextfield textField = new RoundedTextfield();
        textField.setBounds(450, 250, 500, 70);
        textField.setBorderColor(Color.decode("#331402"));
        textField.setBorderThickness(4);
        textField.setBackground(Color.WHITE);
        frame.add(textField);

        // Button to confirm meal selection
        RoundedButton button = new RoundedButton("CONFIRM");
        button.setBounds(600, 350, 200, 50);
        button.setForeground(Color.white);
        button.setBackground(Color.decode("#551F01"));
        button.setFont(new Font("Arial", 1, 20));
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String mealName = textField.getText().trim();

                if(mealsDatabase.authenticateMealName(mealName)) {
                    frame.getContentPane().removeAll();
                    frame.repaint();
                    frame.revalidate();

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
                    JLabel meallLabel = new JLabel(mealLogo);
                    meallLabel.setBounds(0,0,80,80);
                    mealEditorButton.add(meallLabel);

                    sidePanel.add(mealEditorButton);
                } else {
                    error.setBounds(500, 400, 500, 50);
                    error.setForeground(Color.red);
                    error.setFont(new Font("Arial", 1, 20));
                }
            }
        });
        frame.add(error);
        frame.add(button);
        frame.setVisible(true);
    }

    public void deleteMeal(JFrame frame) {

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

        RoundedButton meallLabel = new RoundedButton("DELETE MEAL");
        meallLabel.setBounds(550, 25, 300, 70);
        meallLabel.setBackground(Color.decode("#752A00"));
        meallLabel.setFont(new Font("Arial", 1, 35));
        meallLabel.setForeground(Color.decode("#FACD97"));
        meallLabel.setFocusable(false);
        frame.add(meallLabel);

        JLabel label = new JLabel("Enter the name of the meal you would like to delete:");
        label.setBounds(450, 200, 1000, 50);
        label.setForeground(Color.decode("#331402"));
        label.setFont(new Font("Arial", 0, 26));
        frame.add(label);

        RoundedTextfield textField = new RoundedTextfield();
        textField.setBounds(450, 250, 500, 70);
        textField.setBorderColor(Color.decode("#331402"));
        textField.setBorderThickness(4);
        textField.setBackground(Color.WHITE);
        frame.add(textField);

        RoundedButton button = new RoundedButton("CONFIRM");
        button.setBounds(600, 350, 200, 50);
        button.setForeground(Color.white);
        button.setBackground(Color.decode("#551F01"));
        button.setFont(new Font("Arial", 1, 20));
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String meal = textField.getText();
                    int id =  mealsDatabase.getMealIdByName(meal);
                    mealsDatabase.deleteMeal(id);
                    textField.setText("");
            }
        });
        frame.add(button);
        frame.setVisible(true);
    }
}