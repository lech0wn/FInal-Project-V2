package org.example;

import org.example.Databases.usersDatabase;
import org.example.Extensions.RoundedButton;
import org.example.SidePanels.MealSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

public class usersPage {

    public usersPage(JFrame frame) {

        frame.setTitle("Users");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed
        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        //side panel call
        new MealSidePanel(frame);

        RoundedButton userEditor = new RoundedButton("USERS");
        userEditor.setBounds(550, 20, 300, 60);
        userEditor.setBackground(Color.decode("#752A00"));
        userEditor.setFont(new Font("Arial", Font.BOLD, 45));
        userEditor.setForeground(Color.decode("#EF9B39"));
        frame.add(userEditor);

        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(400, 100, 600, 50);
        titlePanel.setBackground(Color.black);
        titlePanel.setBackground(Color.decode("#752A00"));
        titlePanel.setLayout(null);
        frame.add(titlePanel);

        JLabel usersLabel = new  JLabel("USER");
        usersLabel.setForeground(Color.white);
        usersLabel.setBounds(100, 10, 100, 40);
        usersLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(usersLabel);

        JLabel rolesLabel = new  JLabel("ROLE");
        rolesLabel.setForeground(Color.white);
        rolesLabel.setBounds(310, 10, 100, 40);
        rolesLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(rolesLabel);

        RoundedButton addUser = new RoundedButton("Add a User");
        addUser.setBounds(450, 12, 130, 30);
        addUser.setBackground(Color.white);
        addUser.setBorderThickness(0);
        addUser.setForeground(Color.black);
        addUser.setFocusable(false);
        addUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                addUser.setBackground(Color.decode("#dceaff"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                addUser.setBackground(Color.white);
            }
        });
        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new RegisterPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        titlePanel.add(addUser);

        JPanel panel = new JPanel();
        panel.setBounds(400, 150, 600, 400);
        panel.setBackground(Color.decode("#752A00"));
        panel.setLayout(null);
        frame.add(panel);

        List<String[]>  user = usersDatabase.getUsers();

        int yOffset = 5;
        int panelHeight = 50;
        for (int i = 0; i < user.size(); i++) {
            String[] users = user.get(i);

            JPanel userPanel = new JPanel();
            userPanel.setBounds(0, i * (panelHeight + yOffset), 600, panelHeight);
            userPanel.setBackground(Color.decode("#742a00"));
            userPanel.setLayout(null);
            panel.add(userPanel);

            JPanel namePanel = new JPanel();
            namePanel.setBounds(0, 0, 260, 50);
            namePanel.setBackground(Color.decode("#742a00"));
            namePanel.setLayout(null);
            userPanel.add(namePanel);

            //Add username Label
            JLabel nameLabel = new JLabel(users[0]);
            nameLabel.setForeground(Color.white);
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 21));
            nameLabel.setBounds(60, 0, 140, 40);
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            namePanel.add(nameLabel);

            JPanel rolePanel = new JPanel();
            rolePanel.setBounds(260, 0, 160, 50);
            rolePanel.setBackground(Color.decode("#742a00"));
            rolePanel.setLayout(null);
            userPanel.add(rolePanel);

            //Add role label
            JLabel roleLabel = new JLabel(users[1]);
            roleLabel.setForeground(Color.white);
            roleLabel.setFont(new Font("Arial", Font.PLAIN, 21));
            roleLabel.setBounds(10, 0, 140, 40);
            roleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            rolePanel.add(roleLabel);

            //Add delete button
            RoundedButton deleteButton = new RoundedButton("Delete User");
            deleteButton.setBounds(450, 8, 130, 30);
            deleteButton.setBackground(Color.white);
            deleteButton.setBorderThickness(0);
            deleteButton.setForeground(Color.black);
            deleteButton.setFocusable(false);
            deleteButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    deleteButton.setBackground(Color.decode("#dceaff"));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    deleteButton.setBackground(Color.white);
                }
            });
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    String username = users[0];
                    usersDatabase.deleteUser(username);
                    new usersPage(frame);
                    frame.revalidate();
                    frame.repaint();
                }
            });
            userPanel.add(deleteButton);
        }

        frame.revalidate();
        frame.repaint();
    }
}
