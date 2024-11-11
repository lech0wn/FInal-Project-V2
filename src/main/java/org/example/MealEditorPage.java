package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class MealEditorPage {

    JButton menuPageButton = new JButton();
    JLabel mealNameLabel = new JLabel();
    JTextField mealNameTf = new JTextField("");
    JLabel descLabel = new JLabel();
    JTextField descriptionTf = new JTextField();
    JLabel categLabel = new JLabel();
    JButton breakfastButton = new JButton("breakfast");
    JButton lunchButton = new JButton("lunch");
    JButton dinnerButton = new JButton("dinner");
    JLabel dtLabel = new JLabel();
    JButton vegButton = new JButton();
    JButton nonvegButton = new JButton();
    JLabel spiceLevel = new JLabel();
    JButton spicyButton = new JButton();
    JButton nonspicyButton = new JButton();
    JLabel calsLabel = new JLabel();
    JTextField calsTf = new JTextField();
    JButton addButton = new JButton();
    JButton addMeal = new JButton("Add Meal");
    JButton editMeal = new JButton("Edit Meal");
    JButton removeMeal = new JButton("Remove Meal");
    JButton backButton = new JButton("Back to Page");
    MealEditorPage(JFrame frame) {

        frame.setTitle("Meal Editor");
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
        ordersButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        ordersButton.setForeground(Color.decode("#FACD97"));
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

        //Frame
        ImageIcon img = new ImageIcon("src/main/java/org/example/img/meal editor.png");
        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(235, 50, 500, 500);
        frame.add(imageLabel);

        JLabel mealEditor = new JLabel("MEAL EDITOR");
        mealEditor.setBounds(650, 50, 365, 90);
        mealEditor.setBackground(Color.decode("#752A00"));
        mealEditor.setFont(new Font("Arial", 1, 35));
        mealEditor.setForeground(Color.decode("#EF9B39"));
        mealEditor.setOpaque(true);
        mealEditor.setBorder(new RoundedBorder(40, Color.decode("#551F01")));
        mealEditor.setHorizontalTextPosition(SwingConstants.CENTER);
        mealEditor.setVerticalTextPosition(SwingConstants.CENTER);
        frame.add(mealEditor);

        JLabel label = new JLabel("Hello! What would you like to do?");
        label.setBounds(650, 150, 1000, 100);
        label.setForeground(Color.decode("#752A00"));
        label.setFont(new Font("Arial", 0, 26));
        frame.add(label);


        addMeal.setBounds(650, 250, 365, 85);
        addMeal.setBackground(Color.white);
        addMeal.setBorder(BorderFactory.createLineBorder(Color.decode("#331402"), 2));
        addMeal.setFont(new Font ("Arial", 2, 28));
        addMeal.setBorder(new RoundedBorder(40, Color.decode("#551F01")));
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
        editMeal.setBorder(BorderFactory.createLineBorder(Color.decode("#331402"), 2));
        editMeal.setFont(new Font ("Arial", 2, 28));
        editMeal.setBorder(new RoundedBorder(40, Color.decode("#551F01")));
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
        removeMeal.setBorder(BorderFactory.createLineBorder(Color.decode("#331402"), 2));
        removeMeal.setFont(new Font ("Arial", 2, 28));
        removeMeal.setBorder(new RoundedBorder(40, Color.decode("#551F01")));
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

        frame.add(menuPageButton);
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
        ordersButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        ordersButton.setForeground(Color.decode("#FACD97"));
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

        //Add Meal
        JLabel mealLabel = new JLabel("ADD MEAL");
        mealLabel.setBounds(550, 10, 300, 70);
        mealLabel.setBackground(Color.decode("#752A00"));
        mealLabel.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        mealLabel.setFont(new Font("Arial", 1, 35));
        mealLabel.setForeground(Color.decode("#FACD97"));
        mealLabel.setOpaque(true);
        frame.add(mealLabel);

        //Add Meal Name Label
        mealNameLabel.setText("Meal Name");
        mealNameLabel.setBounds(350, 100, 250, 30);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(mealNameLabel);

        //Add Meal Name TextField
        mealNameTf.setBounds(350, 130, 300, 50);
        mealNameTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        //Add Meal Id Label
        JLabel mealIdLabel = new JLabel("Meal ID");
        mealIdLabel.setBounds(350, 180, 250, 30);
        mealIdLabel.setForeground(Color.decode("#331402"));
        mealIdLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(mealIdLabel);

        //Add Meal Id TextField
        JTextField mealIdTf = new JTextField();
        mealIdTf.setBounds(350, 210, 300, 50);
        mealIdTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
        mealIdTf.setBackground(Color.white);
        frame.add(mealIdTf);

        //Add Description Label
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds(350, 260, 250, 30);
        descriptionLabel.setForeground(Color.decode("#331402"));
        descriptionLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(descriptionLabel);

        //Add Description TextField
        JTextField descriptionTf = new JTextField();
        descriptionTf.setBounds(350, 290, 300, 50);
        descriptionTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
        descriptionTf.setBackground(Color.white);
        frame.add(descriptionTf);

        //Add Category Label
        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(350, 340, 250, 30);
        categoryLabel.setForeground(Color.decode("#331402"));
        categoryLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(categoryLabel);

        //Add Category TextField
        JTextField categoryTf = new JTextField();
        categoryTf.setBounds(350, 370, 300, 50);
        categoryTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
        categoryTf.setBackground(Color.white);
        frame.add(categoryTf);

        //Add Ingredients Label
        JLabel ingredientsLabel = new JLabel("Ingredients");
        ingredientsLabel.setBounds(350, 420, 250, 30);
        ingredientsLabel.setForeground(Color.decode("#331402"));
        ingredientsLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(ingredientsLabel);

        //Add Ingredients TextField
        JTextField ingredientsTf = new JTextField();
        ingredientsTf.setBounds(350, 450, 300, 50);
        ingredientsTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
        ingredientsTf.setBackground(Color.white);
        frame.add(ingredientsTf);

        //Add Diet Type Label
        JLabel dietTypeLabel = new JLabel("Diet Type");
        dietTypeLabel.setBounds(700, 100, 250, 30);
        dietTypeLabel.setForeground(Color.decode("#331402"));
        dietTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(dietTypeLabel);

        //Add Diet Type TextField
        JTextField dietTypeTf = new JTextField();
        dietTypeTf.setBounds(700, 130, 300, 50);
        dietTypeTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
        dietTypeTf.setBackground(Color.white);
        frame.add(dietTypeTf);

        //Add Spice Type Label
        JLabel spiceTypeLabel = new JLabel("Spice Type");
        spiceTypeLabel.setBounds(700, 180, 250, 30);
        spiceTypeLabel.setForeground(Color.decode("#331402"));
        spiceTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(spiceTypeLabel);

        //Add spice Type TextField
        JTextField spiceTypeTf = new JTextField();
        spiceTypeTf.setBounds(700, 210, 300, 50);
        spiceTypeTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
        spiceTypeTf.setBackground(Color.white);
        frame.add(spiceTypeTf);

        //Add Serving Size Label
        JLabel servingSizeLabel = new JLabel("Serving Size");
        servingSizeLabel.setBounds(700, 260, 250, 30);
        servingSizeLabel.setForeground(Color.decode("#331402"));
        servingSizeLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(servingSizeLabel);

        //Add Serving Size TextField
        JTextField servingSizeTf = new JTextField();
        servingSizeTf.setBounds(700, 290, 300, 50);
        servingSizeTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
        servingSizeTf.setBackground(Color.white);
        frame.add(servingSizeTf);

        //Add Nutritional Value Label
        JLabel nutValueLabel = new JLabel("Nutritional Value ");
        nutValueLabel.setBounds(700, 340, 250, 30);
        nutValueLabel.setForeground(Color.decode("#331402"));
        nutValueLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
        frame.add(nutValueLabel);

        //Add Nutritional Value TextField
        JTextField nutValueTf = new JTextField();
        nutValueTf.setBounds(700, 370, 300, 50);
        nutValueTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
        nutValueTf.setBackground(Color.white);
        frame.add(nutValueTf);

        //Add Add Meal button
        addButton.setText("CONFIRM");
        addButton.setBounds(800, 500, 150, 40);
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
                String category = categoryTf.getText();
                String ingredients = ingredientsTf.getText();
                String dietType = dietTypeTf.getText();
                String spice = spiceTypeTf.getText();
                String servingSize = servingSizeTf.getText();
                String nutritionalValue = nutValueTf.getText();
                mealsDatabase.addMeals(name, description, category, ingredients, dietType, spice, servingSize, nutritionalValue);
                mealNameTf.setText("");
                descriptionTf.setText("");
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
                calsTf.setText("");
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
        ordersButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        ordersButton.setForeground(Color.decode("#FACD97"));
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

        //Add Meal
        JLabel mealLabel = new JLabel("EDIT MEAL");
        mealLabel.setBounds(550, 10, 300, 70);
        mealLabel.setBackground(Color.decode("#752A00"));
        mealLabel.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        mealLabel.setFont(new Font("Arial", 1, 35));
        mealLabel.setForeground(Color.decode("#FACD97"));
        mealLabel.setVerticalTextPosition(SwingConstants.CENTER);
        mealLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        mealLabel.setOpaque(true);
        frame.add(mealLabel);

        JLabel label = new JLabel("Enter the name of the meal you would like to edit:");
        label.setBounds(470, 200, 1000, 50);
        label.setForeground(Color.decode("#331402"));
        label.setFont(new Font("Arial", 0, 20));
        frame.add(label);

        RoundedTextfield textField = new RoundedTextfield();
        textField.setBounds(450, 250, 500, 60);
        textField.setBackground(Color.WHITE);
        frame.add(textField);

        RoundedButton button = new RoundedButton("CONFIRM");
        button.setBounds(600, 320, 200, 50);
        button.setForeground(Color.white);
        button.setBackground(Color.decode("#551F01"));
        button.setBorder(new RoundedBorder(50, Color.decode("#EF9B39")));
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        frame.add(button);

        String mealName = textField.getText().trim();
        if (mealName != null && !mealName.isEmpty()) {

            //Add Meal Name Label
            mealNameLabel.setText("Meal Name");
            mealNameLabel.setBounds(350, 100, 250, 30);
            mealNameLabel.setForeground(Color.decode("#331402"));
            mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
            frame.add(mealNameLabel);

            //Add Meal Name TextField
            mealNameTf.setBounds(350, 130, 300, 50);
            mealNameTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
            mealNameTf.setBackground(Color.white);
            frame.add(mealNameTf);

            //Add Meal Id Label
            JLabel mealIdLabel = new JLabel("Meal ID");
            mealIdLabel.setBounds(350, 180, 250, 30);
            mealIdLabel.setForeground(Color.decode("#331402"));
            mealIdLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
            frame.add(mealIdLabel);

            //Add Meal Id TextField
            JTextField mealIdTf = new JTextField();
            mealIdTf.setBounds(350, 210, 300, 50);
            mealIdTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
            mealIdTf.setBackground(Color.white);
            frame.add(mealIdTf);

            //Add Description Label
            JLabel descriptionLabel = new JLabel("Description");
            descriptionLabel.setBounds(350, 260, 250, 30);
            descriptionLabel.setForeground(Color.decode("#331402"));
            descriptionLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
            frame.add(descriptionLabel);

            //Add Description TextField
            JTextField descriptionTf = new JTextField();
            descriptionTf.setBounds(350, 290, 300, 50);
            descriptionTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
            descriptionTf.setBackground(Color.white);
            frame.add(descriptionTf);

            //Add Category Label
            JLabel categoryLabel = new JLabel("Category");
            categoryLabel.setBounds(350, 340, 250, 30);
            categoryLabel.setForeground(Color.decode("#331402"));
            categoryLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
            frame.add(categoryLabel);

            //Add Category TextField
            JTextField categoryTf = new JTextField();
            categoryTf.setBounds(350, 370, 300, 50);
            categoryTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
            categoryTf.setBackground(Color.white);
            frame.add(categoryTf);

            //Add Ingredients Label
            JLabel ingredientsLabel = new JLabel("Ingredients");
            ingredientsLabel.setBounds(350, 420, 250, 30);
            ingredientsLabel.setForeground(Color.decode("#331402"));
            ingredientsLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
            frame.add(ingredientsLabel);

            //Add Ingredients TextField
            JTextField ingredientsTf = new JTextField();
            ingredientsTf.setBounds(350, 450, 300, 50);
            ingredientsTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
            ingredientsTf.setBackground(Color.white);
            frame.add(ingredientsTf);

            //Add Diet Type Label
            JLabel dietTypeLabel = new JLabel("Diet Type");
            dietTypeLabel.setBounds(700, 100, 250, 30);
            dietTypeLabel.setForeground(Color.decode("#331402"));
            dietTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
            frame.add(dietTypeLabel);

            //Add Diet Type TextField
            JTextField dietTypeTf = new JTextField();
            dietTypeTf.setBounds(700, 130, 300, 50);
            dietTypeTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
            dietTypeTf.setBackground(Color.white);
            frame.add(dietTypeTf);

            //Add Spice Type Label
            JLabel spiceTypeLabel = new JLabel("Spice Type");
            spiceTypeLabel.setBounds(700, 180, 250, 30);
            spiceTypeLabel.setForeground(Color.decode("#331402"));
            spiceTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
            frame.add(spiceTypeLabel);

            //Add spice Type TextField
            JTextField spiceTypeTf = new JTextField();
            spiceTypeTf.setBounds(700, 210, 300, 50);
            spiceTypeTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
            spiceTypeTf.setBackground(Color.white);
            frame.add(spiceTypeTf);

            //Add Serving Size Label
            JLabel servingSizeLabel = new JLabel("Serving Size");
            servingSizeLabel.setBounds(700, 260, 250, 30);
            servingSizeLabel.setForeground(Color.decode("#331402"));
            servingSizeLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
            frame.add(servingSizeLabel);

            //Add Serving Size TextField
            JTextField servingSizeTf = new JTextField();
            servingSizeTf.setBounds(700, 290, 300, 50);
            servingSizeTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
            servingSizeTf.setBackground(Color.white);
            frame.add(servingSizeTf);

            //Add Nutritional Value Label
            JLabel nutValueLabel = new JLabel("Nutritional Value ");
            nutValueLabel.setBounds(700, 340, 250, 30);
            nutValueLabel.setForeground(Color.decode("#331402"));
            nutValueLabel.setFont(new Font("Abadi MT Condensed Extra Bold",0, 20));
            frame.add(nutValueLabel);

            //Add Nutritional Value TextField
            JTextField nutValueTf = new JTextField();
            nutValueTf.setBounds(700, 370, 300, 50);
            nutValueTf.setBorder(new RoundedBorder(10, Color.decode("#331402")));
            nutValueTf.setBackground(Color.white);
            frame.add(nutValueTf);

            JButton updateButton = new JButton("Confirm");
            updateButton.setBounds(450, 400, 150, 40);
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String mealName = textField.getText();
                    String newDescription = descriptionTf.getText();
                    String newCategory = categoryTf.getText();
                    String newIngredients = ingredientsTf.getText();
                    String newDietType = dietTypeTf.getText();
                    String newSpice = spiceTypeTf.getText();
                    String newServingSize = servingSizeTf.getText();
                    String newNutValue = nutValueTf.getText();
                    mealsDatabase.updateMeals(mealName, newDescription, newCategory, newIngredients, newDietType, newSpice, newServingSize, newNutValue);
                }
            });
            frame.add(updateButton);
        }
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
        ordersButton.setBorder(new RoundedBorder(30, Color.decode("#752A00")));
        ordersButton.setForeground(Color.decode("#FACD97"));
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

        //Add Meal
        JLabel mealLabel = new JLabel("DELETE MEAL");
        mealLabel.setBounds(550, 10, 300, 70);
        mealLabel.setBackground(Color.decode("#752A00"));
        mealLabel.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        mealLabel.setFont(new Font("Arial", 1, 35));
        mealLabel.setForeground(Color.decode("#FACD97"));
        mealLabel.setOpaque(true);
        frame.add(mealLabel);

        JLabel label = new JLabel("Enter the name of the meal you would like to delete:");
        label.setBounds(470, 200, 1000, 50);
        label.setForeground(Color.decode("#331402"));
        label.setFont(new Font("Arial", 0, 20));
        frame.add(label);

        RoundedTextfield textField = new RoundedTextfield();
        textField.setBounds(450, 250, 500, 60);
        textField.setBackground(Color.WHITE);
        frame.add(textField);

        RoundedButton deleteButton = new RoundedButton("CONFIRM");
        deleteButton.setBounds(450, 400, 150, 40);
        deleteButton.setBackground(Color.decode("#551F01"));
        deleteButton.setForeground(Color.white);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mealName = textField.getText().trim();

                if (mealName != null && !mealName.isEmpty()) {
                    int mealId = mealsDatabase.getMealIdByName(mealName);
                    if (mealId != -1) {
                        mealsDatabase.deleteMeal(mealId);
                        System.out.println("Meal Deleted");
                    }
                }
            }
        });
        frame.add(deleteButton);
        frame.setVisible(true);
    }
}