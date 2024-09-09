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
 * The type Direct hit.
 */
public class DirectHit implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;  // Single ball in this level
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        // List to store the ball's initial velocity
        List<Velocity> velocities = new ArrayList<>();

        // Ball shoots straight up (angle 270 degrees) with speed 5
        Velocity velocity = Velocity.fromAngleAndSpeed(270, 5);
        velocities.add(velocity);

        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 10;  // Fast paddle movement
    }

    @Override
    public int paddleWidth() {
        return 300;  // Wide paddle
    }

    @Override
    public String levelName() {
        return "Direct Hit";  // Level name
    }

    @Override
    public Sprite getBackground() {
        // Background associated with this level
        return new BGDirectHit();
    }

    @Override
    public List<Block> blocks() {
        // List to store the block
        List<Block> blocks = new ArrayList<>();

        // Single red block at the center (point 380, 90) with width 40 and height 40
        Rectangle blockRectangle = new Rectangle(new Point(380, 140), 40, 40);
        Block block = new Block(blockRectangle, Color.RED);
        blocks.add(block);

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        // Number of blocks to remove, which is the size of the block list
        return blocks().size();
    }
}
