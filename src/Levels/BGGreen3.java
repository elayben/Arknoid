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
        d.setColor(Color.GREEN);
        d.drawRectangle(20, 20, 760, 580);
        d.fillRectangle(20, 20, 760, 580);
        d.setColor(Color.BLACK);
        d.drawText(700, 19, "Green 3", 17);
        d.setColor(Color.pink);
        d.drawCircle(90, 200, 15);
        d.fillCircle(90, 200, 15);
        d.setColor(Color.red);
        d.drawCircle(90, 200, 10);
        d.fillCircle(90, 200, 10);
        d.setColor(Color.white);
        d.drawCircle(90, 200, 5);
        d.fillCircle(90, 200, 5);
        d.setColor(Color.gray);
        d.drawRectangle(85, 215, 10, 235);
        d.fillRectangle(85, 215, 10, 235);
        d.setColor(Color.darkGray);
        d.drawRectangle(70, 450, 40, 50);
        d.fillRectangle(70, 450, 40, 50);
        d.setColor(Color.black);
        d.drawRectangle(50, 500, 78, 100);
        d.fillRectangle(50, 500, 78, 100);
        d.setColor(Color.white);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.drawRectangle(55 + i * 15, 505 + j * 19, 8, 16);
                d.fillRectangle(55 + i * 15, 505 + j * 19, 8, 16);
            }
        }

    }

    @Override
    public void timePassed() {

    }
}
