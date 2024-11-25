package org.example.WorkersPage;

import org.example.Databases.mealsDatabase;
import org.example.Extensions.Dialog;
import org.example.Extensions.RoundedBorder;
import org.example.Extensions.RoundedButton;
import org.example.Extensions.RoundedTextfield;
import org.example.Extensions.SearchBar;
import org.example.SidePanels.WorkerSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class WorkerMenuPage {

    RoundedButton breakfastButton = new RoundedButton("BREAKFAST");
    RoundedButton lunchButton = new RoundedButton("LUNCH");
    RoundedButton dinnerButton = new RoundedButton("DINNER");
    JButton dietVegFilter = new JButton("Vegetarian");
    JButton dietNonFilter = new JButton("Non-Vegetarian");
    JLabel errorLabel = new JLabel("Meal not found");
    RoundedTextfield searchbar = new RoundedTextfield();
    ImageIcon img = new ImageIcon("src/main/java/org/example/img/Search.png");
    JButton search = new JButton(img);

    public void searchbar(JFrame frame, JPanel mealPanelContainer) {
        JLabel errorLabel = new JLabel("Meal not found");

        RoundedTextfield searchbar = new RoundedTextfield();
        searchbar.setBounds(370, 20, 550, 45);
        searchbar.setBackground(Color.decode("#FACD97"));
        searchbar.setForeground(Color.black);
        searchbar.setFont(new Font("Arial", Font.PLAIN, 14));
        searchbar.setText("");
        frame.add(searchbar);

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/Search.png");
        JButton search = new JButton(img);
        search.setBorder(BorderFactory.createEmptyBorder());
        search.setFocusable(false);
        search.setBackground(Color.decode("#FACD97"));
        search.setBounds(500, 2, 30, 40);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = searchbar.getText().trim();
                String[] meal = mealsDatabase.getMealByName(searchName);
                if (meal != null) {
                    mealPanelContainer.removeAll();
                    JButton mealButton = new JButton();
                    mealButton.setPreferredSize(new Dimension(220, 250));
                    mealButton.setBackground(Color.decode("#331402"));
                    mealButton.setBorder(BorderFactory.createEmptyBorder());
                    mealButton.setFocusable(false);
                    mealButton.setLayout(null);

                    String mealId = meal[1];
                    boolean isAvailable = mealsDatabase.isMealAvailable(mealId);

                    if (!isAvailable) {
                        JLabel notAvailable = new JLabel("Out of Stock");
                        notAvailable.setBounds(140, 213, 100, 50);
                        notAvailable.setFont(new Font("Arial", Font.BOLD, 12));
                        notAvailable.setForeground(Color.white);
                        mealButton.add(notAvailable);
                    }

                    mealButton.addActionListener(e1 -> {
                        if (isAvailable) {
                            new Dialog(meal, frame);
                        }
                    });

                    JPanel namePanel = new JPanel();
                    namePanel.setBounds(0, 180, 220, 70);
                    namePanel.setBackground(Color.decode("#331402"));
                    namePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
                    mealButton.add(namePanel);

                    JLabel nameLabel = new JLabel(meal[0]);
                    nameLabel.setForeground(Color.decode("#EF9B39"));
                    nameLabel.setFont(new Font("Arial", Font.PLAIN, 21));

                    String mealIdForImage = meal[1];
                    byte[] imageBytes = mealsDatabase.getImageForMeal(mealIdForImage);
                    if (imageBytes != null) {
                        ImageIcon mealImage = new ImageIcon(imageBytes);
                        Image image = mealImage.getImage().getScaledInstance(220, 180, Image.SCALE_SMOOTH);
                        mealImage = new ImageIcon(image);

                        JLabel imageLabel = new JLabel(mealImage);
                        imageLabel.setBounds(0, 0, 220, 180);
                        mealButton.add(imageLabel);
                        namePanel.add(nameLabel);
                        mealPanelContainer.add(mealButton);
                        mealPanelContainer.revalidate();
                        mealPanelContainer.repaint();
                    }
                } else{
                    errorLabel.setBounds(370, 60, 500, 20);
                    errorLabel.setForeground(Color.red);
                    errorLabel.setFont(new Font("Bitstream Vera Sans Mono", Font.BOLD, 10));
                    frame.add(errorLabel);
                    searchbar.setText("");
                }
            }
        });
        searchbar.add(search);
    }

    public void GUI(JFrame frame) {
        new WorkerSidePanel(frame);

        RoundedButton breakfastButton = new RoundedButton("BREAKFAST");
        breakfastButton.setBounds(370, 90, 200, 45);
        breakfastButton.setBackground(Color.decode("#752A00"));
        breakfastButton.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        breakfastButton.setForeground(Color.decode("#EF9B39"));
        breakfastButton.setFont(new Font("Arial", Font.BOLD, 20));
        breakfastButton.setFocusable(false);
        breakfastButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            breakfastPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(breakfastButton);

        RoundedButton lunchButton = new RoundedButton("LUNCH");
        lunchButton.setBounds(600, 90, 200, 45);
        lunchButton.setBackground(Color.decode("#752A00"));
        lunchButton.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        lunchButton.setForeground(Color.decode("#EF9B39"));
        lunchButton.setFont(new Font("Arial", Font.BOLD, 20));
        lunchButton.setFocusable(false);
        lunchButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            lunchPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(lunchButton);

        RoundedButton dinnerButton = new RoundedButton("DINNER");
        dinnerButton.setBounds(830, 90, 200, 45);
        dinnerButton.setBackground(Color.decode("#752A00"));
        dinnerButton.setBorder(new RoundedBorder(30, Color.decode("#551F01")));
        dinnerButton.setForeground(Color.decode("#EF9B39"));
        dinnerButton.setFont(new Font("Arial", Font.BOLD, 20));
        dinnerButton.setFocusable(false);
        dinnerButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            dinnerPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(dinnerButton);

        //Add Sort By Label
        JLabel sortLabel = new JLabel("Filter by");
        sortLabel.setBounds(380, 105, 100, 100);
        sortLabel.setFont(new Font("Arial", Font.BOLD, 16));
        sortLabel.setForeground(Color.decode("#752A00"));
        frame.add(sortLabel);

        dietVegFilter.setBounds(450, 140, 120, 30);
        dietVegFilter.setFocusable(false);
        dietVegFilter.setBackground(Color.decode("#752A00"));
        dietVegFilter.setBorder(BorderFactory.createEmptyBorder());
        dietVegFilter.setForeground(Color.decode("#EF9B39"));
        frame.add(dietVegFilter);

        dietNonFilter.setBounds(580, 140, 130, 30);
        dietNonFilter.setFocusable(false);
        dietNonFilter.setBackground(Color.decode("#752A00"));
        dietNonFilter.setBorder(BorderFactory.createEmptyBorder());
        dietNonFilter.setForeground(Color.decode("#EF9B39"));
        frame.add(dietNonFilter);
    }

    public void menuContainer(List<String[]> meals, JFrame frame, JPanel mealPanelContainer) {
        for (String[] meal : meals) {
            JButton mealButton = new JButton();
            mealButton.setPreferredSize(new Dimension(220, 250));
            mealButton.setBackground(Color.decode("#331402"));
            mealButton.setBorder(BorderFactory.createEmptyBorder());
            mealButton.setFocusable(false);
            mealButton.setLayout(null);

            String mealId = meal[1];
            boolean isAvailable = mealsDatabase.isMealAvailable(mealId);
            if (!isAvailable) {
                JLabel notAvailable = new JLabel("Out of Stock");
                notAvailable.setBounds(140, 213, 100, 50);
                notAvailable.setFont(new Font("Arial", Font.BOLD, 12));
                notAvailable.setForeground(Color.white);
                mealButton.add(notAvailable);
            }

            mealButton.addActionListener(e -> {
                if (isAvailable) {
                    new Dialog(meal, frame);
                }
            });

            // Create Panel
            JPanel namePanel = new JPanel();
            namePanel.setBounds(0, 180, 220, 70);
            namePanel.setBackground(Color.decode("#331402"));
            namePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
            mealButton.add(namePanel);

            // Create meal name text area (supports wrapping)
            JTextArea nameLabel = new JTextArea(meal[0]);
            nameLabel.setForeground(Color.decode("#EF9B39"));
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            nameLabel.setLineWrap(true);
            nameLabel.setWrapStyleWord(true);
            nameLabel.setOpaque(false);
            nameLabel.setEditable(false);
            nameLabel.setFocusable(false);
            nameLabel.setPreferredSize(new Dimension(200, 50));

            String mealIdForImage = meal[1];

            byte[] imageBytes = mealsDatabase.getImageForMeal(mealIdForImage);
            if (imageBytes != null) {
                ImageIcon mealImage = new ImageIcon(imageBytes);
                Image image = mealImage.getImage().getScaledInstance(220, 180, Image.SCALE_SMOOTH);
                mealImage = new ImageIcon(image);

                JLabel imageLabel = new JLabel(mealImage);
                imageLabel.setBounds(0, 0, 220, 180);
                mealButton.add(imageLabel);
                mealButton.revalidate();
                mealButton.repaint();
            } else {
                System.out.println("No image found for meal: " + mealIdForImage);
            }
            namePanel.add(nameLabel);
            mealPanelContainer.add(mealButton);
        }
    }

    public WorkerMenuPage(JFrame frame) {

        frame.setTitle("Worker Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed
        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        //side panel call
        new WorkerSidePanel(frame);

        //Add Image
        ImageIcon img = new ImageIcon("src/main/java/org/example/img/menu.png");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(200,50, 500, 500);
        frame.add(imgLabel);

        //Add The Menu Label
        JLabel theLabel = new JLabel("The");
        theLabel.setBounds(550, 50, 500, 100);
        theLabel.setFont(new Font("Times New Roman", Font.BOLD, 130));
        theLabel.setForeground(Color.decode("#FACD97"));
        frame.add(theLabel);
        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setBounds(700, 170, 500, 100);
        menuLabel.setFont(new Font("Times New Roman", Font.BOLD, 130));
        menuLabel.setForeground(Color.decode("#FACD97"));
        frame.add(menuLabel);

        //Create Breakfast Button
        breakfastButton.setForeground(Color.decode("#EF9B39"));
        breakfastButton.setFont(new Font("Tahoma", Font.BOLD, 24));
        breakfastButton.setBounds(550, 350, 230, 70);
        breakfastButton.setBackground(Color.decode("#752A00"));
        breakfastButton.setFocusable(false);
        breakfastButton.setBorder(new RoundedBorder(30, Color.decode("#331402")));
        breakfastButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            breakfastPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(breakfastButton);

        //Create Lunch Button
        lunchButton.setForeground(Color.decode("#EF9B39"));
        lunchButton.setFont(new Font("Tahoma", Font.BOLD, 24));
        lunchButton.setBounds(820, 350, 230, 70);
        lunchButton.setBackground(Color.decode("#752A00"));
        lunchButton.setFocusable(false);
        lunchButton.setBorder(new RoundedBorder(30, Color.decode("#331402")));
        lunchButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            lunchPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(lunchButton);

        //Create Dinner Button
        dinnerButton.setForeground(Color.decode("#EF9B39"));
        dinnerButton.setFont(new Font("Arial", Font.BOLD, 24));
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
        mealPanelContainer.setBackground(Color.decode("#EF9B39"));
        mealPanelContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        frame.add(mealPanelContainer);

        searchbar(frame, mealPanelContainer);

        java.util.List<String[]> meals = mealsDatabase.getBreakfastMeals();
        menuContainer(meals, frame, mealPanelContainer);

        mealPanelContainer.setPreferredSize(new Dimension(750, meals.size() * 260));

        //Add ScrollPane
        JScrollPane scrollPane = new JScrollPane(mealPanelContainer);
        scrollPane.setBounds(350, 170, 730, 410);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);

        dietVegFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealPanelContainer.removeAll();
                java.util.List<String[]> meals = mealsDatabase.getBreakfastVegetarianMeals();
                menuContainer(meals, frame, mealPanelContainer);
                mealPanelContainer.revalidate();
                mealPanelContainer.repaint();
            }
        });
        dietNonFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealPanelContainer.removeAll();
                java.util.List<String[]> meals = mealsDatabase.getBreakfastNonVegetarianMeals();
                menuContainer(meals, frame, mealPanelContainer);
                mealPanelContainer.revalidate();
                mealPanelContainer.repaint();
            }
        });
    }

    public void lunchPage(JFrame frame) {

        GUI(frame);

        // Create a panel to hold meal panels
        JPanel mealPanelContainer = new JPanel();
        mealPanelContainer.setBackground(Color.decode("#EF9B39"));
        mealPanelContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        frame.add(mealPanelContainer);

        searchbar(frame, mealPanelContainer);

        java.util.List<String[]> meals = mealsDatabase.getLunchMeals();
        menuContainer(meals, frame, mealPanelContainer);

        mealPanelContainer.setPreferredSize(new Dimension(750, meals.size() * 260));

        //Add ScrollPane
        JScrollPane scrollPane = new JScrollPane(mealPanelContainer);
        scrollPane.setBounds(350, 170, 730, 410);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);

        dietVegFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealPanelContainer.removeAll();
                java.util.List<String[]> meals = mealsDatabase.getLunchVegetarianMeals();
                menuContainer(meals, frame, mealPanelContainer);
                mealPanelContainer.revalidate();
                mealPanelContainer.repaint();
            }
        });
        dietNonFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealPanelContainer.removeAll();
                java.util.List<String[]> meals = mealsDatabase.getLunchNonVegetarianMeals();
                menuContainer(meals, frame, mealPanelContainer);
                mealPanelContainer.revalidate();
                mealPanelContainer.repaint();
            }
        });
    }

    public void dinnerPage(JFrame frame) {

        GUI(frame);

        // Create a panel to hold meal panels
        JPanel mealPanelContainer = new JPanel();
        mealPanelContainer.setBackground(Color.decode("#EF9B39"));
        mealPanelContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        frame.add(mealPanelContainer);

        searchbar(frame, mealPanelContainer);

        java.util.List<String[]> meals = mealsDatabase.getDinnerMeals();
        menuContainer(meals, frame, mealPanelContainer);

        mealPanelContainer.setPreferredSize(new Dimension(750, meals.size() * 260));

        //Add ScrollPane
        JScrollPane scrollPane = new JScrollPane(mealPanelContainer);
        scrollPane.setBounds(350, 170, 730, 410);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);

        dietVegFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealPanelContainer.removeAll();
                java.util.List<String[]> meals = mealsDatabase.getDinnerVegetarianMeals();
                menuContainer(meals, frame, mealPanelContainer);
                mealPanelContainer.revalidate();
                mealPanelContainer.repaint();
            }
        });
        dietNonFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealPanelContainer.removeAll();
                List<String[]> meals = mealsDatabase.getDinnerNonVegetarianMeals();
                menuContainer(meals, frame, mealPanelContainer);
                mealPanelContainer.revalidate();
                mealPanelContainer.repaint();
            }
        });
    }
}

