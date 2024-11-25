package org.example;

import org.example.Databases.ordersDatabase;
import org.example.Extensions.RoundedTextfield;
import org.example.Extensions.SearchBar;
import org.example.SidePanels.OrderSidePanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrdersPage {

    private JComboBox<String> filterDropdown; // Class-level variable to store the JComboBox reference

    public OrdersPage(JFrame frame) {
        frame.setTitle("Orders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        new OrderSidePanel(frame);

        frame.revalidate();
        frame.repaint();

        // Header labels
        String[] headers = {"Order ID", "Date", "Meal", "Quantity", "Total Price", "Status"};
        int[] columnWidths = {90, 140, 160, 90, 110, 110};
        int xOffset = 330;

        for (int i = 0; i < headers.length; i++) {
            JLabel headerLabel = createHeaderLabel(headers[i]);
            headerLabel.setBounds(xOffset, 80, columnWidths[i], 40);
            frame.add(headerLabel);
            xOffset += columnWidths[i] + 10;
        }

        // Container panel for all rows
        JPanel ordersPanel = new JPanel();
        ordersPanel.setLayout(null); // Absolute layout for precise positioning
        ordersPanel.setBackground(Color.decode("#EF9B39"));

        // Add order search bar
        addOrderSearchBar(frame, ordersPanel, columnWidths, 50);

        // Add filter dropdown
        addFilterDropdown(frame, ordersPanel, columnWidths, 50);

        // Add scroll pane
        JScrollPane scrollPane = new JScrollPane(ordersPanel);
        scrollPane.setBounds(330, 140, 800, 400);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);
    }

    private void addOrderSearchBar(JFrame frame, JPanel ordersPanel, int[] columnWidths, int rowHeight) {
        JLabel errorLabel = new JLabel("Order not found");
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(new Font("Arial", Font.BOLD, 12));
        errorLabel.setBounds(370, 60, 200, 20);
        errorLabel.setVisible(false);
        frame.add(errorLabel);

        RoundedTextfield searchbar = new RoundedTextfield();
        searchbar.setBounds(370, 20, 550, 45);
        searchbar.setBackground(Color.decode("#FACD97"));
        searchbar.setForeground(Color.black);
        searchbar.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(searchbar);

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/Search.png");
        JButton searchButton = new JButton(img);
        searchButton.setBorder(BorderFactory.createEmptyBorder());
        searchButton.setFocusable(false);
        searchButton.setBackground(Color.decode("#FACD97"));
        searchButton.setBounds(500, 2, 30, 40);

        searchButton.addActionListener(e -> {
            String searchName = searchbar.getText().trim();
            List<String[]> filteredOrders = ordersDatabase.getOrderByMealName(searchName);

            if (!filteredOrders.isEmpty()) {
                refreshOrderData(ordersPanel, filteredOrders, columnWidths, rowHeight);
                errorLabel.setVisible(false);
            } else {
                errorLabel.setVisible(true);
            }
        });

        searchbar.add(searchButton);
    }

    private void addFilterDropdown(JFrame frame, JPanel ordersPanel, int[] columnWidths, int rowHeight) {
        String[] filterOptions = {"All", "Completed", "Deleted"};
        filterDropdown = new JComboBox<>(filterOptions); // Store the reference
        filterDropdown.setBounds(950, 40, 120, 30);
        filterDropdown.setBackground(Color.decode("#331402"));
        filterDropdown.setForeground(Color.decode("#FACD97"));
        filterDropdown.setFocusable(false);
        filterDropdown.setBorder(BorderFactory.createEmptyBorder());
        filterDropdown.setFont(new Font("Milonga", Font.BOLD, 12));

        filterDropdown.addActionListener(e -> {
            String selectedFilter = (String) filterDropdown.getSelectedItem();
            List<String[]> filteredOrders;
            if ("Completed".equals(selectedFilter)) {
                filteredOrders = ordersDatabase.listCompletedOrders();
            } else if ("Deleted".equals(selectedFilter)) {
                filteredOrders = ordersDatabase.listDeletedOrders();
            } else {
                filteredOrders = ordersDatabase.listOrders();
            }
            refreshOrderData(ordersPanel, filteredOrders, columnWidths, rowHeight);
        });

        frame.add(filterDropdown);
    }

    private void refreshOrderData(JPanel ordersPanel, List<String[]> orders, int[] columnWidths, int rowHeight) {
        ordersPanel.removeAll();
        int yPosition = 0;

        for (String[] order : orders) {
            int xPosition = 0;

            for (int i = 0; i < order.length; i++) {
                JPanel cellPanel = createCellPanel(i == 5 ? null : order[i]);
                if (i == 5) {
                    cellPanel.add(createStatusDropdown(order), BorderLayout.CENTER);
                }
                cellPanel.setBounds(xPosition, yPosition, columnWidths[i], rowHeight);
                ordersPanel.add(cellPanel);
                xPosition += columnWidths[i] + 10;
            }
            yPosition += rowHeight;
        }

        ordersPanel.setPreferredSize(new Dimension(ordersPanel.getWidth(), yPosition));
        ordersPanel.revalidate();
        ordersPanel.repaint();
    }

    private JLabel createHeaderLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.decode("#752A00"));
        label.setForeground(Color.decode("#EF9B39"));
        label.setFont(new Font("Milonga", Font.BOLD, 14));
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        return label;
    }

    private JPanel createCellPanel(String text) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
        panel.setBackground(Color.decode("#752A00"));

        if (text != null) {
            JLabel label = new JLabel(text, SwingConstants.CENTER);
            label.setFont(new Font("Milonga", Font.PLAIN, 14));
            label.setForeground(Color.decode("#EF9B39"));
            panel.add(label, BorderLayout.CENTER);
        }
        return panel;
    }

    private JComboBox<String> createStatusDropdown(String[] order) {
        String[] statuses = {"Pending", "Completed"};
        JComboBox<String> comboBox = new JComboBox<>(statuses);
        comboBox.setBackground(Color.decode("#752A00"));
        comboBox.setFocusable(false);
        comboBox.setBorder(BorderFactory.createEmptyBorder());
        comboBox.setSelectedItem(order[5]);

        // Set initial text color
        comboBox.setForeground(order[5].equals("Pending") ? Color.RED : Color.GREEN);

        comboBox.addActionListener(e -> {
            String selectedStatus = (String) comboBox.getSelectedItem();
            int orderId = Integer.parseInt(order[0]);

            // Update text color based on the selected status
            if ("Pending".equals(selectedStatus)) {
                comboBox.setForeground(Color.RED);
            } else if ("Completed".equals(selectedStatus)) {
                comboBox.setForeground(Color.GREEN);
            }

            // Update the database
            ordersDatabase.updateOrderStatus(orderId, selectedStatus);
        });

        return comboBox;
    }
}