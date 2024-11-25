package org.example.SidePanels;

import org.example.*;
import org.example.Extensions.RoundedButton;
import org.example.WorkersPage.WorkerInventoryPage;
import org.example.WorkersPage.WorkerMenuPage;
import org.example.WorkersPage.WorkerOrderEditorPage;
import org.example.WorkersPage.WorkerOrderPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WorkerSidePanel {

    public WorkerSidePanel(JFrame frame) {
        JPanel sidePanel = new JPanel();
        sidePanel.setBounds(0, 0, 320, 600);
        sidePanel.setBackground(Color.decode("#752A00"));
        sidePanel.setLayout(null);
        frame.add(sidePanel);

        // Add Side Panel Java junction logo
        ImageIcon logo = new ImageIcon("src/main/java/org/example/img/SidePanelLogo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(10, 0, 300, 300);
        sidePanel.add(logoLabel);

        // Add Side Panel Welcome Label
        JLabel welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setForeground(Color.decode("#EF9B39"));
        welcomeLabel.setBounds(60, 230, 300, 100);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        sidePanel.add(welcomeLabel);

        // Add Menu Button
        RoundedButton menuButton = new RoundedButton("Menu");
        menuButton.setLayout(null);
        ImageIcon menuLogo = new ImageIcon("src/main/java/org/example/img/Restaurant Menu.png");
        JLabel menuLogoLabel = new JLabel(menuLogo);
        menuLogoLabel.setBounds(62, 6, 30, 30);
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
        menuButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            new WorkerMenuPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        sidePanel.add(menuButton);

        // Add Inventory Button
        RoundedButton inventoryButton = new RoundedButton("Inventory");
        inventoryButton.setLayout(null);
        ImageIcon inventoryLogo = new ImageIcon("src/main/java/org/example/img/Inventory.png");
        JLabel inventoryLogoLabel = new JLabel(inventoryLogo);
        inventoryLogoLabel.setBounds(45, 6, 30, 30);
        inventoryButton.add(inventoryLogoLabel);
        inventoryButton.setBounds(30, 390, 275, 45);
        inventoryButton.setBackground(Color.decode("#EF9B39"));
        inventoryButton.setFont(new Font("Arial", Font.PLAIN, 32));
        inventoryButton.setForeground(Color.BLACK);
        inventoryButton.setFocusable(false);
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
        inventoryButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            new WorkerInventoryPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        sidePanel.add(inventoryButton);

        // Add Meal Editor Button (initially invisible)
        RoundedButton mealEditorButton = new RoundedButton("");
        mealEditorButton.setBounds(140, 520, 60, 60);
        mealEditorButton.setBackground(Color.decode("#331402"));
        mealEditorButton.setForeground(Color.decode("#FACD97"));
        mealEditorButton.setFocusable(false);
        mealEditorButton.setRound(50);
        mealEditorButton.setBorderThickness(0);
        mealEditorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mealEditorButton.setBackground(Color.decode("#9C9C9C"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mealEditorButton.setBackground(Color.decode("#331402"));
            }
        });
        mealEditorButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            new WorkerOrderEditorPage(frame);
            frame.revalidate();
            frame.repaint();
        });

        // Add editor button image
        ImageIcon mealLogo = new ImageIcon("src/main/java/org/example/img/meal icon.png");
        JLabel mealLabel = new JLabel(mealLogo);
        mealLabel.setBounds(0, 0, 80, 80);
        mealEditorButton.add(mealLabel);
        sidePanel.add(mealEditorButton);

        // Add Orders Button
        RoundedButton ordersButton = new RoundedButton("Orders");
        ordersButton.setLayout(null);
        ImageIcon ordersLogo = new ImageIcon("src/main/java/org/example/img/Orders.png");
        JLabel ordersLogoLabel = new JLabel(ordersLogo);
        ordersLogoLabel.setBounds(56, 7, 30, 30);
        ordersButton.add(ordersLogoLabel);
        ordersButton.setBounds(30, 450, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", Font.PLAIN, 32));
        ordersButton.setForeground(Color.BLACK);
        ordersButton.setFocusable(false);
        ordersButton.setBorderThickness(0);
        ordersButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ordersButton.setBackground(Color.decode("#FACD97"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ordersButton.setBackground(Color.decode("#EF9B39"));
            }
        });
        ordersButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            new WorkerOrderPage(frame);
            frame.revalidate();
            frame.repaint();
            mealEditorButton.setVisible(true); // Make the meal editor button visible
            sidePanel.revalidate(); // Ensure the side panel is updated
            sidePanel.repaint();
        });
        sidePanel.add(ordersButton);

        // Add Log out button
        ImageIcon logOutImg = new ImageIcon("src/main/java/org/example/img/logout.png");
        JLabel logOutLabel = new JLabel(logOutImg);
        logOutLabel.setBounds(0, 0, 60, 60);
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
        logOutButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            new LoginPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        logOutButton.add(logOutLabel);
        sidePanel.add(logOutButton);
    }
}