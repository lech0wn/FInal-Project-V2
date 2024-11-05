package org.example;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FigmaToCodeApp");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1282, 687); // Halved size

            JPanel mainPanel = new JPanel();
            mainPanel.setBounds(0, 39, 1282, 608); // Halved size and y-position
            mainPanel.setBackground(new Color(0xFFEF9B39));
            mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            mainPanel.setLayout(null);

            JPanel whitePanel1 = new JPanel();
            whitePanel1.setBounds(485, 275, 767, 83); // Halved size and y-position
            whitePanel1.setBackground(Color.WHITE);

            JPanel whitePanel2 = new JPanel();
            whitePanel2.setBounds(485, 422, 767, 83); // Halved size and y-position
            whitePanel2.setBackground(Color.WHITE);

            JLabel imageLabel = new JLabel(new ImageIcon("https://via.placeholder.com/412x687"));
            imageLabel.setBounds(21, 0, 412, 687); // Halved size and x-position

            //header
            JLabel titleLabel = new JLabel("EMPLOYEE LOGIN");
            titleLabel.setBounds(475, 98, 796, 95); // Halved size and y-position
            titleLabel.setFont(new Font("Tauri", Font.PLAIN, 95)); // Halved font size
            titleLabel.setForeground(new Color(0xFF752A00));

            //username
            JLabel usernameLabel = new JLabel("Username");
            usernameLabel.setBounds(485, 236, 238, 61); // Halved size and y-position
            usernameLabel.setFont(new Font("Tauri", Font.PLAIN, 30)); // Halved font size
            usernameLabel.setForeground(new Color(0xFF752A00));

            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(485, 383, 169, 29); // Halved size and y-position
            passwordLabel.setFont(new Font("Tauri", Font.PLAIN, 30)); // Halved font size
            passwordLabel.setForeground(new Color(0xFF752A00));

            JPanel enterButton = new JPanel();
            enterButton.setBounds(1095, 553, 156, 56); // Halved size and y-position
            enterButton.setBackground(Color.WHITE);
            enterButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 3));
            enterButton.setLayout(null);

            JLabel enterLabel = new JLabel("enter");
            enterLabel.setBounds(41, 12, 94, 44); // Halved size and y-position
            enterLabel.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 35)); // Halved font size
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
            frame.setResizable(false);
        });
    }
}
