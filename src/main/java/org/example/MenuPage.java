package org.example;

import org.example.Databases.mealsDatabase;
import org.example.SidePanels.MealSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MenuPage {

    RoundedButton breakfastButton = new RoundedButton("BREAKFAST");
    RoundedButton lunchButton = new RoundedButton("LUNCH");
    RoundedButton dinnerButton = new RoundedButton("DINNER");

    public void GUI(JFrame frame) {
        new MealSidePanel(frame);
        new SearchBar(frame);

        RoundedButton breakfastButton = new RoundedButton("BREAKFAST");
        breakfastButton.setBounds(370, 90, 200, 45);
        breakfastButton.setBackground(Color.decode("#752A00"));
        breakfastButton.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        breakfastButton.setForeground(Color.decode("#EF9B39"));
        breakfastButton.setFont(new Font("Arial", 1, 20));
        breakfastButton.setFocusable(false);
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

        RoundedButton lunchButton = new RoundedButton("LUNCH");
        lunchButton.setBounds(600, 90, 200, 45);
        lunchButton.setBackground(Color.decode("#752A00"));
        lunchButton.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        lunchButton.setForeground(Color.decode("#EF9B39"));
        lunchButton.setFont(new Font("Arial", 1, 20));
        lunchButton.setFocusable(false);
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                lunchPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(lunchButton);

        RoundedButton dinnerButton = new RoundedButton("DINNER");
        dinnerButton.setBounds(830, 90, 200, 45);
        dinnerButton.setBackground(Color.decode("#752A00"));
        dinnerButton.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        dinnerButton.setForeground(Color.decode("#EF9B39"));
        dinnerButton.setFont(new Font("Arial", 1, 20));
        dinnerButton.setFocusable(false);
        dinnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                dinnerPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(dinnerButton);
    }

    public MenuPage(JFrame frame) {

        frame.setTitle("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed
        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        //side panel call
        new MealSidePanel(frame);

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
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                lunchPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
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

        GUI(frame);

        // Create a panel to hold meal panels
        JPanel mealPanelContainer = new JPanel();
        mealPanelContainer.setBounds(330, 170, 750, 400);
        mealPanelContainer.setBackground(Color.decode("#EF9B39"));
        frame.add(mealPanelContainer);

        List<String[]> meals = mealsDatabase.getBreakfastMeals();

        for (String[] meal : meals) {
            JButton mealButton = new JButton();
            mealButton.setPreferredSize(new Dimension(200, 200));
            mealButton.setBackground(Color.decode("#cb6a2e"));
            mealButton.setBorder(BorderFactory.createEmptyBorder());
            mealButton.setFocusable(false);
            mealButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    mealButton.setBackground(Color.white);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    mealButton.setBackground(Color.decode("#cb6a2e"));
                }
            });
            mealButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Dialog(meal, mealPanelContainer);
                }
            });
            mealButton.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 90));

            JLabel nameLabel = new JLabel(meal[0]);
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalTextPosition(JLabel.CENTER);
            nameLabel.setVerticalTextPosition(JLabel.CENTER);
            nameLabel.setFont(new Font("Arial", 1, 21));


//            JLabel spiceLabel = new JLabel("Spice Type: " + meal[4]);
//            spiceLabel.setBounds(400, 10, 300, 50);
//            spiceLabel.setForeground(Color.white);
//            spiceLabel.setFont(new Font("Arial", 1, 21));

//            JLabel dietLabel = new JLabel("Diet Type: " + meal[6]);
//            dietLabel.setBounds(400, 70, 300, 50);
//            dietLabel.setForeground(Color.white);
//            dietLabel.setFont(new Font("Arial", 1, 21));
//
            mealButton.add(nameLabel);
            mealPanelContainer.add(mealButton);
        }
    }

    public void lunchPage(JFrame frame) {

        GUI(frame);

        // Create a panel to hold meal panels
        JPanel mealPanelContainer = new JPanel();
        mealPanelContainer.setBounds(370, 170, 670, 400);
        mealPanelContainer.setBackground(Color.decode("#EF9B39"));
        frame.add(mealPanelContainer);

        List<String[]> meals = mealsDatabase.getLunchMeals();

        for (String[] meal : meals) {
            JPanel mealPanel = new JPanel();
            mealPanel.setPreferredSize(new Dimension(670, 150));
            mealPanel.setBackground(Color.decode("#cb6a2e"));
            mealPanel.setBorder(BorderFactory.createEmptyBorder());
            mealPanel.setLayout(null);

            JLabel nameLabel = new JLabel("Meal Name: " + meal[0]);
            nameLabel.setBounds(150, 10, 300, 50);
            nameLabel.setForeground(Color.white);
            nameLabel.setFont(new Font("Arial", 1, 21));

            JLabel id = new JLabel("Meal ID: " + meal[1]);
            id.setBounds(150, 40, 300, 50);
            id.setForeground(Color.white);
            id.setFont(new Font("Arial", 1, 21));

            JLabel descriptionLabel = new JLabel("Description: " + meal[2]);
            descriptionLabel.setBounds(150, 70, 300, 50);
            descriptionLabel.setForeground(Color.white);
            descriptionLabel.setFont(new Font("Arial", 1, 21));

            JLabel nutValue = new JLabel("Nutritional Value: " + meal[3]);
            nutValue.setBounds(150, 100, 300, 50);
            nutValue.setForeground(Color.white);
            nutValue.setFont(new Font("Arial", 1, 21));

            JLabel spiceLabel = new JLabel("Spice Type: " + meal[4]);
            spiceLabel.setBounds(400, 10, 300, 50);
            spiceLabel.setForeground(Color.white);
            spiceLabel.setFont(new Font("Arial", 1, 21));

            JLabel servSize = new JLabel("Serving Size: " + meal[5]);
            servSize.setBounds(400, 40, 300, 50);
            servSize.setForeground(Color.white);
            servSize.setFont(new Font("Arial", 1, 21));

            JLabel dietLabel = new JLabel("Diet Type: " + meal[6]);
            dietLabel.setBounds(400, 70, 300, 50);
            dietLabel.setForeground(Color.white);
            dietLabel.setFont(new Font("Arial", 1, 21));

            JLabel ingredientsLabel = new JLabel("Ingredients: " + meal[7]);
            ingredientsLabel.setBounds(400, 100, 300, 50);
            ingredientsLabel.setForeground(Color.white);
            ingredientsLabel.setFont(new Font("Arial", 1, 21));

            mealPanel.add(nameLabel);
            mealPanel.add(id);
            mealPanel.add(descriptionLabel);
            mealPanel.add(ingredientsLabel);
            mealPanel.add(dietLabel);
            mealPanel.add(spiceLabel);
            mealPanel.add(servSize);
            mealPanel.add(nutValue);
            mealPanelContainer.add(mealPanel);
        }
    }

    public void dinnerPage(JFrame frame) {

        GUI(frame);

        // Create a panel to hold meal panels
        JPanel mealPanelContainer = new JPanel();
        mealPanelContainer.setBounds(370, 170, 670, 400);
        mealPanelContainer.setBackground(Color.decode("#EF9B39"));
        frame.add(mealPanelContainer);

        List<String[]> meals = mealsDatabase.getDinnerMeals();

        for (String[] meal : meals) {
            JPanel mealPanel = new JPanel();
            mealPanel.setPreferredSize(new Dimension(670, 150));
            mealPanel.setBackground(Color.decode("#FACD97"));
            mealPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#A8671C"), 2));
            mealPanel.setLayout(null);

            JLabel nameLabel = new JLabel("Meal Name: " + meal[0]);
            nameLabel.setBounds(150, 10, 300, 50);
            nameLabel.setForeground(Color.decode("#551F01"));
            nameLabel.setFont(new Font("Arial", 1, 21));

            JLabel id = new JLabel("Meal ID: " + meal[1]);
            id.setBounds(150, 40, 300, 50);
            id.setForeground(Color.decode("#551F01"));
            id.setFont(new Font("Arial", 1, 21));

            JLabel descriptionLabel = new JLabel("Description: " + meal[2]);
            descriptionLabel.setBounds(150, 70, 300, 50);
            descriptionLabel.setForeground(Color.decode("#551F01"));
            descriptionLabel.setFont(new Font("Arial", 1, 21));

            JLabel nutValue = new JLabel("Nutritional Value: " + meal[3]);
            nutValue.setBounds(150, 100, 300, 50);
            nutValue.setForeground(Color.decode("#551F01"));
            nutValue.setFont(new Font("Arial", 1, 21));

            JLabel spiceLabel = new JLabel("Spice Type: " + meal[4]);
            spiceLabel.setBounds(400, 10, 300, 50);
            spiceLabel.setForeground(Color.decode("#551F01"));
            spiceLabel.setFont(new Font("Arial", 1, 21));

            JLabel servSize = new JLabel("Serving Size: " + meal[5]);
            servSize.setBounds(400, 40, 300, 50);
            servSize.setForeground(Color.decode("#551F01"));
            servSize.setFont(new Font("Arial", 1, 21));

            JLabel dietLabel = new JLabel("Diet Type: " + meal[6]);
            dietLabel.setBounds(400, 70, 300, 50);
            dietLabel.setForeground(Color.decode("#551F01"));
            dietLabel.setFont(new Font("Arial", 1, 21));

            JLabel ingredientsLabel = new JLabel("Ingredients: " + meal[7]);
            ingredientsLabel.setBounds(400, 100, 300, 50);
            ingredientsLabel.setForeground(Color.decode("#551F01"));
            ingredientsLabel.setFont(new Font("Arial", 1, 21));

            mealPanel.add(nameLabel);
            mealPanel.add(id);
            mealPanel.add(descriptionLabel);
            mealPanel.add(ingredientsLabel);
            mealPanel.add(dietLabel);
            mealPanel.add(spiceLabel);
            mealPanel.add(servSize);
            mealPanel.add(nutValue);
            mealPanelContainer.add(mealPanel);
        }
    }
}