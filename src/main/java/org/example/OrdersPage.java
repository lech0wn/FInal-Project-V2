package org.example;

import org.example.ordersDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class OrdersPage {

    OrdersPage(JFrame frame) {

        frame.setTitle("Orders");  //set the title of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        //side panel call
        new SidePanel(frame);

        JTextField searchbar = new JTextField();
        searchbar.setBounds(370, 20, 550, 45);
        searchbar.setBackground(Color.decode("#FACD97"));
        searchbar.setBorder(new RoundedBorder(20, Color.decode("#331402")));
        frame.add(searchbar);

        JLabel orderIdOrdersLabel = new JLabel("Order ID");
        orderIdOrdersLabel.setBounds(370, 80, 110, 45);
        orderIdOrdersLabel.setOpaque(true);
        orderIdOrdersLabel.setBackground(Color.decode("#752A00"));
        orderIdOrdersLabel.setForeground(Color.decode("#EF9B39"));
        orderIdOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        orderIdOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        orderIdOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(orderIdOrdersLabel);

        JLabel dateOrdersLabel = new JLabel("Date");
        dateOrdersLabel.setBounds(500, 80, 110, 45);
        dateOrdersLabel.setOpaque(true);
        dateOrdersLabel.setBackground(Color.decode("#752A00"));
        dateOrdersLabel.setForeground(Color.decode("#EF9B39"));
        dateOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        dateOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        dateOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(dateOrdersLabel);

        JLabel mealOrdersLabel = new JLabel("Meal");
        mealOrdersLabel.setBounds(630, 80, 110, 45);
        mealOrdersLabel.setOpaque(true);
        mealOrdersLabel.setBackground(Color.decode("#752A00"));
        mealOrdersLabel.setForeground(Color.decode("#EF9B39"));
        mealOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        mealOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        mealOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(mealOrdersLabel);

        JLabel quantityOrdersLabel = new JLabel("Quantity");
        quantityOrdersLabel.setBounds(760, 80, 110, 45);
        quantityOrdersLabel.setOpaque(true);
        quantityOrdersLabel.setBackground(Color.decode("#752A00"));
        quantityOrdersLabel.setForeground(Color.decode("#EF9B39"));
        quantityOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        quantityOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        quantityOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(quantityOrdersLabel);

        JLabel priceOrdersLabel = new JLabel("Total Price");
        priceOrdersLabel.setBounds(890, 80, 130, 45);
        priceOrdersLabel.setOpaque(true);
        priceOrdersLabel.setBackground(Color.decode("#752A00"));
        priceOrdersLabel.setForeground(Color.decode("#EF9B39"));
        priceOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 18));
        priceOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        priceOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(priceOrdersLabel);

        // Create panel containers for each column
        JPanel datePanelContainer = new JPanel();
        datePanelContainer.setLayout(new BoxLayout(datePanelContainer, BoxLayout.Y_AXIS));

        JPanel orderIdPanelContainer = new JPanel();
        orderIdPanelContainer.setLayout(new BoxLayout(orderIdPanelContainer, BoxLayout.Y_AXIS));

        JPanel mealPanelContainer = new JPanel();
        mealPanelContainer.setLayout(new BoxLayout(mealPanelContainer, BoxLayout.Y_AXIS));

        JPanel quantityPanelContainer = new JPanel();
        quantityPanelContainer.setLayout(new BoxLayout(quantityPanelContainer, BoxLayout.Y_AXIS));

        JPanel pricePanelContainer = new JPanel();
        pricePanelContainer.setLayout(new BoxLayout(pricePanelContainer, BoxLayout.Y_AXIS));

        List<String[]> orders = ordersDatabase.listOrders();

        // Loop through orders and create panels
        for (String[] order : orders) {

            // Create Order ID Panel
            JPanel orderIdPanel = new JPanel();
            orderIdPanel.setLayout(new BorderLayout());
            orderIdPanel.setPreferredSize(new Dimension(200, 50));
            orderIdPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            orderIdPanel.setBackground(Color.decode("#752A00"));

            JLabel orderIdLabel2 = new JLabel(order[0], SwingConstants.CENTER);
            orderIdLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            orderIdLabel2.setForeground(Color.decode("#EF9B39"));
            orderIdPanel.add(orderIdLabel2, BorderLayout.CENTER);
            orderIdPanelContainer.add(orderIdPanel);

            // Create Date Panel
            JPanel datePanel = new JPanel();
            datePanel.setLayout(new BorderLayout());
            datePanel.setPreferredSize(new Dimension(200, 50));
            datePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            datePanel.setBackground(Color.decode("#752A00"));

            JLabel dateLabel = new JLabel(order[1], SwingConstants.CENTER);
            dateLabel.setFont(new Font("Milonga", Font.BOLD, 14));
            dateLabel.setForeground(Color.decode("#EF9B39"));
            datePanel.add(dateLabel, BorderLayout.CENTER);
            datePanelContainer.add(datePanel);


            // Create Meal Panel
            JPanel mealPanel = new JPanel();
            mealPanel.setLayout(new BorderLayout());
            mealPanel.setPreferredSize(new Dimension(200, 50));
            mealPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            mealPanel.setBackground(Color.decode("#752A00"));

            JLabel mealLabel2 = new JLabel(order[2], SwingConstants.CENTER);
            mealLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            mealLabel2.setForeground(Color.decode("#EF9B39"));
            mealPanel.add(mealLabel2, BorderLayout.CENTER);
            mealPanelContainer.add(mealPanel);

            // Create Quantity Panel
            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new BorderLayout());
            quantityPanel.setPreferredSize(new Dimension(200, 50));
            quantityPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            quantityPanel.setBackground(Color.decode("#752A00"));

            JLabel quantityLabel2 = new JLabel(order[3], SwingConstants.CENTER); // Assuming quantity is at index 3
            quantityLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            quantityLabel2.setForeground(Color.decode("#EF9B39"));
            quantityPanel.add(quantityLabel2, BorderLayout.CENTER);
            quantityPanelContainer.add(quantityPanel);

            // Create Price Panel
            JPanel pricePanel = new JPanel();
            pricePanel.setLayout(new BorderLayout());
            pricePanel.setPreferredSize(new Dimension(200, 50));
            pricePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            pricePanel.setBackground(Color.decode("#752A00"));

            JLabel priceLabel2 = new JLabel(order[4], SwingConstants.CENTER); // Assuming price is at index 4
            priceLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            priceLabel2.setForeground(Color.decode("#EF9B39"));
            pricePanel.add(priceLabel2, BorderLayout.CENTER);
            pricePanelContainer.add(pricePanel);
        }

        // Set the position and size of each panel container
        orderIdPanelContainer.setBounds(370, 140, 110, 400);
        datePanelContainer.setBounds(500, 140, 110, 400);
        mealPanelContainer.setBounds(630, 140, 110, 400);
        quantityPanelContainer.setBounds(760, 140, 110, 400);
        pricePanelContainer.setBounds(890, 140, 130, 400);

        // Add the containers to the frame
        frame.add(datePanelContainer);
        frame.add(orderIdPanelContainer);
        frame.add(mealPanelContainer);
        frame.add(quantityPanelContainer);
        frame.add(pricePanelContainer);

        //add orders button
        JButton addOrdersButton = new JButton();
        addOrdersButton.setBounds(950, 20, 50, 50);
        addOrdersButton.setBackground(Color.decode("#752A00"));
        addOrdersButton.setText("+");
        addOrdersButton.setFont(new Font("Arial", Font.BOLD, 18));
        addOrdersButton.setForeground(Color.white);
        addOrdersButton.setFocusable(false);
        addOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                addOrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(addOrdersButton);

        // Refresh frame components
        frame.revalidate();
        frame.repaint();

        //delete order button
        JButton deleteOrdersButton = new JButton();
        deleteOrdersButton.setBounds(1020, 20, 50, 50);
        deleteOrdersButton.setBackground(Color.decode("#752A00"));
        deleteOrdersButton.setText("-");
        deleteOrdersButton.setFont(new Font("Arial", Font.BOLD, 18));
        deleteOrdersButton.setForeground(Color.white);
        deleteOrdersButton.setFocusable(false);
        deleteOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                deleteOrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(deleteOrdersButton);

        // Refresh frame components
        frame.revalidate();
        frame.repaint();
    }

    public void addOrdersPage(JFrame frame){

        //Add Side Panel
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
                new MenuPage(frame);
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
                new InventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(inventoryButton);

        //Add Orders Button
        RoundedButton ordersButton = new RoundedButton("Orders");
        ordersButton.setLayout(null);
        ImageIcon ordersLogo = new ImageIcon("src/main/java/org/example/img/Orders.png");
        JLabel ordersLogoLabel = new JLabel(ordersLogo);
        ordersLogoLabel.setBounds(56,7,30,30);
        ordersButton.add(ordersLogoLabel);
        ordersButton.setBounds(30, 450, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", 0, 32));
        ordersButton.setForeground(Color.BLACK);
        ordersButton.setFocusable(false);
        ordersButton.setForeground(Color.BLACK);
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
        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new OrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(ordersButton);

        //Add Meal Editor Button
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
        mealEditorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MealEditorPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });

        //Add eDitor button img
        ImageIcon mealLogo = new ImageIcon("src/main/java/org/example/img/meal icon.png");
        JLabel mealLabel = new JLabel(mealLogo);
        mealLabel.setBounds(0,0,80,80);
        mealEditorButton.add(mealLabel);

        sidePanel.add(mealEditorButton);

        //add order label
        JLabel addOrderLabel = new JLabel("ADD ORDER");
        addOrderLabel.setBounds(520, 50, 360, 80);
        addOrderLabel.setOpaque(true);
        addOrderLabel.setBackground(Color.decode("#752A00"));
        addOrderLabel.setForeground(Color.decode("#FACD97"));
        addOrderLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 40));
        addOrderLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        //add this if naa nay image
//        ImageIcon icon = new ImageIcon("path/to/your/image.png"); // Replace with the path to your image
//        addOrderLabel.setIcon(icon);
//        addOrderLabel.setHorizontalTextPosition(SwingConstants.RIGHT); // Text on the right, image on the left

        addOrderLabel.setHorizontalAlignment(SwingConstants.RIGHT); //align text to the right
        frame.add(addOrderLabel);

        //meal name label
        JLabel mealNameLabel = new JLabel();
        mealNameLabel.setText("Meal Name");
        mealNameLabel.setBounds(370, 200, 300, 45);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(mealNameLabel);

        //meal name text field
        JTextField mealNameTf = new JTextField("");
        mealNameTf.setBounds(370, 240, 300, 45);
        mealNameTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        //price label
        JLabel priceLabel = new JLabel();
        priceLabel.setText("Subtotal Price");
        priceLabel.setBounds(700, 200, 300, 45);
        priceLabel.setForeground(Color.decode("#331402"));
        priceLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(priceLabel);

        //price text field
        JTextField priceTf = new JTextField("");
        priceTf.setBounds(700, 240, 300, 45);
        priceTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        priceTf.setBackground(Color.white);
        frame.add(priceTf);

        //quantity label
        JLabel quantityLabel = new JLabel();
        quantityLabel.setText("Quantity");
        quantityLabel.setBounds(370, 280, 300, 45);
        quantityLabel.setForeground(Color.decode("#331402"));
        quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(quantityLabel);

        //quantity text field
        JTextField quantityTf = new JTextField("");
        quantityTf.setBounds(370, 320, 300, 45);
        quantityTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        quantityTf.setBackground(Color.white);
        frame.add(quantityTf);

        //date label
        JLabel dateLabel = new JLabel();
        dateLabel.setText("Date");
        dateLabel.setBounds(700, 280, 300, 45);
        dateLabel.setForeground(Color.decode("#331402"));
        dateLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(dateLabel);

        //date text field
        JTextField dateTf = new JTextField("");
        dateTf.setBounds(700, 320, 300, 45);
        dateTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        dateTf.setBackground(Color.white);
        frame.add(dateTf);

        //confirm order button
        JButton confirmOrderButton = new JButton();
        confirmOrderButton.setText("CONFIRM");
        confirmOrderButton.setBounds(850, 500, 160, 40);
        confirmOrderButton.setBackground(Color.decode("#551F01"));
        confirmOrderButton.setFont(new Font("Arial", 1, 18));
        confirmOrderButton.setForeground(Color.white);
        confirmOrderButton.setFocusable(false);
        confirmOrderButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
        confirmOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = mealNameTf.getText();
                String quantity = quantityTf.getText();
                String price = priceTf.getText();
                String date = dateTf.getText();

                ordersDatabase.addOrders(name, quantity, price, date);
                mealNameTf.setText("");
                quantityTf.setText("");
                priceTf.setText("");
                dateTf.setText("");
            }
        });
        frame.add(confirmOrderButton);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    //delete orders page
    public void deleteOrdersPage(JFrame frame) {

        //Add Side Panel
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
                new MenuPage(frame);
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
                new InventoryPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(inventoryButton);

        //Add Orders Button
        RoundedButton ordersButton = new RoundedButton("Orders");
        ordersButton.setLayout(null);
        ImageIcon ordersLogo = new ImageIcon("src/main/java/org/example/img/Orders.png");
        JLabel ordersLogoLabel = new JLabel(ordersLogo);
        ordersLogoLabel.setBounds(56,7,30,30);
        ordersButton.add(ordersLogoLabel);
        ordersButton.setBounds(30, 450, 275, 45);
        ordersButton.setBackground(Color.decode("#EF9B39"));
        ordersButton.setFont(new Font("Arial", 0, 32));
        ordersButton.setForeground(Color.BLACK);
        ordersButton.setFocusable(false);
        ordersButton.setForeground(Color.BLACK);
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
        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new OrdersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        sidePanel.add(ordersButton);

        //Add Meal Editor Button
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
        mealEditorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MealEditorPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });

        //Add eDitor button img
        ImageIcon mealLogo = new ImageIcon("src/main/java/org/example/img/meal icon.png");
        JLabel mealLabel = new JLabel(mealLogo);
        mealLabel.setBounds(0,0,80,80);
        mealEditorButton.add(mealLabel);

        sidePanel.add(mealEditorButton);

        // delete order button
        JLabel deleteOrderLabel = new JLabel("DELETE ORDER");
        deleteOrderLabel.setBounds(500, 50, 430, 80);
        deleteOrderLabel.setOpaque(true);
        deleteOrderLabel.setBackground(Color.decode("#752A00"));
        deleteOrderLabel.setForeground(Color.decode("#FACD97"));
        deleteOrderLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 40));
        deleteOrderLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        //add this if naa nay image
//        ImageIcon icon = new ImageIcon("path/to/your/image.png"); // Replace with the path to your image
//        addOrderLabel.setIcon(icon);
//        addOrderLabel.setHorizontalTextPosition(SwingConstants.RIGHT); // Text on the right, image on the left

        deleteOrderLabel.setHorizontalAlignment(SwingConstants.RIGHT); //align text to the right
        frame.add(deleteOrderLabel);

        // order ID label
        JLabel orderIdLabel = new JLabel();
        orderIdLabel.setText("Enter the ID of the order you would like to delete: ");
        orderIdLabel.setBounds(480, 190, 600, 45);
        orderIdLabel.setForeground(Color.decode("#331402"));
        orderIdLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(orderIdLabel);

        // order ID text field
        JTextField orderIdTf = new JTextField("");
        orderIdTf.setBounds(460, 230, 500, 45);
        orderIdTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        orderIdTf.setBackground(Color.white);
        frame.add(orderIdTf);

        // delete order button
        JButton deleteOrderButton = new JButton();
        deleteOrderButton.setText("CONFIRM");
        deleteOrderButton.setBounds(580, 370, 250, 40);
        deleteOrderButton.setBackground(Color.decode("#551F01"));
        deleteOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
        deleteOrderButton.setForeground(Color.white);
        deleteOrderButton.setFocusable(false);
        deleteOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderId = orderIdTf.getText();

                if (ordersDatabase.deleteOrder(Integer.parseInt(orderId))) {
                    JOptionPane.showMessageDialog(frame, "Order deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Order ID not found.");
                }

                orderIdTf.setText("");
            }
        });
        frame.add(deleteOrderButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}


