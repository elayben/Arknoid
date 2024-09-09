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
import java.util.Random;

/**
 * The type Direct hit.
 */
public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Random rand = new Random();
        List<Velocity> l = new ArrayList<>();
        Velocity v1 = Velocity.fromAngleAndSpeed(270/*-rand.nextInt(180 + 20) + 20*/, 5);
        l.add(v1);
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 300;
    }

    @Override
    public String levelName() {
        return " Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new BGDirectHit();
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        Rectangle rec1 = new Rectangle(new Point(380, 90), 40, 40);
        Block b1 = new Block(rec1, Color.RED);
        l.add(b1);
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
