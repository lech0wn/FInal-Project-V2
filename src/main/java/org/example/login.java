import javax.swing.*;
import java.awt.*;

public class FigmaToCodeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FigmaToCodeApp");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(2563, 1373);
            frame.setLayout(null);

            JPanel mainPanel = new JPanel();
            mainPanel.setBounds(0, 79, 2563, 1216);
            mainPanel.setBackground(new Color(0xFFEF9B39));
            mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            mainPanel.setLayout(null);

            JPanel whitePanel1 = new JPanel();
            whitePanel1.setBounds(970, 551, 1534, 166);
            whitePanel1.setBackground(Color.WHITE);

            JPanel whitePanel2 = new JPanel();
            whitePanel2.setBounds(970, 844, 1534, 166);
            whitePanel2.setBackground(Color.WHITE);

            JLabel imageLabel = new JLabel(new ImageIcon("https://via.placeholder.com/824x1373"));
            imageLabel.setBounds(43, 0, 824, 1373);

            JLabel titleLabel = new JLabel("EMPLOYEE LOGIN");
            titleLabel.setBounds(951, 197, 1593, 190);
            titleLabel.setFont(new Font("Tauri", Font.PLAIN, 190));
            titleLabel.setForeground(new Color(0xFF752A00));

            JLabel usernameLabel = new JLabel("Username");
            usernameLabel.setBounds(970, 473, 475, 122);
            usernameLabel.setFont(new Font("Tauri", Font.PLAIN, 60));
            usernameLabel.setForeground(new Color(0xFF752A00));

            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(970, 767, 338, 58);
            passwordLabel.setFont(new Font("Tauri", Font.PLAIN, 60));
            passwordLabel.setForeground(new Color(0xFF752A00));

            JPanel enterButton = new JPanel();
            enterButton.setBounds(2191, 1106, 313, 112);
            enterButton.setBackground(Color.WHITE);
            enterButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 3));
            enterButton.setLayout(null);

            JLabel enterLabel = new JLabel("enter");
            enterLabel.setBounds(83, 23, 189, 88);
            enterLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 70));
            enterLabel.setForeground(new Color(0xFF551F01));

            enterButton.add(enterLabel);

            mainPanel.add(whitePanel1);
            mainPanel.add(whitePanel2);
            mainPanel.add(imageLabel);
            mainPanel.add(titleLabel);
            mainPanel.add(usernameLabel);
            mainPanel.add(passwordLabel);
            mainPanel.add(enterButton);

            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }
}
