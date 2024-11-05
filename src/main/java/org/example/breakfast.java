package org.example;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class breakfast {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FigmaToCodeApp");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(2907, 1526);
            frame.setLayout(null);

            Breakfast breakfast = new Breakfast();
            frame.add(breakfast);

            frame.setVisible(true);
        });
    }
}

class Breakfast extends JPanel {
    public Breakfast() {
        setLayout(null);
        setBounds(0, 0, 2907, 1526);

        JPanel container1 = new JPanel();
        container1.setBounds(0, 70, 2907, 1456);
        container1.setBackground(new Color(0xFFEF9B39));
        container1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 30));
        add(container1);

        JPanel container2 = new JPanel();
        container2.setBounds(0, 70, 643, 1456);
        container2.setBackground(new Color(0xFF752A00));
        container2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 30));
        add(container2);

        JLabel imageLabel = new JLabel(new ImageIcon("https://via.placeholder.com/465x677"));
        imageLabel.setBounds(89, 0, 465, 677);
        add(imageLabel);

        JLabel welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setBounds(136, 601, 571, 91);
        welcomeLabel.setForeground(new Color(0xFFEF9B39));
        welcomeLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 96));
        add(welcomeLabel);

        JPanel menuContainer = new JPanel();
        menuContainer.setBounds(65, 743, 519, 67);
        menuContainer.setBackground(new Color(0xFFFACD97));
        menuContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));
        add(menuContainer);

        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setBounds(190, 750, 263, 52);
        menuLabel.setForeground(Color.BLACK);
        menuLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
        add(menuLabel);

        JPanel ordersContainer = new JPanel();
        ordersContainer.setBounds(65, 960, 519, 66);
        ordersContainer.setBackground(new Color(0xFFEF9B39));
        ordersContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));
        add(ordersContainer);

        JLabel ordersIcon = new JLabel(new ImageIcon("https://via.placeholder.com/63x49"));
        ordersIcon.setBounds(62, 9, 63, 49);
        ordersContainer.add(ordersIcon);

        JLabel ordersLabel = new JLabel("Orders");
        ordersLabel.setBounds(131, 9, 201, 41);
        ordersLabel.setForeground(Color.BLACK);
        ordersLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
        ordersContainer.add(ordersLabel);

        JPanel inventoryContainer = new JPanel();
        inventoryContainer.setBounds(65, 852, 519, 66);
        inventoryContainer.setBackground(new Color(0xFFEF9B39));
        inventoryContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));
        add(inventoryContainer);

        JLabel inventoryIcon = new JLabel(new ImageIcon("https://via.placeholder.com/77x59"));
        inventoryIcon.setBounds(52, 5, 77, 59);
        inventoryContainer.add(inventoryIcon);

        JLabel inventoryLabel = new JLabel("Inventory");
        inventoryLabel.setBounds(121, 5, 347, 48);
        inventoryLabel.setForeground(Color.BLACK);
        inventoryLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
        inventoryContainer.add(inventoryLabel);

        JLabel menuIcon = new JLabel(new ImageIcon("https://via.placeholder.com/64x58"));
        menuIcon.setBounds(123, 751, 64, 58);
        add(menuIcon);

        JPanel profileContainer = new JPanel();
        profileContainer.setBounds(255, 1314, 132, 122);
        profileContainer.setBackground(new Color(0xFF331301));
        profileContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(profileContainer);

        JLabel profileImage = new JLabel(new ImageIcon("https://via.placeholder.com/103x94"));
        profileImage.setBounds(15, 16, 103, 94);
        profileContainer.add(profileImage);

        JPanel headerContainer = new JPanel();
        headerContainer.setBounds(707, 126, 1795, 133);
        headerContainer.setBackground(new Color(0xFFFACD97));
        headerContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 6));
        add(headerContainer);

        JLabel headerIcon = new JLabel(new ImageIcon("https://via.placeholder.com/81x75"));
        headerIcon.setBounds(768, 155, 81, 75);
        add(headerIcon);

        JPanel breakfastContainer = new JPanel();
        breakfastContainer.setBounds(731, 343, 620, 161);
        breakfastContainer.setBackground(new Color(0xFFFACD97));
        breakfastContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFA7671B), 10));
        add(breakfastContainer);

        JLabel breakfastImage = new JLabel(new ImageIcon("https://via.placeholder.com/194x175"));
        breakfastImage.setBounds(735, 344, 194, 175);
        add(breakfastImage);

        JLabel breakfastLabel = new JLabel("BREAKFAST");
        breakfastLabel.setBounds(890, 388, 471, 100);
        breakfastLabel.setForeground(new Color(0xFFEF9B39));
        breakfastLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 85));
        add(breakfastLabel);

        JPanel dinnerContainer = new JPanel();
        dinnerContainer.setBounds(2202, 303, 699, 216);
        dinnerContainer.setBackground(new Color(0xFF752A00));
        dinnerContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        add(dinnerContainer);

        JLabel dinnerImage = new JLabel(new ImageIcon("https://via.placeholder.com/196x216"));
        dinnerImage.setBounds(2262, 303, 196, 216);
        add(dinnerImage);

        JLabel dinnerLabel = new JLabel("DINNER");
        dinnerLabel.setBounds(2469, 379, 432, 125);
        dinnerLabel.setForeground(new Color(0xFFEF9B39));
        dinnerLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 90));
        add(dinnerLabel);

        JPanel lunchContainer = new JPanel();
        lunchContainer.setBounds(1455, 339, 644, 165);
        lunchContainer.setBackground(new Color(0xFF752A00));
        lunchContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        add(lunchContainer);

        JLabel lunchImage = new JLabel(new ImageIcon("https://via.placeholder.com/191x161"));
        lunchImage.setBounds(1485, 343, 191, 161);
        add(lunchImage);

        JLabel lunchLabel = new JLabel("LUNCH");
        lunchLabel.setBounds(1697, 375, 432, 126);
        lunchLabel.setForeground(new Color(0xFFEF9B39));
        lunchLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 90));
        add(lunchLabel);

        JPanel breakfastDetailsContainer = new JPanel();
        breakfastDetailsContainer.setBounds(735, 564, 2087, 374);
        breakfastDetailsContainer.setBackground(new Color(0xFFFACD97));
        breakfastDetailsContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFA7671B), 9));
        add(breakfastDetailsContainer);

        JPanel lunchDetailsContainer = new JPanel();
        lunchDetailsContainer.setBounds(731, 984, 2087, 374);
        lunchDetailsContainer.setBackground(new Color(0xFFFACD97));
        lunchDetailsContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFA7671B), 9));
        add(lunchDetailsContainer);
    }
}

