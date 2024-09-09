package Levels;

import Environment.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Bg direct hit.
 */
public class BGDirectHit implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // Draw a subtle gradient-like background using alternating rectangles
        for (int i = 0; i < 580; i += 20) {
            if (i % 40 == 0) {
                d.setColor(new Color(30, 30, 30));
            } else {
                d.setColor(new Color(45, 45, 45));
            }
            d.fillRectangle(20, 20 + i, 760, 20);
        }

        d.setColor(Color.BLACK);
        d.drawText(700, 19, "Direct Hit", 20);

        // Lower the glowing circles
        d.setColor(new Color(0, 100, 255));
        d.drawCircle(400, 160, 40);
        d.setColor(new Color(0, 150, 255));
        d.drawCircle(400, 160, 50);
        d.setColor(new Color(0, 200, 255));
        d.drawCircle(400, 160, 60);

        // Lower the glowing lines
        d.setColor(new Color(0, 150, 255));
        d.drawLine(400, 70, 400, 290);
        d.drawLine(300, 160, 520, 160);

        d.setColor(Color.RED); // Original rectangle color
        d.fillRectangle(395, 150, 10, 10);
    }

    @Override
    public void timePassed() {
    }
}
