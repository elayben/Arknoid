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
        d.setColor(Color.BLACK);
        d.drawRectangle(20, 20, 760, 580);
        d.fillRectangle(20, 20, 760, 580);
        d.drawText(700, 19, "Direct Hit", 17);
        d.setColor(Color.blue);
        d.drawCircle(400, 110, 40);
        d.drawCircle(400, 110, 50);
        d.drawCircle(400, 110, 60);
        d.drawLine(400, 20, 400, 240);
        d.drawLine(300, 110, 520, 110);
        d.setColor(Color.red);
        d.drawRectangle(395, 100, 10, 10);
        d.fillRectangle(395, 100, 10, 10);
    }

    @Override
    public void timePassed() {

    }
}
