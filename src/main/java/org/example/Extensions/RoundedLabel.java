package org.example.Extensions;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedLabel extends JLabel {
    private int round = 25;  // Corner radius for rounding
    private int borderThickness = 2;  // Default border thickness
    private Color borderColor = Color.BLACK;  // Default border color
    private ImageIcon imageIcon;  // Store the image icon

    // Default constructor
    public RoundedLabel() {
        setOpaque(false);  // Make the label transparent so the custom background and border can be painted
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));  // Set padding
    }

    // Constructor with border thickness and color
    public RoundedLabel(int borderThickness, Color borderColor) {
        this();  // Call the default constructor to initialize common properties
        setBorderThickness(borderThickness);
        setBorderColor(borderColor);
    }

    // Set the image for the label
    public void setImage(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        repaint();  // Trigger repaint to render the image
    }

    // Getters and setters for border thickness and color
    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    // Getters and setters for corner rounding
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (imageIcon == null) {
            System.out.println("No image set!");  // Debugging message
            return;  // If no image is set, skip painting
        }

        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Get the label dimensions
        double width = getWidth();
        double height = getHeight();

        System.out.println("Label Dimensions: " + width + "x" + height);  // Debugging message

        // Get the image and scale it to fit the label dimensions
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance((int) (width - 2 * borderThickness), (int) (height - 2 * borderThickness), Image.SCALE_SMOOTH);

        // Draw the image inside the rounded rectangle
        g2.setClip(new RoundRectangle2D.Double(borderThickness, borderThickness, width - 2 * borderThickness, height - 2 * borderThickness, round, round));
        g2.drawImage(scaledImage, borderThickness, borderThickness, this);

        // Ensure that the border is drawn with the desired thickness and color
        if (borderThickness > 0) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderThickness));
            g2.drawRoundRect(0, 0, (int) width - borderThickness, (int) height - borderThickness, round, round);
        }

        g2.dispose();
        super.paintComponent(grphcs);
    }
}
