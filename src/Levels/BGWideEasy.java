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
        d.setColor(Color.BLACK);
        d.drawText(700, 19, "Wide Easy", 17);
        d.setColor(Color.yellow);
        d.drawCircle(100, 100, 20);
        d.fillCircle(100, 100, 20);
        d.setColor(Color.orange);
        d.drawCircle(100, 100, 16);
        d.fillCircle(100, 100, 16);
        d.setColor(Color.red);
        d.drawCircle(100, 100, 12);
        d.fillCircle(100, 100, 12);
        d.setColor(Color.yellow);
        for (int i = 0; i < 100; i++) {
            d.drawLine(100, 100, i * 7, 250);
        }
    }

    @Override
    public void timePassed() {

    }
}
