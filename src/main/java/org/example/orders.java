import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(2899, 1526);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(6, 70, 2907, 1456);
        panel.setBackground(new Color(0xFFEF9B39));
        panel.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 30));
        frame.add(panel);

        JPanel panel2 = new JPanel();
        panel2.setBounds(877, 230, 193, 1205);
        panel2.setBackground(new Color(0xFF752A00));
        panel2.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBounds(724, 301, 330, 121);
        panel3.setBackground(new Color(0xFF752A00));
        panel3.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setBounds(722, 469, 332, 987);
        panel4.setBackground(new Color(0xFF752A00));
        panel4.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setBounds(1583, 230, 194, 1205);
        panel5.setBackground(new Color(0xFF752A00));
        panel5.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel5);

        JPanel panel6 = new JPanel();
        panel6.setBounds(1431, 301, 329, 121);
        panel6.setBackground(new Color(0xFF752A00));
        panel6.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel6);

        JPanel panel7 = new JPanel();
        panel7.setBounds(1429, 469, 331, 987);
        panel7.setBackground(new Color(0xFF752A00));
        panel7.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel7);

        JPanel panel8 = new JPanel();
        panel8.setBounds(2292, 259, 194, 1205);
        panel8.setBackground(new Color(0xFF752A00));
        panel8.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel8);

        JPanel panel9 = new JPanel();
        panel9.setBounds(2140, 301, 329, 121);
        panel9.setBackground(new Color(0xFF752A00));
        panel9.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel9);

        JPanel panel10 = new JPanel();
        panel10.setBounds(2138, 469, 331, 987);
        panel10.setBackground(new Color(0xFF752A00));
        panel10.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel10);

        JPanel panel11 = new JPanel();
        panel11.setBounds(2648, 270, 194, 1205);
        panel11.setBackground(new Color(0xFF752A00));
        panel11.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel11);

        JPanel panel12 = new JPanel();
        panel12.setBounds(2494, 301, 329, 121);
        panel12.setBackground(new Color(0xFF752A00));
        panel12.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel12);

        JPanel panel13 = new JPanel();
        panel13.setBounds(2497, 466, 331, 987);
        panel13.setBackground(new Color(0xFF752A00));
        panel13.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel13);

        JPanel panel14 = new JPanel();
        panel14.setBounds(1937, 230, 195, 1205);
        panel14.setBackground(new Color(0xFF752A00));
        panel14.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel14);

        JPanel panel15 = new JPanel();
        panel15.setBounds(1785, 301, 329, 121);
        panel15.setBackground(new Color(0xFF752A00));
        panel15.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel15);

        JPanel panel16 = new JPanel();
        panel16.setBounds(1784, 469, 330, 987);
        panel16.setBackground(new Color(0xFF752A00));
        panel16.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel16);

        JPanel panel17 = new JPanel();
        panel17.setBounds(1231, 230, 192, 1205);
        panel17.setBackground(new Color(0xFF752A00));
        panel17.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel17);

        JPanel panel18 = new JPanel();
        panel18.setBounds(1078, 301, 329, 121);
        panel18.setBackground(new Color(0xFF752A00));
        panel18.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel18);

        JPanel panel19 = new JPanel();
        panel19.setBounds(1076, 469, 331, 987);
        panel19.setBackground(new Color(0xFF752A00));
        panel19.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel19);

        JPanel panel20 = new JPanel();
        panel20.setBounds(0, 70, 643, 1456);
        panel20.setBackground(new Color(0xFF752A00));
        panel20.setBorder(BorderFactory.createLineBorder(new Color(0xFF752A00), 30));
        frame.add(panel20);

        JPanel panel21 = new JPanel();
        panel21.setBounds(95, 0, 465, 677);
        panel21.setBackground(new Color(0xFF752A00));
        panel21.setBorder(BorderFactory.createLineBorder(new Color(0xFF752A00), 178));
        frame.add(panel21);

        JLabel label1 = new JLabel("WELCOME!");
        label1.setBounds(142, 601, 571, 91);
        label1.setForeground(new Color(0xFFEF9B39));
        label1.setFont(new Font("SeoulNamsan CEB", Font.PLAIN, 96));
        frame.add(label1);

        JPanel panel22 = new JPanel();
        panel22.setBounds(71, 960, 519, 66);
        panel22.setBackground(new Color(0xFFFACD97));
        panel22.setBorder(BorderFactory.createLineBorder(new Color(0xFFFACD97), 40));
        frame.add(panel22);

        JPanel panel23 = new JPanel();
        panel23.setBounds(133, 969, 63, 49);
        panel23.setBackground(new Color(0xFFFACD97));
        panel23.setBorder(BorderFactory.createLineBorder(new Color(0xFFFACD97), 40));
        frame.add(panel23);

        JLabel label2 = new JLabel("Orders");
        label2.setBounds(202, 969, 201, 41);
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Milonga", Font.PLAIN, 48));
        frame.add(label2);

        JPanel panel24 = new JPanel();
        panel24.setBounds(71, 852, 519, 66);
        panel24.setBackground(new Color(0xFFEF9B39));
        panel24.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 40));
        frame.add(panel24);

        JPanel panel25 = new JPanel();
        panel25.setBounds(52, 857, 77, 59);
        panel25.setBackground(new Color(0xFFEF9B39));
        panel25.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 40));
        frame.add(panel25);

        JLabel label3 = new JLabel("Inventory");
        label3.setBounds(121, 857, 347, 48);
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("Milonga", Font.PLAIN, 48));
        frame.add(label3);

        JPanel panel26 = new JPanel();
        panel26.setBounds(71, 743, 519, 67);
        panel26.setBackground(new Color(0xFFEF9B39));
        panel26.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 40));
        frame.add(panel26);

        JLabel label4 = new JLabel("Menu");
        label4.setBounds(125, 750, 263, 52);
        label4.setForeground(Color.BLACK);
        label4.setFont(new Font("Milonga", Font.PLAIN, 48));
        frame.add(label4);

        JPanel panel27 = new JPanel();
        panel27.setBounds(58, 751, 64, 58);
        panel27.setBackground(new Color(0xFFEF9B39));
        panel27.setBorder(BorderFactory.createLineBorder(new Color(0xFFEF9B39), 40));
        frame.add(panel27);

        JPanel panel28 = new JPanel();
        panel28.setBounds(261, 1314, 132, 122);
        panel28.setBackground(new Color(0xFF331301));
        panel28.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 40));
        frame.add(panel28);

        JPanel panel29 = new JPanel();
        panel29.setBounds(15, 1330, 103, 94);
        panel29.setBackground(new Color(0xFF331301));
        panel29.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 40));
        frame.add(panel29);

        JPanel panel30 = new JPanel();
        panel30.setBounds(713, 126, 1795, 133);
        panel30.setBackground(new Color(0xFFFACD97));
        panel30.setBorder(BorderFactory.createLineBorder(new Color(0xFF331301), 6));
        frame.add(panel30);

        JPanel panel31 = new JPanel();
        panel31.setBounds(774, 155, 81, 75);
        panel31.setBackground(new Color(0xFFFACD97));
        panel31.setBorder(BorderFactory.createLineBorder(new Color(0xFFFACD97), 40));
        frame.add(panel31);

        JPanel panel32 = new JPanel();
        panel32.setBounds(1071, 250, 255, 1193);
        panel32.setBackground(new Color(0xFF752A00));
        panel32.setBorder(BorderFactory.createLineBorder(new Color(0xFF551F01), 10));
        frame.add(panel32);

        JLabel label5 = new JLabel("Order ID");
        label5.setBounds(1109, 325, 279, 63);
        label5.setForeground(new Color(0xFFEF9B39));
        label5.setFont(new Font("Milonga", Font.PLAIN, 64));
        frame.add(label5);

        JLabel label6 = new JLabel("Date");
        label6.setBounds(814, 321, 186, 40);
        label6.setForeground(new Color(0xFFEF9B39));
        label6.setFont(new Font("Milonga", Font.PLAIN, 64));
        frame.add(label6);

        JLabel label7 = new JLabel("Meal");
        label7.setBounds(1523, 321, 186, 40);
        label7.setForeground(new Color(0xFFEF9B39));
        label7.setFont(new Font("Milonga", Font.PLAIN, 64));
        frame.add(label7);

        JLabel label8 = new JLabel("Status");
        label8.setBounds(2572, 325, 327, 63);
        label8.setForeground(new Color(0xFFEF9B39));
        label8.setFont(new Font("Milonga", Font.PLAIN, 60));
        frame.add(label8);

        JLabel label9 = new JLabel("Total Price");
        label9.setBounds(2159, 325, 327, 63);
        label9.setForeground(new Color(0xFFEF9B39));
        label9.setFont(new Font("Milonga", Font.PLAIN, 60));
        frame.add(label9);

        JLabel label10 = new JLabel("Quantity");
        label10.setBounds(1835, 321, 327, 63);
        label10.setForeground(new Color(0xFFEF9B39));
        label10.setFont(new Font("Milonga", Font.PLAIN, 60));
        frame.add(label10);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

