package Levels;

import Environment.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Bg green 3.
 */
public class BGGreen3 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // Draw a gradient green background
        for (int i = 0; i < 580; i += 20) {
            if (i % 40 == 0) {
                d.setColor(new Color(30, 180, 30));  // Darker green
            } else {
                d.setColor(new Color(50, 200, 50));  // Lighter green
            }
            d.fillRectangle(20, 20 + i, 760, 20);
        }

        // Draw the title text with a background for contrast
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(680, 0, 120, 30);
        d.setColor(Color.WHITE);
        d.drawText(700, 19, "Green 3", 20);

        // Draw a tower-like structure with circles and rectangles
        // Enhancing the tower and giving it more detail
        d.setColor(Color.PINK);
        d.fillCircle(90, 200, 20);  // Larger circle for a more prominent look

        d.setColor(Color.RED);
        d.fillCircle(90, 200, 15);  // Middle red circle

        d.setColor(Color.WHITE);
        d.fillCircle(90, 200, 10);  // Small inner white circle

        // Tower body (gray rectangle)
        d.setColor(Color.GRAY);
        d.fillRectangle(85, 215, 10, 235);

        // Tower base (dark gray rectangle)
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(70, 450, 40, 50);

        // Large building base (black rectangle)
        d.setColor(Color.BLACK);
        d.fillRectangle(50, 500, 78, 100);

        // Adding windows to the building for more detail
        d.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(55 + i * 15, 505 + j * 19, 8, 16);
            }
        }

        // Adding subtle details to the windows for depth
        d.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.drawRectangle(55 + i * 15, 505 + j * 19, 8, 16);
            }
        }
    }

    @Override
    public void timePassed() {
        // No dynamic changes required.
    }
}
