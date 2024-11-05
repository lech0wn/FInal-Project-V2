import javax.swing.*;
import java.awt.*;

public class FigmaToCodeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FigmaToCodeApp");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(2907, 1526);
            frame.setBackground(new Color(18, 32, 47));
            frame.setLayout(new BorderLayout());

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(null);

            // Background container
            JPanel backgroundPanel = new JPanel();
            backgroundPanel.setBounds(0, 70, 2907, 1456);
            backgroundPanel.setBackground(new Color(0xFFEF9B39));
            backgroundPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 30));
            mainPanel.add(backgroundPanel);

            // Left side container
            JPanel leftSidePanel = new JPanel();
            leftSidePanel.setBounds(0, 70, 643, 1456);
            leftSidePanel.setBackground(new Color(0xFF752A00));
            leftSidePanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 30));
            mainPanel.add(leftSidePanel);

            // Image container
            JLabel imageLabel = new JLabel(new ImageIcon("https://via.placeholder.com/465x677"));
            imageLabel.setBounds(89, 0, 465, 677);
            imageLabel.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 178));
            mainPanel.add(imageLabel);

            // Welcome text
            JLabel welcomeLabel = new JLabel("WELCOME!");
            welcomeLabel.setBounds(136, 601, 571, 91);
            welcomeLabel.setForeground(new Color(0xFFEF9B39));
            welcomeLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 96));
            mainPanel.add(welcomeLabel);

            // Menu button
            JPanel menuButton = new JPanel();
            menuButton.setBounds(65, 743, 519, 67);
            menuButton.setBackground(new Color(0xFFFACD97));
            menuButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 40));
            mainPanel.add(menuButton);

            JLabel menuLabel = new JLabel("Menu");
            menuLabel.setBounds(190, 750, 263, 52);
            menuLabel.setForeground(Color.BLACK);
            menuLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
            mainPanel.add(menuLabel);

            // Orders button
            JPanel ordersButton = new JPanel();
            ordersButton.setBounds(65, 960, 519, 66);
            ordersButton.setBackground(new Color(0xFFEF9B39));
            ordersButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 40));
            mainPanel.add(ordersButton);

            JLabel ordersIcon = new JLabel(new ImageIcon("https://via.placeholder.com/63x49"));
            ordersIcon.setBounds(62, 9, 63, 49);
            ordersButton.add(ordersIcon);

            JLabel ordersLabel = new JLabel("Orders");
            ordersLabel.setBounds(131, 9, 201, 41);
            ordersLabel.setForeground(Color.BLACK);
            ordersLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
            ordersButton.add(ordersLabel);

            // Menu icon
            JLabel menuIcon = new JLabel(new ImageIcon("https://via.placeholder.com/64x58"));
            menuIcon.setBounds(123, 751, 64, 58);
            mainPanel.add(menuIcon);

            // Bottom left circle
            JPanel bottomLeftCircle = new JPanel();
            bottomLeftCircle.setBounds(255, 1314, 132, 122);
            bottomLeftCircle.setBackground(new Color(0xFF331301));
            bottomLeftCircle.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 132));
            mainPanel.add(bottomLeftCircle);

            JLabel bottomLeftIcon = new JLabel(new ImageIcon("https://via.placeholder.com/103x94"));
            bottomLeftIcon.setBounds(15, 16, 103, 94);
            bottomLeftCircle.add(bottomLeftIcon);

            // Top right container
            JPanel topRightContainer = new JPanel();
            topRightContainer.setBounds(707, 126, 1795, 133);
            topRightContainer.setBackground(new Color(0xFFFACD97));
            topRightContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 6));
            mainPanel.add(topRightContainer);

            JLabel topRightIcon = new JLabel(new ImageIcon("https://via.placeholder.com/81x75"));
            topRightIcon.setBounds(768, 155, 81, 75);
            mainPanel.add(topRightIcon);

            // Lunch container
            JPanel lunchContainer = new JPanel();
            lunchContainer.setBounds(1455, 339, 620, 161);
            lunchContainer.setBackground(new Color(0xFFFACD97));
            lunchContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFA7671B), 10));
            mainPanel.add(lunchContainer);

            // Breakfast container
            JPanel breakfastContainer = new JPanel();
            breakfastContainer.setBounds(731, 343, 630, 176);
            breakfastContainer.setBackground(new Color(0xFF752A00));
            breakfastContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
            mainPanel.add(breakfastContainer);

            JLabel breakfastImage = new JLabel(new ImageIcon("https://via.placeholder.com/194x175"));
            breakfastImage.setBounds(4, 1, 194, 175);
            breakfastContainer.add(breakfastImage);

            JLabel breakfastLabel = new JLabel("BREAKFAST");
            breakfastLabel.setBounds(159, 45, 471, 100);
            breakfastLabel.setForeground(new Color(0xFFEF9B39));
            breakfastLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 85));
            breakfastContainer.add(breakfastLabel);

            // Lunch label
            JLabel lunchLabel = new JLabel("LUNCH");
            lunchLabel.setBounds(1682, 374, 432, 126);
            lunchLabel.setForeground(new Color(0xFFEF9B39));
            lunchLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 90));
            mainPanel.add(lunchLabel);

            // Dinner container
            JPanel dinnerContainer = new JPanel();
            dinnerContainer.setBounds(2202, 303, 699, 216);
            dinnerContainer.setBackground(new Color(0xFF752A00));
            dinnerContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
            mainPanel.add(dinnerContainer);

            JLabel dinnerImage = new JLabel(new ImageIcon("https://via.placeholder.com/196x216"));
            dinnerImage.setBounds(60, 0, 196, 216);
            dinnerContainer.add(dinnerImage);

            JLabel dinnerLabel = new JLabel("DINNER");
            dinnerLabel.setBounds(267, 76, 432, 125);
            dinnerLabel.setForeground(new Color(0xFFEF9B39));
            dinnerLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 90));
            dinnerContainer.add(dinnerLabel);

            // Lunch image
            JLabel lunchImage = new JLabel(new ImageIcon("https://via.placeholder.com/191x161"));
            lunchImage.setBounds(1508, 344, 191, 161);
            mainPanel.add(lunchImage);

            // Middle right container
            JPanel middleRightContainer = new JPanel();
            middleRightContainer.setBounds(735, 564, 2087, 374);
            middleRightContainer.setBackground(new Color(0xFFFACD97));
            middleRightContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFA7671B), 9));
            mainPanel.add(middleRightContainer);

            // Bottom right container
            JPanel bottomRightContainer = new JPanel();
            bottomRightContainer.setBounds(731, 984, 2087, 374);
            bottomRightContainer.setBackground(new Color(0xFFFACD97));
            bottomRightContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFA7671B), 9));
            mainPanel.add(bottomRightContainer);

            // Inventory button
            JPanel inventoryButton = new JPanel();
            inventoryButton.setBounds(65, 852, 519, 107);
            inventoryButton.setBackground(new Color(0xFFEF9B39));
            inventoryButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 40));
            mainPanel.add(inventoryButton);

            JLabel inventoryIcon = new JLabel(new ImageIcon("https://via.placeholder.com/77x59"));
            inventoryIcon.setBounds(52, 5, 77, 59);
            inventoryButton.add(inventoryIcon);

            JLabel inventoryLabel = new JLabel("Inventory");
            inventoryLabel.setBounds(121, 5, 347, 48);
            inventoryLabel.setForeground(Color.BLACK);
            inventoryLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
            inventoryButton.add(inventoryLabel);

            frame.add(mainPanel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}

