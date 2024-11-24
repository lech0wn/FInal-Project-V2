package org.example.SidePanels;

import org.example.*;
import org.example.Extensions.RoundedButton;
import org.example.WorkersPage.WorkerInventoryPage;
import org.example.WorkersPage.WorkerMenuPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WorkerSidePanel {

    public WorkerSidePanel(JFrame frame) {
        JPanel sidePanel = new JPanel();
        sidePanel.setBounds(0,  0, 320, 600);
        sidePanel.setBackground(Color.decode("#752A00"));
        sidePanel.setLayout(null);
        frame.add(sidePanel);

        //Add Side Panel Java junction logo
        ImageIcon logo = new ImageIcon("src/main/java/org/example/img/SidePanelLogo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(10,0,300,300);
        sidePanel.add(logoLabel);

        //Add Side Panel Welcome Label
        JLabel welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setBounds(60, 230, 300, 100);
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setFont(new Font("Arial", 1, 40));
        sidePanel.add(welcomeLabel);

        //Add Menu Button
        RoundedButton menuButton = new RoundedButton("Menu");
        menuButton.setLayout(null);
        ImageIcon menuLogo = new ImageIcon("src/main/java/org/example/img/Restaurant Menu.png");
        JLabel menuLogoLabel = new JLabel(menuLogo);
        menuLogoLabel.setBounds(62,6,30,30);
        menuButton.add(menuLogoLabel);
        menuButton.setBounds(30, 330, 275, 45);
        menuButton.setBackground(Color.decode("#EF9B39"));
        menuButton.setFont(new Font("Arial", Font.PLAIN, 32));
        menuButton.setFocusable(false);
        menuButton.setForeground(Color.BLACK);
        menuButton.setBorderThickness(0);
        menuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                menuButton.setBackground(Color.decode("#FACD97"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                menuButton.setBackground(Color.decode("#EF9B39"));
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new WorkerMenuPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });

        sidePanel.add(menuButton);

        //Add Inventory Button
        RoundedButton inventoryButton = new RoundedButton("Inventory");
        inventoryButton.setLayout(null);
        ImageIcon inventoryLogo = new ImageIcon("src/main/java/org/example/img/Inventory.png");
        JLabel inventoryLogoLabel = new JLabel(inventoryLogo);
        inventoryLogoLabel.setBounds(45,6,30,30);
        inventoryButton.add(inventoryLogoLabel);
        inventoryButton.setBounds(30, 390, 275, 45);
        inventoryButton.setBackground(Color.decode("#EF9B39"));
        inventoryButton.setFont(new Font("Arial", 0, 32));
        inventoryButton.setForeground(Color.BLACK);
        inventoryButton.setFocusable(false);
        inventoryButton.setForeground(Color.BLACK);
        inventoryButton.setBorderThickness(0);
        inventoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                inventoryButton.setBackground(Color.decode("#FACD97"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                inventoryButton.setBackground(Color.decode("#EF9B39"));
            }
        });
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new WorkerInventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(inventoryButton);

        //Add Log out button
        ImageIcon logOutImg = new ImageIcon("src/main/java/org/example/img/logout.png");
        JLabel logOUtLabel = new JLabel(logOutImg);
        logOUtLabel.setBounds(0,0, 60, 60);
        RoundedButton logOutButton = new RoundedButton("");
        logOutButton.setBounds(10, 10, 100, 50);
        logOutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logOutButton.setForeground(Color.white);
        logOutButton.setFocusable(false);
        logOutButton.setBackground(Color.decode("#752A00"));
        logOutButton.setFocusPainted(false);
        logOutButton.setContentAreaFilled(false);
        logOutButton.setOpaque(true);
        logOutButton.setBorder(BorderFactory.createEmptyBorder());
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new LoginPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        logOutButton.add(logOUtLabel);
        sidePanel.add(logOutButton);
    }
}
