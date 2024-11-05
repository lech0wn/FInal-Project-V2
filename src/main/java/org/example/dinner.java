import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FigmaToCodeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FigmaToCodeApp");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(2907, 1526);
            frame.setLayout(null);

            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(new Color(18, 32, 47));

            JPanel container1 = new JPanel();
            container1.setBounds(0, 70, 2907, 1456);
            container1.setBackground(new Color(0xFFEF9B39));
            container1.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 30));

            JPanel container2 = new JPanel();
            container2.setBounds(0, 70, 643, 1456);
            container2.setBackground(new Color(0xFF752A00));
            container2.setBorder(BorderFactory.createLineBorder(new Color(0xFF752A00), 30));

            JLabel imageLabel1 = new JLabel(new ImageIcon(new URL("https://via.placeholder.com/465x677")));
            imageLabel1.setBounds(89, 0, 465, 677);
            imageLabel1.setBorder(BorderFactory.createLineBorder(new Color(0xFF752A00), 178));

            JLabel welcomeLabel = new JLabel("WELCOME!");
            welcomeLabel.setBounds(136, 601, 571, 91);
            welcomeLabel.setForeground(new Color(0xFFEF9B39));
            welcomeLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 96));

            JPanel menuContainer = new JPanel();
            menuContainer.setBounds(65, 743, 519, 67);
            menuContainer.setBackground(new Color(0xFFFACD97));
            menuContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFFACD97), 40));

            JLabel menuLabel = new JLabel("Menu");
            menuLabel.setBounds(190, 750, 263, 52);
            menuLabel.setForeground(Color.BLACK);
            menuLabel.setFont(new Font("Milonga", Font.PLAIN, 48));

            JPanel ordersContainer = new JPanel();
            ordersContainer.setBounds(65, 960, 519, 66);
            ordersContainer.setBackground(new Color(0xFFEF9B39));
            ordersContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 40));

            JLabel ordersLabel = new JLabel("Orders");
            ordersLabel.setBounds(131, 9, 201, 41);
            ordersLabel.setForeground(Color.BLACK);
            ordersLabel.setFont(new Font("Milonga", Font.PLAIN, 48));

            JLabel imageLabel2 = new JLabel(new ImageIcon(new URL("https://via.placeholder.com/63x49")));
            imageLabel2.setBounds(62, 9, 63, 49);

            JPanel inventoryContainer = new JPanel();
            inventoryContainer.setBounds(65, 852, 519, 66);
            inventoryContainer.setBackground(new Color(0xFFEF9B39));
            inventoryContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 40));

            JLabel inventoryLabel = new JLabel("Inventory");
            inventoryLabel.setBounds(121, 5, 347, 48);
            inventoryLabel.setForeground(Color.BLACK);
            inventoryLabel.setFont(new Font("Milonga", Font.PLAIN, 48));

            JLabel imageLabel3 = new JLabel(new ImageIcon(new URL("https://via.placeholder.com/77x59")));
            imageLabel3.setBounds(52, 5, 77, 59);

            JLabel imageLabel4 = new JLabel(new ImageIcon(new URL("https://via.placeholder.com/64x58")));
            imageLabel4.setBounds(123, 751, 64, 58);

            JPanel circleContainer = new JPanel();
            circleContainer.setBounds(255, 1314, 132, 122);
            circleContainer.setBackground(new Color(0xFF331301));
            circleContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 122));

            JLabel imageLabel5 = new JLabel(new ImageIcon(new URL("https://via.placeholder.com/103x94")));
            imageLabel5.setBounds(15, 16, 103, 94);

            JPanel headerContainer = new JPanel();
            headerContainer.setBounds(707, 126, 1795, 133);
            headerContainer.setBackground(new Color(0xFFFACD97));
            headerContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 6));

            JLabel imageLabel6 = new JLabel(new ImageIcon(new URL("https://via.placeholder.com/81x75")));
            imageLabel6.setBounds(768, 155, 81, 75);

            JPanel dinnerContainer = new JPanel();
            dinnerContainer.setBounds(2202, 339, 620, 161);
            dinnerContainer.setBackground(new Color(0xFFFACD97));
            dinnerContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFFA7671B), 10));

            JLabel imageLabel7 = new JLabel(new ImageIcon(new URL("https://via.placeholder.com/196x216")));
            imageLabel7.setBounds(2262, 303, 196, 216);

            JPanel breakfastContainer = new JPanel();
            breakfastContainer.setBounds(731, 343, 630, 176);
            breakfastContainer.setBackground(new Color(0xFF752A00));
            breakfastContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));

            JLabel imageLabel8 = new JLabel(new ImageIcon(new URL("https://via.placeholder.com/194x175")));
            imageLabel8.setBounds(4, 1, 194, 175);

            JLabel breakfastLabel = new JLabel("BREAKFAST");
            breakfastLabel.setBounds(159, 45, 471, 100);
            breakfastLabel.setForeground(new Color(0xFFEF9B39));
            breakfastLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 85));

            JLabel dinnerLabel = new JLabel("DINNER");
            dinnerLabel.setBounds(2469, 379, 432, 125);
            dinnerLabel.setForeground(new Color(0xFFEF9B39));
            dinnerLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 90));

            JPanel lunchContainer = new JPanel();
            lunchContainer.setBounds(1455, 339, 653, 165);
            lunchContainer.setBackground(new Color(0xFF752A00));
            lunchContainer.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));

            JLabel lunchLabel = new JLabel("LUNCH");
            lunchLabel.setBounds(221, 36, 432, 126);
            lunchLabel.setForeground(new Color(0xFFEF9B39));
            lunchLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 90));

            JLabel imageLabel9 = new JLabel(new ImageIcon(new URL("https://via.placeholder.com/191x161")));
            imageLabel9.setBounds(30, 4, 191, 161);

            JPanel contentContainer1 = new JPanel();
            contentContainer1.setBounds(735, 564, 2087, 374);
            contentContainer1.setBackground(new Color(0xFFFACD97));
            contentContainer1.setBorder(BorderFactory.createLineBorder(new Color(0xFFA7671B), 9));

            JPanel contentContainer2 = new JPanel();
            contentContainer2.setBounds(731, 984, 2087, 374);
            contentContainer2.setBackground(new Color(0xFFFACD97));
            contentContainer2.setBorder(BorderFactory.createLineBorder(new Color(0xFFA7671B), 9));

            panel.add(container1);
            panel.add(container2);
            panel.add(imageLabel1);
            panel.add(welcomeLabel);
            panel.add(menuContainer);
            panel.add(menuLabel);
            panel.add(ordersContainer);
            panel.add(ordersLabel);
            panel.add(imageLabel2);
            panel.add(inventoryContainer);
            panel.add(inventoryLabel);
            panel.add(imageLabel3);
            panel.add(imageLabel4);
            panel.add(circleContainer);
            panel.add(imageLabel5);
            panel.add(headerContainer);
            panel.add(imageLabel6);
            panel.add(dinnerContainer);
            panel.add(imageLabel7);
            panel.add(breakfastContainer);
            panel.add(imageLabel8);
            panel.add(breakfastLabel);
            panel.add(dinnerLabel);
            panel.add(lunchContainer);
            panel.add(lunchLabel);
            panel.add(imageLabel9);
            panel.add(contentContainer1);
            panel.add(contentContainer2);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}

