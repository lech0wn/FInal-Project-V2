import javax.swing.*;
import java.awt.*;

public class FigmaToCodeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FigmaToCodeApp");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(2563, 1373);
            frame.setLayout(new BorderLayout());

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(null);
            mainPanel.setBackground(new Color(18, 32, 47));

            JPanel loginPanel = new LoginPanel();
            loginPanel.setBounds(0, 0, 2563, 1373);
            mainPanel.add(loginPanel);

            frame.add(mainPanel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}

class LoginPanel extends JPanel {
    public LoginPanel() {
        setLayout(null);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 79, 2563, 1216);
        backgroundPanel.setBackground(new Color(0xFFEF9B39));
        backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(backgroundPanel);

        JPanel whitePanel1 = new JPanel();
        whitePanel1.setBounds(970, 551, 1534, 166);
        whitePanel1.setBackground(Color.WHITE);
        add(whitePanel1);

        JPanel whitePanel2 = new JPanel();
        whitePanel2.setBounds(970, 844, 1534, 166);
        whitePanel2.setBackground(Color.WHITE);
        add(whitePanel2);

        JLabel imageLabel = new JLabel(new ImageIcon("https://via.placeholder.com/824x1373"));
        imageLabel.setBounds(43, 0, 824, 1373);
        add(imageLabel);

        JLabel titleLabel = new JLabel("EMPLOYEE LOGIN");
        titleLabel.setBounds(951, 197, 1593, 190);
        titleLabel.setFont(new Font("Tauri", Font.PLAIN, 190));
        titleLabel.setForeground(new Color(0xFF752A00));
        add(titleLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(970, 473, 475, 122);
        usernameLabel.setFont(new Font("Tauri", Font.PLAIN, 60));
        usernameLabel.setForeground(new Color(0xFF752A00));
        add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(970, 767, 338, 58);
        passwordLabel.setFont(new Font("Tauri", Font.PLAIN, 60));
        passwordLabel.setForeground(new Color(0xFF752A00));
        add(passwordLabel);

        JButton enterButton = new JButton("enter");
        enterButton.setBounds(2191, 1106, 313, 112);
        enterButton.setBackground(Color.WHITE);
        enterButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 3));
        enterButton.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 70));
        enterButton.setForeground(new Color(0xFF551F01));
        add(enterButton);
    }
}
