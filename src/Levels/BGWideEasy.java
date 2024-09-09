package Levels;

import Environment.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Bg wide easy.
 */
public class BGWideEasy implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // Draw the sky background
        d.setColor(new Color(135, 206, 250));  // Light sky blue
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        // Draw the sun in the top-left corner
        d.setColor(Color.YELLOW);
        d.fillCircle(100, 100, 60);
        d.setColor(new Color(255, 223, 0));
        d.fillCircle(100, 100, 50);
        d.setColor(new Color(255, 200, 0));
        d.fillCircle(100, 100, 40);

        // Draw sun rays extending outward from the sun
        d.setColor(new Color(255, 255, 100));
        for (int i = 0; i < 100; i += 8) {
            d.drawLine(100, 100, i * 10, 300);
        }

        // Draw clouds to add visual elements
        drawCloud(d, 500, 150);
        drawCloud(d, 650, 100);
        drawCloud(d, 300, 90);

        // Title text for the level
        d.setColor(Color.BLACK);
        d.drawText(700, 19, "Wide Easy", 18);
    }

    // Helper method to draw clouds
    private void drawCloud(DrawSurface d, int x, int y) {
        d.setColor(Color.WHITE);
        d.fillCircle(x, y, 20);
        d.fillCircle(x + 30, y + 10, 25);
        d.fillCircle(x + 60, y, 20);
        d.fillCircle(x + 30, y - 10, 25);
    }

    @Override
    public void timePassed() {
        // No dynamic changes needed.
    }
}
