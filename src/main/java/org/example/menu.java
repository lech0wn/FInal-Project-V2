import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FigmaToCodeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FigmaToCodeApp");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(2901, 1526);
            frame.setLayout(null);

            Menu menu = new Menu();
            frame.add(menu);

            frame.setVisible(true);
        });
    }
}

class Menu extends JPanel {
    public Menu() {
        setLayout(null);
        setBackground(new Color(18, 32, 47));

        JPanel container1 = new JPanel();
        container1.setBounds(-3, 70, 2907, 1456);
        container1.setBackground(new Color(0xFFEF9B39));
        container1.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 30));
        add(container1);

        JPanel container2 = new JPanel();
        container2.setBounds(0, 70, 643, 1456);
        container2.setBackground(new Color(0xFF752A00));
        container2.setBorder(BorderFactory.createLineBorder(new Color(0xFF752A00), 30));
        add(container2);

        JLabel imageLabel = new JLabel(new ImageIcon(getImageURL("https://via.placeholder.com/465x677")));
        imageLabel.setBounds(89, 0, 465, 677);
        add(imageLabel);

        JLabel welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setBounds(136, 601, 571, 91);
        welcomeLabel.setForeground(new Color(0xFFEF9B39));
        welcomeLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 96));
        add(welcomeLabel);

        JPanel menuButton = new JPanel();
        menuButton.setBounds(65, 743, 519, 67);
        menuButton.setBackground(new Color(0xFFFACD97));
        menuButton.setBorder(BorderFactory.createLineBorder(new Color(0xFFFACD97), 40));
        add(menuButton);

        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setBounds(190, 750, 263, 52);
        menuLabel.setForeground(Color.BLACK);
        menuLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
        add(menuLabel);

        JPanel ordersButton = new JPanel();
        ordersButton.setBounds(65, 960, 519, 66);
        ordersButton.setBackground(new Color(0xFFEF9B39));
        ordersButton.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 40));
        add(ordersButton);

        JLabel ordersIcon = new JLabel(new ImageIcon(getImageURL("https://via.placeholder.com/63x49")));
        ordersIcon.setBounds(62, 9, 63, 49);
        ordersButton.add(ordersIcon);

        JLabel ordersLabel = new JLabel("Orders");
        ordersLabel.setBounds(131, 9, 201, 41);
        ordersLabel.setForeground(Color.BLACK);
        ordersLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
        ordersButton.add(ordersLabel);

        JPanel inventoryButton = new JPanel();
        inventoryButton.setBounds(65, 852, 519, 66);
        inventoryButton.setBackground(new Color(0xFFEF9B39));
        inventoryButton.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 40));
        add(inventoryButton);

        JLabel inventoryIcon = new JLabel(new ImageIcon(getImageURL("https://via.placeholder.com/77x59")));
        inventoryIcon.setBounds(52, 5, 77, 59);
        inventoryButton.add(inventoryIcon);

        JLabel inventoryLabel = new JLabel("Inventory");
        inventoryLabel.setBounds(121, 5, 347, 48);
        inventoryLabel.setForeground(Color.BLACK);
        inventoryLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
        inventoryButton.add(inventoryLabel);

        JLabel menuIcon = new JLabel(new ImageIcon(getImageURL("https://via.placeholder.com/64x58")));
        menuIcon.setBounds(123, 751, 64, 58);
        add(menuIcon);

        JPanel profilePic = new JPanel();
        profilePic.setBounds(255, 1314, 132, 122);
        profilePic.setBackground(new Color(0xFF331301));
        profilePic.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 122));
        add(profilePic);

        JLabel profileImage = new JLabel(new ImageIcon(getImageURL("https://via.placeholder.com/103x94")));
        profileImage.setBounds(15, 16, 103, 94);
        profilePic.add(profileImage);

        JPanel breakfastButton = new JPanel();
        breakfastButton.setBounds(1527, 819, 630, 176);
        breakfastButton.setBackground(new Color(0xFF752A00));
        breakfastButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        add(breakfastButton);

        JLabel breakfastImage = new JLabel(new ImageIcon(getImageURL("https://via.placeholder.com/194x175")));
        breakfastImage.setBounds(4, 1, 194, 175);
        breakfastButton.add(breakfastImage);

        JLabel breakfastLabel = new JLabel("BREAKFAST");
        breakfastLabel.setBounds(159, 45, 471, 100);
        breakfastLabel.setForeground(new Color(0xFFEF9B39));
        breakfastLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 85));
        breakfastButton.add(breakfastLabel);

        JPanel dinnerButton = new JPanel();
        dinnerButton.setBounds(1853, 1018, 699, 216);
        dinnerButton.setBackground(new Color(0xFF752A00));
        dinnerButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        add(dinnerButton);

        JLabel dinnerImage = new JLabel(new ImageIcon(getImageURL("https://via.placeholder.com/196x216")));
        dinnerImage.setBounds(60, 0, 196, 216);
        dinnerButton.add(dinnerImage);

        JLabel dinnerLabel = new JLabel("DINNER");
        dinnerLabel.setBounds(267, 76, 432, 125);
        dinnerLabel.setForeground(new Color(0xFFEF9B39));
        dinnerLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 90));
        dinnerButton.add(dinnerLabel);

        JPanel lunchButton = new JPanel();
        lunchButton.setBounds(2230, 819, 644, 165);
        lunchButton.setBackground(new Color(0xFF752A00));
        lunchButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        add(lunchButton);

        JLabel lunchLabel = new JLabel("LUNCH");
        lunchLabel.setBounds(212, 36, 432, 126);
        lunchLabel.setForeground(new Color(0xFFEF9B39));
        lunchLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 90));
        lunchButton.add(lunchLabel);

        JLabel lunchImage = new JLabel(new ImageIcon(getImageURL("https://via.placeholder.com/191x161")));
        lunchImage.setBounds(30, 4, 191, 161);
        lunchButton.add(lunchImage);

        JLabel backgroundImage = new JLabel(new ImageIcon(getImageURL("https://via.placeholder.com/1255x1398")));
        backgroundImage.setBounds(526, 116, 1255, 1398);
        add(backgroundImage);

        JLabel theLabel = new JLabel("The ");
        theLabel.setBounds(1531, 176, 991, 567);
        theLabel.setForeground(new Color(0xFFFACD97));
        theLabel.setFont(new Font("Milonga", Font.PLAIN, 275));
        add(theLabel);

        JLabel menuTextLabel = new JLabel("Menu");
        menuTextLabel.setBounds(1970, 445, 934, 495);
        menuTextLabel.setForeground(new Color(0xFFFACD97));
        menuTextLabel.setFont(new Font("Milonga", Font.PLAIN, 275));
        add(menuTextLabel);
    }

    private ImageIcon getImageURL(String url) {
        try {
            return new ImageIcon(new URL(url));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
