package Levels;

import Environment.LevelInformation;
import Environment.Sprite;
import GeometryPrimitives.Point;
import GeometryPrimitives.Rectangle;
import Movement.Velocity;
import Objects.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Wide easy.
 */
public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        /*Random rand = new Random();*/
        List<Velocity> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(220 + i * 10/*rand.nextInt(330 - 210 + 1) + 210*/, 5);
            l.add(v);
        }
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 4;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return " Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new BGWideEasy();
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        Rectangle rec = new Rectangle(new Point(20 + 50.6 * 0, 250), 50.6, 20);
        Block b = new Block(rec, Color.red);
        l.add(b);
        rec = new Rectangle(new Point(20 + 50.6 * 1, 250), 50.6, 20);
        b = new Block(rec, Color.red);
        l.add(b);

        rec = new Rectangle(new Point(20 + 50.6 * 2, 250), 50.6, 20);
        b = new Block(rec, Color.orange);
        l.add(b);
        rec = new Rectangle(new Point(20 + 50.6 * 3, 250), 50.6, 20);
        b = new Block(rec, Color.orange);
        l.add(b);

        rec = new Rectangle(new Point(20 + 50.6 * 4, 250), 50.6, 20);
        b = new Block(rec, Color.yellow);
        l.add(b);
        rec = new Rectangle(new Point(20 + 50.6 * 5, 250), 50.6, 20);
        b = new Block(rec, Color.yellow);
        l.add(b);

        rec = new Rectangle(new Point(20 + 50.6 * 6, 250), 50.6, 20);
        b = new Block(rec, Color.green);
        l.add(b);
        rec = new Rectangle(new Point(20 + 50.6 * 7, 250), 50.6, 20);
        b = new Block(rec, Color.green);
        l.add(b);
        rec = new Rectangle(new Point(20 + 50.6 * 8, 250), 50.6, 20);
        b = new Block(rec, Color.green);
        l.add(b);

        rec = new Rectangle(new Point(20 + 50.6 * 9, 250), 50.6, 20);
        b = new Block(rec, Color.blue);
        l.add(b);
        rec = new Rectangle(new Point(20 + 50.6 * 10, 250), 50.6, 20);
        b = new Block(rec, Color.blue);
        l.add(b);

        rec = new Rectangle(new Point(20 + 50.6 * 11, 250), 50.6, 20);
        b = new Block(rec, Color.pink);
        l.add(b);
        rec = new Rectangle(new Point(20 + 50.6 * 12, 250), 50.6, 20);
        b = new Block(rec, Color.pink);
        l.add(b);

        rec = new Rectangle(new Point(20 + 50.6 * 13, 250), 50.6, 20);
        b = new Block(rec, Color.magenta);
        l.add(b);
        rec = new Rectangle(new Point(20 + 50.6 * 14, 250), 50.6, 20);
        b = new Block(rec, Color.magenta);
        l.add(b);


        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
