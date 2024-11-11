package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoundedButton extends JButton {
    private int round = 25;  // Corner roundness
    private Color hoverBackgroundColor = Color.decode("#AE8670");  // Color on hover
    private Color normalBackgroundColor = Color.decode("#551F01");  // Default button color

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);  // Make sure button's background is transparent
        setBorderPainted(false);  // Remove default border
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(normalBackgroundColor);

        // Mouse listener for hover effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackgroundColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalBackgroundColor);
            }
        });

        // Ensure the button is focusable and responds to focus events
        setFocusable(true);
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Create a Graphics2D object to allow advanced rendering
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the button with rounded corners
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);

        // Paint the text
        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        repaint();
    }
}
