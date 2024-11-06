//package org.example;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class inventory {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("FigmaToCodeApp");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(3200, 1600);
//            frame.setLayout(new BorderLayout());
//
//            Inventory inventory = new Inventory();
//            frame.add(inventory, BorderLayout.CENTER);
//
//            frame.setVisible(true);
//        });
//    }
//}
//
//class Inventory extends JPanel {
//    public Inventory() {
//        setLayout(null);
//
//        JPanel container1 = new JPanel();
//        container1.setBounds(141, 70, 2907, 1456);
//        container1.setBackground(new Color(0xFFEF9B39));
//        container1.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 30));
//        add(container1);
//
//        JPanel container2 = new JPanel();
//        container2.setBounds(144, 70, 643, 1456);
//        container2.setBackground(new Color(0xFF752A00));
//        container2.setBorder(BorderFactory.createLineBorder(new Color(0xFF752A00), 30));
//        add(container2);
//
//        JPanel container3 = new JPanel();
//        container3.setBounds(206, 960, 519, 66);
//        container3.setBackground(new Color(0xFFEF9B39));
//        container3.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 40));
//        add(container3);
//
//        JLabel imageLabel = new JLabel(new ImageIcon("https://via.placeholder.com/63x49"));
//        imageLabel.setBounds(268, 969, 63, 49);
//        add(imageLabel);
//
//        JLabel textLabel = new JLabel("Orders");
//        textLabel.setBounds(337, 969, 201, 41);
//        textLabel.setFont(new Font("Milonga", Font.PLAIN, 48));
//        textLabel.setForeground(Color.BLACK);
//        add(textLabel);
//    }
//}
