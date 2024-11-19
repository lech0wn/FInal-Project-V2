package org.example;

import org.example.Databases.ordersDatabase;
import org.example.Extensions.SearchBar;
import org.example.SidePanels.OrderSidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrdersPage {

    public OrdersPage(JFrame frame) {

        frame.setTitle("Orders");  //set the title of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        //side panel call
        new OrderSidePanel(frame);
        new SearchBar(frame);

        // Refresh frame components
        frame.revalidate();
        frame.repaint();

        JLabel orderIdOrdersLabel = new JLabel("Order ID");
        orderIdOrdersLabel.setBounds(330, 80, 90, 40);
        orderIdOrdersLabel.setOpaque(true);
        orderIdOrdersLabel.setBackground(Color.decode("#752A00"));
        orderIdOrdersLabel.setForeground(Color.decode("#EF9B39"));
        orderIdOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 14));
        orderIdOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        orderIdOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(orderIdOrdersLabel);

        JLabel dateOrdersLabel = new JLabel("Date");
        dateOrdersLabel.setBounds(430, 80, 140, 40);
        dateOrdersLabel.setOpaque(true);
        dateOrdersLabel.setBackground(Color.decode("#752A00"));
        dateOrdersLabel.setForeground(Color.decode("#EF9B39"));
        dateOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 14));
        dateOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        dateOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(dateOrdersLabel);

        JLabel mealOrdersLabel = new JLabel("Meal");
        mealOrdersLabel.setBounds(580, 80, 160, 40);
        mealOrdersLabel.setOpaque(true);
        mealOrdersLabel.setBackground(Color.decode("#752A00"));
        mealOrdersLabel.setForeground(Color.decode("#EF9B39"));
        mealOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 14));
        mealOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        mealOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(mealOrdersLabel);

        JLabel quantityOrdersLabel = new JLabel("Quantity");
        quantityOrdersLabel.setBounds(750, 80, 90, 40);
        quantityOrdersLabel.setOpaque(true);
        quantityOrdersLabel.setBackground(Color.decode("#752A00"));
        quantityOrdersLabel.setForeground(Color.decode("#EF9B39"));
        quantityOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 14));
        quantityOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        quantityOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(quantityOrdersLabel);

        JLabel priceOrdersLabel = new JLabel("Total Price");
        priceOrdersLabel.setBounds(850, 80, 110, 40);
        priceOrdersLabel.setOpaque(true);
        priceOrdersLabel.setBackground(Color.decode("#752A00"));
        priceOrdersLabel.setForeground(Color.decode("#EF9B39"));
        priceOrdersLabel.setFont(new Font("Milonga", Font.BOLD, 14));
        priceOrdersLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        priceOrdersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(priceOrdersLabel);

        JLabel statusLabel = new JLabel("Status");
        statusLabel.setBounds(970, 80, 110, 40);
        statusLabel.setOpaque(true);
        statusLabel.setBackground(Color.decode("#752A00"));
        statusLabel.setForeground(Color.decode("#EF9B39"));
        statusLabel.setFont(new Font("Milonga", Font.BOLD, 14));
        statusLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(statusLabel);

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

        JPanel statusPanelContainer = new JPanel();
        statusPanelContainer.setLayout(new BoxLayout(statusPanelContainer, BoxLayout.Y_AXIS));

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

            //add to container
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

        // Parent panel for all column containers
        JPanel ordersPanel = new JPanel();
        ordersPanel.setLayout(null); // Use absolute layout for precise positioning
        ordersPanel.setBackground(Color.decode("#EF9B39"));
        ordersPanel.setPreferredSize(new Dimension(1150, orders.size() * 55)); // Adjust dimensions for scrolling

        // Add the column panels to the parent panel
        orderIdPanelContainer.setBounds(0, 0, 110, orders.size() * 55);
        datePanelContainer.setBounds(120, 0, 160, orders.size() * 55);
        mealPanelContainer.setBounds(290, 0, 170, orders.size() * 55);
        quantityPanelContainer.setBounds(470, 0, 110, orders.size() * 55);
        pricePanelContainer.setBounds(590, 0, 130, orders.size() * 55);

        ordersPanel.add(orderIdPanelContainer);
        ordersPanel.add(datePanelContainer);
        ordersPanel.add(mealPanelContainer);
        ordersPanel.add(quantityPanelContainer);
        ordersPanel.add(pricePanelContainer);

        // Wrap the parent panel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(ordersPanel);
        scrollPane.setBounds(350, 140, 735, 400); // Position and size of the scrollable area
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBackground(Color.decode("#EF9B39"));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the scroll pane to the frame
        frame.add(scrollPane);
    }
}


