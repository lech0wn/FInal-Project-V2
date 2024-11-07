package org.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {
    private final Color borderColor;
    private int radius;

    public RoundedBorder(int radius, Color borderColor) {
        this.radius = radius;
        this.borderColor = borderColor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the border color
        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(5)); // Line thickness for the border

        // Draw rounded rectangle border (off by 1 so it fits well within button bounds)
        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        // Insets should be large enough to avoid text clipping
        return new Insets(this.radius + 4, this.radius + 4, this.radius + 4, this.radius + 4);
    }
}