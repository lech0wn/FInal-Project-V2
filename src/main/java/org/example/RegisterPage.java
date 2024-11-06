package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage {

    String role = "Manager";
    JButton managerButton = new JButton();
    JButton workerButton = new JButton();

    RegisterPage(JFrame frame) {
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#EF9B39"));

        //Back to Login Button
        JButton loginButton = new JButton("LogIn");
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setBounds(250, 430, 100, 20);
        loginButton.setBackground(Color.decode("#EF9B39"));
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
            }
        });
        frame.add(loginButton);

        //Create Account Label
        JLabel label = new JLabel("CREATE ACCOUNT");
        label.setBounds(45, 50, 500, 100);
        label.setFont(new Font("Arial", 1, 50));
        label.setForeground(Color.decode("#752A00"));
        frame.add(label);

        //Username Label
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(45, 150, 500, 100);
        userLabel.setFont(new Font("Arial", 1, 18));
        userLabel.setForeground(Color.decode("#752A00"));
        frame.add(userLabel);

        //Username Textfield
        JTextField username = new JTextField();
        username.setBounds(45, 210, 470, 57);
        username.setBorder(BorderFactory.createEmptyBorder());
        username.setBackground(Color.white);
        frame.add(username);

        //Password Label
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(45, 260, 500, 100);
        passLabel.setFont(new Font("Arial", 1, 18));
        passLabel.setForeground(Color.decode("#752A00"));
        frame.add(passLabel);

        //Password Textfield
        JPasswordField password = new JPasswordField();
        password.setBounds(44, 320, 470, 57);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.setBackground(Color.white);
        frame.add(password);

        //Select Role Label
        JLabel roleLabel = new JLabel("Kindly select your role from the choices below:");
        roleLabel.setBounds(610, 100, 1000, 50);
        roleLabel.setForeground(Color.decode("#752A00"));
        roleLabel.setFont(new Font("Arial", 0, 20));
        frame.add(roleLabel);

        //Manager Button
        managerButton.setBounds(570, 200, 220, 210);
        managerButton.setBackground(Color.decode("#EF9B39"));
        managerButton.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        ImageIcon managerIcon = new ImageIcon("src/main/Manager.png");
        managerButton.setIcon(managerIcon);
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerButton.setBackground(Color.white);
                ImageIcon managerIcon = new ImageIcon("src/main/yellowManager.png");
                ImageIcon workerIcon = new ImageIcon("src/main/Worker.png");
                workerButton.setIcon(workerIcon);
                managerButton.setIcon(managerIcon);

                workerButton.setBackground(Color.decode("#EF9B39"));
                role = "Manager";
            }
        });
        managerButton.setFocusable(false);
        frame.add(managerButton);

        //Worker Button
        workerButton.setBounds(830, 200, 220, 210);
        workerButton.setBackground(Color.decode("#EF9B39"));
        workerButton.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        ImageIcon workerIcon = new ImageIcon("src/main/Worker.png");
        workerButton.setIcon(workerIcon);
        workerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workerButton.setBackground(Color.white);
                workerButton.setBorder(BorderFactory.createLineBorder(Color.white, 3));
                ImageIcon workerIcon = new ImageIcon("src/main/yellowWorker.png");
                workerButton.setIcon(workerIcon);
                ImageIcon managerIcon = new ImageIcon("src/main/Manager.png");
                managerButton.setIcon(managerIcon);
                managerButton.setBackground(Color.decode("#EF9B39"));
                role = "Worker";
            }
        });
        workerButton.setFocusable(false);
        frame.add(workerButton);

        //Register Button
        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(45, 415, 175, 45);
        registerButton.setBackground(Color.white);
        registerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#331402"), 2));
        registerButton.setFont(new Font("Arial", 1, 20));
        registerButton.setFocusable(false);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = username.getText();
                String passWord = new String(password.getPassword());
                Database.registerUser(userName, passWord, role);
                username.setText("");
                password.setText("");
            }
        });
        frame.add(registerButton);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
