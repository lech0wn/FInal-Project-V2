package org.example;

import org.example.Database;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;



public class ManagersPage {

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
    private String category = "breakfast";
    private String dietType = "Non-Vegetarian";
    private String spice = "Not-Spicy";

    ManagersPage(JFrame frame) {

        frame.setTitle("Manager Page");  //set the title of the window
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
        ImageIcon logo = new ImageIcon("src/main/SidePanelLogo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(100, 100, 160, 300);
        sidePanel.add(logoLabel);

        //Add Side Panel Welcome Label
        JLabel welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setBounds(80, 200, 300, 100);
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setFont(new Font("Arial", 1, 35));
        sidePanel.add(welcomeLabel);

        //Add Menu Button
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(30, 270, 275, 45 );
        menuButton.setBackground(Color.decode("#EF9B39"));
        menuButton.setBorder(BorderFactory.createEmptyBorder());
        menuButton.setFont(new Font("Arial", 0, 20));
        menuButton.setFocusable(false);
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
        inventoryButton.setBounds(30, 320, 275, 45);
        inventoryButton.setBackground(Color.decode("#EF9B39"));
        inventoryButton.setBorder(BorderFactory.createEmptyBorder());
        inventoryButton.setFont(new Font("Arial", 0, 20));
        inventoryButton.setFocusable(false);
        sidePanel.add(inventoryButton);

        //Add Orders Button
        JButton ordersButton = new JButton("Orders");
        ordersButton.setBounds(30, 380, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", Font.BOLD, 20));
        ordersButton.setFocusable(false);
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


        //Frame
        JLabel mealEditor = new JLabel("MEAL EDITOR");
        mealEditor.setBounds(600, 50, 390, 90);
        mealEditor.setBackground(Color.decode("#752A00"));
        mealEditor.setFont(new Font("Arial", 1, 20));
        mealEditor.setForeground(Color.decode("#EF9B39"));
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

        backButton.setBounds(900, 20, 150, 40);
        backButton.setBackground(Color.decode("#8c9e42"));
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setForeground(Color.white);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManagersPage(frame);
            }
        });
        frame.add(backButton);

        //Add Meal Name Label
        mealNameLabel.setText("Meal Name");
        mealNameLabel.setBounds(50, 170, 250, 30);
        mealNameLabel.setForeground(Color.decode("#d87436"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(mealNameLabel);

        //Add Meal Name TextField
        mealNameTf.setBounds(50, 200, 250, 40);
        mealNameTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        //Add description Label
        descLabel.setText("Description");
        descLabel.setBounds(50, 270, 250, 30);
        descLabel.setForeground(Color.decode("#d87436"));
        descLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(descLabel);

        //Add description TextField
        descriptionTf.setBounds(50, 300, 250, 40);
        descriptionTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        descriptionTf.setBackground(Color.white);
        frame.add(descriptionTf);

        //Add Category Label
        categLabel.setText("Category");
        categLabel.setBounds(50, 370, 250, 30);
        categLabel.setForeground(Color.decode("#d87436"));
        categLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(categLabel);

        //Add breakfast Button
        breakfastButton.setBounds(50, 400, 70, 40);
        breakfastButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        breakfastButton.setBackground(Color.white);
        breakfastButton.setFocusable(false);
        breakfastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakfastButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                breakfastButton.setBackground(Color.decode("#d87436"));
                breakfastButton.setForeground(Color.white);
                lunchButton.setBackground(Color.white);
                lunchButton.setForeground(Color.black);
                dinnerButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.black);
                category = "breakfast";
            }
        });
        frame.add(breakfastButton);

        //Add Lunch Button
        lunchButton.setBounds(140, 400, 70, 40);
        lunchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        lunchButton.setBackground(Color.white);
        lunchButton.setFocusable(false);
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                lunchButton.setBackground(Color.decode("#d87436"));
                lunchButton.setForeground(Color.white);
                breakfastButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.black);
                dinnerButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.black);
                category = "lunch";
            }
        });
        frame.add(lunchButton);

        //Add Dinner Button
        dinnerButton.setBounds(230, 400, 70, 40);
        dinnerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        dinnerButton.setBackground(Color.white);
        dinnerButton.setFocusable(false);
        dinnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dinnerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                dinnerButton.setBackground(Color.decode("#d87436"));
                dinnerButton.setForeground(Color.white);
                breakfastButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.black);
                lunchButton.setBackground(Color.white);
                lunchButton.setForeground(Color.black);
                category = "dinner";
            }
        });
        frame.add(dinnerButton);

        //Add Diet Type label
        dtLabel.setText("Diet Type");
        dtLabel.setBounds(50, 470, 250, 30);
        dtLabel.setForeground(Color.decode("#d87436"));
        dtLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(dtLabel);

        //Add Vegetarian Button
        vegButton.setText("Vegetarian");
        vegButton.setBounds(50, 500, 120, 40);
        vegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        vegButton.setBackground(Color.white);
        vegButton.setFocusable(false);
        vegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                vegButton.setBackground(Color.decode("#d87436"));
                vegButton.setForeground(Color.white);
                dietType = "Vegetarian";
                nonvegButton.setBackground(Color.white);
                nonvegButton.setForeground(Color.black);
            }
        });
        frame.add(vegButton);

        //Add Non-Vegetarian Button
        nonvegButton.setText("Non-Vegetarian");
        nonvegButton.setBounds(180, 500, 120, 40);
        nonvegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        nonvegButton.setBackground(Color.white);
        nonvegButton.setFocusable(false);
        nonvegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonvegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                nonvegButton.setBackground(Color.decode("#d87436"));
                nonvegButton.setForeground(Color.white);
                dietType = "Non-Vegetarian";
                vegButton.setBackground(Color.white);
                vegButton.setForeground(Color.black);
            }
        });
        frame.add(nonvegButton);

        //Add a Spice Label
        spiceLevel.setText("Spice");
        spiceLevel.setBounds(450, 170, 250, 30);
        spiceLevel.setForeground(Color.decode("#d87436"));
        spiceLevel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(spiceLevel);

        //Add Spicy button
        spicyButton.setText("Spicy");
        spicyButton.setBounds(450, 200, 120, 40);
        spicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        spicyButton.setBackground(Color.white);
        spicyButton.setFocusable(false);
        spicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                spicyButton.setBackground(Color.decode("#d87436"));
                spicyButton.setForeground(Color.white);
                spice = "Spicy";
                nonspicyButton.setBackground(Color.white);
                nonspicyButton.setForeground(Color.black);
            }
        });
        frame.add(spicyButton);

        //Add Non-Spicy Button
        nonspicyButton.setText("Not-Spicy");
        nonspicyButton.setBounds(580, 200, 120, 40);
        nonspicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        nonspicyButton.setBackground(Color.white);
        nonspicyButton.setFocusable(false);
        nonspicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonspicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                nonspicyButton.setBackground(Color.decode("#d87436"));
                nonspicyButton.setForeground(Color.white);
                spice = "Not-Spicy";
                spicyButton.setBackground(Color.white);
                spicyButton.setForeground(Color.black);
            }
        });
        frame.add(nonspicyButton);

        //Add Calories Label
        calsLabel.setText("Calories");
        calsLabel.setBounds(450, 270, 250, 30);
        calsLabel.setForeground(Color.decode("#d87436"));
        calsLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(calsLabel);

        //Add Calories TextField
        calsTf.setBounds(450, 300, 250, 40);
        calsTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        calsTf.setBackground(Color.white);
        frame.add(calsTf);

        //Add Add Meal button
        addButton.setText("Add Meal");
        addButton.setBounds(450, 370, 250, 40);
        addButton.setBackground(Color.decode("#d87436"));
        addButton.setFont(new Font("Arial", 1, 18));
        addButton.setForeground(Color.white);
        addButton.setFocusable(false);
        addButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = mealNameTf.getText();
                String description = descriptionTf.getText();
                String category = ManagersPage.this.category;
                String dietType = ManagersPage.this.dietType;
                String spice = ManagersPage.this.spice;
                int calories = Integer.parseInt(calsTf.getText());
                mealsDatabase.addMeals(name, description, category, dietType, spice, calories);
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
        backButton.setBounds(900, 20, 150, 40);
        backButton.setBackground(Color.decode("#8c9e42"));
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setForeground(Color.white);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManagersPage(frame);
            }
        });
        frame.add(backButton);

        JComboBox<String> mealsDropdown = new JComboBox<>();
        mealsDatabase.mealsSelector(mealsDropdown);
        mealsDropdown.setBounds(50, 50, 250, 40);
        frame.add(mealsDropdown);

        //Add description Label
        descLabel.setText("Description");
        descLabel.setBounds(50, 270, 250, 30);
        descLabel.setForeground(Color.decode("#d87436"));
        descLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(descLabel);

        //Add description TextField
        descriptionTf.setBounds(50, 300, 250, 40);
        descriptionTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        descriptionTf.setBackground(Color.white);
        frame.add(descriptionTf);

        //Add Category Label
        categLabel.setText("Category");
        categLabel.setBounds(50, 370, 250, 30);
        categLabel.setForeground(Color.decode("#d87436"));
        categLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(categLabel);

        //Add breakfast Button
        breakfastButton.setBounds(50, 400, 70, 40);
        breakfastButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        breakfastButton.setBackground(Color.white);
        breakfastButton.setFocusable(false);
        breakfastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakfastButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                breakfastButton.setBackground(Color.decode("#d87436"));
                breakfastButton.setForeground(Color.white);
                lunchButton.setBackground(Color.white);
                lunchButton.setForeground(Color.black);
                dinnerButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.black);
                category = "breakfast";
            }
        });
        frame.add(breakfastButton);

        //Add Lunch Button
        lunchButton.setBounds(140, 400, 70, 40);
        lunchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        lunchButton.setBackground(Color.white);
        lunchButton.setFocusable(false);
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                lunchButton.setBackground(Color.decode("#d87436"));
                lunchButton.setForeground(Color.white);
                breakfastButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.black);
                dinnerButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.black);
                category = "lunch";
            }
        });
        frame.add(lunchButton);

        //Add Dinner Button
        dinnerButton.setBounds(230, 400, 70, 40);
        dinnerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        dinnerButton.setBackground(Color.white);
        dinnerButton.setFocusable(false);
        dinnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dinnerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                dinnerButton.setBackground(Color.decode("#d87436"));
                dinnerButton.setForeground(Color.white);
                breakfastButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.black);
                lunchButton.setBackground(Color.white);
                lunchButton.setForeground(Color.black);
                category = "dinner";
            }
        });
        frame.add(dinnerButton);

        //Add Diet Type label
        dtLabel.setText("Diet Type");
        dtLabel.setBounds(50, 470, 250, 30);
        dtLabel.setForeground(Color.decode("#d87436"));
        dtLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(dtLabel);

        //Add Vegetarian Button
        vegButton.setText("Vegetarian");
        vegButton.setBounds(50, 500, 120, 40);
        vegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        vegButton.setBackground(Color.white);
        vegButton.setFocusable(false);
        vegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                vegButton.setBackground(Color.decode("#d87436"));
                vegButton.setForeground(Color.white);
                dietType = "Vegetarian";
                nonvegButton.setBackground(Color.white);
                nonvegButton.setForeground(Color.black);
            }
        });
        frame.add(vegButton);

        //Add Non-Vegetarian Button
        nonvegButton.setText("Non-Vegetarian");
        nonvegButton.setBounds(180, 500, 120, 40);
        nonvegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        nonvegButton.setBackground(Color.white);
        nonvegButton.setFocusable(false);
        nonvegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonvegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                nonvegButton.setBackground(Color.decode("#d87436"));
                nonvegButton.setForeground(Color.white);
                dietType = "Non-Vegetarian";
                vegButton.setBackground(Color.white);
                vegButton.setForeground(Color.black);
            }
        });
        frame.add(nonvegButton);

        //Add a Spice Label
        spiceLevel.setText("Spice");
        spiceLevel.setBounds(450, 170, 250, 30);
        spiceLevel.setForeground(Color.decode("#d87436"));
        spiceLevel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(spiceLevel);

        //Add Spicy button
        spicyButton.setText("Spicy");
        spicyButton.setBounds(450, 200, 120, 40);
        spicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        spicyButton.setBackground(Color.white);
        spicyButton.setFocusable(false);
        spicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                spicyButton.setBackground(Color.decode("#d87436"));
                spicyButton.setForeground(Color.white);
                spice = "Spicy";
                nonspicyButton.setBackground(Color.white);
                nonspicyButton.setForeground(Color.black);
            }
        });
        frame.add(spicyButton);

        //Add Non-Spicy Button
        nonspicyButton.setText("Not-Spicy");
        nonspicyButton.setBounds(580, 200, 120, 40);
        nonspicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        nonspicyButton.setBackground(Color.white);
        nonspicyButton.setFocusable(false);
        nonspicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonspicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                nonspicyButton.setBackground(Color.decode("#d87436"));
                nonspicyButton.setForeground(Color.white);
                spice = "Not-Spicy";
                spicyButton.setBackground(Color.white);
                spicyButton.setForeground(Color.black);
            }
        });
        frame.add(nonspicyButton);

        //Add Calories Label
        calsLabel.setText("Calories");
        calsLabel.setBounds(450, 270, 250, 30);
        calsLabel.setForeground(Color.decode("#d87436"));
        calsLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(calsLabel);

        //Add Calories TextField
        calsTf.setBounds(450, 300, 250, 40);
        calsTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        calsTf.setBackground(Color.white);
        frame.add(calsTf);

        JButton updateButton = new JButton("Update Meal");
        updateButton.setBounds(450, 400, 150, 40);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMeal = (String) mealsDropdown.getSelectedItem();
                String newDescription = descriptionTf.getText();
                String newCategory = category;
                String newDietType = dietType;
                String newSpice = spice;
                mealsDatabase.updateMeals(selectedMeal, newDescription, newCategory, newDietType, newSpice);
            }
        });
        frame.add(updateButton);
        frame.setVisible(true);
    }

    public void deleteMeal(JFrame frame) {
        backButton.setBounds(900, 20, 150, 40);
        backButton.setBackground(Color.decode("#8c9e42"));
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setForeground(Color.white);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManagersPage(frame);
            }
        });
        frame.add(backButton);

        JLabel label = new JLabel("Enter the name of the meal you would like to delete:");
        label.setBounds(280, 200, 1000, 100);
        label.setFont(new Font("Arial", 0, 28));
        label.setForeground(Color.decode("#331402"));
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(250, 300, 700, 70);
        textField.setBorder(BorderFactory.createLineBorder(Color.decode("#331402"), 2));
        frame.add(textField);

        JButton deleteButton = new JButton("CONFIRM");
        deleteButton.setBounds(300, 400, 100, 40);
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