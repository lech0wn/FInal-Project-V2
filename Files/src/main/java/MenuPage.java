import org.example.models.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MenuPage {

    JButton managersButton = new JButton("Manager");
    JButton breakfastButton = new JButton("Breakfast");
    JButton lunchButton = new JButton("Lunch");
    JButton dinnerButton = new JButton("Dinner");

    MenuPage(JFrame frame) {
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        //Create Managers Button
        managersButton.setBounds(900, 30, 150, 40);
        managersButton.setBackground(Color.decode("#8c9e42"));
        managersButton.setFont(new Font("Arial", Font.BOLD, 18));
        managersButton.setForeground(Color.white);
        managersButton.setFocusable(false);
        managersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new ManagersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(managersButton);

        //Create Breakfast Button
        breakfastButton.setForeground(Color.white);
        breakfastButton.setBorder(BorderFactory.createEmptyBorder());
        breakfastButton.setFont(new Font("Arial", Font.BOLD, 18));
        breakfastButton.setBounds(50, 30, 150, 40);
        breakfastButton.setBackground(Color.decode("#cb6a2e"));
        breakfastButton.setFocusable(false);
        breakfastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakfastButton.setBackground(Color.decode("#cb6a2e"));
                lunchButton.setBackground(Color.decode("#e4a781"));
                dinnerButton.setBackground(Color.decode("#e4a781"));
            }
        });
        frame.add(breakfastButton);

        //Create Lunch Button
        lunchButton.setForeground(Color.white);
        lunchButton.setBorder(BorderFactory.createEmptyBorder());
        lunchButton.setFont(new Font("Arial", Font.BOLD, 18));
        lunchButton.setBounds(230, 30, 150, 40);
        lunchButton.setBackground(Color.decode("#e4a781"));
        lunchButton.setFocusable(false);
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunchButton.setBackground(Color.decode("#cb6a2e"));
                breakfastButton.setBackground(Color.decode("#e4a781"));
                dinnerButton.setBackground(Color.decode("#e4a781"));
            }
        });
        frame.add(lunchButton);

        //Create Dinner Button
        dinnerButton.setForeground(Color.white);
        dinnerButton.setBorder(BorderFactory.createEmptyBorder());
        dinnerButton.setFont(new Font("Arial", Font.BOLD, 18));
        dinnerButton.setBounds(410, 30, 150, 40);
        dinnerButton.setBackground(Color.decode("#e4a781"));
        dinnerButton.setFocusable(false);
        dinnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dinnerButton.setBackground(Color.decode("#cb6a2e"));
                breakfastButton.setBackground(Color.decode("#e4a781"));
                lunchButton.setBackground(Color.decode("#e4a781"));
            }
        });
        frame.add(dinnerButton);

        // Create a panel to hold meal panels
        JPanel mealPanelContainer = new JPanel();
        mealPanelContainer.setBounds(50, 100, 1000, 450);
        mealPanelContainer.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        frame.add(mealPanelContainer);

        List<String[]> meals = Database.getMeals();

        for (String[] meal : meals) {
            JPanel mealPanel = new JPanel();
            mealPanel.setPreferredSize(new Dimension(200, 200));
            mealPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            mealPanel.setBackground(Color.white);

            JLabel nameLabel = new JLabel(meal[0]);
            JLabel descriptionLabel = new JLabel(meal[1]);
            JLabel categoryLabel = new JLabel(meal[2]);
            JLabel dietLabel = new JLabel(meal[3]);
            JLabel spiceLabel = new JLabel(meal[4]);
            JLabel caloriesLabel = new JLabel(meal[5]);
            mealPanel.add(nameLabel);
            mealPanel.add(descriptionLabel);
            mealPanel.add(categoryLabel);
            mealPanel.add(dietLabel);
            mealPanel.add(spiceLabel);
            mealPanel.add(caloriesLabel);
            mealPanelContainer.add(mealPanel);
        }

        frame.setLayout(null);
        frame.setSize(1100, 630);
        frame.setVisible(true);
    }
}